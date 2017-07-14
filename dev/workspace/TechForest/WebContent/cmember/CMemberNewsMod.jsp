<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!-- Attribute start -->
<%@ page import="service.BoardVo" %>
<%
	BoardVo vo = (BoardVo) request.getAttribute("bvo");
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
    $('#cmemberNewsModifyActionButton').click(function(){
        if($('#title').val()=='') { 
            alert('제목을 입력하세요.'); 
            $('#title').focus(); 
        } else if($('#contents').val()=='') {
            alert('내용을 입력하세요.');
            $('#contents').focus();
        } else if(confirm("수정 하시겠습니까?")){
        	$('#cmemberNewsModifyAction').submit();
    	} else {
    		return false;
    	}
    });
});
</script>

	<form id="cmemberNewsModifyAction" class="form-horizontal cmemberNewsModifyAction" 	action="<%=request.getContextPath()%>/CMemberNewsMod_Action.do" method="post" >
  	 	<div class="form-group">
      		<input class="form-control" type="hidden" name="bIdx" id="bIdx" value="<%=vo.getbIdx()%>">
   		</div>
   		<div class="form-group">
   			<input class="form-control" type="hidden" name="pIdx" id="pIdx" value="<%=vo.getpIdx()%>">
   		</div>	
  		<div class="form-group">
   	 		<label for="title" class="col-sm-3 control-label">제목</label>
    		<div class="col-sm-9">
    			<input class="form-control" type="text" name="title" id="title" value="<%=vo.getTitle()%>">
   			</div>
 		</div>
 		<div class="form-group">
   	 		<label for="contents" class="col-sm-3 control-label">내용</label>
    		<div class="col-sm-9">
      			<textarea class="form-control" type="text" name="contents" id="contents" rows="15"><%=vo.getContents()%></textarea>
   			</div>
 		</div>
 		<center><input class="btn btn-primary" id="cmemberNewsModifyActionButton" type="button" value="수정" ></center>
 	</form>




	

<!-- main end -->
	</div>
</div>
<%@ include file="/footer.jsp" %>