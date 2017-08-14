<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!-- Attribute start -->

<!-- Attribute end -->
<%@ include file="/WEB-INF/views/header.jsp" %>
<!-- 바디	 -->
<div class="bodyWrapper clearFix">
<!-- 사이드바	 -->
<%@ include file="/WEB-INF/views/sideBar/cmemberSideBar.jsp" %>
	<div class="bodyMain"> 
<!-- main start -->
<script>
$(document).ready(function(){
    $('#cmemberInfoExtWriteActionButton').click(function(){
        if($('#company').val()=='') { 
            alert('회사명을 입력하세요'); 
            $('#company').focus(); 
        } else if($('#cNumber').val()=='') {
            alert('사업자번호를 입력하세요.');
            $('#cNumber').focus();
        } else if($('#cAddr').val()=='') {
            alert('사업자주소를 입력하세요.');
            $('#cAddr').focus();
        } else if(confirm("사업자 등록을 하시겠습니까?")){
        	$('#cmemberInfoExtWriteAction').submit();
    	} else {
    		return false;
    	}
    });
});
</script>
	
	<form id="cmemberInfoExtWriteAction" name="cmemberInfoExtWriteAction" class="form-horizontal cmemberInfoExtWriteAction" 	action="<%=request.getContextPath()%>/CMemberInfoExtWrite_Action.do" method="post" >		 	
 		<div class="form-group">
   	 		<label for="title" class="col-sm-3 control-label">회사명</label>
    			<div class="col-sm-9">
    				<input class="form-control" type="text" name="company" id="company">
   				</div>
 		</div>
 		<div class="form-group">
   	 		<label for="contents" class="col-sm-3 control-label">사업자번호</label>
    			<div class="col-sm-9">
    				<input class="form-control" type="text" name="cNumber" id="cNumber">
   				</div>
 		</div>
 		<div class="form-group">
   	 		<label for="contents" class="col-sm-3 control-label">사업자주소</label>
    			<div class="col-sm-9">
    				<input class="form-control" type="text" name="cAddr" id="cAddr">
   				</div>
 		</div>
		<center>
			<input class="btn btn-default" name="cmemberInfoExtWriteActionButton" id="cmemberInfoExtWriteActionButton" type="button" value="작성">
		</center>
 	</form>
 	   	<p class="lead text-center"><br>
   	사업자 등록을 위해서는 먼저 아래 메일주소로 사업자등록증을 접수하셔야 합니다.<br>
   	접수 후 승인 절차가 진행되며 승인이 완료된 사업자 분께선 프로젝트를 등록하실 수 있습니다.<br><br>
   	<strong>	
   		admin@techforest.com
   	</strong>
   	</p>


	

<!-- main end -->
	</div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>