<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!-- Attribute start -->

<!-- Attribute end -->
<%@ include file="/header.jsp" %>
<!-- 바디	 -->
<div class="bodyWrapper clearFix">
<!-- 사이드바	 -->
<%@ include file="/sideBar/memberSideBar.jsp" %>
	<div class="bodyMain"> 
<!-- main start -->
<script>
$(document).ready(function(){
    $('#memberFindMailButton').click(function(){
    	if($('#name').val()=='') {
            alert('이름을 입력하세요.');
            $('#name').focus();
        } else if($('#phone').val()=='') {
            alert('전화번호를 입력하세요.');
            $('#phone').focus();
        } else {
        	$('#memberFindMail').submit();
        }
    });
});
</script>
<p class="text-center"> 
	아이디 찾기
	 </p>
	<form id="memberFindMail" class="form-horizontal memberFindMail" 	action="<%=request.getContextPath()%>/MemberFindMail_Action.do" method="post" >
  		<div class="form-group">
  			<label for="name" class="col-sm-3 control-label">이름</label>
			<div class="col-sm-6">
      			<input class="form-control" type="text" name="name" id="name" placeholder="이름을 입력하세요">
   			</div>
  	 	</div>
  	 	<div class="form-group">
    		<label for="phone" class="col-sm-3 control-label">전화번호</label>
    		<div class="col-sm-6">
      			<input class="form-control" type="tel" name="phone" id="phone" placeholder="전화번호를 입력하세요">
   			</div>
   		</div>
   		<div class=form-group">
   			<center><input class="btn btn-primary" id="memberFindMailButton" type="button" value="입력"></center>	
   		</div>
   	</form>



	

<!-- main end -->
	</div>
</div>
<%@ include file="/footer.jsp" %>