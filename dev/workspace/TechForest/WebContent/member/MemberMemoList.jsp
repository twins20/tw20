<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!-- Attribute start -->
<%@ page import="java.util.*" %>
<%@ page import="service.MemoVo" %>
<%
ArrayList<MemoVo> alist = (ArrayList<MemoVo>) request.getAttribute("alist");
%>
<!-- Attribute end -->
<%@ include file="/header.jsp" %>
<!-- 바디	 -->
<div class="bodyWrapper clearFix">
<!-- 사이드바	 -->
<%@ include file="/sideBar/imemberSideBar.jsp" %>
	<div class="bodyMain"> 
<!-- main start -->
	
	<table class="table table-striped table-bordered table-hover">
	<tr>
	<td>순번</td>
	<td>보낸사람 idx</td>
	<td>받는사람 idx</td>
	<td>내용</td>
	<td>상태</td>
	</tr>
<%
	for(MemoVo vo : alist){
%>
	<tr>
	<td><%=vo.getrNum() %></td>
	<td><%=vo.getSendIdx() %></td>
	<td><%=vo.getRecvIdx() %></td>
	<td><a href="<%=request.getContextPath()%>/MemberMemoCon.do?memoIdx=<%=vo.getMemoIdx()%>"><%=vo.getContents() %></a></td>
	<td><%=vo.getStatus() %></td>
	</tr>
<% } %>
	</table>	

<!-- main end -->
	</div>
</div>
<%@ include file="/footer.jsp" %>