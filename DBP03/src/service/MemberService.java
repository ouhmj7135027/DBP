package service;

import java.util.List;

import service.dto.MemberDTO;

public interface MemberService {
	public List<MemberDTO> ListingMembers();
	public MemberDTO getMember(String email);
	public int insertMember(MemberDTO mem);
	public int updateMember(MemberDTO mem);
	public int deleteMember(int m_id);
}
