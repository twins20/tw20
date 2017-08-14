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
    $('#cmemberProjApplyWriteActionButton').click(function(){
        if($('#pName').val()=='') { 
            alert('프로젝트 명을 입력하세요'); 
            $('#pName').focus(); 
        } else if($('#pCate').val()=='') {
            alert('프로젝트 카테고리를 입력하세요');
            $('#pCate').focus();
        } else if($('#itListCnt').val()=='') {
            alert('아이템 수량을 입력하세요');
            $('#itListCnt').focus();
        } else if($('#ptFunds').val()=='') {
            alert('프로젝트 투자금액을 입력하세요');
            $('#ptFunds').focus();
        } else if($('#pGrade').val()=='') {
            alert('프로젝트 평가를 입력하세요');
            $('#pGrade').focus();
        } else if($('#contents').val()=='') {
            alert('내용을 입력하세요');
            $('#contents').focus();
        } else if(confirm("프로젝트 등록을 하시겠습니까?")){
        	$('#cmemberProjApplyWriteAction').submit();
    	} else {
    		return false;
    	}
    });
});
</script>

	<form id="cmemberProjApplyWriteAction" name="cmemberProjApplyWriteAction" class="form-horizontal cmemberProjApplyWriteAction" 	action="<%=request.getContextPath()%>/CMemberProjApplyWrite_Action.do" method="post">		 	
 		<div class="form-group">
   	 		<label for="pName" class="col-sm-3 control-label">프로젝트 명</label>
    			<div class="col-sm-9">
    				<input class="form-control" type="text" name="pName" id="pName">
   				</div>
 		</div>
 		<div class="form-group">
   	 		<label for="pCate" class="col-sm-3 control-label">카테고리</label>
    			<div class="col-sm-9">
    				<input class="form-control" type="text" name="pCate" id="pCate">
   				</div>
 		</div>
 		<div class="form-group">
   	 		<label for="itListCnt" class="col-sm-3 control-label">아이템 옵션 개수</label>
    			<div class="col-sm-9">
    				<input class="form-control" type="text" name="itListCnt" id="itListCnt">
    			</div>
 		</div>
 		<div class="form-group">
   	 		<label for="_itName" class="col-sm-3 control-label">아이템 명</label>
    			<div class="col-sm-9">
    				<input class="form-control" type="text" name="_itName" id="_itName">
   				</div>
 		</div>
 		<div class="form-group">
   	 		<label for="_itPrice" class="col-sm-3 control-label">아이템 가격</label>
    			<div class="col-sm-9">
    				<input class="form-control" type="text" name="_itPrice" id="_itPrice">
   				</div>
 		</div>
 		<div class="form-group">
   	 		<label for="_contents" class="col-sm-3 control-label">아이템 내용</label>
    			<div class="col-sm-9">
    				<input class="form-control" type="text" name="_contents" id="_contents">
   				</div>
 		</div>
 		<div class="form-group">
   	 		<label for="_itTCnt" class="col-sm-3 control-label">아이템 총갯수</label>
    			<div class="col-sm-9">
    				<input class="form-control" type="text" name="_itTCnt" id="_itTCnt">
   				</div>
 		</div>
 		<div class="form-group">
   	 		<label for="ptFunds" class="col-sm-3 control-label">프로젝트 투자금액</label>
    			<div class="col-sm-9">
    				<input class="form-control" type="text" name="ptFunds" id="ptFunds">
   				</div>
 		</div>
 		<div class="form-group">
   	 		<label for="pGrade" class="col-sm-3 control-label">프로젝트 기술성 평가</label>
    			<div class="col-sm-9">
    				<input class="form-control" type="text" name="pGrade" id="pGrade">
   				</div>
 		</div>
 		<div class="form-group">
   	 		<label for="contents" class="col-sm-3 control-label">내용</label>
    			<div class="col-sm-9">
    				<textarea class="form-control" type="text" name="contents" id="contents" row="15" ></textarea>
   				</div>
 		</div>
		<center>
			<input class="btn btn-default" name="cmemberProjApplyWriteActionButton" id="cmemberProjApplyWriteActionButton" type="button" value="작성">
		</center>
 	</form>




	

<!-- main end -->
	</div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>