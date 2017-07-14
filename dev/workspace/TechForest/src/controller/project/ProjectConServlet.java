package controller.project;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		String nick = null;
		HttpSession session = request.getSession();
		if(session.getAttribute("nick") != null){
			nick = (String) session.getAttribute("nick");
		}
		
		int pIdx = 0;
		
		if(request.getParameter("pIdx") != null){
			pIdx = Integer.valueOf(request.getParameter("pIdx").trim());
		}
		
		ProjectVo vo = new ProjectVo();
		MemberVo cMemInfo = new MemberVo();
//		ItemVo ivo = new ItemVo();
		ArrayList<ProjectCommVo> commList = new ArrayList<ProjectCommVo>();
		ArrayList<BoardVo> boardList = new ArrayList<BoardVo>();
		
		ProjectServiceImpl ps = new ProjectServiceImpl(); 
		vo = ps.projCon(pIdx);
//		ivo = ps.projConItemList(pIdx);
		cMemInfo = ps.projConCmem(pIdx);
		commList = ps.projConCommList(pIdx, 10, 1);
		boardList = ps.projConNewsList(pIdx, 10, 1);
		
		request.setAttribute("nick", nick);
		request.setAttribute("vo", vo);
//		request.setAttribute("ivo", ivo);
		request.setAttribute("cMemInfo", cMemInfo);
		request.setAttribute("commList", commList);
		request.setAttribute("boardList", boardList);
		
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
