<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!-- Attribute start -->
<%@ page import="com.port.service.*" %>
<%
MemberVo vo = (MemberVo) request.getAttribute("vo");
%>
<!-- Attribute end -->
<%@ include file="/WEB-INF/views/header.jsp" %>
<!-- 바디	 -->
<div class="bodyWrapper clearFix">
<!-- 사이드바	 -->
<%@ include file="/WEB-INF/views/sideBar/memberSideBar.jsp" %>
	<div class="bodyMain"> 
<!-- main start -->

<h1>회원님의 아이디는 <%=vo.getId() %> 입니다.</h1> 
비밀번호가 생각나지 않으시다면 비밀번호 찾기를 이용해주세요.
<a class="btn btn-primary" href="<%=request.getContextPath()%>/MemberFindPass.do">비밀번호 찾기</a>

	
<!-- main end -->
	</div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>