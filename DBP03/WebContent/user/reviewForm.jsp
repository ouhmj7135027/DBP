<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>review</title>
</head>
<body>
	<form name="write_form" method="post" action="">
		<h3 class="blind">리뷰 작성</h3>
		<div>
			<input type="hidden" name="product_id" value="${review.product_id}">
			제목
			<input type="text" name="title"><p>
			상품은 만족하셨나요?
			<div>
				<a href="#" role="radio" aria-checked="false" data-value="5"> 
				<span class="rate">5</span></a> 
				<a href="#" role="radio" aria-checked="false" data-value="4"> 
				<span class="rate">4</span></a>
				<a href="#" role="radio" aria-checked="false" data-value="3"> 
				<span class="rate">3</span></a> 
				<a href="#" role="radio" aria-checked="false" data-value="2"> 
				<span class="rate">2</span></a>
				<a href="#" role="radio" aria-checked="false" data-value="1"> 
				<span class="rate">1</span></a>
			</div>
		</div>
		<p>
		<textarea name="review" cols="50" rows="10"></textarea>
		<div>
			<a href="#">사진 첨부</a>
		</div>

		<table>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pw"></td>
			</tr>

			<tr>
				<td colspan="2"><input type="button" value="메  인" onClick="">&nbsp;
					<input type="submit" value="등  록 " onClick="check()">&nbsp;
					<input type="button" value="목  록" onClick="reviewlist.jsp"></td>
			</tr>
		</table>
	</form>
</body>
</html>