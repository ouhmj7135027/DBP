package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberManager;

public class MemberLoginController {

	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	    	String userId = request.getParameter("userId");
			String password = request.getParameter("password");
			
			try {
				// �𵨿� �α��� ó���� ����
				MemberManager manager = MemberManager.getInstance();
				manager.login(userId, password);
		
				// ���ǿ� ����� ���̵� ����
				HttpSession session = request.getSession();
	            session.setAttribute(UserSessionUtils.USER_SESSION_KEY, userId);
	            
	            return "redirect:Main.jsp";			
			} catch (Exception e) {
				/* UserNotFoundException�̳� PasswordMismatchException �߻� ��
				 * �ٽ� login form�� ����ڿ��� �����ϰ� ���� �޼����� ���
				 */
	            request.setAttribute("loginFailed", true);
				request.setAttribute("exception", e);
	            return "user/loginForm.jsp";			
			}	
	    }
	
	
}
