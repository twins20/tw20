package controller.imember;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import common.PageRedirect;
import service.IMemberServiceImpl;
import service.MemberVo;

/**
 * Servlet implementation class IMemberInfoModServlet_Action
 */
@WebServlet("/IMemberInfoModServlet_Action")
public class IMemberInfoModServlet_Action extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IMemberInfoModServlet_Action() {
    	super();
        

    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idx = 0;
		HttpSession session = request.getSession();
		if(session.getAttribute("idx") != null) {
			idx = (Integer) session.getAttribute("idx");
		}
		
		int phone = 0;
		String pw = null, nick = null, addr = null; 
		
     	if(request.getParameter("pw") != null){
     		pw = request.getParameter("pw").trim();
     	}
    	if(request.getParameter("nick") != null){
    		nick = request.getParameter("nick").trim();
    	}
		if(request.getParameter("phone") != null){
			phone = Integer.parseInt(request.getParameter("phone").trim(),10);
		}
		if(request.getParameter("addr") != null){
			addr = request.getParameter("addr").trim();
		}
    	
    	MemberVo inputMV = new MemberVo();
    	inputMV.setPw(pw);
    	inputMV.setNick(nick);
    	inputMV.setPhone(phone);
    	inputMV.setAddr(addr);
    	
    	int row = 0;
    	
    	IMemberServiceImpl si = new IMemberServiceImpl();
    	row = si.IMemInfoModAction(inputMV, idx);
    	   	
    	PageRedirect pr = new PageRedirect(true, "/IMemberInfoCon.do", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
