<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>order</title>
<%
	int total = Integer.parseInt(request.getParameter("total_price"));
%>
<style>
.orderInfo {
	border: 5px solid #eee;
	padding: 20px;
}

.orderInfo .inputArea {
	margin: 10px 0;
}

.orderInfo .inputArea label {
	display: inline-block;
	width: 120px;
	margin-right: 10px;
}

.orderInfo .inputArea input {
	font-size: 14px;
	padding: 5px;
}

#address {
	width: 250px;
}

.orderInfo .inputArea:last-child {
	margin-top: 30px;
}

.orderInfo .inputArea button {
	font-size: 20px;
	border: 2px solid #ccc;
	padding: 5px 10px;
	background: #fff;
	margin-right: 20px;
}
</style>
<script>
	function orderComplete() {
		if (form.order_name.value == "") {
			alert("수령인을 입력하십시오.");
			form.userId.focus();
			return false;
		} 
		if (form.order_phone.value == "") {
			alert("수령인 연락처를 입력하십시오.");
			form.order_phone.focus();
			return false;
		}
		if(form.address.value=="") {
			alert("주소를 입력하십시오.");
			form.address.focus();
			return false;
		}
		alert("주문이 완료되었습니다.");
		form.action="<c:url value='/order/ordercont' />";
		form.submit();
	}
</script>
</head>
<body>
	<div class="orderInfo">
		<form name="form" method="POST">
			<h2>주문 정보 입력</h2>
			<div class="inputArea">
				<label for="">수령인</label> 
				<input type="text" name="order_name" id="order_name" required="required" />
			</div>

			<div class="inputArea">
				<label for="orderPhon">수령인 연락처</label> 
				<input type="text" name="order_phone" id="order_phone" required="required" />
			</div>

			<div class="inputArea">
				<label for="addr">주소</label> 
				<input type="text" name="address" id="address" required="required" />
			</div>
			
			<div class="inputArea">
				<label for="price">총 합계</label> 
				<input type="text" name="total_price" id="total_price" value= "<%= total %>원" required="required" />
			</div>

			<div class="inputArea">
				<a href="<c:url value='/user/myorder/list' />"><button type="submit" class="order_btn" Onclick="orderComplete()">주문</button></a>
				<a href="<c:url value='/cart/cart' />"><button type="button" class="cancel_btn">취소</button></a>
			</div>

		</form>
	</div>
</body>
</html>