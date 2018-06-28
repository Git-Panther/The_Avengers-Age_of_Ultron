package ein.mono.partners.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ein.mono.common.PageInfo;
import ein.mono.member.model.vo.MemberVo;
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
		MemberVo member = (MemberVo)request.getSession().getAttribute("member"); // 회원의 정보 기준에 따라 보여줄 것이다.
		String category = request.getParameter("category"); // 전체, 내 지역, 우수 업체 중 하나
		PageInfo pageInfo = new PageInfo();
		ArrayList<ProfileVo> list = new PartnersService().selectPartnersList(member, category);
		// 리스트 조건이 무엇이냐에 따라 불러오는 쿼리는 달라진다. 표시하는 방법과 페이징은 같다.
	
		if(null != list){ // 성공
			
		}else{ // 실패
			
		}
	}

}
