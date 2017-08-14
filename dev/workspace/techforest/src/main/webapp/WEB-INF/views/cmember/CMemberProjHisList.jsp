<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!-- Attribute start -->
<%@ page import="java.util.*" %>
<%@ page import="com.port.service.*" %>
<!-- Attribute end -->
<%@ include file="/WEB-INF/views/header.jsp" %>
<!-- 바디	 -->
<div class="bodyWrapper clearFix">
<!-- 사이드바	 -->
<%@ include file="/WEB-INF/views/sideBar/cmemberSideBar.jsp" %>
	<div class="bodyMain"> 
<!-- main start -->
<style>
.btn-default{
	margin-bottom: 3px;
}

.cmemWrapper{
	width:100%;
	padding: 0;
	margin: 0; 	 	
}

.cmemDivTable{
	margin-top: 10px;
	margin-bottom: 40px;
}

.cmemTitle{
	font-size: 20px;
	margin-top: 20px;
	margin-left: 10px;
	font-weight: bold;
}
</style>
<p class="cmemTitle">완료된 프로젝트</p>
<div class="cmemWrapper">
	<div class="cmemDivTable">
		<div class="clearFix rowTitle">
			<div class="col col6_1">순번</div>
			<div class="col col6_2">프로젝트 명</div>
			<div class="col col6_3">프로젝트 현재 투자금액</div>
			<div class="col col6_4">프로젝트 목표 투자금액</div>
			<div class="col col6_5">목표도달율</div>
			<div class="col col6_6">상태</div>
		</div>

		<div class="clearFix">
			<div>
				<c:forEach var="pv" items="${plist }" >
					<div class="col col6_1">${pv.rNum }</div>
					<div class="col col6_2"><a href="<c:url value='/ProjCon.do?pIdx=${pv.pIdx }' />">${pv.pName }</a></div>
					<div class="col col6_3">${pv.pnFunds }원</div>
					<div class="col col6_4">${pv.ptFunds }원</div>
					<div class="col col6_5">${(pv.pnFunds / pv.ptFunds) * 100}%</div>
					<c:choose>
						<c:when test="${pv.status eq 5 }">
							<div class="col col6_6">성공</div>	
						</c:when>	
						<c:when test="${pv.status eq 4 }">
							<div class="col col6_6">실패</div>
						</c:when>
					</c:choose>
				</c:forEach>
			</div>
		</div>	
	</div>
</div>
<!-- main end -->
	</div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>