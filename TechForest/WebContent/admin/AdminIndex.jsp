<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/header.jsp" %>
<%@ page import="service.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.ArrayList" %> 
<!-- 메인 시작 -->
<style>
	.indexPMoneyChkListTable {
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
	    background-color: gold; 		
	    font-weight: bold;
	     
	  }	   
	 .cell {
	     display: table-cell; 
		 border-bottom: 1px solid #ccc;      
	     padding: 0;
	     margin: 0;
	     height: 35px;
	     vertical-align: middle;	    
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
	     width: 15%;
	  }

</style>

<div class = "adminIndex">
	<div class="indexPMoneyChkListTable">
	  <div class="row thead">
	    <div class="cell col1"> </div>
	    <div class="cell col2">회원</div>
	    <div class="cell col3">충전금액</div>
	    <div class="cell col4">신청일</div>
	    <div class="cell col5">상태</div>
	    <div class="cell col6">작업</div>
	  </div>
<%	
		ArrayList<Map<String, Object>> alist1 = (ArrayList<Map<String, Object>>) request.getAttribute("alist");	
		for(Map<String, Object> hashmap : alist1){			
			MemberVo mbv = (MemberVo) hashmap.get("mbv");
			MoneyVo mnv = (MoneyVo) hashmap.get("mnv");			
%>
		
	  <div class="row">
	    <div class="cell col1">Rnum</div>
	    <div class="cell col2"><%= mbv.getName()%></div>
	    <div class="cell col3"><%= mnv.getChgMoney()%></div>
	    <div class="cell col4"><%= mnv.getInsDate()%></div>
	    <div class="cell col5"><%= mnv.getStatus()%></div>
	    <div class="cell col6"></div>
	  </div>
	  
<%
		}
%>

	</div>
<!--  
	<div class="indexPProjectChkListTable">
	  <div class="row thead">
	    <div class="cell col1"> </div>
	    <div class="cell col2">프로젝트명</div>
	    <div class="cell col3">신청일</div>
	    <div class="cell col4">상태</div>
	    <div class="cell col5">작업</div>
	  </div>
<%	
ArrayList<ProjectVo> blist1 = (ArrayList<ProjectVo>) request.getAttribute("blist");
for(ProjectVo vo : blist1){	
%>
		
	  <div class="row">
	    <div class="cell col1">Rnum</div>
	    <div class="cell col2"><%= vo.getpIdx()%></div>
	    <div class="cell col3"><%= vo.getpName()%></div>
	    <div class="cell col4"><%= vo.getInsDate()%></div>
	    <div class="cell col5"><%= vo.getStatus()%></div>
	    <div class="cell col6"></div>
	  </div>
<%
		}
%>
	</div>
-->
</div>



<!-- 메인 끝 -->
<%@ include file="/footer.jsp" %>