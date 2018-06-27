package ein.mono.favblock.model.dao;

import java.sql.Connection;
import java.util.ArrayList;

import ein.mono.favblock.model.vo.FBVo;

public class FBDao {

	

	public int insertFav(Connection con, FBVo LB) {
		int result = 0;
		return result;
	}

	public int updateBlock(Connection con, FBVo LB) {
		int result = 0;
		return result;
	}

	public ArrayList<FBVo> selectLBList(Connection con) {//리스트 조회는 페이징 처리
		
		ArrayList<FBVo> list = null;
		return list;
		
	}

	public int deleteFB(Connection con, String id) {
		int result = 0;
		return result;
	}

}
