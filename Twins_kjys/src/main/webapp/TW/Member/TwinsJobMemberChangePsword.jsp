<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-UTF-8">
<title>Insert title here</title>
</head>
<body>
<br>
<h1>비밀번호 변경</h1>			
												<!-- 보안을 고려하여 method 는 post로 설정  -->
<form name= "form" action="${pageContext.request.contextPath }/twins/jmChangePswordActionController" method = "post">
	
	<input type = "hidden" name = "jmidx" value="${jmv.jmidx }">

<table>
	<tr>
		<td>
			이 &nbsp; &nbsp; &nbsp; &nbsp; 름 
			<input type="text" name="jmname" value="${jmv.jmname }">
		</td>
	</tr>

	<tr>
		<td>
			아 &nbsp; 이 &nbsp; 디 
			<input type ="text" name="jmid" value="${jmv.jmid }">
		</td></tr>

	<tr>
		<td>
			새비밀번호 
			<input type ="password" name="jmpsword" value="${jmv.jmpsword }">
		</td></tr>
	<tr><td>
		</td></tr>
	<tr><td>
		</td></tr>
	<tr><td>
		</td></tr>
	<tr><td>
			<input type = "submit" value="확인"> ${msg}</td></tr>
</table>
</form>

<br>

<a href="${pageContext.request.contextPath }/twins/jmMainController${jmv.sendLoginInfo()}">메인 화면으로 가기</a>

</body>
</html>