package controller.cmember;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.*;
import service.*;

/**
 * Servlet implementation class CMemberQnaListServlet
 */
@WebServlet("/CMemberQnaListServlet")
public class CMemberQnaListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CMemberQnaListServlet() {
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
				
		ArrayList<Map<String, Object>> alist = new ArrayList<Map<String, Object>>();
		
		CMemberServiceImpl cs = new CMemberServiceImpl();
		alist = cs.cMemQnaList(idx, 10, 1);
		
		request.setAttribute("alist", alist);
		
//		alist = (ArrayList<Map<String, Object>>) request.getAttribute("alist");
//		
//		BoardVo bvo = new BoardVo();
//		ProjectVo pvo = new ProjectVo();
//		String status = null;
//		
//		for(Map<String, Object> data : alist){
//			
//			bvo = (BoardVo) data.get("bvo");
//			pvo = (ProjectVo) data.get("pvo");
//			status = (String) data.get("status");
//			
//			System.out.println(bvo.getbIdx());
//			System.out.println(bvo.getIdx());
//			System.out.println(bvo.getCate());
//			System.out.println(bvo.getTitle());
//			System.out.println(bvo.getHit());
//			System.out.println(bvo.getGood());
//			System.out.println(bvo.getBad());
//			System.out.println(bvo.getCommCnt());
//			System.out.println(bvo.getObIdx());
//			System.out.println(bvo.getInsDate());
//			
//			System.out.println(pvo.getpIdx());
//			System.out.println(pvo.getpName());
//						
//			System.out.println(status);
//			
//		}
		
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
