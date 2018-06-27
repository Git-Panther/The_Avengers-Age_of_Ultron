package ein.mono.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import ein.mono.board.model.dao.PostDao;
import ein.mono.board.model.vo.PostVo;
import ein.mono.common.JDBCTemplate;

public class PostService {
	public ArrayList<PostVo> selectPostList(String post_type){
		Connection con = JDBCTemplate.getConnection();
		
		ArrayList<PostVo> boardList = new PostDao().selectPostList(con, post_type);
		
		JDBCTemplate.close(con);
		
		return boardList;
	}

	public PostVo selectPost(String post_code) {
		Connection con = JDBCTemplate.getConnection();
		
		PostVo post = new PostDao().selectPost(con, post_code);
		
		JDBCTemplate.close(con);
		
		return post;
	}

	public int insertPost(PostVo post) {
		Connection con = JDBCTemplate.getConnection();
		
		int result = new PostDao().insertPost(con, post);
		
		if(0 < result) {
			JDBCTemplate.commit(con);
		} else {
			JDBCTemplate.rollback(con);
		}
		
		return result;
	}

	public int deletePost(String post_code) {
		Connection con = JDBCTemplate.getConnection();
		
		int result = new PostDao().deletePost(con, post_code);
		
		if(0 < result) {
			JDBCTemplate.commit(con);
		} else {
			JDBCTemplate.rollback(con);
		}
		
		return result;

	}

	public int updatePost(PostVo post) {
		Connection con = JDBCTemplate.getConnection();
		
		int result = new PostDao().updatePost(con, post);
		
		if(0 < result) {
			JDBCTemplate.commit(con);
		} else {
			JDBCTemplate.rollback(con);
		}
		
		return result;
	}

	public ArrayList<PostVo> searchPost(int condition, String keyword) {
		Connection con = JDBCTemplate.getConnection();

		ArrayList<PostVo> postList = new PostDao().searchPost(con, condition, keyword);
		
		JDBCTemplate.close(con);
		
		return postList;
	}
}
