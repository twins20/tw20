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
 * Servlet implementation class CMemberIndexPServlet
 */
@WebServlet("/CMemberIndexPServlet")
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
		
		int idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null){
			idx = (Integer) session.getAttribute("idx");
		}
						
		ProjectVo vo = new ProjectVo();
		ArrayList<ProjectCommVo> commList = new ArrayList<ProjectCommVo>();
		ArrayList<BoardVo> newsList = new ArrayList<BoardVo>();
		
		CMemberServiceImpl cs = new CMemberServiceImpl();
		vo = cs.cMemIndexProjNowList(idx);
		commList = cs.cMemIndexCommList(idx, 10, 1);
		newsList = cs.cMemIndexNewsList(idx, 10, 1);
		
		request.setAttribute("vo", vo);
		request.setAttribute("commList", commList);
		request.setAttribute("newsList", newsList);
		
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
