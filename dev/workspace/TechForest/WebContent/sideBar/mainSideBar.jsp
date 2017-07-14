<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<div class="sideBar">
		<ul>
			<li>
				<a href="<%=request.getContextPath()%>/ProjListByPower.do">
					파워랭킹
				</a>
			</li>
			<li>
				<a href="<%=request.getContextPath()%>/ProjListByTech.do">
					기술랭킹
				</a>
			</li>
			<li>
				<a href="<%=request.getContextPath()%>/ProjListByCate.do?pCate=TECH">
					IT/TECH
				</a>
			</li>
			<li>
				<a href="<%=request.getContextPath()%>/ProjListByCate.do?pCate=HANDMADE">
					HAND MADE
				</a>
			</li>
			<li>
				<a href="<%=request.getContextPath()%>/ProjListByCate.do?pCate=BEAUTY">
					BEAUTY
				</a>
			</li>
			<li>
				<a href="<%=request.getContextPath()%>/ProjListByCate.do?pCate=FOOD">
					FOOD
				</a>
			</li>
			<li>
				<a href="<%=request.getContextPath()%>/ProjListByCate.do?pCate=FASHION">
					FASHION
				</a>
			</li>
			<li>
				<a href="<%=request.getContextPath()%>/ProjListByCate.do?pCate=ETC">
					etc.
				</a>
			</li>
		</ul>
	</div>