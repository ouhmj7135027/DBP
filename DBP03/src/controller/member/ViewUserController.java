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
    	// �α��� ���� Ȯ��
    	
		MemberManager manager = MemberManager.getInstance();
		String userId = request.getParameter("email_id");
		
    	Member member = null;
		member = manager.getMemberByEmail(userId);	// ����� ���� �˻�	
		
		request.setAttribute("member", member);		// ����� ���� ����				
		return "/user/view.jsp";				// ����� ���� ȭ������ �̵� �����ؾ���!!!!!!!!!!!! ����
    }

	@Override
	public void onlyGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}
}
