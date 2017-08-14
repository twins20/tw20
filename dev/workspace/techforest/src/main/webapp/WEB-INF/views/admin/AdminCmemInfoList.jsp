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
<p class="adminP">사업자 회원 리스트</p>

	<div class="divTable">  
	 <div class="clearFix rowTitle">
	   <div class="col col5_1">No</div>
	   <div class="col col5_2">사업자 ID</div>
	   <div class="col col5_3">사업자 명</div>
	   <div class="col col5_4">상태</div>
	   <div class="col col5_5">투자 지원 상태</div>	  
	</div>


	  <c:forEach var="hashmap" items="${dataList}">
	  <div class="clearFix">
	    <div class="col col5_1"></div>
	    <div class="col col5_2"><a href="<c:url value='/AdminCmemInfoCon.do?param_idx=${hashmap.IDX}' />">${hashmap.ID}</a></div>
	    <div class="col col5_3">${hashmap.NAME}</div>	    
	    
	    <c:choose>
	    	<c:when test="${hashmap.STATUS eq 0}">
	    		<div class="col col5_4">이메일 인증 대기 </div>
	    	</c:when>
			<c:when test="${hashmap.STATUS eq 1 }">
				<div class="col col5_4">사업자 등록 대기</div>
			</c:when>	
			<c:when test="${hashmap.STATUS eq 3 }">
				<div class="col col5_4">사업자 등록 완료</div>
			</c:when>
			<c:when test="${hashmap.STATUS eq 10 }">
				<div class="col col5_4">탈퇴</div>
			</c:when>						
		</c:choose>
		    <div class="col col5_5">${hashmap.PNFUNDS}원</div>
		</div>
		</c:forEach>
			 
  	 </div>	  
	</div>
<!-- main end -->
	</div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>