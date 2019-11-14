package service.dto;

public class productDTO {
	private int product_id = 0;
	private String effect = null;
	private String p_name = null;
	private int p_price = 0;
	private int sales = 0;
	private int category_id = 0;
	private int category_age_id = 0;
	
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public int getCategory_age_id() {
		return category_age_id;
	}
	public void setCategory_age_id(int category_age_id) {
		this.category_age_id = category_age_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getEffect() {
		return effect;
	}
	public void setEffect(String effect) {
		this.effect = effect;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public int getP_price() {
		return p_price;
	}
	public void setP_price(int p_price) {
		this.p_price = p_price;
	}
	public int getSales() {
		return sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
	


}
