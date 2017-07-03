package controller.cmember;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.PageRedirect;
import service.CMemberServiceImpl;
import service.MemoVo;

/**
 * Servlet implementation class CMemberMemoDelServlet_Action
 */
@WebServlet("/CMemberMemoDelServlet_Action")
public class CMemberMemoDelServlet_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CMemberMemoDelServlet_Action() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int memoIdx = 0;
					
		if(request.getParameter("memoIdx") != null) memoIdx = Integer.parseInt(request.getParameter("memoIdx").trim(),10);

		int row = 0;

		CMemberServiceImpl cs = new CMemberServiceImpl();
		row = cs.cMemMemoDel(memoIdx);
		
//		System.out.println(row);
		
		PageRedirect pr = new PageRedirect(true, "/cmember/CMemberMemoSendList.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
