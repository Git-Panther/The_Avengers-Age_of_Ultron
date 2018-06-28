package ein.mono.profile.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import ein.mono.common.JDBCTemplate;
import ein.mono.profile.model.dao.ProfileDao;
import ein.mono.profile.model.vo.ProfileVo;

public class ProfileService {

	public ArrayList<ProfileVo> selectProfileList(int pCode) {
		
		//1. 커넥션 연결
		Connection con = JDBCTemplate.getConnection(); 
	//2. dao 메소드 호출
		ArrayList<ProfileVo> list = new ProfileDao().selectProfileList(con, pCode);
	//3. 자원반납
		JDBCTemplate.close(con);
	//4. 해당 결과 리턴
		return list;
	}

	public int updateProfile(ProfileVo profil) {
		Connection con = JDBCTemplate.getConnection();
		int result = new ProfileDao().updateProfile(con, profil);
		if(0 < result) {
			JDBCTemplate.commit(con);
		}else {
			JDBCTemplate.rollback(con);
		}
		
		JDBCTemplate.close(con);
		
		return result;
	}

}
