<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Model1.MemberDao" %>
<%@ page import="Model1.MemberVo" %>
<%
    request.setCharacterEncoding("UTF-8");
	int idx = Integer.parseInt(request.getParameter("idx"));
    // parameter을 통해 idx 값을 받아옴.
    MemberDao md = new MemberDao(); // 객체 선언
    // delete는 데이터만 접근하면 되기 때문에 MemberVo가 필요 없음.
    int dt = md.Delete(idx);
    if (dt ==0) { // 실패 시 write로 다시 감  html이 아니어서 연결문자로 실행 값을 연결(주소가 +idx 였기 때문에)
    	response.sendRedirect(request.getContextPath()+"/model1/Content.jsp?idx="+idx);	
    	}
    	else{ // 성공 시 리스트 화면으로 오고 데이터가 지워짐
    	response.sendRedirect(request.getContextPath()+"/model1/List.jsp");
    	}
%>      