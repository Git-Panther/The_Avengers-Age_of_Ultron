package ein.mono.request.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ein.mono.member.model.vo.MemberVo;
import ein.mono.request.model.service.RequestService;
import ein.mono.request.model.vo.RequestVo;

/**
 * Servlet implementation class SelectRequestDetailServlet
 */
@WebServlet("/selectRequestDetail.do")
public class SelectRequestDetailServlet extends HttpServlet { // 주문 목록을 선택했을 때 상세 정보 불러오기
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectRequestDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		MemberVo member = (MemberVo)request.getSession().getAttribute("member"); // 회원 객체 정보
		String reqCode = request.getParameter("reqCode");
		
		// reqType이 일반 주문이면 RequestVo, 경매이면 AuctionVo, 시공이면 ConstructionVo가 저장됨
		RequestVo req = new RequestService().selectRequestDetail(member, reqCode);
	
		// 이후 url은 회원 유형과 RequestVo의 reqType으로 바뀜.
	}
}
