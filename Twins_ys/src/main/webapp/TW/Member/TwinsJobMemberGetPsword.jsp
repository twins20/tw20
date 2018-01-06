<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name = "form" action="${pageContext.request.contextPath }/twins/jmGetPswordController">
<table>
<tr>
<td><input type="text" name="jmid">아이디</td>
</tr>
<tr>


<td><input type= "text" name = "jmemail">이메일</td>
</tr>
<tr>
<td><input type = "submit" value="확인"></td>
</tr>

</table>
</form>
</body>
</html>