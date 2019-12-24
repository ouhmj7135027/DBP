package controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import service.ProductManager;
import service.dto.productDTO;

public class recommendController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ProductManager manager = new ProductManager();
		List<productDTO> slist = manager.getSalesList();
		request.setAttribute("saleList", slist);
		
		return "/main";
	}

	@Override
	public void onlyGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
	}

}
