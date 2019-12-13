<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table border =1 width = 500>
<tr><td>작성자</td><td>성분</td><td>내용</td><td>작성일</td><</tr>
<c:forEach items="${Reviewlist}" var="review">
<tr>
	<td>${review.m_id}</td>
	<td>${review.product_id}</td>
	<td>${review.review}</td>
	<td>${review.write_date}</td>
</tr>	
</c:forEach>
</table>

<a class="nav-link" href="<c:url value='/review/form' />">리뷰쓰기 </a>
</body>
</html>