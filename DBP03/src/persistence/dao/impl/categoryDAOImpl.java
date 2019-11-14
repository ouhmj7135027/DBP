package persistence.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistence.DAOFactory;
import persistence.dao.categoryDAO;


public class categoryDAOImpl implements categoryDAO{
	
	private JDBCUtil jdbcUtil = null;
	public categoryDAOImpl() {
		jdbcUtil = new JDBCUtil();
	}
	
	@Override
	public List<Integer> getCategoryId() {
		String query  = "select c_id from category";
		
		jdbcUtil.setSql(query);
	
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List <Integer> list = null;
			while (rs.next()) {
				
				list.add(rs.getInt("c_id"));
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
