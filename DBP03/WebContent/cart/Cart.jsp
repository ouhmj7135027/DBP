<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h4>장바구니 관리</h4>
<!--<c:choose>
	<c:when test="${CART_LIST == null || CART_LIST.size <= 0}">
		장바구니가 비어있습니다.
	</c:when>
	<c:otherwise>
		<table border=1>
		<tr>
			<td width = 100></td>
			<td width=250>상품이름</td>
			<td width=80>가격</td>
			<td width=50>수량</td>
		</tr>
		<c:forEach var="cnt" begin="0" end="${CART_LIST.size-1}">
			<tr>
				
				<td><img src="<c:url value='${CART_LIST.img[cnt]}' />"></td>
				<td>${CART_LIST.title[cnt]}</td>
				<td>${CART_LIST.price[cnt]}원</td>
				<td>${CART_LIST.number[cnt]}</td>
			</tr>
			</c:forEach>
		</table>
		총계: ${CART_LIST.totalAmount}원
		<input type = hidden name=TOTAL_AMOUNT value=${CART_LIST.totalAmount} />
		<hr /><a href="<c:url value='/order?total_price=${CART_LIST.totalAmount}' />" >주문하기</a> 
	</c:otherwise>
</c:choose>
<br>
<a href="<c:url value='/main' />" >홈 화면으로</a>
<a href="<c:url value='/product/category' />" >쇼핑 계속 하기</a>
-->
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
<a href="<c:url value='/main' />" >홈 화면으로</a>
<a href="<c:url value='/product/category' />" >쇼핑 계속 하기</a>
<hr /><a href="<c:url value='/order' />" >주문하기</a> 