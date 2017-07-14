<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<!-- Attribute start -->
<%@ page import="service.*" %>
<%@ page import="java.util.*" %>
<%  
BoardVo vo = (BoardVo) request.getAttribute("vo");
int commIdx = (Integer) request.getAttribute("commIdx");
ArrayList<Map<String, Object>> clist = (ArrayList<Map<String, Object>>) request.getAttribute("clist");
ArrayList<Map<String, Object>> sclist = (ArrayList<Map<String, Object>>) request.getAttribute("sclist");
%>
<!-- Attribute end -->
<%@ include file="/header.jsp" %>
<!-- 바디	 -->
<div class="bodyWrapper clearFix">
<!-- 사이드바	 -->
<%@ include file="/sideBar/newsSideBar.jsp" %>
	<div class="bodyMain"> 
<!-- main start -->

<script>
$(document).ready(function(){
$('#replyButton').click(function(){ 
    if($('#comments').val().length <1) {
        alert('댓글을 입력해주세요'); 
        $('#comments').focus(); 
    } 
		else {
        $('#reply').submit(); 
    }
});


});
</script>
<style>
.newscon form-group{
 float:left;
 display: inline-block;
 width:20px;
 height:40px;
}
.icon-forward:before {
  content: "\e969";
}
   
</style>


	<form class= "form-horizontal newsCon">
		<div class="form-group">
    		<label for="cate" class="col-sm-3 control-label">카테고리</label>
    		<div class="col-sm-9">
      			<%=vo.getCate()%> 
   		 	</div>
  		</div>
  		<div class="form-group">
   	 		<label for="title" class="col-sm-3 control-label">제목</label>
    		<div class="col-sm-9">
      			<%=vo.getTitle()%>
   			</div>
 		</div>
  		<div class="form-group">
    		<label for="contents" class="col-sm-3 control-label">내용</label>
    		<div class="col-sm-9">
      			<%=vo.getContents()%>
   		 	</div>
  		</div>
  		<div class="form-group">
    		<label for="hit" class="col-sm-3 control-label">조회수</label>
    		<div class="col-sm-9">
      			<%=vo.getHit()%>
   		 	</div>
  		</div>
  		 <div class="form-group">
    		<label for="insdate" class="col-sm-3 control-label">작성일</label>
    		<div class="col-sm-9">
      			<%=vo.getInsDate()%>
   		 	</div>
  		</div>
  	</form>	
	<center>
		<div>
		    <a href="<%=request.getContextPath()%>/NewsConGoodBad_Action.do?bIdx=<%=vo.getbIdx() %>&goodbad=up"><p class="glyphicon glyphicon-thumbs-up"></p></a>&nbsp;&nbsp;<%=vo.getGood()%>&nbsp;
		    <a href="<%=request.getContextPath()%>/NewsConGoodBad_Action.do?bIdx=<%=vo.getbIdx() %>&goodbad=down"><p class="glyphicon glyphicon-thumbs-down"></p></a>&nbsp;&nbsp;<%=vo.getBad()%>					    			
		    <p><a class="btn btn-primary" href="<%=request.getContextPath()%>/NewsList.do?cate=<%=vo.getCate()%>">글목록</a></p>	
		</div>		
	</center>
	
<center>
<h3>CommWrite</h3>
  <form id="reply" action="<%=request.getContextPath()%>/NewsCommWrite_Action.do" method="post">
      <div class="form-group">
          <label for="Comments"></label>
          <input type="hidden" name="bIdx" value="<%=vo.getbIdx() %>" autocomplete="off" readonly="readonly">
          <textarea class="form" name="comments" id="comments" rows="5" cols="40" placeholder="댓글을 입력해 주세요." style="resize:none;"></textarea>	
	       <input id="replyButton" type="button" value="댓글입력"/> 
	  </div>	
  </form>	
</center>	
	
<!-- 댓글 리스트  -->
<h3>CommList</h3>
	<div style="height: auto; width: 100%; border-bottom:1px solid white;">
		<div style="height: auto; width: 100%; border-bottom:1px solid white;">
			<table style="width:100%;">
				<tr>
					<td style="width:20%;"></td>
					<td style="width:10%;">작성자</td>
					<td style="width:40%;">댓글</td>
					<td style="width:30%;"></td>
				</tr>				
			</table>
		</div>
	
