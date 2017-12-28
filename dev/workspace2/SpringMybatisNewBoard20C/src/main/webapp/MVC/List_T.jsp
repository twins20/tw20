
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

<h1>목록보기 화면입니다</h1>

<!--  
<h1>${list}</h1>
-->

<p>
 Check Line : subject = <span>${checkLineVO.subject}</span> &nbsp&nbsp&nbsp&nbsp 
author = <span>${checkLineVO.author}</span>
</p>

<!-- 
<form name="form1" action = "${pageContext.request.contextPath}/Spring/MVCWritecontroller?page=${pageMaker.cri.page}&totalPage=${pageMaker.totalPage}" method = "post">
</form>
-->


<form name="form1" action = "${pageContext.request.contextPath}/Spring/MVCListcontroller_T?page=${pageMaker.cri.page}&totalPage=${pageMaker.totalPage}" method = "post">
<select name='searchType'>
  <option value='' selected>-- 선택 --</option>
  <option value='subject'>제목</option>
  <option value='writer'>작성자</option>
</select>
<input type="text" name='keyword' id="keywordInput" value=''>
<button id='searchBtn'>검색</button>
</form>


</form>


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
	        
	        <a title="미리보기" href="${pageContext.request.contextPath}/Spring/MVCContentcontroller?Bidx=${bv.bidx}&page=${pageMaker.cri.page}">
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


     <div class="container">
      <div class="row">
        <div class="col-xs-12">
          <div class="jb-center">
            <ul class="pagination">
              
              <!--  
              <span class="glyphicon glyphicon-chevron-left"></span>
              -->
              
              <c:if test="${pageMaker.prev}">
              	<li><a href="${pageContext.request.contextPath}/Spring/MVCListcontroller_T?page=${pageMaker.startPage - 1}">&laquo;</a>
              	</li>
              </c:if>
              
              <c:forEach begin="${pageMaker.startPage}"
              	end="${pageMaker.endPage}" var="idx">
              
              		<li
              			<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>
              		>
              			<a href="${pageContext.request.contextPath}/Spring/MVCListcontroller_T?page=${idx}">${idx}</a>
              		</li>
              </c:forEach>
        
        
        	  <!-- 
        	  <span class="glyphicon glyphicon-chevron-left"></span>
        	   -->	
        
              <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
              	
              	   <!-- 
              	   <li class="disabled" ><a href="${pageContext.request.contextPath}/Spring/MVCListcontroller_T?page=${pageMaker.endPage + 1}">&raquo;</a>
              	   -->
              	   <li><a href="${pageContext.request.contextPath}/Spring/MVCListcontroller_T?page=${pageMaker.endPage + 1}">&raquo;</a>
              	
              	</li>
              </c:if>
              
            </ul>
          </div>
        </div>
      </div>
    </div>




<p class="pg"> <a href="${pageContext.request.contextPath}/Spring/MVCWritecontroller?page=${pageMaker.cri.page}&totalPage=${pageMaker.totalPage}">글쓰기</a></p>
<p>내부 절대 경로 시작 루트 = ${pageContext.request.contextPath}</p>


<!-- 
<input type="submit" value="작성">
-->




<p><a href="${pageContext.request.contextPath}/Spring/MVCWritecontroller?page=${pageMaker.cri.page}&totalPage=${pageMaker.totalPage}">
      <img src="${pageContext.request.contextPath}/resources/img/btn_write.gif">
   </a>
</p>

</body>
</html>

