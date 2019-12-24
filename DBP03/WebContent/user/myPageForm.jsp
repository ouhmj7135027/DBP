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
<title>����������</title>
<style>

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
<nav class="navbar navbar-expand-lg navbar-light bg-light" >
  <a class="navbar-brand" href="#">Pill To You </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarText">
    <ul class="navbar-nav mr-auto">
      
    
      <li class="nav-item">
        <a class="nav-link" href="<c:url value='/product/list?page=1' />">��ǰ����</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<c:url value='/cart/cartList' />">��ٱ���</a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="<c:url value='/review/main' />">���ı�</a>
      </li>
<%if(session.getAttribute("userId") == null) {%>

      <li class="nav-item">
        <a class="nav-link" href="<c:url value='/user/login/form' />">�α���</a>
      </li>
       
<%
}
else 
{  
%>
       <li class="nav-item">
        <a class="nav-link" href="<c:url value='/user/logout' />">�α׾ƿ� </a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="<c:url value='/user/mypage/form' />">����������</a>
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
         <h1>���� ȸ�� ����</h1>
   <table border="1" align=center align="left" cellpadding="5" cellspacing="0"
         width="50%" height="50%" bordercolor="lightgrey"
         style="border-collapse: collapse;">
      <tr>
         <td>ID</td>
          <td><input type="text" disabled name="email" value="<%=member.getEmail_id() %>" /></td>
      </tr>
      <tr>
         <td>��й�ȣ</td>
         <td><input type="text" name="password" value="<%=member.getM_password() %>" /></td>
      </tr>
      <tr>
         <td>�̸�</td>
         <td><input type="text" name="name" value="<%= member.getM_name() %>" /></td>
      </tr>
      <tr>
         <td>�ּ�</td>
         <td><input type="text" name="address" value="<%= member.getAddress() %>" /></td>
      </tr>
      <tr>
         <td>��ȭ��ȣ</td>
         <td><input type="text" name="phone" value="<%=member.getPhone() %>" /></td>
      </tr>
     
   </table></form>
   <br>
   
      <input type="submit" value="ȸ������ ���� Ȯ��" onClick="updateMyinfo01()">

  

</div>
</body>
</html>