package persistence.dao.impl;

import java.sql.SQLException;

import persistence.DAOFactory;
import persistence.dao.order_detailDAO;
import persistence.dao.order_pDAO;
import service.dto.order_detailDTO;
import service.dto.order_pDTO;
import service.dto.productDTO;

public class order_detailDAOImpl implements order_detailDAO{
	private JDBCUtil jdbcUtil = null;
	
	public order_detailDAOImpl() {
		jdbcUtil = new JDBCUtil();
	}
	
	public int insertOrder_detail(order_detailDTO ord_d) {
		int result = 0;
		String insertQuery = "insert into order_detail (product_id, order_detail_id, order_id,"
				+ "total_price, o_amount) " + "values(?, ?, ?, ?, ?) ";
		
		DAOFactory factory = new DAOFactory();
		
		persistence.dao.productDAO productDAO = factory.getProdutDAO();
		productDTO productDTO = productDAO.getProductByName(ord_d.getProduct_name());
		int pId = productDTO.getProduct_id();
		
		order_pDAO order_pDAO = factory.getOrder_pDAO();
		//order_pDTO order_pDTO = order_pDAO.getOrder_pById(ord_d.getOrder_id());
		int oId = order_pDTO.getOrder_id();
		
		Object[] param = new Object[] {ord_d.getProduct_id(), ord_d.getOrder_detail_id(), ord_d.getOrder_id(),
				ord_d.getTotal_price(), ord_d.getO_amount()};
		jdbcUtil.setSql(insertQuery);
		jdbcUtil.setParameters(param);
		
		try {				
			result = jdbcUtil.executeUpdate();		// insert 문 실행
			System.out.println(ord_d.getOrder_id() + " 주문의 주문정보가 삽입되었습니다.");
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
	
	public int deleteOrder_detail (String order_detail_id) {
		String deleteQuery = "delete from order_detail where order_detail_id = ? ";
		
		jdbcUtil.setSql(deleteQuery);
		Object[] param = new Object[] {order_detail_id};
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
