package controller.cmember;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.*;
import service.*;

/**
 * Servlet implementation class CMemberProjApplyItemPlusServlet_Action
 */
@WebServlet("/CMemberProjApplyItemPlusServlet_Action")
public class CMemberProjApplyItemPlusServlet_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CMemberProjApplyItemPlusServlet_Action() {
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
		
		int pIdx = 0, itListCnt = 0;
			
		if(request.getParameter("pIdx") != null){
			pIdx = Integer.parseInt(request.getParameter("pIdx").trim(),10);
		}
		if(request.getParameter("itListCnt") != null){
			itListCnt = Integer.parseInt(request.getParameter("itListCnt").trim(),10);
		}
				
		//테스트 변수입력 시작

//		pIdx = 1;
//		itListCnt = 20;
		
		//테스트 변수입력 끝
		
		ArrayList<ItemVo> alist = new ArrayList<ItemVo>();
		
		for(int itCnt = 0; itCnt < itListCnt; itCnt++){
			ItemVo inputIV = new ItemVo();
			
			if(request.getParameter("itList"+itCnt+"_itName") != null) inputIV.setItName(request.getParameter("itLIst"+itCnt+"_itName").trim());
			if(request.getParameter("itList"+itCnt+"_itPrice") != null) inputIV.setItPrice(Integer.parseInt(request.getParameter("itLIst"+itCnt+"_itPrice").trim(),10));
			if(request.getParameter("itList"+itCnt+"_contents") != null) inputIV.setContents(request.getParameter("itLIst"+itCnt+"_contents").trim());
			if(request.getParameter("itList"+itCnt+"_itTCnt") != null) inputIV.setItTCnt(Integer.parseInt(request.getParameter("itLIst"+itCnt+"_itTCnt").trim(),10));
			
			alist.add(inputIV);
		}
		
		//테스트 변수입력 시작 테스트시 getParameter - 객체생성 부분을 주석처리 해줘야함
		
//		for(int itCnt = 0; itCnt < itListCnt; itCnt++){
//			ItemVo inputIV = new ItemVo();
//			
//			inputIV.setItName("itemText " + itCnt);
//			inputIV.setItPrice(10000 * itCnt); 
//			inputIV.setContents("itemCon " + itCnt);
//			inputIV.setItTCnt(100 * itCnt);
//			
//			alist.add(inputIV);
//		}
		
		//테스트 변수입력 끝
		
		int row = 0;
		
		CMemberServiceImpl cs = new CMemberServiceImpl();
		row = cs.cMemProjApplyItemPlus(pIdx, alist);
		
//		System.out.println(row);
		
		PageRedirect pr = new PageRedirect(false, "/cmember/CMemberProjApplyCon.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
