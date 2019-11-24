package controller.member;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import service.dto.cartDTO;

public class AddProductToCartController implements Controller, Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void onlyGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
	
	}
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		String code = request.getParameter("CODE");
		
		if (code == null) 
			throw new ServletException("��ǰ�ڵ尡 �Էµ��� �ʾҽ��ϴ�.");
		
		HttpSession s = request.getSession();
		cartDTO cart = (cartDTO) s.getAttribute("CART");
		
		if (cart == null)
			cart = new cartDTO();
		cart.addItem(code,  1);
		s.setAttribute("CART", cart);
		//response.sendRedirect("AddItemToCartResult.jsp");
		
		return "/cart/AddItemToCartResult.jsp";
	}
}
