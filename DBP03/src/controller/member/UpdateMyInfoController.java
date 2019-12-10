package controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import service.dto.MemberDTO;

import persistence.dao.impl.MemberDAOImpl;
import service.MemberManager;


public class UpdateMyInfoController implements Controller {
   private static final Logger log = LoggerFactory.getLogger(UpdateMyInfoController.class);

   public String execute(HttpServletRequest request, HttpServletResponse response)   throws Exception {
      System.out.println("\n###UpdateMyInfoController -����");
      HttpSession session = request.getSession();
      String id = (String)session.getAttribute("userId");
      
      MemberDAOImpl dao = MemberDAOImpl.getInstance();
   	  MemberDTO m = dao.findUser(id);
  
  	 // request.setAttribute("user", m);
  		
      MemberDTO updatedMember = new MemberDTO(
    		request.getParameter("password"),
  			request.getParameter("name"),
  			request.getParameter("email"),
  			request.getParameter("phone"),
  			request.getParameter("address"));
      log.debug("Update User : {}", updatedMember);
      System.out.println("\n###UpdateMyInfoController - reqȮ��  user:: " + updatedMember.toString());
      MemberManager manager = MemberManager.getInstance();
      manager.update(updatedMember);
      
      return "/user/updated.jsp";      
   }

@Override
public void onlyGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	// TODO Auto-generated method stub
	
}
}
