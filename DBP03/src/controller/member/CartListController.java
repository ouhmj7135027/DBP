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
import service.CartManager;
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
		
		CartManager cmanager = CartManager.getInstance();
		List<cartDTO> clist = cmanager.getCartByMid(Integer.parseInt(String.valueOf(session.getAttribute("m_id"))));
		List<cartDTO> tlist = cmanager.getTotalAmount(Integer.parseInt(String.valueOf(session.getAttribute("m_id"))));
			
		if (clist.size() >= 1) {
			request.setAttribute("cartlist", clist);
			request.setAttribute("totalList", tlist.get(0).getTotalAmount());
		}
		else {
			request.setAttribute("cartlist", null);
			request.setAttribute("totalList", null);
		}
		
		return "/cart/cart";
	}
	
}
