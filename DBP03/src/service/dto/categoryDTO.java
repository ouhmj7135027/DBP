package service.dto;

public class categoryDTO {
	private int category_id;
	private String c_name;
	private String c_detail;
	
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_detail() {
		return c_detail;
	}
	public void setC_detail(String c_detail) {
		this.c_detail = c_detail;
	}
}
