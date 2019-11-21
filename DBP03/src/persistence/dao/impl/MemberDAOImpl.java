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
		jdbcUtil = new JDBCUtil();	// JDBCUtil ��ü ����
	}
	
	   
	private static String query = 	"SELECT Member.m_id AS MEM_ID, " +
				"Member.m_name AS MEM_NAME, " +
				"Member.m_password AS MEM_PWD, " +
				"Member.email_id AS MEM_EMAIL, " +
				"Member.address AS MEM_ADDRESS " +
				"Member.phone AS MEM_PHONE " +
				"FROM Member ";
	
	
	
	public List<MemberDTO> getMemberList() {
		// TODO Auto-generated method stub
		jdbcUtil.setSql(query);		// JDBCUtil �� query ����
		
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
			 // dto��ſ� model�� ����ϴ� ������ ������  ����
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
			System.out.println(mem.getEmail_id() + " ���̵��� ȸ�������� ���ԵǾ����ϴ�.");
		} catch (SQLException ex) {
			System.out.println("�Է¿��� �߻�!!!");
			if (ex.getErrorCode() == 1)
				System.out.println("������ ȸ�������� �̹� �����մϴ�."); 
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

}
