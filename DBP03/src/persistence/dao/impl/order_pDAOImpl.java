package persistence.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistence.dao.order_pDAO;
import service.dto.order_pDTO;

public class order_pDAOImpl implements order_pDAO{
	private JDBCUtil jdbcUtil = null;
	
	public order_pDAOImpl() {
		jdbcUtil = new JDBCUtil();
	}

	@Override
	public List<order_pDTO> getOrderListById(int mid) {
		// TODO Auto-generated method stub
		String listQuery = "select order_date, order_id, order_name, address, total_price , order_state "
						 + "from order_p where m_id = ?";
				
		
		Object[] param = new Object[] {mid};	
		jdbcUtil.setSql(listQuery);
		jdbcUtil.setParameters(param);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<order_pDTO> list = new ArrayList<order_pDTO>();
			while (rs.next()) {
				order_pDTO dto = new order_pDTO();
				dto.setOrder_date(rs.getDate("order_date"));
				dto.setOrder_id(rs.getInt("order_id"));
				dto.setOrder_name(rs.getString("order_name"));
				dto.setAddress(rs.getString("address"));
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
		String sql = "INSERT INTO ORDER_P (order_id, m_id, order_state, order_date, address, total_price, order_name, order_phone) "
				+ "VALUES(S_ORDER_ID.nextval, ?, '결제완료', SYSDATE, ?, ?, ?, ?)";	
	
	Object[] param = new Object[] {ord.getM_id(), ord.getAddress(), ord.getTotal_price(), ord.getOrder_name(), ord.getOrder_phone()};		
	jdbcUtil.setSql(sql);
	jdbcUtil.setParameters(param);	
	String key[]={"order_id"};  
					
	try {				
		int result = jdbcUtil.executeUpdate(key);
		ResultSet rs = jdbcUtil.getGeneratedKeys();
		   int generatedKey = 0;
		   if(rs.next())
		       generatedKey = rs.getInt(1);   

		return generatedKey;
	} catch (Exception ex) {
		jdbcUtil.rollback();
		ex.printStackTrace();
	} finally {		
		jdbcUtil.commit();
		jdbcUtil.close();	
	}		
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
