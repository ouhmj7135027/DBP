package service.dto;

public class cartDTO {

	static int m_id;			
	static int cart_p_num;			
	static int c_price;			
	static int product_id;
	public cartDTO() {
	}
	public cartDTO(int m_id, int cart_p_num, int c_price, int product_id) {
		this.product_id = product_id;
		this.c_price = c_price;
		this.cart_p_num = cart_p_num;
		this.m_id = m_id;
	}
	public static int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public static int getCart_p_num() {
		return cart_p_num;
	}
	public void setCart_p_num(int cart_p_num) {
		this.cart_p_num = cart_p_num;
	}
	public static int getC_price() {
		return c_price;
	}
	public void setC_price(int c_price) {
		this.c_price = c_price;
	}
	public static int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}	
}
