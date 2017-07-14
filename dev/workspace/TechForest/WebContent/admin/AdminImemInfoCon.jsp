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
.btn-primary{
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
.adminP{
	font-size: 20px;
	margin-top: 20px;
	margin-left: 10px;
	font-weight: bold;
}
.form-control{
	width: 400px;
}
.form-mod{
	margin-left: 226px;
}
</style>
<c:set var="pagingUrl" value="/AdminImemInfoCon.do"/>
<c:set var="c_pagingUrl" value="/AdminImemInfoCon.do"/>
<c:set var="d_pagingUrl" value="/AdminImemInfoCon.do"/>

<div class="adminInmemInfoConWrapper">
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
				<input type="text" class="form-control" id="tel" value="<%=vo.getPhone()%>" readonly>
			</div>
		</div>
		<div class="form-group">
			<label for="adress" class="col-sm-3 control-label">주소</label>
			<div class="col-sm-9">
				<input type="text" class="form-control" id="address" value="<%=vo.getAddr()%>" readonly>
			</div>
		</div>		
	</form>
	<button type="button" class="btn btn-primary form-control form-mod" data-toggle="modal" data-target="#myModal">정보 수정</button>
	<form id="ModifyForm" action="<%=request.getContextPath()%>/IMemberInfoMod.do" method="post">	
		<div class="modal fade imemberModify" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		        <span aria-hidden="true">&times;</span>
		        </button>
		        <h4 class="modal-title" id="myModalLabel">비밀번호를 입력해주세요.</h4>
		      </div>
		      	  <input class="form-control" type="hidden" name="param_idx" id="param_idx" value=<%=vo.getIdx() %>>
		      <div class="modal-body">
		      	 <input class="form-control" type="password" name="pw" id="pw">
		      </div>
		      <div class="modal-footer">
		        <button type="submit" id="ModifyForm" class="btn btn-primary">입력</button>
		      </div>
		    </div>
		  </div>
		</div>
	</form>
<% } %>

<p class="adminP">투자금 충전 내역</p>
	<div class="divTable">  
	 <div class="clearFix rowTitle">
	   <div class="col col5_1">No </div>
	   <div class="col col5_2">충전금액</div>
	   <div class="col col5_3">충전일</div>
	   <div class="col col5_4">상태</div>
	   <div class="col col5_5">작업</div>
	</div>
<%	
	ArrayList<MoneyVo> blist1 = (ArrayList<MoneyVo>) request.getAttribute("blist");
	for(MoneyVo vo : blist1){		
		String statusMsg = null;		
		String statusBtn1 = null;
		String statusBtn2 = null;
		
		if(vo.getStatus() == 0){
			statusMsg = "머니 신청";
			statusBtn1 = "<button type='button' class='btn btn-primary'>승인</button>";
			statusBtn2 = "<button type='button' class='btn btn-primary'>반려</button>";
		}else if(vo.getStatus() == 1){
			statusMsg = "충전 완료";		
			statusBtn1 = "<button type='button' class='btn btn-primary' disabled='disabled'>승인</button>";
			statusBtn2 = "<button type='button' class='btn btn-primary' disabled='disabled'>반려</button>";
		}else if(vo.getStatus() == 2){
			statusMsg = "충전 취소";	
			statusBtn1 = "<button type='button' class='btn btn-primary' disabled='disabled'>승인</button>";
			statusBtn2 = "<button type='button' class='btn btn-primary' disabled='disabled'>반려</button>";
		}else if(vo.getStatus() == 3){
			statusMsg = "신청 반려";	
			statusBtn1 = "<button type='button' class='btn btn-primary' disabled='disabled'>승인</button>";
			statusBtn2 = "<button type='button' class='btn btn-primary' disabled='disabled'>반려</button>";
		}		
	
%>		
	  <div class="clearFix">
	    <div class="col col5_1"><%= vo.getrNum()%></div>
	    <div class="col col5_2"><%= vo.getChgMoney()%>원</div>
	    <div class="col col5_3"><%= vo.getInsDate()%></div>
	    <div class="col col5_4"><%= statusMsg%></div>
	    <div class="col col5_5"><a href="<%=request.getContextPath()%>/AdminMoneyChkOk_Action.do?param_idx=<%=vo.getIdx()%>&mIdx=<%=vo.getmIdx()%>"><%= statusBtn1%></a>
	    						<a href="<%=request.getContextPath()%>/AdminMoneyChkNOk_Action.do?param_idx=<%=vo.getIdx()%>&mIdx=<%=vo.getmIdx()%>"><%= statusBtn2%></a></div>
	  </div>	  
<%
		}
