package ein.mono.report.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import ein.mono.report.model.service.ReportService;
import ein.mono.report.model.vo.ReportVo;

/**
 * Servlet implementation class reportListServlet
 */
@WebServlet("/reportList.do")
public class ReportListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ReportVo report = new ReportVo();
		
		ArrayList<ReportVo> list = new ReportService().selectReportList(report); //신고당한사람 delflag가 y인사람 조회(관리자)
	}

}
