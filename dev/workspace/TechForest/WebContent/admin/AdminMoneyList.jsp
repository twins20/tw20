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

.adminP{
	font-size: 20px;
	margin-top: 20px;
	margin-left: 10px;
	font-weight: bold;
}
</style>
<c:set var="pagingUrl" value="/AdminMoneyList.do"/>

<div class="adminWrapper">	
<p class="adminP">회원 머니 리스트</p>
	<div class="divTable">  
	 <div class="clearFix rowTitle">
	   <div class="col col6_1">No </div>
	   <div class="col col6_2">회원 이름</div>
	   <div class="col col6_3">충전 금액</div>
	   <div class="col col6_4">신청일</div>
	   <div class="col col6_5">상태</div>	  
	   <div class="col col6_5">작업</div>	  
	</div>
<%	
	ArrayList<Map<String, Object>> alist1 = (ArrayList<Map<String, Object>>) request.getAttribute("alist");
	for(Map<String, Object> hashmap : alist1){	
		MemberVo mbv = (MemberVo) hashmap.get("mbv");
		MoneyVo mnv = (MoneyVo) hashmap.get("mnv");			
		
		String statusMsg = null;
		String statusBtn1 = null;
		String statusBtn2 = null;
		if(mnv.getStatus() == 0){
			statusMsg = "승인 대기";
			statusBtn1 = "<button type='button' class='btn btn-default'>승인</button>";
			statusBtn2 = "<button type='button' class='btn btn-default'>반려</button>";
		}else if(mnv.getStatus() == 1){
			statusMsg = "충전 완료";			
		}else if(mnv.getStatus() == 2){
			statusMsg = "충전 취소";			
		}
%>		
	  <div class="clearFix">
	    <div class="col col6_1"><%= hashmap.get("rNum") %></div>
	    <div class="col col6_2"><a href="<%=request.getContextPath()%>/AdminImemInfoCon.do?param_idx=<%=mbv.getIdx()%>"><%= mbv.getName()%></a></div>
	    <div class="col col6_3"><%= mnv.getChgMoney()%>원</div>	    
	    <div class="col col6_4"><%= mnv.getInsDate()%></div>	    
	    <div class="col col6_5"><%= statusMsg%></div>
	    <div class="col col6_5"><a href="<%=request.getContextPath()%>/AdminMoneyChkOk_Action.do?param_idx=<%=mbv.getIdx()%>&mIdx=<%=mnv.getmIdx()%>"><%= statusBtn1%></a>
	    						<a href="<%=request.getContextPath()%>/AdminMoneyChkNOk_Action.do?param_idx=<%=mbv.getIdx()%>&mIdx=<%=mnv.getmIdx()%>"><%= statusBtn2%></a></div>
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
</div>

<!-- main end -->
	</div>
</div>
<%@ include file="/footer.jsp" %>