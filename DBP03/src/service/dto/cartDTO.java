package service.dto;

import java.io.Serializable;
import java.util.LinkedList;

public class cartDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int m_id;			
	private int cart_p_num;			
	private int c_price;			
	private int product_id;
	
	//product_id
	private LinkedList<String> codeList = new LinkedList<String>();
	//���� 
	private LinkedList<Integer> numberList = new LinkedList<Integer>();
	//��ٱ��Ͽ� product ���� �߰��ϴ� �޼ҵ�
	public void addItem(String p_id, int num) {
		for (int cnt = 0; cnt < codeList.size(); cnt++) {
			//��ǰ id �� ���� ���
			if (codeList.get(cnt).equals(p_id)) {
				numberList.set(cnt,  numberList.get(cnt) + num);
				return;
				}
			}
		//��ǰ id�� ���� ���
		codeList.add(p_id);
		numberList.add(num);
	}
		
	public String getCode(int index ) {
		return codeList.get(index);
	}
	public int getNumber(int index) {
		return numberList.get(index);
	}
		//��ٱ��Ͽ� �ִ� �׸� �� ���� �޼ҵ�
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
	
	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public int getCart_p_num() {
		return cart_p_num;
	}
	public void setCart_p_num(int cart_p_num) {
		this.cart_p_num = cart_p_num;
	}
	public int getC_price() {
		return c_price;
	}
	public void setC_price(int c_price) {
		this.c_price = c_price;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}	
	
}
