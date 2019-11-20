<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%><%@ page import = "java.util.Enumeration" %>
    <%@ page import = "java.util.ArrayList" %>
    <%request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>


	
<% 
	String[] list =request.getParameterValues("main");

	int i =0;
	while(i<list.length){
			if(Integer.parseInt(list[i])==0)
				pageContext.include("surveyBlood.jsp");
			if(Integer.parseInt(list[i])==1)
				pageContext.include("surveySkin.jsp");
			 
			if(Integer.parseInt(list[i])==2)
				pageContext.include("surveyDigestion.jsp");
	 
			if(Integer.parseInt(list[i])==3)
				pageContext.include("surveyEye.jsp");
			if(Integer.parseInt(list[i])==4)
				pageContext.include("surveyFatigue.jsp");
				
			if(Integer.parseInt(list[i])==5)
				pageContext.include("surveyBone.jsp");
			 if(Integer.parseInt(list[i])==6)
				pageContext.include("surveyImmune.jsp");
				
			i++;
		}
		
%>
</body>
</html>