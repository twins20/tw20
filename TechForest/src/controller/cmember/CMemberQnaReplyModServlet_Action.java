package controller.cmember;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.PageRedirect;
import service.BoardVo;
import service.CMemberServiceImpl;

/**
 * Servlet implementation class CMemberQnaReplyModServlet_Action
 */
@WebServlet("/CMemberQnaReplyModServlet_Action")
public class CMemberQnaReplyModServlet_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CMemberQnaReplyModServlet_Action() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				
		int bIdx = 0;
		String title = null, contents = null;
		
		if(request.getParameter("bIdx") != null) bIdx = Integer.parseInt(request.getParameter("bIdx").trim(),10);
		if(request.getParameter("title") != null) title = request.getParameter("title").trim();
		if(request.getParameter("contents") != null) contents = request.getParameter("contents").trim();
		
		BoardVo inputBV = new BoardVo();
		inputBV.setbIdx(bIdx);
		inputBV.setTitle(title);
		inputBV.setContents(contents);

		int row = 0;
		
		CMemberServiceImpl cs = new CMemberServiceImpl();
		row = cs.cMemQnaMod(inputBV);
		
//		System.out.println(row);
		
		PageRedirect pr = new PageRedirect(true, "/CMemberQnaList.do", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
