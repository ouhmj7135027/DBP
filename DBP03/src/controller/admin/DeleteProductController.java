package controller.admin;

import java.io.IOException;
import java.util.List;

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
import service.dto.productDTO;

public class DeleteProductController implements Controller {
	List<productDTO> pList;
	private static final Logger log = LoggerFactory.getLogger(DeleteProductController.class);

    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		int deleteId = Integer.parseInt(request.getParameter("product_id"));
    	log.debug("Delete Product : {}", deleteId);

    	ProductManager manager = ProductManager.getInstance();		
		HttpSession session = request.getSession();	
		manager.delete(deleteId);

		pList = manager.ListingProductsInfo();	// 커뮤니티 리스트 검색
		request.setAttribute("pList", pList);
		           
		return "/admin/admin_main.jsp";		// 사용자 보기 화면으로 이동 (forwarding)	
	}

	@Override
	public void onlyGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}

}
