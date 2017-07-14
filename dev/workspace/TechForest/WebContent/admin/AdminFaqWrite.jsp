<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!-- Attribute start -->
<%@ page import="service.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.ArrayList" %> 
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
<p class="pageP">FAQ 글쓰기</p>
	<form method="post" action="<%=request.getContextPath()%>/AdminFaqWrite_Action.do">
		<div class="form-group">
		    <label for="title">Title</label>
		    <input class="form-control" type="text" name="title"   id="title" placeholder="제목을 입력하세요" required >
	  	</div>
	  	<div class="form-group">
			<label for="cate">CATE</label>
			<select class="form-control" name="cate" id="cate">
				<option value="회원">회원</option>
				<option value="가드닝">가드닝</option>
				<option value="결제">결제</option>					
			</select>
		</div>
		<div class="form-group">
		  <label for="content">Content</label>	    
		  <textarea class="form-control" name="contents" id="content" placeholder="내용을 입력하세요" rows="15" required></textarea> 	    
		</div>	  
  		<button type="submit" class="btn btn-primary btn-block">글쓰기</button>
	</form>
		

<!-- main end -->
	</div>
</div>
<%@ include file="/footer.jsp" %>