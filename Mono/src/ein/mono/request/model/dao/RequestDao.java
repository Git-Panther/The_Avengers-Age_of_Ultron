package ein.mono.request.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Properties;

import ein.mono.member.model.vo.MemberVo;
import ein.mono.request.model.vo.RequestVo;

public class RequestDao {
	
	private Properties prop = new Properties();
	
	public RequestDao() {
		String filename = RequestDao.class.getResource("/request/request_sql.properties").getPath();
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
	
	public int insertRequest(Connection con, RequestVo req) {
		// TODO Auto-generated method stub
		// RequestVo 정보 토대로 삽입
		int result = 0;
		
		return result;
	}

	public int updateRequest(Connection con, RequestVo req) {
		// TODO Auto-generated method stub
		// 주의 : Request 테이블 뿐만 아니라 Req_Info 테이블도 수정해줘야 함.
		String query = null;
		int result = 0;
		
		return result;
	}

	public int deleteRequest(Connection con, String reqCode) {
		// TODO Auto-generated method stub
		// 삭제 쿼리 작성하여 삭제하거나 delflag를 'T'로 바꾼다.
		int result = 0;
		
		return result;
	}

	public int updateTradeCheck(Connection con, String reqCode, String tradeCheck) {
		// TODO Auto-generated method stub
		// 전달받은 reqCode에서 tradeCheck를 해당 값으로 변경
		int result = 0;
		return result;
	}

	public RequestVo selectRequestDetail(Connection con, MemberVo member, String reqType) {
		// TODO Auto-generated method stub
		// 1. member.getMemberType()이 고객이냐 업체냐에 따라 query가 달라짐
		// 2. 조건절에 member.getMemberCode()와 reqCode 추가
		// 3. query 실행 후 결과에서 reqType이 일반 주문이면 RequestVo, 경매면 AuctionVo, 시공이면 ConstructionVo를 반환
		RequestVo rv = null; // 주의 : 경매이면 경매 관련된 업체들 정보도 따로 쿼리 실행하여 가져와야 함
		
		return rv;
	}

	public ArrayList<RequestVo> selectRequestList(Connection con, MemberVo member, String reqType, String reqCheck) {
		// TODO Auto-generated method stub
		String query = null;
		ArrayList<RequestVo> list = null; // reqType이 뭐냐에 따라 RequestVo, AuctionVo, ConstructionVo가 들어감
		// 1. member.getMemberType()이 고객이냐 업체냐에 따라 query가 달라짐
		// 2. reqType, reqCheck가 all이면 해당 범주 내 모든 리스트, 아니면 해당하는 값으로 조건을 넣어준다.		
		
		return list;
	}

	public ArrayList<RequestVo> selectRequestListByKeyword(Connection con, MemberVo member, String reqType, String reqCheck,
			String condition, String keyword) {
		// TODO Auto-generated method stub
		String query = null;
		ArrayList<RequestVo> list = null; // reqType이 뭐냐에 따라 RequestVo, AuctionVo, ConstructionVo가 들어감
		// 1. member.getMemberType()이 고객이냐 업체냐에 따라 query가 달라짐
		// 2. reqType, reqCheck가 all이면 해당 범주 내 모든 리스트, 아니면 해당하는 값으로 조건을 넣어준다.
		// 3. 검색 조건을 맞춰줌
		
		return list;
	}

	public int updateReqCheck(Connection con, String reqCode, String reqCheck) {
		// TODO Auto-generated method stub
		// reqCheck 수정된 사항 반영
		int result = 0;
		
		return result;
	}

}
