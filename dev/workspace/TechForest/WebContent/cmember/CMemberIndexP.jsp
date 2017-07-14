<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!-- Attribute start -->
<%@ page import="java.util.*" %>
<%@ page import="service.ProjectVo" %>
<%@ page import="service.ProjectCommVo" %>
<%@ page import="service.BoardVo" %>
<%
	ProjectVo pvo = (ProjectVo) request.getAttribute("vo");
	ArrayList<ProjectCommVo> commList = (ArrayList<ProjectCommVo>) request.getAttribute("commList");
	ArrayList<BoardVo> newsList = (ArrayList<BoardVo>) request.getAttribute("newsList");
%>
<!-- Attribute end -->
<%@ include file="/header.jsp" %>
<!-- 바디	 -->
<div class="bodyWrapper clearFix">
<!-- 사이드바	 -->
<%@ include file="/sideBar/cmemberSideBar.jsp" %>
	<div class="bodyMain"> 
<!-- main start -->

	<h3>진행중인 프로젝트</h3>
	<table class="table table-striped table-bordered table-hover">
	<tr>
	<td>프로젝트 명</td>
	<td>카테고리</td>
	<td>프로젝트 현재 투자금액</td>
	<td>프로젝트 목표 투자금액</td>
	<td>목표도달율</td>
	<td>프로젝트 기술성 평가</td>
	</tr>
<%	
	float goalRate = 0;
	float pnFunds = 0;
	float ptFunds = 0;
	pnFunds = pvo.getPnFunds();
	ptFunds = pvo.getPtFunds();
	goalRate = (pnFunds / ptFunds) * 100;
%>	
	<tr>
	<td><%=pvo.getpName() %></td>
	<td><%=pvo.getpCate() %></td>
	<td><%=pvo.getPnFunds() %>원</td>
	<td><%=pvo.getPtFunds() %>원</td>
	<td><%=goalRate %>%</td>
	<td><%=pvo.getpGrade() %></td>
	</tr>
	</table>
	
	<h3>프로젝트 댓글리스트</h3>
	<table class="table table-striped table-bordered table-hover">
	<tr>
	<td>내용</td>
	<td>작성자</td>
	<td>작성일</td>
	<td>완료일</td>
	</tr>
<%
	for(ProjectCommVo commvo : commList){
%>	
	<tr>
	<td><%=commvo.getComments() %></td>
	<td><%=commvo.getIdx() %></td>
	<td><%=commvo.getInsDate() %></td>
	<td><%=commvo.getModDate() %></td>
	</tr>
<%	} %>
	</table>
	
	<h3>뉴스리스트</h3>
	<table class="table table-striped table-bordered table-hover">
	<tr>
	<td>순번</td>
	<td>카테고리</td>
	<td>제목</td>
	<td>댓글갯수</td>
	</tr>
<%
	for(BoardVo newsVo : newsList){
%>	
	<tr>
	<td><%=newsVo.getrNum() %></td>
	<td><%=newsVo.getCate() %></td>
	<td><%=newsVo.getTitle() %></td>
	<td><%=newsVo.getCommCnt() %></td>
	</tr>
<%	} %>
	</table>



	
<!-- main end -->
	</div>
</div>
<%@ include file="/footer.jsp" %>