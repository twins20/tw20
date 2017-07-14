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
<c:set var="pagingUrl" value="/AdminCmemChkList.do"/>

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
<%	
	ArrayList<MemberVo> alist1 = (ArrayList<MemberVo>) request.getAttribute("alist");
	for(MemberVo vo : alist1){
				
		String statusMsg = null;
		String statusBtn1 = null;
		String statusBtn2 = null;
		
		if(vo.getStatus() == 0){
			statusMsg = "승인 대기";
			statusBtn1 = "<button type='button' class='btn btn-default'>승인</button>";
			statusBtn2 = "<button type='button' class='btn btn-default'>반려</button>";
			
		}else if(vo.getStatus() == 1){
			statusMsg = "승인 완료";		
			statusBtn1 = "<button type='button' class='btn btn-default'>승인</button>";
			statusBtn2 = "<button type='button' class='btn btn-default'>반려</button>";
			
		}else if(vo.getStatus() == 3){
			statusMsg = "사업자 등록 완료";	
			
		}else if(vo.getStatus() == 9){
			statusMsg = "회원 정지";		
			
		}else if(vo.getStatus() == 10){
			statusMsg = "회원 탈퇴";			
		}		
		
%>		
	  <div class="clearFix">
	    <div class="col col5_1"><%= vo.getrNum() %></div>
	    <div class="col col5_2"><a href="<%=request.getContextPath()%>/AdminCmemChkCon.do?param_idx=<%=vo.getIdx()%>"><%= vo.getName()%></a></div>
	    <div class="col col5_3"><%= vo.getModDate()%></div>	    
	    <div class="col col5_4"><%= statusMsg%></div>	    
	    <div class="col col5_5">
	   		<a href="<%=request.getContextPath()%>/AdminCmemChkOk_Action.do?param_idx=<%=vo.getIdx()%>"><%= statusBtn1%></a> 
	   		<a href="<%=request.getContextPath()%>/AdminMemoSend.do?param_idx=<%=vo.getIdx()%>"><%= statusBtn2%></a></div>
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