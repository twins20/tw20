<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!-- Attribute start -->

<!-- Attribute end -->
<%@ include file="/header.jsp" %>
<!-- 바디	 -->
<div class="bodyWrapper clearFix">
<!-- 사이드바	 -->
<%@ include file="/sideBar/boardSideBar.jsp" %>
	<div class="bodyMain"> 
<!-- main start -->
 <style>
 .form-group{
 	width:700px;
 }
 </style>
<script>

$(document).ready(function(){

    $('#addButton').click(function(){ 
        if($('#cate').val().length <1) {
            alert('카테고리를입력해주세요'); 
            $('#cate').focus(); 
        } else if($('#title').val()=='') { 
            alert('제목을입력해주세요'); 
            $('#title').focus();
        } else if($('#contents').val()=='') { 
            alert('내용을입력해주세요'); 
            $('#contents').focus();
        }
			else {
            $('#addForm').submit(); 
        }
    });
});
</script>

<div class="container">

    <h1>QNA WRITE</h1>
    <form id="addForm" action="<%=request.getContextPath()%>/IMemberIndexP.do" method="post"> 
 		<div class="form-group">
			<label for="cate">CATE</label>
			<select class="form-control" name="cate" id="cate">
				<option>회원</option>
				<option>가드닝</option>
				<option>결제</option>
			</select>
		</div>
        <div class="form-group">
            <label for="title">title :</label>
            <input class="form-control" name="title" id="title" type="text"/>
        </div>
        <div class="form-group">
            <label for="contents">contents :</label>
            <textarea class="form-control" name="contents" id="contents" rows="5" cols="50"></textarea>
        </div>

        <div>
            <input class="btn btn-default" id="addButton" type="button" value="글입력"/> 
            <input class="btn btn-default" type="reset" value="초기화"/>
            <a class="btn btn-default" href="<%=request.getContextPath()%>/IMemberIndexP.do">글목록</a>
        </div>

    </form>

</div>

<!-- main end -->
	</div>
</div>
<%@ include file="/footer.jsp" %>