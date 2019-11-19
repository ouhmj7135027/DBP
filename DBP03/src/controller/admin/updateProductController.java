package controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.UpdateUserController;
import model.Product;
import service.ProductManager;
import service.dto.productDTO;

public class updateProductController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(UpdateUserController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
 
    	if (request.getMethod().equals("GET")) {	
    		// GET request: 회원정보 수정 form 요청	
    		// 원래는 UpdateUserFormController가 처리하던 작업을 여기서 수행
    		productDTO updateProduct = new productDTO(
    	    		0, request.getParameter("effect"),
    				request.getParameter("p_name"),
    				request.getParameter("p_price"), 0, 
    				request.getParameter("category_id"),
    				request.getParameter("category_age_id"));	

    		log.debug("UpdateForm Request : {}", updateProduct);
    		
    		ProductManager manager = ProductManager.getInstance();
    		manager.update(updateProduct);			
            
    	}
    	return "redirect:/user/list";



					
    }

}
