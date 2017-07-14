package controller.cmember;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.*;
import service.*;

/**
 * Servlet implementation class CMemberMemoWriteServlet_Action
 */
@WebServlet("/CMemberMemoWriteServlet_Action")
public class CMemberMemoWriteServlet_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CMemberMemoWriteServlet_Action() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int sess_idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null){
			sess_idx = (Integer) session.getAttribute("idx");
		}
		
		int param_idx = 0;
		int sendIdx = sess_idx, recvIdx = param_idx;
		String contents = null;
		
		if(request.getParameter("param_idx") != null){
			param_idx = Integer.parseInt(request.getParameter("param_idx"));
		}
		if(request.getParameter("contents") != null){
			contents = request.getParameter("contents").trim();
		}

		MemoVo inputMV = new MemoVo();
		inputMV.setSendIdx(sendIdx);
		inputMV.setRecvIdx(recvIdx);
		inputMV.setContents(contents);
				
		int row = 0;
		
		CMemberServiceImpl cs = new CMemberServiceImpl();
		row = cs.cMemMemoWrite(inputMV);
		
		PageRedirect pr = new PageRedirect(true, "/CMemberMemoSendList.do", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
