package ein.mono.favblock.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import ein.mono.common.JDBCTemplate;
import ein.mono.favblock.model.dao.FBDao;
import ein.mono.favblock.model.vo.FBVo;


public class FBService {

	public int updateLike(FBVo LB) {
		Connection con = JDBCTemplate.getConnection();
		int result = new FBDao().insertFav(con, LB);
		
		if(0 < result) {
			JDBCTemplate.commit(con);
		}else {
			JDBCTemplate.rollback(con);
		}
		
		JDBCTemplate.close(con);
		
		return result;
	}

	public int updateBlock(FBVo LB) {
		Connection con = JDBCTemplate.getConnection();
		int result = new FBDao().updateBlock(con, LB);
		
		if(0 < result) {
			JDBCTemplate.commit(con);
		}else {
			JDBCTemplate.rollback(con);
		}
		
		JDBCTemplate.close(con);
		
		return result;
	}

	public ArrayList<FBVo> selectLBList() {
		
		
		Connection con = JDBCTemplate.getConnection();
		
		ArrayList<FBVo> list = new FBDao().selectLBList(con);
		
		JDBCTemplate.close(con);
		
		return list;
	}

	public int removeBoard(String id) {
		Connection con = JDBCTemplate.getConnection();
		int result = new FBDao().deleteFB(con, id);
		
		if(0 < result) {
			JDBCTemplate.commit(con);
		}else {
			JDBCTemplate.rollback(con);
		}
		
		JDBCTemplate.close(con);
		
		return result;
	}
	

}
