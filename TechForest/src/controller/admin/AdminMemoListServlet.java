package controller.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.PageRedirect;
import service.AdminServiceImpl;
import service.MemberVo;
import service.MemoVo;


@WebServlet("/AdminMemoListServlet")
public class AdminMemoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public AdminMemoListServlet() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AdminServiceImpl as = new AdminServiceImpl();		
		
		//관리자 메모리스트 확인 
		ArrayList<MemoVo> alist = new ArrayList<MemoVo>();	
		
		int idx = 0;
		HttpSession session = request.getSession();		
		if(session.getAttribute("idx") != null) idx = (Integer) session.getAttribute("idx");		
//		int idx = Integer.parseInt(request.getParameter("idx"));
//		int idx = 1;
		
		alist = as.adminBoardMemoList(idx);
		request.setAttribute("alist", alist);
		ArrayList<MemoVo> alist1 = (ArrayList<MemoVo>) request.getAttribute("alist");
		
		for(MemoVo mv : alist1){
			
			System.out.println("메모 리스트");			
			System.out.println(mv.getMemoIdx());
			System.out.println(mv.getSendIdx());		
			System.out.println(mv.getRecvIdx());
			System.out.println(mv.getContents());
			System.out.println(mv.getStatus());
			System.out.println(mv.getInsDate());
			System.out.println(mv.getModDate());			
		}
		
		PageRedirect pr = new PageRedirect(false, "/admin/AdminCmemChkList.jsp", request, response);		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
