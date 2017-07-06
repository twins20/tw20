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
<h1>TechForest</h1>
<ul class="clearFix">
	<li>
		<a href="http://www.daum.net" target="_blank">
			<p class="glyphicon glyphicon-th" aria-hidden="true"></p>
			상세메뉴
		</a>
	</li>
	<li>
		<p class="glyphicon glyphicon-phone-alt" aria-hidden="true"></p>
		고객센터
	</li>
	<li>
		<p class="glyphicon glyphicon-wrench" aria-hidden="true"></p>
		마이페이지
	</li>
</ul>
</div>

<div class="headerBack">
	<img src="<%=request.getContextPath()%>/images/headerBack.jpg" alt="헤더 배경 이미지">
	<div class="white"></div>
</div>

</header>

<div class="bodyWrapper clearFix">
<!-- 바디	 -->
	<div class="sideBar">
	<!-- 사이드바	 -->
		<ul>
			<li>
				파워랭크
			</li>
			<li>
				기술랭크
			</li>
			<li>
				IT/TECH
			</li>
			<li>
				HAND MADE
			</li>
			<li>
				BEAUTY
			</li>
			<li>
				FOOD
			</li>
			<li>
				FASHION
			</li>
			<li>
				etc.
			</li>
		</ul>
	</div>
	<div class="bodyMain">