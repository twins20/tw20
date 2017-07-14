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
	ArrayList<BoardVo> alist1 = (ArrayList<BoardVo>) request.getAttribute("alist");
	for(BoardVo vo : alist1){
%>
<div class="Wrapper">
	<div class="panel panel-primary">
	  <div class="panel-heading">
	    <h3 class="panel-title">제목</h3>
	  </div>
	  <div class="panel-body">
	   	<%= vo.getTitle() %>
	  </div>
	</div>
	<div class="panel panel-primary panelMiddle">
	  <div class="panel-heading">
	    <h3 class="panel-title">작성자</h3>
	  </div>
	  <div class="panel-body">
	   	<%= vo.getNick() %>
	  </div>
	</div>
	<div class="panel panel-primary panelMiddle">
	  <div class="panel-heading">
	    <h3 class="panel-title">카테고리</h3>
	  </div>
	  <div class="panel-body">
	   	<%= vo.getCate() %>
	  </div>
	</div>
	<div class="panel panel-primary panelMiddle">
	  <div class="panel-heading">
	    <h3 class="panel-title">조회수</h3>
	  </div>
	  <div class="panel-body">
	   	<%= vo.getHit() %>
	  </div>
	</div>
	<div class="panel panel-primary panelMiddle">
	  <div class="panel-heading">
	    <h3 class="panel-title">추천</h3>
	  </div>
	  <div class="panel-body">
	   	<%= vo.getGood()%>
	  </div>
	</div>
	<div class="panel panel-primary panelMiddle">
	  <div class="panel-heading">
	    <h3 class="panel-title">반대</h3>
	  </div>
	  <div class="panel-body">
	   	<%= vo.getBad() %>
	  </div>
	</div>
	<div class="panel panel-primary panelMiddle">
	  <div class="panel-heading">
	    <h3 class="panel-title">작성일</h3>
	  </div>
	  <div class="panel-body">
	   	<%= vo.getInsDate()%>
	  </div>
	</div>
	<div class="panel panel-primary panelMiddle">
	  <div class="panel-heading">
	    <h3 class="panel-title">수정일</h3>
	  </div>
	  <div class="panel-body">
	   	<%= vo.getModDate()%>
	  </div>
	</div>
	<div class="panel panel-primary">
	  <div class="panel-heading">
	    <h3 class="panel-title">내용</h3>
	  </div>
	  <div class="panel-body">
	   	<%= vo.getContents()%>
	  </div>
	</div>
		
	<div>
		<a href="<%=request.getContextPath()%>/AdminNoticeDel_Action.do?bIdx=<%= vo.getbIdx()%>"><button class="btn btn-primary pull-right">삭제</button></a>
	</div>
	<div>
		<a href="<%=request.getContextPath()%>/AdminNoticeMod.do?bIdx=<%= vo.getbIdx()%>"><button class="btn btn-primary pull-right">수정</button></a>
	</div>
	<div>
		<a href="<%=request.getContextPath()%>/AdminNoticeList.do"><button class="btn btn-primary pull-right">목록</button></a>
	</div>	
</div>

<% } %>
	

<!-- main end -->
	</div>
</div>
<%@ include file="/footer.jsp" %>