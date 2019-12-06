<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>관리자 페이지</title>
<style>
 section#content ul li { display:inline-block; margin:10px; }
 section#content div.goodsThumb img { width:200px; height:200px; }
 section#content div.goodsName { padding:10px 0; text-align:center; }
 section#content div.goodsName a { color:#000; }
</style>
<script>
function update(p_id) {	
	form.action = "<c:url value='/admin/update?id="+p_id+"' />";
	form.submit();
}

function del(p_id) {
	if(confirm("삭제하시겠습니까?")== true){
	form.action = "<c:url value='/admin/delete/cont?product_id="+p_id+"' />";
	form.submit();
	}else{
		return false;
	}
}
</script>
</head>
<body>
<div align="center">
<ul class="low">
	<li><a href="<c:url value='/admin/add' />">상품 추가</a></li>
	<!--  <li><a href="<c:url value='/admin/update' />">상품 정보 변경</a></li> 
	<li><a href="<c:url value='/admin/delete' />">상품 삭제</a></li> -->
	<li><a href="<c:url value='/admin/status' />">주문 상태 변경</a></li>
</ul>
<div id="root">
<form name="form" method="POST" action="<c:url value='/admin/update' />">
	<section id="container">
		<div id="container_box">
			<section id="content">
				<ul>
				 <c:forEach items="${pList}" var="product">
				 <li>
					 <div class="goodsThumb">
					 <img src="<c:url value='${product.imgsrc}' />">
					 </div> 		 
				  <div class="goodsName">
				    <p>${product.p_name}</p>
				    </div>
					<input type="button" value="상품 수정" onClick="update(${product.product_id})">
					<input type="button" value="상품 삭제" onClick="del(${product.product_id})">
					</li>
				 </c:forEach>
				</ul>
			</section>
			
		</div>
	</section>
</form>
</div>
</div>
</body>
</html>