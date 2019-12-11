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
		
		try {
			// 모델에 로그인 처리를 위임
			ProductManager pmanager = ProductManager.getInstance();
			 if (userId.equals("admin") && password.equals("admin")) {
 				// 현재 로그인한 사용자가 수정 대상 사용자이거나 관리자인 경우 -> 수정 가능
 								
 				List<productDTO> pList = pmanager.ListingProductsInfo();	// 커뮤니티 리스트 검색
 				request.setAttribute("pList", pList);	
 				
 				return "/admin/admin_main.jsp";   // 검색한 사용자 정보를 update form으로 전송     
 			} 
			 
			MemberManager manager = MemberManager.getInstance();
			manager.login(userId, password);
	
			// 세션에 사용자 이이디 저장
			HttpSession session = request.getSession();
			session.setAttribute(UserSessionUtils.USER_SESSION_KEY, userId);
			request.setAttribute("id", userId);
            
            return "redirect:/main";			
		
		}catch (Exception e) {
		
			/* UserNotFoundException이나 PasswordMismatchException 발생 시
			 * 다시 login form을 사용자에게 전송하고 오류 메세지도 출력
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
