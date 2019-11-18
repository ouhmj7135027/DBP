package model;

public class Member {

	private int m_id;
	private String m_name;
	private String m_password;
	private String email_id;
	private String address;
	private String phone;
	

	public Member(int m_id, String m_password, String m_name, String email_id, String phone,String address) {
		this.m_id = m_id;
		this.m_password = m_password;
		this.m_name = m_name;
		this.email_id = email_id;
		this.phone = phone;
		this.address = address;
	}
	
	public void update(Member updateMember) {
        this.m_password = updateMember.m_password;
        this.phone = updateMember.phone;
        this.address = updateMember.address;
    }
	

	public int getM_id() {
		return m_id;
	}
	public void setM_id(int m_id) {
		this.m_id = m_id;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_password() {
		return m_password;
	}
	public void setM_password(String m_password) {
		this.m_password = m_password;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
