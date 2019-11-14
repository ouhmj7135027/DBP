package persistence.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistence.DAOFactory;
import persistence.dao.cartDAO;
import service.dto.cartDTO;

public class cartDAOImpl implements cartDAO {
	// StudentDTO �� ��� �л������� Data Source �� �߰��ϴ� �޼ҵ�
	private JDBCUtil jdbcUtil = null;		// JDBCUtil ��ü�� �����ϱ� ���� ����
	private static String query;

	public cartDAOImpl() {	
		jdbcUtil = new JDBCUtil();
	}

	public int insertInCart(cartDTO cart) {
		int result = 0;
		String insertQuery = "INSERT INTO CART (m_id, cart_p_num, c_price, product_id) " +
							 "VALUES (?, ?, ?, ?) ";
		
		DAOFactory factory = new DAOFactory();		// ���������� �а������� �˾ƿ��� ���� DAO ��ü�� �����ϴ� factory ��ü ����
		
		// ����ü �ܺο� �þ�ĳ �޾ƿ���?
		
		// query ���� ����� �Ű����� ���� ���� �Ű����� �迭 ����
		Object[] param = new Object[] {};		
		jdbcUtil.setSql(insertQuery);			// JDBCUtil �� insert �� ����
		jdbcUtil.setParameters(param);			// JDBCUtil �� �Ű����� ����
				
		try {				
			result = jdbcUtil.executeUpdate();		// insert �� ����
			System.out.println();
		} catch (SQLException ex) {
			System.out.println("�Է¿��� �߻�!!!");
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection ��ȯ
		}		
		return result;		// insert �� ���� �ݿ��� ���ڵ� �� ��ȯ	
			
	}

	@Override
	public int updateInCart(cartDTO stu) {
		// TODO Auto-generated method stub
		int result = 0;
		String insertQuery = "INSERT INTO CART (c_id,m_id, cart_p_num, c_price, product_id) " +
							 "VALUES (?,?, ?, ?, ?) ";
		
		DAOFactory factory = new DAOFactory();		// ���������� �а������� �˾ƿ��� ���� DAO ��ü�� �����ϴ� factory ��ü ����
		
		// �ܺο��� ��� �޾ƿ����� �𸣰ھ�......
		
		// query ���� ����� �Ű����� ���� ���� �Ű����� �迭 ����
		Object[] param = new Object[] {};		
		jdbcUtil.setSql(insertQuery);			// JDBCUtil �� insert �� ����
		jdbcUtil.setParameters(param);			// JDBCUtil �� �Ű����� ����
				
		try {				
			result = jdbcUtil.executeUpdate();		// insert �� ����
			System.out.println();
		} catch (SQLException ex) {
			System.out.println("�Է¿��� �߻�!!!");
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection ��ȯ
		}		
		return result;		// insert �� ���� �ݿ��� ���ڵ� �� ��ȯ	
			

	}

	@Override
	public int deleteInCart(int c_id) {
		// TODO Auto-generated method stub
		String deleteQuery = "DELETE FROM CART WHERE C_ID = ?";
		
		jdbcUtil.setSql(deleteQuery);			// JDBCUtil �� query �� ����
		Object[] param = new Object[] {c_id};
		jdbcUtil.setParameters(param);			// JDBCUtil �� �Ű����� ����
		
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

	@Override
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
			
			// ��ٱ��ϸ� �����ϴ� �޼ҵ�
	


