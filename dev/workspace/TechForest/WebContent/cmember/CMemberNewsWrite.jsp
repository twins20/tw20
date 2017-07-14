<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!-- Attribute start -->
<%@ page import="service.ProjectVo" %>
<%
	ProjectVo vo = (ProjectVo) request.getAttribute("vo"); 
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
$(document).ready(function(){
    $('#cmemberNewsWriteActionButton').click(function(){
        if($('#title').val()=='') { 
            alert('제목을 입력하세요'); 
            $('#title').focus(); 
        } else if($('#contents').val()=='') {
            alert('내용을 입력하세요.');
            $('#contents').focus();
        } else if(confirm("뉴스를 작성하시겠습니까?")){
        	$('#cmemberNewsWriteAction').submit();
    	} else {
    		return false;
    	}
    });
});
</script>
	
	<form id="cmemberNewsWriteAction" name="cmemberNewsWriteAction" class="form-horizontal cmemberNewsWriteAction" 	action="<%=request.getContextPath()%>/CMemberNewsWrite_Action.do" method="post" >		 	
  		<div class="form-group">
      		<input class="form-control" type="hidden" name="pIdx" id="pIdx" value="<%=vo.getpIdx()%>">
   		</div>
 		<div class="form-group">
   	 		<label for="title" class="col-sm-3 control-label">제목</label>
    			<div class="col-sm-9">
    				<input class="form-control" type="text" name="title" id="title">
   				</div>
 		</div>
 		<div class="form-group">
   	 		<label for="contents" class="col-sm-3 control-label">내용</label>
    			<div class="col-sm-9">
    				<textarea class="form-control" type="text" name="contents" id="contents" rows="15"></textarea>
   				</div>
 		</div>
		<center>
			<input class="btn btn-default" name="cmemberNewsWriteActionButton" id="cmemberNewsWriteActionButton" type="button" value="작성">
		</center>
 	</form>
	
	

	
	
	<table class="table table-striped table-bordered table-hover">
	<tr>
	<td>카테고리</td>
	<td>프로젝트 명</td>
	<td>프로젝트 현재 투자금액</td>
	<td>프로젝트 목표 투자금액</td>
	<td>프로젝트 기술성 평가</td>
	<td>상태</td>
	</tr>
<%
	String status = null;
	if(vo.getStatus() == 1){
		status = "진행";
	}else if(vo.getStatus() == 5){
		status = "완료";
	}else if(vo.getStatus() == 4){
		status = "실패";
	}
%>		
	<tr>
	<td><%=vo.getpCate() %></td>
	<td><%=vo.getpName() %></td>
	<td><%=vo.getPnFunds() %></td>
	<td><%=vo.getPtFunds() %></td>
	<td><%=vo.getpGrade() %></td>
	<td><%=status %></td>
	</tr>
	</table>




	

<!-- main end -->
	</div>
</div>
<%@ include file="/footer.jsp" %>>