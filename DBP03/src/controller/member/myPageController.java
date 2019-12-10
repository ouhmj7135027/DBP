package controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import service.dto.MemberDTO;

import persistence.dao.impl.MemberDAOImpl;
import service.MemberManager;


public class myPageController implements Controller{
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse resp) throws Exception {
        HttpSession session = request.getSession();
        
        
        String id = (String)session.getAttribute("userId");
        if(id != null) {
        MemberDAOImpl dao = MemberDAOImpl.getInstance();
    	MemberDTO m = dao.findUser(id);
    
    	request.setAttribute("userId", m);
    	
        return "/user/myPageForm.jsp";
        }
		return id;
        
        //else 
        	//return "/user/login/form";
        	
}

	@Override
	public void onlyGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}
}
