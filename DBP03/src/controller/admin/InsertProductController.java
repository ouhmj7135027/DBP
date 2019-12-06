package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
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
    		request.getParameter("effect"),
			request.getParameter("p_name"),
			Integer.parseInt(request.getParameter("p_price")),
			Integer.parseInt(request.getParameter("category_1")),
			Integer.parseInt(request.getParameter("category_2")));		
        
		try {
			ProductManager manager = ProductManager.getInstance();
			manager.insert(product);
			
	    	log.debug("Create product : {}", product);
	        return "redirect:/admin";	// 목록으로 바꾸기
	        
		} catch (Exception e) {		// 예외 발생 시 입력 form으로 forwarding
            request.setAttribute("creationFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("product", product);
			return "/admin/addProduct.jsp";
		}
    }

	@Override
	public void onlyGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}
}
