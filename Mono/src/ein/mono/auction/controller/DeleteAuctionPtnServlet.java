package ein.mono.auction.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ein.mono.auction.model.service.AuctionService;

/**
 * Servlet implementation class DeleteAuctionPtnServlet
 */
@WebServlet("/deleteAuctionPtn.do")
public class DeleteAuctionPtnServlet extends HttpServlet { // 업체가 경매 취소할 때
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAuctionPtnServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String reqCode = request.getParameter("reqCode");
		String ptnCode = request.getParameter("ptnCode");
		
		int result = new AuctionService().deleteAuctionPtn(reqCode, ptnCode);
		// 이후 url은 selectRequestList.do?reqType=all&reqCheck=all
	}

}
