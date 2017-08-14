<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!-- Attribute start -->
<%@ page import="java.util.*" %> 
<%@ page import="com.port.service.*" %>
<!-- Attribute end -->
<%@ include file="/WEB-INF/views/header.jsp" %>
<!-- 바디	 -->
<div class="bodyWrapper clearFix">
<!-- 사이드바	 -->
<%@ include file="/WEB-INF/views/sideBar/projectSideBar.jsp" %>
	<div class="bodyMain"> 
<!-- main start -->
<script>
$(document).ready(function(){
    $('#ProjPayButton').click(function(){
        if($('#name').val().length <1) { 
            alert('이름은 1자이상 이어야 합니다.'); 
            $('#name').focus(); 
        } else if($('#email').val()=='') {
            alert('이메일을 입력하세요.');
            $('#email').focus();
        } else if($('#phone').val()=='') {
            alert('연락처를 입력하세요.');
            $('#phone').focus();
        } else if($('#addr').val()=='') {
            alert('주소를 입력하세요.');
            $('#addr').focus();
        } else if($('#inFunds').val() > 800000) {
            alert('보유 금액 이상 사용은 불가합니다.');
            $('#inFunds').focus();
        } else if(confirm("결제하시겠습니까?")){
        	$('#ProjPay').submit();
    	} else {
    		return false;
    	}
    });
});
</script>
<style>
.pay-total-con {
	width: 879px;
	margin: 0 auto;
	padding: 0 30px;
	overflow: hidden;
	line-height: 1;
}
</style>	
<div class="pay-total-con">
	<c:url var="action" value='/ProjPay_Action.do' />
	<form id="ProjPay" class="form-horizontal ProjPay" action="${action }" method="post">
		<input class="form-control" type="hidden" name="idx" id="idx" value="${data.IDX }">
		<input class="form-control" type="hidden" name="pIdx" id="pIdx" value="${iv.pIdx }">
		<input class="form-control" type="hidden" name="itIdx" id="itIdx" value="${iv.itIdx }">
		<div class="form-group">
    		<label for="name" class="col-sm-3 control-label">성명</label>
    		<div class="col-sm-9">
    			<input class="form-control" type="text" name="name" id="name" value="${data.NAME }">
   		 	</div>
  		</div>
  		<div class="form-group">
   	 		<label for="email" class="col-sm-3 control-label">이메일</label>
    		<div class="col-sm-9">
    			<input class="form-control" type="text" name="email" id="email" value="${data.ID }">
   			</div>
 		</div>
  		<div class="form-group">
    		<label for="phone" class="col-sm-3 control-label">휴대폰 번호</label>
    		<div class="col-sm-9">
    			<input class="form-control" type="text" name="phone" id="phone" value="${data.PHONE }">
   		 	</div>
  		</div>
  		<div class="form-group">
    		<label for="addr" class="col-sm-3 control-label">주소</label>
    		<div class="col-sm-9">
      			<input class="form-control" type="text" name="addr" id="addr" value="${data.ADDR }">
   		 	</div>
  		</div>
  		<div class="form-group">
    		<label for="message" class="col-sm-3 control-label">배송메세지</label>
    		<div class="col-sm-9">
    			<input class="form-control" type="text" name="message" id="message" placeholder="배송메세지를 입력해주세요">
   		 	</div>
  		</div>
  		<div class="form-group">
    		<label for="inFunds" class="col-sm-3 control-label">충전금액</label>
    		<div class="col-sm-3">
    			<input class="form-control" type="text" name="inFunds" id="inFunds"> (사용가능 금액 : ${data.MONEY }원)
   		 	</div>
  		</div>
  		<center>
	  		<button type="button" class="btn btn-primary" id="ProjPayButton" name="ProjPayButton">
	 			결제
			</button>
		</center>
  	</form>

	 
</div>
<!-- main end -->
	</div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>