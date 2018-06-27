package ein.mono.profil.model.dao;

import java.sql.Connection;
import java.util.ArrayList;

import ein.mono.profil.model.vo.ProfilVo;

public class ProfilDao {

	public ArrayList<ProfilVo> selectProfilList(Connection con, int pCode) {
		
		ArrayList<ProfilVo> list = null;
		return list;
	}

	public int updateProfil(Connection con, ProfilVo profil) {
		int result = 0;
		return result;
	}

}
