<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
.container {
  position: absolute;
  width : 100%
}
table {
	width : 100%
	
}
.container .btn {
  position: absolute;;
  top: 50%;
  left: 95%;
  transform: translate(-70%, -70%);
  -ms-transform: translate(-70%, -70%);
  background-color: #5fbee3;
  color: white;
  font-size: 16px;
  padding: 12px 24px;
  border: none;
  cursor: pointer;
  border-radius: 5px;
  text-align: center;
}
</style>
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
        <a class="nav-link" href="<c:url value='/user/login/form' />">���ı�</a>
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
<div class = "container">
  <img src="<c:url value='/image/pills.png' />" style = "width:140%;height:250px;" alt="Responsive image">
   <a href="<c:url value='/survey' />"><button class="btn" >�� �ǰ����� �˱�</button></a>
   </div>
   <br><br><br><br><br><br><br><br><br><br><br>
   <div>
  <table >
  <tr>
  	<td>
  		��õ��ǰ1 
  		</td>
  		<td>
  		��õ��ǰ2
  		</td>
  		<td>
  		��õ��ǰ3 
  		</td>
  	</tr>
  </table>
  <p>
  
</div>
</body>
</html>