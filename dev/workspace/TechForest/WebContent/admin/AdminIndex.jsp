<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!-- Attribute start -->
<%@ page import="service.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.ArrayList" %> 
<!-- Attribute end -->
<%@ include file="/header.jsp" %>
<!-- main start -->
<style>
.btn-default{
	margin-bottom: 3px;
}
.adminIndexWrapper{
	width:100%;
	padding: 0;
	margin: 0; 	 	
}
</style>

<div class="adminIndexWrapper">
	<div class="divTable">  
	 <div class="clearFix rowTitle">
	   <div class="col col6_1">No </div>
	   <div class="col col6_2">회원</div>
	   <div class="col col6_3">충전금액</div>
	   <div class="col col6_4">신청일</div>
	   <div class="col col6_5">상태</div>
	   <div class="col col6_6">작업</div>
	</div>
<%	
	ArrayList<Map<String, Object>> alist1 = (ArrayList<Map<String, Object>>) request.getAttribute("alist");	
	for(Map<String, Object> hashmap : alist1){			
		MemberVo mbv = (MemberVo) hashmap.get("mbv");
		MoneyVo mnv = (MoneyVo) hashmap.get("mnv");
		
		String statusMsg = null;
		String statusBtn = null;
		if(mnv.getStatus() == 0){
			statusMsg = "승인 대기";
			statusBtn = "<button type='button' class='btn btn-default'>승인</button>";
		}else{
			statusMsg = "승인 완료";
			statusBtn = "";
		}		
%>		
	  <div class="clearFix">
	    <div class="col col6_1"_>No</div>
	    <div class="col col6_2"><%= mbv.getName()%></div>
	    <div class="col col6_3"><%= mnv.getChgMoney()%></div>
	    <div class="col col6_4"><%= mnv.getInsDate()%></div>	    
	    <div class="col col6_5"><%= statusMsg%></div>	    
	    <div class="col col6_6"><%= statusBtn%></div>
	  </div>	  
<%
		}
%>
	</div> 


</div>



<!-- main end -->
<%@ include file="/footer.jsp" %>