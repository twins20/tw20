<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!-- Attribute start -->
<%@ page import="service.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<!-- Attribute end -->
<%@ include file="/header.jsp" %>
<!-- 바디	 -->
<div class="bodyWrapper clearFix">
<!-- 사이드바	 -->
<%@ include file="/sideBar/adminSideBar.jsp" %>
	<div class="bodyMain"> 
<!-- main start -->
<style>
/*
.panel-primary{
	padding: 0;
	margin-bottom: 3px;
}
.panel-heading{	
	display: inline-block;	
	float: left;	
	height: 35px;
	width: 78px;
	text-align: center;
	border-radius: 3px;
}
.panel-body{
	display: inline-block;
	text-align: center;
	height: 25px;
	padding-top: 9px;
	padding-left: 25px;	
}
.panelMiddle{
	display: inline-block;
	float: left;
	width: 439px;	
}
*/

</style>
<%
	ArrayList<Map<String, Object>> alist1 = (ArrayList<Map<String, Object>>) request.getAttribute("alist");
	for(Map<String, Object> hashmap : alist1){
		BoardVo bvo = (BoardVo) hashmap.get("bvo");
		ProjectVo pvo = (ProjectVo) hashmap.get("pvo");
%>
<div class="Wrapper">
	<div class="panel panel-primary">
	  <div class="panel-heading">
	    <h3 class="panel-title">제목</h3>
	  </div>
	  <div class="panel-body">
	   	<%= bvo.getTitle() %>
	  </div>
	</div>
	<div class="panel panel-primary panelMiddle">
	  <div class="panel-heading">
	    <h3 class="panel-title">작성자</h3>
	  </div>
	  <div class="panel-body">
	   	<%= bvo.getIdx()%>
	  </div>
	</div>
	<div class="panel panel-primary panelMiddle">
	  <div class="panel-heading">
	    <h3 class="panel-title">카테고리</h3>
	  </div>
	  <div class="panel-body">
	   	<%= bvo.getCate() %>
	  </div>
	</div>
	<div class="panel panel-primary panelMiddle">
	  <div class="panel-heading">
	    <h3 class="panel-title">조회수</h3>
	  </div>
	  <div class="panel-body">
	   	<%= bvo.getHit() %>
	  </div>
	</div>
	<div class="panel panel-primary panelMiddle">
	  <div class="panel-heading">
	    <h3 class="panel-title">추천</h3>
	  </div>
	  <div class="panel-body">
	   	<%= bvo.getGood()%>
	  </div>
	</div>
	<div class="panel panel-primary panelMiddle">
	  <div class="panel-heading">
	    <h3 class="panel-title">반대</h3>
	  </div>
	  <div class="panel-body">
	   	<%= bvo.getBad() %>
	  </div>
	</div>
	<div class="panel panel-primary panelMiddle">
	  <div class="panel-heading">
	    <h3 class="panel-title">작성일</h3>
	  </div>
	  <div class="panel-body">
	   	<%= bvo.getInsDate()%>
	  </div>
	</div>
	<div class="panel panel-primary panelMiddle">
	  <div class="panel-heading">
	    <h3 class="panel-title">수정일</h3>
	  </div>
	  <div class="panel-body">
	   	<%= bvo.getModDate()%>
	  </div>
	</div>
	<div class="panel panel-primary">
	  <div class="panel-heading">
	    <h3 class="panel-title">내용</h3>
	  </div>
	  <div class="panel-body">
	   	<%= bvo.getContents()%>
	  </div>
	</div>
	<div class="panel panel-primary">
	  <div class="panel-heading">
	    <h3 class="panel-title">관련 프로젝트</h3>
	  </div>
	  <div class="panel-body">
	   	<%= pvo.getpName()%>
	  </div>
	</div>
		
	<div>
		<a href="<%=request.getContextPath()%>/AdminNewsDel_Action.do?bIdx=<%= bvo.getbIdx()%>"><button class="btn btn-primary pull-right">삭제</button></a>
	</div>
	<div>
		<a href="<%=request.getContextPath()%>/AdminNewsMod.do?bIdx=<%= bvo.getbIdx()%>"><button class="btn btn-primary pull-right">수정</button></a>
	</div>
	<div>
		<a href="<%=request.getContextPath()%>/AdminNewsList.do"><button class="btn btn-primary pull-right">목록</button></a>
	</div>	
</div>

<% } %>
	

<!-- main end -->
	</div>
</div>
<%@ include file="/footer.jsp" %>