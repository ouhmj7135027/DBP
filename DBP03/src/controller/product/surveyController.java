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
import java.util.List;
public class surveyController implements Controller {
	ArrayList<String> getParameterName(HttpServletRequest request){
		ArrayList<String> list = new ArrayList<String>();
		Enumeration<String> e = request.getParameterNames();
		while (e.hasMoreElements()){
			String s = e.nextElement();
			list.add(s);
		}
		return list;
	}
		@SuppressWarnings({ "null11", "null" })
		public String execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
			
		ArrayList<Integer> l = new ArrayList<Integer>();
		
		ProductManager m = ProductManager.getInstance();
		ArrayList<String> list = getParameterName(request);
		List<productDTO> k = new ArrayList<productDTO>();
		String data = request.getParameter("Blood");
		
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
		
		k.add(m.getProductBySurvey(1, 4));
		//k.add(m.getProductByNames("레모나 키튼정"));
		request.setAttribute("list", k);				
		return "/survey/surveyResult.jsp";     
	 }

		@Override
		public void onlyGet(HttpServletRequest request, HttpServletResponse response) 
				throws IOException, ServletException {
			// TODO Auto-generated method stub
			
		}
}
