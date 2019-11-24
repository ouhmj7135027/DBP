package controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import service.ProductManager;
import service.dto.productDTO;

public class ProductListController implements Controller {
	@Override
	
    public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		int cnum1 = Integer.parseInt(request.getParameter("c"));
		int cnum2 = Integer.parseInt(request.getParameter("i"));
		
    	ProductManager manager = ProductManager.getInstance();
		List<productDTO> plist = manager.getProductByCategory(cnum1, cnum2);
		
		// commList 객체를 request에 저장하여 커뮤니티 리스트 화면으로 이동(forwarding)
		request.setAttribute("productlist", plist);				
		return "/product/productlist.jsp";        
    }

	@Override
	public void onlyGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}
}