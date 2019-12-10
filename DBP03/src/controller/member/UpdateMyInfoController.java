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
      System.out.println("\n###UpdateMyInfoController -µé¾î¿È");
      HttpSession session = request.getSession();
     
  		
      MemberDTO updatedMember = new MemberDTO(
    		session.getAttribute("userId").toString(),
    		request.getParameter("password"),
  			request.getParameter("name"),
  			request.getParameter("address"),
  			request.getParameter("phone"));
  			
      log.debug("Update User : {}", updatedMember);
      System.out.println("\n###UpdateMyInfoController - reqÈ®ÀÎ  user:: " + updatedMember.toString());
      System.out.println("request.getParameter(\"password\") =" + request.getParameter("password"));
      System.out.println("request.getParameter(\"email\") =" + request.getParameter("email"));
      System.out.println("updated pw =" + updatedMember.getM_password());
      System.out.println("updated id =" + updatedMember.getEmail_id());
      MemberManager manager = MemberManager.getInstance();
      manager.update(updatedMember);
      
      return "/user/updated.jsp";      
   }

@Override
public void onlyGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	// TODO Auto-generated method stub
	
}
}
