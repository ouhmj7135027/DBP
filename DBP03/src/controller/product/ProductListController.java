package controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.member.CartListController;
import service.ProductManager;
import service.dto.productDTO;

public class ProductListController implements Controller {
	
	@Override
	
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		ProductManager manager = ProductManager.getInstance();
		List<productDTO> plist;
		
		if(request.getParameter("page") != null) {
			plist = manager.ListingProductsInfo();
			request.setAttribute("productlist", plist);				
			return "/product/Category.jsp";  
		}
		
		int cnum1 = Integer.parseInt(request.getParameter("c"));
		int cnum2 = Integer.parseInt(request.getParameter("i"));
		
    	
		plist = manager.getProductByCategory(cnum1, cnum2);
		
		request.setAttribute("productlist", plist);				
		return "/product/productlist.jsp";        
    }

	@Override
	public void onlyGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}
}