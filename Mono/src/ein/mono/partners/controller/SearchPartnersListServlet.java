package ein.mono.partners.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ein.mono.common.PageInfo;
import ein.mono.partners.model.service.PartnersService;
import ein.mono.partners.model.vo.PartnersVo;

/**
 * Servlet implementation class SearchPartnersListServlet
 */
@WebServlet("/searchPartnersList.do")
public class SearchPartnersListServlet extends HttpServlet { // 회원이 검색 기준으로 검색했을 때 나오는 업체 리스트
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchPartnersListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String keyword = request.getParameter("keyword"); // 검색 키워드
		String condition = request.getParameter("condition"); // 검색 기준
		PageInfo pageInfo = new PageInfo();
		ArrayList<PartnersVo> list = new PartnersService().selectPartnersListByKeyword(condition, keyword);
		// 검색 조건이 무엇이냐에 따라 불러오는 쿼리는 달라진다. 표시하는 방법과 페이징은 같다.
	}

}
