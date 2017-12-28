<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />

<title>Insert title here</title>

<style>

td.col1{background-color :#B2EBF4}  // col1으로 지정된 부분의 배경색을 스타일로 지정하는 부분입니다

</style>


<script  type="text/javascript">
  
// 공백이 입력되면 체크 하는 함수 입니다
function check() {
	
	var form1208 = document.form1;
	if (form1208.id.value == "") {
		alert ('아이디를 입력하세요.');
		form1103.id.focus();
		return false;
	}else if (form1208.password.value == "") {
		alert ('비밀번호를 입력하세요.');
		form1208.password.focus();
		return false;
	}
	
	form1208.method="post";    /* 파라메터를를 주고 받을때 보이지 않게 주고 받는 방식으로 설정  */ 
	form1208.action="${pageContext.request.contextPath}/Spring/MVCMemberLoginCheck";  // submit 버튼이 눌렸을 때 이동할 페이지 지정
	form1208.submit(); // submit 버튼이 눌린 효과를 발생시킴
    return;
}

</script>


</head>
<body>


<h1>로그인 화면입니다</h1>

<form name="form1">
<table>

<tr>
<td class='col1'>아이디   :
</td>
<td><input type="text" name="id" size="20" value=${mv.id}>
</td>
</tr>

<tr>
<td class='col1'>비밀번호:
</td>
<td><input type="password" name="password" size="20" value=${mv.password}>
</td>
</tr>

<tr>
<td colspan="2">
<input type="button" name="button" value="확인" onclick="check(); ">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="reset" name="reset" value="취소">
</td>
</tr>

</table>
</form>

<br>
<br>
msg : ${m.msg}
<br>
<br>
<a href="${pageContext.request.contextPath}/Spring/MVCListcontroller_TS">/Spring/MVCListcontroller_TS로 가기</a><br>
<br>
<a href="${pageContext.request.contextPath}/Spring/MVCWritecontroller">/Spring/MVCWritecontroller로 가기</a><br>
<br>
<a href="${pageContext.request.contextPath}/Spring/MVCContentcontroller">/Spring/MVCContentcontroller로 가기</a><br>
<br>
<a href="${pageContext.request.contextPath}/Spring/MVCModifycontroller">/Spring/MVCModifycontroller로 가기</a><br>
<br>
<a href="${pageContext.request.contextPath}/Spring/MVCReplycontroller">/Spring/MVCReplycontroller로 가기</a><br>
<br>
<a href="${pageContext.request.contextPath}/Spring/MVCReply_Actioncontroller">/Spring/MVCReply_Actioncontroller로 가기</a><br>
<br>
<a href="${pageContext.request.contextPath}/Spring/MVCModify_Actioncontroller">/Spring/MVCModify_Actioncontroller로 가기</a><br>
<br>
<a href="${pageContext.request.contextPath}/Spring/MVCWrite_Actioncontroller">/Spring/MVCWrite_Actioncontroller로 가기</a><br>
<br>
<a href="${pageContext.request.contextPath}/Spring/MVCDelete_Actioncontroller">/Spring/MVCDelete_Actioncontroller로 가기</a><br>
   
</body>
</html>

