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
 * Servlet implementation class IMemberIndexPProjectListServlet
 */
@WebServlet("/IMemberIndexPProjectListServlet")
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
		
		//투자자 인덱스 프로젝트 리스트  
		int idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null) idx = (Integer) session.getAttribute("idx");
		
		IMemberServiceImpl si = new IMemberServiceImpl();
		ArrayList<Map<String,Object>> plist = new ArrayList<Map<String,Object>>();
		ArrayList<BoardVo> qlist = new ArrayList<BoardVo>();
		
		plist = si.IMemberIndexPProjectList(idx, 10, 1);
		qlist = si.IMemberIndexPQnaList(idx, 10, 1);
		
//		request.setAttribute("plist", plist);			
//		request.setAttribute("qlist", qlist);
//		
//		ArrayList<Map<String,Object>> plist1 = (ArrayList<Map<String,Object>>) request.getAttribute("plist");
//		
//		for(Map<String, Object> plist2 : plist1){
//			
//		ProjectVo pvo = (ProjectVo) plist2.get("vo");
//		FundVo fvo = (FundVo) plist2.get("vo2");
//		
//		System.out.println(pvo.getrNum());
//		System.out.println(pvo.getIdx());
//		System.out.println(pvo.getpName());
//		System.out.println(pvo.getpCate());
//		System.out.println(pvo.getpGrade());
//		System.out.println(fvo.getStatus());
//		System.out.println(pvo.getPnFunds() / pvo.getPtFunds() * 100);
//		
//		}
//		
//		ArrayList<BoardVo> qlist1 = (ArrayList<BoardVo>) request.getAttribute("qlist");
//		
//		String status = null;
//		for(BoardVo bvo : qlist1){ 
//			if(bvo.getbDepth() > 1){
//				status = "답변완료";
//			}else{
//				status = "답변대기";
//		}
//			
//		System.out.println(bvo.getrNum());
//		System.out.println(bvo.getbIdx());
//		System.out.println(bvo.getCate());
//		System.out.println(bvo.getTitle());
//		System.out.println(status);
//		System.out.println(bvo.getInsDate());
//		System.out.println(bvo.getHit());	
//		
//		}
		
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
