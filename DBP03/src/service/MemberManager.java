package service;

import java.util.List;

import model.Member;
import persistence.DAOFactory;
import persistence.dao.MemberDAO;
import service.dto.MemberDTO;

public class MemberManager implements MemberService {
	private static MemberManager mem = new MemberManager();
	private MemberDAO dao = null;
	public MemberManager() {								// DAOFactory 클래스의 객체 생성
		DAOFactory factory = new DAOFactory();
		dao = factory.getMemberDAO();
	}
	public static MemberManager getInstance() {
		return mem;
	}
	@Override
	public List<MemberDTO> ListingMembers() {
		// TODO Auto-generated method stub
		return dao.getMemberList();
	}

	@Override
	public MemberDTO getMember(String email) {
		// TODO Auto-generated method stub
		return dao.getMemberByEmail(email);
	}

	@Override
	public int insertMember(MemberDTO mem) {
		// TODO Auto-generated method stub
		return dao.insertMember(mem);
	}

	@Override
	public int updateMember(MemberDTO mem) {
		// TODO Auto-generated method stub
		return dao.updateMember(mem);
	}

	@Override
	public int deleteMember(int m_id) {
		// TODO Auto-generated method stub
		return dao.deleteMember(m_id);
	}
	public Member getMemberByEmail(String m_email) {
		// TODO Auto-generated method stub
		return dao.getMemberByEmail(m_email);
	}

}
