package ein.mono.report.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ein.mono.report.model.service.ReportService;
import ein.mono.report.model.vo.ReportVo;

/**
 * Servlet implementation class reportInsertServlet
 */
@WebServlet("/reportInsert.do")
public class ReportInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ReportVo report = new ReportVo();//회원이 신고하기(일반회원)/ delflag바꾸기 신고당한횟수증가(쿼리)
		
		int result = new ReportService().reportInsert(report);
	}

}
