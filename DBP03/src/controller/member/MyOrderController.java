package controller.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import service.OrderManager;
import service.dto.order_pDTO;

public class MyOrderController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(MyOrderController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		
		OrderManager manager = OrderManager.getInstance();
		List<order_pDTO> orderlist = manager.getOrderListById(Integer.parseInt(String.valueOf(session.getAttribute("m_id"))));
		request.setAttribute("orderList", orderlist);
		return "/user/myorderList";   
		
	}

	@Override
	public void onlyGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}
	
}