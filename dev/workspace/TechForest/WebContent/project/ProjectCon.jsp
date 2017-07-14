<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!-- Attribute start -->
<%@ page import="java.util.*" %> 
<%@ page import="service.ProjectVo" %>
<!-- <%@ page import="service.ItemVo" %>  -->
<%@ page import="service.ProjectCommVo" %>
<%@ page import="service.MemberVo" %>
<%@ page import="service.BoardVo" %>
<%@ page import="service.BoardCommVo" %>
<%
	String nick = (String) request.getAttribute("nick");
	ProjectVo pvo = (ProjectVo) request.getAttribute("vo");
	//ItemVo ivo = (ItemVo) request.getAttribute("ivo");
	MemberVo mvo = (MemberVo) request.getAttribute("cMemInfo");
	ArrayList<ProjectCommVo> commList = (ArrayList<ProjectCommVo>) request.getAttribute("commList");
	ArrayList<BoardVo> boardList = (ArrayList<BoardVo>) request.getAttribute("boardList");
%>
<!-- Attribute end -->
<%@ include file="/header.jsp" %>
<!-- 바디	 -->
<div class="bodyWrapper clearFix">
<!-- 사이드바	 -->
<%@ include file="/sideBar/projectSideBar.jsp" %>
	<div class="bodyMain"> 
<!-- main start -->
<script>
$(document).ready(function(){
    $('#projCommWriteButton').click(function(){
        if($('#comments').val()==''){ 
            alert('댓글을 입력해주세요'); 
            $('#comments').focus(); 
        }else{
        	var check = confirm('댓글을 등록하시겠습니까?'); 
	        	if (check  == true){
	        		$('#projCommWriteAction').submit();	
	        	}else
	        		$('#comments').focus();        	 		
    	}
        return false;
    });
});
</script>
<script>
$(document).ready(function(){
    $("#projSubCommWriteShowButton").click(function(){
        $("p").hide();
    });
    $("#projSubCommWriteShowButton").click(function(){
        $("p").show();
    });
});
</script>

	<table class="table table-striped table-bordered table-hover">
	<tr>
	<td>프로젝트 명</td>
	<td>프로젝트 카테고리</td>
	<td>프로젝트 내용</td>
	<td>아이템 리스트</td>
	<td>아이템 수량</td>
	<td>프로젝트 현재 투자금액 </td>
	<td>프로젝트 목표 도달금액</td>
	<td>목표달성률</td>
	</tr>
<%	
	float goalRate = 0;
	float pnFunds = 0;
	float ptFunds = 0;
	pnFunds = pvo.getPnFunds();
	ptFunds = pvo.getPtFunds();
	goalRate = (pnFunds / ptFunds) * 100;
%>
	<tr>
	<td><%=pvo.getpName() %></td>
	<td><%=pvo.getpCate() %></td>
	<td><%=pvo.getContents() %></td>
	<td><%=pvo.getItList() %></td>
	<td><%=pvo.getItListCnt() %></td>
	<td><%=pvo.getPnFunds() %></td>
	<td><%=pvo.getPtFunds() %></td>
	<td><%=goalRate %></td>
	</tr>
	</table>
	
	<table class="table table-striped table-bordered table-hover">
	<tr>
	<td>회사명</td>
	<td>사업자번호</td>
	<td>사업장 주소</td>
	</tr>
	
	<tr>
	<td><%=mvo.getCompany() %></td>
	<td><%=mvo.getcNumber() %></td>
	<td><%=mvo.getcAddr() %></td>
	</tr>
	</table>
	
	<table class="table table-striped table-bordered table-hover">
	<tr>
	<td>순번</td>
	<td>카테고리</td>
	<td>제목</td>
	</tr>
<% 
	for(BoardVo bvo : boardList){
%>
	<tr>
	<td><%=bvo.getrNum() %></td>
	<td><%=bvo.getCate() %></td>
	<td><%=bvo.getTitle() %></td>
	</tr>
<% } %>
	</table>
	<table class="table table-striped table-bordered table-hover">
	<tr>
	<td>내용</td>
	<td>좋아요</td>
	<td>싫어요</td>
	<td><a class="btn btn-default" id="projSubCommWriteShowButton" role="button">대댓글 달기</td>
	</tr>
<%
	for(ProjectCommVo pcvo : commList){
%>	
	<tr>
	<td><%=pcvo.getComments() %></td>
	<td><%=pcvo.getGood() %></td>
	<td><%=pcvo.getBad() %></td>
	</tr>
<% } %>
	</form>
	</table>
	
	<form id="projCommWriteAction" class="form-horizontal projCommWriteAction" 	action="<%=request.getContextPath()%>/ProjConCommWrite_Action.do" method="post" >
  	 	<div class="form-group">
  	 		<input class="form-control" type="hidden" name="pIdx" id="pIdx" value="<%=pvo.getpIdx()%>"/>
  	 	</div>
  	 	<div class="form-group">
    		<label for="nick" class="col-sm-3 control-label"><%=nick%></label>
    			<div class="col-sm-9">
      				<textarea class="form-control" name="comments" id="comments" rows="3"></textarea>
      			</div>
   			</div>
   		</div>
   		<center><button type="submit" id="projCommWriteButton">입력</button></center>
   	</form>
	


<!-- main end -->
	</div>
</div>
<%@ include file="/footer.jsp" %>