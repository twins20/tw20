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
 * Servlet implementation class CMemberIndexServlet
 */
@WebServlet("/CMemberIndexServlet")
public class CMemberIndexPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CMemberIndexPServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int idx = 1;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null) idx = (Integer) session.getAttribute("idx");
						
		ProjectVo vo = new ProjectVo();
		ArrayList<ProjectCommVo> commList = new ArrayList<ProjectCommVo>();
		ArrayList<BoardVo> newsList = new ArrayList<BoardVo>();
		
		CMemberServiceImpl cs = new CMemberServiceImpl();
		vo = cs.cMemIndexProjNowList(idx);
		commList = cs.cMemIndexCommList(idx, 10, 1);
		newsList = cs.cMemIndeNewsList(idx, 10, 1);
		
		request.setAttribute("vo", vo);
		request.setAttribute("commList", commList);
		request.setAttribute("newsList", newsList);
		
//		vo = (ProjectVo) request.getAttribute("vo");
//		
//		System.out.println(vo.getpIdx());
//		System.out.println(vo.getIdx());
//		System.out.println(vo.getpName());
//		System.out.println(vo.getpCate());
//		System.out.println(vo.getPtFunds());
//		System.out.println(vo.getPnFunds());
//		System.out.println(vo.getpGrade());
		
//		commList = (ArrayList<ProjectCommVo>) request.getAttribute("commList");
//		
//		for(ProjectVo commVo : commList){
//			System.out.println(commVo.getpCommIdx());
//			System.out.println(commVo.getComments());
//			System.out.println(commVo.getGood());
//			System.out.println(commVo.getBad());
//			System.out.println(commVo.getOpCommIdx());
//			System.out.println(commVo.getRpCommIdx());
//			System.out.println(commVo.getpCommDepth());
//			System.out.println(commVo.getViewStat());
//		}
		
//		newsList = (ArrayList<BoardVo>) request.getAttribute("newsList");
//		
//		for(BoardVo newsVo : newsList){
//			System.out.println(newsVo.getbIdx());
//			System.out.println(newsVo.getIdx());
//			System.out.println(newsVo.getCate());
//			System.out.println(newsVo.getTitle());
//			System.out.println(newsVo.getHit());
//			System.out.println(newsVo.getGood());
//			System.out.println(newsVo.getBad());
//			System.out.println(newsVo.getObIdx());
//			System.out.println(newsVo.getRbIdx());
//			System.out.println(newsVo.getbDepth());
//			System.out.println(newsVo.getCommCnt());
//			System.out.println(newsVo.getViewStat());
//		}		
		
		PageRedirect pr = new PageRedirect(false, "/cmember/CMemberIndexP.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
