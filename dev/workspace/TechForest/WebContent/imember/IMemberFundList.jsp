<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!-- Attribute start -->
<%@ page import="service.ProjectVo" %>
<%@ page import="service.FundVo" %>
<%@ page import="java.util.*" %>
<%
	ArrayList<Map<String, Object>> dataList = (ArrayList<Map<String, Object>>) request.getAttribute("dataList");
%>
<!-- Attribute end -->
<%@ include file="/header.jsp" %> 
<!-- main start -->

	<table class="table table-striped table-bordered table-hover">
	<tr>
	<td>프로젝트 명</td>
	<td>프로젝트 현재 투자금액</td>
	<td>프로젝트 목표 도달금액</td>
	</tr>
<%
	for(Map<String, Object> tmpData : dataList){
		ProjectVo tmpPVo = (ProjectVo) tmpData.get("pVo");
		ArrayList<FundVo> tmpFVo = (ArrayList<FundVo>) tmpData.get("fList");
%>
	<tr>
	<td><%=tmpPVo.getpName() %></td>
	<td><%=tmpPVo.getPnFunds() %></td>
	<td><%=tmpPVo.getPtFunds() %></td>
	</tr>
	</table>

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

<!-- main end -->
<%@ include file="/footer.jsp" %>