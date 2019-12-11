package controller.product;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import oracle.net.jdbc.TNSAddress.SOException;
import persistence.dao.impl.ReviewDAOImpl;
import service.MemberManager;
import service.ProductManager;
import service.dto.MemberDTO;
import service.dto.ReviewDTO;


public class ReviewController implements Controller{

	 public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		
		 ReviewDTO r = new ReviewDTO(
					request.getParameter("name"),
				
					request.getParameter("rate"),
					request.getParameterValues("component"),
					request.getParameter("review"),
					request.getParameter("reviewpassword"),
				);
				 
			
				ReviewDAOImpl review = new ReviewDAOImpl();
				review.insertReview(r);
				return "redirect:/review/main";		
		
		    }

	 

		@Override
		public void onlyGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			// TODO Auto-generated method stub
			
		}
}
