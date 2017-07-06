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

import common.PageRedirect;
import service.CMemberServiceImpl;
import service.ItemVo;
import service.ProjectVo;

/**
 * Servlet implementation class CMemberProjApplyModServlet_Action
 */
@WebServlet("/CMemberProjApplyModServlet_Action")
public class CMemberProjApplyModServlet_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CMemberProjApplyModServlet_Action() {
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
		if(session.getAttribute("idx") != null) idx = (Integer) session.getAttribute("idx");
		
		int pIdx = 0, itListCnt = 0;
		String pName = null, contents = null, itList = "";
		
		if(request.getParameter("pIdx") != null) pIdx = Integer.parseInt(request.getParameter("pIdx").trim(),10);
		if(request.getParameter("pName") != null) pName = request.getParameter("pName").trim();
		if(request.getParameter("contents") != null) contents = request.getParameter("contents").trim();
		if(request.getParameter("itListCnt") != null) itListCnt = Integer.parseInt(request.getParameter("itListCnt").trim(),10);
				
		//테스트 변수입력 시작

//		itListCnt = 20;
		
		//테스트 변수입력 끝
		
		ItemVo[] itListArray = new ItemVo[itListCnt];
		
		for(int itCnt = 0; itCnt < itListCnt; itCnt++){
			itListArray[itCnt] = new ItemVo();
			
			if(request.getParameter("itList"+itCnt+"_itIdx") != null) itListArray[itCnt].setItIdx(Integer.parseInt(request.getParameter("itLIst"+itCnt+"_itIdx").trim(),10));
			if(request.getParameter("pIdx") != null) itListArray[itCnt].setpIdx(Integer.parseInt(request.getParameter("pIdx").trim(),10));
			if(request.getParameter("itList"+itCnt+"_itName") != null) itListArray[itCnt].setItName(request.getParameter("itLIst"+itCnt+"_itName").trim());
			if(request.getParameter("itList"+itCnt+"_itPrice") != null) itListArray[itCnt].setItPrice(Integer.parseInt(request.getParameter("itLIst"+itCnt+"_itPrice").trim(),10));
			if(request.getParameter("itList"+itCnt+"_contents") != null) itListArray[itCnt].setContents(request.getParameter("itLIst"+itCnt+"_contents").trim());
			if(request.getParameter("itList"+itCnt+"_itTCnt") != null) itListArray[itCnt].setItTCnt(Integer.parseInt(request.getParameter("itLIst"+itCnt+"_itTCnt").trim(),10));
			
			itList += "" + itListArray[itCnt].getItIdx();
			if(itCnt != itListCnt-1) itList += "|";
		}
		
		//테스트 변수입력 시작
		
//		idx = 2;
//		pIdx = 134;
//		pName = "수정 프로젝트 입력 테스트 이름";
//		contents = "수정 프로젝트 입력 테스트 컨텐츠";
//		
//		itList = "";
//		for(int testCnt = 0; testCnt < itListCnt; testCnt++){
//			itListArray[testCnt].setItIdx(testCnt+425);
//			itListArray[testCnt].setpIdx(pIdx);
//			itListArray[testCnt].setItName("테스트 수정 테스트 아이템");
//			itListArray[testCnt].setItPrice(10000 * testCnt);
//			itListArray[testCnt].setContents("테스트 수정 테스트 아이템 컨텐츠");
//			itListArray[testCnt].setItTCnt(100 * testCnt);
//			itListArray[testCnt].setStatus(1);
//			
//			itList += "" + itListArray[testCnt].getItIdx();
//			if(testCnt != itListCnt-1) itList += "|";
//		}
		
		//테스트 변수입력 끝	
		
		ProjectVo inputPV = new ProjectVo();
		inputPV.setpIdx(pIdx);
		inputPV.setpName(pName);
		inputPV.setContents(contents);
		inputPV.setItList(itList);
		inputPV.setItListCnt(itListCnt);
				
		Map<String, Object> itData = new HashMap<String, Object>();
		for(int itCnt = 0; itCnt < itListCnt; itCnt++){
			itData.put("itList"+itCnt, itListArray[itCnt]);	
		}
		
		Map<String, Object> mapData = new HashMap<String, Object>();
		mapData.put("inputPV", inputPV);
		mapData.put("itData", itData);
		
		int row = 0;
		
		CMemberServiceImpl cs = new CMemberServiceImpl();
		
		row = cs.cMemProjApplyModTransaction(mapData);
		
//		row += cs.cMemProjApplyModProj(inputPV);
//		row += cs.cMemProjApplyModItem(itData);
		
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
