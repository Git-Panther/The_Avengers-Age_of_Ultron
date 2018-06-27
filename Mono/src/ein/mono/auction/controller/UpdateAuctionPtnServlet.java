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
 * Servlet implementation class UpdateAuctionPtnServlet
 */
@WebServlet("/updateAuctionPtn.do")
public class UpdateAuctionPtnServlet extends HttpServlet { // 업체가 입찰 금액을 바꿀 때
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAuctionPtnServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int ptnPay = Integer.parseInt(request.getParameter("ptnPay"));
		String reqCode = request.getParameter("reqCode");
		String ptnCode = request.getParameter("ptnCode");
		
		AuctionPartnerVo auc = new AuctionPartnerVo();
		auc.setReqCode(reqCode);
		auc.setPtnCode(ptnCode);
		
		int result = new AuctionService().updateAuctionPtn(auc);
		// 이후 url은 selectRequestDetail.do?reqCode= + reqCode
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
