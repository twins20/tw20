<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!-- Attribute start -->
<%@ page import="com.port.service.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<!-- Attribute end -->
<%@ include file="/WEB-INF/views/header.jsp" %>
<!-- 바디	 -->
<div class="bodyWrapper clearFix">
<!-- 사이드바	 -->
<%@ include file="/WEB-INF/views/sideBar/adminSideBar.jsp" %>
	<div class="bodyMain"> 
<!-- main start -->

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
		
	<c:forEach var="hashmap" items="${alist}">
  <div class="clearFix">
	    <div class="col col6_1"></div>
	    <div class="col col6_2"><a href="<c:url value='/'/>/AdminImemInfoCon.do?idx=${hashmap.IDX}">${hashmap.NAME}</a></div>
	    <div class="col col6_3">${hashmap.CHGMONEY}원</div>	    
	    <div class="col col6_4">${hashmap.INSDATE}</div>	    
	    <c:choose>
	    	<c:when test="${hashmap.STATUS eq 0 }">
	    <div class="col col6_5">승인대기</div>
	   <div class="col col6_6">					
			<a href="<c:url value="/AdminMoneyChkOk_Action.do?param_idx=${hashmap.IDX}&mIdx=${hashmap.MIDX}"/>">
				<button type='button' class='btn btn-default'>승인</button>
			</a> 
			<a href="<c:url value="/AdminMoneyChkNOk_Action.do?param_idx=${hashmap.IDX }&mIdx=${hashmap.MIDX}"/>">
			<button type='button' class='btn btn-default'>반려</button></a>
		</div>
		</c:when>
		<c:when test="${hashmap.STATUS eq 1 }">
			<div class="col col6_5">충전 완료</div>
		</c:when>
		<c:when test="${hashmap.STATUS eq 2 }">
			<div class="col col6_5">충전 취소</div>
		</c:when>
		
		</c:choose>
		</div>
		</c:forEach>
	
	</div>
	
</div>
<!-- main end -->
	</div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>