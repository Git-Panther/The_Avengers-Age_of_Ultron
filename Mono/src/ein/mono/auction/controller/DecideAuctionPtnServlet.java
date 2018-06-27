package ein.mono.auction.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ein.mono.auction.model.service.AuctionService;

/**
 * Servlet implementation class DecideAuctionPtnServlet
 */
@WebServlet("/decideAuctionPtn.do")
public class DecideAuctionPtnServlet extends HttpServlet { // 고객이 경매에서 최종 입찰 업체를 정함
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DecideAuctionPtnServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());		
		String ptnCode = request.getParameter("ptnCode"); // 입찰이 결정된 업체의 코드
		String reqCode = request.getParameter("reqCode"); // 입찰이 결정된 경매의 코드
		
		int result = new AuctionService().updatePtnCodeOfAuction(reqCode, ptnCode);
		// 이후, selectRequestDetail.do?reqCode= + reqCode로 이동
	}

}
