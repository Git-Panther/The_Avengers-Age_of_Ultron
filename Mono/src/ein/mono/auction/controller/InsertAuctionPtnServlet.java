package ein.mono.auction.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ein.mono.auction.model.service.AuctionService;
import ein.mono.auction.model.vo.AuctionPartnerVo;

/**
 * Servlet implementation class InsertAuctionPtnServlet
 */
@WebServlet("/insertAuctionPtn.do")
public class InsertAuctionPtnServlet extends HttpServlet { // 업체의 경매 신청
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertAuctionPtnServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 1. 변수 불러오기
		String reqCode = request.getParameter("reqCode");
		String ptnCode = request.getParameter("ptnCode");
		int ptnPay = Integer.parseInt(request.getParameter("ptnPay"));
		// 2. 객체 생성
		AuctionPartnerVo aucPtn = new AuctionPartnerVo();
		aucPtn.setReqCode(reqCode);
		aucPtn.setPtnCode(ptnCode);
		aucPtn.setPtnPay(ptnPay);
		
		// 3. 실행
		int result = new AuctionService().insertAuctionPtn(aucPtn);
		// 경매 신청이 끝나면 selectRequestDetail.do?reqCode=? + reqCode. 또는 경매 신청 완료 창으로 이동
	}

}
