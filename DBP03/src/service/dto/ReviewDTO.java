package service.dto;
import java.util.Date;

public class ReviewDTO{
	private int m_id;
	private int product_id;
	private String review_id;
	private int rate;
	private String review;
	private Date write_date;
	private String component; 
	String password;
	public ReviewDTO(String m_id, String rate, String component, String review,String password) {
		// TODO Auto-generated constructor stub
		this.m_id = Integer.parseInt(m_id);
		this.rate = Integer.parseInt(rate);
		this.component = component;
		this.review = review;
		this.password = password;
		
		
		
	}
	
	public ReviewDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getReview_id() {
		return review_id;
	}
	public void setReview_id(String review_id) {
		this.review_id = review_id;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public Date getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Date write_date) {
		this.write_date = write_date;
	}
	public String getComponent() {
		return component;
	}
	public void setComponent(String component) {
		this.component = component;
	}
	
	
}