<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myorderList</title>
<style>
 section#content ul li { border:5px solid #eee; padding:10px 20px; margin-bottom:20px; }
 section#content .orderList span { font-size:20px; font-weight:bold; display:inline-block; width:90px; margin-right:10px; }
</style>
</head>
<body>
<section id="content">
 
 <ul class="orderList">
  <c:forEach items="${orderList}" var="orderList">
  <li>
  <div>
   <p><span>주문날짜</span>${orderList.order_date}</p>
   <p><span>주문번호</span><a href="<c:url value='/user/myorder/view?orderId=${orderList.order_id}' />">${orderList.order_id}</a></p>
   <p><span>수령인</span>${orderList.order_name}</p>
   <p><span>주소</span>${orderList.address}</p>
   <p><span>결제 금액</span>${orderList.total_price}원</p>
   <p><span>주문상태</span>${orderList.order_state}</p>
  </div>
  </li>
  </c:forEach>
 </ul>

</section>
</body>
</html>