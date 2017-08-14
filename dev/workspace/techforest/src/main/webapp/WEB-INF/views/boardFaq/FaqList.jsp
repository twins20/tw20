<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	
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

<h3>FAQ</h3>

	<div class="FaqTable">
		<div class ="row thead">
			<div class="cell col1"></div>
			<div class="cell col2">카테고리</div>
			<div class="cell col3">제목</div>
			<div class="cell col4">조회수</div>
			<div class="cell col5">입력시간</div>
		</div>	
	
	<c:forEach var="bv" items="${alist }">
		<div class ="row">
			<div class="cell col1"></div>	
			<div class="cell col2">${bv.cate}</div>
			<div class="cell col3"><a href="<c:url value='/FaqCon.do?bIdx=${bv.bIdx}'/>">${bv.title}</a></div>
			<div class="cell col4">${bv.hit}</div>
			<div class="cell col5">${bv.insDate}</div>
		</div>
	</c:forEach>
	</div>
<!-- 페이징 처리 부분

<!-- main end -->
	</div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>