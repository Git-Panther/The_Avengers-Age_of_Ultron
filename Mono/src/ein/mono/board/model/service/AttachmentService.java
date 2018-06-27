package ein.mono.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import ein.mono.board.model.dao.AttachmentDao;
import ein.mono.board.model.dao.PostDao;
import ein.mono.board.model.vo.AttachmentVo;
import ein.mono.board.model.vo.PostVo;
import ein.mono.common.JDBCTemplate;

public class AttachmentService {

	public ArrayList<AttachmentVo> selectAttachmentList(String post_code) {
		Connection con = JDBCTemplate.getConnection();
		
		ArrayList<AttachmentVo> list = new AttachmentDao().selectAttachmentList(con, post_code);
		
		JDBCTemplate.close(con);
		
		return list;
	}

	public ArrayList<AttachmentVo> selectThumnailAttachmentList() {
		Connection con = JDBCTemplate.getConnection();
		
		ArrayList<AttachmentVo> list = new AttachmentDao().selectThumnailAttachmentList(con);
		
		JDBCTemplate.close(con);
		
		return list;
	}
	
	public int insertAttachment(String post_code, ArrayList<AttachmentVo> list) {
		Connection con = JDBCTemplate.getConnection();
		
		// 3. ATTACHMENT 객체들에 외래키 설정
		for(AttachmentVo av : list) {
			av.setPost_code(post_code);
		}
		
		// 4. 해당 객체들 DB에 저장
		int result = new AttachmentDao().insertAttachment(con, list);
		if(0 < result) {
			JDBCTemplate.commit(con);
			result = 1;
		} else {
			JDBCTemplate.rollback(con);
		}
		
		return result;
	}
	
	public int updateAttachment(String post_code, ArrayList<AttachmentVo> list) {
		Connection con = JDBCTemplate.getConnection();
		
		int result = new AttachmentDao().updateAttachment(con, post_code, list);
		
		return result;
	}
	
}
