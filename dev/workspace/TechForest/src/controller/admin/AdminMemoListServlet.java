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
		
		int sess_idx = 0;
		HttpSession session = request.getSession();		
		if(session.getAttribute("idx") != null){
			sess_idx = (Integer) session.getAttribute("idx");			
		}			
				
		//관리자 메모리스트 확인 
		ArrayList<MemoVo> alist = new ArrayList<MemoVo>();	
		
		AdminServiceImpl as = new AdminServiceImpl();		
		alist = as.adminBoardMemoList(sess_idx, 10, 1);
		request.setAttribute("alist", alist);
		
//		ArrayList<MemoVo> alist1 = (ArrayList<MemoVo>) request.getAttribute("alist");
//		
//		for(MemoVo vo : alist1){
//			
//			System.out.println("메모 리스트");			
//			System.out.println(vo.getMemoIdx());
//			System.out.println(vo.getSendIdx());		
//			System.out.println(vo.getRecvIdx());
//			System.out.println(vo.getContents());
//			System.out.println(vo.getStatus());
//			System.out.println(vo.getInsDate());
//			System.out.println(vo.getModDate());			
//		}
		
		PageRedirect pr = new PageRedirect(false, "/admin/AdminMemoList.jsp", request, response);		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
