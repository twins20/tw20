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
.pull-right{
	margin-right: 50px;
}

</style>
<c:set var="pagingUrl" value="/AdminQnaList.do"/>

<div class="adminImemInfoListWrapper">	
<p class="adminP">전체 뉴스 리스트</p>
	<div class="divTable">  
	 <div class="clearFix rowTitle">
	   <div class="col col6_1">No </div>
	   <div class="col col6_2">제목</div>
	   <div class="col col6_3">상태</div>
	   <div class="col col6_4">작성일</div>
	   <div class="col col6_5">카테고리</div>
	   <div class="col col6_6">작업</div>	  
	</div>
<%	
	ArrayList<BoardVo> alist1 = (ArrayList<BoardVo>) request.getAttribute("alist");
	for(BoardVo vo : alist1){
		
		String statusView = null;
		String modBtn = null;
		String delBtn = null;
		
		modBtn = "<button type='button' class='btn btn-default'>수정</button>";
		delBtn = "<button type='button' class='btn btn-default'>삭제</button>";
		
		if(vo.getViewStat() == 0){
			statusView = "비출력";			
		}else{
			statusView = "출력";			
		}	
%>		
	  <div class="clearFix">
	    <div class="col col6_1"><%= vo.getrNum() %></div>
	    <div class="col col6_2"><a href="<%=request.getContextPath()%>/AdminNewsConServlet?bIdx=<%= vo.getbIdx()%>"><%= vo.getTitle()%></a></div>
	    <div class="col col6_3"><%= statusView%></div>	    
	    <div class="col col6_4"><%= vo.getInsDate()%></div>
	    <div class="col col6_5"><%= vo.getCate()%></div>	  	    
	    <div class="col col6_6">
		    <a href="<%=request.getContextPath()%>/AdminNewsMod.do?bIdx=<%= vo.getbIdx()%>"><%= modBtn%></a>
		    <a href="<%=request.getContextPath()%>/AdminNewsDel_Action.do?bIdx=<%= vo.getbIdx()%>"><%= delBtn%></a></div>
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
	<div>
		<a href="<%=request.getContextPath()%>/AdminNewsWrite.do"><button class="btn btn-primary pull-right">글쓰기</button></a>
	</div>
</div>

<!-- main end -->
	</div>
</div>
<%@ include file="/footer.jsp" %>