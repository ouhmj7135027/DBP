<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	총계: ${cart.totalAmount}원
</c:otherwise>
</c:choose>
<br>
<hr /><a href="<c:url value='/order?total_price=${cart.totalAmount}' />" >주문하기</a><hr />
<a href="<c:url value='/main' />" >홈 화면으로</a>
<a href="<c:url value='/product/category' />" >쇼핑 계속 하기</a>
