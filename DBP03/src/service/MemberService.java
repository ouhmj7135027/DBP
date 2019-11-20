package service;

import java.util.List;

import model.Member;
import service.dto.MemberDTO;

public interface MemberService {
	public List<MemberDTO> ListingMembers();
	public Member getMember(String email);
	public int insertMember(MemberDTO mem);
	public int updateMember(MemberDTO mem);
	public int deleteMember(int m_id);
}
