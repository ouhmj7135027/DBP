package service;

import java.util.List;
import persistence.DAOFactory;
import persistence.dao.MemberDAO;
import service.dto.MemberDTO;

public class MemberServiceImpl implements MemberService {

	private MemberDAO dao = null;
	public MemberServiceImpl() {								// DAOFactory 클래스의 객체 생성
		DAOFactory factory = new DAOFactory();
		dao = factory.getMemberDAO();
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

}
