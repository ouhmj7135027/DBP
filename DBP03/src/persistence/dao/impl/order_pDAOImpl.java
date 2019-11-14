package persistence.dao.impl;

import java.sql.SQLException;

import persistence.DAOFactory;
import persistence.dao.order_pDAO;
import service.dto.order_pDTO;

public class order_pDAOImpl implements order_pDAO{
private JDBCUtil jdbcUtil = null;
	
	public order_pDAOImpl() {
		jdbcUtil = new JDBCUtil();
	}
	
	public int insertOrder_p(order_pDTO ord) {
		int result = 0;
		String insertQuery = "insert into order_p (order_id, m_id, order_state, order_Date,"
				+ "address, total_price) " + "values(?, ?, ?, ?, ?, ?) ";
		
		DAOFactory factory = new DAOFactory();
		
		Object[] param = new Object[] {ord.getOrder_id(), ord.getOrder_state(), ord.getOrder_date(),
				ord.getAddress(), ord.getTotal_price()};
		
		jdbcUtil.setSql(insertQuery);
		jdbcUtil.setParameters(param);
		
		try {				
			result = jdbcUtil.executeUpdate();		// insert �� ����
			System.out.println(ord.getOrder_id() + " �ֹ��� �ֹ������� ���ԵǾ����ϴ�.");
		} catch (SQLException ex) {
			System.out.println("�Է¿��� �߻�!!!");
			if (ex.getErrorCode() == 1)
				System.out.println("������ �ֹ��� �̹� �����մϴ�."); 
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection ��ȯ
		}		
		return result;		// insert �� ���� �ݿ��� ���ڵ� �� ��ȯ	
	}
	
	public int updateOrder_p(order_pDTO ord) {
		String updateQuery = "update order_p set ";
		int index = 0;
		Object[] tempParam = new Object[10];
		
		if (ord.getOrder_state() != null) {
			updateQuery += "order_state = ?, ";
			tempParam[index++] = ord.getOrder_state();
		}
		
		updateQuery += "where order_id = ? ";
		updateQuery += updateQuery.replace(", where", " where");
		
		tempParam[index++] = ord.getOrder_id();
		
		Object[] newParam = new Object[index];
		for (int i = 0; i < newParam.length; i++)
			newParam[i] = tempParam[i];
		
		jdbcUtil.setSql(updateQuery);
		jdbcUtil.setParameters(newParam);
		
		try {
			int result = jdbcUtil.executeUpdate();		// update �� ����
			return result;			// update �� ���� �ݿ��� ���ڵ� �� ��ȯ
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection ��ȯ
		}		
		return 0;
	}
	
	public int deleteOrder_p (String order_id) {
		String deleteQuery = "delete from order_p where order_id = ? ";
		
		jdbcUtil.setSql(deleteQuery);
		Object[] param = new Object[] {order_id};
		jdbcUtil.setParameters(param);
		
		try {
			int result = jdbcUtil.executeUpdate();		// delete �� ����
			return result;						// delete �� ���� �ݿ��� ���ڵ� �� ��ȯ
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();		
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection ��ȯ
		}
		return 0;
	}

}
