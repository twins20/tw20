<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!-- Attribute start -->
<%@ page import="service.MemberVo" %>
<%
MemberVo vo = (MemberVo) request.getAttribute("vo");
%>
<!-- Attribute end -->
<%@ include file="/header.jsp" %>
<!-- 바디	 -->
<div class="bodyWrapper clearFix">
<!-- 사이드바	 -->
<%@ include file="/sideBar/memberSideBar.jsp" %>
	<div class="bodyMain"> 
<!-- main start -->
회원님의 비밀번호는 <%=vo.getPw() %>입니다.




	

<!-- main end -->
	</div>
</div>
<%@ include file="/footer.jsp" %>