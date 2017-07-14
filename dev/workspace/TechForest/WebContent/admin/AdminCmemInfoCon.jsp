<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
.btn-default{
	margin-bottom: 3px;
}
.adminWrapper{
	width:100%;
	padding: 0;
	margin: 0; 	 	
}
.divTable{
	margin-top: 10px;
	margin-bottom: 40px;
}
.adminP, .CmemInfo{
	font-size: 20px;
	margin-top: 20px;
	margin-left: 10px;
	font-weight: bold;
}
.form-control{
	width: 400px;
}
.btn-primary{
	margin-left: 226px;
}
</style>
<c:set var="pagingUrl" value="/AdminCmemInfoCon.do"/>

<div class="adminWrapper">
<%
	ArrayList<MemberVo> alist1 = (ArrayList<MemberVo>) request.getAttribute("alist");
	for(MemberVo vo : alist1){		
%>
<p class="adminP">회원 상세 정보</p>
	<form class="form-horizontal adminIMemberList">
		<div class="form-group">
			<label for="email" class="col-sm-3 control-label">이메일</label>
			<div class="col-sm-9">
				<input type="text" class="form-control" id="email" value="<%=vo.getId()%>" readonly>
			</div>
		</div>
		<div class="form-group">
			<label for="nick" class="col-sm-3 control-label">닉네임</label>		
			<div class="col-sm-9">
				<input type="text" class="form-control" id="nick" value="<%=vo.getNick()%>" readonly>
			</div>
		</div>
		<div class="form-group">
			<label for="name" class="col-sm-3 control-label">성명</label>
			<div class="col-sm-9">
				<input type="text" class="form-control" id="name" value="<%=vo.getName()%>" readonly>
			</div>
		</div>
		<div class="form-group">
			<label for="tel" class="col-sm-3 control-label">전화번호</label>
			<div class="col-sm-9">
				<input type="text" class="form-control" id="tel" value="0<%=vo.getPhone()%>" readonly>
			</div>
		</div>
		<div class="form-group">
			<label for="adress" class="col-sm-3 control-label">주소</label>
			<div class="col-sm-9">
				<input type="text" class="form-control" id="address" value="<%=vo.getAddr()%>" readonly>
			</div>
		</div>
		<div class="form-group">
			<label for="adress" class="col-sm-3 control-label">사업자 등록번호</label>
			<div class="col-sm-9">
				<input type="text" class="form-control" id="address" value="<%=vo.getcNumber()%>" readonly>
			</div>
		</div>
		<div class="form-group">
			<label for="adress" class="col-sm-3 control-label">사업자 등록주소</label>
			<div class="col-sm-9">
				<input type="text" class="form-control" id="address" value="<%=vo.getcAddr()%>" readonly>
			</div>
		</div>
		<button type="button" class="btn btn-primary form-control" data-toggle="modal" data-target="#myModal">정보 수정</button>
		
		<div class="modal fade adminImemberModify" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title" id="myModalLabel">비밀번호를 입력해주세요.</h4>
			</div>
			<div class="modal-body">
				<input class="form-control" type="password" name="password" id="password">
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary">수정</button>
			</div>
		</div>
		</div>
		</div>
	</form>
<% } %>

<p class="CmemInfo">진행중 프로젝트 상황</p>
<%	
	ArrayList<ProjectVo> blist1 = (ArrayList<ProjectVo>) request.getAttribute("blist");
		for(ProjectVo vo : blist1){
			
		float goalRate = 0;		
		float pnFunds = 0;
		float ptFunds = 0;
		pnFunds = vo.getPnFunds();		
		ptFunds = vo.getPtFunds();		
		goalRate = (pnFunds / ptFunds)*100;
			
%>		
		<div>
			<div>
				<p><%= vo.getPtFunds()%></p> 
				<p>goalRate %</p>
			</div>
			<div>
				그림
			</div>
			<div>
				<p>아이탬 이름</p>
				<p>vo.getpName()</p>
				<p>부트스트랩 아이콘</p>
			</div>
		</div>
		
	  <div class="clearFix">
	    <div class="col col5_1"><%= vo.getrNum()%></div>
	    <div class="col col5_2"><%= vo.getpName()%></div>
	    <div class="col col5_3"><%= vo.getPnFunds()%>원</div>
	    <div class="col col5_4"><%= vo.getInsDate()%></div>
	    <div class="col col5_4"><%= goalRate%>%</div>
	  </div>	  
<%
		}
