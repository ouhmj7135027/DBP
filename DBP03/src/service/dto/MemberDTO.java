package service.dto;

import model.Member;

public class MemberDTO {

	private int m_id = 0;
	private String m_name = null;
	private String m_password = null;
	private String email_id = null;
	private String address = null;
	private String phone = null;

	
	public MemberDTO(int userId, String m_password, String m_name, String email_id, String phone,String address) {
		this.m_id = userId;
		this.m_password = m_password;
		this.m_name = m_name;
		this.email_id = email_id;
		this.phone = phone;
		this.address = address;
	}
	public MemberDTO( String email_id,String m_password, String m_name, String address,String phone) {
		this.m_password = m_password;
		this.m_name = m_name;
		this.email_id = email_id;
		this.phone = phone;
		this.address = address;
	}
	public MemberDTO() {
		
	}
	
	public void update(Member updateMember) {
        this.m_password = updateMember.getM_password();
        this.phone = updateMember.getPhone();
        this.address = updateMember.getAddress();
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
	public boolean matchPassword(String password) {
		if (password == null) {
			return false;
		}
		return this.m_password.equals(password);
	}
	
	public boolean isSameUser(int userid) {
        return this.m_id == userid;
    }
	
	
}
