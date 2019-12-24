package controller.product;

import controller.Controller;
import service.CartManager;
import service.OrderManager;
import service.ProductManager;
import service.dto.cartDTO;
import service.dto.cartListDTO;
import service.dto.order_detailDTO;
import service.dto.order_pDTO;
import service.dto.productDTO;

import java.io.IOException;
import java.util.List;

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

		HttpSession session = request.getSession();
		
		order_pDTO order = new order_pDTO(
				Integer.parseInt(String.valueOf(session.getAttribute("m_id"))),
				request.getParameter("order_name"),
				request.getParameter("order_phone"),
				request.getParameter("address"),
				Integer.parseInt(request.getParameter("total_price")));
			
	    log.debug("Insert order : {}", order);

	    OrderManager manager = OrderManager.getInstance();
		int order_id = manager.insertOrder_p(order);
		
		//ProductManager promanager = ProductManager.getInstance();

		CartManager cmanager = CartManager.getInstance();
		List<cartDTO> clist = cmanager.getCartByMid(Integer.parseInt(String.valueOf(session.getAttribute("m_id"))));
		
		for(int i = 0; i < clist.size(); i++) {
			System.out.println(clist.get(i).getProduct_id() + " " +clist.get(i).getCart_p_num());
			order_detailDTO od = new order_detailDTO();
			od.setProduct_id(clist.get(i).getProduct_id());
			od.setO_amount(clist.get(i).getCart_p_num());
			od.setTotal_price(clist.get(i).getP_price()*clist.get(i).getCart_p_num());
			od.setOrder_id(order_id);
			manager.insertOrderDetail(od);
		}
		cmanager.delete(Integer.parseInt(String.valueOf(session.getAttribute("m_id"))));	
		
		//if(order_id == 0)
			//promanager.update(p);
		
		return "/user/myorder/list";		
		     		
	}
	
	

	@Override
	public void onlyGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}
	
}