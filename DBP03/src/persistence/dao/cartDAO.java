package persistence.dao;

import java.util.List;

import service.dto.cartDTO;

public interface cartDAO {
		
		// StudentDTO 에 담긴 학생정보를 Data Source 에 추가하는 메소드
		public int insertInCart(cartDTO cart);
		
		// 장바구니를 수정하는 메소드
		public int updateInCart(cartDTO cart);
		
		// 장바구니안에 물건을 삭제하는 메소드
		public int deleteInCart(int m_id);

		
		// id에 해당하는 카트정보를 반환하는 메소드
		public List<cartDTO> getCartById(int m_id);
}
