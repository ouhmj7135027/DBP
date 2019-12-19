package persistence.dao;

import java.util.List;

import service.dto.order_pDTO;

public interface order_pDAO {
	public int insertOrder_p(order_pDTO ord);
	public int updateOrder_p(order_pDTO ord);
	public int deleteOrder_p(String order_id);
	
	public List<order_pDTO> getOrderListById(int mid);
}
