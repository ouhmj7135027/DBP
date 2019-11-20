<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="persistence.dao.impl.MemberDAOImpl"%>
<%@page import="model.Member"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>마이페이지</title>
<style>
body {
   background-color: WHITE;
}
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
   <%
   String id = session.getAttribute("user").toString();
   Member member = new Member();
  
   %>
<div align="center">
   <form action="edited.jsp" method="post" name="form" onSubmit="return check()" >
         <h1>현재 회원 정보</h1>
   <table border="1" align=center align="left" cellpadding="5" cellspacing="0"
         width="50%" height="50%" bordercolor="lightgrey"
         style="border-collapse: collapse;">
      <tr>
         <td>ID</td>
         <td><%=member.getEmail_id()%></td>
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


   <!-- button onclick="update()">회원정보 변경</button-->
   <form name="update" name="form" action="" //uri
      method="GET">
      <input type="button" value="회원정보 변경 확인" onClick="updateMyinfo01()">

   </form>
</div>
</body>
</html>