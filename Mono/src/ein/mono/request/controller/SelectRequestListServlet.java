package ein.mono.request.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ein.mono.member.model.vo.MemberVo;
import ein.mono.request.model.service.RequestService;
import ein.mono.request.model.vo.RequestVo;

/**
 * Servlet implementation class SelectRequestListServlet
 */
@WebServlet("/selectRequestList.do")
public class SelectRequestListServlet extends HttpServlet { // 고객, 업체가 자신과 연관된 주문 리스트를 불러올 때
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectRequestListServlet() {
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
		String reqType = request.getParameter("reqType"); // 일반 주문, 경매, 시공 중 하나
		String reqCheck = request.getParameter("reqCheck"); // 주문 상태를 의미
		
		ArrayList<RequestVo> list = new RequestService().selectRequestList(member, reqType, reqCheck);
		
		// 이후, memberType에 따라 고객이면 고객 쪽 jsp, 업체이면 업체 쪽 jsp로 할 수 있다. 또는 통합된 jsp이되, jsp에서 고객이냐 업체냐에 따라 갈릴 수 있음
		// 마이페이지를 통해 접근했든, 경매 페이지를 통해 접근했든 여기를 통해 접근함.
	}
}
