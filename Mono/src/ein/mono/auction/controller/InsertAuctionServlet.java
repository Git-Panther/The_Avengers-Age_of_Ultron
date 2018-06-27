package ein.mono.auction.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ein.mono.auction.model.service.AuctionService;
import ein.mono.auction.model.vo.AuctionVo;

/**
 * Servlet implementation class InsertAuctionServlet
 */
@WebServlet("/insertAuction.do")
public class InsertAuctionServlet extends HttpServlet { // 고객의 경매 삽입
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertAuctionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 1. 변수 불러오기
		// 2. 객체 생성하고 저장
		AuctionVo auc = new AuctionVo();
	
		int result = new AuctionService().insertAuction(auc);
	}

}
