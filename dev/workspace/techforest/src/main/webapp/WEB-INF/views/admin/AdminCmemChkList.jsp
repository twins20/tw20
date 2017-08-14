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
	<p class="adminP">사업자 승인 관리</p>
	<div class="divTable">  
	 <div class="clearFix rowTitle">
	   <div class="col col5_1">No </div>
	   <div class="col col5_2">사업자</div>
	   <div class="col col5_3">신청일</div>
	   <div class="col col5_4">상태</div>
	   <div class="col col5_5">작업</div>	  
	</div>
		
	<c:forEach var="mv" items="${mlist}">	
	<div class="clearFix">
	    <div class="col col5_1"></div>
	    <div class="col col5_2"><a href="<c:url value="/AdminCmemChkCon.do?param_idx=${mv.idx}"/>">${mv.name}</a></div>
	    <div class="col col5_3">${mv.modDate}</div>	  
	    <c:choose>
	    	<c:when test="${mv.status eq 0 }">
	    	   <div class="col col5_4">승인대기</div>
	    	   <div class="col col5_5">
	    	   	  	<a href="<c:url value="/AdminCmemChkOk_Action.do?param_idx=${mv.idx}"/>">
					<button type='button' class='btn btn-default'>승인</button></a>    	    
	   				<a href="<c:url value="/AdminMemoSend.do?param_idx=${mv.idx}"/>">
					<button type='button' class='btn btn-default'>반려</button></a>
				</div>	
				</c:when>	
	  			<c:when test="${mv.status eq 1 }">
					<div class="col col5_4">승인완료</div>
					<div class="col col5_5"></div>
				</c:when>
				<c:when test="${mv.status eq 3 }">
					<div class="col col5_4">사업자 등록 완료</div>
					<div class="col col5_5"></div>
				</c:when>
				<c:when test="${mv.status eq 9 }">
					<div class="col col5_4">회원 정지</div>
					<div class="col col5_5"></div>
				</c:when>
				<c:when test="${mv.status eq 10 }">
					<div class="col col5_4">회원 탈퇴</div>
					<div class="col col5_5"></div>
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