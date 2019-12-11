package controller.member;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import service.CartManager;
import service.ProductManager;
import service.dto.cartDTO;
import service.dto.productDTO;

public class AddProductToCartController implements Controller, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void onlyGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	
	}
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String p_id = request.getParameter("productId");
		
		if (p_id == null) 
			throw new ServletException("��ǰ�ڵ尡 �Էµ��� �ʾҽ��ϴ�.");
		
		HttpSession session = request.getSession();
		cartDTO cart = (cartDTO) session.getAttribute("CART");
		
		//���ǿ��� ��ٱ��� ��ü�� ���� ��� ���� �����
		if (cart == null) {
			cart = new cartDTO();
			
		}
		//���ǿ��� ��ٱ��� ��ü ���� ��� ��ٱ��Ͽ� ��ǰ �߰� 
		cart.addItem(p_id,  1);
		session.setAttribute("CART", cart);
		
		ProductManager manager = ProductManager.getInstance();
		productDTO product;
		product = manager.getProductById(Integer.parseInt(p_id));
		
		CartManager cmanager = CartManager.getInstance();
		cartDTO c = new cartDTO(Integer.parseInt(String.valueOf(session.getAttribute("m_id"))), 
				1, 
									product.getP_price(), product.getProduct_id());
		try {
			cmanager.insert(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/cart/result";
	}
}
