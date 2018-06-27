package ein.mono.request.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ein.mono.request.model.service.RequestService;

/**
 * Servlet implementation class UpdateTradeCheckServlet
 */
@WebServlet("/updateTradeCheck.do")
public class UpdateTradeCheckServlet extends HttpServlet { // 결제 여부를 반영
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTradeCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		String reqCode = request.getParameter("reqCode");
		String tradeCheck = request.getParameter("tradeCheck");
		
		int result = new RequestService().updateTradeCheck(reqCode, tradeCheck);
		// 이후 url은 selectRequestDetail.do?reqCode= + reqCode
		// 참고로 결제 상태는 폼 수정이 불가능한 시공 이후에도 변경할 수 있어야 한다.
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
