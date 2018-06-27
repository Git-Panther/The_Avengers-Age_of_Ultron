package ein.mono.report.model.dao;

import java.sql.Connection;
import java.util.ArrayList;


import ein.mono.report.model.vo.ReportVo;

public class ReportDao {

	public int reportUpdate(Connection con, ReportVo report) {
		int result = 0;
		return result;
	}

	public ArrayList<ReportVo> selectReportList(Connection con, ReportVo report) {
		
		ArrayList<ReportVo> list = null;
		return list;
	}

	public int reportInsert(Connection con, ReportVo report) {
		int result = 0;
		return result;
	}

	public ReportVo reportDetail(Connection con, int reportCode) {
		
		ReportVo result = null;
		result = new ReportVo();
		
		return result;
	}

}
