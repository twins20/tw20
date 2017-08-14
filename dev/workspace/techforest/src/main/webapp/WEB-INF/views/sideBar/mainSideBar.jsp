<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<div class="sideBar">
		<ul>
			<li>
				<a href="<%=request.getContextPath()%>/ProjectListByPower.do">
					파워랭킹
				</a>
			</li>
			<li>
				<a href="<%=request.getContextPath()%>/ProjectListByTech.do">
					기술랭킹
				</a>
			</li>
			<li>
				<a href="<%=request.getContextPath()%>/ProjectListByCate.do?pCate=TECH">
					IT/TECH
				</a>
			</li>
			<li>
				<a href="<%=request.getContextPath()%>/ProjectListByCate.do?pCate=HANDMADE">
					HAND MADE
				</a>
			</li>
			<li>
				<a href="<%=request.getContextPath()%>/ProjectListByCate.do?pCate=BEAUTY">
					BEAUTY
				</a>
			</li>
			<li>
				<a href="<%=request.getContextPath()%>/ProjectListByCate.do?pCate=FOOD">
					FOOD
				</a>
			</li>
			<li>
				<a href="<%=request.getContextPath()%>/ProjectListByCate.do?pCate=FASHION">
					FASHION
				</a>
			</li>
			<li>
				<a href="<%=request.getContextPath()%>/ProjectListByCate.do?pCate=ETC">
					etc.
				</a>
			</li>
		</ul>
	</div>