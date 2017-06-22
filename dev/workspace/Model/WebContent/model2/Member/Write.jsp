<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- bootstrap을 사용하기 위한 CDN주소 -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
 
<!-- jquery를 사용하기위한 CDN주소 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
 
<!-- bootstrap javascript소스를 사용하기 위한 CDN주소 -->
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
 
 <!-- 내용 작성하는 페이지-->
 
<script>
    $(document).ready(function(){
    //    alert('jquery test');
    /* 입력폼 유효성 관련 요구사항
        1. 모든 폼은 공백 또는 "" 문자는 입력되면 안된다.
        2. 비밀번호는 4자이상 입력하여야 한다.
    */
        $('#addButton').click(function(){ // button 클릭하면 띄우는 창
            if($('#name').val().length <1) { // val = value // # = id와 같음 
                alert('이름은 1자이상 이어야 합니다'); // 이름 입력 안했을 시 출력
                $('#name').focus(); //  입력 초점 name 으로 (다른 것도 마찬가지)
            } else if($('#age').val()=='') { // 이름은 입력했는데 age 입력 안하면
                alert('나이를 입력하세요'); // 나이를 입력하세요 출력, ''입력하면 안돼므로 ==를 통해 차단
                $('#age').focus();
            } else if($('#sex').val()=='') {
                alert('성별을 입력하세요');
                $('#sex').focus();
            } else if($('#area').val()=='') {
                alert('지역을 입력하세요');
                $('#area').focus();
            } else {
                $('#addForm').submit(); // 전송 버튼
            }
        });
    });
</script>
<title>(모델2 방식)</title>
</head>
<body>
<div class="container">
    <h1>글쓰기(모델2 방식)</h1>
    <form id="addForm" action="<%=request.getContextPath()%>/Controller/WriteActionServlet.do" method="post"> <!-- div로 묶음 -->
    <!-- 전송하면 WriteAtction.do WriteActionServlet가 실행되고 WriteAction.do는 가짜 페이지 post방식-->
        <div class="form-group">
            <label for="name">name :</label>
            <input class="form-control" name="name" id="name" type="text"/>
        </div>
        <div class="form-group">
            <label for="age">age :</label>
            <input class="form-control" name="age" id="age" type="text"/>
        </div>
        <div class="form-group">
            <label for="sex">sex :</label>
            <textarea class="form-control" name="sex" id="sex" rows="5" cols="50"></textarea>
        </div>
        <div class="form-group">
            <label for="area">area :</label>
            <input class="form-control" name="area" id="area" type="text"/>
        </div>
        <div>
            <input class="btn btn-default" id="addButton" type="button" value="글입력"/> <!-- 버튼 생성 -->
            <input class="btn btn-default" type="reset" value="초기화"/>
            <a class="btn btn-default" href="<%=request.getContextPath()%>/Controller/ListServlet.do">글목록</a>
        </div>
    </form>
</div>
</body>
</html>
