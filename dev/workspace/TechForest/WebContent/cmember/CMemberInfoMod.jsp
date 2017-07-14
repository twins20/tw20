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
<%@ include file="/sideBar/cmemberSideBar.jsp" %>
	<div class="bodyMain"> 
<!-- main start -->
<script>
$(document).ready(function(){
    $('#cmemberModifyButton').click(function(){
        if($('#name').val().length <1) { 
            alert('이름은 1자이상 이어야 합니다.'); 
            $('#name').focus(); 
        } else if($('id').val()=='') {
            alert('아이디를 입력하세요.');
            $('#id').focus();
        } else if($('#pw').val()=='') {
            alert('패스워드를 입력하세요.');
            $('#pw').focus();
        } else if($('#nick').val()=='') {
            alert('닉네임을 입력하세요.');
            $('#nick').focus();
        } else if($('#phone').val()=='') {
            alert('전화번호를 입력하세요.');
            $('#phone').focus();
        } else if($('#addr').val()=='') {
            alert('주소를 입력하세요.');
            $('#addr').focus();
        } else if(confirm("수정 하시겠습니까?")){
        	$('#cmemberModifyAction').submit();
    	} else {
    		return false;
    	}
    });
});
</script>

	<form id="cmemberModifyAction" class="form-horizontal cmemberModifyAction" 	action="<%=request.getContextPath()%>/CMemberInfoMod_Action.do" method="post" >
  		<div class="form-group">
  	 	</div>
  	 	<div class="form-group">
    		<label for="name" class="col-sm-3 control-label">성명</label>
    		<div class="col-sm-9">
      			<input class="form-control" type="text" name="name" id="name" value="<%=vo.getName()%>" readonly>
   		</div>
  		</div>
  		<div class="form-group">
   	 		<label for="id" class="col-sm-3 control-label">이메일</label>
    		<div class="col-sm-9">
      				<input class="form-control" type="text" id="id" value="<%=vo.getId()%>"  readonly>
   			</div>
 		</div>
 		<div class="form-group">
   	 		<label for="pw" class="col-sm-3 control-label">비밀번호</label>
    		<div class="col-sm-9">
      				<input  class="form-control" type="password" name="pw" id="pw" value="<%=vo.getPw()%>">
   			</div>
 		</div>
  		<div class="form-group">
    		<label for="nick" class="col-sm-3 control-label">닉네임</label>
    		<div class="col-sm-9">
      				<input class="form-control" type="text" name="nick" id="nick" value="<%=vo.getNick()%>">
   		 	</div>
  		</div>
  		<div class="form-group">
    		<label for="phone" class="col-sm-3 control-label">전화번호</label>
    		<div class="col-sm-9">
      				<input class="form-control" type="text" name="phone" id="phone" value="<%=vo.getPhone()%>">
   		 	</div>
  		</div>
  		<div class="form-group">
    		<label for="addr" class="col-sm-3 control-label">주소</label>
    		<div class="col-sm-9">
      				<input  class="form-control" type="text" name="addr" id="addr" value="<%=vo.getAddr()%>">
   		 	</div>
  		</div>
  		<center><input class="btn btn-primary" id="cmemberModifyButton" type="button" value="수정" ></center>
	</form>



	

<!-- main end -->
	</div>
</div>
<%@ include file="/footer.jsp" %>