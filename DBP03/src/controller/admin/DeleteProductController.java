package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.member.UserSessionUtils;
import service.MemberManager;
import service.ProductManager;

public class DeleteProductController implements Controller {

	private static final Logger log = LoggerFactory.getLogger(DeleteProductController.class);

    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		int deleteId = Integer.parseInt(request.getParameter("product_id"));
    	log.debug("Delete Product : {}", deleteId);

    	ProductManager manager = ProductManager.getInstance();		
		HttpSession session = request.getSession();	
	
		if ((UserSessionUtils.isLoginUser("admin", session))) {
				
			manager.delete(deleteId);				// 사용자 정보 삭제
			if (UserSessionUtils.isLoginUser("admin", session))	// 로그인한 사용자가 관리자 	
				return "redirect:/admin";		// 사용자 리스트로 이동
		}
		           
		return "/admin/admin_main.jsp";		// 사용자 보기 화면으로 이동 (forwarding)	
	}

	@Override
	public void onlyGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}

}
