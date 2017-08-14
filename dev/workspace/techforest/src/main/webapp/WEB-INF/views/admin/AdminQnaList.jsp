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

<script>	
	function delBtn(){ 
		if(confirm("글을 삭제하시겠습니까?")){
	    		document.submit();
	    	}else{
	    		alert("삭제되지 않았습니다.");
	    	}
		}
</script>  

<c:set var="pagingUrl" value="/AdminQnaList.do"/>

<div class="adminQnaWrapper">	
<p class="adminP">전체 QNA 리스트</p>
	<div class="divTable">  
	 <div class="clearFix rowTitle">
	   <div class="col col6_1">No </div>
	   <div class="col col6_2 qna2">문의 내역</div>
	   <div class="col col6_3 qna3">카테고리</div>
	   <div class="col col6_4">글 종류</div>
	   <div class="col col6_5">작성일</div>
	   <div class="col col6_6 qna6">작업</div>	  
	</div>
		
	<c:forEach var="bv" items="${blist}">	
	  <div class="clearFix">
	    <div class="col col6_1"></div>
	    <div class="col col6_2 qna2"><a href="<c:url value='/'/>/AdminQnaCon.do?bIdx=${bv.bIdx}">${bv.title}</a></div>
	    <div class="col col6_3 qna3">${bv.cate}</div>
	   <c:choose>
	   <c:when test ="${bv.viewStat eq 1 }">
	    <div class="col col6_4">회원문의</div>
	    </c:when>
	    <c:when test ="${bv.viewStat ne 1 }">
	    <div class="col col6_4">관리자 답글</div>
	    </c:when>
	    </c:choose>	    
	    <div class="col col6_5">${bv.insDate}</div>	    
	    <div class="col col6_6 qna6">
	    	<a href="<c:url value='/AdminQnaWrite.do?bIdx=${bv.bIdx}'/>"></a>
	    	<button type='button' class='btn btn-default'>답글</button>
	    	<a href="<c:url value='/AdminQnaMod.do?bIdx=${bv.bIdx}'/>"></a>
	    	<button type='button' class='btn btn-default'>수정</button>
	    	<a href="<c:url value='/AdminQnaDel_Action.do?bIdx=${bv.bIdx}'/>"></a>
	    	<button type='button' class='btn btn-default'>삭제</button>
	    	</div>
	  </div>	  
		</c:forEach>
	</div>
</div>
<!-- main end -->
	</div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>