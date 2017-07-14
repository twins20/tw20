package controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.PageRedirect;
import service.AdminServiceImpl;
import service.BoardVo;
import service.MemoVo;


@WebServlet("/AdminMemoSendServlet_Action")
public class AdminMemoSendServlet_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
        public AdminMemoSendServlet_Action() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int sess_idx = 0;
		HttpSession session = request.getSession();		
		if(session.getAttribute("idx") != null){
			sess_idx = (Integer) session.getAttribute("idx");			
		}	
						
		//관리자 메모 작성 액션
		int row = 0;
		int sendIdx = 0;
		int recvIdx = 0;	
		
		String contents = null;
		
		if(request.getParameter("sendIdx") != null){
			sendIdx = Integer.parseInt(request.getParameter("sendIdx").trim(),10);				
		}
		if(request.getParameter("recvIdx") != null){
			recvIdx = Integer.parseInt(request.getParameter("recvIdx").trim(),10);
		}
		if(request.getParameter("contents") != null){
			contents = request.getParameter("contents").trim();
		}
		
		MemoVo inputMV = new MemoVo();
		inputMV.setContents(contents);		
		
		AdminServiceImpl as = new AdminServiceImpl();		
		row = as.adminBoardMemoSend(sendIdx, recvIdx, inputMV);
				
//		System.out.println(row);		
		
		PageRedirect pr = new PageRedirect(true, "/AdminMemoList.do", request, response);		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