%>
<!-- 페이징 처리 부분 -->
		<div class="clearFix">
			<ul class="pagingUl clearFix">
			<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
				<c:choose>
					<c:when test="${i eq pageCnt}">
						<li class="selected">
							${i}
						</li>
					</c:when>
					<c:otherwise>
						<c:url value="${pagingUrl}" var="inputUrl">
							<c:if test="${!empty param.param_idx}">
						   		<c:param name="param_idx" value="${param.param_idx}"/>
					   		</c:if>
						    <c:param name="pageCnt" value="${i}"/>						
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
	
<p class="adminP">참가 프로젝트</p>	
	<div class="divTable">  
	 <div class="clearFix rowTitle">
	   <div class="col col5_1">No </div>
	   <div class="col col5_2">프로젝트명</div>
	   <div class="col col5_3">투자 금액</div>
	   <div class="col col5_4">투자일</div>
	   <div class="col col5_5">목표달성률</div>
	</div>
<%	
	ArrayList<Map<String, Object>> clist1 = (ArrayList<Map<String, Object>>) request.getAttribute("clist"); 
	for(Map<String, Object> hashmap : clist1){	
		ProjectVo pvo = (ProjectVo) hashmap.get("pvo");
		FundVo fvo = (FundVo) hashmap.get("fvo");
		
		float goalRate = 0;		
		float pnFunds = 0;
		float ptFunds = 0;
		pnFunds = pvo.getPnFunds();		
		ptFunds = pvo.getPtFunds();		
		goalRate = (pnFunds / ptFunds)*100;
			
%>		
	  <div class="clearFix">
	    <div class="col col5_1"><%= hashmap.get("rNum")%></div>
	    <div class="col col5_2"><a href="<%=request.getContextPath()%>/ProjCon.do?pIdx=<%=pvo.getpIdx()%>"><%= pvo.getpName()%></a></div>
	    <div class="col col5_3"><%= fvo.getInFunds()%>원</div>
	    <div class="col col5_4"><%= fvo.getInsDate()%></div>
	    <div class="col col5_4"><%= goalRate%>%</div>
	  </div>	  
<%
		}
%>
<!-- 페이징 처리 부분 -->
		<div class="clearFix">
			<ul class="pagingUl clearFix">
			<c:forEach var="i" begin="${c_startPage}" end="${c_endPage}" step="1">
				<c:choose>
					<c:when test="${i eq c_pageCnt}">
						<li class="selected">
							${i}
						</li>
					</c:when>					
					<c:otherwise>
						<c:url value="${c_pagingUrl}" var="inputUrl">						    	
						    <c:if test="${!empty param.param_idx}">
						   		<c:param name="param_idx" value="${param.param_idx}"/>
					   		</c:if>			
					   		<c:param name="c_pageCnt" value="${i}"/>		
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
	
<p class="adminP">QNA 리스트</p> 
	<div class="divTable">  
	 <div class="clearFix rowTitle">
	   <div class="col col4_1">No </div>
	   <div class="col col4_2">문의 내역</div>
	   <div class="col col4_3">상태</div>
	   <div class="col col4_4">작성일</div>
	</div>
<%	
	ArrayList<Map<String, Object>> dlist1 = (ArrayList<Map<String, Object>>) request.getAttribute("dlist");
	for(Map<String, Object> hashmap : dlist1){
		MemberVo mvo = (MemberVo) hashmap.get("mvo");
		BoardVo bvo = (BoardVo) hashmap.get("bvo");	
		
		String statusMsg = null;
		if(bvo.getMaxDepth() == 1){
			statusMsg = "미 답변";		
			
		}else{
			statusMsg = "답변 완료";				
		}
%>		
	  <div class="clearFix">
	    <div class="col col4_1"><%= hashmap.get("rNum")%></div>
	    <div class="col col4_2"><a href="<%=request.getContextPath()%>/AdminQnaConServlet?bIdx=<%= bvo.getbIdx()%>"><%= bvo.getTitle()%></a></div>
	    <div class="col col4_3"><%= statusMsg%></div>
	    <div class="col col4_4"><%= bvo.getInsDate()%></div>
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
						<c:url value="${d_pagingUrl}" var="inputUrl">
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
	
</div>


<!-- main end -->
	</div>
</div>
<%@ include file="/footer.jsp" %>