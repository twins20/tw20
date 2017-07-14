package controller.cmember;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.*;
import service.*;

/**
 * Servlet implementation class CMemberNewsWriteServlet_Action
 */
@WebServlet("/CMemberNewsWriteServlet_Action")
public class CMemberNewsWriteServlet_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CMemberNewsWriteServlet_Action() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null){
			sess_idx = (Integer) session.getAttribute("idx");
		}
		
		int pIdx = 0;
		String title = null, contents = null;
		
		if(request.getParameter("pIdx") != null){
			pIdx = Integer.parseInt(request.getParameter("pIdx").trim());
		}
		if(request.getParameter("title") != null){
			title = request.getParameter("title").trim();
		}
		if(request.getParameter("contents") != null){
			contents = request.getParameter("contents").trim();
		}

		BoardVo inputBV = new BoardVo();
		inputBV.setIdx(sess_idx);
		inputBV.setTitle(title);
		inputBV.setContents(contents);
		inputBV.setpIdx(pIdx);
				
		int row = 0;
		
		CMemberServiceImpl cs = new CMemberServiceImpl();
		row = cs.cMemNewsWrite(inputBV);
		
		PageRedirect pr = new PageRedirect(true, "/CMemberNewsList.do", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
