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
<style>
.title0{
	width: 879px;
	height: 40px;
	display: block;
	padding-top: 10px;
	padding-bottom: 10px;
	border-top: 1px solid #ccc;
	border-bottom: 1px solid #ccc;
	background:#FCFCFC;	
}
.title1{
	float: left;	
	display: block;
	margin:0;
	padding-left: 30px;
	font-weight: bold;
}
.title2{
	float: right;
	display: block;
	margin:0;
	padding-right: 30px;
	font-weight: bold;

}
.title3{
	width: 879px;
	height: 40px;
	display: block;
	padding-top: 10px;
	padding-bottom: 10px;	
	border-bottom: 1px solid #ccc;
	
}
.title4{
	float: left;	
	display: block;
	margin:0;
	padding-left: 30px;
	
}

.title5{
	float: right;
	display: block;
	margin:0;
	padding-right: 30px;

}
.title6{
	width: 879px;
	height: 350px;
	margin-top: 20px;
	padding-top: 10px;
	padding-left: 70px;
	padding-right: 70px;
	text-align: letf;
	background-color: white;

}  
</style>
<script>	
	function delBtn(){ 
		if(confirm("글을 삭제하시겠습니까?")){
	    		document.submit();
	    	}else{
	    		alert("삭제되지 않았습니다.");
	    	}
			return false;
		}
</script>  


<p>
		<div class="t">
		<div class="tt1">
				<div class="title0">
			    <h4 class="title1">${bv.title}</h3>
			    <div class="title2">${bv.insDate }</div>
		</div>
		<div class="title3">
			<div class="title4">카테고리 > ${bv.cate} </div>
			<div class="title5">조회수 : ${bv.hit}</div>
		</div>	
		<div class="tt2">
			<div class="title6">
		 		${bv.contents}
		 	</div>
		</div>	
		</div>	
		</div>
		
	<div>
		<a href="<c:url value='/'/>/AdminNoticeDel_Action.do?bIdx=${bv.bIdx}"><button class="btn btn-primary pull-right" onclick="delBtn">삭제</button></a>
	</div>
	<div>
		<a href="<%=request.getContextPath()%>/AdminNoticeMod.do?bIdx=${bv.bIdx}"><button class="btn btn-primary pull-right">수정</button></a>
	</div>
	<div>
		<a href="<%=request.getContextPath()%>/AdminNoticeList.do"><button class="btn btn-primary pull-right">목록</button></a>
	</div>	
</div>


<!-- main end -->
	</div>
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>