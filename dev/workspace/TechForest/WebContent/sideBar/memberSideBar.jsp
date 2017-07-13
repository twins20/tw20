<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<div class="sideBar">
		<ul>
			<li>
				<a href="<%=request.getContextPath() %>/MemberLogIn.do">
				로그인
				</a>
			</li>
			<li>
				<a href="<%=request.getContextPath() %>/MemberJoin.do">
				회원가입
				</a>
			</li>
			<li>
				<a href="<%=request.getContextPath() %>/MemberFindMail.do">
				아이디/비밀번호 찾기
				</a>
			</li>
		</ul>
	</div>