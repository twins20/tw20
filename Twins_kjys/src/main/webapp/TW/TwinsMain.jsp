<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function dropChk(){
		alert("탈퇴하시겠습니까?")
        document.dropform.submit();
	}
</script>

</head>
<body>
<br>
<!-- 이름만 나타내기...나중에....마지막에 뷰단들어갈때 작업하기... -->
<h1>${jmv.jmid } / ${jmv.jmidx } / ${jmv.jmname }님을 환영합니다.</h1>
${msg}
<br>
<br>
<form name ="dropform" action="${pageContext.request.contextPath}/twins/jmDropController">
			<input type ="hidden" name = "jmidx" value = "${jmv.jmidx}">
			<input type ="hidden" name = "jmid" value = "${jmv.jmid}">
			<input type ="hidden" name = "jmname" value = "${jmv.jmname}">
			<input type ="button"  onclick="dropChk();" value="회원탈퇴"> 
</form>
<br>
<form name = "mdform" action="${pageContext.request.contextPath}/twins/jmModifyController">
			<input type ="hidden" name = "jmidx" value = "${jmv.jmidx}">
			<input type ="submit" value = "내 정보 수정">
</form>
<br>
<form name = "outform" action="${pageContext.request.contextPath}/twins/jmLoginOutController">
			<input type ="submit" value="로그아웃">
</form>
<br>
<a href="${pageContext.request.contextPath}/twins/jbListController">/twins/jbListController로 가기</a><br>
<br>
<a href="${pageContext.request.contextPath}/twins/jbListController${jmv.sendLoginInfo()}">/twins/jbListController로 가기(로그인 정보 가지고)</a><br>
<br>

</body>
</html>