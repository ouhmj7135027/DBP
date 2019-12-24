<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import = "java.util.Calendar" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="/css/top.css">
<meta charset="EUC-KR">
<title>Insert title here</title>
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
<div align = "center">
	<HR>
	<form name = form1 method = "post" action = "<c:url value='/review/create' />">
	<table border = 1 cellspacing = "1" cellpadding = "5">
	<tr>
	<td>�̸� </td>
	<td><input type = text size =20 name = name disabled value = "<%= session.getAttribute("userId") %>"></td>
	</tr>
	<tr>
	<td  colspan = "2"> ������ ������ ������.</td>
	</tr>
	<tr>
	<td  colspan = "2"> <input type=checkbox name=component value=0>����/���׼�ȯ</td></tr>
		<tr><td colspan = "2"> <input type=checkbox name=component value=1>�Ǻ�</td></tr>
		<tr><td colspan = "2"> <input type=checkbox name=component value=2>��ȭ/��</td></tr>
		<tr><td colspan = "2"> <input type=checkbox name=component value=3>��</td></tr>
		<tr><td colspan = "2"> <input type=checkbox name=component value=4>�Ƿΰ�</td></tr>
		<tr><td colspan = "2"> <input type=checkbox name=component value=5>���� ����</td></tr>
		<tr><td colspan = "2"> <input type=checkbox name=component value=6>�鿪</td></tr>
	
	
	<tr>
	<td>����</td>
	<td>
	<select name = rate>
		<option selected value="5">5</option>
		<option value="4"> 4</option>
		<option value="3"> 3</option>
		<option value="2"> 2</option>
		<option value="1"> 1</option>
	</select>
	</td>
	</tr>
	<tr>
	<td>����</td>
	<td>
	<input type = text name = review>
	</td>
	<tr>
	<td>��¥</td>
<%
	Calendar cal = Calendar.getInstance();
	String date = String.valueOf(cal.get(java.util.Calendar.YEAR))  +"-"+  String.valueOf((cal.get(java.util.Calendar.MONTH) + 1))+
			"-"+ String.valueOf(cal.get(java.util.Calendar.DATE)); 
	
 %>
 <td>
<input type = text name = date disabled value= "<%=date %>"></td>
	<tr>

	</tr>
	<tr>
				<td>���� ��й�ȣ</td>
				<td><input name="reviewpassword"></td>
			</tr>
	<tr><td colspan = 2 align = center>
		<input type = submit value = "Ȯ��">
		<input type = reset value = "���"></td></tr>
	</table>
	</form>
	</div>	

</body>
</html>