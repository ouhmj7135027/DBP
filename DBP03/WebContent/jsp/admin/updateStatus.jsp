<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상태 변경(관리자용)</title>
</head>
<body>
<div align="center">

<form name="order" action="" method="post">
<fieldset>
<legend>상태 변경할 주문내역 선택</legend><br />
<table border="1">
	<tr>
		<th>주문ID</th>
		<td><input type="text" id="order_id"></td>
	</tr>

</table>
<br />
<input type="submit" value="주문내역 불러오기">
<input type="reset" value="초기화">
</fieldset><br />
<fieldset>
<legend>주문 상태 변경</legend><br />
	<input type="radio" name="order_state" value="1">입금 확인중
	<input type="radio" name="order_state" value="2">결제 완료
	<input type="radio" name="order_state" value="3">배송 준비중
	<input type="radio" name="order_state" value="4">배송중
	<input type="radio" name="order_state" value="5">배송 완료<br /><br />
<input type="submit" value="상태 변경">
<input type="reset" value="초기화">
</fieldset>
</form>
<form name="exchange_status" action="" method="post">
<fieldset>
<legend>교환 상태 변경</legend><br />
	<input type="radio" name="exchange_status" value="1">반품 신청 완료
	<input type="radio" name="exchange_status" value="2">반품 확인
	<input type="radio" name="exchange_status" value="3">배송 준비중
	<input type="radio" name="exchange_status" value="4">배송중
	<input type="radio" name="exchange_status" value="5">배송 완료<br /><br />
<input type="submit" value="상태 변경">
<input type="reset" value="초기화">
</fieldset>
</form>
</div>
</body>
</html>