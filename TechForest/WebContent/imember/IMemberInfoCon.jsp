<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Attribute start -->
<%@ page import="service.MemberVo" %>
<%
	MemberVo vo = (MemberVo)request.getAttribute("vo");
%>
<!-- Attribute end -->
<%@ include file="/header.jsp" %> 
<!-- main start -->

	<form class="form-horizontal IMemberList">
  		<div class="form-group">
   	 		<label for="email" class="col-sm-2 control-label">이메일</label>
    		<div class="col-sm-10">
      				<input type="text" class="form-control" id="email" value="<%=vo.getId()%>" readonly>
   			</div>
 		</div>
  		<div class="form-group">
    		<label for="nick" class="col-sm-2 control-label">닉네임</label>
    		<div class="col-sm-10">
      				<input type="text" class="form-control" id="nick" value="<%=vo.getNick()%>" readonly>
   		 	</div>
  		</div>
  		<div class="form-group">
    		<label for="name" class="col-sm-2 control-label">성명</label>
    		<div class="col-sm-10">
      				<input type="text" class="form-control" id="name" value="<%=vo.getName()%>" readonly>
   		 	</div>
  		</div>
  		<div class="form-group">
    		<label for="tel" class="col-sm-2 control-label">전화번호</label>
    		<div class="col-sm-10">
      				<input type="text" class="form-control" id="tel" value="<%=vo.getPhone()%>" readonly>
   		 	</div>
  		</div>
  		<div class="form-group">
    		<label for="adress" class="col-sm-2 control-label">주소</label>
    		<div class="col-sm-10">
      				<input type="text" class="form-control" id="address" value="<%=vo.getAddr()%>" readonly>
   		 	</div>
  		</div>
  	</form>
  	
  	<center><a class="btn btn-default" href="/IMemberIn" role="button">정보 수정</a></center>
  	
  	<!-- main end -->
<%@ include file="/footer.jsp" %>