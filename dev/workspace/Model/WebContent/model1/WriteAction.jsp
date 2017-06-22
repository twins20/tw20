<%@ page language="java" contentType="text/html; charset=UTF-8"     
pageEncoding="UTF-8"%>
<%//@ page import="Model1.MemberDao" %>
<%//@ page import="Model1.MemberVo" %>
<%
/*
    request.setCharacterEncoding("UTF-8");
    String name = request.getParameter("name");
    int age = Integer.parseInt(request.getParameter("age"));   
    String sex = request.getParameter("sex");
    String area = request.getParameter("area");
    
    MemberDao md = new MemberDao();
    
    MemberVo mv = new MemberVo();
    mv.setName(name);
    mv.setAge(age);
    mv.setSex(sex);
    mv.setArea(area);
    
    int max = md.getMax();
    int row = md.insertWrite(mv, max); 
    
    //row 0이면 입력안됨
    if (row ==0) {
    response.sendRedirect(request.getContextPath()+"/model1/Write.jsp");	
    }
    else{
    response.sendRedirect(request.getContextPath()+"/model1/List.jsp");
    }
  */
%>      

<jsp:useBean id="md" class="Model1.MemberDao"/>
<jsp:useBean id="mv" class="Model1.MemberVo"/>
<jsp:setProperty name="mv" property="*" />
<%	
	request.setCharacterEncoding("UTF-8"); // utf-8을 통해 페이지 한글깨짐 방지 설정
//	out.print(md.pasing(mv.getName()));
	int max = md.getMax();
	int row = md.insertWrite(mv, max);
	String alt = null; // alt 값 초기화
	if (row ==0) { // row 값이 0이라면 입력실패 0이 아니면 입력성공
	 alt ="입력실패";		
	}else{
	 alt ="입력성공";	
	}	
%>
  <script language=javascript>
   self.window.alert("<%=alt%>");
   location.href="List.jsp"; 
</script>

