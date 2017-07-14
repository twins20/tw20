<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!-- Attribute start -->
<%@ page import="java.util.*" %>
<%@ page import="service.BoardVo" %>
<%
	ArrayList<BoardVo> alist = (ArrayList<BoardVo>) request.getAttribute("alist"); 
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
	<td>순번</td>
	<td>카테고리</td>
	<td>제목</td>
	<td>등록일</td>
	</tr>
<%
	for(BoardVo vo : alist){
%>	
	<tr>
	<td><%=vo.getrNum() %></td>
	<td><%=vo.getCate() %></td>
	<td><a href="<%=request.getContextPath()%>/CMemberNewsCon.do?bIdx=<%=vo.getbIdx()%>"><%=vo.getTitle() %></a></td>
	<td><%=vo.getInsDate() %></td>
	</tr>
<% } %>
	</table>
	
	<a class="btn btn-default" href="<%=request.getContextPath() %>/CMemberNewsWrite.do" role="button">뉴스 작성</a>



	

<!-- main end -->
	</div>
</div>
<%@ include file="/footer.jsp" %>