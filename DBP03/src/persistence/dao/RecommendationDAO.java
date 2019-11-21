package persistence.dao;

import service.dto.RecommendationDTO;

public interface RecommendationDAO {
	public RecommendationDTO getRecommendationByID(Integer M_ID);
	
	public int insertRecommendation (RecommendationDTO Recommendation);
	
}