<% int i = 1; 
for(Map<String, Object> clist2 : clist){ 
	
	BoardCommVo commvo1 = (BoardCommVo) clist2.get("vo");
	MemberVo mvo = (MemberVo) clist2.get("vo2");	
%> 
	
<script>
$(document).ready(function(){

   $('#DreplyButton<%=i%>').click(function(){ 
       if($('#dcomments<%=i%>').val().length <1) {
           alert('<%=i%>번째 대댓글을 입력해주세요'); 
           $('#dcomments<%=i%>').focus(); 
       } 
		else {
           $('#Dreply<%=i%>').submit(); 
       }
   }); 
   
   $('#ModifyButton<%=i%>').click(function(){ 
       if($('#rcomments<%=i%>').val().length <1) { 
           alert('<%=i%>번째 댓글을 수정해주세요'); 
           $('#rcomments<%=i%>').focus(); 
       }
       	else {
           $('#replymod<%=i%>').submit(); 
       }
   });  
  
   $('#modify1<%=i%>').click(function(){ 
       if($("#modify<%=i%>").css("display") == "none"){
		$("#modify<%=i%>").show();
	}else{
		$("#modify<%=i%>").hide();
  		 }
   }); 
   
   $('#dreply1<%=i%>').click(function(){ 
       if($("#ddreply<%=i%>").css("display") == "none"){
		$("#ddreply<%=i%>").show();
	}else{
		$("#ddreply<%=i%>").hide();
	}
   });    
}); 

function newsCommDel(){ 
	if(confirm("댓글을 삭제하시겠습니까?")){
    	location.href="<%=request.getContextPath()%>/NewsCommDel_Action.do?bIdx=<%=commvo1.getbIdx()%>&commIdx=<%=commvo1.getCommIdx()%>";
    	}else{
    		alert("삭제되지 않았습니다.");
    	}
	}
</script>	
	<div style="height: auto; width: 100%; border-top:1px solid #ccc;, border-bottom:1px solid #ccc; ">
		<table style="width:100%;">
			<tr>
				<td style="width:20%;"></td>
				<td style="width:10%;"><%=mvo.getNick() %></td>
				<td style="width:40%;">
					<a href="<%=request.getContextPath() %>/NewsCon.do?bIdx=<%=commvo1.getbIdx() %>&commIdx=<%=commvo1.getCommIdx() %>">
					<%=commvo1.getComments() %>
					</a>			
				</td>
				<td style="width:30%;">
					<a class="btn btn-basic" onclick="newsCommDel()">삭제</a>
					<a class="btn btn-basic" id="modify1<%=i%>">수정</a>
					<a class="btn btn-basic" id="dreply1<%=i%>">대댓글</a>
				</td>
			</tr>										
		</table>
	</div>	
		
		<div id="modify<%=i%>" style="height: auto; width: 100%; border-bottom:1px solid #ccc; display:none;">
					<table style="width:100%;">
					 <form id="replymod<%=i%>" action="<%=request.getContextPath()%>/NewsCommMod_Action.do?" method="post"> 
						<tr>
							<td colspan="3">댓글수정					   	
				    		<input  name="bIdx" id="bIdx" type="hidden" value="<%=commvo1.getbIdx() %>" />
				    		<input  name="commIdx" id="commIdx" type="hidden" value="<%=commvo1.getCommIdx() %>" />
							<input  name="rcomments" id="rcomments<%=i%>" type="text" value="<%=commvo1.getComments() %>"/>  		
							<input  id="ModifyButton<%=i%>" type="button" value="수정완료"/>	 		
							</td>
						</tr>	
						</form>				
					</table>
		</div>	
		
		<div id="ddreply<%=i%>" style="height: auto; width: 100%; border-bottom:1px solid #ccc; display:none;">
					<table style="width:100%;">
					 <form id="Dreply<%=i%>" action="<%=request.getContextPath()%>/NewsCommSubWrite_Action.do?" method="post"> 
						<tr>
							<td colspan="3">대댓글				   	
				    		<input type="hidden" name="bIdx" value="<%=commvo1.getbIdx() %>" >
					   		<input type="hidden" name="commIdx" value="<%=commvo1.getCommIdx() %>" >
					        <input class="form" name="dcomments" id="dcomments<%=i%>" rows="3" cols="10" placeholder="대댓글을 입력해 주세요.">	
					        <input  id="DreplyButton<%=i%>" type="button" value="대댓글입력"/>
							</td>
						</tr>	
						</form>				
					</table>
		</div>	
	 
	
<% 

if(commIdx == commvo1.getCommIdx()){
	int j = 1;
	
	for(Map<String, Object> sclist2 : sclist){ 
	BoardCommVo commvo2 = (BoardCommVo) sclist2.get("vo");
	MemberVo mvo2 = (MemberVo) sclist2.get("vo2");
	
	
	%> 
	
<script>
$(document).ready(function(){
	 $('#DreplymodButton<%=j%>').click(function(){ 
	        if($('#drcomments<%=j%>').val().length <1) { 
	            alert('<%=j%>번쨰 대댓글을 수정해주세요'); 
	            $('#drcomments<%=j%>').focus(); 
	        }
	        	else {
	            $('#Dreplymod<%=j%>').submit(); 
	        }
	    }); 
	 
	    $('#modify3<%=j%>').click(function(){ 
	        if($("#modify2<%=j%>").css("display") == "none"){
	 		$("#modify2<%=j%>").show();
	 	}else{
	 		$("#modify2<%=j%>").hide();
	 	}
	     }); 
	    
	    });

function newsSubCommDel(){ 
	if(confirm("댓글을 삭제하시겠습니까?")){
    	location.href="<%=request.getContextPath()%>/NewsCommSubDel_Action.do?bIdx=<%=commvo2.getbIdx()%>&commIdx=<%=commvo2.getCommIdx()%>";
    	}else{
    		alert("삭제되지 않았습니다.");
    	}
	}
</script>	
      
     <div style="height: auto; width: 100%; float:right; text-align:right;">
					<table style="width:100%; text-align:right; text-valign:middle; ">
						<tr style="background-color: white;text-valign:middle;">
							<td style="width:20%;"></td>
							<td style="width:10%; <%=j%>"><img src="images/1111.jpg"  margin-bottom= 11px width=11px heigh=11px>&nbsp;<%=mvo2.getNick() %></td>
							<td style="width:40%; text-align:left;">&nbsp;&nbsp;&nbsp;&nbsp;<%=commvo2.getComments() %></td>
							<td style="width:30%; text-align:left;">
							<a class="btn btn-basic" onclick="newsSubCommDel()">삭제</a>
							<a class="btn btn-basic" id="modify3<%=j%>">수정</a>
							</td>
						</tr>				
					</table>
	</div>	
	<div  id="modify2<%=j%>" style="height: auto; width: 100%; border-bottom:1px solid #ccc; display:none;">
					<table style="width:100%;">
					 <form id="Dreplymod<%=j%>" action="<%=request.getContextPath()%>/NewsCommSubMod_Action.do" method="post"> 
						<tr>
							<td colspan="3">대댓글수정					   	
				    		<input  name="bIdx" id="bIdx" type="hidden" value="<%=commvo2.getbIdx() %>" />
				    		<input  name="commIdx" id="commIdx" type="hidden" value="<%=commvo2.getCommIdx() %>" />
							<input  name="ocommIdx" id="ocommIdx" type="hidden" value="<%=commvo1.getCommIdx() %>" />							
							<input  name="drcomments" id="drcomments<%=j%>" type="text" value="<%=commvo2.getComments() %>"/>  		
							<input  id="DreplymodButton<%=j%>" type="button" value="수정완료"/>	 		
							</td>
						</tr>	
					</form>				
					</table>
	</div>	
      
    <%
j = j+1;    
	}
	}
i = i+1;
}
%>	
</div>


<!-- main end -->
	</div>
</div>
<%@ include file="/footer.jsp" %>