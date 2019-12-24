<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="/css/top.css">
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light" >
  <a class="navbar-brand" href="#">Pill To You </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarText">
    <ul class="navbar-nav mr-auto">
      
    
      <li class="nav-item">
        <a class="nav-link" href="<c:url value='/product/list?page=1' />">제품보기</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<c:url value='/cart/cartList' />">장바구니</a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="<c:url value='/review/main' />">고객후기</a>
      </li>
<%if(session.getAttribute("userId") == null) {%>

      <li class="nav-item">
        <a class="nav-link" href="<c:url value='/user/login/form' />">로그인</a>
      </li>
       
<%
}
else 
{  
%>
       <li class="nav-item">
        <a class="nav-link" href="<c:url value='/user/logout' />">로그아웃 </a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="<c:url value='/user/mypage/form' />">마이페이지</a>
      </li>
<%
} %>
     
    </ul>
    
  </div>
  
</nav>
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
