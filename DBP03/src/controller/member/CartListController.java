package controller.member;

import java.beans.Statement;
import java.io.IOException;
import java.io.Serializable;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.corba.se.pept.transport.Connection;

import controller.Controller;
import service.ProductManager;
import service.dto.cartDTO;
import service.dto.cartListDTO;
import service.dto.productDTO;

public class CartListController implements Controller, Serializable {
	private static final Logger log = LoggerFactory.getLogger(CartListController.class);
	private static final long serialVersionUID = 1L;
	
	public CartListController() {
		// TODO Auto-generated constructor stub
	}

	public void onlyGet (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
	
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		cartDTO cart = (cartDTO) session.getAttribute("CART");
		
		if (cart != null) {
			cartListDTO cartList = new cartListDTO();
			
			ProductManager manager = ProductManager.getInstance();
					
			int productNum = cart.getSize();
			for (int cnt = 0; cnt < productNum; cnt++) {
				int id = Integer.parseInt(cart.getCode(cnt));
				int num = cart.getNumber(cnt);
				
				List<productDTO> plist = manager.getProductByp_Id(id);
				
				String name = plist.get(0).getP_name();
				int price = plist.get(0).getP_price();
				String img = plist.get(0).getImgsrc();
				
				
				cartList.setCode(cnt, id);
				cartList.setTitle(cnt, name);
				cartList.setPrice(cnt, price);
				cartList.setNumber(cnt, num);
				cartList.setImg(cnt, img);
			}
			
			request.setAttribute("CART_LIST",  cartList);
		}
		else {
			request.setAttribute("CART_LIST",  null);
		}
		
		return "/cart/cart";
	}
	
}
