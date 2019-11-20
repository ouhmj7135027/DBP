package service;

import java.sql.SQLException;
import java.util.List;

import model.Member;
import model.service.PasswordMismatchException;
import model.service.UserNotFoundException;
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
	public Member getMember(String email) {
		// TODO Auto-generated method stub
		return dao.getMemberByEmail(email);
	} //변경 지원

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
	
	public boolean login(String userId, String password)
			throws SQLException, UserNotFoundException, PasswordMismatchException {
			Member mem = getMemberByEmail(userId);

			if (!mem.matchPassword(password)) {
				throw new PasswordMismatchException("비밀번호가 일치하지 않습니다.");
			}
			return true;
		}
}
