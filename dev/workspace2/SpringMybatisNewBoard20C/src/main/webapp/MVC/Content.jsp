<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%//@ page import="com.my.smnb20_2.service.*" %>

 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>
table.mytable{width:1000px; height:480px;}
td.narrow {width:50px; height:20px; text-align:center; background-color:#B2EBF4;}
td.col1 {width:100px; height:20px; text-align:center; background-color:#B2EBF4;}
td.title {width:350px; height:20px;}
td.short {height:20px}
td.aligncenter {width:100px; text-align:center; background-color:#B2EBF4;}
td.col2 {width:100px;text-align:center;}

</style>

<script type="text/javascript">

 function DeleteYN(){
	 	 
	 var rep = confirm("정말 삭제하시겠습니까?");
	 
	 	 
	 if (rep == true) {

	//	 alert("삭제 진행합니다.")
		 window.document.location.href=
			 '${pageContext.request.contextPath}/Spring/MVCDelete_Actioncontroller${pageMaker.bidxIdxMakeSearch(page, bv.bidx, mv.idx, mv.name)}';

	 } else {
		 alert("삭제가 취소되었습니다.")
	 }
	  
 }

</script>

</head>
<body>

totalPage = ${totalPage}<br>
pageMaker.totalPage = ${pageMaker.totalPage}

<p>pageMaker.scri.searchType = ${pageMaker.scri.searchType}</p> 
<p>pageMaker.scri.keyword = ${scri.keyword}</p> 
<p>${mv.idx}/${mv.name}님 반갑습니다.</p> 

<h1>  내용보기 화면입니다. </h1>

<input type="hidden" name="searchType" value="${pageMaker.scri.searchType}">
<input type="hidden" name="keyword" value="${pageMaker.scri.keyword}">

<input type="hidden" name="originbidx" value="${bv.originbidx}">
<input type="hidden" name="updown" value="${bv.updown}">
<input type="hidden" name="leftright" value="${bv.leftright}">

<c:if test="${bv == null }">
	<script type='text/javascript'>alert('처음부터 시작하세요.');</script>
	<script type='text/javascript'>	
	    window.document.location.href='${pageContext.request.contextPath}/Spring/MVCListcontroller_TS${mv.sendLoginInfo(mv.idx, mv.name)}';</script>
</c:if>	   



<!--  // 이 부분은 bd.getContent()함수가 query 실패시 bv.bidx에 0을 담아서 보내기 때문임  -->
<c:if test="${bv.bidx == 0 }">
   <script type='text/javascript'>alert('데이터를 가져오지 못했습니다.\n\n다시 시도하세요.');</script>
   <script type='text/javascript'>	
	    window.document.location.href='${pageContext.request.contextPath}/Spring/MVCListcontroller_TS${pageMaker.idxMakeSearch(page, mv.idx, mv.name)}';</script>
</c:if>


<!--  // 이 부분은 UpdateDB()함수가 query 실패시 RRDS에 0을 isUpdate에 "Yes"를 담아서 보내기 때문임  -->

<!-- 아래 부분은 sendRedirect나 forward 방식에서는 효과가 없으므로 주석처리함 

<c:if test="${RRDS == 0 && isUpdate == 'Yes'}">
	<script type='text/javascript'>alert('데이터 수정에 실패했습니다.\n\n다시 시도하세요.);</script>
</c:if>

<c:if test="${RRDS == 1 && isUpdate == 'Yes'}">
	<script type='text/javascript'>alert('수정하여 저장하였습니다.');</script>
</c:if>

<c:if test="${RRDS == 0 && isDelete == 'Yes'}">
	<script type='text/javascript'>alert('데이터 삭제에 실패하였습니다.);</script>  
</c:if>
-->



<!-- 

 // 이 부분은 ReplyInsertDB()함수가 query 실패시 RRDS에 0을 isReply에 "Yes"를 담아서 보내기 때문임  
<c:if test="${RRDS == 0 && isReply == 'Yes'}">
	<script type='text/javascript'>alert('답글 달기에 실패했습니다.\n\n다시 시도하세요.);</script>
</c:if>

<c:if test="${RRDS == 1 && isReply == 'Yes'}">
	<script type='text/javascript'>alert('답글을 저장하였습니다.');</script>
</c:if>

-->

<table border=1 class="mytable">

		<tr>
		  <td class=col1>상태 바</td>
		  <td colspan=9>${m.msg}</td>
		</tr>

        <tr>
         <td class="col1">번호</td><td class="col2" align="center">${bv.bidx}</td>
         <td class="narrow">제목</td><td class="title">${bv.subject}</td>
         <td class="narrow">작성자</td><td class="col2">${bv.writer}</td>
         <td class="narrow">등록일</td><td class="col2">${bv.writedate}</td> 
         <td class="narrow">수정일</td><td class="col2">${bv.modifydate}</td> 
        </tr>

        <tr>
         <td class="aligncenter">내용</td><td colspan=9>${bv.content}</td>
        </tr>

       </table>

        <p class="short" align=center>
          <input type="button" name="modify" value="수정" onclick="location.href='${pageContext.request.contextPath}/Spring/MVCModifycontroller${pageMaker.bidxIdxMakeSearch(page, bv.bidx, mv.idx, mv.name)}'">
          <input type="button" name="delete" value="삭제" onclick="DeleteYN();">
          
          <!--  
          <input type="button" name="list" value="목록" onclick="location.href='${pageContext.request.contextPath}/Spring/MVCListcontroller_TS?page=${page}&searchType=${scri.searchType}&keyword=${scri.keyword}'">
          -->
          
         
          <c:if test="${m.rrds == '1' && m.isUpdate == 'Yes'}"> 
          	<input type="button" name="list" value="목록1" onclick="location.href='${pageContext.request.contextPath}/Spring/MVCListcontroller_R_TS${pageMaker.bidxIdxMakeSearch(page, bv.bidx, mv.idx, mv.name)}'">
          </c:if>
     
          
          <c:if test="${ ! (m.rrds == '1' && m.isUpdate == 'Yes') }">
          <input type="button" name="list" value="목록0" onclick="location.href='${pageContext.request.contextPath}/Spring/MVCListcontroller_TS${pageMaker.idxMakeSearch(page, mv.idx, mv.name)}'">
          </c:if>
          
          <input type="button" name="reply" value="답글쓰기" onclick="location.href='${pageContext.request.contextPath}/Spring/MVCReplycontroller${pageMaker.bidxIdxTotalMakeSearch(page, bv.bidx, mv.idx, mv.name)}'">
         </p>

</body>
</html>

