<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!-- Attribute start -->
<%@ page import="service.MemoVo" %>
<%
	MemoVo vo = (MemoVo) request.getAttribute("vo");
%>
<!-- Attribute end -->
<%@ include file="/header.jsp" %>
<!-- 바디	 -->
<div class="bodyWrapper clearFix">
<!-- 사이드바	 -->
<%@ include file="/sideBar/cmemberSideBar.jsp" %>
	<div class="bodyMain"> 
<!-- main start -->
<script>

function memoListDel(){ 
	if(confirm("메모를 삭제하시겠습니까?")){
    	location.href="<%=request.getContextPath()%>/CMemberMemoDel_Action.do?memoidx=<%=vo.getMemoIdx()%>";
    	}else{
    		alert("삭제되지 않았습니다.");
    	}
	}
	
</script>

	<table class="table table-striped table-bordered table-hover">
	<tr>
	<td>보낸 사람</td>
	<td>받은 사람</td>
	<td>내용</td>
	<td>상태</td>
	</tr>
<%
	String status = null;
	
	if(vo.getStatus() == 0){
		status = "읽지 않음";
	}else if(vo.getStatus() == 1){
		status = vo.getModDate();
	}
%>
	<tr>
	<td><%=vo.getSendIdx() %></td>
	<td><%=vo.getRecvIdx() %></td>
	<td><%=vo.getContents() %></td>
	<td><%=status %> </td>
	</tr>
	</table>
	
	<button class="btn btn-default" id="memoListDel" type="button" onclick="memoListDel()">삭제</button>


	

<!-- main end -->
	</div>
</div>
<%@ include file="/footer.jsp" %>