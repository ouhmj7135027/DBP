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
			result = jdbcUtil.executeUpdate();		// insert �� ����
			System.out.println(ord_d.getOrder_id() + " �ֹ��� �ֹ������� ���ԵǾ����ϴ�.");
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
	
	public int deleteOrder_detail (String order_detail_id) {
		String deleteQuery = "delete from order_detail where order_detail_id = ? ";
		
		jdbcUtil.setSql(deleteQuery);
		Object[] param = new Object[] {order_detail_id};
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
