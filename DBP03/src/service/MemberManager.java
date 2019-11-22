package service;

import java.sql.SQLException;
import java.util.List;

import model.Member;
import model.service.ExistingUserException;
import model.service.PasswordMismatchException;
import model.service.UserNotFoundException;
import persistence.DAOFactory;
import persistence.dao.MemberDAO;
import persistence.dao.impl.MemberDAOImpl;
import service.dto.MemberDTO;

/*public class MemberManager implements MemberService {
	private static MemberManager mem = new MemberManager();
	private MemberDAOImpl dao = null;
	
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
}*/
public class MemberManager {
	private static MemberManager userMan = new MemberManager();
	private MemberDAOImpl userDAO;
	//private UserAnalysis userAanlysis;

	private MemberManager() {
		try {
			userDAO = new MemberDAOImpl();
			//userAanlysis = new UserAnalysis(userDAO);
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public static MemberManager getInstance() {
		return userMan;
	}
	
	//안되면 MemberDTO.getM_id()로..?
	public int create(MemberDTO user) throws SQLException, ExistingUserException {
		if (userDAO.existingUser(user.getM_id()) == true) {
			throw new ExistingUserException(user.getM_id() + "는 존재하는 아이디입니다.");
		}
		return userDAO.create(user);
	}

	public int update(MemberDTO user) throws SQLException {
		return userDAO.update(user);
	}	

	public int remove(int userId) throws SQLException {
		return userDAO.remove(userId);
	}

	public MemberDTO findUser(String emailId)
		throws SQLException, UserNotFoundException {
		MemberDTO user = userDAO.findUser(emailId);
		
		if (user == null) {
			throw new UserNotFoundException(emailId + "는 존재하지 않는 아이디입니다.");
		}		
		return user;
	}

	public List<MemberDTO> findUserList() throws SQLException {
			return userDAO.findUserList();
	}
	
	public List<MemberDTO> findUserList(int currentPage, int countPerPage)
		throws SQLException {
		return userDAO.findUserList(currentPage, countPerPage);
	}

	public boolean login(String emailId, String password)
		throws SQLException, UserNotFoundException, PasswordMismatchException {
		MemberDTO user = findUser(emailId);

		if (!user.matchPassword(password)) {
			throw new PasswordMismatchException("비밀번호가 일치하지 않습니다.");
		}
		return true;
	}

	
	public MemberDAOImpl getUserDAO() {
		return this.userDAO;
	}
}

