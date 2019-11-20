package controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import service.dto.cartDTO;

public class AddProductToCartController implements Controller{
	/*public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String code = request.getParameter("CODE");
		
		if (code == null) 
			throw new ServletException("상품코드가 입력되지 않았습니다.");
		
		HttpSession session = request.getSession();
		cartDTO cart = (cartDTO) session.getAttribute("CART");
		
		if (cart == null)
			cart = new cartDTO();
		cart.addItem(code,  1);
		session.setAttribute("CART", cart);
		response.sendRedirect("장바구니담기버튼누르면뜨는창.jsp?ITEM_NUM=" + 1);
	}*/

	@Override
	public void onlyGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String code = request.getParameter("CODE");
		
		if (code == null) 
			throw new ServletException("상품코드가 입력되지 않았습니다.");
		
		HttpSession session = request.getSession();
		cartDTO cart = (cartDTO) session.getAttribute("CART");
		
		if (cart == null)
			cart = new cartDTO();
		cart.addItem(code,  1);
		session.setAttribute("CART", cart);
		response.sendRedirect("장바구니담기버튼누르면뜨는창.jsp?ITEM_NUM=" + 1);
	
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
