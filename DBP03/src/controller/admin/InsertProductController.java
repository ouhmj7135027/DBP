package controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import service.ProductManager;
import service.dto.productDTO;

public class InsertProductController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(InsertProductController.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	productDTO product = new productDTO(
    		0, request.getParameter("effect"),
			request.getParameter("p_name"),
			request.getParameter("p_price"), 0, 
			request.getParameter("category_id"),
			request.getParameter("category_age_id"));		
        
		try {
			ProductManager manager = ProductManager.getInstance();
			manager.insert(product);
			
	    	log.debug("Create product : {}", product);
	        return "redirect:/community/list";	// ���� �� Ŀ�´�Ƽ ����Ʈ ȭ������ redirect
	        
		} catch (Exception e) {		// ���� �߻� �� �Է� form���� forwarding
            request.setAttribute("creationFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("product", product);
			return ".jsp";
		}
    }
}
