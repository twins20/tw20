<!-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> -->
<!DOCTYPE html>
<html lang="ko">
<head>
  <title>Tech Forest</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <script src="https://code.jquery.com/jquery-3.2.1.min.js" integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4=" crossorigin="anonymous"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
	/*float clearFix*/

	.clearFix{
		*zoom:1;
	}
	.clearFix:after{
		content:'';
		clear:both;
		display:block;
	}

	/*body*/
	a:visited {
		color: #fff;
	}
	a:hover {
		text-decoration: none;
	}

	@import url(http://fonts.googleapis.com/earlyaccess/jejugothic.css);
	body {
		font-family: 'Jeju Gothic', sans-serif;
		color: #555;
	}
   	header {
   		position: relative;
   		background: rgba(0,0,0,0.4);
   		color: #fff;
   	}
   	.headerWrapper {
   		width: 1100px;
   		height: 200px;
   		margin: 0 auto;
   	}
   	.headerWrapper h1 {
   		float: left;
   		margin-top : 50px;
   		font-weight: bold;
   	}
   	.headerWrapper ul {
   		float: right;
   		list-style: none;
   		padding: 20px 0;
   		margin: 30px 0 0;
   	}
   	.headerWrapper li {
   		float: left;
   		margin-left: 30px;
   		font-size: 10px;
   	}
   	.headerWrapper p {
   		display: block;
   		font-size: 25px;
   		text-align: center;
   	}
   	.headerBack {
   		position: absolute;
   		top: 0;
   		z-index: -1;
   		width: 100%;
   	}
   	.headerBack img {
   		position: absolute;
   		top: -530px;
   		width: 100%;
   	}
   	.headerBack .white{
   		position: absolute;
   		top: 200px;
   		background: #fff;
   		width: 100%;
   		height: 700px;
   	}
   	.bodyWrapper {
   		width: 1100px;
   		margin: 0 auto;
   	}
   	.bodyWrapper .sideBar {
   		float: left;
   		width: 200px;
   		min-height: 500px;
   		background: rgba(0,0,0,0.03);   		
   	}
   	.bodyWrapper .sideBar ul{
   		list-style: none;
   		padding: 30px 0 0 15px;
   		margin: 0;
   		font-weight: bold;
   		font-size: 14px;
   	}
   	.bodyWrapper .sideBar li{
   		padding: 10px;
   	}
	.bodyMain {
		float: left;
		width: 900px;
		min-height: 500px;
		border-right: 1px solid #ddd;
	}
   	footer {
   		width: 1100px;
   		padding: 20px;
   		margin: 0 auto;
    	background: rgba(0,0,0,0.05);
    	border-top: 1px solid #555;
   	}
   	.fundAlert{
  		padding: 20px;
   		margin: 0 auto;
  		background: #fff;
   	}
   	.fundAlert .fundAlertTitle{
   		margin-left: 150px;
   		font-size: 30px;
   		font-weight: bold;
   	}
   	.fundAlert .fundAlertCon{
   		margin-left: 150px;
   		font-size: 20px;
   		font-weight: bold;
   		line-height: 1em;
   	}
  	.siteMap {
  		margin-top: 20px;
  		font-weight: bold;
  	}
  	.siteMap .subMapMain {
  		float: left;
  		width: 200px;
  		padding: 20px;
  		background: rgba(0,0,0,0.1);
  	}
	.siteMap .subMap {
  		float: left;
  		width: 200px;
  		padding: 20px;
  		margin-left: 15px;
  	}
	.siteMap h4{
  		padding: 10px 0 20px;
  		margin: 0;
  		font-weight: bold;
  	}
  	.siteMap ul{
  		list-style: none;
  		padding: 0;
  		margin: 0 0 0 5px;
  	}
  	.siteMap li{
  		margin-bottom: 10px;
  	}
  	.siteMap li:before{
  		content: "-";
   	}
   	.siteMap .subMap2first {
   		margin-bottom: 50px;
   	}

   	/*윗부분 수정금지*/
   	




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
	<img src="headerBack2.jpg" alt="헤더 배경 이미지">
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
	<!-- 메인 -->
	bodyMain

	</div>
</div>

<footer class="clearFix">
<!-- 푸터 -->
	<div class="fundAlert">
		<p class="fundAlertTitle">투자위험고지</p>
		<p class="fundAlertCon">비상장 기업에 대한 투자는 높은 기대수익만큼 손실가능성을 가지고 있습니다.</p>
		<p class="fundAlertCon">투자 전에 투자 위험에 대한 내용을 확인해 주세요.</p>
	</div>
	<div class="siteMap">
		<div class="subMapMain">
			<h4>MainPage</h4>
			<ul>
				<li>
					파워랭킹
				</li>
				<li>
					테크랭킹
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
		<div class="subMap">
			<div class="subMap2first">
				<h4>About Us</h4>
				<ul>
					<li>
						About Us
					</li>
				</ul>
			</div>
			<div>
				<h4>Contact Us</h4>
				<ul>
					<li>
						공지사항
					</li>
					<li>
						이벤트	
					</li>
					<li>
						FAQ
					</li>
					<li>
						QNA
					</li>
				</ul>
			</div>
		</div>
		<div class="subMap">
			<h4>이용안내</h4>
			<ul>
				<li>
					가드닝 시작하기					
				</li>
				<li>
					이용약관
				</li>
				<li>
					개인정보 처리방침
				</li>
			</ul>
		</div>
		<div class="subMap">
			<h4>뉴스</h4>
			<ul>
				<li>
					카테고리 뉴스
				</li>
			</ul>
		</div>
		<div class="subMap">
			<h4>Members</h4>
			<ul>
				<li>
					회원가입
				</li>
				<li>
					My Page
				</li>
			</ul>
		</div>
	</div>
</footer>
</body>
</html>