%>
	</div>
	
	<div>
			투자 현황 그래프
		</div>


<p class="CmemInfo">지난 프로젝트 리스트</p>
	<div class="divTable">  
	 <div class="clearFix rowTitle">
	   <div class="col col5_1">No </div>
	   <div class="col col5_2">프로젝트명</div>
	   <div class="col col5_3">총 투자 받은 금액</div>
	   <div class="col col5_4">프로젝트 시작일</div>
	   <div class="col col5_5">목표달성률</div>
	</div>
<%	
	ArrayList<ProjectVo> dlist1 = (ArrayList<ProjectVo>) request.getAttribute("dlist");
		for(ProjectVo vo : dlist1){
			
		float goalRate = 0;		
		float pnFunds = 0;
		float ptFunds = 0;
		pnFunds = vo.getPnFunds();		
		ptFunds = vo.getPtFunds();		
		goalRate = (pnFunds / ptFunds)*100;
			
%>		
	  <div class="clearFix">
	    <div class="col col5_1"><%= vo.getrNum()%></div>
	    <div class="col col5_2"><a href="<%=request.getContextPath()%>/AdminProjChkCon.do?pIdx=<%=vo.getpIdx()%>"><%= vo.getpName()%></a></div>
	    <div class="col col5_3"><%= vo.getPnFunds()%>원</div>
	    <div class="col col5_4"><%= vo.getInsDate()%></div>
	    <div class="col col5_4"><%= goalRate%>%</div>
	  </div>	  
<%
		}
%>
<!-- 페이징 처리 부분 -->
		<div class="clearFix">
			<ul class="pagingUl clearFix">
			<c:forEach var="i" begin="${d_startPage}" end="${d_endPage}" step="1">
				<c:choose>
					<c:when test="${i eq d_pageCnt}">
						<li class="selected">
							${i}
						</li>
					</c:when>					
					<c:otherwise>
						<c:url value="${pagingUrl}" var="inputUrl">
							<c:if test="${!empty param.param_idx}">
						   		<c:param name="param_idx" value="${param.param_idx}"/>
					   		</c:if>	
						    <c:param name="d_pageCnt" value="${i}"/>						
						</c:url>
						<a href="${inputUrl}">
							<li>
								${i}
							</li>
						</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			</ul>
		</div>
	</div>
	
<p class="CmemInfo">투자 회원 리스트</p>	
	<div class="divTable">  
	 <div class="clearFix rowTitle">
	   <div class="col col5_1">No </div>
	   <div class="col col5_2">회원 닉네임</div>
	   <div class="col col5_3">투자 금액</div>
	   <div class="col col5_4">투자일</div>
	   <div class="col col5_5">상태</div>
	</div>
<%	
	ArrayList<Map<String, Object>> elist1 = (ArrayList<Map<String, Object>>) request.getAttribute("elist");
	for(Map<String, Object> hashmap : elist1){
		MemberVo mvo = (MemberVo) hashmap.get("mvo");
		FundVo fvo = (FundVo) hashmap.get("fvo");		
		
		String statusMsg = null;
		if(fvo.getStatus() == 0){
			statusMsg = "정상 투자";	
			
		}else if(fvo.getStatus() == 1){
			statusMsg = "취소 / 환불";				
		}			
%>		
	  <div class="clearFix">
	    <div class="col col5_1"><%= hashmap.get("rNum")%></div>
	    <div class="col col5_2"><%= mvo.getNick()%></div>
	    <div class="col col5_3"><%= fvo.getaFunds()%>원</div>
	    <div class="col col5_4"><%= fvo.getInsDate()%></div>
	    <div class="col col5_4"><%= statusMsg%></div>
	  </div>	  
<%
		}
%>
<!-- 페이징 처리 부분 -->
		<div class="clearFix">
			<ul class="pagingUl clearFix">
			<c:forEach var="i" begin="${e_startPage}" end="${e_endPage}" step="1">
				<c:choose>
					<c:when test="${i eq e_pageCnt}">
						<li class="selected">
							${i}
						</li>
					</c:when>					
					<c:otherwise>
						<c:url value="${pagingUrl}" var="inputUrl">
							<c:if test="${!empty param.param_idx}">
						   		<c:param name="param_idx" value="${param.param_idx}"/>
					   		</c:if>	
						    <c:param name="e_pageCnt" value="${i}"/>						
						</c:url>
						<a href="${inputUrl}">
							<li>
								${i}
							</li>
						</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			</ul>
		</div>
	</div>
