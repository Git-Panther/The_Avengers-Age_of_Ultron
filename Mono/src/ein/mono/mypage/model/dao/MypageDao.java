package ein.mono.mypage.model.dao;

import java.sql.Connection;
import java.util.ArrayList;

import ein.mono.favblock.model.vo.FBVo;
import ein.mono.report.model.vo.ReportVo;

public class MypageDao {
	public ArrayList<FBVo> selectFBList(Connection con,String mCode,String fbType){
		return null;
	}
	public int deleteFB(Connection con,String mCode,String tCode, String fbType){
		return 0;
	}
	public ArrayList selectPostList(Connection con,String mCode){
		return null;
	}
	public ArrayList selectReportList(Connection con,String pCode){
		return null;
	}
	public ReportVo selectReport(Connection con,String rCode){
		return null;
	}
	public ArrayList selectConstList(Connection con,String pCode){
		return null;
	}
	public ArrayList selectQnaList(Connection con,String pCode){
		return null;
	}
}
