<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%> 
<!-- Attribute start -->
<%@ page import="java.util.*" %>
<%@ page import="service.IMemberServiceImpl" %>
<%@ page import="service.ProjectVo" %>
<%@ page import="service.FundVo" %>
<%@ page import="service.BoardVo" %>
<% 
	ArrayList<Map<String,Object>> plist = (ArrayList<Map<String,Object>>) request.getAttribute("plist");
	ArrayList<BoardVo> qlist = (ArrayList<BoardVo>) request.getAttribute("qlist");
%>
<!-- Attribute end -->
<%@ include file="/header.jsp" %> 
<!-- main start -->

	<h3> 참가 프로젝트 </h3>
	<table class="table table-striped table-bordered table-hover">
	<tr>
	<td></td>
	<td>프로젝트 명</td>
	<td>투자금액</td>
	<td>투자일</td>
	<td>목표달성률</td>
	</tr>
<%
	for(Map<String, Object> plist2 : plist){
		
		ProjectVo pvo = (ProjectVo) plist2.get("vo");
		FundVo fvo = (FundVo) plist2.get("vo2");
%>
	<tr>
	<td><%=pvo.getrNum()%></td>
	<td><%=pvo.getpName()%></td>
	<td><%=fvo.getInFunds() %>원</td>
	<td><%=fvo.getInsDate() %></td>
	<td><%=pvo.getPnFunds() / pvo.getPtFunds() * 100%>%</td>

	</tr>
<%
	}
%>
	</table>
	
	<h3> Qna 리스트 </h3>
	<table class="table table-striped table-bordered table-hover">
	<tr>
	<td></td>
	<td>카테고리</td>
	<td>제목</td>
	<td>상태</td>
	<td>작성일</td>
	</tr>
<%
	String status = null;
	for(BoardVo bvo : qlist){ 
		if(bvo.getbDepth() > 1){
			status = "답변완료";
		}else{
			status = "답변대기";
		}
%>
	<tr>
	<td><%=bvo.getrNum() %></td>
	<td><%=bvo.getCate() %></td>
	<td><%=bvo.getTitle() %></td>
	<td><%=status %></td>
	<td><%=bvo.getInsDate() %></td>
	</tr>
<% 
	} 
%>
	</table>
<!-- main end -->
<%@ include file="/footer.jsp" %>