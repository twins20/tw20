<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<br>
<h1>ȸ�� Ż��</h1>
<p> ${jmv.jmname}���� ȸ��Ż�� ó���� �Ͽ����ϴ�. �̿��� �ּż� �����մϴ�.</p>
<form name = "loginform" action="${pageContext.request.contextPath }/twins/jmJoinController">
			<input type = "submit" value="Ȯ��">
</form>
</body>
</html>