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
		 window.name = "parentForm";
         window.open("/TW/Member/TwinsJobMemberDrop.jsp","dropform", "width=500, height=300, resizable = no, scrollbars = no");
	}
</script>

</head>
<body>
<h1>${jmid }님을 환영합니다.</h1>
<form name ="dropform" action="${pageContext.request.contextPath }/twins/jmDropController">
<input type ="submit" value="회원탈퇴">
</form>
<form name = "mdform" action="${pageContext.request.contextPath }/twins/jmModifyController">
<input type ="hidden" name = "jmidx" value = "${jmv.jmidx }">
<input type ="submit" value = "내정보 수정">
</form>
</body>
</html>