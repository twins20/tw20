<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form name= "form" action="${pageContext.request.contextPath }/twins/jmChangePswordActionController">
<input type = "hidden" name = "jmidx" value="${jmidx }">

<table>
<tr>
<td>
�̸�<input type="text" name="jmname" value="${jmv.jmname }">
</td>
</tr>

<tr>
<td>
���̵�<input type ="text" name="jmid" value="${jmv.jmid }">
</td></tr>

<tr>
<td>
����й�ȣ<input type ="password" name="jmpsword" value="${jmv.jmpsword }">
</td></tr>
<tr><td>
<input type = "submit" value="Ȯ��"></td></tr>
</table>
</form>
</body>
</html>