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
		jdbcUtil.setSql(searchQuery);				// JDBCUtil 에 query 문 설정
		Object[] param = new Object[] { name };		// 학생을 찾기 위한 조건으로 이름을 설정
		jdbcUtil.setParameters(param);				// JDBCUtil 에 query 문의 매개변수 값으로 사용할 매개변수 설정
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 문 실행
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
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection 반환
		}
		return null;
				
	}
	
	public int insertProduct (productDTO pro) {
		int result = 0;
		String insertQuery = "insert int product (product_id, effect, p_name, p_price, category_id, "
				+ "category_age, sales) " + "values(?, ?, ?, ?, ?, ?, ?) ";
		
		DAOFactory factory = new DAOFactory();
		
		//categoryDAO 객체 생성해서 id 알아와야함
		//category_ageDAO 객체 생성해서 id 알아와야함
		
		Object[] param = new Object[] {pro.getProduct_id(), pro.getEffect(), pro.getP_name(), 
				pro.getP_price(), pro.getSales()}; //category, categpry_age 삽입 해야함
	
		jdbcUtil.setSql(insertQuery);
		jdbcUtil.setParameters(param);
		
		try {				
			result = jdbcUtil.executeUpdate();		// insert 문 실행
			System.out.println(pro.getProduct_id() + " 상품의 상품정보가 삽입되었습니다.");
		} catch (SQLException ex) {
			System.out.println("입력오류 발생!!!");
			if (ex.getErrorCode() == 1)
				System.out.println("동일한 상품이 이미 존재합니다."); 
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection 반환
		}		
		return result;		// insert 에 의해 반영된 레코드 수 반환	
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
		//sold out...?
	}
		
	public int deleteProduct (String product_id) {
		String deleteQuery = "delete from student where product_id = ?";
		
		jdbcUtil.setSql(deleteQuery);
		Object[] param = new Object[] {product_id};
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
