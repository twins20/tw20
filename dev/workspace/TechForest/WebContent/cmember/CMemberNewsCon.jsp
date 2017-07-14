<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!-- Attribute start -->
<%@ page import="java.util.*" %>
<%@ page import="service.BoardVo" %>
<%@ page import="service.ProjectVo" %>
<%
	BoardVo bvo = (BoardVo) request.getAttribute("bvo");
	ProjectVo pvo = (ProjectVo) request.getAttribute("pvo");
%>
<!-- Attribute end -->
<%@ include file="/header.jsp" %>
<!-- 바디	 -->
<div class="bodyWrapper clearFix">
<!-- 사이드바	 -->
<%@ include file="/sideBar/cmemberSideBar.jsp" %>
	<div class="bodyMain"> 
<!-- main start -->
<script>

function cmemberNewsDel(){ 
	if(confirm("프로젝트 뉴스를 삭제하시겠습니까?")){
    	location.href="<%=request.getContextPath()%>/CMemberNewsDel_Action.do?bIdx=<%=bvo.getbIdx()%>";
    	}else{
    		alert("삭제되지 않았습니다.");
    	}
	}
	
</script>

	<table class="table table-striped table-bordered table-hover">
	<tr>
	<td>카테고리</td>
	<td>제목</td>
	<td>내용</td>
	<td>좋아요</td>
	<td>싫어요</td>
	<td>등록일</td>
	</tr>
	
	<tr>
	<td><%=bvo.getCate() %></td>
	<td><%=bvo.getTitle() %></td>
	<td><%=bvo.getContents() %></td>
	<td><%=bvo.getGood() %></td>
	<td><%=bvo.getBad() %></td>
	<td><%=bvo.getInsDate() %></td>
	</tr>
	</table>
	
	<table class="table table-striped table-bordered table-hover">
	<tr>
	<td>프로젝트 명</td>
	<td>프로젝트 현재 투자금액</td>
	<td>프로젝트 목표 투자금액</td>
	<td>프로젝트 기술성 평가</td>
	<td>프로젝트 상태</td>
	</tr>
<%
	String status = null;
	if(pvo.getStatus() == 1){
		status = "진행";
	}else if(pvo.getStatus() == 5){
		status = "완료";
	}else if(pvo.getStatus() == 4){
		status = "실패";
	}
%>	
	<tr>
	<td><a href="<%=request.getContextPath()%>/ProjCon.do?pIdx=<%=pvo.getpIdx()%>"><%=pvo.getpName() %></td>
	<td><%=pvo.getPnFunds() %></td>
	<td><%=pvo.getPtFunds() %></td>
	<td><%=pvo.getpGrade() %></td>
	<td><%=status %></td>
	</tr>
	</table>
	
	<button class="btn btn-default" id="cmemberNewsDel" type="button" onclick="cmemberNewsDel()">삭제</button>
	<a class="btn btn-default" href="<%=request.getContextPath() %>/CMemberNewsMod.do?bIdx=<%=bvo.getbIdx()%>" role="button">수정</a>


	

<!-- main end -->
	</div>
</div>
<%@ include file="/footer.jsp" %>