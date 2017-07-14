<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Attribute start -->
<%@ page import="service.MemberVo" %>
<%
	MemberVo vo = (MemberVo) request.getAttribute("vo");
%>
<!-- Attribute end -->
<%@ include file="/header.jsp" %>
<!-- 바디	 -->
<div class="bodyWrapper clearFix">
<!-- 사이드바	 -->
<%@ include file="/sideBar/imemberSideBar.jsp" %>
	<div class="bodyMain"> 
<!-- main start -->
	
	<form class="form-horizontal imemberCon">
		<div class="form-group">
    		<label for="name" class="col-sm-3 control-label">성명</label>
    		<div class="col-sm-9">
      			<%=vo.getName()%> 
   		 	</div>
  		</div>
  		<div class="form-group">
   	 		<label for="id" class="col-sm-3 control-label">이메일</label>
    		<div class="col-sm-9">
      			<%=vo.getId()%>
   			</div>
 		</div>
  		<div class="form-group">
    		<label for="nick" class="col-sm-3 control-label">닉네임</label>
    		<div class="col-sm-9">
      			<%=vo.getNick()%>
   		 	</div>
  		</div>
  		<div class="form-group">
    		<label for="phone" class="col-sm-3 control-label">전화번호</label>
    		<div class="col-sm-9">
      			<%=vo.getPhone()%>
   		 	</div>
  		</div>
  		<div class="form-group">
    		<label for="addr" class="col-sm-3 control-label">주소</label>
    		<div class="col-sm-9">
      			<%=vo.getAddr()%>
   		 	</div>
  		</div>
  		<center>
	  		<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">
	 			회원정보 수정
			</button>
		</center>
  	</form>
  	
  	
  	<form id="ModifyForm" action="<%=request.getContextPath()%>/IMemberInfoMod.do" method="post">	
		<div class="modal fade imemberModify" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		        <span aria-hidden="true">&times;</span>
		        </button>
		        <h4 class="modal-title" id="myModalLabel">비밀번호를 입력해주세요.</h4>
		      </div>
		      <div class="modal-body">
		      	 <input class="form-control" type="password" name="pw" id="pw">
		      </div>
		      <div class="modal-footer">
		        <button type="submit" id="ModifyForm" class="btn btn-primary">입력</button>
		      </div>
		    </div>
		  </div>
		</div>
	</form>

<!-- main end -->
	</div>
</div>
<%@ include file="/footer.jsp" %>