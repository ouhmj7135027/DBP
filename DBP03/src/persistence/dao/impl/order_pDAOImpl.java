package persistence.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistence.dao.order_pDAO;
import service.dto.order_pDTO;

public class order_pDAOImpl implements order_pDAO{
	private JDBCUtil jdbcUtil = null;
	private static order_pDAOImpl dao = new order_pDAOImpl();
	
	public order_pDAOImpl() {
		jdbcUtil = new JDBCUtil();
	}
	
	public static order_pDAOImpl getInstance() {
	     return dao;
	  }

	/*public List<order_pDTO> getOrder_plistById() {
		String listQuery = "select order_p.order_id AS order_id, " +
				"order_p.order_date AS order_date, " +
				"order_p.total_price AS total_price, " +
				"order_p.order_state AS order_state " +
				"from order_p "+
				"where order_id = ?";}
		jdbcUtil.setSql(listQuery);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<order_pDTO> list = new ArrayList<order_pDTO>();
			while (rs.next()) {
				order_pDTO dto = new order_pDTO();
				dto.setOrder_id(rs.getInt("order_id"));
				dto.setOrder_date(rs.getDate("order_date"));
				dto.setTotal_price(rs.getInt("total_price"));
				dto.setOrder_state(rs.getString("order_state"));
				list.add(dto);
			}
			return list;
			
		}catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}*/

	public int insert(order_pDTO ord) throws SQLException{
		String sql = "INSERT INTO ORDER_P (order_id, email_id, order_state, order_date, address, total_price, order_name, order_phone) "
					+ "VALUES (S_ORDER_ID.nextval, ?, 결제 완료, SYSDATE, ?, ?, ?, ?)";	
		
		Object[] param = new Object[] {ord.getEmail_id(), ord.getAddress(), ord.getTotal_price(), ord.getOrder_name(), ord.getOrder_phone()};		
		jdbcUtil.setSqlAndParameters(sql, param);	
						
		try {				
			int result = jdbcUtil.executeUpdate();
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();	
		}		
		return 0;			
	}
	
	public int update(order_pDTO ord) {
		String updateQuery = "update order_p set ";
		int index = 0;
		Object[] tempParam = new Object[10];
		
		if (ord.getOrder_state() != null) {
			updateQuery += "order_state = ?, ";
			tempParam[index++] = ord.getOrder_state();
		}
		
		if (ord.getOrder_date() != null) {
			updateQuery += "order_Date = ?, ";
			tempParam[index++] = ord.getOrder_date();
		}
		if (ord.getAddress() != null) {
			updateQuery += "address = ?, ";
			tempParam[index++] = ord.getAddress();
		}
		if (ord.getTotal_price() != -1) {
			updateQuery += "total_price = ?, ";
			tempParam[index++] = ord.getTotal_price();
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
	
	public int delete (String order_id) {
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

	@Override
	public int insertOrder_p(order_pDTO ord) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateOrder_p(order_pDTO ord) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOrder_p(String order_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
