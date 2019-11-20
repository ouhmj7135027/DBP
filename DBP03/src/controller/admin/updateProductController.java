package controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.member.UpdateUserController;
import model.Product;
import service.ProductManager;
import service.dto.productDTO;

public class updateProductController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(UpdateUserController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
 
    	if (request.getMethod().equals("GET")) {	
    		// GET request: ȸ������ ���� form ��û	
    		// ������ UpdateUserFormController�� ó���ϴ� �۾��� ���⼭ ����
    		productDTO updateProduct = new productDTO(
    				request.getParameter("effect"),
    				request.getParameter("p_name"),
    				Integer.parseInt(request.getParameter("p_price")),
    				Integer.parseInt(request.getParameter("category_id")),
    				Integer.parseInt(request.getParameter("category_age_id")));

    		log.debug("UpdateForm Request : {}", updateProduct);
    		
    		ProductManager manager = ProductManager.getInstance();
    		manager.update(updateProduct);			
            
    	}
    	return "redirect:/user/list";



					
    }

}
