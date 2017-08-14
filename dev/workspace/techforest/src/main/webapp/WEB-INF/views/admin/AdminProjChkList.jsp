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
	<p class="adminP">프로젝트 승인 관리</p>
	<div class="divTable">  
	 <div class="clearFix rowTitle">
	   <div class="col col5_1">No </div>
	   <div class="col col5_2">프로젝트 명</div>
	   <div class="col col5_3">신청일</div>
	   <div class="col col5_4">상태</div>
	   <div class="col col5_5">작업</div>	  
	</div>
			
	
	<c:forEach var="pv" items="${plist}">
	  <div class="clearFix">
	    <div class="col col5_1"></div>
	    <div class="col col5_2"><a href="<c:url value='/AdminProjChkCon.do?pIdx=${pv.pIdx}'/>">${pv.pName}</a></div>
	    <div class="col col5_3">${pv.insDate}</div>	    
	   <c:choose>
	    	<c:when test="${pv.status eq 0 }">
	    	<div class="col col5_4">등록 대기</div>	    	    
	    	<div class="col col5_5">
	    		<a href="<c:url value="/AdminProjChkOk_Action.do?pIdx=${pv.pIdx}"/>"> 
	    		<button type='button' class='btn btn-default'>승인</button></a>    
	    		<a href="<c:url value="/AdminProjChkNOk_Action.do?pIdx=${pv.pIdx}"/>">
	  	  		<button type='button' class='btn btn-default'>반려</button></a></div>
			</c:when>	
			<c:when test="${pv.status eq 1 }">
					<div class="col col5_4">프로젝트 진행중</div>
					<div class="col col5_5"></div>
				</c:when>
				<c:when test="${pv.status eq 2 }">
					<div class="col col5_4">등록 반려</div>
					<div class="col col5_5"></div>
				</c:when>
				<c:when test="${pv.status eq 3 }">
					<div class="col col5_4">프로젝트 성공</div>
					<div class="col col5_5"></div>
				</c:when>
				<c:when test="${pv.status eq 4 }">
					<div class="col col5_4">프로젝트 실패</div>
					<div class="col col5_5"></div>
				</c:when>
				<c:when test="${pv.status eq 5 }">
					<div class="col col5_4">프로젝트 완료</div>
					<div class="col col5_5"></div>
				</c:when>
				<c:when test="${pv.status eq 10 }">
					<div class="col col5_4">강제종료</div>
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