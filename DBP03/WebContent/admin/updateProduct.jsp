<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="service.dto.productDTO"%>
<%@ page import="service.ProductManager" %>
<%@ page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 업데이트(관리자용)</title>
</head>
<body>
<div align="center">
<h2>수정할 상품정보를 입력하세요.</h2>
<%
	ProductManager manager = ProductManager.getInstance();
	productDTO product;

	product = manager.getProductById(Integer.parseInt(request.getParameter("id")));
%>
<form action="<c:url value='/admin/update/cont' />" method="post">
<table height="300" border="1">
	<tr>
		<th>상품명</th>
		<td><input type="text" id="p_name" value=<%=product.getP_name() %>></td>
	</tr>
	<tr>
		<th>효능</th>
		<td><input type="text" id="effect" value=<%=product.getEffect() %>></td>
	</tr>
	<tr>
		<th>판매가격</th>
		<td><input type="number" id="p_price" value=<%=product.getP_price() %>></td>
	</tr>
	<tr>
		<th>성분 카테고리</th>
		<td>
			<input type="radio" name="category_1" value="1">프로바이오틱스
			<input type="radio" name="category_1" value="2">칼슘/마그네슘/비타민
			<input type="radio" name="category_1" value="3">비타민B<br />
			<input type="radio" name="category_1" value="4">비타민C
			<input type="radio" name="category_1" value="5">루테인
			<input type="radio" name="category_1" value="6">밀크씨슬
			<input type="radio" name="category_1" value="7">오메가3
		</td>
	</tr>
	<tr>
		<th>연령 카테고리</th>
		<td>
			<input type="radio" name="category_2" value="1">성인남녀
			<input type="radio" name="category_2" value="2">어린이
			<input type="radio" name="category_2" value="3">청소년
			<input type="radio" name="category_2" value="4">임산부
			<input type="radio" name="category_2" value="5">시니어
		</td>
	</tr>
</table>
<br />
<input type="submit" value="상품 수정">
<input type="reset" value="초기화">
</form>
</div>
</body>
</html>