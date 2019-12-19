package persistence.dao;

import java.util.List;

import service.dto.order_detailDTO;

public interface order_detailDAO {
	public int insertOrder_detail(order_detailDTO order_detail);
	public int updateOrder_detail(order_detailDTO ord_d);
	public int deleteOrder_detail(String order_detail_id);
	
	public List<order_detailDTO> getOrderViewById(int oid);
}
