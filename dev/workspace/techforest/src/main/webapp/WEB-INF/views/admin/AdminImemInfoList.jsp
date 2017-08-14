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

<c:set var="pagingUrl" value="/AdminImemInfoList.do"/>

<div class="adminWrapper">	
<p class="adminP">투자자 회원 리스트</p>
	<div class="divTable">  
	 <div class="clearFix rowTitle">
	   <div class="col col5_1">No </div>
	   <div class="col col5_2">프로젝트 명</div>
	   <div class="col col5_3">신청일</div>
	   <div class="col col5_4">상태</div>
	   <div class="col col5_5">투자금</div>	  
	</div>

  
	  <c:forEach var="mv" items="${mlist}">
	  <div class="clearFix">
	    <div class="col col5_1"></div>
	    <div class="col col5_2"><a href="<c:url value='/'/>/AdminImemInfoCon.do?idx${mv.idx}">${mv.id}</a></div>
	    <div class="col col5_3">${mv.name}</div>	  
	     <c:choose>
	     	<c:when test="${mv.status eq 0}">
	     		<div class="col col5_4">인증대기</div>
	     	</c:when>
	     	<c:when test="${mv.status eq 1}">
	     		<div class="col col5_4">일반</div>
	     	</c:when>
	     	<c:when test="${mv.status eq 2}">
	     		<div class="col col5_4">투자 참여 회원</div>
	     	</c:when>
	     	<c:when test="${mv.status eq 3}">
	     		<div class="col col5_4">사업자 등록 완료</div>
	     	</c:when>
	     	<c:when test="${mv.status eq 9}">
	     		<div class="col col5_4">정지</div>
	     	</c:when>
	     	<c:when test="${mv.status eq 10}">
	     		<div class="col col5_4">탈퇴</div>
	     	</c:when>	     		     		     		     		     		
	     </c:choose>      
	    <div class="col col5_5">${mv.money}원</div>
	  </div>	  
	  </c:forEach>
</div>
</div>
<!-- main end -->
	</div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>