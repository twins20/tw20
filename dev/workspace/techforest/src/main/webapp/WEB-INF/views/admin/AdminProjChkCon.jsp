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

<p class="pageP">프로젝트 상세 내용</p>
	
<div class="adminPWrapper">
	<div class="pC Box1">
		<img src="<%=request.getContextPath()%>/images/projectTest.PNG" alt="프로젝트1">
	</div>
	
	<div class="pC Box2">
		<div class="pCon1">
			<h4>프로젝트 명</h4>
			<div class="pCon1">
				${data.PNAME}
			</div>
		</div>		
		<div class="pCon1">
			<h4>카테고리</h4>
			<div class="pCon1">
			 	${data.PCATE}
			</div>
		</div>		
		<div class="pCon1">
			<h4>프로젝트 목표 금액</h4>
			<div class="pCon1">
				${data.PTFUNDS}원
			</div>
		</div>		
		<div class="pCon1">
			<h4>아이탬 리스트</h4>
			<div class="pCon1">
			 	${data.ITLIST}
			</div>
		</div>		
		<div class="pCon1">
			<h4>기술성 평가 등급</h4>
			<div class="pCon1">
				${data.PGRADE}		 	
			</div>
		</div>		
		<div class="pCon1">
			<h4>프로젝트 신청일</h4>
			<div class="pCon1">
			 	${data.INSDATE}
			</div>
		</div>		
	</div>

<div class="pC Box3">
	<a href="<c:url value="/AdminProjChkOk_Action.do?pIdx=${pIdx}"/>">
		<button type="submit" class="btn btn-primary btn-block">프로젝트 승인 하기</button></a>
</div>	


	<div class="pCon2">
		<h4>프로젝트 내용</h4>
	</div>
	<textarea class="form-control" rows="10">${data.CONTENTS}</textarea>	
	
						
</div>	

<!-- main end -->
	</div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>