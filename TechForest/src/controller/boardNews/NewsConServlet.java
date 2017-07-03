package controller.boardNews;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.PageRedirect;
import service.BoardCommVo;
import service.BoardNewsServiceImpl;
import service.BoardVo;
import service.ProjectVo;

/**
 * Servlet implementation class NewsConServlet
 */
@WebServlet("/NewsConServlet")
public class NewsConServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsConServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		int bidx = (Integer) null;
		if(session.getAttribute("bidx") !=null) bidx =(Integer) request.getAttribute("bidx");
		if(request.getParameter("bidx") != null) bidx = Integer.parseInt(request.getParameter("bidx"));
	
		BoardNewsServiceImpl bs = new BoardNewsServiceImpl(); 
		ArrayList<BoardVo> alist = new ArrayList<BoardVo>(); 
		
		alist = bs.boardNewsCon(bidx);		
		request.setAttribute("alist", alist);		
				
		ArrayList<BoardVo> alist1 = (ArrayList<BoardVo>) request.getAttribute("alist");		
		for(BoardVo vo : alist1){
			
//			System.out.println(vo.getbIdx());
//			System.out.println(vo.getIdx());
//			System.out.println(vo.getCate());
//			System.out.println(vo.getTitle());
//			System.out.println(vo.getContents());
//			System.out.println(vo.getHit());
//			System.out.println(vo.getGood());
//			System.out.println(vo.getBad());
//			System.out.println(vo.getCommCnt());
//			System.out.println(vo.getInsDate());
//			System.out.println(vo.getModDate());
			
			}
		

		ArrayList<BoardCommVo> blist = new ArrayList<BoardCommVo>();

		blist = bs.boardNewsCommList(bidx, 1, 1);

//		request.setAttribute("blist", blist);
//		
//		ArrayList<BoardCommVo> blist2 = (ArrayList<BoardCommVo>) request.getAttribute("blist");
//
//		for(BoardCommVo vc : blist2){
//			
////			System.out.println(vc.getrNum());
//			System.out.println(vc.getCommIdx());
//			System.out.println(vc.getbIdx());
//			System.out.println(vc.getIdx());
//			System.out.println(vc.getComments());
//			System.out.println(vc.getGood());
//			System.out.println(vc.getBad());
//			System.out.println(vc.getoCommIdx());
//			System.out.println(vc.getrCommIdx());
//			
//		}
		
		bs.boardNewsHit(bidx);
			
//		int bidx = 1;
		ArrayList<ProjectVo> clist = new ArrayList<ProjectVo>();
		
		clist = bs.boardNewsProjList(bidx, 1, 1);
//		request.setAttribute("clist", clist);
//		
//		ArrayList<ProjectVo> clist2 = (ArrayList<ProjectVo>) request.getAttribute("clist");
//		for(ProjectVo vo : clist2){
//									
//			System.out.println(vo.getpIdx());
//			System.out.println(vo.getIdx());
//			System.out.println(vo.getpName());
//			System.out.println(vo.getpCate());
//			System.out.println(vo.getItList1());
//			System.out.println(vo.getPtFunds());
//			System.out.println(vo.getPnFunds());
//			
//		}
		
	
		PageRedirect pr = new PageRedirect(false, "/NewsConServlet.do" ,request ,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
