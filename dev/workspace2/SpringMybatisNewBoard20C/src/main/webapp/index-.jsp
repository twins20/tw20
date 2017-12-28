<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF=-8">
<title>Insert title here</title>
</head>
<body>

<a href="${pageContext.request.contextPath}/MVCListcontroller">게시판 목록 가기</a><br>
<a href="${pageContext.request.contextPath}/MVCContentcontroller">게시판 1번 내용 보기</a><br>
<a href="${pageContext.request.contextPath}/MVCWritecontroller">글쓰기로 가기</a><br>
<a href="${pageContext.request.contextPath}/MVCModifycontroller">첫글 수정으로 바로 가기</a><br>
<a href="${pageContext.request.contextPath}/MVCReplycontroller">1번글에 대한 답글 쓰기로 바로 가기</a><br>


<br><br>
<a href="${pageContext.request.contextPath}/MVCWrite_Actioncontroller">Write_Action 으로 바로가기를 선택한다면 ?</a><br>
<a href="${pageContext.request.contextPath}/MVCModify_Actioncontroller">Modify_Action 으로 바로가기를 선택한다면 ?</a><br>
<a href="${pageContext.request.contextPath}/MVCDelete_Actioncontroller">Delete_Action 으로 바로가기를 선택한다면 ?</a><br>
<a href="${pageContext.request.contextPath}/MVCReply_Actioncontroller">Reply_Action 으로 바로가기를 선택한다면 ?</a><br>


<br><br>
<a href="${pageContext.request.contextPath}/Spring/MVCListcontroller">/Spring/MVCListcontroller로 가기</a><br>

<br><br>
<a href="${pageContext.request.contextPath}/Spring/MVCContentcontroller?Bidx=1">/Spring MYbatis Content로 가기</a><br>

<br><br>
<a href="${pageContext.request.contextPath}/Spring/MVCListcontroller_T">/Spring/MVCListcontroller_T로 가기</a><br>

<br><br>
<a href="${pageContext.request.contextPath}/Spring/MVCListcontroller_TS">/Spring/MVCListcontroller_TS로 가기</a><br>


</body>
</html>
