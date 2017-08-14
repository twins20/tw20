<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Attribute start -->
<%@ page import="java.util.*" %>
<%@ page import="com.port.service.*" %>
<!-- Attribute end -->
<%@ include file="/WEB-INF/views/header.jsp" %>
<!-- 바디	 -->
<div class="bodyWrapper clearFix">
<!-- 사이드바	 -->
<%@ include file="/WEB-INF/views/sideBar/projectSideBar.jsp" %>
	<div class="bodyMain"> 
<!-- main start -->
<style>

.project-list {
	width: 879px;
	margin: 0 auto;
	overflow: hidden;
	line-height: 1;
}
.project-list .project-list-ul {
	display: flex;
	flex-wrap: wrap;
	padding: 0;
	margin: 20px 10px;
	list-style: none;
}
.project-list .project-list-ul li {
	width : 245px;
	margin : 0 20px;
}
h1 {
	text-align: center;
}

</style>
<div class="project-list">
	<ul class="project-list-ul">
		<c:forEach var="pv" items="${plist }">
		<li>
			<a href="<c:url value='/ProjectCon.do?pIdx=${pv.pIdx }' />">
				<div class="project-box">
					<img src="/techforest/resources/images/${pv.pUrl }" width="245px" height="165" alt="프로젝트 이미지" >
				</div>
			<div class="project-info">	
				<dl>
					<dt>${pv.pName }</dt>
					<dd>${pv.pCate }</dd>
					<dd><fmt:formatNumber value="${pv.pnFunds }" pattern="###,###,###" />원 달성</dd>
					<dd>${pv.pGrade }</dd>
				</dl>
			</div>
			</a>
		</li>
		</c:forEach>
	</ul>
</div>	
<!-- main end -->
	</div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>