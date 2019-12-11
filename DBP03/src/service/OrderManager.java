package service;

import java.util.List;

import persistence.DAOFactory;
import persistence.dao.order_detailDAO;
import persistence.dao.order_pDAO;
import persistence.dao.productDAO;
import persistence.dao.impl.order_pDAOImpl;
import service.dto.order_detailDTO;
import service.dto.order_pDTO;
import service.dto.productDTO;


public class OrderManager {
	private static OrderManager manager = new OrderManager();
	private order_pDAO orderDAO = null;
	private order_detailDAO odDAO = null;
	
	public OrderManager() {
		try {
			DAOFactory factory = new DAOFactory();
			orderDAO = factory.getOrder_pDAO();
			odDAO = factory.getOrder_detailDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	/*public List<order_pDTO> getOrder_plistById() {
		return order_pDAO.getOrder_plistById();
	}
	
	public List<order_detailDTO> getOrder_dlistById() {
		return order_detailDAO.getOrder_dlistById();
	}*/
	
	public static OrderManager getInstance() {
		return manager;
	}
	
	public int insertOrder_p(order_pDTO order) {
		return orderDAO.insertOrder_p(order);
	}
	
	public int insertOrderDetail(order_detailDTO order_detail) {
		return odDAO.insertOrder_detail(order_detail);
	}
	

}

