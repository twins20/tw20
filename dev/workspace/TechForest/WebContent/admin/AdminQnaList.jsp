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
	margin-bottom: 10px;
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
.divTable .qna2{
	width: 250px;
}
.divTable .qna3{
	width: 10%;
}
.divTable .qna6{
	width: 189px;
}

</style>
<c:set var="pagingUrl" value="/AdminQnaList.do"/>

<div class="adminWrapper">	
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
<%	
	ArrayList<BoardVo> alist1 = (ArrayList<BoardVo>) request.getAttribute("alist");
	for(BoardVo vo : alist1){
		
		String statusView = null;
		String wrtBtn = null;
		String modBtn = null;
		String delBtn = null;		
		
		if(vo.getRbIdx() == 1){
			statusView = "회원 문의";
			wrtBtn = "<button type='button' class='btn btn-primary'>답변</button>";
			modBtn = "<button type='button' class='btn btn-default'>수정</button>";
			delBtn = "<button type='button' class='btn btn-default'>삭제</button>";
		}else if(vo.getRbIdx() > 1){
			statusView = "관리자 답글";
			wrtBtn = "<button type='button' class='btn btn-primary' disabled='disabled'>답글</button>";
			modBtn = "<button type='button' class='btn btn-default'>수정</button>";
			delBtn = "<button type='button' class='btn btn-default'>삭제</button>";
		}
			
%>		
	  <div class="clearFix">
	    <div class="col col6_1"><%= vo.getrNum() %></div>
	    <div class="col col6_2 qna2"><a href="<%=request.getContextPath()%>/AdminQnaConServlet?bIdx=<%= vo.getbIdx()%>"><%= vo.getTitle()%></a></div>
	    <div class="col col6_3 qna3"><%= vo.getCate()%></div>
	    <div class="col col6_4"><%= statusView%></div>	    
	    <div class="col col6_5"><%= vo.getInsDate()%></div>	    
	    <div class="col col6_6 qna6">
	    	<a href="<%=request.getContextPath()%>/AdminQnaWrite.do?bIdx=<%= vo.getbIdx()%>"><%= wrtBtn%></a>
	    	<a href="<%=request.getContextPath()%>/AdminQnaMod.do?bIdx=<%= vo.getbIdx()%>"><%= modBtn%></a>
	    	<a href="<%=request.getContextPath()%>/AdminQnaDel_Action.do?bIdx=<%= vo.getbIdx()%>"><%= delBtn%></a></div>
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