package service.dto;

import java.util.LinkedList;

public class cartDTO {

	static int m_id;			
	static int cart_p_num;			
	static int c_price;			
	static int product_id;
	
	//product_id
		private LinkedList<String> codeList = new LinkedList<String>();
		//수량 (db에 추가해야함)
		private LinkedList<Integer> numberList = new LinkedList<Integer>();
		//장바구니에 product 정보 추가하는 메소드
		public void addItem(String code, int num) {
			for (int cnt = 0; cnt < codeList.size(); cnt++) {
				if (codeList.get(cnt).equals(code)) {
					numberList.set(cnt,  numberList.get(cnt) + num);
					return;
				}
			}
			codeList.add(code);
			numberList.add(num);
		}
		
		public String getCode(int index ) {
			return codeList.get(index);
		}
		public int getNumber(int index) {
			return numberList.get(index);
		}
		//장바구니에 있는 항목 수 리턴 메소드
		public int getSize() {
			return codeList.size();
		}
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
