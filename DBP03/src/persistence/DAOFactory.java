package persistence;

import persistence.dao.*;
import persistence.dao.impl.*;

// DAO �� ������ Implementation ��ü�� �����ϴ� Ŭ����
public class DAOFactory {
	
	// cartDAO �� ���� RDB �� DAO Implementation ��ü�� ��ȯ
	public cartDAO getCartDAO() {
		return new cartDAOImpl();		 
	}
	
	public productDAO getProdutDAO() {
		return new productDAOImpl();
	}

	public order_pDAO getOrder_pDAO() {
		return new order_pDAOImpl();
	}
	
	public MemberDAO getMemberDAO() {
		return new MemberDAOImpl();
	}
	
	public ExchangeDAO getExchangeDAO() {
		return new ExchangeDAOImpl();
	}

}
