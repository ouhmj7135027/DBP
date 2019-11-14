package persistence.dao.impl;

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
		int result = 0;
		String insertQuery = "INSERT INTO CART (m_id, cart_p_num, c_price, product_id) " +
							 "VALUES (?, ?, ?, ?) ";
		
		DAOFactory factory = new DAOFactory();		// 교수정보와 학과정보를 알아오기 위해 DAO 객체를 생성하는 factory 객체 생성
		
		// ProfDAO 객체를 생성하여 학생정보에 포함되어 있는 지도교수의 교수코드를 알아옴
		cartDAO cartDAO = factory.getCartDAO();		// factory 를 통해 교수에 대한 DAO 획득
		cartDTO cartDTO = cartDAO.getProfByName(stu.getProfName());		// 교수 DAO 의 이름을 사용하여 교수코드를 얻어오는 메소드 사용
		String pCode = profDTO.getPCode();		// 교수코드를 설정
		if (pCode == null) {
			System.out.println("해당 지도교수가 없습니다." + stu.getProfName());
			return 0;
		}
		
		// DeptDAO 객체를 생성하여 학생정보에 포함되어 있는 학과의 학과코드를 알아옴
		DeptDAO deptDAO = factory.getDeptDAO();		// factory 를 통해 학과에 대한 DAO 획득
		DeptDTO deptDTO = deptDAO.getDeptByName(stu.getDept());		// 학과 DAO 의 학과명을 사용하여 학과코드를 얻어오는 메소드 사용
		String dCode = deptDTO.getDCode();			// 학과코드를 설정
		if (dCode == null) {
			System.out.println("해당 학과가 없습니다.");
			return 0;
		}
		// query 문에 사용할 매개변수 값을 갖는 매개변수 배열 생성
		Object[] param = new Object[] {stu.getStuNo(), stu.getStuName(), 
							stu.getPwd(), stu.getStuPhoneNo(), stu.getYear(), pCode, dCode};		
		jdbcUtil.setSql(insertQuery);			// JDBCUtil 에 insert 문 설정
		jdbcUtil.setParameters(param);			// JDBCUtil 에 매개변수 설정
				
		try {				
			result = jdbcUtil.executeUpdate();		// insert 문 실행
			System.out.println(stu.getStuNo() + " 학번의 학생정보가 삽입되었습니다.");
		} catch (SQLException ex) {
			System.out.println("입력오류 발생!!!");
			if (ex.getErrorCode() == 1)
				System.out.println("동일한 학생정보가 이미 존재합니다."); 
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection 반환
		}		
		return result;		// insert 에 의해 반영된 레코드 수 반환	
			
	}
			
			// 장바구니를 수정하는 메소드
	public int updateInCart(cartDTO cart) {}
			
			// 장바구니안에 물건을 삭제하는 메소드
	public int deleteInCart(int m_id, int p_id) {}
			
			// id에 해당하는 카트정보를 반환하는 메소드
	public List<cartDTO> getCartById(int m_id){}

}
