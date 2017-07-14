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


<h3>FAQ CON</h3>
<p>
	<form class="form-horizontal FaqCon">
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
		<div>		
	         <a class="btn btn-default" href="<%=request.getContextPath()%>/FaqList.do?bIdx=<%=vo.getbIdx() %>">글목록</a>
 		</div>	
 
  	</form>





<!-- main end -->
	</div>
</div>
<%@ include file="/footer.jsp" %>