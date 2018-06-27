package ein.mono.request.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ein.mono.request.model.service.RequestService;

/**
 * Servlet implementation class DeleteRequestServlet
 */
@WebServlet("/deleteRequest.do")
public class DeleteRequestServlet extends HttpServlet { // 주문(경매, 시공 포함)을 취소하여 삭제해야 할 때 발생. delflag를 바꾸거나 행 자체를 삭제.
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String reqCode = request.getParameter("reqCode"); // 삭제할 주문
		
		int result = new RequestService().deleteRequest(reqCode);
		// 삭제 문법은 모두가 공유하므로 통일된 것을 쓴다.
		// url은 selectRequestList.do?reqType=all&reqCheck=all 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
