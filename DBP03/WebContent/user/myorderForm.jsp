<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myorder</title>
</head>
<body>
	<table border = 1>
		<tr>
			<th colspan = "5">주문 내역</th>
		</tr>
		
		<tr align = center>
			<th>주문 번호</th>
			<th>주문 상세번호</th>
			<th>주문날짜</th>
			<th>상품번호</th>
			<th>상품 개수</th>
			<th>가격</th>
			<th>주문 상태</th>
		</tr>
		
		<c:forEach items = "${requestScope.orderlist }" var = "ord">
		<tr align = center>
			<td>${ord.order_id }</td>
			<td>${ord.order_detail_id }</td>
			<td>${ord.order_date }</td>
			<td>${ord.product_id }</td>
			<td>${ord.o_amount }</td>
			<td>${ord.total_price }</td>
			<td>${ord.order_state }</td>
		</tr>
		</c:forEach>
		
	</table>
</body>
</html>