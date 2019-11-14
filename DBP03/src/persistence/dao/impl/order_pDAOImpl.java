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
			result = jdbcUtil.executeUpdate();		// insert 문 실행
			System.out.println(ord.getOrder_id() + " 주문의 주문정보가 삽입되었습니다.");
		} catch (SQLException ex) {
			System.out.println("입력오류 발생!!!");
			if (ex.getErrorCode() == 1)
				System.out.println("동일한 주문이 이미 존재합니다."); 
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection 반환
		}		
		return result;		// insert 에 의해 반영된 레코드 수 반환	
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
			int result = jdbcUtil.executeUpdate();		// update 문 실행
			return result;			// update 에 의해 반영된 레코드 수 반환
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection 반환
		}		
		return 0;
	}
	
	public int deleteOrder_p (String order_id) {
		String deleteQuery = "delete from order_p where order_id = ? ";
		
		jdbcUtil.setSql(deleteQuery);
		Object[] param = new Object[] {order_id};
		jdbcUtil.setParameters(param);
		
		try {
			int result = jdbcUtil.executeUpdate();		// delete 문 실행
			return result;						// delete 에 의해 반영된 레코드 수 반환
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();		
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection 반환
		}
		return 0;
	}

}
