<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>order</title>
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

#userAddr2, #userAddr3 {
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
   		alert("주문이 완료되었습니다.");
   		form.submit();
	}
</script>
</head>
<body>
	<div class="orderInfo">
		<form role="form" action=" uri "  method="GET">
			<h2>주문 정보 입력</h2>

			<input type="hidden" name="amount" value="${sum}" />

			<div class="inputArea">
				<label for="">수령인</label> <input type="text" name="orderRec"
					id="orderRec" required="required" />
			</div>

			<div class="inputArea">
				<label for="orderPhon">수령인 연락처</label> <input type="text"
					name="orderPhon" id="orderPhon" required="required" />
			</div>

			<div class="inputArea">
				<label for="userAddr1">우편번호</label> <input type="text"
					name="userAddr1" id="userAddr1" required="required" />
			</div>

			<div class="inputArea">
				<label for="userAddr2">도로명 주소</label> <input type="text"
					name="userAddr2" id="userAddr2" required="required" />
			</div>

			<div class="inputArea">
				<label for="userAddr3">상세 주소</label> <input type="text"
					name="userAddr3" id="userAddr3" required="required" />
			</div>
			
			<div class="sum">총 합계:</div>

			<div class="inputArea">
				<button type="submit" class="order_btn" Onclick="orderComplete()">주문</button> <!--주문내역으로 이동?-->
				<button type="button" class="cancel_btn">취소</button> <!--장바구니로 이동?-->
			</div>

		</form>
	</div>
</body>
</html>