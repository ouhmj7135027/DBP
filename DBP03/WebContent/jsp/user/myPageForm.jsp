<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="persistence.dao.impl.MemberDAOImpl"%>
<%@page import="persistence.dao.MemberDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>����������</title>
<style>
body {
   background-color: WHITE;
}
</style>
<script>
/*alert("ȸ������ ����"); */

   function check(){
      if (login.id.value == "") {
         alert("����� ID�� �Է��Ͻʽÿ�.");
         login.id.focus();
         return false;
      } 
      if (login.password.value == "") {
         alert("��й�ȣ�� �Է��Ͻʽÿ�.");
         login.password.focus();
         return false;
      }      
      login.submit();
   }
   
   function updateMyinfo01() {
      alert("ȸ������ ����");
      //Uncaught ReferenceError: form is not defined ����
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
   
  
   %>
<div align="center">
   <form action="edited.jsp" method="post" name="form" onSubmit="return check()" >
         <h1>���� ȸ�� ����</h1>
   <table border="1" align=center align="left" cellpadding="5" cellspacing="0"
         width="50%" height="50%" bordercolor="lightgrey"
         style="border-collapse: collapse;">
      <tr>
         <td>ID</td>
         <td><%=member.getId() %></td>
      </tr>
      <tr>
         <td>��й�ȣ</td>
         <td><input type="text" name="password" value="<%=user.getPassword() %>" /></td>
      </tr>
      <tr>
         <td>�̸�</td>
         <td><input type="text" name="name" value="<%= user.getName() %>" /></td>
      </tr>
      <tr>
         <td>�ּ�</td>
         <td><input type="text" name="address" value="<%= user.getAddress() %>" /></td>
      </tr>
      <tr>
         <td>��ȭ��ȣ</td>
         <td><input type="text" name="phone" value="<%= user.getPhone() %>" /></td>
      </tr>
      <tr>
         <td>�̸���</td>
         <td><input type="text" name="email" value="<%= user.getEmail() %>" /></td>
      </tr>
      

   </table></form>
   <br>


   <!-- button onclick="update()">ȸ������ ����</button-->
   <form name="update" name="form" action="" //uri
      method="GET">
      <input type="button" value="ȸ������ ���� Ȯ��" onClick="updateMyinfo01()">

   </form>
</div>
</body>
</html>