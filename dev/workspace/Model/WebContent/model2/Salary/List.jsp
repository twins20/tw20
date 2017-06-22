<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ page import ="java.util.*" %>   
<%@ page import ="Model.SalaryDao" %>
<%@ page import ="Model.SalaryVo" %>   
    
    
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
ArrayList<SalaryVo> alist = (ArrayList<SalaryVo>)request.getAttribute("alist"); 
// membervo 타입이지만 타입을 적어준 게 없기 때문에 형을 맞춰서 선언해줘야 에러가 안남
// 리스트가 저장해준것들을 request.attribute 값에서 받음
%>

<table class="table table-striped table-bordered table-hover ">
<tr>
<td>회원번호</td><td>금액</td><td>회차</td><td>인덱스</td> <!-- 테이블 생성 -->
</tr>
<% for (SalaryVo sv : alist) {  %> 
<tr>
<td><%=sv.getSidx() %></td><td><a href="<%=request.getContextPath()%>/Controller/SalaryContentServlet.do?sidx=<%=sv.getSidx() %>"><%=sv.getAmount()%></a></td> <!-- 가로로 각 테이블 출력 -->
<td><%=sv.getRound() %></td><td><%=sv.getIdx() %>
</tr>
<% }%>
</table>

<div>
  <a class="btn btn-default" href="<%=request.getContextPath()%>/Controller/SalaryWriteServlet.do">게시글 입력</a>
 </div>
 </div>
 </body>
</html>