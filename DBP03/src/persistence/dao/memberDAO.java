package persistence.dao;

import java.util.List;

import service.dto.MemberDTO;

public interface memberDAO {
	public List<MemberDTO> getMemberList();
	public MemberDTO getMemberByEmail(String email);
	public int insertMember(MemberDTO mem);
	public int updateMember(MemberDTO mem);
	public int deleteMember(int m_id);
}