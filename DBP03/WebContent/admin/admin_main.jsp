<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="/css/top.css">
<meta charset="EUC-KR">
<title>관리자 페이지</title>
<style>
.container {
  position: absolute;
  width : 100%
}
table {
	width : 100%
	
}
.container .btn {
  position: absolute;;
  top: 50%;
  left: 95%;
  transform: translate(-70%, -70%);
  -ms-transform: translate(-70%, -70%);
  background-color: #5fbee3;
  color: white;
  font-size: 16px;
  padding: 12px 24px;
  border: none;
  cursor: pointer;
  border-radius: 5px;
  text-align: center;
}
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
<nav class="navbar navbar-expand-lg navbar-light bg-light" >
  <a class="navbar-brand" href="#">Pill To You </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarText">
    <ul class="navbar-nav mr-auto">
      
    
      <li class="nav-item">
        <a class="nav-link" href="<c:url value='/product/list?page=1' />">제품보기</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<c:url value='/cart/cartList' />">장바구니</a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="<c:url value='/review/main' />">고객후기</a>
      </li>
<%if(session.getAttribute("userId") == null) {%>

      <li class="nav-item">
        <a class="nav-link" href="<c:url value='/user/login/form' />">로그인</a>
      </li>
       
<%
}
else 
{  
%>
       <li class="nav-item">
        <a class="nav-link" href="<c:url value='/user/logout' />">로그아웃 </a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="<c:url value='/user/mypage/form' />">마이페이지</a>
      </li>
<%
} %>
     
    </ul>
    
  </div>
  
</nav>
<div align="center">
<ul class="low">
	<hr /><br>
	<a href="<c:url value='/admin/add' />"><h3><strong>상품 추가</strong></h3></a>
	<br><hr />
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