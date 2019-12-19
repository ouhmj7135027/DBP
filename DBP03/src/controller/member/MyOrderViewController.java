package controller.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import service.OrderManager;
import service.dto.order_detailDTO;

public class MyOrderViewController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(MyOrderViewController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		OrderManager manager = OrderManager.getInstance();
		
		int oid = Integer.parseInt(String.valueOf(request.getParameter("orderId")));
		
		List<order_detailDTO> orderview = manager.getOrderViewById(oid);
		
		request.setAttribute("orderView", orderview);
		
		return "/user/myorderView";      
		
	}

	@Override
	public void onlyGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}
	
}