package controller.boardQna;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.PageRedirect;
import service.BoardQnaServiceImpl;
import service.BoardVo;
import service.ProjectVo;

/**
 * Servlet implementation class QnaConServlet
 */
@WebServlet("/QnaConServlet")
public class QnaConServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnaConServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int bidx = 0;
		
		if(request.getParameter("bidx") != null) bidx = Integer.parseInt(request.getParameter("bidx"));
		
		BoardQnaServiceImpl bs = new BoardQnaServiceImpl(); 		
		ArrayList<BoardVo> alist = new ArrayList<BoardVo>();
		
		alist = bs.boardQnaCon(bidx);
		request.setAttribute("alist", alist);
		
		ArrayList<BoardVo> alist1 = (ArrayList<BoardVo>) request.getAttribute("alist");
		
		for (BoardVo vo : alist1){
//			
//			System.out.println(vo.getbIdx());
//			System.out.println(vo.getIdx());
//			System.out.println(vo.getCate());
//			System.out.println(vo.getTitle());
//			System.out.println(vo.getContents());
//			System.out.println(vo.getGood());
//			System.out.println(vo.getBad());
//			System.out.println(vo.getHit());
//			System.out.println(vo.getInsDate());
//			System.out.println(vo.getModDate());
			
		}
		
		ArrayList<ProjectVo> blist = new ArrayList<ProjectVo>();
	
		blist = bs.boardQnaProjList(bidx, 1, 1);
		request.setAttribute("blist", blist);
		
		ArrayList<ProjectVo> blist2 = (ArrayList<ProjectVo>) request.getAttribute("blist");
		for(ProjectVo vo : blist2){
									
//			System.out.println(vo.getpIdx());
//			System.out.println(vo.getIdx());
//			System.out.println(vo.getpName());
//			System.out.println(vo.getpCate());
//			System.out.println(vo.getItList1());
//			System.out.println(vo.getPtFunds());
//			System.out.println(vo.getPnFunds());
		
		}	

		PageRedirect pr = new PageRedirect(false, "/boardQna/QnaCon.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
