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


<h3>NOTICE</h3>

	<div class="NoticeTable">
		<div class ="row thead">
			<div class="cell col2">제목</div>
			<div class="cell col3">조회수</div>
			<div class="cell col4">날짜</div>
		</div>	
	
<c:forEach var="bv" items="${alist}">
	<div class ="row">
		<div class="cell col2"><a href="<c:url value='/'/>/NoticeCon.do?bIdx=${bv.bIdx}">${bv.title}</a></div>
		<div class="cell col3">${bv.hit}</div>
		<div class="cell col4">${bv.insDate}</div>
	</div>
	
	</c:forEach>

</div>

<!-- main end -->
	</div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>