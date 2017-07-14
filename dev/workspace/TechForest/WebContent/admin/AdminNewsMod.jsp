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

</style>

<%		
	ArrayList<Map<String, Object>> alist1 = (ArrayList<Map<String, Object>>) request.getAttribute("alist");
	for(Map<String, Object> hashmap : alist1){
		BoardVo bvo = (BoardVo) hashmap.get("bvo");
%>
<p class="pageP">뉴스 수정하기</p>
	<form method="post" action="<%=request.getContextPath()%>/AdminNewsMod_Action.do">
		<div class="form-group">
		    <label for="title">Title</label>
		    <input class="form-control" type="text" name="title" id="title" value="<%= bvo.getTitle()%>" required >
	  	</div>		
	  	<div class="form-group">
			<label for="cate">CATE</label>
			<select class="form-control" name="cate" id="cate">
				<option>IT/TECH</option>
				<option>HAND MADE</option>
				<option>BEAUTY</option>
				<option>FOOD</option>
				<option>FASHION</option>
				<option>etc</option>				
			</select>
		</div>
		<div class="form-group">
		  <label for="content">Content</label>	    
		  <textarea class="form-control" name="contents" id="contents" rows="15" required><%= bvo.getContents()%></textarea> 	    
		</div>	 
		<input type="hidden" name="bIdx" value="<%= bvo.getbIdx()%>" > 
  		<button type="submit" class="btn btn-primary btn-block">글쓰기</button>
	</form>
	
<%} %>		

<!-- main end -->
	</div>
</div>
<%@ include file="/footer.jsp" %>