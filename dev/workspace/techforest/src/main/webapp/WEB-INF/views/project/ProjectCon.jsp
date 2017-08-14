<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Attribute start -->
<%@ page import="java.util.*" %> 
<%@ page import="com.port.service.*" %>
<!-- Attribute end -->
<%@ include file="/WEB-INF/views/header.jsp" %>
<!-- 바디	 -->
<style>
.project-total-con {
	width: 879px;
	margin: 0 auto;
	padding: 0 30px;
	overflow: hidden;
	line-height: 1;
}
h1 {
	text-align: center;
}
.project-total-con .project-sup-con {
	display: flex;
	flex-direction: row;
	margin: 20px;
}
.project-total-con .project-sup-con .project-image{
	width: 385px;
	height: 300px;
	overflow: hidden;
}
.project-total-con .project-sup-con .project-info{
	margin-left: 30px;
}
.project-total-con .project-sup-con .project-info p strong{
	font-size: 26px;
}
.project-total-con .project-sup-con .project-info p, .form-control{
	margin-bottom: 20px;
	
}
#value{
	font-size: 26px;
}
#fundingButton{
	width: 100%;
	height: 60px;
	font-size: 26px;
}
</style>
<div class="bodyWrapper clearFix">
<!-- 사이드바	 -->
<%@ include file="/WEB-INF/views/sideBar/projectSideBar.jsp" %>
	<div class="bodyMain"> 
<!-- main start -->
<script>
$(document).ready(function(){
    $('#fundingButton').click(function(){
        if(confirm("결제하시겠습니까?")){
        	$('#PayForm').submit();
    	} else {
    		return false;
    	}
    });
});
function money(selectObj) {
	var option = selectObj.value;
	console.log(option)
    $('#value').html(option)
}
</script>
<div class="project-total-con">
	<h1>${pv.pName }</h1>
		<div class="project-sup-con">
			<img src="/techforest/resources/images/${pv.pUrl }" class="project-image" alt="프로젝트 이미지">
			<div class="project-info">
				<c:url var="action" value='/ProjectPay.do' />
					<form id="PayForm" action="${action }" method="post">
						<input id="pIdx" name="pIdx" type="hidden" value="${pv.pIdx }">
							<p><strong>${(pv.pnFunds / pv.ptFunds) * 100}</strong> % 달성</p>
							<p><strong><fmt:formatNumber value="${pv.pnFunds}" pattern="###,###,###" /></strong> 원 펀딩</p>
								<select id="funding" class="form-control" onchange="money(this)">
									<option selected="selected" value="">옵션을 선택하세요</option>
									<c:forEach var="iv" items="${itemList }">
										<option value="<fmt:formatNumber value='${iv.itPrice }' pattern='###,###,###원'/>">${iv.contents }</option>									
									</c:forEach>
								</select>
							<strong><p id="value"></p></strong>
						<button type="button" id="fundingButton" class="btn btn-info">펀딩하기</button>
					</form>		
				</div>
			</div>
			<div class="project-sub-con"></div>		
	
</div>
<!-- main end -->
	</div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>