package persistence.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import persistence.DAOFactory;
import persistence.dao.RecommendationDAO;
import service.dto.RecommendationDTO;

public class RecommendationDAOImpl implements RecommendationDAO {

	private JDBCUtil jdbcUtil = null;		
	
	private static String query = "SELECT , RECOMMENDATION.recomm_time AS RECOMM_Recomm_Time";
		
	public RecommendationDAOImpl() {			
		jdbcUtil = new JDBCUtil();	
	}

	public RecommendationDTO getRecommendationByID(int m_id) {
		
		String searchQuery = query + ", " + "ORDER_P.m_id AS RECOMM_M_ID, " +
					"ORDER_P.order_id AS RECOMM_ORDER_ID  " + 
					"ORDER_DETAIL.order_detail_id AS RECOMM_Order_Detail_ID  " + 
					"FROM RECOMMENDATION, ORDER_DETAIL" +
					"WHERE RECOMMENDATION.m_id = ORDER_P.m_id"; //????????????
		
		jdbcUtil.setSql(searchQuery);				
		Object[] param = new Object[] {m_id};		
		jdbcUtil.setParameters(param);				
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();		
			RecommendationDTO recomm = null;
			if (rs.next()) {						
				recomm = new RecommendationDTO();
				recomm.setM_id(rs.getInt("RECOMM_M_ID"));
				recomm.setOrder_detail_id(rs.getInt("RECOMM_Order_Detail_ID"));
				recomm.setOrder_id(rs.getInt("RECOMM_Order_ID"));
				recomm.setRecomm_time(rs.getDate("RECOMM_Recomm_Time"));
			}
			return recomm;				
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		
		}
		return null;
	}

	
	public int insertRecommendation(RecommendationDTO recomm) {
		int result = 0;
		String insertQuery = "INSERT INTO RECOMMENDATION (m_id, order_detail_id, order_id, recomm_time) " +
							 "VALUES (?, ?, ?, ?) ";
		
		DAOFactory factory = new DAOFactory();			
		
		Object[] param = new Object[] {recomm.getM_id(), recomm.getOrder_detail_id(), 
							recomm.getOrder_id(), recomm.getRecomm_time()};		
		jdbcUtil.setSql(insertQuery);			
		jdbcUtil.setParameters(param);			
				
		try {				
			result = jdbcUtil.executeUpdate();		
			System.out.println(recomm.getM_id() + " 의 추천정보가 삽입되었습니다.");
		} catch (SQLException ex) {
			System.out.println("입력오류 발생!!!");
			if (ex.getErrorCode() == 1)
				System.out.println("동일한 추천정보가 이미 존재합니다."); 
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
	public RecommendationDTO getRecommendationByID(Integer M_ID) {
		// TODO Auto-generated method stub
		return null;
	}

}
