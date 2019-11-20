package controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import service.MemberManager;
import service.UserNotFoundException;
import model.Member;

public class ViewUserController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {			
    	// 로그인 여부 확인
    	
		MemberManager manager = MemberManager.getInstance();
		String userId = request.getParameter("email_id");
		
    	Member member = null;
		member = manager.getMemberByEmail(userId);	// 사용자 정보 검색	
		
		request.setAttribute("member", member);		// 사용자 정보 저장				
		return "/user/view.jsp";				// 사용자 보기 화면으로 이동 수정해야함!!!!!!!!!!!! 지원
    }

	@Override
	public void onlyGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}
}
