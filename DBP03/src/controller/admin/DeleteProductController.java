package controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import service.MemberManager;
import service.ProductManager;

public class DeleteProductController {

	private static final Logger log = LoggerFactory.getLogger(DeleteProductController.class);

    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		String deleteId = request.getParameter("product_id");
    	log.debug("Delete Product : {}", deleteId);

    	ProductManager manager = ProductManager.getInstance();		
		HttpSession session = request.getSession();	
	
		if ((UserSessionUtils.isLoginUser("admin", session))) {
				
			manager.delete(deleteId);				// 사용자 정보 삭제
			if (UserSessionUtils.isLoginUser("admin", session))	// 로그인한 사용자가 관리자 	
				return "redirect:/product/list";		// 사용자 리스트로 이동
		}
		           
		return ".jsp";		// 사용자 보기 화면으로 이동 (forwarding)	
	}

}
