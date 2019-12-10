package controller.product;

import controller.Controller;
import service.OrderManager;
import service.dto.cartDTO;
import service.dto.cartListDTO;
import service.dto.order_pDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(OrderController.class);
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*장바구니에서 각 리스트 값 (상품id, 가격, 수량) 가져와서  order_detail에 저장  ????*/
		
		/*HttpSession session = request.getSession();
		cartDTO cart = (cartDTO) session.getAttribute("CART");
		cartListDTO cartList = new cartListDTO();
			request.setAttribute("CART_LIST",  cartList);
			cartList.getCode();
			cartList.getTitle();
			cartList.getNumber();
			cartList.getPrice();
		
		log.debug("Insert order_detail : {}", order_detail);

	    //OrderManager manager = OrderManager.getInstance();
		//manager.insert(order_detail);*/
		
		
		
		/*form 입력값 
			& 
		order_id 시퀀스, m_id(시퀀스 말고 로그인한거로 어떻게 가져오지?), 
		order_state(일단 결제완료), order_date      ----order_p에 저장 */
		
		order_pDTO order = new order_pDTO(
				request.getParameter("order_name"),
				request.getParameter("order_phone"),
				request.getParameter("address"));
			
	    log.debug("Insert order : {}", order);

	    OrderManager manager = OrderManager.getInstance();
		manager.insertOrder_p(order);
		//cartDAO.deleteInCart(m_id); //주문하면 장바구니 비우기
		return "redirect:/user/myorderForm.jsp";		
		     		
	}

	@Override
	public void onlyGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}
	
}