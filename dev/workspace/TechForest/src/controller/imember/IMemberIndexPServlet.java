package controller.imember;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.PageRedirect;
import service.BoardVo;
import service.FundVo;
import service.IMemberServiceImpl;
import service.ProjectVo;

/**
 * Servlet implementation class IMemberIndexPServlet
 */
@WebServlet("/IMemberIndexPServlet")
public class IMemberIndexPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IMemberIndexPServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null){
			idx = (Integer) session.getAttribute("idx");
		}
		
		ArrayList<Map<String,Object>> plist = new ArrayList<Map<String,Object>>();
		ArrayList<BoardVo> qlist = new ArrayList<BoardVo>();
		
		IMemberServiceImpl si = new IMemberServiceImpl();
		plist = si.IMemberIndexPProjectList(idx, 10, 1);
		qlist = si.IMemberIndexPQnaList(idx, 10, 1);
		
		request.setAttribute("plist", plist);			
		request.setAttribute("qlist", qlist);
		request.setAttribute("idx", idx);
		
		PageRedirect pr = new PageRedirect(false, "/imember/IMemberIndexP.jsp", request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
