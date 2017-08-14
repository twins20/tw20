<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!-- Attribute start -->
<%@ page import="com.port.service.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<!-- Attribute end -->
<%@ include file="/WEB-INF/views/header.jsp" %>
<!-- 바디	 -->
<div class="bodyWrapper clearFix">
<!-- 사이드바	 -->
<%@ include file="/WEB-INF/views/sideBar/adminSideBar.jsp" %>
	<div class="bodyMain"> 
<!-- main start -->


<div class="adminWrapper">

<p class="adminP">회원 상세 정보</p>
	<form class="form-horizontal adminIMemberList">
		<div class="form-group">
			<label for="email" class="col-sm-3 control-label">이메일</label>
			<div class="col-sm-9">
				<input type="text" class="form-control" id="email" value="${mv.id}" readonly>
			</div>
		</div>
		<div class="form-group">
			<label for="nick" class="col-sm-3 control-label">닉네임</label>		
			<div class="col-sm-9">
				<input type="text" class="form-control" id="nick" value="${mv.nick}" readonly>
			</div>
		</div>
		<div class="form-group">
			<label for="name" class="col-sm-3 control-label">성명</label>
			<div class="col-sm-9">
				<input type="text" class="form-control" id="name" value="${mv.name}" readonly>
			</div>
		</div>
		<div class="form-group">
			<label for="tel" class="col-sm-3 control-label">전화번호</label>
			<div class="col-sm-9">
				<input type="text" class="form-control" id="tel" value="${mv.phone}" readonly>
			</div>
		</div>
		<div class="form-group">
			<label for="adress" class="col-sm-3 control-label">주소</label>
			<div class="col-sm-9">
				<input type="text" class="form-control" id="address" value="${mv.addr}" readonly>
			</div>
		</div>		
	</form>
	<button type="button" class="btn btn-primary form-control form-mod" data-toggle="modal" data-target="#myModal">정보 수정</button>
	
	<form id="ModifyForm" action="<c:url value='/'/>/IMemberInfoMod.do" method="post">	
		<div class="modal fade imemberModify" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		        <span aria-hidden="true">&times;</span>
		        </button>
		        <h4 class="modal-title" id="myModalLabel">비밀번호를 입력해주세요.</h4>
		      </div>
		      	  <input class="form-control" type="hidden" name="param_idx" id="param_idx" value="${mv.idx}">
		      <div class="modal-body">
		      	 <input class="form-control" type="password" name="pw" id="pw">
		      </div>
		      <div class="modal-footer">
		        <button type="submit" id="ModifyForm" class="btn btn-primary">입력</button>
		      </div>
		    </div>
		  </div>
		</div>
	</form>


<p class="adminP">투자금 충전 내역</p>
	<div class="divTable">  
	 <div class="clearFix rowTitle">
	   <div class="col col5_1">No </div>
	   <div class="col col5_2">충전금액</div>
	   <div class="col col5_3">충전일</div>
	   <div class="col col5_4">상태</div>
	   <div class="col col5_5">작업</div>
	</div>

<c:forEach var="mv" items="${molist}"> 

	  <div class="clearFix">
	    <div class="col col5_1"></div>
	    <div class="col col5_2">${mv.chgMoney}원</div>
	    <div class="col col5_3">${mv.insDate}</div>
	    <c:when test="${mv.status eq 0 }">
	    <div class="col col5_4">머니신청</div>
	    </c:when>
	    <div class="col col5_5">
	    <a href="<c:url value='/'/>/AdminMoneyChkOk_Action.do?param_idx=${mv.idx }&mIdx=${mv.mIdx}">
	    <button type='button' class='btn btn-default'>승인</button></a></a>
	    <a href="<c:url value='/'/>/AdminMoneyChkNOk_Action.do?param_idx=${mv.idx }&mIdx=${mv.mIdx}">
	    <button type='button' class='btn btn-default'>반려</button></a></a>
	    </div>
	    <c:when test="${mv.status eq 1 }">
	    <div class="col col5_4">충전 완료</div>
	    </c:when>
	    <c:when test="${mv.status eq 2 }">	    
	    <div class="col col5_4">충전 취소</div>
	    </c:when>
	    <c:when test="${mv.status eq 3 }">
	    <div class="col col5_4">신청 반려</div>
	    </c:when>
	  </div>	  
</c:forEach>
	
<p class="adminP">참가 프로젝트</p>	
	<div class="divTable">  
		<div class="clearFix rowTitle">
			<div class="col col5_1">No </div>
			<div class="col col5_2">프로젝트명</div>
			<div class="col col5_3">투자 금액</div>
			<div class="col col5_4">투자일</div>
			<div class="col col5_5">목표달성률</div>
		</div>

	<c:forEach var="hashmap" items="${dataList}">
		<div class="clearFix">
			<div class="col col5_1"></div>
			<div class="col col5_2"><a href="<c:url value='/'/>/ProjCon.do?pIdx=${dataList.pIdx}">${dataList.PNAME}</a></div>
			<div class="col col5_3">${dataList.INFUNDS}원</div>
			<div class="col col5_4">${dataList.INSDATE}</div>
			<div class="col col5_4">${(pnFunds / ptFunds)*100}%</div>
		</div>	  
	</c:forEach>
	
<p class="adminP">QNA 리스트</p> 
	<div class="divTable">  
		<div class="clearFix rowTitle">
			<div class="col col4_1">작성자 </div>
			<div class="col col4_2">문의 내역</div>
			<div class="col col4_3">상태</div>
			<div class="col col4_4">작성일</div>
		</div>
		
		<c:forEach var="hashmap" items="${QdataList}">
		<div class="clearFix">
			<div class="col col4_1">${hashmap.NICK}</div>
			<div class="col col4_2"><a href="<c:url value='/'/>/AdminQnaConServlet?bIdx=${hashmap.bIdx}">${hashmap.TITLE}</a></div>
			<c:choose>
			<c:when test="${STATUS eq 1}">
			<div class="col col4_3">미답변</div>
			</c:when>
			<c:when test="${STATUS eq 2 }">
			<div class="col col4_3">답변 완료</div>
			</c:when>
			</c:choose>
			<div class="col col4_4">${hashmap.INSDATE}</div>
		</div>	  

		</c:forEach>
	</div> 	
</div>

<!-- main end -->
	</div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>