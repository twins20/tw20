<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="Model1.MemberDao" %>   
<%@ page import ="Model1.MemberVo" %>
<%

int idx = Integer.parseInt(request.getParameter("idx"));
MemberDao md = new MemberDao();
MemberVo mv = md.Modify(idx);

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
        $('#ModifyButton').click(function(){ // button 클릭하면 띄우는 창  # = 아이디
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
                $('#ModifyForm').submit(); // 전송 버튼 = 폼 아이디
            }
        });
    });
</script>
<title>(모델1 방식)</title>
</head>
<body>
<div class="container">

    <h1>수정하기(모델1 방식)</h1><!-- 전송하면 writeAtction.jsp로 페이지를 넘김 post방식-->
    <form id="ModifyForm" action="<%=request.getContextPath()%>/model1/ModifyAction.jsp" method="post">
    <div class="form-group">
    <label for="idx">idx : <%=idx %></label>
    <input class="form-control" name="idx" id="idx" type="hidden" value="<%=idx %>"/>
    </div>
        <div class="form-group">
            <label for="name">name :</label>
            <input class="form-control" name="name" id="name" type="text" value="<%=mv.getName() %>"/>
        </div>
        <div class="form-group">
            <label for="age">age :</label>
            <input class="form-control" name="age" id="age" type="text" value="<%=mv.getAge() %>" />
        </div>
        <div class="form-group">
            <label for="sex">sex :</label>
            <textarea class="form-control" name="sex" id="sex" rows="5" cols="50"><%=mv.getSex() %></textarea>
        </div>											<!-- textarea는 값 안에 넣는게 아니고 값 밖에 넣어줘야 한다 -->
        <div class="form-group">
            <label for="area">area :</label>
            <input class="form-control" name="area" id="area" type="text" value="<%=mv.getArea() %>"/>
        </div>
        <div>
            <input class="btn btn-default" id="ModifyButton" type="button" value="글입력"/> <!-- 버튼 생성 -->
            <input class="btn btn-default" type="reset" value="초기화"/>
            <a class="btn btn-default" href="<%=request.getContextPath()%>/model1/List.jsp">글목록</a>
        </div>
    </form>
</div>
</body>
</html>