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
 * Servlet implementation class reportSelectServlet
 */
@WebServlet("/reportSelect.do")
public class ReportListDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportListDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//신고내역 클릭해서 상세보기
		
		int reportCode = Integer.parseInt(request.getParameter("reportCode")); //신고당한사람들 모아둔 list에서 클릭후 자세한 정보(관리자)
		
		ReportVo report = new ReportService().reportDetail(reportCode);
	}

}
