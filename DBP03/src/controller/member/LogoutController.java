package controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;

public class LogoutController implements Controller {
	 public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
			//���ǿ� ����� ����� ���̵� �����ϰ� ������ ��ȿȭ �� 
			HttpSession session = request.getSession();
			session.removeAttribute(UserSessionUtils.USER_SESSION_KEY);
			session.invalidate();		
	        
	        return "redirect:/user/list";
	    }


}
