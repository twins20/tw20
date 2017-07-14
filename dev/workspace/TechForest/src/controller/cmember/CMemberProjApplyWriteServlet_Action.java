package controller.cmember;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.*;
import service.*;

/**
 * Servlet implementation class CMemberProjApplyWriteServlet_Action
 */
@WebServlet("/CMemberProjApplyWriteServlet_Action")
public class CMemberProjApplyWriteServlet_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CMemberProjApplyWriteServlet_Action() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null){
			idx = (Integer) session.getAttribute("idx");
		}
		
		int itListCnt = 0, ptFunds = 0, pGrade = 0;
		String pName = null, pCate = null, contents = null;
		
		if(request.getParameter("pName") != null){
			pName = request.getParameter("pName").trim();
		}
		if(request.getParameter("pCate") != null){
			pCate = request.getParameter("pCate").trim();
		}
		if(request.getParameter("contents") != null){
			contents = request.getParameter("contents").trim();
		}
		if(request.getParameter("itListCnt") != null){
			itListCnt = Integer.parseInt(request.getParameter("itListCnt").trim(),10);
		}
		if(request.getParameter("ptFunds") != null){
			ptFunds = Integer.parseInt(request.getParameter("ptFunds").trim(),10);
		}
		if(request.getParameter("pGrade") != null){
			pGrade = Integer.parseInt(request.getParameter("pGrade").trim(),10);
		}
		
		//테스트 변수입력 시작

//		itListCnt = 20;
		
		//테스트 변수입력 끝

		ItemVo[] itListArray = new ItemVo[itListCnt];
		
		for(int itCnt = 0; itCnt < itListCnt; itCnt++){
			itListArray[itCnt] = new ItemVo();
			
			if(request.getParameter("itList"+itCnt+"_itName") != null) itListArray[itCnt].setItName(request.getParameter("itLIst"+itCnt+"_itName").trim());
			if(request.getParameter("itList"+itCnt+"_itPrice") != null) itListArray[itCnt].setItPrice(Integer.parseInt(request.getParameter("itLIst"+itCnt+"_itPrice").trim(),10));
			if(request.getParameter("itList"+itCnt+"_contents") != null) itListArray[itCnt].setContents(request.getParameter("itLIst"+itCnt+"_contents").trim());
			if(request.getParameter("itList"+itCnt+"_itTCnt") != null) itListArray[itCnt].setItTCnt(Integer.parseInt(request.getParameter("itLIst"+itCnt+"_itTCnt").trim(),10));
		}
		
		//테스트 변수입력 시작
		
//		idx = 2;
//		pName = "프로젝트 입력 테스트 이름";
//		pCate = "CATE";
//		contents = "프로젝트 입력 테스트 컨텐츠";
//		
//		ptFunds = 1000000;
//		pGrade = 5;
//		for(int testCnt = 0; testCnt < itListCnt; testCnt++){
//			itListArray[testCnt].setItName("테스트 아이템 ");
//			itListArray[testCnt].setItPrice(10000 * testCnt);
//			itListArray[testCnt].setContents("테스트 아이템 컨텐츠");
//			itListArray[testCnt].setItTCnt(100 * testCnt);
//		}
		
		//테스트 변수입력 끝	
		
		ProjectVo inputPV = new ProjectVo();
		inputPV.setIdx(idx);
		inputPV.setpName(pName);
		inputPV.setpCate(pCate);
		inputPV.setContents(contents);
		inputPV.setItListCnt(itListCnt);
		inputPV.setPtFunds(ptFunds);
		inputPV.setpGrade(pGrade);
		
		Map<String, Object> itData = new HashMap<String, Object>();
		for(int itCnt = 0; itCnt < itListCnt; itCnt++){
			itData.put("itList"+itCnt, itListArray[itCnt]);	
		}
	
		int row = 0;
		
		CMemberServiceImpl cs = new CMemberServiceImpl();
		row = cs.cMemProjApplyWriteTransaction(inputPV, itData); //트랜잭션 적용
//		row = cs.cMemProjApplyWrite(inputPV, itData);
		
//		System.out.println(row);
		
		PageRedirect pr = new PageRedirect(false, "/cmember/CMemberProjNowList.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
