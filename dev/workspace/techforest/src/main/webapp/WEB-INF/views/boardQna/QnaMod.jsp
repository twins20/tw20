<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ page import="com.port.service.*" %>
<%@ page import="java.util.*" %> 
<!-- Attribute start -->
<%  
BoardVo vo = (BoardVo) request.getAttribute("vo");
%>
<!-- Attribute end -->
<%@ include file="/WEB-INF/views/header.jsp" %>
<!-- 바디	 -->
<div class="bodyWrapper clearFix">
<!-- 사이드바	 -->
<%@ include file="/WEB-INF/views/sideBar/boardSideBar.jsp" %>
	<div class="bodyMain"> 
<!-- main start -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
        $('#ModifyButton').click(function(){ 
            if($('#title').val().length <1) { 
                alert('카테고리를 입력해주세요'); 
                $('#title').focus(); 
            } else if($('#contents').val()=='') { 
                alert('제목을를 입력하세요'); 
                $('#contents').focus();
            } else {
                $('#ModifyForm').submit(); 
            }
        });
    });
</script>
	<h1>QNA MODIFY</h1>   
		<form id="ModifyForm" action="<%=request.getContextPath()%>/QnaMod_Action.do" method="post">
	  		<div class="form-group">
	           <label for="bIdx"></label>
	      		<input class="form-control" name="bIdx" id="bIdx" type="hidden" value="<%=vo.getbIdx() %>" autocomplete="off" readonly="readonly"/>
	      	</div>
	  		<div class="form-group">
	    		<label for="title" class="col-sm-3 control-label">제목</label>
	    		<input class="form-control" name="title" id="title" type="text" value="<%=vo.getTitle() %>"/>
	  		</div>
	  				<div class="form-group">
	    		<label for="contents" class="col-sm-3 control-label">내용</label>
	    		<input class="form-control" name="contents" id="contents" type="text" value="<%=vo.getContents() %>"/>
	  		</div>		
	    </form>	
		<div>
			<input class="btn btn-default" id="ModifyButton" type="button" value="수정완료"/>
			<a class="btn btn-default" href="<%=request.getContextPath()%>/QnaList.do?idx=<%=vo.getIdx() %>">글목록</a>
		</div>
<!-- main end -->
	</div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>