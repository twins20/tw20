<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!-- Attribute start -->
<%@ page import="service.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<!-- Attribute end -->
<%@ include file="/header.jsp" %>
<!-- 바디	 -->
<div class="bodyWrapper clearFix">
<!-- 사이드바	 -->
<%@ include file="/sideBar/adminSideBar.jsp" %>
	<div class="bodyMain"> 
<!-- main start -->
<style>

.pageP{
	font-size: 20px;
	margin-top: 20px;
	margin-left: 5px;
	margin-bottom: 15px;
	padding-left: 10px;
	font-weight: bold;
	border-left : 5px solid black;	
}
<%		
	ArrayList<BoardVo> alist1 = (ArrayList<BoardVo>) request.getAttribute("alist");
	for(BoardVo vo : alist1){
%>
</style>
<p class="pageP">QNA 답변하기</p>
	<form method="post" action="<%=request.getContextPath()%>/AdminQnaWrite_Action.do">		
		<input type="hidden" name="bIdx" id= "bIdx" value="<%= vo.getbIdx()%>">
		<input type="hidden" name="pIdx" id= "pIdx" value="<%= vo.getpIdx()%>">	  			
		<div class="form-group">
		    <label for="title">Title</label>
		    <input class="form-control" type="text" name="title" id="title" placeholder="<%= vo.getTitle()%>" required >
	  	</div>
	  	<div class="form-group">
		    <label for="cate">Cate</label>
		    <select class="form-control" name="cate" id="cate">
		    	<option >회원</option>
				<option >가드닝</option>
				<option >결제</option>		
			</select>	   
	  	</div>		
		<div class="form-group">
		  <label for="contents">Contents</label>	    
		  <textarea class="form-control" name="contents" id="contents" placeholder="<%= vo.getContents()%>" rows="15" required></textarea> 	    
		</div>	  
  		<button type="submit" class="btn btn-primary btn-block">답변 작성</button>
	</form>
<% } %>		

<!-- main end -->
	</div>
</div>
<%@ include file="/footer.jsp" %>