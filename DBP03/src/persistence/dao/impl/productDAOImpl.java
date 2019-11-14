package persistence.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import persistence.DAOFactory;
import persistence.dao.productDAO;
import service.dto.productDTO;

public class productDAOImpl implements productDAO {
private JDBCUtil jdbcUtil = null;
	
	private static String query = "select product.product_id AS product_id, " +
										"product.effect AS product_effect, " +
										"product.p_name AS product_name, " + 
										"product.p_price AS product_price, " +
										"product.sales AS product_sales";
	
	public productDAOImpl() {
		jdbcUtil = new JDBCUtil();
	}
	
	public productDTO getProductByName(String name) {
		String searchQuery = query + ", " + "category.category_id AS category_id, " +
											"category_age.category_age_id AS category_age_id " +
										"from product, category, category_age " +
										"where product.product_id = ? AND " +
											"product.category_id = category.category_id AND " +
											"product.category_age_id = category_age.category_age_id ";
		jdbcUtil.setSql(searchQuery);				// JDBCUtil �� query �� ����
		Object[] param = new Object[] { name };		// �л��� ã�� ���� �������� �̸��� ����
		jdbcUtil.setParameters(param);				// JDBCUtil �� query ���� �Ű����� ������ ����� �Ű����� ����
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query �� ����
			productDTO pro = null;
			if (rs.next()) {
				pro = new productDTO();
				pro.setProduct_id(rs.getInt("product_id"));
				pro.setEffect(rs.getString("product_effect"));
				pro.setP_name(rs.getString("product_name"));
				pro.setP_price(rs.getInt("product_price"));
				pro.setSales(rs.getInt("product_sales"));
			}
			return pro;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection ��ȯ
		}
		return null;
				
	}
	
	public int insertProduct (productDTO pro) {
		int result = 0;
		String insertQuery = "insert int product (product_id, effect, p_name, p_price, category_id, "
				+ "category_age, sales) " + "values(?, ?, ?, ?, ?, ?, ?) ";
		
		DAOFactory factory = new DAOFactory();
		
		//categoryDAO ��ü �����ؼ� id �˾ƿ;���
		//category_ageDAO ��ü �����ؼ� id �˾ƿ;���
		
		Object[] param = new Object[] {pro.getProduct_id(), pro.getEffect(), pro.getP_name(), 
				pro.getP_price(), pro.getSales()}; //category, categpry_age ���� �ؾ���
	
		jdbcUtil.setSql(insertQuery);
		jdbcUtil.setParameters(param);
		
		try {				
			result = jdbcUtil.executeUpdate();		// insert �� ����
			System.out.println(pro.getProduct_id() + " ��ǰ�� ��ǰ������ ���ԵǾ����ϴ�.");
		} catch (SQLException ex) {
			System.out.println("�Է¿��� �߻�!!!");
			if (ex.getErrorCode() == 1)
				System.out.println("������ ��ǰ�� �̹� �����մϴ�."); 
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection ��ȯ
		}		
		return result;		// insert �� ���� �ݿ��� ���ڵ� �� ��ȯ	
	}
	
	public int updateProduct(productDTO pro) {
		String updateQuery = "update product set ";
		int index = 0;
		Object[] tempParam = new Object[10];
		
		if (pro.getEffect() != null) {
			updateQuery += "effect = ?, ";
			tempParam[index++] = pro.getEffect();
		}
		if (pro.getP_name() != null) {
			updateQuery += "p_name = ?, ";
			tempParam[index++] = pro.getP_name();
		}
		if (pro.getP_price() != 0) {
			updateQuery += "p_price = ?, ";
			tempParam[index++] = pro.getP_price();
		}
		if (pro.getSales() != 0) {
			updateQuery += "p_sales = ?, ";
			tempParam[index++] = pro.getSales();
		}
		
		updateQuery += "where product_id = ? ";
		updateQuery = updateQuery.replace(", where", " where");
		
		tempParam[index++] = pro.getProduct_id();
		
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
		//sold out...?
	}
		
	public int deleteProduct (String product_id) {
		String deleteQuery = "delete from student where product_id = ?";
		
		jdbcUtil.setSql(deleteQuery);
		Object[] param = new Object[] {product_id};
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
