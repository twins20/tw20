<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<div class="sideBar">
		<ul>
			<li>
				<a href="<%=request.getContextPath()%>/IMemberIndexP.do">
					마이페이지
				</a>
			</li>
			<li>
				<a href="<%=request.getContextPath()%>/IMemberInfoCon.do">
					회원정보수정
				</a>
			</li>
			<li>
				<a href="<%=request.getContextPath()%>/IMemberMoneyHis.do">
					충전 및 금액조회
				</a>	
			</li>
			<li>
				<a href="<%=request.getContextPath()%>/IMemberFundList.do">
					투자리스트
				</a>
			</li>
			<li>
				<a href="<%=request.getContextPath()%>/IMemberWishList.do">
					위시리스트
				</a>
			</li>
			<li>
				<a href="<%=request.getContextPath()%>/MemberMemoList.do">
					메모리스트
				</a>
			</li>
		</ul>
	</div>