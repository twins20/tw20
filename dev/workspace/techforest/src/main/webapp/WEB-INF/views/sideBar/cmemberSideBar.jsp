<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<div class="sideBar">
		<ul>
			<li>
				<a href="<%=request.getContextPath() %>/CMemberIndexP.do">
					사업자 마이페이지
				</a>
			</li>
			<li>
				<a href="<%=request.getContextPath() %>/CMemberInfoExtWrite.do">
					사업자 등록
				</a>
			</li>
			<li>
				<a href="<%=request.getContextPath() %>/CMemberInfoCon.do">
					사업자 회원정보수정
				</a>
			</li>
			<li>
				<a href="<%=request.getContextPath() %>/CMemberProjNowList.do">
					사업자 진행중 프로젝트
				</a>
			</li>
			<li>
				<a href="<%=request.getContextPath() %>/CMemberProjHisList.do">
					사업자 완료된 프로젝트
				</a>
			</li>
			<li>
				<a href="<%=request.getContextPath() %>/CMemberProjApplyWrite.do">
					사업자 프로젝트 신청 
				</a>
			</li>
		</ul>
	</div>