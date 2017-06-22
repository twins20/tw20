<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="UTF-8"%>  
<%@ page import ="Model1.MemberDao" %>   
<%@ page import ="Model1.MemberVo" %>
<%

int idx = Integer.parseInt(request.getParameter("idx"));
MemberDao md = new MemberDao(); // data access object
MemberVo mv = md.getMember(idx); // value object

%>    
 <!-- 조회 결과 내용 출력 페이지 -->
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글목록</title>
<!-- bootstrap을 사용하기 위한 CDN주소 -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script>
	function de(){ // function = 함수
		if(confirm("삭제 하시겠습니까?")){ // confirm = 경고창
        	location.href="<%=request.getContextPath()%>/model1/DeleteAction.jsp?idx=<%=idx %>";
        	}else{
        		alert("삭제되지 않았습니다.");
        	}
		}
</script>
</head>
<body>
<div class="container"> <!-- div로 묶음 -->

<table class="table table-striped table-bordered table-hover ">
<tr>
<td>성별</td><td>지역</td> <!-- 테이블 생성 -->
</tr>
<tr>
<td><%=mv.getSex() %></td><td><%=mv.getArea() %></td>
</tr>
</table>
<!-- div class = "form group" -->
<!-- label for="sex" sex : /label -->
<!-- %mv.getSex()% /div -->

<!-- div class = "form group" -->
<!-- label for="area" area : /label -->
<!-- %mv.getArea()% /div -->
<div>
  <input class="btn btn-default" id="addButton" type="button" value="글입력"/>
  <a class="btn btn-default" href="<%=request.getContextPath()%>/model1/Modify.jsp?idx=<%=idx %>">수정</a> <!--idx 값을 못 불러오니까 getidx였지만 설정을 안해둬서 그냥 idx 값을 불러와서 실행 -->
  <input class="btn btn-default" id="DeleteButton" type="button" value="삭제" onclick="de()"/>
  </form>
 </div>
 </div>
 </body>
</html>