package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BuseoDao;
import Model.BuseoVo;

/**
 * Servlet implementation class WriteActionServlet
 */
@WebServlet("/BuseoWriteActionServlet")
public class BuseoWriteActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuseoWriteActionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
	    String bname = request.getParameter("bname");
	    int idx = Integer.parseInt(request.getParameter("idx"));   
	    
	    BuseoDao bd = new BuseoDao();
	    
	    BuseoVo bv = new BuseoVo();
	    bv.setBname(bname);
	    bv.setIdx(idx);
	    
	    int max = bd.getMax();
	    int row = bd.insertWrite(bv, max); 
	    
	    //row 0이면 입력안됨
//	    if (row ==0) {
//	    response.sendRedirect(request.getContextPath()+"/Controller/BuseoWriteServlet.do");	
//	    }
//	    else{
//	    response.sendRedirect(request.getContextPath()+"/Controller/BuseoListServlet.do");
//	    }
	}

}

