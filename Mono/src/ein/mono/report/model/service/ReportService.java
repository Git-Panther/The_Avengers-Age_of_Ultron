package ein.mono.report.model.service;

import java.sql.Connection;
import java.util.ArrayList;



import ein.mono.common.JDBCTemplate;

import ein.mono.report.model.dao.ReportDao;
import ein.mono.report.model.vo.ReportVo;

public class ReportService {

	public int updateReport(ReportVo report) {
		Connection con = JDBCTemplate.getConnection();
		int result = new ReportDao().reportUpdate(con, report);
		if(0 < result) {
			JDBCTemplate.commit(con);
		}else {
			JDBCTemplate.rollback(con);
		}
		
		JDBCTemplate.close(con);
		
		return result;
	}

	public ArrayList<ReportVo> selectReportList(ReportVo report) {
		Connection con = JDBCTemplate.getConnection();
		
		ArrayList<ReportVo> list = new ReportDao().selectReportList(con, report);
		
		JDBCTemplate.close(con);
		
		return list;
	}

	public int reportInsert(ReportVo report) {
		Connection con = JDBCTemplate.getConnection();
		//비지니스 로직 호출
	int result = new ReportDao().reportInsert(con, report);
	
	if(0<result) {
			JDBCTemplate.commit(con);
	}else {
		JDBCTemplate.rollback(con);
	}
		//자원반납
	JDBCTemplate.close(con);
		//결과 반환
	
	return result;
	}

	public ReportVo reportDetail(int reportCode) {
		Connection con = JDBCTemplate.getConnection();
		
		ReportVo report = new ReportDao().reportDetail(con, reportCode);
		
		JDBCTemplate.close(con);
		
		return report;

}
}