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
 * Servlet implementation class InsertRequestServlet
 */
@WebServlet("/insertRequest.do")
public class InsertRequestServlet extends HttpServlet { // 고객의 일반 주문 삽입
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertRequestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 1. 변수들 request에서 불러오기(경매와 같이 하고 싶다면, 주의할 점은 경매에 해당하는 컬럼 변수도 불러와야 해서 Req 쪽이 불편해짐)
		
		// 2. 불러온 변수들을 RequestVo에 저장
		RequestVo req = new RequestVo();
		// 3. 삽입
		int result = new RequestService().insertRequest(req);
		if(0 < result) {
			
		}else {
			
		}
	}

}
