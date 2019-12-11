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
		/*�옣諛붽뎄�땲�뿉�꽌 媛� 由ъ뒪�듃 媛� (�긽�뭹id, 媛�寃�, �닔�웾) 媛��졇���꽌  order_detail�뿉 ���옣  ????*/
		
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
		
		
		
		/*form �엯�젰媛� 
			& 
		order_id �떆���뒪, m_id(�떆���뒪 留먭퀬 濡쒓렇�씤�븳嫄곕줈 �뼱�뼸寃� 媛��졇�삤吏�?), 
		order_state(�씪�떒 寃곗젣�셿猷�), order_date      ----order_p�뿉 ���옣 */
		HttpSession session = request.getSession();
		
		order_pDTO order = new order_pDTO(
				(String)session.getAttribute("userId"),
				request.getParameter("order_name"),
				request.getParameter("order_phone"),
				request.getParameter("address"),
				Integer.parseInt(request.getParameter("total_price")));
			
	    log.debug("Insert order : {}", order);

	    OrderManager manager = OrderManager.getInstance();
		manager.insertOrder_p(order);
		//cartDAO.deleteInCart(m_id); //二쇰Ц�븯硫� �옣諛붽뎄�땲 鍮꾩슦湲�
		return "/user/myorderForm.jsp";		
		     		
	}

	@Override
	public void onlyGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}
	
}