<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<body>
<form name = "getform" action="${pageContext.request.contextPath }/twins/jmGetIDController">
<table>
<tr>
<td>
<input type = "text" name="jmname">이름
</td>
</tr>
<tr>
<td>
<input type ="text" name="jmemail">이메일
</td>
</tr>
<tr>
<td>
</td>
</tr>

</table>
<input type ="submit" name ="submit" value="버튼">
</form>

</body>
</html>