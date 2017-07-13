package controller.cmember;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
 * Servlet implementation class CMemberProjApplyConServlet
 */
@WebServlet("/CMemberProjApplyConServlet")
public class CMemberProjApplyConServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CMemberProjApplyConServlet() {
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
		
		ProjectVo vo = new ProjectVo();
		ArrayList<ItemVo> alist = new ArrayList<ItemVo>();

		CMemberServiceImpl cs = new CMemberServiceImpl();
		vo = cs.cMemProjApplyConProj(idx);
		alist = cs.cMemProjApplyConItem(vo.getpIdx());
		
		request.setAttribute("vo", vo);
		request.setAttribute("alist", alist);
		
//		vo = (ProjectVo) request.getAttribute("vo"); 
//	
//		System.out.println(vo.getpIdx());
//		System.out.println(vo.getIdx());
//		System.out.println(vo.getpName());
//		System.out.println(vo.getpCate());
//		System.out.println(vo.getContents());
//		System.out.println(vo.getItList());
//		System.out.println(vo.getItListCnt());
//		System.out.println(vo.getPtFunds());
//		System.out.println(vo.getPeDate());
//		System.out.println(vo.getPcDate());
//
//		alist = (ArrayList<ItemVo>) request.getAttribute("alist"); 
//		
//		for(ItemVo itVo : alist){
//			System.out.println(itVo.getItIdx());
//			System.out.println(itVo.getItName());
//			System.out.println(itVo.getItPrice());
//			System.out.println(itVo.getContents());
//			System.out.println(itVo.getItTCnt());
//		}
		
		PageRedirect pr = new PageRedirect(false, "/CMemberProjApplyCon.do", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}