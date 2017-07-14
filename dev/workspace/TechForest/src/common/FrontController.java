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

import controller.imember.IMemberMoneyHisServlet;
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
		
		int sess_idx = 0, sess_status = 0;
		String sess_id = null, sess_type = null;
	
		HttpSession session = request.getSession();
		
		if(session.getAttribute("idx") != null) sess_idx = (Integer) session.getAttribute("idx");
		if(session.getAttribute("id") != null) sess_id = (String) session.getAttribute("id");
		if(session.getAttribute("status") != null) sess_status = (Integer) session.getAttribute("status");
		if(session.getAttribute("type") != null) sess_type = (String) session.getAttribute("type");
			
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
			
		}else if(command.equals("/ProjConCommWrite_Action.do")){
			
			this.view = "/ProjectConCommWriteServlet_Action";
			
		}else if(command.equals("/ProjConSubCommWrite_Action.do")){
			
			this.view = "/ProjectConSubCommWriteServlet_Action";
//---------------------------------------------------멤버----------------------------------------------------------//	
		}else if(command.equals("/MemberJoin.do")){
			
			this.view = "/MemberJoinServlet";
			
		}else if(command.equals("/MemberJoin_Action.do")){
			
			this.view = "/MemberJoinServlet_Action";
			
		}else if(command.equals("/MemberLogIn.do")){
			
			this.view = "/MemberLogInServlet";
			
		}else if(command.equals("/MemberLogIn_Action.do")){
			
			this.view = "/MemberLogInServlet_Action";
			
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
		}else if(command.equals("/CMemberIndexP.do")){
			
			this.view = "/CMemberIndexPServlet";
			
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
			
			this.view = "/CMemberQnaConServlet";
			
		}else if(command.equals("/CMemberQnaReplyWrite.do")){
			
			this.view = "/CMemberQnaReplyWriteServlet";
			
		}else if(command.equals("/CMemberQnaReplyWrite_Action.do")){
			
			this.view = "/CMemberQnaReplyWriteServlet_Action";
			
		}else if(command.equals("/CMemberQnaReplyMod.do")){
			
			this.view = "/CMemberQnaReplyModServlet";
			
		}else if(command.equals("/CMemberQnaReplyMod_Action.do")){
			
			this.view = "/CMemberQnaReplyModServlet_Action";
//--------------------------------------------------관리자----------------------------------------------------------//			
		}else if(command.equals("/AdminCmemChkCon.do")){

			if(sess_idx != 0 && sess_type.equals("A")){
				this.view = "/AdminCmemChkConServlet";	
			}else{
				this.view = "/pageReturnServlet";	
			}
			
//			this.view = "/AdminCmemChkConServlet";
				
		}else if(command.equals("/AdminCmemChkList.do")){
			
			if(sess_idx != 0 && sess_type.equals("A")){
				this.view = "/AdminCmemChkListServlet";	
			}else{
				this.view = "/pageReturnServlet";	
			}
			
//			this.view = "/AdminCmemChkListServlet";
			
		}else if(command.equals("/AdminCmemChkOk_Action.do")){
			
			if(sess_idx != 0 && sess_type.equals("A")){
				this.view = "/AdminCmemChkOkServlet_Action";	
			}else{
				this.view = "/pageReturnServlet";	
			}
			
//			this.view = "/AdminCmemChkOkServlet_Action";
			
		}else if(command.equals("/AdminCmemInfoCon.do")){
			
			if(sess_idx != 0 && sess_type.equals("A")){
				this.view = "/AdminCmemInfoConServlet";	
			}else{
				this.view = "/pageReturnServlet";	
			}
			
//			this.view = "/AdminCmemInfoConServlet";
			
		}else if(command.equals("/AdminCmemInfoList.do")){
			
			if(sess_idx != 0 && sess_type.equals("A")){
				this.view = "/AdminCmemInfoListServlet";	
			}else{
				this.view = "/pageReturnServlet";	
			}
			
//			this.view = "/AdminCmemInfoListServlet";
			
		}else if(command.equals("/AdminFaqCon.do")){
			
			if(sess_idx != 0 && sess_type.equals("A")){
				this.view = "/AdminFaqConServlet";	
			}else{
				this.view = "/pageReturnServlet";	
			}
			
//			this.view = "/AdminFaqConServlet";
			
		}else if(command.equals("/AdminFaqDel_Action.do")){
			
			if(sess_idx != 0 && sess_type.equals("A")){
				this.view = "/AdminFaqDelServlet_Action";	
			}else{
				this.view = "/pageReturnServlet";	
			}
			
//			this.view = "/AdminFaqDelServlet_Action";
			
		}else if(command.equals("/AdminFaqList.do")){
			
			if(sess_idx != 0 && sess_type.equals("A")){
				this.view = "/AdminFaqListServlet";	
			}else{
				this.view = "/pageReturnServlet";	
			}
			
//			this.view = "/AdminFaqListServlet";
			
		}else if(command.equals("/AdminFaqMod_Action.do")){
			
			if(sess_idx != 0 && sess_type.equals("A")){
				this.view = "/AdminFaqModServlet_Action";	
			}else{
				this.view = "/pageReturnServlet";	
			}
			
//			this.view = "/AdminFaqModServlet_Action";
			
		}else if(command.equals("/AdminFaqMod.do")){
			
			if(sess_idx != 0 && sess_type.equals("A")){
				this.view = "/AdminFaqModServlet";	
			}else{
				this.view = "/pageReturnServlet";	
			}
			
//			this.view = "/AdminFaqModServlet";
			
		}else if(command.equals("/AdminFaqWrite_Action.do")){
			
			if(sess_idx != 0 && sess_type.equals("A")){
				this.view = "/AdminFaqWriteServlet_Action";	
			}else{
				this.view = "/pageReturnServlet";	
			}
			
//			this.view = "/AdminFaqWriteServlet_Action";
			
		}else if(command.equals("/AdminFaqWrite.do")){
			
			if(sess_idx != 0 && sess_type.equals("A")){
				this.view = "/AdminFaqWriteServlet";	
			}else{
				this.view = "/pageReturnServlet";	
			}
			
//			this.view = "/AdminFaqWriteServlet";
			
		}else if(command.equals("/AdminImemInfoCon.do")){
			
			if(sess_idx != 0 && sess_type.equals("A")){
				this.view = "/AdminImemInfoConServlet";	
			}else{
				this.view = "/pageReturnServlet";	
			}
			
//			this.view = "/AdminImemInfoConServlet";
			
		}else if(command.equals("/AdminImemInfoList.do")){
			
			if(sess_idx != 0 && sess_type.equals("A")){
				this.view = "/AdminImemInfoListServlet";	
			}else{
				this.view = "/pageReturnServlet";	
			}
			
//			this.view = "/AdminImemInfoListServlet";
			
		}else if(command.equals("/AdminImemWrite_Action.do")){
			
			if(sess_idx != 0 && sess_type.equals("A")){
				this.view = "/AdminImemWriteServlet_Action";	
			}else{
				this.view = "/pageReturnServlet";	
			}
			
//			this.view = "/AdminImemWriteServlet_Action";
			
		}else if(command.equals("/AdminImemWrite.do")){
			
			if(sess_idx != 0 && sess_type.equals("A")){
				this.view = "/AdminImemWriteServlet";	
			}else{
				this.view = "/pageReturnServlet";	
			}
			
//			this.view = "/AdminImemWriteServlet";
			
		}else if(command.equals("/AdminIndex.do")){
			
			if(sess_idx != 0 && sess_type.equals("A")){
				this.view = "/AdminIndexServlet";	
			}else{
				this.view = "/pageReturnServlet";	
			}
			
//			this.view = "/AdminIndexServlet";
			
		}else if(command.equals("/AdminMemoList.do")){
			
			if(sess_idx != 0 && sess_type.equals("A")){
				this.view = "/AdminMemoListServlet";	
			}else{
				this.view = "/pageReturnServlet";	
			}
			
//			this.view = "/AdminMemoListServlet";
			
		}else if(command.equals("/AdminMemoSend_Action.do")){
			
			if(sess_idx != 0 && sess_type.equals("A")){
				this.view = "/AdminMemoSendServlet_Action";	
			}else{
				this.view = "/pageReturnServlet";	
			}
			
//			this.view = "/AdminMemoSendServlet_Action";
			
		}else if(command.equals("/AdminMemoSend.do")){
			
			if(sess_idx != 0 && sess_type.equals("A")){
				this.view = "/AdminMemoSendServlet";	
			}else{
				this.view = "/pageReturnServlet";	
			}
			
//			this.view = "/AdminMemoSendServlet";
			
		}else if(command.equals("/AdminMoneyChkNOk_Action.do")){
			
			if(sess_idx != 0 && sess_type.equals("A")){
				this.view = "/AdminMoneyChkNOkServlet_Action";	
			}else{
				this.view = "/pageReturnServlet";	
			}
			
//			this.view = "/AdminMoneyChkNOkServlet_Action";
			
		}else if(command.equals("/AdminMoneyChkOk_Action.do")){
			
			if(sess_idx != 0 && sess_type.equals("A")){
				this.view = "/AdminMoneyChkOkServlet_Action";	
			}else{
				this.view = "/pageReturnServlet";	
			}
			
//			this.view = "/AdminMoneyChkOkServlet_Action";
			
		}else if(command.equals("/AdminMoneyList.do")){
			
			if(sess_idx != 0 && sess_type.equals("A")){
				this.view = "/AdminMoneyListServlet";	
			}else{
				this.view = "/pageReturnServlet";	
			}
			
//			this.view = "/AdminMoneyListServlet";
			
		}else if(command.equals("/AdminNewsCon.do")){
			
			if(sess_idx != 0 && sess_type.equals("A")){
				this.view = "/AdminNewsConServlet";	
			}else{
				this.view = "/pageReturnServlet";	
			}
			
//			this.view = "/AdminNewsConServlet";
			
		}else if(command.equals("/AdminNewsDel_Action.do")){
			
			if(sess_idx != 0 && sess_type.equals("A")){
				this.view = "/AdminNewsDelServlet_Action";	
			}else{
				this.view = "/pageReturnServlet";	
			}
			
//			this.view = "/AdminNewsDelServlet_Action";
			
		}else if(command.equals("/AdminNewsList.do")){
			
			if(sess_idx != 0 && sess_type.equals("A")){
				this.view = "/AdminNewsListServlet";	
			}else{
				this.view = "/pageReturnServlet";	
			}
			
//			this.view = "/AdminNewsListServlet";
			
		}else if(command.equals("/AdminNewsMod_Action.do")){
			
			if(sess_idx != 0 && sess_type.equals("A")){
				this.view = "/AdminNewsModServlet_Action";	
			}else{
				this.view = "/pageReturnServlet";	
			}
			
//			this.view = "/AdminNewsModServlet_Action";
			
		}else if(command.equals("/AdminNewsMod.do")){
			
			if(sess_idx != 0 && sess_type.equals("A")){
				this.view = "/AdminNewsModServlet";	
			}else{
				this.view = "/pageReturnServlet";	
			}
			
//			this.view = "/AdminNewsModServlet";
			
		}else if(command.equals("/AdminNewsWrite_Action.do")){
			
			if(sess_idx != 0 && sess_type.equals("A")){
				this.view = "/AdminNewsWriteServlet_Action";	
			}else{
				this.view = "/pageReturnServlet";	
			}
			
			this.view = "/AdminNewsWriteServlet_Action";
			
		}else if(command.equals("/AdminNewsWrite.do")){
			
			if(sess_idx != 0 && sess_type.equals("A")){
				this.view = "/AdminNewsWriteServlet";	
			}else{
				this.view = "/pageReturnServlet";	
			}
			
//			this.view = "/AdminNewsWriteServlet";
			
		}else if(command.equals("/AdminNoticeCon.do")){
			
			if(sess_idx != 0 && sess_type.equals("A")){
				this.view = "/AdminNoticeConServlet";	
			}else{
				this.view = "/pageReturnServlet";	
			}
			
//			this.view = "/AdminNoticeConServlet";
			
		}else if(command.equals("/AdminNoticeDel_Action.do")){
			
			if(sess_idx != 0 && sess_type.equals("A")){
				this.view = "/AdminNoticeDelServlet_Action";	
			}else{
				this.view = "/pageReturnServlet";	
			}
			
//			this.view = "/AdminNoticeDelServlet_Action";
			
		}else if(command.equals("/AdminNoticeList.do")){
			
			if(sess_idx != 0 && sess_type.equals("A")){
				this.view = "/AdminNoticeListSevlet";	
			}else{
				this.view = "/pageReturnServlet";	
			}
			
//			this.view = "/AdminNoticeListSevlet";
			
		}else if(command.equals("/AdminNoticeMod_Action.do")){
			
			if(sess_idx != 0 && sess_type.equals("A")){
				this.view = "/AdminNoticeModServlet_Action";	
			}else{
				this.view = "/pageReturnServlet";	
			}
			
//			this.view = "/AdminNoticeModServlet_Action";
			
		}else if(command.equals("/AdminNoticeMod.do")){
			
			if(sess_idx != 0 && sess_type.equals("A")){
				this.view = "/AdminNoticeModServlet";	
			}else{
				this.view = "/pageReturnServlet";	
			}
			
//			this.view = "/AdminNoticeModServlet";
			
		}else if(command.equals("/AdminNoticeWrite_Action.do")){
			
			if(sess_idx != 0 && sess_type.equals("A")){
				this.view = "/AdminNoticeWriteServlet_Action";	
			}else{
				this.view = "/pageReturnServlet";	
			}
			
//			this.view = "/AdminNoticeWriteServlet_Action";
			
		}else if(command.equals("/AdminNoticeWrite.do")){
			
			if(sess_idx != 0 && sess_type.equals("A")){
				this.view = "/AdminNoticeWriteServlet";	
			}else{
				this.view = "/pageReturnServlet";	
			}
			
//			this.view = "/AdminNoticeWriteServlet";
			
		}else if(command.equals("/AdminProjChkCon.do")){
			
			if(sess_idx != 0 && sess_type.equals("A")){
				this.view = "/AdminProjChkConServlet";	
			}else{
				this.view = "/pageReturnServlet";	
			}
			
//			this.view = "/AdminProjChkConServlet";
			
		}else if(command.equals("/AdminProjChkList.do")){
			
			if(sess_idx != 0 && sess_type.equals("A")){
				this.view = "/AdminProjChkListServlet";	
			}else{
				this.view = "/pageReturnServlet";	
			}
			
//			this.view = "/AdminProjChkListServlet";
			
		}else if(command.equals("/AdminProjChkOk_Action.do")){
			
			if(sess_idx != 0 && sess_type.equals("A")){
				this.view = "/AdminProjChkOkServlet_Action";	
			}else{
				this.view = "/pageReturnServlet";	
			}
			
//			this.view = "/AdminProjChkOkServlet_Action";
			
		}else if(command.equals("/AdminProjChkNOk_Action.do")){
			
			if(sess_idx != 0 && sess_type.equals("A")){
				this.view = "/AdminProjChkNOkServlet_Action";	
			}else{
				this.view = "/pageReturnServlet";	
			}
			
//			this.view = "/AdminProjChkNOkServlet_Action";
			
		}else if(command.equals("/AdminQnaCon.do")){
			
			if(sess_idx != 0 && sess_type.equals("A")){
				this.view = "/AdminQnaConServlet";	
			}else{
				this.view = "/pageReturnServlet";	
			}
			
//			this.view = "/AdminQnaConServlet";
			
		}else if(command.equals("/AdminQnaDel_Action.do")){
			
			if(sess_idx != 0 && sess_type.equals("A")){
				this.view = "/AdminQnaDelServlet_Action";	
			}else{
				this.view = "/pageReturnServlet";	
			}
			
//			this.view = "/AdminQnaDelServlet_Action";
			
		}else if(command.equals("/AdminQnaList.do")){
			
			if(sess_idx != 0 && sess_type.equals("A")){
				this.view = "/AdminQnaListServlet";	
			}else{
				this.view = "/pageReturnServlet";	
			}
			
//			this.view = "/AdminQnaListServlet";
			
		}else if(command.equals("/AdminQnaMod_Action.do")){
			
			if(sess_idx != 0 && sess_type.equals("A")){
				this.view = "/AdminQnaModServlet_Action";	
			}else{
				this.view = "/pageReturnServlet";	
			}
			
//			this.view = "/AdminQnaModServlet_Action";
			
		}else if(command.equals("/AdminQnaMod.do")){
			
			if(sess_idx != 0 && sess_type.equals("A")){
				this.view = "/AdminQnaModServlet";	
			}else{
				this.view = "/pageReturnServlet";	
			}
			
//			this.view = "/AdminQnaModServlet";
			
		}else if(command.equals("/AdminQnaWrite_Action.do")){
			
			if(sess_idx != 0 && sess_type.equals("A")){
				this.view = "/AdminQnaWriteServlet_Action";	
			}else{
				this.view = "/pageReturnServlet";	
			}
			
//			this.view = "/AdminQnaWriteServlet_Action";
			
		}else if(command.equals("/AdminQnaWrite.do")){
			
			if(sess_idx != 0 && sess_type.equals("A")){
				this.view = "/AdminQnaWriteServlet";	
			}else{
				this.view = "/pageReturnServlet";	
			}
			
//			this.view = "/AdminQnaWriteServlet";
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
		}else if(command.equals("/NewsList.do")){ 
				
			this.view = "/NewsListServlet";
		
		}else if(command.equals("/NewsCon.do")){
			
			this.view = "/NewsConServlet";
		
		}else if(command.equals("/NewsWrite.do")){
			
			this.view = "/NewsWriteServlet";
		
		}else if(command.equals("/NewsWrite_Action.do")){
			
			this.view = "/NewsWriteServlet_Action";	
			
		}else if(command.equals("/NewsMod.do")){
			
			this.view = "/NewsModServlet";
			
		}else if(command.equals("/NewsMod_Action.do")){
			
			this.view = "/NewsModServlet_Action";
			
		}else if(command.equals("/NewsDel_Action.do")){
			
			this.view = "/NewsDelServlet_Action";	
			
		}else if(command.equals("/NewsCommWrite_Action.do")){

			if(sess_idx != 0 ){				
				this.view = "/NewsCommWriteServlet_Action";					
			}else{
				this.view = "/pageReturnLogInServlet";	
			}			
			
//			this.view = "/NewsCommWriteServlet_Action";
		
		}else if(command.equals("/NewsCommMod_Action.do")){
			
			if(sess_idx != 0 ){				
				this.view = "/NewsCommModServlet_Action";					
			}else{
				this.view = "/pageReturnLogInServlet";	
			}			
								
//			this.view = "/NewsCommModServlet_Action";
		
		}else if(command.equals("/NewsCommDel_Action.do")){

			if(sess_idx != 0 ){				
				this.view = "/NewsCommDelServlet_Action";					
			}else{
				this.view = "/pageReturnLogInServlet";	
			}			
			
//			this.view = "/NewsCommDelServlet_Action";
		
		}else if(command.equals("/NewsCommSubWrite_Action.do")){ 

			if(sess_idx != 0 ){				
				this.view = "/NewsCommSubWriteServlet_Action";					
			}else{
				this.view = "/pageReturnLogInServlet";	
			}			
			
//			this.view = "/NewsCommSubWriteServlet_Action";
			
		}else if(command.equals("/NewsCommSubMod_Action.do")){ 
			
			if(sess_idx != 0 ){				
				this.view = "/NewsCommSubModServlet_Action";					
			}else{
				this.view = "/pageReturnLogInServlet";	
			}				
			
//			this.view = "/NewsCommSubModServlet_Action";
				
		}else if(command.equals("/NewsCommSubDel_Action.do")){

			if(sess_idx != 0 ){				
				this.view = "/NewsCommSubDelServlet_Action";					
			}else{
				this.view = "/pageReturnLogInServlet";	
			}			
					
//			this.view = "/NewsCommSubDelServlet_Action";
					
		}else if(command.equals("/NewsConGoodBad_Action.do")){ 
			
			if(sess_idx != 0 ){				
				this.view = "/NewsConGoodBadServlet_Action";					
			}else{
				this.view = "/pageReturnLogInServlet";	
			}			
						
//			this.view = "/NewsConGoodBadServlet_Action";	
			
//---------------------------------------------------QNA----------------------------------------------------------//		
		}else if(command.equals("/QnaList.do")){
			
			this.view = "/QnaListServlet";
			
		}else if(command.equals("/QnaCon.do")){
			
			this.view = "/QnaConServlet";
			
		}else if(command.equals("/QnaWrite.do")){
			
			if(sess_idx != 0 ){				
				this.view = "/QnaWriteServlet";					
			}else{
				this.view = "/pageReturnLogInServlet";	
			}			
			
//			this.view = "/QnaWriteServlet";
		
		}else if(command.equals("/QnaWrite_Action.do")){
			
			this.view = "/QnaWriteServlet_Action";	
			
		}else if(command.equals("/QnaMod.do")){
			
			this.view = "/QnaModServlet";
			
		}else if(command.equals("/QnaMod_Action.do")){
			
			this.view = "/QnaModServlet_Action";
			
		}else if(command.equals("/QnaDel_Action.do")){
			
			this.view = "/QnaDelServlet_Action";

		}else if(command.equals("/QnaCommWrite_Action.do")){

			if(sess_idx != 0 ){				
				this.view = "/QnaCommWriteServlet_Action";					
			}else{
				this.view = "/pageReturnLogInServlet";	
			}			
			
//			this.view = "/QnaCommWriteServlet_Action";
		
		}else if(command.equals("/QnaCommMod_Action.do")){
			
			if(sess_idx != 0 ){				
				this.view = "/QnaCommModServlet_Action";					
			}else{
				this.view = "/pageReturnLogInServlet";	
			}			
								
//			this.view = "/QnaCommModServlet_Action";
		
		}else if(command.equals("/QnaCommDel_Action.do")){

			if(sess_idx != 0 ){				
				this.view = "/QnaCommDelServlet_Action";					
			}else{
				this.view = "/pageReturnLogInServlet";	
			}			
			
//			this.view = "/QnaCommDelServlet_Action";
		
		}else if(command.equals("/QnaCommSubWrite_Action.do")){ 

			if(sess_idx != 0 ){				
				this.view = "/QnaCommSubWriteServlet_Action";					
			}else{
				this.view = "/pageReturnLogInServlet";	
			}			
			
//			this.view = "/QnaCommSubWriteServlet_Action";
			
		}else if(command.equals("/QnaCommSubMod_Action.do")){ 
			
			if(sess_idx != 0 ){				
				this.view = "/QnaCommSubModServlet_Action";					
			}else{
				this.view = "/pageReturnLogInServlet";	
			}				
			
//			this.view = "/QnaCommSubModServlet_Action";
				
		}else if(command.equals("/QnaCommSubDel_Action.do")){

			if(sess_idx != 0 ){				
				this.view = "/QnaCommSubDelServlet_Action";					
			}else{
				this.view = "/pageReturnLogInServlet";	
			}			
					
//			this.view = "/QnaCommSubDelServlet_Action";
					
		}else if(command.equals("/QnaConGoodBad_Action.do")){ 
			
			if(sess_idx != 0 ){				
				this.view = "/QnaConGoodBadServlet_Action";					
			}else{
				this.view = "/pageReturnLogInServlet";	
			}			
						
//			this.view = "/QnaConGoodBadServlet_Action";				
//--------------------------------------------------공지사항--------------------------------------------------------//		
		}else if(command.equals("/NoticeList.do")){
			
			this.view = "/NoticeListServlet";
		
		}else if(command.equals("/NoticeCon.do")){
			
			this.view = "/NoticeConServlet";
			
		}else if(command.equals("/NoticeWrite.do")){
			
			this.view = "/NoticeWriteServlet";
		
		}else if(command.equals("/NoticeWrite_Action.do")){
			
			this.view = "/NoticeWriteServlet_Action";	
			
		}else if(command.equals("/NoticeMod.do")){
			
			this.view = "/NoticeModServlet";
			
		}else if(command.equals("/NoticeMod_Action.do")){
			
			this.view = "/NoticeModServlet_Action";
			
		}else if(command.equals("/NoticeDel_Action.do")){
			
			this.view = "/NoticeDelServlet_Action";	
			
		}else if(command.equals("/NoticeCommWrite_Action.do")){

			if(sess_idx != 0 ){				
				this.view = "/NoticeCommWriteServlet_Action";					
			}else{
				this.view = "/pageReturnLogInServlet";	
			}			
			
//			this.view = "/NoticeCommWriteServlet_Action";
		
		}else if(command.equals("/NoticeCommMod_Action.do")){
			
			if(sess_idx != 0 ){				
				this.view = "/NoticeCommModServlet_Action";					
			}else{
				this.view = "/pageReturnLogInServlet";	
			}			
								
//			this.view = "/NoticeCommModServlet_Action";
		
		}else if(command.equals("/NoticeCommDel_Action.do")){

			if(sess_idx != 0 ){				
				this.view = "/NoticeCommDelServlet_Action";					
			}else{
				this.view = "/pageReturnLogInServlet";	
			}			
			
//			this.view = "/NoticeCommDelServlet_Action";
		
		}else if(command.equals("/NoticeCommSubWrite_Action.do")){ 

			if(sess_idx != 0 ){				
				this.view = "/NoticeCommSubWriteServlet_Action";					
			}else{
				this.view = "/pageReturnLogInServlet";	
			}			
			
//			this.view = "/NoticeCommSubWriteServlet_Action";
			
		}else if(command.equals("/NoticeCommSubMod_Action.do")){ 
			
			if(sess_idx != 0 ){				
				this.view = "/NoticeCommSubModServlet_Action";					
			}else{
				this.view = "/pageReturnLogInServlet";	
			}				
			
//			this.view = "/NoticeCommSubModServlet_Action";
				
		}else if(command.equals("/NoticeCommSubDel_Action.do")){

			if(sess_idx != 0 ){				
				this.view = "/NoticeCommSubDelServlet_Action";					
			}else{
				this.view = "/pageReturnLogInServlet";	
			}			
					
//			this.view = "/NoticeCommSubDelServlet_Action";
					
		}else if(command.equals("/NoticeConGoodBad_Action.do")){ 
			
			if(sess_idx != 0 ){				
				this.view = "/NoticeConGoodBadServlet_Action";					
			}else{
				this.view = "/pageReturnLogInServlet";	
			}			
						
//			this.view = "/NoticeConGoodBadServlet_Action";				
//---------------------------------------------------FAQ----------------------------------------------------------//			
		}else if(command.equals("/FaqList.do")){
			
			this.view = "/FaqListServlet";
			
		}else if(command.equals("/FaqCon.do")){
			
			this.view = "/FaqConServlet";
			
		}else if(command.equals("/FaqWrite.do")){
			
			this.view = "/FaqWriteServlet";
		
		}else if(command.equals("/FaqWrite_Action.do")){
			
			this.view = "/FaqWriteServlet_Action";	
			
		}else if(command.equals("/FaqMod.do")){
			
			this.view = "/FaqModServlet";
			
		}else if(command.equals("/FaqMod_Action.do")){
			
			this.view = "/FaqModServlet_Action";
			
		}else if(command.equals("/FaqDel_Action.do")){
			
			this.view = "/FaqDelServlet_Action";	
			
		}else if(command.equals("/FaqCommWrite_Action.do")){

			if(sess_idx != 0 ){				
				this.view = "/FaqCommWriteServlet_Action";					
			}else{
				this.view = "/pageReturnLogInServlet";	
			}			
			
//			this.view = "/FaqCommWriteServlet_Action";
		
		}else if(command.equals("/FaqCommMod_Action.do")){
			
			if(sess_idx != 0 ){				
				this.view = "/FaqCommModServlet_Action";					
			}else{
				this.view = "/pageReturnLogInServlet";	
			}			
								
//			this.view = "/FaqCommModServlet_Action";
		
		}else if(command.equals("/FaqCommDel_Action.do")){

			if(sess_idx != 0 ){				
				this.view = "/FaqCommDelServlet_Action";					
			}else{
				this.view = "/pageReturnLogInServlet";	
			}			
			
//			this.view = "/FaqCommDelServlet_Action";
		
		}else if(command.equals("/FaqCommSubWrite_Action.do")){ 

			if(sess_idx != 0 ){				
				this.view = "/FaqCommSubWriteServlet_Action";					
			}else{
				this.view = "/pageReturnLogInServlet";	
			}			
			
//			this.view = "/FaqCommSubWriteServlet_Action";
			
		}else if(command.equals("/FaqCommSubMod_Action.do")){ 
			
			if(sess_idx != 0 ){				
				this.view = "/FaqCommSubModServlet_Action";					
			}else{
				this.view = "/pageReturnLogInServlet";	
			}				
			
//			this.view = "/FaqCommSubModServlet_Action";
				
		}else if(command.equals("/FaqCommSubDel_Action.do")){

			if(sess_idx != 0 ){				
				this.view = "/FaqCommSubDelServlet_Action";					
			}else{
				this.view = "/pageReturnLogInServlet";	
			}			
					
//			this.view = "/FaqCommSubDelServlet_Action";
					
		}else if(command.equals("/FaqConGoodBad_Action.do")){ 
			
			if(sess_idx != 0 ){				
				this.view = "/FaqConGoodBadServlet_Action";					
			}else{
				this.view = "/pageReturnLogInServlet";	
			}			
						
//			this.view = "/FaqConGoodBadServlet_Action";					
		}

		
		PageRedirect pr = new PageRedirect(false, view, request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response); 		
	}
	
}
