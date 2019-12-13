package controller.product;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import oracle.net.jdbc.TNSAddress.SOException;
import persistence.dao.impl.ReviewDAOImpl;
import service.MemberManager;
import service.ProductManager;
import service.dto.MemberDTO;
import service.dto.ReviewDTO;


public class ReviewController implements Controller{

	 public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		 HttpSession session = request.getSession();
		 String component ="";
		 System.out.println(request.getParameterValues("component"));
		for(int i=0;i<request.getParameterValues("component").length;i++) {
		component = request.getParameterValues("component")[i];
		}
		 ReviewDTO r = new ReviewDTO(
				 String.valueOf(session.getAttribute("m_id")),
				
					request.getParameter("rate"),
				    component,
					request.getParameter("review"),
					request.getParameter("reviewpassword")
				);
				
				System.out.println(String.valueOf(session.getAttribute("m_id")));
				System.out.println(String.valueOf(request.getParameter("rate")));
				System.out.println(String.valueOf(request.getParameter("review")));
				System.out.println(String.valueOf(request.getParameter("reviewpassword")));
				ReviewDAOImpl review = new ReviewDAOImpl();
				review.insertReview(r);
				List<ReviewDTO> list=  review.getReviewList();
				System.out.println(list.size());
				request.setAttribute("Reviewlist", list);
				return "redirect:/review/main";		
		
		    }

	 

		@Override
		public void onlyGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			// TODO Auto-generated method stub
			
		}
}