<p class="CmemInfo">뉴스 리스트</p> 
	<div class="divTable">  
	 <div class="clearFix rowTitle">
	   <div class="col col4_1">No </div>
	   <div class="col col4_2">제목</div>
	   <div class="col col4_3">연관 프로젝트</div>
	   <div class="col col4_4">작성일</div>
	</div>
<%	
	ArrayList<Map<String, Object>> flist1 = (ArrayList<Map<String, Object>>) request.getAttribute("flist");
	for(Map<String, Object> hashmap : flist1){		
			BoardVo bvo = (BoardVo) hashmap.get("bvo");	
			ProjectVo pvo = (ProjectVo) hashmap.get("pvo");
		
%>		
	  <div class="clearFix">
	    <div class="col col4_1"><%= hashmap.get("rNum")%></div>
	    <div class="col col4_2"><a href="<%=request.getContextPath()%>/AdminNewsConServlet?bIdx=<%= bvo.getbIdx()%>"><%= bvo.getTitle()%></a></div>
	    <div class="col col4_3"><%= pvo.getpName()%></div>
	    <div class="col col4_4"><%= bvo.getInsDate()%></div>
	  </div>	  
<%
		}
%>
<!-- 페이징 처리 부분 -->
		<div class="clearFix">
			<ul class="pagingUl clearFix">
			<c:forEach var="i" begin="${f_startPage}" end="${f_endPage}" step="1">
				<c:choose>
					<c:when test="${i eq f_pageCnt}">
						<li class="selected">
							${i}
						</li>
					</c:when>					
					<c:otherwise>
						<c:url value="${pagingUrl}" var="inputUrl">
							<c:if test="${!empty param.param_idx}">
						   		<c:param name="param_idx" value="${param.param_idx}"/>
					   		</c:if>	
						    <c:param name="f_pageCnt" value="${i}"/>						
						</c:url>
						<a href="${inputUrl}">
							<li>
								${i}
							</li>
						</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			</ul>
		</div>
	</div> 
		
<p class="CmemInfo">QNA 리스트</p> 
	<div class="divTable">  
	 <div class="clearFix rowTitle">
	   <div class="col col4_1">No </div>
	   <div class="col col4_2">문의 내역</div>
	   <div class="col col4_3">상태</div>
	   <div class="col col4_4">작성일</div>
	</div>
<%	
	ArrayList<BoardVo> glist1 = (ArrayList<BoardVo>) request.getAttribute("glist");
	for(BoardVo vo : glist1){			
		
		String statusMsg = null;
		if(vo.getbDepth() == 1){
			statusMsg = "미 답변";			
		}else{
			statusMsg = "답변 완료";				
		}
%>		
	  <div class="clearFix">
	    <div class="col col4_1"><%= vo.getrNum()%></div>
	    <div class="col col4_2"><a href="<%=request.getContextPath()%>/AdminQnaConServlet?bIdx=<%= vo.getbIdx()%>"><%= vo.getTitle()%></a></div>
	    <div class="col col4_3"><%= statusMsg%></div>
	    <div class="col col4_4"><%= vo.getInsDate()%></div>
	  </div>	  
<%
		}
%>
<!-- 페이징 처리 부분 -->
		<div class="clearFix">
			<ul class="pagingUl clearFix">
			<c:forEach var="i" begin="${g_startPage}" end="${g_endPage}" step="1">
				<c:choose>
					<c:when test="${i eq g_pageCnt}">
						<li class="selected">
							${i}
						</li>
					</c:when>					
					<c:otherwise>
						<c:url value="${pagingUrl}" var="inputUrl">
							<c:if test="${!empty param.param_idx}">
						   		<c:param name="param_idx" value="${param.param_idx}"/>
					   		</c:if>	
						    <c:param name="g_pageCnt" value="${i}"/>						
						</c:url>
						<a href="${inputUrl}">
							<li>
								${i}
							</li>
						</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			</ul>
		</div>
	</div> 
	
</div>


<!-- main end -->
	</div>
</div>
<%@ include file="/footer.jsp" %>