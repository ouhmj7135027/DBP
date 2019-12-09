package service;

import java.util.List;

import persistence.dao.order_detailDAO;
import persistence.dao.impl.order_pDAOImpl;
import service.dto.order_detailDTO;
import service.dto.order_pDTO;
import service.dto.productDTO;


public class OrderManager {
	private static OrderManager order = new OrderManager();
	private order_pDAOImpl order_pDAO;

	/*public List<order_pDTO> getOrder_plistById() {
		return order_pDAO.getOrder_plistById();
	}
	
	public List<order_detailDTO> getOrder_dlistById() {
		return order_detailDAO.getOrder_dlistById();
	}*/
	
	private OrderManager() {
			order_pDAO = new order_pDAOImpl();
	}
	
	public static OrderManager getInstance() {
		return order;
	}
	
	public int insertOrder_p(order_pDTO order) {
		return order_pDAO.insertOrder_p(order);
	}
	
	public order_pDAOImpl getorder_pDAO() {
		return this.order_pDAO;
	}

}

