package ein.mono.profile.model.dao;

import java.sql.Connection;
import java.util.ArrayList;

import ein.mono.profile.model.vo.ProfileVo;

public class ProfileDao {

	public ArrayList<ProfileVo> selectProfileList(Connection con, int pCode) {
		
		ArrayList<ProfileVo> list = null;
		return list;
	}

	public int updateProfile(Connection con, ProfileVo profil) {
		int result = 0;
		return result;
	}

}
