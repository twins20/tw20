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
import service.BoardVo;
import service.CMemberServiceImpl;
import service.ProjectVo;

/**
 * Servlet implementation class CMemberQnaReplyModServlet
 */
@WebServlet("/CMemberQnaReplyModServlet")
public class CMemberQnaReplyModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CMemberQnaReplyModServlet() {
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
		
		int bIdx = 0;
		
		if(request.getParameter("bIdx") != null) bIdx = Integer.parseInt(request.getParameter("bIdx").trim(),10);
		
		Map<String, Object> data = new HashMap<String, Object>();
		BoardVo vo = new BoardVo();
		ProjectVo pvo = new ProjectVo();
		
		CMemberServiceImpl cs = new CMemberServiceImpl();
		data = cs.cMemQnaCon(bIdx);
		
		vo = (BoardVo) data.get("vo");
		pvo = (ProjectVo) data.get("pvo");
		
		request.setAttribute("vo", vo);
		request.setAttribute("pvo", pvo);
		
//		vo = (BoardVo) request.getAttribute("vo"); 
//	
//		System.out.println(vo.getbIdx());
//		System.out.println(vo.getIdx());
//		System.out.println(vo.getCate());
//		System.out.println(vo.getTitle());
//		System.out.println(vo.getHit());
//		System.out.println(vo.getGood());
//		System.out.println(vo.getBad());
//		System.out.println(vo.getObIdx());
//		System.out.println(vo.getInsDate());
//		System.out.println(vo.getExtColumn());
//
//		pvo = (ProjectVo) request.getAttribute("pvo"); 
//		
//		System.out.println(pvo.getpIdx());
//		System.out.println(pvo.getpName());
//		System.out.println(pvo.getPnFunds());
//		System.out.println(pvo.getpGrade());
//		System.out.println(pvo.getStatus());
		
		PageRedirect pr = new PageRedirect(false, "/cmember/CMemberQnaReplyMod.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
