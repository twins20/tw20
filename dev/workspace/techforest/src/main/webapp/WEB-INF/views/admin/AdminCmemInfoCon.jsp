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
				<input type="text" class="form-control" id="tel" value="0${mv.phone}" readonly>
			</div>
		</div>
		<div class="form-group">
			<label for="adress" class="col-sm-3 control-label">주소</label>
			<div class="col-sm-9">
				<input type="text" class="form-control" id="address" value="${mv.addr}" readonly>
			</div>
		</div>
		<div class="form-group">
			<label for="adress" class="col-sm-3 control-label">사업자 등록번호</label>
			<div class="col-sm-9">
				<input type="text" class="form-control" id="address" value="${mv.cNumber}" readonly>
			</div>
		</div>
		<div class="form-group">
			<label for="adress" class="col-sm-3 control-label">사업자 등록주소</label>
			<div class="col-sm-9">
				<input type="text" class="form-control" id="address" value="${mv.cAddr}" readonly>
			</div>
		</div>
		<button type="button" class="btn btn-primary form-control form-mod" data-toggle="modal" data-target="#myModal">정보 수정</button>
		
		<div class="modal fade adminImemberModify" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 class="modal-title" id="myModalLabel">비밀번호를 입력해주세요.</h4>
			</div>
			<div class="modal-body">
				<input class="form-control" type="password" name="password" id="password">
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-primary">수정</button>
			</div>
		</div>
		</div>
		</div>
	</form>

<c:forEach var="pv" items="${plist}">		
<div class="pListTable clearFix AdCmemInfopList">
	<div class="pListBox">
		<img src="" alt="">
		<div class="fundInfo clearFix">
			목표 금액 :${pv.pnfunds}원 <br>
			목표율 : ${(pnFunds / ptFunds)*100}
		</div>
		<div class="title">
			${pv.pName}
		</div>
	</div>
</div>
</c:forEach>	

	

<p class="adminP">지난 프로젝트 리스트</p>
	<div class="divTable">  
		<div class="clearFix rowTitle">
			<div class="col col5_1">No </div>
			<div class="col col5_2">프로젝트명</div>
			<div class="col col5_3">총 투자 받은 금액</div>
			<div class="col col5_4">프로젝트 시작일</div>
			<div class="col col5_5">목표달성률</div>
		</div>


<c:forEach var="dv" items="${dlist}">
		<div class="clearFix">
			<div class="col col5_1"></div>
			<div class="col col5_2"><a href="<c:url value='/AdminProjChkCon.do?pIdx=${dv.pIdx}'/>">${dv.pName}</a></div>
			<div class="col col5_3">${dv.pnFund}원</div>
			<div class="col col5_4">${dv.insDate}</div>
			<div class="col col5_4">${(pnFunds / ptFunds)*100}%</div>
		</div>	  
	</c:forEach>	
	</div>
<p class="adminP">투자 회원 리스트</p>	
	<div class="divTable">  
		<div class="clearFix rowTitle">
			<div class="col col5_1">No </div>
			<div class="col col5_2">회원 닉네임</div>
			<div class="col col5_3">투자 금액</div>
			<div class="col col5_4">투자일</div>
			<div class="col col5_5">상태</div>
		</div>
			
		<e:forEach var="hashmap" items="${elist}">
		<div class="clearFix">
			<div class="col col5_1"></div>
			<div class="col col5_2">${hashmap.NICK}</div>
			<div class="col col5_3">${hashmap.AFUNDS}원</div>
			<div class="col col5_4">${hashmap.INSDATE}</div>
			<c:choose>
			<c:when test="${STATUS eq 0 }">
			<div class="col col5_5">정상투자</div>
			</c:when>
			<c:when test="${STATUS ne 0 }">
			<div class="col col5_5">취소/환불</div>
			</c:when>
			</c:choose>
		</div>	  
	</e:forEach>
	</div>
		
<p class="adminP">QNA 리스트</p> 
	<div class="divTable">  
		<div class="clearFix rowTitle">
			<div class="col col4_1">No </div>
			<div class="col col4_2">문의 내역</div>
			<div class="col col4_3">상태</div>
			<div class="col col4_4">작성일</div>
		</div>
				
	<c:forEach var="bv" items="${glist}">
		<div class="clearFix">
			<div class="col col4_1"></div>
			<div class="col col4_2"><a href="<c:url value='/AdminQnaConServlet?bIdx=${bv.bIdx}'/>">${bv.title}</a></div>
			<c:choose>
				<c:when test="${bv.status eq 0}">
			<div class="col col4_3">미답변</div>
				</c:when>
				<c:when test="${bv.status ne 0 }">
			<div class="col col4_3">답변 완료</div>
				</c:when>
			</c:choose>		
			<div class="col col4_4">${bv.insDate}</div>
			
		</div>	  
	</c:forEach>	
	</div>
<!-- main end -->
	</div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>