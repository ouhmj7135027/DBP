package persistence.dao.impl;
import service.MemberManager;
import service.dto.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistence.DAOFactory;
import persistence.dao.cartDAO;


public class cartDAOImpl implements cartDAO {
	// StudentDTO 에 담긴 학생정보를 Data Source 에 추가하는 메소드
	private JDBCUtil jdbcUtil = null;		// JDBCUtil 객체를 지정하기 위한 변수
	private static String query;

	public cartDAOImpl() {	
		jdbcUtil = new JDBCUtil();
	}

	public int insertInCart(cartDTO cart) {
			String sql = "INSERT INTO cart (m_id, cart_p_num, c_price, product_id) "
						+ "VALUES (?, ?, ?, ?)";		

			Object[] param = new Object[] {cart.getM_id(), cart.getCart_p_num(), cart.getC_price(), cart.getProduct_id()};				
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

	@Override
	public int updateInCart(cartDTO cart) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteInCart(int m_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<cartDTO> getCartById(int m_id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//조인해서 한꺼번에 담기
	public List<cartDTO> getCartListByMid(int mid) {
		 
		String sql = "select p_name, imgsrc, p_price, cart_p_num " +
						"from cart, product " +
						"where cart.product_id = product.product_id AND m_id = ? ";
		Object[] param = new Object[] {mid};
		jdbcUtil.setSqlAndParameters(sql, param);
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<cartDTO> list = new ArrayList<cartDTO>();
			while(rs.next()) {
				cartDTO dto = new cartDTO();
				dto.setP_name(rs.getString("p_name"));
				dto.setCart_p_num(rs.getInt("cart_p_num"));
				dto.setImgsrc(rs.getString("imgsrc"));
				dto.setP_price(rs.getInt("p_price"));
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
}
	
	/*
	@Override
	public int updateInCart(cartDTO stu) {
		// TODO Auto-generated method stub
		int result = 0;
		String insertQuery = "INSERT INTO CART (m_id, cart_p_num, c_price, product_id) " +
							 "VALUES (?,?, ?, ?, ?) ";
		
		DAOFactory factory = new DAOFactory();		// 교수정보와 학과정보를 알아오기 위해 DAO 객체를 생성하는 factory 객체 생성
		
		// 외부에서 어떻게 받아오는지 모르겠어......
		
		// query 문에 사용할 매개변수 값을 갖는 매개변수 배열 생성
		Object[] param = new Object[] {MemberDTO.getM_id(), cartDTO.getCart_p_num(), 
				cartDTO.getC_price(), cartDTO.getProduct_id()};		
			
		jdbcUtil.setSql(insertQuery);			// JDBCUtil 에 insert 문 설정
		jdbcUtil.setParameters(param);			// JDBCUtil 에 매개변수 설정
				
		try {				
			result = jdbcUtil.executeUpdate();		// insert 문 실행
			System.out.println();
		} catch (SQLException ex) {
			System.out.println("입력오류 발생!!!");
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection 반환
		}		
		return result;		// insert 에 의해 반영된 레코드 수 반환	
			

	}

	@Override
	public int deleteInCart(int m_id) {
		// TODO Auto-generated method stub
		String deleteQuery = "DELETE FROM CART WHERE M_ID = ?";
		
		jdbcUtil.setSql(deleteQuery);			// JDBCUtil 에 query 문 설정
		Object[] param = new Object[] {cartDTO.getM_id()};
		jdbcUtil.setParameters(param);			// JDBCUtil 에 매개변수 설정
		
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

	

	
	public List<cartDTO> getCartById(int m_id) {
		// TODO Auto-generated method stub
		String searchQuery = query + "Select c_id where m_id = ? from cart";
		Object[] param = new Object[] {m_id};
		
		jdbcUtil.setSql(searchQuery);
		jdbcUtil.setParameters(param);
	
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<cartDTO> list = new ArrayList<cartDTO>();
			while (rs.next()) {
				cartDTO dto = new cartDTO();
				dto.setM_id(rs.getInt("m_id"));
				dto.setCart_p_num(rs.getInt("cart_p_num"));
				dto.setC_price(rs.getInt("c_price"));
				dto.setProduct_id(rs.getInt("product_id"));
				list.add(dto);
			}
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return null;
	}


	}
			
			// 장바구니를 수정하는 메소드
	
*/

