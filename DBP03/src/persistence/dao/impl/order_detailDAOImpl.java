package persistence.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistence.DAOFactory;
import persistence.dao.order_detailDAO;
import persistence.dao.order_pDAO;
import service.dto.cartDTO;
import service.dto.order_detailDTO;
import service.dto.order_pDTO;
import service.dto.productDTO;

public class order_detailDAOImpl implements order_detailDAO{
	private JDBCUtil jdbcUtil = null;
	
	public order_detailDAOImpl() {
		jdbcUtil = new JDBCUtil();
	}
	
	/*public List<order_detailDTO> listOrder()
	{
		String sql = "select order_num, g.name gname, c.name cname, c.address, order_date from orderlist "
				+ "inner join goods g on orderlist.goods_num = g.goods_num"
				+ "inner join customer c on orderlist.cust_id = c.id order by order_num desc";
		
		List<OrderDTO> ReturnList = new ArrayList<OrderDTO>();
		
		try {
			pstmt = con.prepareStatement(sql);
			
			
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				OrderDTO T = new OrderDTO();
				
				T.setCustAddr(rs.getString("c.address"));
				T.setCustName(rs.getString("cname"));
				T.setOrder_num(rs.getInt("order_num"));
				T.setGoodsName(rs.getString("gname"));
				T.setOrder_date(rs.getDate("order_date"));
				
				ReturnList.add(T);
			}
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.print("List order SQL ERROR");
			}
			
			return ReturnList;
	}*/
	
	public int insertOrder_detail(order_detailDTO ord_d) {
		String sql = "INSERT INTO ORDER_DETAIL (order_detail_id, order_id, product_id, o_amount, total_price) "
				+ "VALUES(S_ORDER_DETAIL_ID.nextval, ?, ?, ?, ? )";	
	
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
	public List<order_detailDTO> getOrderListByMid(int order_id) {
		 
		String sql = "select p_name " +
						"from product,order_detail" +
						"where product.product_id = order_detail.product_id AND order_id = ? ";
		Object[] param = new Object[] {order_id};
		jdbcUtil.setSqlAndParameters(sql, param);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<order_detailDTO> list = new ArrayList<order_detailDTO>();
			while(rs.next()) {
				order_detailDTO dto = new order_detailDTO();
				dto.setProduct_id(rs.getInt("product_id"));
				
				list.add(dto);
			}
			return  list;
		}catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection 반환
		}		
		return null;
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
			int result = jdbcUtil.executeUpdate();		// update �눧占� 占쎈뼄占쎈뻬
			return result;			// update 占쎈퓠 占쎌벥占쎈퉸 獄쏆꼷�겫占쎈쭆 占쎌쟿�굜遺얜굡 占쎈땾 獄쏆꼹�넎
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection 獄쏆꼹�넎
		}		
		return 0;
	}
	
	public int deleteOrder_detail (String order_detail_id) {
		String deleteQuery = "delete from order_detail where order_detail_id = ? ";
		
		jdbcUtil.setSql(deleteQuery);
		Object[] param = new Object[] {order_detail_id};
		jdbcUtil.setParameters(param);
		
		try {
			int result = jdbcUtil.executeUpdate();		// delete �눧占� 占쎈뼄占쎈뻬
			return result;						// delete 占쎈퓠 占쎌벥占쎈퉸 獄쏆꼷�겫占쎈쭆 占쎌쟿�굜遺얜굡 占쎈땾 獄쏆꼹�넎
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();		
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection 獄쏆꼹�넎
		}
		return 0;
	}

}
