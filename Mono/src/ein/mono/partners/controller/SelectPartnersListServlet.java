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
import ein.mono.profile.model.vo.ProfileVo;

/**
 * Servlet implementation class SelectPartnersListServlet
 */
@WebServlet("/selectPartnersList.do")
public class SelectPartnersListServlet extends HttpServlet { // 회원이 업체 지정 메인 페이지에서 카테고리를 고르면 표시되는 페이지
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectPartnersListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PartnersService ps = new PartnersService();
		
		// 페이징 처리
		int currentPage = 0; // 현재 페이지 번호
		int limitPage = 0; // 한 페이지에 출력할 페이지 개수
		
		int maxPage = 0; // 마지막 페이지
		int startPage = 0; // 시작 페이지
		int endPage = 0; // 마지막 페이지 변수
		int limit = 0; // 한 페이지에 출력할 게시글 개수
		
		limit = 12;
		limitPage = 12;
		
		if(null != request.getParameter("currentPage")){
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}else{
			currentPage = 1;
		}
		
		String category = request.getParameter("category"); // 전체, 내 지역, 우수 업체 중 하나
		int totalCount = ps.selectPartnersTotalCount(category); // 총 업체 개수
		String url = null;
		if(-1 != totalCount) { // 조회 성공시
			maxPage = (int)((double)totalCount / limit + 0.99); // 업체 개수가 145개면 13페이지
			
			startPage = (int)(currentPage / limitPage * limitPage) + 1;// 현재 페이지 번호
			endPage = startPage + limitPage - 1;
			if(maxPage < endPage) {
				endPage = maxPage;
			}
			PageInfo pi = new PageInfo(currentPage, limitPage, maxPage, startPage, endPage, totalCount);
				
			// MemberVo member = (MemberVo)request.getSession().getAttribute("member"); // 회원의 정보 기준에 따라 보여줄 것이다.
			// 검색으로 알아서 하라고 그러고 키워드는 우수 업체냐, 전체냐로 갈림
			ArrayList<ProfileVo> list = ps.selectPartnersList(category, currentPage, limit); // 페이지만큼 가져옴
			// 리스트 조건이 무엇이냐에 따라 불러오는 쿼리는 달라진다. 표시하는 방법과 페이징은 같다.
			
			if(null != list){ // 성공
				url = "views/board/boardList.jsp";
				request.setAttribute("list", list);
				request.setAttribute("pi", pi);
			}else{ // 실패
				
			}
		}else { // 실패
			
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
