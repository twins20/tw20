package controller.project;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.PageRedirect;
import service.*;

/**
 * Servlet implementation class ProjectConServlet
 */
@WebServlet("/ProjectConServlet")
public class ProjectConServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectConServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int pIdx = 0, idx = 0;
		
		if(request.getParameter("pIdx") != null) pIdx = Integer.valueOf(request.getParameter("pIdx").trim());
		if(request.getParameter("idx") != null) idx = Integer.valueOf(request.getParameter("idx").trim());
		
		ProjectVo vo = new ProjectVo();
		MemberVo cMemInfo = new MemberVo();
		ArrayList<ProjectCommVo> commList = new ArrayList<ProjectCommVo>();
		ArrayList<BoardVo> boardList = new ArrayList<BoardVo>();
		
		ProjectServiceImpl ps = new ProjectServiceImpl(); 
		vo = ps.projCon(pIdx);
		cMemInfo = ps.projConCmem(pIdx);
		commList = ps.projConCommList(pIdx, 10, 1);
		boardList = ps.projConNewsList(pIdx, 10, 1);
				
		request.setAttribute("vo", vo);
		request.setAttribute("cMemInfo", cMemInfo);
		request.setAttribute("commList", commList);
		request.setAttribute("boardList", boardList);
		
//		vo = (ProjectVo) request.getAttribute("vo"); 
//		
//		System.out.println(vo.getpIdx());
//		System.out.println(vo.getIdx());
//		System.out.println(vo.getpName());
//		System.out.println(vo.getpCate());
//		System.out.println(vo.getContents());
//		System.out.println(vo.getItList());
//		System.out.println(vo.getItListCnt());
//		System.out.println(vo.getPtFunds());
//		System.out.println(vo.getPnFunds());
//		System.out.println(vo.getpGrade());
//		System.out.println("line");
		
//		commList = (ArrayList<ProjectVo>) request.getAttribute("commList"); 
//		
//		for(ProjectVo voComm : commList){
//			System.out.println(voComm.getpCommIdx());
//			System.out.println(voComm.getComments());
//			System.out.println(voComm.getGood());
//			System.out.println(voComm.getBad());
//			System.out.println(voComm.getOpCommIdx());
//			System.out.println(voComm.getRpCommIdx());
//			System.out.println(voComm.getpCommDepth());
//		}
		
//		boardList = (ArrayList<BoardVo>) request.getAttribute("boardList"); 
//		
//		for(BoardVo voBoard : boardList){
//			System.out.println(voBoard.getbIdx());
//			System.out.println(voBoard.getIdx());
//			System.out.println(voBoard.getCate());
//			System.out.println(voBoard.getTitle());
//			System.out.println(voBoard.getHit());
//			System.out.println(voBoard.getGood());
//			System.out.println(voBoard.getBad());
//			System.out.println(voBoard.getObIdx());
//			System.out.println(voBoard.getRbIdx());
//			System.out.println(voBoard.getbDepth());
//			System.out.println(voBoard.getCommCnt());
//			System.out.println(voBoard.getViewStat());
//			System.out.println(voBoard.getExtColumn());
//			System.out.println(voBoard.getExtColumn2());
//			System.out.println(voBoard.getExtColumn3());
//		}		

//		voCmem = (MemberVo) request.getAttribute("voCmem"); 
//		
//		System.out.println(voCmem.getCompany());
//		System.out.println(voCmem.getcNumber());
//		System.out.println(voCmem.getcAddr());
		
		PageRedirect pr = new PageRedirect(false, "/project/ProjectCon.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
