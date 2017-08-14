<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!-- Attribute start -->
<%@ page import="com.port.service.*" %>
<%@ page import="java.util.*" %>
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

<div class="adminWrapper">	
<p class="adminP">FAQ 리스트</p>
	<div class="divTable">  
	 <div class="clearFix rowTitle">
	   <div class="col col6_1">No </div>
	   <div class="col col6_2">제목</div>
	   <div class="col col6_3">카테고리</div>
	   <div class="col col6_4">상태</div>
	   <div class="col col6_5">작성일</div>
	   <div class="col col6_6">작업</div>	  
	</div>
	
	  
	  	<c:forEach var="bv" items="${blist}">
		  <div class="clearFix">
		    <div class="col col6_1"></div>
		    <div class="col col6_2"><a href="<c:url value='/'/>/AdminFaqCon.do?bIdx=${bv.bIdx}">${bv.title}</a></div>
		    <div class="col col6_3">${bv.cate}</div>	
		   <c:choose>
		   	<c:when test="${bv.viewStat eq 1 }">		   
		    <div class="col col6_4">출력</div>
		    </c:when>
		    <c:when test="${bv.viewStat eq 0 }">
		    <div class="col col6_4">비출력</div>
		    </c:when>
		   </c:choose>	    
		    <div class="col col6_5">${bv.insDate}</div>	    
		   
		    <div class="col col6_6">
			    <a href="<c:url value="/AdminFaqMod.do?bIdx=${bv.bIdx}"/>">
			    <button type='button' class='btn btn-default'>수정</button>
			    </a>
			    <a href="<c:url value="/AdminFaqDel_Action.do?bIdx=${bv.bIdx}"/>">
			    <button type='button' class='btn btn-default'>삭제</button>
			    </a>
			 </div>
		</div>
		</c:forEach>
	  </div>	  
	
	<div>
		<a href="<c:url value="/AdminFaqWrite.do"/>"><button class="btn btn-primary pull-right">글쓰기</button></a>
	</div>
</div>

<!-- main end -->
	</div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>