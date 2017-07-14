<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%> 
<!-- Attribute start -->
<%@ page import="java.util.*" %>
<%@ page import="service.ProjectVo" %>
<%@ page import="service.FundVo" %>
<%@ page import="service.BoardVo" %>
<% 
	ArrayList<Map<String,Object>> plist = (ArrayList<Map<String,Object>>) request.getAttribute("plist");
	ArrayList<BoardVo> qlist = (ArrayList<BoardVo>) request.getAttribute("qlist");
%>
<!-- Attribute end -->
<%@ include file="/header.jsp" %>
<!-- 바디	 -->
<div class="bodyWrapper clearFix">
<!-- 사이드바	 -->
<%@ include file="/sideBar/imemberSideBar.jsp" %>
	<div class="bodyMain"> 
<!-- main start -->
<style>
.btn-default{
	margin-bottom: 3px;
}

.imemWrapper{
	width:100%;
	padding: 0;
	margin: 0; 	 	
}

.imemDivTable{
	margin-top: 10px;
	margin-bottom: 40px;
}

.imemTitle{
	font-size: 20px;
	margin-top: 20px;
	margin-left: 10px;
	font-weight: bold;
}
</style>

<p class="imemTitle">참가 프로젝트 </p>
<div class="imemWrapper">
	<div class="imemDivTable">
		<div class="clearFix rowTitle">
			<div class="col col5_1">No</div>
			<div class="col col5_2">프로젝트 명</div>
			<div class="col col5_3">투자금액</div>
			<div class="col col5_4">투자일</div>
			<div class="col col5_5">목표달성률</div>
		</div>	
<%
	for(Map<String, Object> plist2 : plist){
		ProjectVo pvo = (ProjectVo) plist2.get("vo");
		FundVo fvo = (FundVo) plist2.get("vo2");
		
		float goalRate = 0;
		float pnFunds = 0;
		float ptFunds = 0;
		pnFunds = pvo.getPnFunds();
		ptFunds = pvo.getPtFunds();
		goalRate = (pnFunds / ptFunds) * 100;
%>
<div class="clearFix">
	<div>
		<div class="col col5_1"><%=pvo.getrNum()%></div>
		<div class="col col5_2"><%=pvo.getpName()%></div>
		<div class="col col5_3"><%=fvo.getInFunds() %>원</div>
		<div class="col col5_4"><%=fvo.getInsDate() %></div>
		<div class="col col5_5"><%=fvo.getInsDate() %></div>
	</div>
</div>	
<%
	}
%>
	
<p class="imemTitle">Qna리스트</p>
		<div class="clearFix rowTitle">
			<div class="col col5_1">No</div>
			<div class="col col5_2">카테고리</div>
			<div class="col col5_3">제목</div>
			<div class="col col5_4">상태</div>
			<div class="col col5_5">작성일</div>
		</div>	
<%
	String status = null;
	for(BoardVo bvo : qlist){ 
		if(bvo.getbDepth() > 1){
			status = "답변완료";
		}else{
			status = "답변대기";
		}
%>
<div class="clearFix">
	<div>
		<div class="col col5_1"><%=bvo.getrNum() %></div>
		<div class="col col5_2"><%=bvo.getCate() %></div>
		<div class="col col5_3"><%=bvo.getTitle() %></div>
		<div class="col col5_4"><%=status %></div>
		<div class="col col5_5"><%=bvo.getInsDate() %></div>
	</div>
</div>	
<% 
	} 
%>
	</div>
</div>
<!-- main end -->
	</div>
</div>
<%@ include file="/footer.jsp" %>