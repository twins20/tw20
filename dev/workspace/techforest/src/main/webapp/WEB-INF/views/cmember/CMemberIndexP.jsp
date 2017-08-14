<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Attribute start -->
<%@ page import="java.util.*" %>
<%@ page import="com.port.service.*" %>
<%
	ArrayList<Map<String, Object>> dataList = (ArrayList<Map<String, Object>>) request.getAttribute("dataList");
	ArrayList<BoardVo> blist = (ArrayList<BoardVo>) request.getAttribute("blist");
%>
<!-- Attribute end -->
<%@ include file="/WEB-INF/views/header.jsp" %>
<!-- 바디	 -->
<div class="bodyWrapper clearFix">
<!-- 사이드바	 -->
<%@ include file="/WEB-INF/views/sideBar/cmemberSideBar.jsp" %>
	<div class="bodyMain"> 
<!-- main start -->

	<h3>진행중인 프로젝트</h3>
	<table class="table table-striped table-bordered table-hover">
		<tr>
			<td>프로젝트 명</td>
			<td>카테고리</td>
			<td>프로젝트 현재 투자금액</td>
			<td>프로젝트 목표 투자금액</td>
			<td>목표도달율</td>
			<td>프로젝트 기술성 평가</td>
		</tr>

		<tr>
			<td><a href="<c:url value='/ProjCon.do?pIdx=${pv.pIdx}'/>">${pv.pName }</a></td>
			<td>${pv.pCate}</td>
			<td>${pv.pnFunds}원</td>
			<td>${pv.ptFunds}원</td>
			<td>${pv.pnFunds * 100 / pv.ptFunds}%</td>
			<td>${pv.pGrade}</td>
		</tr>
	</table>
	
	<h3>프로젝트 댓글리스트</h3>
	<table class="table table-striped table-bordered table-hover">
		<tr>
			<td>내용</td>
			<td>작성자</td>
			<td>작성일</td>
		</tr>
<%
	for(Map<String, Object> data : dataList){
%>	
		<tr>
			<td><%=data.get("COMMENTS") %></td>
			<td><%=data.get("NAME") %></td>
			<td><%=data.get("INSDATE") %></td>
		</tr>
<%	} %>
	</table>


	
<!-- main end -->
	</div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>