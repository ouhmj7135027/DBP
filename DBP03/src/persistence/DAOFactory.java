package persistence;

import service.dao.*;
import serviceImpl.dao.*;

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

}
