package ein.mono.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ein.mono.board.model.vo.PostVo;
import ein.mono.common.JDBCTemplate;

public class PostDao {

	public ArrayList<PostVo> selectPostList(Connection con, String post_type) {
		PreparedStatement pstmt = null;
		String query = null;
		ResultSet rs = null;
		ArrayList<PostVo> list = new ArrayList<PostVo>();
		try {
			// post_type과 일치하는 게시글만 가져오기. 
			// 회원 테이블과 조인해서 작성자의 닉네임도 가져오기.
			query = "SELECT POST_CODE, POST_TYPE, WRITER_CODE, TITLE, CONTENT, ATTACHFILE, VIEWS_COUNT, "
					+ "WRITTEN_DATE, DELFLAG, USERNAME "
					+ "FROM POST "
					+ "JOIN "
					+ "WHERE POST_TYPE = ?";

			pstmt = con.prepareStatement(query);
			pstmt.setString(1, post_type);
			
			rs = pstmt.executeQuery();
			
			// 결과 처리(select -> resultSet)
			PostVo temp = null;
			while(rs.next()) {

				list.add(temp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// close 처리
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public PostVo selectPost(Connection con, String post_code) {
		// post_code를 where조건에서 사용하여 게시글 하나 select해서 리턴
		PostVo post = null;
		
		
		return post;
	}

	public int insertPost(Connection con, PostVo post) {
		// post 객체 게시글 테이블에 insert
		// post_code는 sql 쿼리에서 sequence이용해서 넣어줘야함
		// 		-> post_type에 따라서 if문 또는 switch문 사용하고 
		//			게시판 종류별 스트링 값을 sequence 앞에 붙여줘야함
		// 작성일과 조회수는 default 값 (sysdate, 0).
		int result = 0;
		
		return result;
	}

	public int deletePost(Connection con, String post_code) {
		// post_code에 해당하는 게시글 삭제
		// delflag를 y로 바꾸는 update문 실행
		
		int result = 0;
		
		return result;
	}

	public int updatePost(Connection con, PostVo post) {
		// post 내용 변경.
		int result = 0;
		
		return result;
	}

	// 검색조건과 키워드로 해당되는 게시글 select
	public ArrayList<PostVo> searchPost(Connection con, int condition, String keyword) {
		ArrayList<PostVo> list = null;
		
/*		switch(condition) {
		case 1:
			// 제목
			query += "WHERE NTITLE LIKE '%" + keyword + "%'";
			break;
		case 2:
			query += "WHERE NCONTENT LIKE '%" + keyword + "%'";
			break;
		case 3:
			query += "WHERE USERNAME LIKE '%" + keyword + "%'";
			break;
		case 0:
			query += "WHERE (USERNAME LIKE '%" + keyword + "%'";
			query += "OR NCONTENT LIKE '%" + keyword + "%'";
			query += "OR NTITLE LIKE '%" + keyword + "%')";
			break;
		}
*/		
		
		return list;
	}

}
