package persistence.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Member;
import service.dto.MemberDTO;

public interface MemberDAO {

	
	public List<MemberDTO> getMemberList();
	public Member getMemberByEmail(String email);
	public int insertMember(MemberDTO mem);
	public int updateMember(MemberDTO mem);
	public int deleteMember(int m_id);

	public MemberDTO findUser(String emailId);
}