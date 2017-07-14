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
<%@ include file="/sideBar/imemberSideBar.jsp" %>
	<div class="bodyMain"> 
<!-- main start -->
<script>
	function memodelete(){ // function = 함수
		if(confirm("삭제 하시겠습니까?")){ // confirm = 경고창
        	location.href="<%=request.getContextPath()%>/MemberMemoDel_Action.do?memoIdx=<%=vo.getMemoIdx() %>";
        	}else{
        		alert("삭제되지 않았습니다.");
        	}
		}
</script>
	<form class="form-horizontal imemberCon">
  		<div class="form-group">
   	 		<label for="sendidx" class="col-sm-3 control-label">보낸사람idx</label>
    		<div class="col-sm-9">
      			<%=vo.getSendIdx()%>
   			</div>
 		</div>
  		<div class="form-group">
    		<label for="recvidx" class="col-sm-3 control-label">받은사람idx</label>
    		<div class="col-sm-9">
      			<%=vo.getRecvIdx()%>
   		 	</div>
  		</div>
  		<div class="form-group">
    		<label for="contetns" class="col-sm-3 control-label">내용</label>
    		<div class="col-sm-9">
      			<%=vo.getContents()%>
   		 	</div>
  		</div>
  		<div class="form-group">
    		<label for="status" class="col-sm-3 control-label">상태</label>
    		<div class="col-sm-9">
      			<%=vo.getStatus()%>
   		 	</div>
  		</div>
  		<input class="btn btn-default" id="DeleteButton" type="button" value="삭제" onclick="memodelete()"/>
  	</form>


	

<!-- main end -->
	</div>
</div>
<%@ include file="/footer.jsp" %>