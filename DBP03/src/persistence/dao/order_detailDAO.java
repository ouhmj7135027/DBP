package persistence.dao;

import service.dto.order_detailDTO;

public interface order_detailDAO {
	public int insertOrder_detail(order_detailDTO ord_d);
	public int updateOrder_detail(order_detailDTO ord_d);
	public int deleteOrder_detail(String order_detail_id);

}
