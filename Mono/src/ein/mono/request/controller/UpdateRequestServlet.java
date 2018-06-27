package ein.mono.request.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ein.mono.request.model.service.RequestService;
import ein.mono.request.model.vo.RequestVo;

/**
 * Servlet implementation class UpdateRequestServlet
 */
@WebServlet("/updateRequest.do")
public class UpdateRequestServlet extends HttpServlet { // 고객이 주문이나 경매의 상세 정보들을 수정한 결과를 반영
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestVo req = null;
		// String reqType = request.getParameter("reqType"); // 주문 형식(일반 주문, 업체, 경매)
		// RequestVo 세팅
		
		int result = new RequestService().updateRequest(req);
		
		// 업데이트 완료 후, selectRequestDetail.do?reqCode= + req.getReqCode()로 이동
	}

}
