package ein.mono.member.model.service;

import java.sql.Connection;

import ein.mono.common.JDBCTemplate;
import ein.mono.member.model.dao.MemberDao;
import ein.mono.member.model.vo.MemberVo;

public class MemberService {

	public int joinMember(MemberVo member) {
		
		Connection con = JDBCTemplate.getConnection();
		int result = new MemberDao().joinMember(con, member);
		if(0 < result) {
			JDBCTemplate.commit(con);
		}else {
			JDBCTemplate.rollback(con);
		}
		
		JDBCTemplate.close(con);
		
		return result;
	}

	public MemberVo loginMember(String id ) {
		
		Connection con = JDBCTemplate.getConnection(); 
		
		MemberVo result = new MemberDao().loginMember(con, id);
		
			JDBCTemplate.close(con);
		
			return result;
	}

	public int updateMember(MemberVo member) {
		
		Connection con = JDBCTemplate.getConnection();
		int result = new MemberDao().updateMember(con, member);
		if(0 < result) {
			JDBCTemplate.commit(con);
		}else {
			JDBCTemplate.rollback(con);
		}
		
		JDBCTemplate.close(con);
		
		return result;
	}

	public int deleteMember(String id) {
		
		Connection con = JDBCTemplate.getConnection();
		int result = new MemberDao().deleteMember(con, id);
		if(0 < result) {
			JDBCTemplate.commit(con);
		}else {
			JDBCTemplate.rollback(con);
		}
		
		JDBCTemplate.close(con);
		
		return result;
	}

	
}
