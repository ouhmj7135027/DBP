package controller.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import service.OrderManager;
import service.dto.order_detailDTO;
import service.dto.order_pDTO;

public class MyOrderController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		OrderManager manager = OrderManager.getInstance();
		List<order_pDTO> order_plist = manager.getOrder_plistById();
		request.setAttribute("order_plist", order_plist);
		
		List<order_detailDTO> order_dlist = manager.getOrder_dlistById();
		request.setAttribute("order_dlist", order_dlist);
		return null;				
		       
	}

	@Override
	public void onlyGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}
	
}