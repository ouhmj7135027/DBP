package persistence.dao;

import java.util.List;

import service.dto.cartDTO;

public interface cartDAO {
		
		// StudentDTO �� ��� �л������� Data Source �� �߰��ϴ� �޼ҵ�
		public int insertInCart(cartDTO cart);
		
		// ��ٱ��ϸ� �����ϴ� �޼ҵ�
		public int updateInCart(cartDTO cart);
		
		// ��ٱ��Ͼȿ� ������ �����ϴ� �޼ҵ�
		public int deleteInCart(int m_id);

		
		// id�� �ش��ϴ� īƮ������ ��ȯ�ϴ� �޼ҵ�
		public List<cartDTO> getCartById(int m_id);
}
