<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!-- Attribute start -->
<%@ page import="java.util.*" %>
<%@ page import="com.port.service.*" %>
<!-- Attribute end -->
<%@ include file="/WEB-INF/views/header.jsp" %>
<!-- 바디	 -->
<div class="bodyWrapper clearFix">
<!-- 사이드바	 -->
<%@ include file="/WEB-INF/views/sideBar/projectSideBar.jsp" %>
	<div class="bodyMain"> 
<!-- main start -->
	
	<table class="table table-striped table-bordered table-hover">
		<tr>
			<td>프로젝트 명</td>
			<td>프로젝트 카테고리</td>
			<td>프로젝트 목표 도달금액</td>
			<td>프로젝트 현재 투자금액</td>
			<td>프로젝트 기술 등급</td>
		</tr>
	
		<c:forEach var="pv" items="${plist }">
			<tr>
				<td><a href="<c:url value='/ProjectCon.do?pIdx=${pv.pIdx }' />">${pv.pName }</a></td>
				<td>${pv.pCate }</td>
				<td>${pv.ptFunds }원</td>
				<td>${pv.pnFunds }원</td>
				<td>${pv.pGrade }</td>
			</tr>
		</c:forEach>
	</table>




	

<!-- main end -->
	</div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>