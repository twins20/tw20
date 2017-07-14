<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!-- Attribute start -->
<%@ page import="java.util.*" %>
<%@ page import="service.BoardVo" %>
<%@ page import="service.ProjectVo" %>
<%
	BoardVo bvo = (BoardVo) request.getAttribute("bvo");
	ProjectVo pvo = (ProjectVo) request.getAttribute("pvo");
%>
<!-- Attribute end -->
<%@ include file="/header.jsp" %>
<!-- 바디	 -->
<div class="bodyWrapper clearFix">
<!-- 사이드바	 -->
<%@ include file="/sideBar/cmemberSideBar.jsp" %>
	<div class="bodyMain"> 
<!-- main start -->
<style>
.btn-default{
	margin-bottom: 3px;
}

.cmemWrapper{
	width:100%;
	padding: 0;
	margin: 0; 	 	
}

.cmemDivTable{
	margin-top: 10px;
	margin-bottom: 40px;
}

.cmemTitle{
	font-size: 20px;
	margin-top: 20px;
	margin-left: 10px;
	font-weight: bold;
}
</style>
<script>
$(document).ready(function(){
    $('#cmemberQnaReplyWriteActionButton').click(function(){
        if($('#title').val()==''){ 
            alert('제목을 입력하세요'); 
            $('#title').focus(); 
        }else if($('#contents').val()==''){
            alert('내용을 입력하세요.');
            $('#contents').focus();
        }else if(confirm("답변을 등록하시겠습니까?")){
        	$('#cmemberQnaReplyWriteAction').submit();
    	}else{
    		return false;
    	}
    });
});
</script>

<p class="cmemTitle">사업자 QNA 내용</p>	
	<form class="form-horizontal cmemberCon">
		<div class="form-group">
    		<label for="title" class="col-sm-3 control-label">제목</label>
    		<div class="col-sm-9">
      			<%=bvo.getTitle()%> 
   		 	</div>
  		</div>
  		<div class="form-group">
   	 		<label for="contents" class="col-sm-3 control-label">내용</label>
    		<div class="col-sm-9">
      			<%=bvo.getContents()%>
   			</div>
 		</div>
  	</form>
	
<div class="cmemWrapper">
	<div class="cmemDivTable">
		<div class="clearFix rowTitle">
			<div class="col col4_1">프로젝트 명</div>
			<div class="col col4_2">프로젝트 현재 투자금액</div>
			<div class="col col4_3">프로젝트 기술성 평가</div>
			<div class="col col4_4">상태</div>
		</div>
<%
String status = null;
	if(pvo.getStatus() == 1){
		status = "진행";
	}else if(pvo.getStatus() == 5){
		status = "완료";
	}else if(pvo.getStatus() == 4){
		status = "실패";
}
%>			
<div class="clearFix">
	<div>
		<div class="col col4_1"><%=pvo.getpName() %></div>
		<div class="col col4_2"><%=pvo.getPnFunds() %>원</div>
		<div class="col col4_3"><%=pvo.getpGrade() %></div>
		<div class="col col4_4"><%=status %></div>
	</div>
</div>

<p class="cmemTitle">답변 작성</p>	
	<form id="cmemberQnaReplyWriteAction" name="cmemberQnaReplyWriteAction" class="form-horizontal cmemberQnaReplyWriteAction" 	action="<%=request.getContextPath()%>/CMemberQnaReplyWrite_Action.do" method="post">
      		<input class="form-control" type="hidden" name="obIdx" id="obIdx" value="<%=bvo.getObIdx()%>">
      		<input class="form-control" type="hidden" name="cate" id="cate" value="<%=bvo.getCate()%>">
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
			<input class="btn btn-default" name="cmemberQnaReplyWriteActionButton" id="cmemberQnaReplyWriteActionButton" type="button" value="작성">
		</center>
 	</form>
	
	
	</div>
</div>
<!-- main end -->
	</div>
</div>
<%@ include file="/footer.jsp" %>