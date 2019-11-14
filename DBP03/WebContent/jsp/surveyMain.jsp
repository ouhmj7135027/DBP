<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form name = "frm1" action="mainprocess.jsp" method = "post">
<table>

		<tr><th>불편하시거나 걱정되는 3가지를 선택하세요.(우선적으로 관리가 필요한 것을 선택하세요.)</th></tr>
		<tr><td> <input type=checkbox name=main value=0>혈관/혈액순환</td></tr>
		<tr><td> <input type=checkbox name=main value=1>피부</td></tr>
		<tr><td> <input type=checkbox name=main value=2>소화/장</td></tr>
		<tr><td> <input type=checkbox name=main value=3>눈</td></tr>
		<tr><td> <input type=checkbox name=main value=4>피로감</td></tr>
		<tr><td> <input type=checkbox name=main value=5>뼈와 관절</td></tr>
		<tr><td> <input type=checkbox name=main value=6>면역</td></tr>
		
	
</table>
<input type = "submit" value = "선택"/>
</form>
	
</body>
</html>