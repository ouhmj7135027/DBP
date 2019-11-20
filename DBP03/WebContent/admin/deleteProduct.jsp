<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 삭제(관리자용)</title>
</head>
<body>
<div align="center">
<h2>삭제할 상품의 상품명을 입력하세요.</h2>
<form action="" method="post">
<table border="1">
	<tr>
		<th>상품명</th>
		<td><input type="text" id="p_name"></td>
	</tr>
	<tr>
		<th><input type="button" value="상품id찾기" onclick="{document.getElementById('product_id').value='';}"></th>
		<td><input type="text" id="product_id"></td>
	</tr>
</table>
<br />
<input type="submit" value="상품 삭제">
</form>
</div>

</body>
</html>