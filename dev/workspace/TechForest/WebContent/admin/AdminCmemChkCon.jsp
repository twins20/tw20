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
.btn-default{
	margin-bottom: 3px;
}
.adminWrapper{
	width:100%;
	padding: 0;
	margin: 0; 	 	
}
.divTable{
	margin-top: 10px;
	margin-bottom: 40px;
}
.adminP, .CmemInfo{
	font-size: 20px;
	margin-top: 20px;
	margin-left: 10px;
	font-weight: bold;
}
.form-control{
	width: 400px;
}
.btn-primary{
	margin-left: 226px;
}
.cmemimg{
	width:700px;	
	margin: 0 auto;
	margin-top: 10px;
	margin-left: 20px;
	margin-bottom: 30px;
}
.cmemimg .img{
	border: 2px solid #ccc;
}
</style>

<%
	ArrayList<MemberVo> alist1 = (ArrayList<MemberVo>) request.getAttribute("alist");
	for(MemberVo vo : alist1){		
%>
<p class="adminP">회원 상세 정보</p>
	<form class="form-horizontal adminIMemberList">
		<div class="form-group">
			<label for="email" class="col-sm-3 control-label">이메일</label>
			<div class="col-sm-9">
				<input type="text" class="form-control" id="email" value="<%=vo.getId()%>" readonly>
			</div>
		</div>
		<div class="form-group">
			<label for="nick" class="col-sm-3 control-label">닉네임</label>		
			<div class="col-sm-9">
				<input type="text" class="form-control" id="nick" value="<%=vo.getNick()%>" readonly>
			</div>
		</div>
		<div class="form-group">
			<label for="name" class="col-sm-3 control-label">성명</label>
			<div class="col-sm-9">
				<input type="text" class="form-control" id="name" value="<%=vo.getName()%>" readonly>
			</div>
		</div>
		<div class="form-group">
			<label for="tel" class="col-sm-3 control-label">전화번호</label>
			<div class="col-sm-9">
				<input type="text" class="form-control" id="tel" value="0<%=vo.getPhone()%>" readonly>
			</div>
		</div>
		<div class="form-group">
			<label for="adress" class="col-sm-3 control-label">주소</label>
			<div class="col-sm-9">
				<input type="text" class="form-control" id="address" value="<%=vo.getAddr()%>" readonly>
			</div>
		</div>
		<div class="form-group">
			<label for="adress" class="col-sm-3 control-label">사업자 등록번호</label>
			<div class="col-sm-9">
				<input type="text" class="form-control" id="address" value="<%=vo.getcNumber()%>" readonly>
			</div>
		</div>
		<div class="form-group">
			<label for="adress" class="col-sm-3 control-label">사업자 등록주소</label>
			<div class="col-sm-9">
				<input type="text" class="form-control" id="address" value="<%=vo.getcAddr()%>" readonly>
			</div>
		</div>
		<button type="button" class="btn btn-primary form-control" data-toggle="modal" data-target="#myModal">정보 수정</button>
		
		<div class="modal fade adminImemberModify" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title" id="myModalLabel">비밀번호를 입력해주세요.</h4>
			</div>
			<div class="modal-body">
				<input class="form-control" type="password" name="password" id="password">
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary">수정</button>
			</div>
		</div>
		</div>
		</div>
	</form>
		
<p class="adminP">제출한 사업자 등록증</p>
	<div class="cmemimg">
		<img class="cmemimg img" src="<%=request.getContextPath()%>/images/cmemimg.jpg" alt="사업자 등록증" />
	</div>
<% } %>





	

<!-- main end -->
	</div>
</div>
<%@ include file="/footer.jsp" %>