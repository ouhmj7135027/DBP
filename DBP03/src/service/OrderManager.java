package service;

import java.sql.SQLException;
import java.util.List;

import persistence.DAOFactory;
import persistence.dao.order_detailDAO;
import persistence.dao.order_pDAO;
import persistence.dao.productDAO;
import persistence.dao.impl.order_detailDAOImpl;
import persistence.dao.impl.order_pDAOImpl;
import service.dto.cartDTO;
import service.dto.order_detailDTO;
import service.dto.order_pDTO;
import service.dto.productDTO;


public class OrderManager {
	private static OrderManager manager = new OrderManager();
	private order_detailDAOImpl odDAO = null;
	private order_pDAOImpl order_pDAO;
	
	public OrderManager() {
		try {
			DAOFactory factory = new DAOFactory();
			odDAO = new order_detailDAOImpl();
			
			order_pDAO = new order_pDAOImpl();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public static OrderManager getInstance() {
		return manager;
	}
	
	public int insertOrder_p(order_pDTO order) throws SQLException{
		return order_pDAO.insertOrder_p(order);
	}
	
	public int insertOrderDetail(order_detailDTO order_detail) {
		return odDAO.insertOrder_detail(order_detail);
	}

	public List<order_pDTO> getOrderListById(int mid) {
		return order_pDAO.getOrderListById(mid);
	}
	
	public List<order_detailDTO> getOrderViewById(int oid) {
		return odDAO.getOrderViewById(oid);
	}

}

