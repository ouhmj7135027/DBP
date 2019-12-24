<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="EUC-KR"%>
<%@page import="java.util.*"%>
<%@page import="persistence.dao.impl.MemberDAOImpl"%>
<%@page import="service.dto.MemberDTO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:useBean id="dto" class="service.dto.MemberDTO">
<jsp:setProperty property="*" name="dto" />
</jsp:useBean>
    <%
   
    String id = (String)session.getAttribute("userId");
    System.out.println("--update---" + dto.toString() + " iD = "+id);
    
    MemberDAOImpl dao = MemberDAOImpl.getInstance();
   
  //  System.out.println(dto.getM_password());
  	dto = dao.findUser(id);
    %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="/css/top.css">
<meta charset="EUC-KR">
<title>������ ȸ������</title>
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
<div align="center">
<h1>������ ȸ������</h1>
<table border="1" align=center cellpadding="5" cellspacing="0"
         width="30%" height="50%" bordercolor="lightgrey"
         style="border-collapse: collapse;">
<tr>
         <td>ID</td>
         <td><%=id %></td>
      </tr>
      <tr>
         <td>��й�ȣ</td>
         <td><%= dto.getM_password() %></td>
      </tr>
      <tr>
         <td>�̸�</td>
         <td><%= dto.getM_name() %></td>
      </tr>
      <tr>
         <td>�ּ�</td>
         <td><%= dto.getAddress() %></td>
      </tr>
      <tr>
         <td>��ȭ��ȣ</td>
         <td><%= dto.getPhone() %></td>
      </tr>
     

   </table>
   <input type = "button" value="�ڷ�" onClick="history.back()" />
   <a href="<c:url value='/main' />">��������</a>
</div>
</body>
</html>