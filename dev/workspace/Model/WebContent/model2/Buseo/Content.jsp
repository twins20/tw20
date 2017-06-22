<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ page import ="Model.BuseoDao" %>
<%@ page import ="Model.BuseoVo" %> 
<%
request.setCharacterEncoding("UTF-8");
 // int idx = Integer.parseInt(request.getParameter("idx"));
BuseoVo bv = (BuseoVo)request.getAttribute("bv");
// attribute가 object 형으로 들어감
// int idx = ((Integer)request.getAttribute("idx")).intValue();
//Integer.parseInt는 ()안의 값이 String 일때 int로 형변환을 해줍니다.

%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글목록</title>
<!-- bootstrap을 사용하기 위한 CDN주소 -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script>
	function de(){ // function = 함수
		if(confirm("삭제 하시겠습니까?")){ // confirm = 경고창
        	location.href="<%=request.getContextPath()%>/Controller/BuseoDeleteActionServlet.do?bidx=<%=bv.getBidx() %>";
        	}else{
        		alert("삭제되지 않았습니다.");
        	}
		}
</script>
</head>
<body>
<div class="container"> <!-- div로 묶음 -->

<table class="table table-striped table-bordered table-hover ">
<tr>
<td>사원명</td><td>인덱스 : </td> <!-- 테이블 생성 -->
</tr>
<tr>
<td><%=bv.getBname() %></td><td><%=bv.getIdx() %>
</tr>
</table>
<!-- div class = "form group" -->
<!-- label for="sex" sex : /label -->
<!-- %mv.getSex()% /div -->

<!-- div class = "form group" -->
<!-- label for="area" area : /label -->
<!-- %mv.getArea()% /div -->
	<div>
  <a class="btn btn-default" href="<%=request.getContextPath()%>/Controller/BuseoWriteServlet.do">게시글 입력</a>
  <a class="btn btn-default" href="<%=request.getContextPath()%>/Controller/BuseoModifyServlet.do?bidx=<%=bv.getBidx() %>">수정</a> <!--bidx 값을 못 불러오니까 getidx였지만 설정을 안해둬서 그냥 bidx 값을 불러와서 실행 -->
  <input class="btn btn-default" id="DeleteButton" type="button" value="삭제" onclick="de()"/>
  </form>
 	</div>
 </div>
 </body>
</html>