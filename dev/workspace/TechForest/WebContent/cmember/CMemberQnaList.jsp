<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!-- Attribute start -->
<%@ page import="java.util.*" %>
<%@ page import="service.BoardVo" %>
<%@ page import="service.ProjectVo" %>
<%
	ArrayList<Map<String, Object>> alist = (ArrayList<Map<String, Object>>) request.getAttribute("alist");
%>
<!-- Attribute end -->
<%@ include file="/header.jsp" %>
<!-- 바디	 -->
<div class="bodyWrapper clearFix">
<!-- 사이드바	 -->
<%@ include file="/sideBar/cmemberSideBar.jsp" %>
	<div class="bodyMain"> 
<!-- main start -->

	<table class="table table-striped table-bordered table-hover">
	<tr>
	<td>카테고리</td>
	<td>프로젝트</td>
	<td>제목</td>
	<td>조회수</td>
	<td>작성일</td>
	<td>상태</td>
	</tr>
<%
	int status = 0;
	String qnaStatus = null;

	for(Map<String, Object> data : alist){
		BoardVo bvo = (BoardVo) data.get("bvo");
		ProjectVo pvo = (ProjectVo) data.get("pvo");
		status = (Integer) data.get("status");
		
		if(status == 1){
			qnaStatus = "질문";
		}else if(status == 2){
			qnaStatus = "답변";
		}
		
%>	
	<tr>
	<td><%=bvo.getCate() %></td>
	<td><a href="<%=request.getContextPath()%>/ProjCon.do?pIdx=<%=pvo.getpIdx()%>"><%=pvo.getpName() %></a></td>
	<td><a href="<%=request.getContextPath()%>/CMemberQnaCon.do?bIdx=<%=bvo.getbIdx()%>"><%=bvo.getTitle() %></a></td>
	<td><%=bvo.getHit() %></td>
	<td><%=bvo.getInsDate() %></td>
	<td><%=qnaStatus %></td>
	</tr>
<% } %>
	</table>
	

<!-- main end -->
	</div>
</div>
<%@ include file="/footer.jsp" %>