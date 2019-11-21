package persistence.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	//��ü ��ǰ������ List�� ��ȯ�ϴ� �޼ҵ�
	public List<productDTO> getProductList() {
		jdbcUtil.setSql(query+"from product");
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<productDTO> list = new ArrayList<productDTO>();
			while(rs.next()) {
				productDTO dto = new productDTO();
				dto.setProduct_id(rs.getInt("product_id"));
				dto.setEffect(rs.getString("product_effect"));
				dto.setP_name(rs.getString("product_name"));
				dto.setP_price(rs.getInt("product_price"));
				dto.setSales(rs.getInt("product_sales"));
				list.add(dto);
			}
			return  list;
		}catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection ��ȯ
		}		
		return null;
	}
	
	@Override
	public List<productDTO> getProductByCategory(int cnum1, int cnum2) {
		String listQuery;
		if(cnum1 == 1) {
			listQuery = "select product.effect AS product_effect, " + 
									"product.p_name AS product_name, " +
									"product.p_price AS product_price " +
									"from product " +
									"where category_id = ?";}
		else if(cnum1 == 2) {
			listQuery = "select product.effect AS product_effect, " + 
					"product.p_name AS product_name, " +
					"product.p_price AS product_price " +
					"from product " +
					"where category_age_id = ?";
		}
		jdbcUtil.setSql(listQuery);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<productDTO> list = new ArrayList<productDTO>();
			while(rs.next()) {
				productDTO dto = new productDTO();
				dto.setProduct_id(rs.getInt("product_id"));
				dto.setEffect(rs.getString("product_effect"));
				dto.setP_name(rs.getString("product_name"));
				dto.setP_price(rs.getInt("product_price"));
				dto.setSales(rs.getInt("product_sales"));
				list.add(dto);
			}
			return  list;
		}catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection ��ȯ
		}		
		return null;
	}
}

	//��ǰ��ϸ��� List�� ��ȯ�ϴ� �޼ҵ�
	public List<productDTO> getOnlyProductList() {
		String listQuery = "select product.p_name AS product_name from product ";
		jdbcUtil.setSql(listQuery);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<productDTO> list = new ArrayList<productDTO>();
			while (rs.next()) {
				productDTO dto = new productDTO();
				dto.setP_name(rs.getString("product_name"));
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
	
	//��ǰ�� �̸����� ��ǰ������ �˻��Ͽ� �ش��ǰ�� ������ ���� �ִ� ProductDTO ��ü�� ��ȯ�ϴ� �޼ҵ�
	public productDTO getProductByName(String name) {
		//category�� ���� �����;� �ϴ��� �𸣰ھ�,,
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
		//categoryDAO categoryDAO = factory.getCategoryDAO(); //factory�� ���� ī�װ��� ���� DAO ȹ��
		//categoryDTO categoryDTO = categoryDAO.getCategoryById(pro.getCategory_id());
		//int cateId = categoryDTO.getCategory_id();
				
		//category_ageDAO category_ageDAO = factory.getCategory_ageDAO();
		//category_ageDAO categoryDTO = category_ageDAO.getCategory_ageById(pro.getCategory_age_id());
		//int cate_ageId = category_ageDTO.getCategory_id();
		
		Object[] param = new Object[] {pro.getProduct_id(), pro.getEffect(), pro.getP_name(), 
				pro.getP_price(), pro.getSales(), pro.getCategory_id(), pro.getCategory_age_id()};
	
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
		if (pro.getP_price() != -1) {
			updateQuery += "p_price = ?, ";
			tempParam[index++] = pro.getP_price();
		}
		if (pro.getSales() != -1) {
			updateQuery += "p_sales = ?, ";
			tempParam[index++] = pro.getSales();
		}
		if (pro.getCategory_id() != -1) {
			updateQuery += "category_id = ?, ";
			tempParam[index++] = pro.getCategory_id();
		}
		if (pro.getCategory_age_id() != -1) {
			updateQuery += "category_age_id = ?, ";
			tempParam[index++] = pro.getCategory_age_id();
		}
		
		updateQuery += "where product_id = ? ";
		updateQuery = updateQuery.replace(", where", " where"); // update ���� where �� �տ� ���� �� �ִ� , ����
		
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
