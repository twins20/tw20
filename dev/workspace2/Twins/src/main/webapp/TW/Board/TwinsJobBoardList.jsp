<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 
<style>
   h1 {
     font-size: 20px;
   }
   .jb-center {
     text-align: center;
   }

td.col{width:100px; height:20px; text-align:center;}
td.col2{width:150px; height:20px;}
td.coltitle{width:550px; height:20px;}

a:hover {background-color :red}
a:hover {color :orange}
</style> 
</head>

<body>

<h1>목록보기 화면입니다</h1>
<br>
${jmv.jmidx} / ${jmv.jmname}님 반갑습니다.
<br>

<input type="hidden" name='jmidx' id="jmidxInput" value='${jmv.jmidx}'>
<input type="hidden" name='jmname' id="jmnameInput" value='${jmv.jmname}'>

<form name="form1" action = "${pageContext.request.contextPath}/twins/jbListController"> 

<select name='searchType'>
  <option value=''
  	<c:out value="${scri.searchType == null?'selected':''}"/>>
  	 -- 선택 -- </option>
  <option value='jbsubject'
  	<c:out value="${scri.searchType eq 'jbsubject'?'selected':''}"/>>
  	제목</option>
  <option value='jbwriter'	
  	<c:out value="${scri.searchType eq 'jbwriter'?'selected':''}"/>>
  	작성자</option>
  <option value='jbcontent'	
  	<c:out value="${scri.searchType eq 'jbcontent'?'selected':''}"/>>
  	글내용</option>
</select>

<input type="text" name='keyword' id="keywordInput" value='${scri.keyword}'>

<button id='searchBtn'>검색</button> &nbsp;&nbsp;&nbsp;

<input type = 'radio' name='jbcategory' value='' checked='checked'> 전체게시판 &nbsp;&nbsp;&nbsp;
<input type = 'radio' name='jbcategory' value='n'> 공지사항 &nbsp;&nbsp;&nbsp;
<input type = 'radio' name='jbcategory' value='f'> 자유게시판 &nbsp;&nbsp;&nbsp;
<input type = 'radio' name='jbcategory' value='c'> 회사정보 &nbsp;&nbsp;&nbsp;
<input type = 'radio' name='jbcategory' value='r'> 취업정보 &nbsp;&nbsp;&nbsp;
<input type = 'radio' name='jbcategory' value='d'> 자료실   &nbsp;&nbsp;&nbsp;

게시판 선택후 검색

</form>

<table border=1>

<tr>
  <td class=col style="background-color:#B2EBF4;">상태 바</td>
  <td colspan=5>${m.msg}</td>
</tr>  

<tr>
  <td class=col style="background-color:#B2EBF4;">글번호</td>
  <td class=col2 style="background-color:#B2EBF4;">제목</td>
  <td class=col style="background-color:#B2EBF4;">작성자</td>
  <td class=col style="background-color:#B2EBF4;">작성일</td>
  <td class=col style="background-color:#B2EBF4;">수정일</td>
  <td class=col style="background-color:#B2EBF4;">조회수</td>
</tr>  

<c:if test="${list != null }">
  <c:forEach items="${list}" var="jbv"> 
  
    <tr>
      <td class=col style="background-color:white;">${jbv.jbidx}</td>
      <td class=coltitle style="background-color:white;">
      
        <c:forEach items="${list}" var="lr" end="${jbv.jbleftright}" varStatus="status">
      	  &nbsp;&nbsp;&nbsp;
        </c:forEach>☞
      
          <a title="내용보기" href="${pageContext.request.contextPath}/twins/jbContentController${pageMaker.bidxIdxTotalMakeSearch(pageMaker.scri.page, jbv.jbidx, jmv.jmidx, jmv.jmname)}">
                                              ${jbv.jbsubject}</a></td>
      <td class=col style="background-color:white;">${jbv.jbwriter}</td>
      <td class=col style="background-color:white;">${jbv.jbwritedate.substring(0,10)}</td>
      <td class=col style="background-color:white;">${jbv.jbmodifydate.substring(0,10)}</td>
      <td class=col style="background-color:white;">${jbv.jbreadnum}</td>
    </tr> 
    
  </c:forEach> 
</c:if>

<c:if test="${list == null }">

  <script type='text/javascript'>alert('데이터가 없습니다.\n\n처음부터 시작합니다.');	  
	window.document.location.href='${pageContext.request.contextPath}/twins/jbWriteController';</script>
	  
</c:if>     
    	
</table>


<div class="container">
 <div class="row">
   <div class="col-xs-12">
     <div class="jb-center">
       <ul class="pagination">
     
         <c:if test="${pageMaker.prev}">

		   <li><a href="${pageContext.request.contextPath}/twins/jbListController${pageMaker.idxMakeSearch(pageMaker.startPage - 1, jmv.jmidx, jmv.jmname)}">&laquo;</a>
           </li>
         </c:if>
         
         <c:forEach begin="${pageMaker.startPage}"
         	end="${pageMaker.endPage}" var="idx">
         
         		<li
         			<c:out value="${pageMaker.scri.page == idx?'class =active':''}"/>
         		>
         			<a href="${pageContext.request.contextPath}/twins/jbListController${pageMaker.idxMakeSearch(idx, jmv.jmidx, jmv.jmname)}">${idx}</a>
         		</li>
         </c:forEach>
   
         <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
         	
       	   <li><a href="${pageContext.request.contextPath}/twins/jbListController${pageMaker.idxMakeSearch(pageMaker.endPage + 1, jmv.jmidx, jmv.jmname)}">&raquo;</a>       	
           </li>
         </c:if>
          
        </ul>
      </div>
    </div>
  </div>
</div>

<p class="pg"> 
  <a href="${pageContext.request.contextPath}/twins/jbListController${pageMaker.idxSend(jmv.jmidx, jmv.jmname)}">전체목록보기</a> &nbsp;&nbsp;&nbsp;
  <a href="${pageContext.request.contextPath}/twins/jbWriteController${pageMaker.idxTotalMakeSearch(pageMaker.scri.page, jmv.jmidx, jmv.jmname)}">
      <img src="${pageContext.request.contextPath}/resources/img/btn_write.gif">
  </a>
</p>

</body>
</html>

