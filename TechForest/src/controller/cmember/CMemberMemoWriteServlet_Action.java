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
		
		int idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null) idx = (Integer) session.getAttribute("idx");
		
		int sendIdx = 0, recvIdx = 0;
		String contents = null;
				
		if(request.getParameter("sendIdx") != null) sendIdx = Integer.parseInt(request.getParameter("sendIdx").trim(),10);
		if(request.getParameter("recvIdx") != null) recvIdx = Integer.parseInt(request.getParameter("recvIdx").trim(),10);
		if(request.getParameter("contents") != null) contents = request.getParameter("contents").trim();

		MemoVo inputMV = new MemoVo();
		inputMV.setSendIdx(sendIdx);
		inputMV.setRecvIdx(recvIdx);
		inputMV.setContents(contents);
				
		int row = 0;
		
		CMemberServiceImpl cs = new CMemberServiceImpl();
		row = cs.cMemMemoWrite(inputMV);
		
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
