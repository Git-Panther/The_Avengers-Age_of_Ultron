package ein.mono.partners.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import ein.mono.common.JDBCTemplate;
import ein.mono.member.model.vo.MemberVo;
import ein.mono.partners.model.dao.PartnersDao;
import ein.mono.partners.model.vo.PartnersVo;
import ein.mono.profile.model.vo.ProfileVo;

public class PartnersService {

	public ArrayList<ProfileVo> selectPartnersListMain() {
		// TODO Auto-generated method stub
		Connection con = JDBCTemplate.getConnection();
		ArrayList<ProfileVo> list = new PartnersDao().selectPartnersListMain(con);
		JDBCTemplate.close(con); // 자원 반납
		return list;
	}

	public ArrayList<ProfileVo> selectPartnersList(MemberVo member, String category) {
		// TODO Auto-generated method stub
		Connection con = JDBCTemplate.getConnection();
		ArrayList<ProfileVo> list = new PartnersDao().selectPartnersList(con, member, category);
		JDBCTemplate.close(con); // 자원 반납
		return list;
	}

	public ArrayList<ProfileVo> selectPartnersListByKeyword(String condition, String keyword) {
		// TODO Auto-generated method stub
		Connection con = JDBCTemplate.getConnection();
		ArrayList<ProfileVo> list = new PartnersDao().selectPartnersListByKeyword(con, condition, keyword);
		JDBCTemplate.close(con); // 자원 반납

		return list;
	}

}
