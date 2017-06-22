<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.simple_table {
    width: 100%;
    border: none;
    border-collapse: separate;
    border-spacing: 2px;
}
.simple_table th {
    padding: 15px;
    border: none;
    border-left: 5px solid #C03;
    border-bottom: 1px solid #DDD;
    background: #FCF0F3;
    font-weight: normal;
    text-align:center;
    text-shadow: 0 1px #FFF;
    vertical-align: middle;
}
 
.simple_table td {
    padding: 15px;
    border: none;
    border-bottom: 1px solid #DDD;
    text-align: left;
    vertical-align: baseline;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body style="text-align:center;">
<table class="simple_table">
	<tbody>
		<tr>
			<th scope="row">회원정보</th>
<td><a href="<%=request.getContextPath()%>/Controller/ListServlet.do">회원정보 리스트 보기</a><br></td>
</tr>
		<tr>
			<th scope="row">부서정보</th>
<td><a href="<%=request.getContextPath()%>/Controller/BuseoListServlet.do">부서정보 리스트 보기</a><br></td>
</tr>
		<tr>
			<th scope="row">급여정보</th>
<td><a href="<%=request.getContextPath()%>/Controller/SalaryListServlet.do">급여정보 리스트</a><br></td>
</tr>
	</tbody>
</table>
</body>
</html>