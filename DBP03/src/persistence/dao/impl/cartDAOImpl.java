package persistence.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistence.DAOFactory;
import persistence.dao.cartDAO;

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
		
		// ProfDAO ��ü�� �����Ͽ� �л������� ���ԵǾ� �ִ� ���������� �����ڵ带 �˾ƿ�
		cartDAO cartDAO = factory.getCartDAO();		// factory �� ���� ������ ���� DAO ȹ��
		cartDTO cartDTO = cartDAO.getProfByName(stu.getProfName());		// ���� DAO �� �̸��� ����Ͽ� �����ڵ带 ������ �޼ҵ� ���
		String pCode = profDTO.getPCode();		// �����ڵ带 ����
		if (pCode == null) {
			System.out.println("�ش� ���������� �����ϴ�." + stu.getProfName());
			return 0;
		}
		
		// DeptDAO ��ü�� �����Ͽ� �л������� ���ԵǾ� �ִ� �а��� �а��ڵ带 �˾ƿ�
		DeptDAO deptDAO = factory.getDeptDAO();		// factory �� ���� �а��� ���� DAO ȹ��
		DeptDTO deptDTO = deptDAO.getDeptByName(stu.getDept());		// �а� DAO �� �а����� ����Ͽ� �а��ڵ带 ������ �޼ҵ� ���
		String dCode = deptDTO.getDCode();			// �а��ڵ带 ����
		if (dCode == null) {
			System.out.println("�ش� �а��� �����ϴ�.");
			return 0;
		}
		// query ���� ����� �Ű����� ���� ���� �Ű����� �迭 ����
		Object[] param = new Object[] {stu.getStuNo(), stu.getStuName(), 
							stu.getPwd(), stu.getStuPhoneNo(), stu.getYear(), pCode, dCode};		
		jdbcUtil.setSql(insertQuery);			// JDBCUtil �� insert �� ����
		jdbcUtil.setParameters(param);			// JDBCUtil �� �Ű����� ����
				
		try {				
			result = jdbcUtil.executeUpdate();		// insert �� ����
			System.out.println(stu.getStuNo() + " �й��� �л������� ���ԵǾ����ϴ�.");
		} catch (SQLException ex) {
			System.out.println("�Է¿��� �߻�!!!");
			if (ex.getErrorCode() == 1)
				System.out.println("������ �л������� �̹� �����մϴ�."); 
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();		// ResultSet, PreparedStatement, Connection ��ȯ
		}		
		return result;		// insert �� ���� �ݿ��� ���ڵ� �� ��ȯ	
			
	}
			
			// ��ٱ��ϸ� �����ϴ� �޼ҵ�
	public int updateInCart(cartDTO cart) {}
			
			// ��ٱ��Ͼȿ� ������ �����ϴ� �޼ҵ�
	public int deleteInCart(int m_id, int p_id) {}
			
			// id�� �ش��ϴ� īƮ������ ��ȯ�ϴ� �޼ҵ�
	public List<cartDTO> getCartById(int m_id){}

}
