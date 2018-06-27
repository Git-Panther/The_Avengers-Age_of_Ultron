package ein.mono.member.model.dao;

import java.sql.Connection;
import java.util.ArrayList;

import ein.mono.member.model.vo.MemberVo;

public class MemberDao {

	public int joinMember(Connection con, MemberVo member) {
		//회원가입
		int result = 0;
		return result;
	}

	public MemberVo loginMember(Connection con, String id) {

		MemberVo result = null;//로그인
		return result;
	}

	public int updateMember(Connection con, MemberVo member) {
		int result = 0;
		return result;//회원정보수정
	}

	public int deleteMember(Connection con, String id) {
		int result = 0;
		return result;//회원삭제
	}

}
