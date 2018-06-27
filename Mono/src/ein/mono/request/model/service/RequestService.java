package ein.mono.request.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import ein.mono.common.JDBCTemplate;
import ein.mono.member.model.vo.MemberVo;
import ein.mono.request.model.dao.RequestDao;
import ein.mono.request.model.vo.RequestVo;

public class RequestService {

	public int insertRequest(RequestVo req) {
		// TODO Auto-generated method stub
		Connection con = JDBCTemplate.getConnection();
		// 각종 연결을 실행
		
		// sql 실행
		int result = new RequestDao().insertRequest(con, req);
		JDBCTemplate.close(con); // 자원 반납
		
		return result;
	}

	public int updateRequest(RequestVo req) {
		// TODO Auto-generated method stub
		Connection con = JDBCTemplate.getConnection();
		
		int result = new RequestDao().updateRequest(con, req);
		JDBCTemplate.close(con); // 자원 반납

		return result;
	}

	public int deleteRequest(String reqCode) {
		// TODO Auto-generated method stub
		Connection con = JDBCTemplate.getConnection();
		
		int result = new RequestDao().deleteRequest(con, reqCode);
		JDBCTemplate.close(con); // 자원 반납
		
		return result;
	}

	public int updateTradeCheck(String reqCode, String tradeCheck) {
		// TODO Auto-generated method stub
		Connection con = JDBCTemplate.getConnection();
		
		int result = new RequestDao().updateTradeCheck(con, reqCode, tradeCheck);
		JDBCTemplate.close(con); // 자원 반납
		
		return result;
	}

	public RequestVo selectRequestDetail(MemberVo member, String reqCode) {
		// TODO Auto-generated method stub
		Connection con = JDBCTemplate.getConnection();
		// reqType에 따라 얻는 값이 RequestVo, AuctionVo, ConstructionVo가 될 수 있음.
		RequestVo req = new RequestDao().selectRequestDetail(con, member, reqCode);
		JDBCTemplate.close(con); // 자원 반납
		
		return req;
	}

	public ArrayList<RequestVo> selectRequestList(MemberVo member, String reqType, String reqCheck) {
		// TODO Auto-generated method stub
		Connection con = JDBCTemplate.getConnection();
		
		ArrayList<RequestVo> list = new RequestDao().selectRequestList(con, member, reqType, reqCheck);
		JDBCTemplate.close(con); // 자원 반납

		return list;
	}

	public ArrayList<RequestVo> selectRequestListByKeyword(MemberVo member, String reqType, String reqCheck, String condition,
			String keyword) {
		// TODO Auto-generated method stub
		Connection con = JDBCTemplate.getConnection();

		ArrayList<RequestVo> list = new RequestDao().selectRequestListByKeyword(con, member, reqType, reqCheck, condition,
				keyword);
		JDBCTemplate.close(con); // 자원 반납

		return list;
	}

	public int updateReqCheck(String reqCode, String reqCheck) {
		// TODO Auto-generated method stub
		Connection con = JDBCTemplate.getConnection();
		
		int result = new RequestDao().updateReqCheck(con, reqCode, reqCheck);
		JDBCTemplate.close(con); // 자원 반납

		return result;
	}

}
