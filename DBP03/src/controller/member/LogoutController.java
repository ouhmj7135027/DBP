package controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;

public class LogoutController implements Controller {
	 public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
			//세션에 저장된 사용자 이이디를 삭제하고 세션을 무효화 함 
			HttpSession session = request.getSession();
			session.removeAttribute(UserSessionUtils.USER_SESSION_KEY);
			session.invalidate();		
	        
	        return "redirect:/main";
	    }

	@Override
	public void onlyGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}


}
