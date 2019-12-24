package controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Product;
import service.ProductManager;
import service.dto.productDTO;

public class updateProductController implements Controller {
	//private static final Logger log = LoggerFactory.getLogger(UpdateUserController.class);
	List<productDTO> pList;
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
    		productDTO updateProduct = new productDTO(
    				request.getParameter("effect"),
    				request.getParameter("p_name"),
    				Integer.parseInt(request.getParameter("p_price")),
    				Integer.parseInt(request.getParameter("category_1")),
    				Integer.parseInt(request.getParameter("category_2")));

    		//log.debug("UpdateForm Request : {}", updateProduct);
    		
    		ProductManager manager = ProductManager.getInstance();
    		manager.update(updateProduct);		
    		pList = manager.ListingProductsInfo();	// 커뮤니티 리스트 검색
			request.setAttribute("pList", pList);	
				
			return "/admin/admin_main.jsp";
    }

	@Override
	public void onlyGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}

}
