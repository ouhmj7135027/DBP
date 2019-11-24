<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@page import="service.dto.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>body { margin:0; padding:0; font-family:'맑은 고딕', verdana; }  
	a { color:#05f; text-decoration:none; }  
	a:hover { text-decoration:underline; }   
	h1, h2, h3, h4, h5, h6 { margin:0; padding:0; }  
	ul, lo, li { margin:0; padding:0; list-style:none; }  
	/* ---------- */   
	div#root { width:900px; margin:0 auto; }  
	header#header { }  nav#nav { }  section#container { }   
	section#content { float:right; width:700px; }   
	ul { float:left; width:180px; }   
	section#container::after { content:""; display:block; clear:both; }  
	footer#footer { background:#eee; padding:20px; }   
	/* ---------- */   
	header#header div#header_box { text-align:center; padding:30px 0; }  
	header#header div#header_box h1 { font-size:50px; }  
	header#header div#header_box h1 a { color:#000; }   
	nav#nav div#nav_box { font-size:14px; padding:10px; text-align:right; }  
	nav#nav div#nav_box li { display:inline-block; margin:0 10px; }  
	nav#nav div#nav_box li a { color:#333; }   
	section#container { }   
	
	h3 { font-size:22px; margin-bottom:20px; text-align:center; }  
	li { font-size:16px; text-align:center; }  
	li a { color:#000; display:block; padding:10px 0; }  
	li a:hover { text-decoration:none; background:#eee; } 
	
	li { position:relative; } 
	li:hover { background:#eee; }   
	li > ul.low { display:none; position:absolute; top:0; left:180px;  } 
	li:hover > ul.low { display:block; } 
	li:hover > ul.low li a { background:#eee; border:1px solid #eee; } 
	li:hover > ul.low li a:hover { background:#fff;} 
	li > ul.low li { width:180px; }
	  
	footer#footer { margin-top:100px; border-radius:50px 50px 0 0; }  
	footer#footer div#footer_box { padding:0 20px; }  
</style>
<style>
 section#content ul li { display:inline-block; margin:10px; }
 section#content div.goodsThumb img { width:200px; height:200px; }
 section#content div.goodsName { padding:10px 0; text-align:center; }
 section#content div.goodsName a { color:#000; }
</style>
</head>
<body>
<section id="container">
		<div id="container_box">
			<section id="content">
				<ul>
				 <c:forEach items="${list}" var="product">
				 <li>
				<div class="goodsThumb">
					 <img src="<c:url value='${product.imgsrc}' />">
					 </div> 				 
				  <div class="goodsName">
				    <p>${product.p_name}</p>
				    <p>${product.effect} </p>
				  </div>
				 </li>
				 </c:forEach>
				</ul>
			</section>
			</div>
			</section>
</body>
</html>