
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  
<%//@ page import="java.util.ArrayList"%>
<%//@ page import="MVC.serviceimpl.*" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

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

<h1>목록보기 화면입니다</h1>

<!--  
<h1>${list}</h1>
-->

<p>
 Check Line : subject = <span>${checkLineVO.subject}</span> &nbsp&nbsp&nbsp&nbsp 
author = <span>${checkLineVO.author}</span>
</p>

<form name="form1" action = "${pageContext.request.contextPath}/Spring/MVCWritecontroller" method = "post">

<table border=1>

<tr>
  <td class=col style="background-color:#B2EBF4;">상태 바</td>
  <td colspan=4>${msg}</td>
</tr>  

<tr>
  <td class=col style="background-color:#B2EBF4;">글번호</td>
  <td class=col2 style="background-color:#B2EBF4;">제목</td>
  <td class=col style="background-color:#B2EBF4;">작성자</td>
  <td class=col style="background-color:#B2EBF4;">날짜</td>
  <td class=col style="background-color:#B2EBF4;">회원번호</td>
</tr>  

<tr>  
<td class=col>점검라인</td>
<td class="coltitle">${subject}</td>
<td class=col>${author}</td>
<td class=col>RRDS=${RRDS}</td> 
<td class=col>RRDS=${RRDS}</td>
</tr>
  
     <c:if test="${list != null }">
	     <c:forEach items="${list}" var="bv"> 
	    
	     <tr>
	        <td class=col style="background-color:white;">${bv.bidx}</td>
	        <td class=coltitle style="background-color:white;">
	        
	        <c:forEach items="${list}" var="lr" end="${bv.leftright}" varStatus="status">
	        	&nbsp;&nbsp;&nbsp;
			</c:forEach>☞
	        
	        <a title="미리보기" href="${pageContext.request.contextPath}/Spring/MVCContentcontroller?Bidx=${bv.bidx}">
	                                                ${bv.subject}</a></td>
	        <td class=col style="background-color:white;">${bv.writer}</td>
	        <td class=col style="background-color:white;">${bv.writedate.substring(0,10)}</td>
	        <td class=col style="background-color:white;">${bv.idx}</td>
	      </tr> 
	      
	      </c:forEach> 
	  </c:if>
	  
	  <c:if test="${list == null }">
	  
		  <script type='text/javascript'>alert('데이터가 없습니다.\n\n처음부터 시작합니다.');	  
	  	  window.document.location.href='${pageContext.request.contextPath}/Spring/MVCWritecontroller';</script>
	  	  
	  </c:if>     
	  
	  
	  
	  
      <!-- Query가 성공하면 RRDS = 1 반납    --> 
      
      <!-- 아래 부분은 sendRedirect나 forward 방식에서는 효과가 없으므로 주석처리함 
      
	  <c:if test="${RRDS == 1 && isWrite == 'Yes'}"> 
		  <script type='text/javascript'>alert('작성된 글이 저장되었습니다.');</script> 	  
	  </c:if>   

	  <c:if test="${RRDS == 1 && isReply == 'Yes'}">	  
		  <script type='text/javascript'>alert('작성된 답글이 저장되었습니다.');</script> 	  
	  </c:if>   
	
	  <c:if test="${RRDS == 1 && isDelete == 'Yes'}">  
		  <script type='text/javascript'>alert('삭제 하였습니다.');</script> 	  
	  </c:if>   	
	
	  -->
	  
    	
</table>

<p class="pg"> <a href="${pageContext.request.contextPath}/Spring/MVCWritecontroller">글쓰기</a></p>
<p>내부 절대 경로 시작 루트 = ${pageContext.request.contextPath}</p>

<input type="submit" value="작성">

</form>

<p><a href="${pageContext.request.contextPath}/Spring/MVCWritecontroller">
      <img src="${pageContext.request.contextPath}/resources/img/btn_write.gif">
   </a>
</p>

</body>
</html>

