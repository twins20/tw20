<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!-- Attribute start -->
<%@ page import="java.util.*" %>
<%@ page import="com.port.service.*" %>
<%
	ArrayList<ProjectVo> plist = (ArrayList<ProjectVo>) request.getAttribute("plist");
%>
<!-- Attribute end -->
<%@ include file="/WEB-INF/views/header.jsp" %>
<!-- 바디	 -->
<div class="bodyWrapper clearFix">
<!-- 사이드바	 -->
<%@ include file="/WEB-INF/views/sideBar/imemberSideBar.jsp" %>
	<div class="bodyMain"> 
<!-- main start -->
<script>
function wishListDel(){ 
	if(confirm("위시리스트에서 삭제하시겠습니까?")){
    	}else{
    		return false;
    	}
	}
	
</script>
	<table class="table table-striped table-bordered table-hover">
		<tr>
			<td>순번</td>
			<td>프로젝트 명</td>
			<td>프로젝트 현재 투자금액</td>
			<td>프로젝트 목표 도달금액</td>
			<td>목표도달율</td>
			<td>주문관리</td>
		</tr>
<% 
	for(ProjectVo vo : plist){
		float goalRate = 0;
		float pnFunds = 0;
		float ptFunds = 0;
		pnFunds = vo.getPnFunds();
		ptFunds = vo.getPtFunds();
		goalRate = (pnFunds / ptFunds) * 100;

%>
	<tr>
		<td><%=vo.getrNum() %></td>
		<td><a href="<%=request.getContextPath()%>/ProjectCon.do?pIdx=<%=vo.getpIdx()%>"><%=vo.getpName() %></a></td>
		<td><%=vo.getPnFunds() %>원</td>
		<td><%=vo.getPtFunds() %>원</td>
		<td><%=goalRate %>%</td>
		<td><a href="<%=request.getContextPath()%>/IMemberWishListDel_Action.do?pIdx=<%=vo.getpIdx() %>" class="btn btn-default" id="wishListDelButton" type="button" onclick="wishListDel()">삭제하기</a></button></td>
	</tr>
<% } %>
	</table>

<!-- main end -->
	</div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>