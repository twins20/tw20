<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ page import ="java.util.*" %>   
<%@ page import ="Model.MemberDao" %>
<%@ page import ="Model.MemberVo" %>   
    
    
 <!-- 조회 결과 내용 출력 페이지 -->
  <!-- 리스트는 url을 타고 넘어오므로 get방식을 사용해야 함 = 서블릿 -->
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

</head>
<body>
<div class="container"> <!-- div로 묶음 -->

<%
ArrayList<MemberVo>  list = (ArrayList<MemberVo>)request.getAttribute("list"); 
%>

<table class="table table-striped table-bordered table-hover ">
<tr>
<td>회원번호</td><td>이름</td><td>나이</td> <!-- 테이블 생성 -->
</tr>
<% for (MemberVo mv : list) {  %> <!-- membervo의 리스트 생성 -->
<tr>
<td><%=mv.getIdx() %></td><td><a href="<%=request.getContextPath()%>/Controller/ContentServlet.do?idx=<%=mv.getIdx() %>"><%=mv.getName()%></a></td> <!-- 가로로 각 테이블 출력 -->
<td><%=mv.getAge() %></td>
<!-- <td><%=mv.getIdx() %></td><td><a href="<%=request.getContextPath()%>/model2/Content.jsp?idx=<%=mv.getIdx() %>"> -->									<!-- 파라미터를 통해 get 방식으로 idx 값을 넘김 -->
</tr>
<% }%>
</table>

<div>
  <a class="btn btn-default" href="<%=request.getContextPath()%>/Controller/WriteServlet.do">게시글 입력</a>
 </div>
 </div>
 </body>
</html>