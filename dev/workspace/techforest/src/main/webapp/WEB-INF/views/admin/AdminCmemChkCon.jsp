<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>      
<!-- Attribute start -->
<%@ page import="com.port.service.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<!-- Attribute end -->
<%@ include file="/WEB-INF/views/header.jsp" %>
<!-- 바디	 -->
<div class="bodyWrapper clearFix">
<!-- 사이드바	 -->
<%@ include file="/WEB-INF/views/sideBar/adminSideBar.jsp" %>
	<div class="bodyMain"> 
<!-- main start -->


<div class="adminWrapper">
<p class="adminP">회원 상세 정보</p>
	<form class="form-horizontal adminIMemberList">
		<div class="form-group">
			<label for="email" class="col-sm-3 control-label">이메일</label>
			<div class="col-sm-9">
				<input type="text" class="form-control" id="email" value="${data.ID}" readonly>
			</div>
		</div>
		<div class="form-group">
			<label for="nick" class="col-sm-3 control-label">닉네임</label>		
			<div class="col-sm-9">
				<input type="text" class="form-control" id="nick" value="${data.NICK}" readonly>
			</div>
		</div>
		<div class="form-group">
			<label for="name" class="col-sm-3 control-label">성명</label>
			<div class="col-sm-9">
				<input type="text" class="form-control" id="name" value="${data.NAME}" readonly>
			</div>
		</div>
		<div class="form-group">
			<label for="tel" class="col-sm-3 control-label">전화번호</label>
			<div class="col-sm-9">
				<input type="text" class="form-control" id="tel" value="0${data.PHONE}" readonly>
			</div>
		</div>
		<div class="form-group">
			<label for="adress" class="col-sm-3 control-label">주소</label>
			<div class="col-sm-9">
				<input type="text" class="form-control" id="address" value="${data.ADDR}" readonly>
			</div>
		</div>
		<div class="form-group">
			<label for="adress" class="col-sm-3 control-label">사업자 등록번호</label>
			<div class="col-sm-9">
				<input type="text" class="form-control" id="address" value="${data.CNUMBER}" readonly>
			</div>
		</div>
		<div class="form-group">
			<label for="adress" class="col-sm-3 control-label">사업자 등록주소</label>
			<div class="col-sm-9">
				<input type="text" class="form-control" id="address" value="${data.CADDR}" readonly>
			</div>
		</div>
		<button type="button" class="btn btn-primary form-control form-mod" data-toggle="modal" data-target="#myModal">정보 수정</button>
		
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
</div>
		
<p class="adminP">제출한 사업자 등록증</p>
	<div class="cmeImg">
		<img class="cmemImg Img" src="${ContextPath}/images/cmemimg.jpg" alt="사업자 등록증" />"
	</div>

<!-- main end -->
	</div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>