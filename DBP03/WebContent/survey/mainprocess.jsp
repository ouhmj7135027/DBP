<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%><%@ page import = "java.util.Enumeration" %>
    <%@ page import = "java.util.ArrayList" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<form name="form" method="POST" action="<c:url value='/survey/result'/>">

<% 

	String[] list =request.getParameterValues("main");

	int i =0;
	while(i<list.length){
			if(Integer.parseInt(list[i])==0)
				pageContext.include("surveyBlood.jsp");
			if(Integer.parseInt(list[i])==1)
				pageContext.include("surveySkin.jsp");
			 
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
<input type = "submit" value = "선택"/>
</form>
</body>
</html>