package persistence;

import persistence.dao.*;
import persistence.dao.impl.*;

// DAO 를 구현한 Implementation 객체를 생성하는 클래스
public class DAOFactory {
	
	// cartDAO 를 위한 RDB 용 DAO Implementation 객체를 반환
	public cartDAOImpl getCartDAO() {
		return new cartDAOImpl();		 
	}
	
	public productDAO getProdutDAO() {
		return new productDAOImpl();
	}

	public order_pDAO getOrder_pDAO() {
		return new order_pDAOImpl();
	}
	
	public order_detailDAO getOrder_detailDAO() {
		return new order_detailDAOImpl();
	}
	
	public MemberDAOImpl getMemberDAO() {
		return new MemberDAOImpl();
	}
	
	public ExchangeDAO getExchangeDAO() {
		return new ExchangeDAOImpl();
	}

}
