package ein.mono.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ein.mono.board.model.vo.ReplyVo;
import ein.mono.common.JDBCTemplate;

public class ReplyDao {

	public ArrayList<ReplyVo> selectReplyList(Connection con, String post_code) {
		ArrayList<ReplyVo> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";
		
		try {
			// post_code를 비교해서 해당 게시글의 댓글만 가져와야함
			query = "";

			pstmt = con.prepareStatement(query);
			pstmt.setString(1, post_code);
				
			rs = pstmt.executeQuery();
			
			list = new ArrayList<ReplyVo>();
			ReplyVo temp = null;
			while(rs.next()) {
				temp = new ReplyVo();
				
				list.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}

	public int insertReply(Connection con, ReplyVo reply) {
		// reply.getPost_code() 이용해서 해당 댓글이 달릴 게시글코드 가져옴
		int result = 0;

		return result;
	}

	public int updateReply(Connection con, ReplyVo reply) {
		int result = 0;

		return result;
	}

	public int deleteReply(Connection con, String reply_code) {
		int result = 0;

		return result;
	}
	
}
