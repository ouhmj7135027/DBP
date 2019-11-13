package persistence;

import service.dao.*;
import serviceImpl.dao.*;

// DAO 를 구현한 Implementation 객체를 생성하는 클래스
public class DAOFactory {
	
	// cartDAO 를 위한 RDB 용 DAO Implementation 객체를 반환
	public cartDAO getCartDAO() {
		return new cartDAOImpl();		 
	}
	
	public productDAO getProdutDAO() {
		return new productDAOImpl();
	}

	public order_pDAO getOrder_pDAO() {
		return new order_pDAOImpl();
	}

}
