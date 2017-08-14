<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!-- Attribute start -->
<%@ page import="java.util.*" %>
<%@ page import="com.port.service.*" %>
<!-- Attribute end -->
<%@ include file="/WEB-INF/views/header.jsp" %>
<!-- 바디	 -->
<div class="bodyWrapper clearFix">
<!-- 사이드바	 -->
<%@ include file="/WEB-INF/views/sideBar/imemberSideBar.jsp" %>
	<div class="bodyMain"> 
<!-- main start -->
<style>
.btn-default{
	margin-bottom: 3px;
}

.imemWrapper{
	width:100%;
	padding: 0;
	margin: 0; 	 	
}

.imemDivTable{
	margin-top: 10px;
	margin-bottom: 40px;
}

.imemTitle{
	font-size: 20px;
	margin-top: 20px;
	margin-left: 10px;
	font-weight: bold;
}
</style>
<script>
function goList(page) {
	  var form = document.getElementById("listForm");
	  form.curPage.value = page;
	  form.submit();
	 }
</script>

<p class="imemTitle">투자금 충전 내역</p>
	<div class="imemWrapper">	
		<div class="imemDivTable">
		 	<div class="clearFix rowTitle">
				<div class="col col5_1">No</div>
				<div class="col col5_2">충전 신청금액</div>
				<div class="col col5_3">현재 충전금액</div>
				<div class="col col5_4">충전일</div>
				<div class="col col5_5">상태</div>
			</div>

<div class="clearFix">
	<c:forEach var="mv" items="${dataList }">
		<div class="col col5_1">${mv.RNUM }</div>	
		<div class="col col5_2">${mv.CHGMONEY }원</div>	
		<div class="col col5_3">${mv.MONEY }원</div>	
		<div class="col col5_4">${mv.MODDATE }</div>		
			<c:choose>
				<c:when test="${mv.STATUS eq 0 }">
					<div class="col col5_5">신청</div>
				</c:when>
				<c:when test="${mv.STATUS eq 1 }">
					<div class="col col5_5">완료</div>
				</c:when>
				<c:when test="${mv.STATUS eq 2 }">
					<div class="col col5_5">취소</div>
				</c:when>
			</c:choose>
	</c:forEach>
</div>

	
	
	 <div id="paging" style="text-align: center;">
  
  <c:if test="${prevLink > 0 }">
  	<a href="javascript:goList('${prevPage }')">[이전]</a>
  </c:if>

  <c:forEach var="i" items="${pageLinks }" varStatus="stat">
  	<c:choose>
    	<c:when test="${curPage == i}">
    		<span class="bbs-strong">${i }</span>
   		</c:when>
   		<c:otherwise>
    		<a href="javascript:goList('${i }')">${i }</a>
   		</c:otherwise>
  	</c:choose>
  </c:forEach>
  
  <c:if test="${nextLink > 0 }">
  	<a href="javascript:goList('${nextPage }')">[다음]</a>
  </c:if>
  
 </div>
 
 <div id="form-group" style="display: none;">
 	<form id="listForm" action="<c:url value='/IMemberMoneyHis.do' />" method="get">
   		<input type="hidden" name="curPage" />
 	</form>
 </div>
	<h3> 투자금 충전 신청 </h3>
	<p class="lead text-center">
		<strong>
			국민 은행 482 - 438298 - 27 <br>
			테크포레스트(주)
		</strong>
	</p>
	
	<c:url var="action" value='/IMemberMoneyCharge_Action.do' />
	<form id="IMemberChargeAction" class="form-inline" action="${action }" method="post">
  	 	<div class="form-group">
			<div class="col-sm-5">
      			<input class="form-control" type="hidden" name="contents" id="contents" value="신청"/>
   			</div>
  	 	</div>
		<div class="form-group">
			<div class="col-sm-5">
      			<input class="form-control" type="text" name="chgMoney" id="chgMoney" placeholder="금액을 입력해 주세요." >
   			</div>
  	 	</div>
  	 		<button class="btn btn-primary" id="IMemberChargeAction" type="submit">신청하기</button>
  	 </form>
   	
   	<p class="lead text-center"><br>
	   	<strong>
	   		본인명의의 입금만 가능합니다.<br>
	   		계좌번호와 예금주를 정확히 확인 후 입금해 주세요.
	   	</strong>
   	</p>
   	
   	</div>
 </div>	
<!-- main end -->
	</div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>