<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
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

.pageP{
	font-size: 20px;
	margin-top: 20px;
	margin-left: 5px;
	margin-bottom: 15px;
	padding-left: 10px;
	font-weight: bold;
	border-left : 5px solid black;	
}
.Box1{
	margin: 0;
	width: 400px;
	display: inline-block;
	float: left;
}
.Box2{
	margin: 0;
	width: 475px;
	display: inline-block;
	float: left;
}
.pCon1{
	width: 475px;
	margin-left: 20px;
	margin-bottom: 8px;
	padding: 0;
	float: left;
	display: inline-block;
}	
.pCon1 h4{
	margin-top: 0px;
	font-weight: bold;
}
.pCon2 h4{
	margin-top: 20px;
	font-weight: bold;
}

</style>
<p class="pageP">프로젝트 상세 내용</p>
<%

ArrayList<Map<String, Object>> alist1 = (ArrayList<Map<String, Object>>) request.getAttribute("alist"); 

for(Map<String, Object> hashmap : alist1){
	
	ProjectVo pvo = (ProjectVo) hashmap.get("pvo");		
	ItemVo ivo = (ItemVo) hashmap.get("ivo");
	
%>	

	<div class="pC Box1">
		<img src="<%=request.getContextPath()%>/images/projectTest.PNG" alt="프로젝트1">
	</div>
	
	<div class="pC Box2">
		<div class="pCon1">
			<h4>프로젝트 명</h4>
			<div class="pCon1">
				<%= pvo.getpName()%>
			</div>
		</div>		
		<div class="pCon1">
			<h4>카테고리</h4>
			<div class="pCon1">
			 	<%= pvo.getpCate()%>
			</div>
		</div>		
		<div class="pCon1">
			<h4>프로젝트 목표 금액</h4>
			<div class="pCon1">
				<%= pvo.getPtFunds()%>원
			</div>
		</div>		
		<div class="pCon1">
			<h4>아이탬 리스트</h4>
			<div class="pCon1">
			 	<%= pvo.getItList()%>
			</div>
		</div>		
		<div class="pCon1">
			<h4>기술성 평가 등급</h4>
			<div class="pCon1">
			 	<%= pvo.getpGrade()%>
			</div>
		</div>		
		<div class="pCon1">
			<h4>프로젝트 신청일</h4>
			<div class="pCon1">
			 	<%= pvo.getInsDate()%>
			</div>
		</div>		
	</div>

<div class="pC Box3">
	<a href="<%=request.getContextPath()%>/AdminProjChkOk_Action.do?pIdx=<%=pvo.getpIdx()%>">
		<button type="submit" class="btn btn-primary btn-block">프로젝트 승인 하기</button></a>
</div>	


	<div class="pCon2">
		<h4>프로젝트 내용</h4>
	</div>
	<textarea class="form-control" rows="10"><%= pvo.getContents()%></textarea>	
	
				
		
<% } %>			
		

<!-- main end -->
	</div>
</div>
<%@ include file="/footer.jsp" %>