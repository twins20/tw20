<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<!-- Attribute start -->
<%@ page import="service.*" %>
<%@ page import="java.util.*" %>
<%  
ArrayList<BoardVo> alist = (ArrayList<BoardVo>) request.getAttribute("alist");
%>
<!-- Attribute end -->
<%@ include file="/header.jsp" %>
<!-- 바디	 -->
<div class="bodyWrapper clearFix">
<!-- 사이드바	 -->
<%@ include file="/sideBar/boardSideBar.jsp" %>
	<div class="bodyMain"> 
<!-- main start -->
<style>
	.FaqTable {
	     display: table; 
	     width: 100%;
	     text-align: center; 	     
	     font-size: 15px;	    
	     border: 1px solid #eee; 
	  }	     
	 .row {
	     display: table-row;
	      
	   }   
	 .thead{
	    background-color: gray; 		
	    font-weight: bold;
	     
	  }	   
	 .cell {
	     display: table-cell; 
		 border-bottom: 1px solid #ccc;      
	     padding: 0;
	     margin: 0;
	     width: 174px;
	     height: 35px;
	     vertical-align: middle;
	     text-align: center;	    
	  }	   
	 .cell col1 {
	     width: 5%;
	  }
	 .cell col2 {
	     width: 25%;
	  }      
	 .cell col3 {
	     width: 20%;
	  }      
	 .cell col4 {
	     width: 20%;
	  }
	 .cell col5 {
	     width: 15%;
	  }
	 .cell col6 {
	     width: 126px;
	  }

</style>

<h3>FAQ</h3>

<div class="FaqTable">
	<div class ="row thead">
		<div class="cell col1"></div>
		<div class="cell col2">카테고리</div>
		<div class="cell col3">제목</div>
		<div class="cell col4">조회수</div>
		<div class="cell col5">입력시간</div>
	</div>
	
<% for(BoardVo vo : alist){  %> 	
	
	<div class ="row">
		<div class="cell col1"><%=vo.getrNum() %></div>	
		<div class="cell col2"><%=vo.getCate() %></div>
		<div class="cell col3"><a href="<%=request.getContextPath()%>/FaqCon.do?bIdx=<%=vo.getbIdx() %>"><%=vo.getTitle() %></a></div>
		<div class="cell col4"><%=vo.getHit() %></div>
		<div class="cell col5"><%=vo.getInsDate() %></div>
	</div>

<% 
	} 
%>
</div>

<!-- main end -->
	</div>
</div>
<%@ include file="/footer.jsp" %>