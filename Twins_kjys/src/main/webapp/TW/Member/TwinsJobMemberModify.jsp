<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<br>
<h1>내 정보 수정</h1>
<form name="mdform" action="${pageContext.request.contextPath }/twins/jmModifyActionController">
<input type ="hidden" name = "jmidx" value="${jmidx }">
<table>
	<tr>
	
		<td>이 &nbsp; &nbsp;&nbsp;&nbsp;름
			<input type = "text"  name="jmname" value="${jmv.jmname}"></td></tr>
	<tr>
		<td>아 &nbsp;이&nbsp;디
			<input type = "text" name="jmid" value="${jmv.jmid}"></td></tr>
	<tr>
		<td>비밀번호
			<input type = "password" name="jmpsword" value ="${jmv.jmpsword}"></td>
		<td>&nbsp;
			<input type = "button" name="jmpsword" value = "비밀번호수정" onclick="javascript:document.location.href='${pageContext.request.contextPath }/twins/jmChangePswordController?jmidx='+${jmv.jmidx}"></td></tr>
	<tr>
		<td>주 &nbsp;  &nbsp;&nbsp;&nbsp;소
			<input type = "text" name="jmaddr" value ="${jmv.jmaddr}"></td></tr>
	<tr>
		<td>이&nbsp;메&nbsp;&nbsp;일
			<input type = "text" name="jmemail" value ="${jmv.jmemail}"></td></tr>
	<tr>
		<td>
			</td></tr>
	<tr>
		<td>
			</td></tr>
	<tr>
		<td>
			</td></tr>
						
</table>

<input type="submit" value="확인">

</form>

<br>

<a href="${pageContext.request.contextPath }/twins/jmMainController${jmv.sendLoginInfo()}">메인 화면으로 가기</a>

</body>
</html>