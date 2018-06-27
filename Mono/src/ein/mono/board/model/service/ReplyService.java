package ein.mono.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import ein.mono.board.model.dao.ReplyDao;
import ein.mono.board.model.vo.ReplyVo;
import ein.mono.common.JDBCTemplate;

public class ReplyService {
	public ArrayList<ReplyVo> selectReplyList(String post_code) {
		// 커넥션 생성
		Connection con = JDBCTemplate.getConnection();
		// 기능 호출
		ArrayList<ReplyVo> list = new ReplyDao().selectReplyList(con, post_code);

		JDBCTemplate.close(con);
		
		// 결과 반환
		return list;
	}

	public int insertReply(ReplyVo reply) {
		Connection con = JDBCTemplate.getConnection();
		
		int result = new ReplyDao().insertReply(con, reply);
		
		if(0 < result) {
			JDBCTemplate.commit(con);
		} else {
			JDBCTemplate.rollback(con);
		}
		
		JDBCTemplate.close(con);
		
		return result;
	}

	public int updateReply(ReplyVo reply) {
		Connection con = JDBCTemplate.getConnection();
		
		int result = new ReplyDao().updateReply(con, reply);
		
		if(0 < result) {
			JDBCTemplate.commit(con);
		} else {
			JDBCTemplate.rollback(con);
		}
		
		JDBCTemplate.close(con);
		
		return result;
	}

	public int deleteReply(String reply_code) {
		Connection con = JDBCTemplate.getConnection();
		
		int result = new ReplyDao().deleteReply(con, reply_code);
		
		if(0 < result) {
			JDBCTemplate.commit(con);
		} else {
			JDBCTemplate.rollback(con);
		}
		
		JDBCTemplate.close(con);
		
		return result;
	}
}
