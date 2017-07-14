<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!-- Attribute start -->
<%@ page import="java.util.*" %>
<%@ page import="service.ProjectVo" %>
<%
	ArrayList<ProjectVo> alist = (ArrayList<ProjectVo>) request.getAttribute("alist");
%>
<!-- Attribute end -->
<%@ include file="/header.jsp" %>
<!-- 바디	 -->
<div class="bodyWrapper clearFix">
<!-- 사이드바	 -->
<%@ include file="/sideBar/projectSideBar.jsp" %>
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
<%
	for(ProjectVo vo : alist){
%>	
	<tr>
	<td><a href="<%=request.getContextPath()%>/ProjCon.do?pIdx=<%=vo.getpIdx() %>"><%=vo.getpName() %></a></td>
	<td><%=vo.getpCate() %></td>
	<td><%=vo.getPtFunds() %></td>
	<td><%=vo.getPnFunds() %></td>
	<td><%=vo.getpGrade() %></td>
	</tr>
<% } %>
	</table>




	
<!-- main end -->
	</div>
</div>
<%@ include file="/footer.jsp" %>