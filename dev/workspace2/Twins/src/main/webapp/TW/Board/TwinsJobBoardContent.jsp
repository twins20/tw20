<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

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
		 
		 window.document.location.href=
			 '${pageContext.request.contextPath}/twins/jbDeleteActionController${pageMaker.bidxIdxMakeSearch(page, jbv.jbidx, jmv.jmidx, jmv.jmname)}';

	 } else {
		 alert("삭제가 취소되었습니다.")
	 }
	  
 }

</script>

</head>
<body>

<p>${jmv.jmidx}/${jmv.jmname}님 반갑습니다.</p> 

<h1>  내용보기 화면입니다. </h1>

<input type="hidden" name="searchType" value="${pageMaker.scri.searchType}">
<input type="hidden" name="keyword" value="${pageMaker.scri.keyword}">

<input type="hidden" name="jboriginbidx" value="${jbv.jboidx}">
<input type="hidden" name="jbupdown" value="${jbv.jbupdown}">
<input type="hidden" name="jbleftright" value="${jbv.jbleftright}">

<c:if test="${jbv == null }">
	<script type='text/javascript'>alert('처음부터 시작하세요.');</script>
	<script type='text/javascript'>	
	     window.document.location.href='${pageContext.request.contextPath}/twins/jbListController';</script>
	     <!-- window.document.location.href='${pageContext.request.contextPath}/Spring/MVCListcontroller_TS${mv.sendLoginInfo(mv.idx, mv.name)}'; -->
</c:if>	   



<!--  // 이 부분은 bd.getContent()함수가 query 실패시 bv.bidx에 0을 담아서 보내기 때문임  -->
<c:if test="${jbv.jbidx == 0 }">
   <script type='text/javascript'>alert('데이터를 가져오지 못했습니다.\n\n다시 시도하세요.');</script>
   <script type='text/javascript'>	
	    window.document.location.href='${pageContext.request.contextPath}/twins/jbListController${pageMaker.idxMakeSearch(page, jmv.jmidx, jmv.jmname)}';</script>
</c:if>

<table border=1 class="mytable">

		<tr>
		  <td class=col1>상태 바</td>
		  <td colspan=9>${m.msg}</td>
		</tr>

        <tr>
         <td class="col1">번호</td><td class="col2" align="center">${jbv.jbidx}</td>
         <td class="narrow">제목</td><td class="title">${jbv.jbsubject}</td>
         <td class="narrow">작성자</td><td class="col2">${jbv.jbwriter}</td>
         <td class="narrow">등록일</td><td class="col2">${jbv.jbwritedate}</td> 
         <td class="narrow">수정일</td><td class="col2">${jbv.jbmodifydate}</td> 
        </tr>

        <tr>
         <td class="aligncenter">내용</td><td colspan=9>${jbv.jbcontent}</td>
        </tr>

       </table>

        <p class="short" align=center>
          <input type="button" name="modify" value="수정" onclick="location.href='${pageContext.request.contextPath}/twins/jbModifyController${pageMaker.bidxIdxMakeSearch(page, jbv.jbidx, jmv.jmidx, jmv.jmname)}'">
          <input type="button" name="delete" value="삭제" onclick="DeleteYN();">
         
          <c:if test="${m.rds == '1' && m.isUpdate == 'Yes'}"> 
          	<input type="button" name="list" value="목록1" onclick="location.href='${pageContext.request.contextPath}/twins/jbListController_rm${pageMaker.bidxIdxMakeSearch(page, jbv.jbidx, jmv.jmidx, jmv.jmname)}'">
          </c:if>
     
          
          <c:if test="${ ! (m.rds == '1' && m.isUpdate == 'Yes') }">
          <input type="button" name="list" value="목록0" onclick="location.href='${pageContext.request.contextPath}/twins/jbListController${pageMaker.idxMakeSearch(page, jmv.jmidx, jmv.jmname)}'">
          </c:if>
          
          <input type="button" name="reply" value="답글쓰기" onclick="location.href='${pageContext.request.contextPath}/twins/jbReplyController${pageMaker.bidxIdxTotalMakeSearch(page, jbv.jbidx, jmv.jmidx, jmv.jmname)}'">
         </p>

</body>
</html>

