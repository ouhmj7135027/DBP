<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h4>장바구니 관리</h4>
<c:choose>
	<c:when test="${CART_LIST == null || CART_LIST.size <= 0}">
		장바구니가 비어있습니다.
	</c:when>
	<c:otherwise>
		<table border=1>
		<tr>
			<td width = 100></td>
			<td width = 70>상품id</td>
			<td width=250>상품이름</td>
			<td width=80>가격</td>
			<td width=50>수량</td>
		</tr>
		<c:forEach var="cnt" begin="0" end="${CART_LIST.size-1}">
			<tr>
				
				<td><img src="<c:url value='${CART_LIST.img[cnt]}' />"></td>
				<td>${CART_LIST.code[cnt]}</td>
				<td>${CART_LIST.title[cnt]}</td>
				<td>${CART_LIST.price[cnt]}원</td>
				<td>${CART_LIST.number[cnt]}</td>
			</tr>
			</c:forEach>
		</table>
		총계: ${CART_LIST.totalAmount}원
		<input type = hidden name=TOTAL_AMOUNT value=${CART_LIST.totalAmount} />
	</c:otherwise>
</c:choose>
<br>
<a href="<c:url value='/main' />" >홈 화면으로</a>
<a href="<c:url value='/product/category' />" >쇼핑 계속 하기</a>