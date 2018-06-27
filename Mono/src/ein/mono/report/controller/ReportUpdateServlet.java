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
 * Servlet implementation class reportUpdateServlet
 */
@WebServlet("/reportUpdate.do")
public class ReportUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//디테일리스트에서 내용확인후 관리자가 등급변경(관리자)
		
		ReportVo report = new ReportVo();
		
		int result = new ReportService().updateReport(report);
		
		
	}

}
