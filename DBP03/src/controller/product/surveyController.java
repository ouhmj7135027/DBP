package controller.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Member;
import service.MemberManager;
import service.ProductManager;
import service.dto.*;

public class surveyController implements Controller {
		public surveyController(String string) {
		// TODO Auto-generated constructor stub
	}

		public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
			
		ArrayList<Integer> l = new ArrayList<Integer>();
		
		ProductManager m = ProductManager.getInstance();
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<productDTO> k = null;
		Enumeration<String> e = request.getParameterNames();
				while (e.hasMoreElements()){
					String s = e.nextElement();
					list.add(s);
				}
		for(int i=0;i<list.size();i++) {
			if((list.get(i).equals("skin")||list.get(i).equals("blood"))&&!l.contains(4)) {
				l.add(4);
				k.add(m.getProductBySurvey(1,l.get(i)));
				}
			else if(((list.get(i).equals("immune")))&&!l.contains(1)) {
				l.add(1);
				k.add(m.getProductBySurvey(1,l.get(i)));
				}
			else if(((list.get(i).equals("bone")))&&!l.contains(2)) {
				l.add(2);
				k.add(m.getProductBySurvey(1,l.get(i)));
			}
			else if(((list.get(i).equals("fatigue")))&&!l.contains(3)) {
				l.add(3);	
				k.add(m.getProductBySurvey(1,l.get(i)));
			}
			
			
			
			 
		}	
		
		request.setAttribute("list", k);				
		return "/survey/surveyResult.jsp";     
	 }

		@Override
		public void onlyGet(HttpServletRequest request, HttpServletResponse response) 
				throws IOException, ServletException {
			// TODO Auto-generated method stub
			
		}
}
