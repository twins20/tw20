<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!-- Attribute start -->
<%@ page import="service.ProjectVo" %>
<%@ page import="java.util.*" %>
<%
	ArrayList<ProjectVo> alist = (ArrayList<ProjectVo>) request.getAttribute("alist");
	int idx = (Integer) request.getAttribute("idx");
%>
<!-- Attribute end -->
<%@ include file="/header.jsp" %> 
<!-- main start -->
<script>
function wishListDel(){ 
	if(confirm("위시리스트에서 삭제하시겠습니까?")){
    	location.href="<%=request.getContextPath()%>/IMemberWishListDel_Action.do?idx=<%=idx %>";
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
<%@ include file="/footer.jsp" %>