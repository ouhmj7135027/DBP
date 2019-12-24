<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myorderView</title>
<style>
 .orderView li { margin-bottom:20px; padding-bottom:20px; border-bottom:1px solid #999; }
 .orderView li::after { content:""; display:block; clear:both; }
 
 .thumb { float:left; width:200px; }
 .thumb img { width:200px; height:200px; }
 .gdsInfo { float:right; width:calc(100% - 220px); line-height:2; }
 .gdsInfo span { font-size:20px; font-weight:bold; display:inline-block; width:100px; margin-right:10px; }
</style>
</head>
<body>
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
    <span><a href="<c:url value='/review/form?pName=${orderView.p_name}' />">리뷰쓰기</a> </span><br>
        
        
    </p>
   </div>
  </li>  
    </form>   
  </c:forEach>

  
 </ul>
</section>
</body>
</html>