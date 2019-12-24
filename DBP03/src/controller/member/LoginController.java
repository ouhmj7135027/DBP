package controller.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import persistence.dao.impl.MemberDAOImpl;
import service.MemberManager;
import service.ProductManager;
import service.dto.MemberDTO;
import service.dto.productDTO;

public class LoginController implements Controller {
	
	private MemberDAOImpl memDAO = new MemberDAOImpl();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		List<productDTO> pList;
		
		try {
			// �𵨿� �α��� ó���� ����
			ProductManager pmanager = ProductManager.getInstance();
			 if (userId.equals("admin") && password.equals("admin")) {
 				// ���� �α����� ����ڰ� ���� ��� ������̰ų� �������� ��� -> ���� ����
 								
 				pList = pmanager.ListingProductsInfo();	// Ŀ�´�Ƽ ����Ʈ �˻�
 				request.setAttribute("pList", pList);	
 				
 				return "/admin/admin_main.jsp";   // �˻��� ����� ������ update form���� ����     
 			} 
			 
			MemberManager manager = MemberManager.getInstance();
			manager.login(userId, password);
			MemberDTO mem = manager.findUser(userId);
	
			ProductManager p_manager = new ProductManager();
			List<productDTO> slist = p_manager.getSalesList();
			request.setAttribute("saleList", slist);
			
			// ���ǿ� ����� ���̵� ����
			HttpSession session = request.getSession();
			session.setAttribute(UserSessionUtils.USER_SESSION_KEY, userId);
			session.setAttribute(UserSessionUtils.USER_M_ID, mem.getM_id());
			request.setAttribute("id", userId);
			
            return "/main";			
		
		}catch (Exception e) {
		
			/* UserNotFoundException�̳� PasswordMismatchException �߻� ��
			 * �ٽ� login form�� ����ڿ��� �����ϰ� ���� �޼����� ���
			 */
            request.setAttribute("loginFailed", true);
			request.setAttribute("exception", e);
            return "/user/loginForm.jsp";			
		}	
    }

	@Override
	public void onlyGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}
}
