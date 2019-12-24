package controller.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
import java.util.List;

public class surveyController implements Controller {
		
		public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {

		ArrayList<Integer> l = new ArrayList<Integer>();

		ProductManager m = ProductManager.getInstance();
		ArrayList<String> list = new ArrayList<String>();
		
		String[] values = new String[] {};
		ArrayList<productDTO> k = new ArrayList<productDTO>();
		
		Enumeration<String> e = request.getParameterNames();
				while (e.hasMoreElements()){
					String s = e.nextElement();
					list.add(s);
				}
		for(int i=0;i<list.size();i++) {
			if((list.get(i).equals("skin")||list.get(i).equals("blood"))&&!l.contains(4)) {
				l.add(4);
				values = request.getParameterValues("blood");
				List<String> val = Arrays.asList(values);
				if(val.get(0).equals("0"))
					val.set(0, "1");
				int big =Integer.parseInt( val.get(val.size()-1));
				
				
					System.out.println();
				k.add(m.getProductBySurvey(big,l.get(i)));
			
				System.out.println(m.getProductBySurvey(1,l.get(i)).getP_name());
			}
			
			else if(((list.get(i).equals("immune")))&&!l.contains(1)) {
				l.add(1);
				values = request.getParameterValues("immune");
				List<String> val = Arrays.asList(values);
				if(val.get(0).equals("0"))
					val.set(0, "1");
				int big =Integer.parseInt( val.get(val.size()-1));
				
				
					System.out.println();
				k.add(m.getProductBySurvey(big,l.get(i)));
			}
		
			else if(((list.get(i).equals("bone")))&&!l.contains(2)) {
				l.add(2);
				values = request.getParameterValues("bone");
				List<String> val = Arrays.asList(values);
				if(val.get(0).equals("0"))
					val.set(0, "1");
				int big =Integer.parseInt( val.get(val.size()-1));
				
				
					System.out.println();
				k.add(m.getProductBySurvey(big,l.get(i)));
		
			}
			
			else if(((list.get(i).equals("fatigue")))&&!l.contains(6)) {
				l.add(6);	
				values = request.getParameterValues("fatigue");
				List<String> val = Arrays.asList(values);
				if(val.get(0).equals("0"))
					val.set(0, "1");
				int big =Integer.parseInt( val.get(val.size()-1));
				
				
					System.out.println();
				k.add(m.getProductBySurvey(big,l.get(i)));
				
			}
			else if(((list.get(i).equals("eye")))&&!l.contains(5)) {
				l.add(5);	
				values = request.getParameterValues("eye");
				List<String> val = Arrays.asList(values);
				if(val.get(0).equals("0"))
					val.set(0, "1");
				int big =Integer.parseInt( val.get(val.size()-1));
				
				
					System.out.println();
				k.add(m.getProductBySurvey(big,l.get(i)));
		
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
