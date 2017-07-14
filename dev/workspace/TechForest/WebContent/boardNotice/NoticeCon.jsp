<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<!-- Attribute start -->
<%@ page import="service.*" %>
<%@ page import="java.util.*" %>
<%  
BoardVo vo = (BoardVo) request.getAttribute("vo");
%>
<!-- Attribute end -->
<%@ include file="/header.jsp" %>
<!-- 바디	 -->
<div class="bodyWrapper clearFix">
<!-- 사이드바	 -->
<%@ include file="/sideBar/boardSideBar.jsp" %>
	<div class="bodyMain"> 
<!-- main start -->
<style>
.btn1{
	margin:0 auto;
	text-align:center;
}
</style>


<p>
	<form class="form-horizontal NoticeCon">
		<div class="form-group">
    		<label for="cate" class="col-sm-3 control-label">카테고리</label>
    		<div class="col-sm-9">
      			<%=vo.getCate()%> 
   		 	</div>
  		</div>
  		<div class="form-group">
   	 		<label for="title" class="col-sm-3 control-label">제목</label>
    		<div class="col-sm-9">
      			<%=vo.getTitle()%>
   			</div>
 		</div>
  		<div class="form-group">
    		<label for="contents" class="col-sm-3 control-label">내용</label>
    		<div class="col-sm-9">
      			<%=vo.getContents()%>
   		 	</div>
  		</div>
  		<div class="form-group">
    		<label for="hit" class="col-sm-3 control-label">조회수</label>
    		<div class="col-sm-9">
      			<%=vo.getHit()%>
   		 	</div>
   		</div> 	
  		<div class="form-group">
    		<label for="insdate" class="col-sm-3 control-label">작성일</label>
    		<div class="col-sm-9">
      			<%=vo.getInsDate()%>
   		 	</div>
  		</div>
				
		<div class="btn1">		
	         <center><a class="btn btn-default" href="<%=request.getContextPath()%>/NoticeList.do?cate=<%=vo.getCate() %>">글목록</a></center>
 		</div>	
 
  	</form>





<!-- main end -->
	</div>
</div>
<%@ include file="/footer.jsp" %>