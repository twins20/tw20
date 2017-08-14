<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<footer class="clearFix">
<!-- 푸터 -->
	<div class="fundAlert">
		<p class="fundAlertTitle">투자위험고지</p>
		<p class="fundAlertCon">비상장 기업에 대한 투자는 높은 기대수익만큼 손실가능성을 가지고 있습니다.</p>
		<p class="fundAlertCon">투자 전에 투자 위험에 대한 내용을 확인해 주세요.</p>
	</div>
	<div class="siteMap">
		<div class="subMapMain">
			<h4>MainPage</h4>
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
		<div class="subMap">
			<div class="subMap2first">
				<h4>About Us</h4>
				<ul>
					<li>
						About Us
					</li>
				</ul>
			</div>
			<div>
				<h4>Contact Us</h4>
				<ul>
					<li>
						<a href="<%=request.getContextPath() %>/NoticeList.do">
							공지사항
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
		</div>
		<div class="subMap">
			<h4>이용안내</h4>
			<ul>
				<li>
					가드닝 시작하기					
				</li>
				<li>
					이용약관
				</li>
				<li>
					개인정보 처리방침
				</li>
			</ul>
		</div>
		<div class="subMap">
			<h4></h4>
			<ul>
				<li>
				</li>
			</ul>
		</div>
		<div class="subMap">
			<h4>Members</h4>
			<ul>
				<li>
					<a href="<%=request.getContextPath() %>/MemberJoin.do">
						회원가입
					</a>
				</li>
				<li>
					<a href="<%=request.getContextPath() %>/IMemberIndexP.do">
						My Page
					</a>
				</li>
			</ul>
		</div>
	</div>
</footer>
</body>
</html>