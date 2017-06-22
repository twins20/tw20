<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="Model.BuseoDao" %>
<%@ page import ="Model.BuseoVo" %>
<%@ page import ="Model.MemberDao" %>
<%@ page import ="Model.MemberVo" %>
<%@ page import ="java.util.*" %> 


<% 
request.setCharacterEncoding("UTF-8");
int bidx = (Integer)request.getAttribute("bidx");
BuseoVo bv = (BuseoVo)request.getAttribute("bv");



%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- bootstrap을 사용하기 위한 CDN주소 -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
 
<!-- jquery를 사용하기위한 CDN주소 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- bootstrap javascript소스를 사용하기 위한 CDN주소 -->
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
   
 <!-- 내용 작성하는 페이지-->
<script>
$(document).ready(function(){
        $('#ModifyButton').click(function(){ // button 클릭하면 띄우는 창  # = 아이디
            if($('#bname').val().length <1) { // val = value // # = id와 같음 
                alert('사원명을 입력하세요'); // 이름 입력 안했을 시 출력
                $('#bname').focus(); //  입력 초점 name 으로 (다른 것도 마찬가지)
            } else if($('#idx').val()=='') { // 이름은 입력했는데 age 입력 안하면
                alert('회원번호를 입력하세요'); // 나이를 입력하세요 출력, ''입력하면 안돼므로 ==를 통해 차단
                $('#idx').focus();
            } else {
                $('#ModifyForm').submit(); // 전송 버튼 = 폼 아이디
            }
        });
    });
</script>
<title>(부서 전용)</title>
</head>
<body>
<%
ArrayList<MemberVo> list = (ArrayList<MemberVo>)request.getAttribute("list"); 
%>
<div class="container">

    <h1>수정하기(부서 테이블 전용)</h1><!-- 전송하면 writeAtction.jsp로 페이지를 넘김 post방식-->
    <form id="ModifyForm" action="<%=request.getContextPath()%>/Controller/BuseoModifyActionServlet.do" method="post">
    <div class="form-group">
    <label for="bidx">bidx : <%=bidx %></label>
    <input class="form-control" name="bidx" id="bidx" type="hidden" value="<%=bidx %>"/>
    </div>
        <div class="form-group">
            <label for="name">bname :</label>
            <input class="form-control" name="bname" id="bname" type="text" value="<%=bv.getBname() %>"/>
        </div>
        <div class="form-group">
            <label for="idx">Idx :</label>
            <select class="form-control" name="idx" id="idx">
<% 			
			for (MemberVo mv : list) {
            	if(mv.getIdx()==bv.getIdx()){ 
%>
            		<option value ="<%=mv.getIdx() %>" selected> <%=bv.getIdx() %> </option>
<%  			
				}else{
%>
					<option value ="<%=mv.getIdx() %>"> <%=mv.getIdx() %> </option>
<% 
				}
			}
%>
        	
        	</select>
        
            
        </div>
        <div>
            <input class="btn btn-default" id="ModifyButton" type="button" value="수정"/> <!-- 버튼 생성 -->
            <input class="btn btn-default" type="reset" value="초기화"/>
            <a class="btn btn-default" href="<%=request.getContextPath()%>/Controller/BuseoListServlet.do">글목록</a>
        </div>
    </form>
</div>
</body>
</html>