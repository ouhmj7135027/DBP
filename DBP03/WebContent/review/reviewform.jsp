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