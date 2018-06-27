package ein.mono.profil.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import ein.mono.common.JDBCTemplate;
import ein.mono.profil.model.dao.ProfilDao;
import ein.mono.profil.model.vo.ProfilVo;

public class ProfilService {

	public ArrayList<ProfilVo> selectProfilList(int pCode) {
		
		//1. 커넥션 연결
		Connection con = JDBCTemplate.getConnection(); 
	//2. dao 메소드 호출
		ArrayList<ProfilVo> list = new ProfilDao().selectProfilList(con, pCode);
	//3. 자원반납
		JDBCTemplate.close(con);
	//4. 해당 결과 리턴
		return list;
	}

	public int updateProfil(ProfilVo profil) {
		Connection con = JDBCTemplate.getConnection();
		int result = new ProfilDao().updateProfil(con, profil);
		if(0 < result) {
			JDBCTemplate.commit(con);
		}else {
			JDBCTemplate.rollback(con);
		}
		
		JDBCTemplate.close(con);
		
		return result;
	}

}
