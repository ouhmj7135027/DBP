package persistence.dao.impl;

import java.util.ArrayList;
import java.util.List;

import model.Member;

import java.sql.*;

import service.dto.*;
import persistence.DAOFactory;
import persistence.dao.*;

public class MemberDAOImpl {
	
	private JDBCUtil jdbcUtil = null;
	
	public MemberDAOImpl() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}
	
	   
	/*private static String query = 	"SELECT Member.m_id AS MEM_ID, " +
				"Member.m_name AS MEM_NAME, " +
				"Member.m_password AS MEM_PWD, " +
				"Member.email_id AS MEM_EMAIL, " +
				"Member.address AS MEM_ADDRESS " +
				"Member.phone AS MEM_PHONE " +
				"FROM Member ";
	
	
	
	public List<MemberDTO> getMemberList() {
		// TODO Auto-generated method stub
		jdbcUtil.setSql(query);		// JDBCUtil 에 query 설정
		
		try { 
			ResultSet rs = jdbcUtil.executeQuery();			
			List<MemberDTO> list = new ArrayList<MemberDTO>();	
			while (rs.next()) {	
				MemberDTO dto = new MemberDTO();		
				dto.setM_id(rs.getInt("MEM_ID"));
				dto.setM_name(rs.getString("MEM_NAME"));
				dto.setM_password(rs.getString("MEM_PWD"));
				dto.setEmail_id(rs.getString("MEM_EMAIL"));
				dto.setAddress(rs.getString("MEM_ADDRESS"));
				dto.setPhone(rs.getString("MEM_PHONE"));
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


	public Member getMemberByEmail(String email) {
		// TODO Auto-generated method stub
		String searchQuery = query + "WHERE MEMBER.email_id = ? ";
		jdbcUtil.setSql(searchQuery);				
		Object[] param = new Object[] { email };		
		jdbcUtil.setParameters(param);				
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();		
			 // dto대신에 model을 사용하는 것으로 수정함  지원
			if (rs.next()) {						
				Member m = new Member(	
				rs.getInt("MEM_ID"),
				rs.getString("MEM_NAME"),
				rs.getString("MEM_PWD"),
				rs.getString("MEM_EMAIL"),
				rs.getString("MEM_ADDRESS"),
				rs.getString("MEM_PHONE"));
				return m;
				
			}
							
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		
		}
		return null;
	}

	public int insertMember(MemberDTO mem) {
		// TODO Auto-generated method stub
		int result = 0;
		String insertQuery = "INSERT INTO MEMBER (m_id, m_name, m_password, email_id, address, phone) " +
							 "VALUES (?, ?, ?, ?, ?, ?) ";
		
		Object[] param = new Object[] {mem.getM_id(), mem.getM_name(), mem.getM_password(), 
				mem.getEmail_id(), mem.getAddress(), mem.getPhone()};		
		jdbcUtil.setSql(insertQuery);			
		jdbcUtil.setParameters(param);			
				
		try {				
			result = jdbcUtil.executeUpdate();		
			System.out.println(mem.getEmail_id() + " 아이디의 회원정보가 삽입되었습니다.");
		} catch (SQLException ex) {
			System.out.println("입력오류 발생!!!");
			if (ex.getErrorCode() == 1)
				System.out.println("동일한 회원정보가 이미 존재합니다."); 
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();		
		}		
		return result;		
	}


	public int updateMember(MemberDTO mem) {
		// TODO Auto-generated method stub
		String updateQuery = "UPDATE MEMBER SET ";
		int index = 0;
		Object[] tempParam = new Object[10];		
		
		if (mem.getM_id() != 0) {		
			updateQuery += "m_id = ?, ";		
			tempParam[index++] = mem.getM_id();		
		}
		if (mem.getM_name() != null) {		
			updateQuery += "m_name = ?, ";		
			tempParam[index++] = mem.getM_name();		
		}
		if (mem.getM_password() != null) {		
			updateQuery += "m_password = ?, ";		
			tempParam[index++] = mem.getM_password();	
		}
		if (mem.getEmail_id() != null) {		
			updateQuery += "email_id = ?, ";		
			tempParam[index++] = mem.getEmail_id();		
		}
		if (mem.getAddress() != null) {		
			updateQuery += "address = ?, ";		
			tempParam[index++] = mem.getAddress();	
		}
		if (mem.getPhone() != null) {		
			updateQuery += "phone = ?, ";		
			tempParam[index++] = mem.getPhone();		
		}
		updateQuery += "WHERE m_id = ? ";		
		updateQuery = updateQuery.replace(", WHERE", " WHERE");		
		
		tempParam[index++] = mem.getM_id();	
		
		Object[] newParam = new Object[index];
		for (int i=0; i < newParam.length; i++)		
			newParam[i] = tempParam[i];
		
		jdbcUtil.setSql(updateQuery);			
		jdbcUtil.setParameters(newParam);		
		
		try {
			int result = jdbcUtil.executeUpdate();		
			return result;			
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	
		}		
		return 0;
	}

	
	public int deleteMember(int m_id) {
		// TODO Auto-generated method stub
		String deleteQuery = "DELETE FROM MEMBER WHERE m_id = ?";
		
		jdbcUtil.setSql(deleteQuery);			
		Object[] param = new Object[] {m_id};
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
	*/
	public int create(MemberDTO mem) throws SQLException {
		String sql = "INSERT INTO MEMBER (m_id, m_name, m_password, email_id, address, phone) "
					+ "VALUES (S_M_ID.nextval, ?, ?, ?, ?, ?)";		
		Object[] param = new Object[] {mem.getM_name(), mem.getM_password(), 
				mem.getEmail_id(), mem.getAddress(), mem.getPhone()};				
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

	/**
	 * 기존의 사용자 정보를 수정.
	 */
	public int update(MemberDTO user) throws SQLException {
		String sql = "UPDATE MEMBER "
					+ "SET m_name=?, m_password=?, email_id=?, address=?, phone=? "
					+ "WHERE m_id=?";
		Object[] param = new Object[] {user.getM_name(), user.getM_password(), 
				user.getEmail_id(), user.getAddress(), user.getPhone(), user.getM_id()};				
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil에 update문과 매개 변수 설정
			
		try {				
			int result = jdbcUtil.executeUpdate();	// update 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;
	}

	/**
	 * 사용자 ID에 해당하는 사용자를 삭제.
	 */
	public int remove(int userId) throws SQLException {
		String sql = "DELETE FROM MEMBER WHERE m_id=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});	// JDBCUtil에 delete문과 매개 변수 설정

		try {				
			int result = jdbcUtil.executeUpdate();	// delete 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;
	}

	/**
	 * 주어진 사용자 ID에 해당하는 사용자 정보를 데이터베이스에서 찾아 User 도메인 클래스에 
	 * 저장하여 반환.
	 */
	public MemberDTO findUser(String emailId) throws SQLException {
        String sql = "SELECT m_name, m_password, address, phone "
        			+ "FROM MEMBER "
        			+ "WHERE email_id=? ";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {emailId});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {						// 학생 정보 발견
				MemberDTO user = new MemberDTO();	// User 객체를 생성하여 학생 정보를 저장
					user.setM_name(rs.getString("m_name"));
					user.setM_password(rs.getString("m_password"));
					user.setAddress(rs.getString("address"));
					user.setPhone(rs.getString("phone"));
				return user;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}

	/**
	 * 전체 사용자 정보를 검색하여 List에 저장 및 반환
	 */
	public List<MemberDTO> findUserList() throws SQLException {
        String sql = "SELECT m_id, m_name, m_password, email_id, address, phone " 
        		   + "FROM MEMBER "
        		   + "ORDER BY m_Id";
		jdbcUtil.setSqlAndParameters(sql, null);		// JDBCUtil에 query문 설정
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query 실행			
			List<MemberDTO> userList = new ArrayList<MemberDTO>();	// User들의 리스트 생성
			while (rs.next()) {
				MemberDTO user = new MemberDTO(		// User 객체를 생성하여 학생 정보를 저장
						rs.getInt("m_id"),
						rs.getString("m_name"),
						rs.getString("m_password"),
						rs.getString("email_id"),
						rs.getString("address"),
						rs.getString("phone"));
					userList.add(user);
			}		
			return userList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	
	/**
	 * 전체 사용자 정보를 검색한 후 현재 페이지와 페이지당 출력할 사용자 수를 이용하여
	 * 해당하는 사용자 정보만을 List에 저장하여 반환.
	 */
	public List<MemberDTO> findUserList(int currentPage, int countPerPage) throws SQLException {
        String sql = "SELECT m_id, m_name, m_password, email_id, address, phone " 
        		   + "FROM MEMBER "
        		   + "ORDER BY m_id";
		jdbcUtil.setSqlAndParameters(sql, null,					// JDBCUtil에 query문 설정
				ResultSet.TYPE_SCROLL_INSENSITIVE,				// cursor scroll 가능
				ResultSet.CONCUR_READ_ONLY);						
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();				// query 실행			
			int start = ((currentPage-1) * countPerPage) + 1;	// 출력을 시작할 행 번호 계산
			if ((start >= 0) && rs.absolute(start)) {			// 커서를 시작 행으로 이동
				List<MemberDTO> userList = new ArrayList<MemberDTO>();	// User들의 리스트 생성
				do {
					MemberDTO user = new MemberDTO(		// User 객체를 생성하여 학생 정보를 저장
							rs.getInt("m_id"),
							rs.getString("m_name"),
							rs.getString("m_password"),
							rs.getString("email_id"),
							rs.getString("address"),
							rs.getString("phone"));
					userList.add(user);							// 리스트에 User 객체 저장
				} while ((rs.next()) && (--countPerPage > 0));		
				return userList;							
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}

	/**
	 * 주어진 사용자 ID에 해당하는 사용자가 존재하는지 검사 
	 */
	public boolean existingUser(String email_id) throws SQLException {
		String sql = "SELECT count(*) FROM MEMBER WHERE email_id=?";      
		jdbcUtil.setSqlAndParameters(sql, new Object[] {email_id});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {
				int count = rs.getInt(1);
				return (count == 1 ? true : false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return false;
	}

}
