package ein.mono.partners.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import ein.mono.common.JDBCTemplate;
import ein.mono.partners.model.dao.PartnersDao;
import ein.mono.profile.model.vo.ProfileVo;
import ein.mono.profile.model.vo.PtnContact;
import ein.mono.profile.model.vo.PtnUpdate;

public class PartnersService {

	private PartnersDao partnerDao = new PartnersDao();
	
	public ArrayList<ProfileVo> selectPartnersListMain(String type) { // 업체 지정 메인 페이지 한정
		// TODO Auto-generated method stub
		Connection con = JDBCTemplate.getConnection();
		ArrayList<ProfileVo> list = partnerDao.selectPartnersListMain(con, type);
		JDBCTemplate.close(con); // 자원 반납
		return list;
	}

	public ArrayList<ProfileVo> selectPartnersList(String category, int currentPage, int limit) { // 업체 지정 중 기준에 따라 페이지만큼 떼서 가져옴
		// TODO Auto-generated method stub
		Connection con = JDBCTemplate.getConnection();
		ArrayList<ProfileVo> list = partnerDao.selectPartnersList(con, category, currentPage, limit);
		JDBCTemplate.close(con); // 자원 반납
		return list;
	}

	public ArrayList<ProfileVo> selectPartnersListByKeyword(String condition, String keyword, int currentPage, int limit) {
		// TODO Auto-generated method stub
		Connection con = JDBCTemplate.getConnection();
		ArrayList<ProfileVo> list = partnerDao.selectPartnersListByKeyword(con, condition, keyword, currentPage, limit);
		JDBCTemplate.close(con); // 자원 반납
		return list;
	}

	public ProfileVo selectPartner(String ptnCode) {
		// TODO Auto-generated method stub
		Connection con = JDBCTemplate.getConnection();
		ProfileVo ptnProfile = partnerDao.selectPartner(con, ptnCode);
		if(null == ptnProfile){
			JDBCTemplate.close(con); // 자원 반납
			return null;
		}
		ArrayList<PtnContact> ptnContacts = partnerDao.selectPartnerContact(con, ptnCode);
		if(null == ptnContacts){
			JDBCTemplate.close(con); // 자원 반납
			return null;
		}
		ArrayList<PtnUpdate> ptnUpdate = partnerDao.selectPartnerUpdate(con, ptnCode);
		if(null == ptnUpdate){
			JDBCTemplate.close(con); // 자원 반납
			return null;
		}
		HashMap<Integer, String> ptnPhoto = partnerDao.selectConstPhoto(con, ptnCode);
		if(null == ptnPhoto){
			JDBCTemplate.close(con); // 자원 반납
			return null;
		}
		
		ptnProfile.setPtnContacts(ptnContacts);
		ptnProfile.setPtnUpdates(ptnUpdate);
		ptnProfile.setPtnPhoto(ptnPhoto);
		
		JDBCTemplate.close(con); // 자원 반납
		return ptnProfile;
	}

	public int selectPartnersTotalCount(String category) {
		// TODO Auto-generated method stub
		//커넥션 생성
		Connection con = JDBCTemplate.getConnection();
		//비지니스 로직 호출
		int listCount = partnerDao.selectPartnersTotalCount(con, category);
		//자원 반납(close)
		JDBCTemplate.close(con);
		//결과 반환
		return listCount;
	}

	public int selectPartnersTotalCount(String condition, String keyword) {
		// TODO Auto-generated method stub
		//커넥션 생성
		Connection con = JDBCTemplate.getConnection();
		//비지니스 로직 호출
		int listCount = partnerDao.selectPartnersTotalCount(con, condition, keyword);
		//자원 반납(close)
		JDBCTemplate.close(con);
		//결과 반환
		return listCount;
	}

	public boolean hasFavPtn(String memberCode, String partnerCode) {
		// TODO Auto-generated method stub
		//커넥션 생성
		Connection con = JDBCTemplate.getConnection();
		//비지니스 로직 호출
		int favPtnCount = partnerDao.selectFavPtnCount(con, memberCode, partnerCode);
		//자원 반납(close)
		JDBCTemplate.close(con);
		//결과 반환
		if(favPtnCount == 1) return true;
		else return false;
	}

}
