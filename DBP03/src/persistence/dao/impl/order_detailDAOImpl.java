package persistence.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import persistence.dao.order_detailDAO;
import service.dto.order_detailDTO;

public class order_detailDAOImpl implements order_detailDAO{
	private JDBCUtil jdbcUtil = null;
	
	public order_detailDAOImpl() {
		jdbcUtil = new JDBCUtil();
	}
	
	public List<order_detailDTO> getOrderViewById(int oid) {
		// TODO Auto-generated method stub
		String listQuery = "select imgsrc, order_detail.product_id AS product_id, p_name, p_price, o_amount, total_price"
						 + " from order_detail, product"
						 + " where order_detail.product_id = product.product_id AND order_id = ? ";
				
		
		Object[] param = new Object[] {oid};	
		jdbcUtil.setSql(listQuery);
		jdbcUtil.setParameters(param);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<order_detailDTO> list = new ArrayList<order_detailDTO>();
			while (rs.next()) {
				order_detailDTO dto = new order_detailDTO();
				dto.setImgsrc(rs.getString("imgsrc"));
				dto.setProduct_id(rs.getInt("product_id"));
				dto.setP_name(rs.getString("p_name"));
				dto.setP_price(rs.getInt("p_price"));
				dto.setO_amount(rs.getInt("o_amount"));
				dto.setTotal_price(rs.getInt("total_price"));
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
	
	public int insertOrder_detail(order_detailDTO ord_d) {
		/*String sql = "INSERT INTO ORDER_DETAIL (order_detail_id, order_id, product_id, o_amount, total_price, review ) "
				+ "VALUES(S_ORDER_DETAIL_ID.nextval, ?, ?, ?, ?, \'0\' )";	*/
		
		String sql = "INSERT INTO ORDER_DETAIL (order_detail_id, order_id, product_id, o_amount, total_price ) "
				+ "VALUES(S_ORDER_DETAIL_ID.nextval, ?, ?, ?, ?)";	
	
	Object[] param = new Object[] {ord_d.getOrder_id(), ord_d.getProduct_id(), ord_d.getO_amount(), ord_d.getTotal_price()};		
	jdbcUtil.setSql(sql);
	jdbcUtil.setParameters(param);	
					
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
	
	public int reviewed_order(String m_id, String product_id) {
		String sql = "INSERT INTO ORDER_DETAIL ( review ) "
				+ "VALUES(\'0\' ) where m_id = ? and product_id = ?";			
	jdbcUtil.setSql(sql);
	Object[] param = new Object[] {m_id, product_id};		
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
	
	public int updateOrder_detail(order_detailDTO ord_d) {
		String updateQuery = "update order_detail set ";
		int index = 0;
		Object[] tempParam = new Object[10];
		
		if (ord_d.getTotal_price() != -1) {
			updateQuery += "total_price = ?, ";
			tempParam[index++] = ord_d.getTotal_price();
		}
		if (ord_d.getO_amount() != -1) {
			updateQuery += "o_amount = ?, ";
			tempParam[index++] = ord_d.getO_amount();
		}
		
		updateQuery += "where order_detail = ? ";
		updateQuery += updateQuery.replace(", where",  " where");
		
		tempParam[index++] = ord_d.getOrder_detail_id();
		
		Object[] newParam = new Object[index];
		for (int i = 0; i < newParam.length; i++) 
			newParam[i] = tempParam[i];
		
		jdbcUtil.setSql(updateQuery);
		jdbcUtil.setParameters(newParam);
		
		try {
			int result = jdbcUtil.executeUpdate();		// update 占쎈닱�뜝占� �뜝�럥堉꾢뜝�럥六�
			return result;			// update �뜝�럥�뱺 �뜝�럩踰ε뜝�럥�돵 �뛾�룇瑗뤄옙寃ュ뜝�럥彛� �뜝�럩�읉占쎄턀�겫�뼔援� �뜝�럥�빢 �뛾�룇瑗뱄옙�꼶
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection �뛾�룇瑗뱄옙�꼶
		}		
		return 0;
	}
	
	public int deleteOrder_detail (String order_detail_id) {
		String deleteQuery = "delete from order_detail where order_detail_id = ? ";
		
		jdbcUtil.setSql(deleteQuery);
		Object[] param = new Object[] {order_detail_id};
		jdbcUtil.setParameters(param);
		
		try {
			int result = jdbcUtil.executeUpdate();		// delete 占쎈닱�뜝占� �뜝�럥堉꾢뜝�럥六�
			return result;						// delete �뜝�럥�뱺 �뜝�럩踰ε뜝�럥�돵 �뛾�룇瑗뤄옙寃ュ뜝�럥彛� �뜝�럩�읉占쎄턀�겫�뼔援� �뜝�럥�빢 �뛾�룇瑗뱄옙�꼶
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();		
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection �뛾�룇瑗뱄옙�꼶
		}
		return 0;
	}


}
