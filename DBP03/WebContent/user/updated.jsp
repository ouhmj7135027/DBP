<%@ page language="java" contentType="text/html; charset=EUC-KR"
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
    dto.setEmail_id(id);
    
    MemberDAOImpl dao = MemberDAOImpl.getInstance();
    //dao.update(dto);
  	dto = dao.findUser(id);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>수정된 회원정보</title>

</head>
<body>
<div align="center">
<h1>수정된 회원정보</h1>
<table border="1" align=center cellpadding="5" cellspacing="0"
         width="30%" height="50%" bordercolor="lightgrey"
         style="border-collapse: collapse;">
<tr>
         <td>ID</td>
         <td><%=id %></td>
      </tr>
      <tr>
         <td>비밀번호</td>
         <td><%= dto.getM_password() %></td>
      </tr>
      <tr>
         <td>이름</td>
         <td><%= dto.getM_name() %></td>
      </tr>
      <tr>
         <td>주소</td>
         <td><%= dto.getAddress() %></td>
      </tr>
      <tr>
         <td>전화번호</td>
         <td><%= dto.getPhone() %></td>
      </tr>
     

   </table>
   <input type = "button" value="뒤로" onClick="history.back()" />
   <a href="<c:url value='/main' />">메인으로</a>
</div>
</body>
</html>