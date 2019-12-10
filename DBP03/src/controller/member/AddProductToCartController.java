package controller.member;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

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
		
		return "redirect:/cart/result";
	}
}
