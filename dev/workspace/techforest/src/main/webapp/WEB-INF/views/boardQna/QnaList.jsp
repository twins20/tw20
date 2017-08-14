<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<!-- Attribute start -->
<%@ page import="com.port.service.*" %>
<%@ page import="java.util.*" %>

<!-- Attribute end -->
<%@ include file="/WEB-INF/views/header.jsp" %>
<!-- 바디	 -->
<div class="bodyWrapper clearFix">
<!-- 사이드바	 -->
<%@ include file="/WEB-INF/views/sideBar/boardSideBar.jsp" %>
	<div class="bodyMain"> 
<!-- main start -->

<h3>QNA</h3>

	<div class="QnaTable">
		<div class ="row thead">
			<div class="cell col1">카테고리</div>
			<div class="cell col2">제목</div>
			<div class="cell col3">조회수</div>
			<div class="cell col4">입력시간</div>
		</div>
	
	<c:forEach var="bv" items="${alist}">
		<div class ="row">
			<div class="cell col1">${bv.cate}</div>
			<div class="cell col2"><a href="<c:url value='/QnaCon.do?bIdx=${bv.bIdx}'/>">${bv.title}</a></div>
			<div class="cell col3">${bv.hit}</div>	
			<div class="cell col4">${bv.insDate}</div>
		</div>
		
	</c:forEach>	


	</div>

<div>
  <a class="btn btn-default" href="<c:url value='/QnaWrite.do'/>">게시글 입력</a>
</div>
	

<!-- main end -->
	</div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>