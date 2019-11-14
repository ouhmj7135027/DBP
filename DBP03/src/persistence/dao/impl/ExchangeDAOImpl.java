package persistence.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistence.dao.ExchangeDAO;
import service.dto.ExchangeDTO;
import service.dto.MemberDTO;

public class ExchangeDAOImpl implements ExchangeDAO {
	

	private JDBCUtil jdbcUtil = null;
	
	private static String query = 	"SELECT Exchange.exchange_id AS EX_ID, " +
				"Exchange.exchange_date AS EX_DATE, " +
				"Exchange.exchange_status AS EX_STATUS ";
	
	public ExchangeDAOImpl() {			
		jdbcUtil = new JDBCUtil();
	}

	@Override
	public List<ExchangeDTO> getExchangeList() {
		// TODO Auto-generated method stub
		String allQuery = query + ", " + "Exchange.m_id AS EX_M_ID, " +
					"Exchange.order_id AS EX_ORDER_ID  " + 
					"Exchange.total_price AS EX_TOTAL_PRICE  " +
				    "FROM EXCHANGE ";		
		jdbcUtil.setSql(allQuery);
		
		try { 
			ResultSet rs = jdbcUtil.executeQuery();			
			List<ExchangeDTO> list = new ArrayList<ExchangeDTO>();	
			while (rs.next()) {	
				ExchangeDTO dto = new ExchangeDTO();		
				dto.setExchange_id(rs.getString("EX_ID"));
				dto.setM_id(rs.getInt("EX_M_ID"));
				dto.setExchange_date(rs.getDate("EX_DATE"));
				dto.setExchange_status(rs.getString("EX_STATUS"));
				dto.setOrder_id(rs.getInt("EX_ORDER_ID"));
				dto.setTotal_price(rs.getInt("EX_TOTAL_PRICE"));
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

	@Override
	public ExchangeDTO getExchangeById(String exchange_id) {
		// TODO Auto-generated method stub
		String searchQuery = query + ", " + "ORDER_P.m_id AS EX_M_ID, " +
					"ORDER_P.order_id AS EX_ORDER_ID  " + 
					"ORDER_P.total_price AS EX_TOTAL_PRICE  " +
			        "FROM EXCHANGE, ORDER_P " +
			        "WHERE EXCHANGE.exchange_id = ? AND " +
			        "EXCHANGE.m_id = ORDER_P.m_id "; //애매함
			         
		jdbcUtil.setSql(searchQuery);		
		Object[] param = new Object[] { exchange_id };		
		jdbcUtil.setParameters(param);				
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();		
			ExchangeDTO dto = null;
			while (rs.next()) {	
				dto = new ExchangeDTO();		
				dto.setExchange_id(rs.getString("EX_ID"));
				dto.setM_id(rs.getInt("EX_M_ID"));
				dto.setExchange_date(rs.getDate("EX_DATE"));
				dto.setExchange_status(rs.getString("EX_STATUS"));
				dto.setOrder_id(rs.getInt("EX_ORDER_ID"));
				dto.setTotal_price(rs.getInt("EX_TOTAL_PRICE"));
			}
			return dto;				
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		
		}
		return null;
	}

	@Override
	public int insertExchange(ExchangeDTO exchange) {
		// TODO Auto-generated method stub
		int result = 0;
		String insertQuery = "INSERT INTO EXCHANGE (exchange_id, m_id, exchange_date, exchange_status, order_id, total_price) " +
							 "VALUES (?, ?, ?, ?, ?, ?) ";
		
		
		Object[] param = new Object[] {exchange.getExchange_id(), exchange.getM_id(), exchange.getExchange_date(), 
				exchange.getExchange_status(), exchange.getOrder_id(), exchange.getTotal_price()};		
		jdbcUtil.setSql(insertQuery);			
		jdbcUtil.setParameters(param);			
				
		try {				
			result = jdbcUtil.executeUpdate();		
			System.out.println(exchange.getExchange_id() + " 의 교환정보가 삽입되었습니다.");
		} catch (SQLException ex) {
			System.out.println("입력오류 발생!!!");
			if (ex.getErrorCode() == 1)
				System.out.println("동일한 교환정보가 이미 존재합니다."); 
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();		
		}		
		return result;		
	}

	@Override
	public int deleteExchange(int exchange_id) {
		// TODO Auto-generated method stub
		String deleteQuery = "DELETE FROM EXCHANGE WHERE exchange_id = ?";
		
		jdbcUtil.setSql(deleteQuery);			
		Object[] param = new Object[] {exchange_id};
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
