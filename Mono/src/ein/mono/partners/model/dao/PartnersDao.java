package ein.mono.partners.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import ein.mono.common.JDBCTemplate;
import ein.mono.profile.model.vo.ProfileVo;
import ein.mono.request.model.dao.RequestDao;

public class PartnersDao {

	private Properties prop = new Properties();
	
	public PartnersDao() {
		String filename = RequestDao.class.getResource("/partners/partners_sql.properties").getPath();
		try {
			prop.load(new FileReader(filename));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<ProfileVo> selectPartnersListMain(Connection con) {
		// TODO Auto-generated method stub
		ArrayList<ProfileVo> list = null;
		// 쿼리는 우수 업체 TOP 3, 내 지역에 가까운 업체 이름 오름차순 TOP 3, 전체 리스트 중 이름 오름차순 TOP 3(스타일 TOP 3 할수도) 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = null;
		try {
			//1. 쿼리 전송 객체 생성
			query = prop.getProperty("selectPartnersListMain");
			pstmt = con.prepareStatement(query);
			//2. 쿼리 작성
			pstmt.setString(1, "우수업체");
			//3. 쿼리 실행
			rs = pstmt.executeQuery();
			//4. 결과 처리(resultSet-list parsing)
			list = new ArrayList<ProfileVo>();
			ProfileVo temp = null;
			HashMap<String, Integer> ptnPhoto = null;
			while(rs.next()){
				temp = new ProfileVo();
				ptnPhoto = new HashMap<String, Integer>();
				temp.setPartnerCode(rs.getString("PTN_CODE"));
				temp.setMemberName(rs.getString("MEMBER_NAME"));
				temp.setMemberRank(rs.getString("MEMBER_RANK"));
				temp.setPartnerLocation(rs.getString("PTN_LOCATION"));
				temp.setMetascore(rs.getInt("METASCORE"));
				ptnPhoto.put(rs.getString("PTN_PHOTO"), 0);
				temp.setPtnPhoto(ptnPhoto);
				temp.setPartnerLogo("PTN_LOGO");
				list.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//5. 자원 반납(close)
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		//6. 결과 리턴	
		return list;
	}

	public ArrayList<ProfileVo> selectPartnersList(Connection con, String category, int currentPage, int limit) {
		// TODO Auto-generated method stub
		ArrayList<ProfileVo> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = null;
		try {
			//1. 쿼리 전송 객체 생성
			query = prop.getProperty("selectPartnersList");
			switch(category){
			case "우수업체":
				query.replaceAll("C1", "WHERE MEMBER RANK = '우수업체'");
				break;
			default:
				query.replaceAll("C1", "");
			}	
			pstmt = con.prepareStatement(query);
			//2. 쿼리 작성
			int startRow = (currentPage - 1) * limit + 1; 
			int endRow = startRow + limit - 1;	
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			//3. 쿼리 실행
			rs = pstmt.executeQuery();
			//4. 결과 처리(resultSet-list parsing)
			list = new ArrayList<ProfileVo>();
			ProfileVo temp = null;
			HashMap<String, Integer> ptnPhoto = null;
			while(rs.next()){
				temp = new ProfileVo();
				ptnPhoto = new HashMap<String, Integer>();
				temp.setPartnerCode(rs.getString("PTN_CODE"));
				temp.setMemberName(rs.getString("MEMBER_NAME"));
				temp.setMemberRank(rs.getString("MEMBER_RANK"));
				temp.setPartnerLocation(rs.getString("PTN_LOCATION"));
				temp.setMetascore(rs.getInt("METASCORE"));
				ptnPhoto.put(rs.getString("PTN_PHOTO"), 0);
				temp.setPtnPhoto(ptnPhoto);
				temp.setPartnerLogo("PTN_LOGO");
				list.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//5. 자원 반납(close)
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		//6. 결과 리턴	
		return list;
	}

	public ArrayList<ProfileVo> selectPartnersListByKeyword(Connection con, String condition, String keyword, int currentPage, int limit) {
		// TODO Auto-generated method stub
		ArrayList<ProfileVo> list = null;
		// 쿼리는 우수 업체 TOP 3, 내 지역에 가까운 업체 이름 오름차순 TOP 3, 전체 리스트 중 이름 오름차순 TOP 3(스타일 TOP 3 할수도) 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = null;
		try {
			//1. 쿼리 전송 객체 생성
			query = prop.getProperty("selectPartnersListByKeyword");
			query.replaceAll("C1", condition); // 지역, 스타일, 업체명 정도만 하는걸로
			pstmt = con.prepareStatement(query);
			//2. 쿼리 작성
			pstmt.setString(1, "%" + keyword + "%");
			int startRow = (currentPage - 1) * limit + 1; 
			int endRow = startRow + limit - 1;	
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			//3. 쿼리 실행
			rs = pstmt.executeQuery();
			//4. 결과 처리(resultSet-list parsing)
			list = new ArrayList<ProfileVo>();
			ProfileVo temp = null;
			HashMap<String, Integer> ptnPhoto = null;
			while(rs.next()){
				temp = new ProfileVo();
				ptnPhoto = new HashMap<String, Integer>();
				temp.setPartnerCode(rs.getString("PTN_CODE"));
				temp.setMemberName(rs.getString("MEMBER_NAME"));
				temp.setMemberRank(rs.getString("MEMBER_RANK"));
				temp.setPartnerLocation(rs.getString("PTN_LOCATION"));
				temp.setMetascore(rs.getInt("METASCORE"));
				ptnPhoto.put(rs.getString("PTN_PHOTO"), 0);
				temp.setPtnPhoto(ptnPhoto);
				temp.setPartnerLogo("PTN_LOGO");
				list.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//5. 자원 반납(close)
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		//6. 결과 리턴	
		return list;
	}

	public ProfileVo selectPartner(Connection con, String ptnCode) {
		ProfileVo ptnProfile = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = null;
		try {
			//1. 쿼리 전송 객체 생성
			query = prop.getProperty("selectPartner");
			pstmt = con.prepareStatement(query);
			//2. 쿼리 작성
			pstmt.setString(1, ptnCode);
			//3. 쿼리 실행
			rs = pstmt.executeQuery();
			//4. 결과 처리(resultSet-list parsing)
			ptnProfile = new ProfileVo();
			while(rs.next()){
				ptnProfile.setPartnerLogo(rs.getString("PTN_LOGO"));
				ptnProfile.setPartnerCode(rs.getString("PTN_CODE"));
				ptnProfile.setMetascore(rs.getInt("METASCORE"));
				ptnProfile.setFavorites(rs.getInt("FAVCOUNT"));
				ptnProfile.setMemberName(rs.getString("MEMBER_NAME"));
				ptnProfile.setMemberRank(rs.getString("MEMBER_RANK"));
				ptnProfile.setPartnerLocation(rs.getString("PTN_LOCATION"));
				ptnProfile.setPartnerStyles(rs.getString("PTN_STYLES"));
				ptnProfile.setPartnerIntro(rs.getString("PTN_INTRO"));
				ptnProfile.setWeekdaysStart(rs.getDate("WEEKDAYS_START"));
				ptnProfile.setWeekdaysEnd(rs.getDate("WEEKDAYS_END"));
				ptnProfile.setWeekendStart(rs.getDate("WEEKEND_START"));
				ptnProfile.setWeekendEnd(rs.getDate("WEEKEND_END"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//5. 자원 반납(close)
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		//6. 결과 리턴	
		return ptnProfile;
	}
	
	public HashMap<String, String> selectPartnerContact(Connection con, String ptnCode) {
		HashMap<String, String> ptnContacts = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = null;
		try {
			//1. 쿼리 전송 객체 생성
			query = prop.getProperty("selectPtnContact");
			pstmt = con.prepareStatement(query);
			//2. 쿼리 작성
			pstmt.setString(1, ptnCode);
			//3. 쿼리 실행
			rs = pstmt.executeQuery();
			//4. 결과 처리(resultSet-list parsing)
			ptnContacts = new HashMap<String, String>();
			while(rs.next()){
				ptnContacts.put(rs.getString("CONTACT_TYPE"), rs.getString("CONTACT_INFO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//5. 자원 반납(close)
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		//6. 결과 리턴	
		return ptnContacts;
	}
	
	public HashMap<String, String> selectPartnerUpdate(Connection con, String ptnCode) {
		HashMap<String, String> ptnUpdates = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = null;
		try {
			//1. 쿼리 전송 객체 생성
			query = prop.getProperty("selectPtnUpdate");
			pstmt = con.prepareStatement(query);
			//2. 쿼리 작성
			pstmt.setString(1, ptnCode);
			//3. 쿼리 실행
			rs = pstmt.executeQuery();
			//4. 결과 처리(resultSet-list parsing)
			ptnUpdates = new HashMap<String, String>();
			while(rs.next()){
				ptnUpdates.put(rs.getString("UPDATE_NAME"), rs.getString("UPDATE_CONTENT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//5. 자원 반납(close)
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		//6. 결과 리턴	
		return ptnUpdates;
	}
	
	public HashMap<String, Integer> selectConstPhoto(Connection con, String ptnCode) {
		HashMap<String, Integer> ptnPhoto = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = null;
		try {
			//1. 쿼리 전송 객체 생성
			query = prop.getProperty("selectConstPhoto");
			pstmt = con.prepareStatement(query);
			//2. 쿼리 작성
			pstmt.setString(1, ptnCode);
			//3. 쿼리 실행
			rs = pstmt.executeQuery();
			//4. 결과 처리(resultSet-list parsing)
			ptnPhoto = new HashMap<String, Integer>();
			while(rs.next()){
				ptnPhoto.put(rs.getString("PTN_PHOTO"), rs.getInt("PTN_PHOTO_NUM"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//5. 자원 반납(close)
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}
		//6. 결과 리턴	
		return ptnPhoto;
	}

	public int selectPartnersTotalCount(Connection con, String category) {
		// TODO Auto-generated method stub
		int partnerCount = -1;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = null;
		try {
			query = prop.getProperty("selectPartnersTotalCount");
			switch(category){
			case "우수업체":
				query.replaceAll("C1", "WHERE MEMBER_RANK = '우수업체'");
				break;
			default:
				query.replaceAll("C1", "");
			}
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			partnerCount = rs.getInt("PARTNERCOUNT");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}		
		return partnerCount;
	}

	public int selectPartnersTotalCount(Connection con, String condition, String keyword) {
		// TODO Auto-generated method stub
		int partnerCount = -1;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = null;
		try {
			query = prop.getProperty("selectPartnersTotalCount");
			query.replaceAll("C1", "WHERE " + condition + " LIKE ?"); // 지역, 스타일, 업체명 정도만 하는걸로
			pstmt = con.prepareStatement(query);
			//2. 쿼리 작성
			pstmt.setString(1, "%" + keyword + "%");
			rs = pstmt.executeQuery();
			partnerCount = rs.getInt("PARTNERCOUNT");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			JDBCTemplate.close(rs);
			JDBCTemplate.close(pstmt);
		}		
		return partnerCount;
	}
}
