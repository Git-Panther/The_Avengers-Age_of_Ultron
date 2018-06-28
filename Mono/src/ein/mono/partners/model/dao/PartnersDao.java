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
import ein.mono.member.model.vo.MemberVo;
import ein.mono.partners.model.vo.PartnersVo;
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

	public ArrayList<ProfileVo> selectPartnersList(Connection con, MemberVo member, String category) {
		// TODO Auto-generated method stub
		ArrayList<ProfileVo> list = null;
		// 쿼리는 우수 업체 TOP 3, 내 지역에 가까운 업체 이름 오름차순 TOP 3, 전체 리스트 중 이름 오름차순 TOP 3(스타일 TOP 3 할수도) 
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

	public ArrayList<ProfileVo> selectPartnersListByKeyword(Connection con, String condition, String keyword) {
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
			pstmt.setString(1, "'%" + keyword + "%'");
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

}
