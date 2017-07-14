<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!-- Attribute start -->
<%@ page import="java.util.*" %>
<%@ page import="service.ProjectVo" %>
<%
	ArrayList<ProjectVo> alist = (ArrayList<ProjectVo>) request.getAttribute("alist");
%>
<!-- Attribute end -->
<%@ include file="/header.jsp" %>
<!-- 바디	 -->
<div class="bodyWrapper clearFix">
<!-- 사이드바	 -->
<%@ include file="/sideBar/imemberSideBar.jsp" %>
	<div class="bodyMain"> 
<!-- main start -->
<script>

function wishListDel(){ 
	if(confirm("위시리스트에서 삭제하시겠습니까?")){
    	location.href="<%=request.getContextPath()%>/IMemberWishListDel_Action.do?";
    	}else{
    		alert("삭제되지 않았습니다.");
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
	for(ProjectVo vo : alist){
		float goalRate = 0;
		float pnFunds = 0;
		float ptFunds = 0;
		pnFunds = vo.getPnFunds();
		ptFunds = vo.getPtFunds();
		goalRate = (pnFunds / ptFunds) * 100;
%>			
	<tr>
	<td><%=vo.getpIdx() %></td>
	<td><%=vo.getrNum() %></td>
	<td><%=vo.getpName() %></td>
	<td><%=vo.getPnFunds() %>원</td>
	<td><%=vo.getPtFunds() %>원</td>
	<td><%=goalRate %>%</td>
	<td><button class="btn btn-default" id="IMemberChargeAction" type="button" onclick="wishListDel()">삭제하기</button></td>
	</tr>
<% } %>
	</table>

<!-- main end -->
	</div>
</div>
<%@ include file="/footer.jsp" %>