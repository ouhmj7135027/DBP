package service;

import java.sql.SQLException;
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
	private order_detailDAO odDAO = null;
	private order_pDAOImpl order_pDAO;
	
	public OrderManager() {
		try {
			DAOFactory factory = new DAOFactory();
			odDAO = factory.getOrder_detailDAO();
			
			order_pDAO = new order_pDAOImpl();
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
	
	public int insertOrder_p(order_pDTO order) throws SQLException{
		return order_pDAO.insertOrder_p(order);
	}
	
	public int insertOrderDetail(order_detailDTO order_detail) {
		return odDAO.insertOrder_detail(order_detail);
	}
	

}

