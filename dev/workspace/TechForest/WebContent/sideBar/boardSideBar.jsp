<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<div class="sideBar">
		<ul>
			<li>
				<a href="<%=request.getContextPath() %>/NoticeList.do?cate=NOTICE">
					공지사항
				</a>
			</li>
			<li>
				<a href="<%=request.getContextPath() %>/NoticeList.do?cate=EVENT">
					이벤트
				</a>
			</li>
			<li>
				<a href="<%=request.getContextPath() %>/QnaWrite.do">
					QNA
				</a>
			</li>
			<li>
				<a href="<%=request.getContextPath() %>/FaqList.do">
					FAQ
				</a>
			</li>
		</ul>
	</div>