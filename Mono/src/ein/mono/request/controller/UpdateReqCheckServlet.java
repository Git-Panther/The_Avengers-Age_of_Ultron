package ein.mono.request.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ein.mono.request.model.service.RequestService;

/**
 * Servlet implementation class UpdateReqCheckServlet
 */
@WebServlet("/updateReqCheck.do")
public class UpdateReqCheckServlet extends HttpServlet { // 변경된 reqCheck 반영
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateReqCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String reqCode = request.getParameter("reqCode");
		String reqCheck = request.getParameter("reqCheck");
		
		int result = new RequestService().updateReqCheck(reqCode, reqCheck);
		// 이후 url은 selectRequestDetail.do?reqCode= + reqCode
		// 참고로 주문 상태는 시공에 들어간 이후에도 수정할 수 있어야 한다.
	}

}
