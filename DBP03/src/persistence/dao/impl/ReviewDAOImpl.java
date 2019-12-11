package persistence.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistence.DAOFactory;
import persistence.dao.ReviewDAO;
import service.dto.ReviewDTO;

public class ReviewDAOImpl implements ReviewDAO {

	private JDBCUtil jdbcUtil = null;		
	

	private static String query = "SELECT, REVIEW.review_id AS REVIEW_Review_Id, " +
								         "REVIEW.rate AS REVIEW_Rate, " +
								         "REVIEW.review AS REVIEW_Review, " +
								         "REVIEW.write_date AS REVIEW_Write_Date";		
		
	public ReviewDAOImpl() {			
		jdbcUtil = new JDBCUtil();		
	}
	
	
	public List<ReviewDTO> getReviewList() {
		
		String allQuery = query + ", " + "REVIEW.m_id AS REVIEW_M_ID, " +
		         "REVIEW.poduct_id AS REVIEW_Product_id, " +
		         "REVIEW.review_id AS REVIEW_Review_Id, " +
		         "REVIEW.rate AS REVIEW_Rate, " +
		         "REVIEW.review AS REVIEW_Review, " +
		         "REVIEW.write_date AS REVIEW_Write_Date" +		 
				"FROM REVIEW";		
		jdbcUtil.setSql(allQuery);		
		
		try { 
			ResultSet rs = jdbcUtil.executeQuery();		
			List<ReviewDTO> list = new ArrayList<ReviewDTO>();		
			while (rs.next()) {	
				ReviewDTO dto = new ReviewDTO();		
				dto.setM_id(rs.getInt("REVIEW_M_ID"));
				dto.setProduct_id(rs.getInt("REVIEW_Product_ID"));
				dto.setReview_id(rs.getString("REVIEW_Review_ID"));
				dto.setRate(rs.getInt("REVIEW_Rate"));
				dto.setReview(rs.getString("REVIEW_Review"));
				dto.setWrite_date(rs.getDate("REVIEW_Write_Date"));
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

	
	public ReviewDTO getReviewByID(String review_id) {
	
		String searchQuery = query + ", " + "REVIEW.m_id AS REVIEW_M_ID, " +
		         							"REVIEW.poduct_id AS REVIEW_Product_id, " +
		         							"REVIEW.review_id AS REVIEW_Review_Id, " +
		         							"REVIEW.rate AS REVIEW_Rate, " +
		         							"REVIEW.review AS REVIEW_Review, " +
		         							"REVIEW.write_date AS REVIEW_Write_Date" +		 
		         							"FROM REVIEW";	//????????	
		jdbcUtil.setSql(searchQuery);				
		Object[] param = new Object[] { review_id };		
		jdbcUtil.setParameters(param);				
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();		
			ReviewDTO rev = null;
			if (rs.next()) {						
				rev = new ReviewDTO();
				rev.setM_id(rs.getInt("REVIEW_M_ID"));
				rev.setProduct_id(rs.getInt("REVIEW_Product_ID"));
				rev.setReview_id(rs.getString("REVIEW_Review_ID"));
				rev.setRate(rs.getInt("REVIEW_Rate"));
				rev.setReview(rs.getString("REVIEW_Review"));
				rev.setWrite_date(rs.getDate("REVIEW_Write_Date"));
			}
			return rev;				
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		
		}
		return null;
	}

	
	public int insertReview(ReviewDTO rev) {
		int result = 0;
		String insertQuery = "INSERT INTO REVIEW (m_id, product_id, review_id, rate, review, write_date) " +
							 "VALUES (?, ?, S_REVIEW_ID.nextval, ?, ?, ) ";
		
		
		Object[] param = new Object[] {rev.getM_id(), rev.getProduct_id(), 
				rev.getRate(), rev.getReview(), rev.getWrite_date()};		
		jdbcUtil.setSql(insertQuery);			
		jdbcUtil.setParameters(param);			
				
		try {				
			result = jdbcUtil.executeUpdate();		
			System.out.println(rev.getM_id() + " 의 리뷰정보가 삽입되었습니다.");
		} catch (SQLException ex) {
			System.out.println("입력오류 발생!!!");
			if (ex.getErrorCode() == 1)
				System.out.println("동일한 리뷰정보가 이미 존재합니다."); 
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {		
			jdbcUtil.commit();
			jdbcUtil.close();		
		}		
		return result;		
	}
	
	public int update(ReviewDTO rev) {
		
		String updateQuery = "UPDATE REVIEW SET ";
		int index = 0;
		Object[] tempParam = new Object[10];		
		
		if (rev.getM_id() != 0) {		
			updateQuery += "m_id = ?, ";		
			tempParam[index++] = rev.getM_id();		
		}
		if (rev.getProduct_id() != 0) {		
			updateQuery += "product_id = ?, ";		
			tempParam[index++] = rev.getProduct_id();		
		}
		if (rev.getReview_id() != null) {		
			updateQuery += "review_id = ?, ";		
			tempParam[index++] = rev.getReview_id();		
		}
		if (rev.getRate() != 0) {		
			updateQuery += "rate = ?, ";		
			tempParam[index++] = rev.getRate();		
		}
		if (rev.getReview() != null) {		
			updateQuery += "review = ?, ";		
			tempParam[index++] = rev.getReview();		
		}
		if (rev.getWrite_date() != null) {		
			updateQuery += "write_date = ?, ";		
			tempParam[index++] = rev.getWrite_date();		
		}
		updateQuery += "WHERE m_id = ? ";		
		updateQuery = updateQuery.replace(", WHERE", " WHERE");		
		
		tempParam[index++] = rev.getM_id();		
		
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
	
	public int deleteReview(String review_id) {
		String deleteQuery = "DELETE FROM REVIEW WHERE review_id = ?";
		
		jdbcUtil.setSql(deleteQuery);			
		Object[] param = new Object[] {review_id};
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


	@Override
	public List<ReviewDTO> getRecommendationList() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int updateReview(ReviewDTO rev) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int deleteReview(ReviewDTO review_id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
