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
 * Servlet implementation class CMemberQnaReplyWriteServlet_Action
 */
@WebServlet("/CMemberQnaReplyWriteServlet_Action")
public class CMemberQnaReplyWriteServlet_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CMemberQnaReplyWriteServlet_Action() {
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
		
		int obIdx = 0;
		String cate = null, title = null, contents = null;
		
		if(request.getParameter("obIdx") != null) obIdx = Integer.parseInt(request.getParameter("obIdx").trim(),10);
		if(request.getParameter("cate") != null) cate = request.getParameter("cate").trim();
		if(request.getParameter("title") != null) title = request.getParameter("title").trim();
		if(request.getParameter("contents") != null) contents = request.getParameter("contents").trim();
		
		BoardVo inputBV = new BoardVo();
		inputBV.setObIdx(obIdx);
		inputBV.setIdx(idx);
		inputBV.setCate(cate);
		inputBV.setTitle(title);
		inputBV.setContents(contents);

		int row = 0;
		
		CMemberServiceImpl cs = new CMemberServiceImpl();
		row = cs.cMemQnaWrite(inputBV);
		
//		System.out.println(row);
		
		PageRedirect pr = new PageRedirect(false, "/cmember/CMemberQnaList.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
