package ein.mono.partners.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Properties;

import ein.mono.member.model.vo.MemberVo;
import ein.mono.partners.model.vo.PartnersVo;
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
	
	public ArrayList<PartnersVo> selectPartnersListMain(Connection con) {
		// TODO Auto-generated method stub
		ArrayList<PartnersVo> list = null;
		// 쿼리는 우수 업체 TOP 3, 내 지역에 가까운 업체 이름 오름차순 TOP 3, 전체 리스트 중 이름 오름차순 TOP 3(스타일 TOP 3 할수도) 
		
		return list;
	}

	public ArrayList<PartnersVo> selectPartnersList(Connection con, MemberVo member, String category) {
		// TODO Auto-generated method stub
		ArrayList<PartnersVo> list = null;
		// 쿼리는 전달된 카테고리에 따라 달라진다.
		return list;
	}

	public ArrayList<PartnersVo> selectPartnersListByKeyword(Connection con, String condition, String keyword) {
		// TODO Auto-generated method stub
		ArrayList<PartnersVo> list = null;
		// 쿼리는 전달된 검색 조건에 따라 달라진다.
		return list;
	}

}
