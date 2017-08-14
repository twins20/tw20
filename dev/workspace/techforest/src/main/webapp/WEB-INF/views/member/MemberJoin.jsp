<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!-- Attribute start -->

<!-- Attribute end -->
<%@ include file="/WEB-INF/views/header.jsp" %>
<!-- 바디	 -->
<div class="bodyWrapper clearFix">
<!-- 사이드바	 -->
<%@ include file="/WEB-INF/views/sideBar/memberSideBar.jsp" %>
	<div class="bodyMain"> 
<!-- main start -->
<script>
$(document).ready(function(){
    $('#memberJoinButton').click(function(){
    	if($('#id').val()=='') {
            alert('아이디를 입력하세요.');
            $('#id').focus();
        } else if($('#pw').val()=='') {
            alert('패스워드를 입력하세요.');
            $('#pw').focus();
        } else if($('#nick').val()=='') {
            alert('닉네임을 입력하세요.');
            $('#nick').focus();
        } else if($('#name').val()=='') {
            alert('성명을 입력하세요.');
            $('#name').focus();
        } else if($('#phone').val()=='') {
            alert('전화번호를 입력하세요.');
            $('#phone').focus();
        } else if($('#addr').val()=='') {
            alert('주소를 입력하세요.');
            $('#addr').focus();
        } else {
        	$('#memberJoin').submit();
        }
    });
});
</script>
	<p class="text-center"> 
	회원가입
	 </p>
	<form id="memberJoin" class="form-horizontal memberJoin" action="<%=request.getContextPath()%>/MemberJoin_Action.do" method="post" >
		<div class="form-group">
			<label for="radio" class="col-sm-3 control-label">회원 구분</label>
			<div class="col-sm-9">
				<input type="radio" name="type" value="I" checked="checked">투자자 회원
				<input type="radio" name="type" value="C">사업자 회원
			</div>
  		</div>
  		<div class="form-group">
  			<label for="email" class="col-sm-3 control-label">아이디</label>
			<div class="col-sm-9">
      			<input class="form-control" type="email" name="id" id="id" placeholder="이메일을 입력하세요">
   			</div>
  	 	</div>
  	 	<div class="form-group">
    		<label for="pw" class="col-sm-3 control-label">패스워드</label>
    		<div class="col-sm-9">
      			<input class="form-control" type="password" name="pw" id="pw" placeholder="패스워드를 입력하세요">
   			</div>
   		</div>
   		<div class="form-group">
    		<label for="nick" class="col-sm-3 control-label">닉네임</label>
    		<div class="col-sm-9">
      			<input class="form-control" type="text" name="nick" id="nick" placeholder="닉네임을 입력하세요">
   			</div>
   		</div>
   		<div class="form-group">
    		<label for="name" class="col-sm-3 control-label">성명</label>
    		<div class="col-sm-9">
      			<input class="form-control" type="text" name="name" id="name" placeholder="성명을 입력하세요">
   			</div>
   		</div>
   		<div class="form-group">
    		<label for="phone" class="col-sm-3 control-label">전화번호</label>
    		<div class="col-sm-9">
      			<input class="form-control" type="tel" name="phone" id="phone" placeholder="전화번호를 입력하세요">
   			</div>
   		</div>
   		<div class="form-group">
    		<label for="addr" class="col-sm-3 control-label">주소</label>
    		<div class="col-sm-9">
      			<input class="form-control" type="text" name="addr" id="addr" placeholder="주소를 입력하세요">
   			</div>
   		</div>
   		<div class=form-group">
   			<input class="btn btn-primary" id="memberJoinButton" type="button" value="등록">	
   			<a class="btn btn-primary" href="<%=request.getContextPath()%>/index.jsp" role="button">취소</a>
   		</div>
   	</form>

<!-- main end -->
	</div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>