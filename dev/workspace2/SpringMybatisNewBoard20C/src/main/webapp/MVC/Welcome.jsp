<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  
<%//@ page import="java.util.ArrayList"%>
<%//@ page import="MVC.serviceimpl.*" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap_css_4.0.0/bootstrap.min.css" -->
<title>Insert title here</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous"-->
<!--  script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script -->

   <style>
      h1 {
        font-size: 20px;
      }
      .jb-center {
        text-align: center;
      }
    </style>


<style>

td.col{width:100px; height:20px; text-align:center;}
td.col2{width:150px; height:20px;}
td.coltitle{width:550px; height:20px;}

a:hover {background-color :red}
a:hover {color :orange}

</style>

<script type="text/javascript">

</script>
    
</head>

<body>

<br>
<h1>로그인 성공입니다</h1>

<h1>${mv.idx} / ${mv.name}님 반갑습니다</h1>

<h1>${result}</h1>

<h1>${m.msg}</h1>
<br>
<br>
<!--  
 <c:if test="${!empty mv.name}">
 	<c:set var = "namehere" value = "${URLEncoder.encoding(mv.name, 'utf-8')}" /> 	
 </c:if>

<a href="${pageContext.request.contextPath}/Spring/MVCListcontroller_TS?name=${namehere}&idxs=${mv.idx}">/Spring/MVCListcontroller_TS로 가기</a><br>
-->

<a href="${pageContext.request.contextPath}/Spring/MVCListcontroller_TS${mv.sendLoginInfo(mv.idx, mv.name)}">/Spring/MVCListcontroller_TS로 가기</a><br>
<br>
-----------------------------------------------------------------------------------------------------------
<br>
<br>
<a href="${pageContext.request.contextPath}/Spring/MVCWritecontroller${mv.sendLoginInfo(mv.idx, mv.name)}">/Spring/MVCWritecontroller로 가기</a><br>
<br>
<a href="${pageContext.request.contextPath}/Spring/MVCContentcontroller${mv.sendLoginInfo(mv.idx, mv.name)}">/Spring/MVCContentcontroller로 가기</a><br>
<br>
<a href="${pageContext.request.contextPath}/Spring/MVCModifycontroller${mv.sendLoginInfo(mv.idx, mv.name)}">/Spring/MVCModifycontroller로 가기</a><br>
<br>
<a href="${pageContext.request.contextPath}/Spring/MVCReplycontroller${mv.sendLoginInfo(mv.idx, mv.name)}">/Spring/MVCReplycontroller로 가기</a><br>
<br>
<a href="${pageContext.request.contextPath}/Spring/MVCReply_Actioncontroller${mv.sendLoginInfo(mv.idx, mv.name)}">/Spring/MVCReply_Actioncontroller로 가기</a><br>
<br>
<a href="${pageContext.request.contextPath}/Spring/MVCModify_Actioncontroller${mv.sendLoginInfo(mv.idx, mv.name)}">/Spring/MVCModify_Actioncontroller로 가기</a><br>
<br>
<a href="${pageContext.request.contextPath}/Spring/MVCWrite_Actioncontroller${mv.sendLoginInfo(mv.idx, mv.name)}">/Spring/MVCWrite_Actioncontroller로 가기</a><br>
<br>
<a href="${pageContext.request.contextPath}/Spring/MVCDelete_Actioncontroller${mv.sendLoginInfo(mv.idx, mv.name)}">/Spring/MVCDelete_Actioncontroller로 가기</a><br>
  
</body>
</html>

