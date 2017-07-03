package common;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.project.*;
import service.*;

@WebServlet("*.do")	
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;	
	private String view = null;	
	
	
    public FrontController() {
        super();      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=UTF-8");
		
		String uri = request.getRequestURI();					
		String contextPath = request.getContextPath();			
		String command = uri.substring(contextPath.length());
		
//		HttpSession session = request.getSession();
//		int idx = (Integer) session.getAttribute("idx");
//		int id = (Integer) session.getAttribute("id");
//		int status = (Integer) session.getAttribute("status");
//		int type = (Integer) session.getAttribute("type");
//		System.out.println(idx);
//		System.out.println(id);
//		System.out.println(status);
//		System.out.println(type);
			
//			ProjectListByCateServlet ps = new ProjectListByCateServlet();
//			ps.doPost(request, response);

//			this.isRedirect = false;
//			this.view = "/project/ProjectListByCate.jsp";
//--------------------------------------------------인덱스---------------------------------------------------------//
		if(command.equals("/index.do")){ 
			
			this.view = "/indexServlet";
//--------------------------------------------------프로젝트--------------------------------------------------------//
		}else if(command.equals("/ProjListByCate.do")){ 
			
			this.view = "/ProjectListByCateServlet";
			
		}else if(command.equals("/ProjListByPower.do")){
			
			this.view = "/ProjectListByPowerServlet";
			
		}else if(command.equals("/ProjListByTech.do")){
			
			this.view = "/ProjectListByTechServlet";
			
		}else if(command.equals("/ProjCon.do")){
			
			this.view = "/ProjectConServlet";
			
		}else if(command.equals("/ProjPay.do")){
			
			this.view = "/ProjectPayServlet";
			
		}else if(command.equals("/ProjectConCommWrite_Action.do")){
			
			this.view = "/ProjectConCommWriteServlet_Action";
			
		}else if(command.equals("/ProjectConSubCommWrite_Action.do")){
			
			this.view = "/ProjectConSubCommWriteServlet_Action";
//---------------------------------------------------멤버----------------------------------------------------------//	
		}else if(command.equals("/MemberJoin.do")){
			
			this.view = "/MemberJoinServlet";
			
		}else if(command.equals("/MemberJoin_Action.do")){
			
			this.view = "/MemberJoinServlet_Action";
			
		}else if(command.equals("/MemberLogIn.do")){
			
			this.view = "/MemberLogInServlet";
			
		}else if(command.equals("/MemberLogIn_Action.do")){
			
			this.view = "/MemberLoginServlet_Action";
			
		}else if(command.equals("/MemberLogOut_Action.do")){
			
			this.view = "/MemberLogOutServlet_Action";
			
		}else if(command.equals("/MemberFindMail.do")){
			
			this.view = "/MemberFindMailServlet";
			
		}else if(command.equals("/MemberFindMail_Action.do")){
			
			this.view = "/MemberFindMailServlet_Action";
			
		}else if(command.equals("/MemberFindPass.do")){
			
			this.view = "/MemberFindPassServlet";
			
		}else if(command.equals("/MemberFindPass_Action.do")){
			
			this.view = "/MemberFindPassServlet_Action";
			
		}else if(command.equals("/MemberMemoList.do")){
			
			this.view = "/MemberMemoListServlet";
			
		}else if(command.equals("/MemberMemoCon.do")){
			
			this.view = "/MemberMemoConServlet";
			
		}else if(command.equals("/MemberMemoDel_Action.do")){
			
			this.view = "/MemberMemoDelServlet_Action";
//--------------------------------------------------사업자----------------------------------------------------------//			
		}else if(command.equals("/CMemberIndex.do")){
			
			this.view = "/CMemberIndexServlet";
			
		}else if(command.equals("/CMemberInfoCon.do")){
			
			this.view = "/CMemberInfoConServlet";
			
		}else if(command.equals("/CMemberInfoMod.do")){
			
			this.view = "/CMemberInfoModServlet";
			
		}else if(command.equals("/CMemberInfoMod_Action.do")){
			
			this.view = "/CMemberInfoModServlet_Action";
			
		}else if(command.equals("/CMemberInfoExtWrite.do")){
			
			this.view = "/CMemberInfoExtWriteServlet";
			
		}else if(command.equals("/CMemberInfoExtWrite_Action.do")){
			
			this.view = "/CMemberInfoExtWriteServlet_Action";
			
		}else if(command.equals("/CMemberMemoWrite.do")){
			
			this.view = "/CMemberMemoWriteServlet";
			
		}else if(command.equals("/CMemberMemoWrite_Action.do")){
			
			this.view = "/CMemberMemoWriteServlet_Action";
			
		}else if(command.equals("/CMemberMemoSendList.do")){
			
			this.view = "/CMemberMemoSendListServlet";
			
		}else if(command.equals("/CMemberMemoDel_Action.do")){
			
			this.view = "/CMemberMemoDelServlet_Action";
			
		}else if(command.equals("/CMemberNewsList.do")){
			
			this.view = "/CMemberNewsListServlet";
			
		}else if(command.equals("/CMemberNewsCon.do")){
			
			this.view = "/CMemberNewsConServlet";
			
		}else if(command.equals("/CMemberMemoDel_Action.do")){
			
			this.view = "/CMemberMemoDelServlet_Action";
			
		}else if(command.equals("/CMemberNewsMod.do")){
			
			this.view = "/CMemberNewsModServlet";
			
		}else if(command.equals("/CMemberNewsMod.do")){
			
			this.view = "/CMemberNewsModServlet";
			
		}else if(command.equals("/CMemberNewsMod_Action.do")){
			
			this.view = "/CMemberNewsModServlet_Action";
			
		}else if(command.equals("/CMemberNewsWrite.do")){
			
			this.view = "/CMemberNewsWriteServlet";
			
		}else if(command.equals("/CMemberNewsWrite_Action.do")){
			
			this.view = "/CMemberNewsWriteServlet_Action";
			
		}else if(command.equals("/CMemberNewsDel_Action.do")){
			
			this.view = "/CMemberNewsDelServlet_Action";
			
		}else if(command.equals("/CMemberProjNowList.do")){
			
			this.view = "/CMemberProjNowListServlet";
			
		}else if(command.equals("/CMemberProjHisList.do")){
			
			this.view = "/CMemberProjHisListServlet";
			
		}else if(command.equals("/CMemberProjApplyWrite.do")){
			
			this.view = "/CMemberProjApplyWriteServlet";
			
		}else if(command.equals("/CMemberProjApplyWrite_Action.do")){
			
			this.view = "/CMemberProjApplyWriteServlet_Action";
			
		}else if(command.equals("/CMemberProjApplyCon.do")){
			
			this.view = "/CMemberProjApplyConServlet";
			
		}else if(command.equals("/CMemberProjApplyItemPlus.do")){
			
			this.view = "/CMemberProjApplyItemPlusServlet";
			
		}else if(command.equals("/CMemberProjApplyItemPlus_Action.do")){
			
			this.view = "/CMemberProjApplyItemPlusServlet_Action";
			
		}else if(command.equals("/CMemberQnaList.do")){
			
			this.view = "/CMemberQnaListServlet";
			
		}else if(command.equals("/CMemberQnaCon.do")){
			
			this.view = "/CMemberQnaCon/CMemberQnaList";
			
		}else if(command.equals("/CMemberQnaReplyWrite.do")){
			
			this.view = "/CMemberQnaReplyWriteServlet";
			
		}else if(command.equals("/CMemberQnaReplyWrite_Action.do")){
			
			this.view = "/CMemberQnaReplyWriteServlet";
			
		}else if(command.equals("/CMemberQnaReplyMod.do")){
			
			this.view = "/CMemberQnaReplyModServlet";
			
		}else if(command.equals("/CMemberQnaReplyMod_Action.do")){
			
			this.view = "/CMemberQnaReplyModServlet_Action";
//--------------------------------------------------관리자----------------------------------------------------------//			
		}else if(command.equals("/AdminCmemChkCon.do")){

			this.view = "/AdminCmemChkConServlet";
		
		}else if(command.equals("/AdminCmemChkList.do")){
			
			this.view = "/AdminCmemChkListServlet";
			
		}else if(command.equals("/AdminCmemChkOk_Action.do")){
			
			this.view = "/AdminCmemChkOkServlet_Action";
			
		}else if(command.equals("/AdminCmemInfoCon.do")){
			
			this.view = "/AdminCmemInfoConServlet";
			
		}else if(command.equals("/AdminCmemInfoList.do")){
			
			this.view = "/AdminCmemInfoListServlet";
			
		}else if(command.equals("/AdminFaqCon.do")){
			
			this.view = "/AdminFaqConServlet";
			
		}else if(command.equals("/AdminFaqDel_Action.do")){
			
			this.view = "/AdminFaqDelServlet_Action";
			
		}else if(command.equals("/AdminFaqList.do")){
			
			this.view = "/AdminFaqListServlet";
			
		}else if(command.equals("/AdminFaqMod_Action.do")){
			
			this.view = "/AdminFaqModServlet_Action";
			
		}else if(command.equals("/AdminFaqMod.do")){
			
			this.view = "/AdminFaqModServlet";
			
		}else if(command.equals("/AdminFaqWrite_Action.do")){
			
			this.view = "/AdminFaqWriteServlet_Action";
			
		}else if(command.equals("/AdminFaqWrite.do")){
			
			this.view = "/AdminFaqWriteServlet";
			
		}else if(command.equals("/AdminImemInfoCon.do")){
			
			this.view = "/AdminImemInfoConServlet";
			
		}else if(command.equals("/AdminImemInfoList.do")){
			
			this.view = "/AdminImemInfoListServlet";
			
		}else if(command.equals("/AdminImemWrite_Action.do")){
			
			this.view = "/AdminImemWriteServlet_Action";
			
		}else if(command.equals("/AdminImemWrite.do")){
			
			this.view = "/AdminImemWriteServlet";
			
		}else if(command.equals("/AdminIndex.do")){
			
			this.view = "/AdminIndexServlet";
			
		}else if(command.equals("/AdminMemoList.do")){
			
			this.view = "/AdminMemoListServlet";
			
		}else if(command.equals("/AdminMemoSend_Action.do")){
			
			this.view = "/AdminMemoSendServlet_Action";
			
		}else if(command.equals("/AdminMemoSend.do")){
			
			this.view = "/AdminMemoSendServlet";
			
		}else if(command.equals("/AdminMoneyChkNOk_Action.do")){
			
			this.view = "/AdminMoneyChkNOkServlet_Action";
			
		}else if(command.equals("/AdminMoneyChkOk_Action.do")){
			
			this.view = "/AdminMoneyChkOkServlet_Action";
			
		}else if(command.equals("/AdminMoneyList.do")){
			
			this.view = "/AdminMoneyListServlet";
			
		}else if(command.equals("/AdminNewsCon.do")){
			
			this.view = "/AdminNewsConServlet";
			
		}else if(command.equals("/AdminNewsDel_Action.do")){
			
			this.view = "/AdminNewsDelServlet_Action";
			
		}else if(command.equals("/AdminNewsList.do")){
			
			this.view = "/AdminNewsListServlet";
			
		}else if(command.equals("/AdminNewsMod_Action.do")){
			
			this.view = "/AdminNewsModServlet_Action";
			
		}else if(command.equals("/AdminNewsMod.do")){
			
			this.view = "/AdminNewsModServlet";
			
		}else if(command.equals("/AdminNewsWrite_Action.do")){
			
			this.view = "/AdminNewsWriteServlet_Action";
			
		}else if(command.equals("/AdminNewsWrite.do")){
			
			this.view = "/AdminNewsWriteServlet";
			
		}else if(command.equals("/AdminNoticeCon.do")){
			
			this.view = "/AdminNoticeConServlet";
			
		}else if(command.equals("/AdminNoticeDel_Action.do")){
			
			this.view = "/AdminNoticeDelServlet_Action";
			
		}else if(command.equals("/AdminNoticeList.do")){
			
			this.view = "/AdminNoticeListSevlet";
			
		}else if(command.equals("/AdminNoticeMod_Action.do")){
			
			this.view = "/AdminNoticeModServlet_Action";
			
		}else if(command.equals("/AdminNoticeMod.do")){
			
			this.view = "/AdminNoticeModServlet";
			
		}else if(command.equals("/AdminNoticeWrite_Action.do")){
			
			this.view = "/AdminNoticeWriteServlet_Action";
			
		}else if(command.equals("/AdminNoticeWrite.do")){
			
			this.view = "/AdminNoticeWriteServlet";
			
		}else if(command.equals("/AdminProjChkCon.do")){
			
			this.view = "/AdminProjChkConServlet";
			
		}else if(command.equals("/AdminProjChkList.do")){
			
			this.view = "/AdminProjChkListServlet";
			
		}else if(command.equals("/AdminProjChkOk_Action.do")){
			
			this.view = "/AdminProjChkOkServlet_Action";
			
		}else if(command.equals("/AdminQnaCon.do")){
			
			this.view = "/AdminQnaConServlet";
			
		}else if(command.equals("/AdminQnaDel_Action.do")){
			
			this.view = "/AdminQnaDelServlet_Action";
			
		}else if(command.equals("/AdminQnaList.do")){
			
			this.view = "/AdminQnaListServlet";
			
		}else if(command.equals("/AdminQnaMod_Action.do")){
			
			this.view = "/AdminQnaModServlet_Action";
			
		}else if(command.equals("/AdminQnaMod.do")){
			
			this.view = "/AdminQnaModServlet";
			
		}else if(command.equals("/AdminQnaWrite_Action.do")){
			
			this.view = "/AdminQnaWriteServlet_Action";
			
		}else if(command.equals("/AdminQnaWrite.do")){
			
			this.view = "/AdminQnaWriteServlet";
//--------------------------------------------------투자자----------------------------------------------------------//		
		}else if(command.equals("/IMemberFundList.do")){
			
			this.view = "/IMemberFundListServlet";
			
		}else if(command.equals("/IMemberIndexP.do")){
			
			this.view = "/IMemberIndexPServlet";
			
		}else if(command.equals("/IMemberInfoCon.do")){
			
			this.view = "/IMemberInfoConServlet";
		
		}else if(command.equals("/IMemberInfoConPw.do")){
				
			this.view = "/IMemberInfoConPwServlet";
					
		}else if(command.equals("/IMemberInfoMod.do")){
			
			this.view = "/IMemberInfoModServlet";
		
		}else if(command.equals("/IMemberInfoMod_Action.do")){
				
			this.view = "/IMemberInfoModServlet_Action";
				
		}else if(command.equals("/IMemberMoneyCharge_Action.do")){
			
			this.view = "/IMemberMoneyChargeServlet_Action";
			
		}else if(command.equals("/IMemberMoneyHis.do")){
			
			this.view = "/IMemberMoneyHisServlet";
			
		}else if(command.equals("/IMemberWishList.do")){
			
			this.view = "/IMemberWishListServlet";
			
		}else if(command.equals("/IMemberWishListDel_Action.do")){
			
			this.view = "/IMemberWishListDelServlet_Action";
//---------------------------------------------------뉴스----------------------------------------------------------//		
		}else if(command.equals("/NewsListServlet.do")){ 
				
			this.view = "/NewsListServlet";
		
		}else if(command.equals("/NewsConServlet.do")){
			
			this.view = "/NewsConServlet";
		
		}else if(command.equals("/NewsCommWriteServlet_Action.do")){
			
			this.view = "/NewsCommWriteServlet_Action";
		
		}else if(command.equals("/NewsCommModServlet_Action.do")){
			
			this.view = "/NewsCommModServlet_Action";
		
		}else if(command.equals("/NewsCommDelServlet_Action.do")){
			
			this.view = "/NewsCommDelServlet_Action";
		
		}else if(command.equals("/NewsSubCommWriteServlet.do")){
			
			this.view = "/NewsSubCommWriteServlet_Action";
//---------------------------------------------------QNA----------------------------------------------------------//		
		}else if(command.equals("/QnaListServlet.do")){
			
			this.view = "/QnaListServlet";
			
		}else if(command.equals("/QnaConServlet.do")){
			
			this.view = "/QnaConServlet";
			
		}else if(command.equals("/QnaWriteServlet_Action.do")){
			
			this.view = "/QnaWriteServlet";
			
		}else if(command.equals("/QnaModServlet_Action.do")){
			
			this.view = "/QnaModServlet_Action";
			
		}else if(command.equals("/QnaDelServlet_Action.do")){
			
			this.view = "/QnaDelServlet_Action";
//--------------------------------------------------공지사항--------------------------------------------------------//		
		}else if(command.equals("/NoticeListServlet.do")){
			
			this.view = "/NoticeListServlet";
		
		}else if(command.equals("/NoticeConServlet.do")){
			
			this.view = "/NoticeConServlet";
//---------------------------------------------------FAQ----------------------------------------------------------//			
		}else if(command.equals("/FaqListServlet.do")){
			
			this.view = "/FaqListServlet";
			
		}else if(command.equals("/FaqConServlet.do")){
			
			this.view = "/FaqConServlet";
			
		}
		
		PageRedirect pr = new PageRedirect(false, view, request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response); 		
	}
	
}
