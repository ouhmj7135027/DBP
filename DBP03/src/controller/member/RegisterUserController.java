package controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Member;
import model.service.ExistingUserException;
import service.MemberManager;
import service.dto.MemberDTO;

public class RegisterUserController implements Controller {
    private static final Logger log = LoggerFactory.getLogger(RegisterUserController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	MemberDTO member = new MemberDTO(
			request.getParameter("password"),
			request.getParameter("name"),
			request.getParameter("email"),
			request.getParameter("phone"),
			request.getParameter("address"));
		
        log.debug("Create Member : {}", member);

		try {
			MemberManager manager = MemberManager.getInstance();
			manager.create(member);
	        return "redirect:/main";		// 성공 시 main화면으로 redirect
	        
		} catch (model.service.ExistingUserException e) {		// 예외 발생 시 회원가입 form으로 forwarding
            request.setAttribute("registerFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("member", member);
			return "/user/loginForm.jsp";
		}
    }

	@Override
	public void onlyGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}
}

