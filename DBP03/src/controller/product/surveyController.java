package controller.product;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Member;
import service.MemberManager;
import service.ProductManager;

public class surveyController {
	 public ArrayList<Integer> execute(HttpServletRequest request, HttpServletResponse response)	throws Exception {
		 ArrayList<Integer> l = new ArrayList<Integer>();
		ArrayList<String> list = new ArrayList<String>();
		Enumeration<String> e = request.getParameterNames();
				while (e.hasMoreElements()){
					String s = e.nextElement();
					list.add(s);
				}
		for(int i=0;i<list.size();i++) {
			if((list.get(i).equals("skin")||list.get(i).equals("blood"))&&!l.contains(4))
				l.add(4);
			else if(((list.get(i).equals("immune")))&&!l.contains(1))
				l.add(1);
			else if(((list.get(i).equals("bone")))&&!l.contains(2))
				l.add(2);
			else if(((list.get(i).equals("fatigue")))&&!l.contains(3))
				l.add(3);		
		}		
		int i =0;
		ProductManager m = ProductManager.getInstance();
		m.getProductBySurvey(l.get(i))
	 }
}
