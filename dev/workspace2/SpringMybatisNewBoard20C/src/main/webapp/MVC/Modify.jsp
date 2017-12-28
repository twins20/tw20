<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%//@ page import="MVC.serviceimpl.*" %>

<html>
<head>

<style> 

table.table{width:800px;}

td.col1{width:100px; background-color:#B2EBF4; text-align:center}
td.col2{width:500px;}
td.bottom{text-align:center;}

input.title{size:100; width:500px}
input.content{size:1000;width:500px}
input.writer{size:20;width:500px}

</style>

<script type="text/javascript">


function checkLength(f,n){
	
	var limit = n;
	var StrLen =f.value.length;
	if(StrLen > limit)
	{
		alert("내용은 "+limit+"자 까지만 입력이 가능합니다.");
		f.value=f.value.substring(0,limit);
		f.focus();
	}
	if ( f.name == "subject") {
		document.getElementById("NoteLen1").innerHTML = f.value.length;
	} else if ( f.name == "content") {
		document.getElementById("NoteLen2").innerHTML = f.value.length;
	} else if (f.name == "writer") {
		document.getElementById("NoteLen3").innerHTML = f.value.length;
	}
	
//	document.getElementById("NoteLen").innerHTML = f.value.length;
	}

function check() {
	
	var form0922 = document.form1;
	if (form0922.subject.value == "") {
		alert ('제목을 입력하세요.');
		form0922.subject.focus();
		return false;
	}else if (form0922.content.value == "") {
		
//		document.getElementById("lblName").innerHTML = form0922.subject.value;
		
		alert ('내용을 입력하세요.');
		form0922.content.focus();
		return false;
	}else if (form0922.writer.value == ""){
		alert ('작성자를 입력하세요.');
		form0922.writer.focus();
		return false;
		}
	form0922.method="post";
    form0922.action="${pageContext.request.contextPath}/Spring/MVCModify_Actioncontroller${pageMaker.idxMakeSearch(page, mv.idx, mv.name)}";
    form0922.submit();
    return;
}

</script>

</head>
<body>

<c:if test="${bv == null}">
    <script type='text/javascript'>alert('수정할 항목을 선택하십시요.');</script>
	<script type='text/javascript'>
	    window.document.location.href='${pageContext.request.contextPath}/Spring/MVCListcontroller_TS${pageMaker.idxMakeSearch(page, mv.idx, mv.name)}';
	</script>

</c:if>

<h1>  수정화면입니다. </h1>


<p>scri.searchType = ${scri.searchType}</p> 
<p>scri.keyword = ${scri.keyword}</p> 

<p>${mv.idx}/${mv.name}님 반갑습니다.</p> 


<form name="form1">

<table class=table border=1>

<tr>
  <td class=col1>상태 바</td>
  <td class=col2>${m.msg}</td>
</tr>

<tr>
  <td class=col1>글번호</td>
  <td class=col2>${bv.bidx}</td>
</tr>

<tr>
<!-- 
  <td class=col1>제목</td>
  <td class=col2><input class=title type="text" name="subject" value="${bv.subject}">
  <label for = "subject" id ="lblName"></label>
  </td>
-->  
  <td class=col1>제목</td>
  <td class=col2><textarea class=title name="subject" cols = 50 rows=1 
  						   onkeyup="checkLength(this,33)">${bv.subject}</textarea>
                 <strong id="NoteLen1">0</strong>/33자
                 <label for = "subject" id ="lblName"></label>
   </td> 
</tr>

<tr>
  <td class=col1>내용&nbsp;&nbsp;&nbsp;&nbsp;</td> 
    <td class=col2><textarea class=content name="content" cols=70 rows=10
                             onkeyup="checkLength(this,500)">${bv.content}</textarea>
                   <strong id="NoteLen2">0</strong>/500자
  </td>
</tr>

<tr>
<!-- 
  <td class=col1>작성자</td>
  <td class=col2><input class=writer type="text" name="writer" value="${bv.writer}">
  </td>
--> 
  <td class=col1>작성자</td>
  <td class=col2><textarea class=writer name="writer" cols = 30 rows=1 
  						   onkeyup="checkLength(this,6)">${bv.writer}</textarea>
                 <strong id="NoteLen3">0</strong>/6자
  </td>  
</tr>

<tr>
  <td class=bottom colspan=2>
  
   <input type="button" value="저장" onclick="check();"> 
   <input type="button" value="목록" onclick="location.href='${pageContext.request.contextPath}/Spring/MVCListcontroller_TS${pageMaker.idxMakeSearch(page, mv.idx, mv.name)}'"> 
   <input type="button" value="새로고침" onclick="javascript:window.location.reload(true);">
   <input type="button" value="리셋" onclick="javascript:reset();">
   <input type="hidden" name="idx" value="1">
   <input type="hidden" name="bidx" value="${bv.bidx}">

  </td>
</tr>

</table>
</form>
</body>
</html>


