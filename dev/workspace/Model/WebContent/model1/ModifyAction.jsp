<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Model1.MemberDao" %>
<%@ page import="Model1.MemberVo" %>
<%
	request.setCharacterEncoding("UTF-8"); // 한글 인코딩
	int idx = Integer.parseInt(request.getParameter("idx")); // idx 값
	String name = request.getParameter("name"); // 네임 값
	int age = Integer.parseInt(request.getParameter("age")); // 나이
	String sex = request.getParameter("sex"); // 성별
	String area = request.getParameter("area"); // 지역


	// out.println(idx);
	// asp = response.write idx
	// php = echo idx
	// jsp = out.println idx
	
	
	MemberDao md = new MemberDao(); // 객체 생성
	MemberVo vo = new MemberVo(); // private 값 가져옴
	
	vo.setName(name);
	vo.setAge(age);
	vo.setSex(sex);
	vo.setArea(area);

	int ra = md.Update(vo, idx); 
	
	if (ra ==0) { // 실패 시 write로 다시 감
	response.sendRedirect(request.getContextPath()+"/model1/Write.jsp");	
	}
	else{ // 성공 시 리스트 화면으로 오고 데이터가 바뀜
	response.sendRedirect(request.getContextPath()+"/model1/List.jsp");
	}
%>

<!--%
	int idx = Integer.parseInt(request.getParameter("idx"));
%-->
<!-- jsp:useBean id="md" class="Model1.MemberDao"/ -->
<!-- jsp:useBean id="mv" class="Model1.MemberVo"/ -->
<!-- jsp:setProperty name="mv" property="*" / -->
<!-- %	
	request.setCharacterEncoding("UTF-8"); // utf-8을 통해 페이지 한글깨짐 방지 설정
	int ra = md.Update(mv,idx);
	String alt = null;
	if (ra == 0) {
	 alt ="데이터 값 수정에 실패했습니다.";		
	 }else{
	 alt ="수정이 완료되었습니다.";	
	}	
% -->
  <!--script language=javascript -->
<!--   self.window.alert("<!--%=alt%");-->
<!-- location.href="List.jsp"; -->
</script>