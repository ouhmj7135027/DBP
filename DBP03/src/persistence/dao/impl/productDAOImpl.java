package persistence.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistence.DAOFactory;
import persistence.dao.productDAO;
import service.dto.MemberDTO;
import service.dto.cartDTO;
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
	public int create(productDTO pro) throws SQLException {
		String sql = "INSERT INTO PRODUCT (product_id, effect, p_name, p_price, category_id, category_age_id) "
					+ "VALUES (S_PRODUCT_ID.nextval, ?, ?, ?, ?, ?)";		
		Object[] param = new Object[] {pro.getEffect(), pro.getP_name(), 
				pro.getP_price(), pro.getCategory_id(), pro.getCategory_age_id()};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil 에 insert문과 매개 변수 설정
						
		try {				
			int result = jdbcUtil.executeUpdate();	// insert 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;	
		
		
	}
	
	//전체 상품정보를 List로 반환하는 메소드
	public List<productDTO> getProductList() {
		String sql = "select product.product_id AS product_id, " +
				"product.effect AS product_effect, " +
								"product.p_name AS product_name, " +
								"product.p_price AS product_price, " +
								"product.imgsrc AS product_image " +
								"from product";
		jdbcUtil.setSqlAndParameters(sql, null);
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<productDTO> list = new ArrayList<productDTO>();
			while(rs.next()) {
				productDTO dto = new productDTO();
				dto.setProduct_id(rs.getInt("product_id"));
				dto.setEffect(rs.getString("product_effect"));
				dto.setP_name(rs.getString("product_name"));
				dto.setP_price(rs.getInt("product_price"));
				dto.setImgsrc(rs.getString("product_image"));
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
	
	@Override
	public List<productDTO> getProductByCategory(int cnum1, int cnum2) {
		String listQuery;
		if(cnum1 == 1) {
			listQuery = "select product.product_id AS product_id, " +
					"product.effect AS product_effect, " +
									"product.p_name AS product_name, " +
									"product.p_price AS product_price, " +
									"product.imgsrc AS product_image " +
									"from product " +
									"where category_id = ?";}
		else {
			listQuery = "select product.product_id AS product_id, " +
					"product.effect AS product_effect, " +
					"product.p_name AS product_name, " +
					"product.p_price AS product_price, " +
					"product.imgsrc AS product_image " +
					"from product " +
					"where category_age_id = ?";
		}
		Object[] param = new Object[] {cnum2};	
		jdbcUtil.setSql(listQuery);
		jdbcUtil.setParameters(param);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<productDTO> list = new ArrayList<productDTO>();
			while(rs.next()) {
				productDTO dto = new productDTO();
				dto.setProduct_id(rs.getInt("product_id"));
				dto.setEffect(rs.getString("product_effect"));
				dto.setP_name(rs.getString("product_name"));
				dto.setP_price(rs.getInt("product_price"));
				dto.setImgsrc(rs.getString("product_image"));
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


	//상품목록만을 List로 반환하는 메소드
	public List<productDTO> getOnlyProductList() {
		String listQuery = "select product.p_name AS product_name, "
				+ "product.p_price AS product_price from product where product.p_id = ?";
		jdbcUtil.setSql(listQuery);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<productDTO> list = new ArrayList<productDTO>();
			while (rs.next()) {
				productDTO dto = new productDTO();
				dto.setP_name(rs.getString("product_name"));
				dto.setP_price(rs.getInt("product_price"));
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
	
	//상품의 이름으로 상품정보를 검색하여 해당상품의 정보를 갖고 있는 ProductDTO 객체를 반환하는 메소드
	public productDTO getProductByName(String name) {
		//category를 굳이 가져와야 하는지 모르겠어,,
		String searchQuery = query + ", " + "category.category_id AS category_id, " +
											"category_age.category_age_id AS category_age_id " +
										"from product, category, category_age " +
										"where p_name = ? AND " +
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
		String insertQuery = "INSERT INTO PRODUCT (product_id, effect, p_name, p_price, category_id, category_age_id) "
			+ "VALUES(S_PRODUCT_ID.nextval, ?, ?, ?, ?, ?)";
		
		Object[] param = new Object[] {pro.getEffect(), pro.getP_name(), 
				pro.getP_price(), pro.getCategory_id(), pro.getCategory_age_id()};
	
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
		if (pro.getP_price() != -1) {
			updateQuery += "p_price = ?, ";
			tempParam[index++] = pro.getP_price();
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
		updateQuery = updateQuery.replace(", where", " where"); // update 문의 where 절 앞에 있을 수 있는 , 제거
		
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

	}
		
	public int deleteProduct (int product_id) {
		String deleteQuery= "delete from product where product_id = ?";
		
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

	public productDTO survey (int survey, int category) {
		String query = "select p_name, effect, imgsrc from product where category_id = ? and survey = ?";
		
		jdbcUtil.setSql(query);
		Object[] param = new Object[] {category,survey};
		jdbcUtil.setParameters(param);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();	
			productDTO pro = new productDTO();
			if (rs.next()) {
			
			//pro.setProduct_id(rs.getInt("product_id"));
			pro.setEffect(rs.getString("effect"));
			pro.setP_name(rs.getString("p_name"));
			pro.setImgsrc(rs.getString("imgsrc"));
			}return pro;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();		
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection 반환
		}
		return null;
	}

	@Override
	public productDTO getProductById(int id) {
		// TODO Auto-generated method stub
		String listQuery = "select product.product_id AS product_id, " +
					"product.effect AS product_effect, " +
									"product.p_name AS product_name, " +
									"product.p_price AS product_price, " +
									"product.imgsrc AS product_image " +
									"from product " +
									"where product_id = ?";
		Object[] param = new Object[] {id};	
		jdbcUtil.setSql(listQuery);
		jdbcUtil.setParameters(param);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			productDTO product = new productDTO();
			if(rs.next()) {
				productDTO dto = new productDTO();
				dto.setProduct_id(rs.getInt("product_id"));
				dto.setEffect(rs.getString("product_effect"));
				dto.setP_name(rs.getString("product_name"));
				dto.setP_price(rs.getInt("product_price"));
				dto.setImgsrc(rs.getString("product_image"));
				return dto;
			}
		}catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection 반환
		}		
		return null;
	}


	@Override
	public List<productDTO> getProductByp_id(int id) {
		// TODO Auto-generated method stub
		String listQuery = "select p_name AS product_name, "
				+ "p_price AS product_price, "
				+ "imgsrc AS product_img from product where product_id = ?";
		
		Object[] param = new Object[] {id};	
		jdbcUtil.setSql(listQuery);
		jdbcUtil.setParameters(param);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<productDTO> list = new ArrayList<productDTO>();
			while (rs.next()) {
				productDTO dto = new productDTO();
				dto.setP_name(rs.getString("product_name"));
				dto.setP_price(rs.getInt("product_price"));
				dto.setImgsrc(rs.getString("product_img"));
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
	
	

}
