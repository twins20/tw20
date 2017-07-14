<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
  <title>Tech Forest</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <%@ include file="/css.jsp" %>
  <script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>

  </style>
 </head>
<body>
<header class="clearFix">
<!-- 헤더 -->

<div class="headerWrapper">
	<a href="index.jsp" >
		<h1>TechForest</h1>
	</a>
<ul class="clearFix">
<%
	Object idx = session.getAttribute("idx");
%>
<%	
	if(idx == null){
%>
	<li>
		<a href="<%=request.getContextPath()%>/MemberLogIn.do" method="post">
			<p class="glyphicon glyphicon-user" aria-hidden="true"></p>
			로그인
		</a>
	</li>
<% }else{ %>
	<li>
		<a href="<%=request.getContextPath()%>/MemberLogOut_Action.do" method="post">
			<p class="glyphicon glyphicon-remove" aria-hidden="true"></p>
			로그아웃
		</a>
	</li>
<% } %>
	<li>
		<a href="http://www.daum.net" target="_blank">
			<p class="glyphicon glyphicon-th" aria-hidden="true"></p>
			상세메뉴
		</a>
	</li>
	<li>
		<a href="<%=request.getContextPath()%>/NoticeList.do" method="post">
			<p class="glyphicon glyphicon-phone-alt" aria-hidden="true"></p>
			고객센터
		</a>
	</li>
	<li>
		<a href="<%=request.getContextPath()%>/IMemberIndexP.do">
			<p class="glyphicon glyphicon-wrench" aria-hidden="true"></p>
			투자자 마이페이지
		</a>
	</li>
	<li>
		<a href="<%=request.getContextPath()%>/CMemberIndexP.do"">
			<p class="glyphicon glyphicon-wrench" aria-hidden="true"></p>
			사업자 마이페이지
		</a>
	</li>
	<li>
		<a href="<%=request.getContextPath()%>/AdminIndex.do">
			<p class="glyphicon glyphicon-wrench" aria-hidden="true"></p>
			관리자 마이페이지
		</a>
	</li>
</ul>
</div>

<div class="headerBack">
	<img src="<%=request.getContextPath()%>/images/headerBack.jpg" alt="헤더 배경 이미지">
	<div class="white"></div>
</div>

</header>
