package service.dto;

import java.sql.Date;

public class order_pDTO {
	private int order_id = 0;
	private String email_id = null;
	private String order_state = null;
	private Date order_date = null;
	private String address = null;
	private int total_price = 0;
	private String order_name = null;
	private String order_phone = null;
	
	public order_pDTO(int order_id, String email_id, String order_state, Date order_date, String address, int total_price, String order_name, String order_phone) {
		this.order_id = order_id;
		this.email_id = email_id;
		this.order_state = order_state;
		this.email_id = email_id;
		this.order_date = order_date;
		this.address = address;
		this.total_price = total_price;
		this.order_name = order_name;
		this.order_phone = order_phone;
	}
	
	public order_pDTO(String email_id, String order_name, String order_phone, String address, int total_price) {
		this.email_id = email_id;
		this.order_name = order_name;
		this.order_phone = order_phone;
		this.address = address;
		this.total_price = total_price;
	}
	
	public order_pDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getOrder_state() {
		return order_state;
	}
	public void setOrder_state(String order_state) {
		this.order_state = order_state;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	public String getOrder_name() {
		return order_name;
	}
	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}
	public String getOrder_phone() {
		return order_phone;
	}
	public void setOrder_phone(String order_phone) {
		this.order_phone = order_phone;
	}

}
