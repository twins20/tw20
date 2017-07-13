package controller.cmember;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.PageRedirect;
import service.CMemberServiceImpl;
import service.MemoVo;

/**
 * Servlet implementation class CMemberMemoConServlet
 */
@WebServlet("/CMemberMemoConServlet")
public class CMemberMemoConServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CMemberMemoConServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int memoIdx = 0;
		
		if(request.getParameter("memoidx") != null){
			memoIdx = Integer.parseInt(request.getParameter("memoidx"));
		}
		
		MemoVo vo = new MemoVo();
		
		CMemberServiceImpl si = new CMemberServiceImpl();
		vo = si.cMemMemoCon(memoIdx);
		
		request.setAttribute("vo", vo);
		
		PageRedirect pr = new PageRedirect(false, "/cmember/CMemberMemoCon.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
