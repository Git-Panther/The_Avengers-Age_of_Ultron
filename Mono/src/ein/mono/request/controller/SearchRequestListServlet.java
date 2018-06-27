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
 * Servlet implementation class SearchRequestListServlet
 */
@WebServlet("/searchRequestList.do")
public class SearchRequestListServlet extends HttpServlet { // 고객, 업체가 주문 중에 키워드 검색한 것을 결과로 배출
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchRequestListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		MemberVo member = (MemberVo)request.getSession().getAttribute("member"); // 회원 객체 정보
		String keyword = request.getParameter("keyword"); // 검색 키워드
		String condition = request.getParameter("condition"); // 검색 기준
		String reqType = request.getParameter("reqType"); // 주문 분류
		String reqCheck = request.getParameter("reqCheck"); // 주문 상태
		
		ArrayList<RequestVo> list = new RequestService().selectRequestListByKeyword(member, reqType, reqCheck, condition, keyword);
		// 이후, 회원 유형에 따라 url이 나뉨
		// 마이페이지로든 경매 쪽으로 접근했든 여기를 거침
	}

}
