<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="persistence.dao.impl.MemberDAOImpl"%>
<%@page import="service.dto.MemberDTO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="/css/top.css">
<meta charset="EUC-KR">
<title>마이페이지</title>
<style>

</style>
<script>
/*alert("회원정보 수정"); */

   function check(){
      if (login.id.value == "") {
         alert("사용자 ID를 입력하십시오.");
         login.id.focus();
         return false;
      } 
      if (login.password.value == "") {
         alert("비밀번호를 입력하십시오.");
         login.password.focus();
         return false;
      }      
      login.submit();
   }
   
   function updateMyinfo01() {
      alert("회원정보 수정");
      //Uncaught ReferenceError: form is not defined 오류
      form.submit();
   }
   function test(){
      alert("hello");
   };
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
   <%
   String id = session.getAttribute("userId").toString();
   MemberDAOImpl dao = MemberDAOImpl.getInstance();
   MemberDTO member = dao.findUser(id);
   member.setEmail_id(id); 
   %>
<div align="center">
 <form name="form" method="POST" action="<c:url value='/user/update' />">
         <h1>현재 회원 정보</h1>
   <table border="1" align=center align="left" cellpadding="5" cellspacing="0"
         width="50%" height="50%" bordercolor="lightgrey"
         style="border-collapse: collapse;">
      <tr>
         <td>ID</td>
          <td><input type="text" disabled name="email" value="<%=member.getEmail_id() %>" /></td>
      </tr>
      <tr>
         <td>비밀번호</td>
         <td><input type="text" name="password" value="<%=member.getM_password() %>" /></td>
      </tr>
      <tr>
         <td>이름</td>
         <td><input type="text" name="name" value="<%= member.getM_name() %>" /></td>
      </tr>
      <tr>
         <td>주소</td>
         <td><input type="text" name="address" value="<%= member.getAddress() %>" /></td>
      </tr>
      <tr>
         <td>전화번호</td>
         <td><input type="text" name="phone" value="<%=member.getPhone() %>" /></td>
      </tr>
     
   </table></form>
   <br>
   
      <input type="submit" value="회원정보 변경 확인" onClick="updateMyinfo01()">

  

</div>
</body>
</html>