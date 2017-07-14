<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!-- Attribute start -->
<%@ page import="java.util.*" %>
<%@ page import="service.MemberVo" %>
<%
	ArrayList<MemberVo> alist = (ArrayList<MemberVo>) request.getAttribute("alist"); 
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
    $('#cmemberWriteActionButton').click(function(){
        if($('#nick').val().length <1) { 
            alert('닉네임을 '); 
            $('#name').focus(); 
        } else if($('#addr').val()=='') {
            alert('주소를 입력하세요.');
            $('#addr').focus();
        } else if(confirm("메모를 작성하시겠습니까?")){
        	$('#cmemberWriteAction').submit();
    	} else {
    		return false;
    	}
    });
});
</script>
	<form id="cmemberWriteAction" name="cmemberWriteAction" class="form-horizontal cmemberWriteAction" 	action="<%=request.getContextPath()%>/CMemberMemoWrite_Action.do" method="post" >	
<%
	for(MemberVo vo : alist){
%>    	 	
  		<div class="form-group">
   	 		<label for="nick" class="col-sm-3 control-label">받는 사람</label>
    		<div class="col-sm-9">
      			<select multiple class="form-control" name="nick" id="nick">
      				<option value="<%=vo.getIdx()%>"><%=vo.getNick()%></option>
      			</select>
   			</div>
 		</div>
 		<div class="form-group">
   	 		<label for="contents" class="col-sm-3 control-label">내용</label>
    		<div class="col-sm-9">
    			<textarea class="form-control" name="contents" id="contents" rows="8"></textarea>
   			</div>
 		</div>
<% } %>
		<button class="btn btn-default" type="submit" name="cmemberWriteActionButton" id="cmemberWriteActionButton">제출</button>
 	</form>


	

<!-- main end -->
	</div>
</div>
<%@ include file="/footer.jsp" %>