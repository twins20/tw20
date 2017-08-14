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
    $('#memberLogInButton').click(function(){
    	if($('#id').val()=='') {
            alert('아이디를 입력하세요.');
            $('#id').focus();
        } else if($('#pw').val()=='') {
            alert('비밀번호를 입력하세요.');
            $('#pw').focus();
        } else {
        	$('#memberLogIn').submit();
        }
    });
});
</script>
	<p class="text-center"> 
	로그인
	 </p>
	<form id="memberLogIn" class="form-horizontal memberLogIn" 	action="<%=request.getContextPath()%>/MemberLogIn_Action.do" method="post" >
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
   		<div class=form-group">
   			<center><input class="btn btn-primary" id="memberLogInButton" type="button" value="로그인"></center>	
   			<a class="btn btn-primary" href="<%=request.getContextPath()%>/MemberJoin.do">회원가입</a>
   			<a class="btn btn-primary" href="<%=request.getContextPath()%>/MemberFindMail.do">아이디/비밀번호 찾기</a>
   		</div>
   	</form>

<!-- main end -->
	</div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>