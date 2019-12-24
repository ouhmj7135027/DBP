<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="/css/top.css">
<meta charset="UTF-8">
<title>myorderView</title>
<style>
 .orderView li { margin-bottom:20px; padding-bottom:20px; border-bottom:1px solid #999; }
 .orderView li::after { content:""; display:block; clear:both; }
 
 .thumb { float:left; width:200px; }
 .thumb img { width:200px; height:200px; }
 .gdsInfo { float:right; width:calc(100% - 220px); line-height:2; }
 .gdsInfo span { font-size:15px; font-weight:bold; display:inline-block; width:100px; margin-right:10px; }
</style>

<script>
function Exchange() {
		alert("환불 신청이 완료되었습니다.");	
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
<% int i = 1;%>
<section id="content">
 <ul class="orderView">

  <c:forEach items="${orderView}" var="orderView">    
   
  <li>
   <div class="thumb">
   <img src="<c:url value='${orderView.imgsrc}' />">
   </div>
   <div class="gdsInfo">
    <p>
    <%request.setAttribute("orderNum", i);
    Object oid = request.getAttribute("oid");
    System.out.println(oid);
    request.setAttribute("oid", oid);
    out.print(i++);
    %><br>
     <span>상품명</span>${orderView.p_name}<br>
     <span>가격</span>${orderView.p_price}원<br>
     <span>상품 개수</span>${orderView.o_amount}개<br>
     <span>최종 가격</span>${orderView.total_price}원  <br>
     <span><a href="<c:url value='/review/form?pName=${orderView.p_name}' />">리뷰쓰기</a> </span>
     <input type="button" value="환불신청 " Onclick="Exchange()">
        
    </p>
   </div>
  </li>  
  </c:forEach>

  
 </ul>
</section>
</body>
</html>