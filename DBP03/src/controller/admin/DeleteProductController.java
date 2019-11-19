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
				
			manager.delete(deleteId);				// ����� ���� ����
			if (UserSessionUtils.isLoginUser("admin", session))	// �α����� ����ڰ� ������ 	
				return "redirect:/product/list";		// ����� ����Ʈ�� �̵�
		}
		           
		return ".jsp";		// ����� ���� ȭ������ �̵� (forwarding)	
	}

}
