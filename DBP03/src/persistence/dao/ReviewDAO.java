package persistence.dao;

import java.util.List;
import service.dto.ReviewDTO;

public interface ReviewDAO {
	public List<ReviewDTO> getRecommendationList ();
			
	public int insertReview (ReviewDTO rev);
	public int updateReview (ReviewDTO rev);
	public int deleteReview (ReviewDTO review_id);

	public ReviewDTO getReviewByID(String review_id);
}
