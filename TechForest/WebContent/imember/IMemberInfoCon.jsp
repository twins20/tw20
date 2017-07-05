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
      				<input type="text" class="form-control" id="tel" value="<%=vo.getPhone()%>" readonly>
   		 	</div>
  		</div>
  		<div class="form-group">
    		<label for="adress" class="col-sm-3 control-label">주소</label>
    		<div class="col-sm-9">
      				<input type="text" class="form-control" id="address" value="<%=vo.getAddr()%>" readonly>
   		 	</div>
  		</div>
		<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
 		정보 수정
		</button>
		<div class="modal fade imemberModify" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
  	
  	
  	
  	<!-- main end -->
<%@ include file="/footer.jsp" %>