package service.dto;
import java.util.Date;

public class RecommendationDTO{
	private int m_id;
	private int order_detail_id;
	private int order_id;
	public Date recomm_time;
	
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public int getOrder_detail_id() {
		return order_detail_id;
	}
	public void setOrder_detail_id(int order_detail_id) {
		this.order_detail_id = order_detail_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public Date getRecomm_time() {
		return recomm_time;
	}
	public void setRecomm_time(Date recomm_time) {
		this.recomm_time = recomm_time;
	}
	
}