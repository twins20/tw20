<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!-- Attribute start -->
<%@ page import="java.util.*" %>
<%@ page import="service.ProjectVo" %>
<%@ page import="service.FundVo" %>
<%
	ArrayList<Map<String, Object>> dataList = (ArrayList<Map<String, Object>>) request.getAttribute("dataList");
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

<p class="imemTitle">펀드리스트</p>
<div class="imemWrapper">
	<div class="imemDivTable">
		<div class="clearFix rowTitle">
			<div class="col col3_1">프로젝트 명</div>
			<div class="col col3_2">프로젝트 현재 투자금액</div>
			<div class="col col3_3">프로젝트 목표 투자금액</div>
		</div>
<%
	for(Map<String, Object> tmpData : dataList){
		ProjectVo tmpPVo = (ProjectVo) tmpData.get("pVo");
		ArrayList<FundVo> tmpFVo = (ArrayList<FundVo>) tmpData.get("fList");
%>
<div class="clearFix">
	<div>
		<div class="col col3_1"><%=tmpPVo.getpName() %></div>
		<div class="col col3_2"><%=tmpPVo.getPnFunds() %></div>
		<div class="col col3_3"><%=tmpPVo.getPtFunds() %></div>
	</div>
</div>

	<table class="table table-striped table-bordered table-hover">
	<tr>
	<td>투자금액</td>
	<td>투자전 금액</td>
	<td>투자후 금액</td>
	<td>투자일</td>
	</tr>
<%
	for(FundVo tmpFVoSub : tmpFVo){
		
%>	
	<tr>
	<td><%=tmpFVoSub.getInFunds() %></td>
	<td><%=tmpFVoSub.getbFunds() %></td>
	<td><%=tmpFVoSub.getaFunds() %></td>
	<td><%=tmpFVoSub.getInsDate() %></td>
	</tr>
	
	<% } %>
<% } %>
	</table>
	</div>
</div>
<!-- main end -->
	</div>
</div>
<%@ include file="/footer.jsp" %>