package service.dto;

import java.util.Date;

public class ExchangeDTO {

	private String exchange_id;
	private int m_id;
	private Date exchange_date;
	private String exchange_status;
	private int order_id;
	private int total_price;
	public String getExchange_id() {
		return exchange_id;
	}
	public void setExchange_id(String exchange_id) {
		this.exchange_id = exchange_id;
	}
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public Date getExchange_date() {
		return exchange_date;
	}
	public void setExchange_date(Date exchange_date) {
		this.exchange_date = exchange_date;
	}
	public String getExchange_status() {
		return exchange_status;
	}
	public void setExchange_status(String exchange_status) {
		this.exchange_status = exchange_status;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	
	
	
}
