<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import = "java.util.Calendar" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div align = "center">
	<HR>
	<form name = form1 method = "post" action = "<c:url value='/review/create' />">
	<table border = 1 cellspacing = "1" cellpadding = "5">
	<tr>
	<td>이름 </td>
	<td><input type = text size =20 name = name disabled value = "<%= session.getAttribute("userId") %>"></td>
	</tr>
	<tr>
	<td  colspan = "2"> 리뷰할 성분을 고르세요.</td>
	</tr>
	<tr>
	<td  colspan = "2"> <input type=checkbox name=component value=0>혈관/혈액순환</td></tr>
		<tr><td colspan = "2"> <input type=checkbox name=component value=1>피부</td></tr>
		<tr><td colspan = "2"> <input type=checkbox name=component value=2>소화/장</td></tr>
		<tr><td colspan = "2"> <input type=checkbox name=component value=3>눈</td></tr>
		<tr><td colspan = "2"> <input type=checkbox name=component value=4>피로감</td></tr>
		<tr><td colspan = "2"> <input type=checkbox name=component value=5>뼈와 관절</td></tr>
		<tr><td colspan = "2"> <input type=checkbox name=component value=6>면역</td></tr>
	
	
	<tr>
	<td>별점</td>
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
	<td>리뷰</td>
	<td>
	<input type = text name = review>
	</td>
	<tr>
	<td>날짜</td>
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
				<td>수정 비밀번호</td>
				<td><input name="reviewpassword"></td>
			</tr>
	<tr><td colspan = 2 align = center>
		<input type = submit value = "확인">
		<input type = reset value = "취소"></td></tr>
	</table>
	</form>
	</div>	

</body>
</html>