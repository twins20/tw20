<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!-- Attribute start -->
<%@ page import="java.util.*" %>
<%@ page import="service.MoneyVo" %>
<%
	ArrayList<MoneyVo> alist = (ArrayList<MoneyVo>) request.getAttribute("alist");
%>
<!-- Attribute end -->
<%@ include file="/header.jsp" %>
<!-- 바디	 -->
<div class="bodyWrapper clearFix">
<!-- 사이드바	 -->
<%@ include file="/sideBar/imemberSideBar.jsp" %>
	<div class="bodyMain"> 
<!-- main start -->

	<h3> 투자금 충전 내역 </h3>
	<table class="table table-striped table-bordered table-hover">
	<tr>
	<td></td>
	<td>충전 신청금액</td>
	<td>현재 충전금액</td>
	<td>충전일</td>
	<td>상태</td>
	</tr>
<%
	String status = null;
	for(MoneyVo vo : alist){
		if(vo.getStatus() == 0){
			status = "신청";
		}else if(vo.getStatus() == 1){
			status = "완료";
		}else if(vo.getStatus() == 2){
			status = "취소";
		}
%>	
	<tr>
	<td><%=vo.getrNum() %></td>
	<td><%=vo.getChgMoney() %>원</td>
	<td><%=vo.getbMoney() %>원</td>
	<td><%=vo.getModDate() %></td>
	<td><%=status %></td>
	</tr>
<%
	}
%>
	</table>
	
	<h3> 투자금 충전 신청 </h3>
	
	<p class="lead text-center">
	<strong>
		국민 은행 482 - 438298 - 27 <br>
		테크포레스트(주)
	</strong>
	</p>
	
	<form id="IMemberChargeAction" class="form-inline" action="<%=request.getContextPath()%>/IMemberMoneyCharge_Action.do" method="post">
  	 	<div class="form-group">
			<div class="col-sm-5">
      			<input class="form-control" type="hidden" name="contents" id="contents" value="신청"/>
   			</div>
  	 	</div>
		<div class="form-group">
			<div class="col-sm-5">
      			<input class="form-control" type="text" name="chgmoney" id="chgmoney" placeholder="금액을 입력해 주세요." >
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
   	
<!-- main end -->
	</div>
</div>
<%@ include file="/footer.jsp" %>