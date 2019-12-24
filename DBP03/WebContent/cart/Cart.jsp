<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="/css/top.css">
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
<h4>장바구니 관리</h4>
<c:choose>
<c:when test="${cartlist == null}">
	장바구니가 비어있습니다.
</c:when>
<c:otherwise>
	<table style="background-color: YellowGreen">
	<tr>
		<td width = 100 align="center" bgcolor="E6ECDE"></td>
		<td width = 260 align="center" bgcolor="E6ECDE">상품 이름</td>
		<td width = 100 align="center" bgcolor="E6ECDE">가격</td>
		<td width = 50 align="center" bgcolor="E6ECDE">수량</td>
	</tr>
	<c:forEach items="${cartlist}" var="cart">
	<tr>
		<td bgcolor="ffffff"><img src="<c:url value='${cart.imgsrc}' />"></td>
		<td align="center" bgcolor="ffffff">${cart.p_name}</td>
		<td align="center" bgcolor="ffffff">${cart.p_price}</td>
		<td align="center" bgcolor="ffffff">${cart.cart_p_num}</td>
	</tr>
	</c:forEach>	
	</table>
	총계: ${totalList}원
</c:otherwise>
</c:choose>
<br>
<hr /><a href="<c:url value='/order?total_price=${totalList}' />" >주문하기</a><hr />
<a href="<c:url value='/main' />" >홈 화면으로</a>
<a href="<c:url value='/product/category' />" >쇼핑 계속 하기</a>
