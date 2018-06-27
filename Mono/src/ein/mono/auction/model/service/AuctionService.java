package ein.mono.auction.model.service;

import java.sql.Connection;

import ein.mono.auction.model.dao.AuctionDao;
import ein.mono.auction.model.vo.AuctionPartnerVo;
import ein.mono.auction.model.vo.AuctionVo;
import ein.mono.common.JDBCTemplate;



public class AuctionService {

	public int insertAuction(AuctionVo auc) {
		// TODO Auto-generated method stub
		Connection con = JDBCTemplate.getConnection();
		
		int result = new AuctionDao().insertAuction(con, auc);
		JDBCTemplate.close(con); // 자원 반납

		return result;
	}

	public int updateAuction(AuctionVo auc) {
		// TODO Auto-generated method stub
		Connection con = JDBCTemplate.getConnection();
		
		int result = new AuctionDao().updateAuction(con, auc);
		JDBCTemplate.close(con); // 자원 반납

		return result;
	}

	public int insertAuctionPtn(AuctionPartnerVo aucPtn) {
		// TODO Auto-generated method stub
		Connection con = JDBCTemplate.getConnection();
		
		int result = new AuctionDao().insertAuctionPtn(con, aucPtn);
		JDBCTemplate.close(con); // 자원 반납

		return result;
	}

	public int deleteAuctionPtn(String reqCode, String ptnCode) {
		// TODO Auto-generated method stub
		Connection con = JDBCTemplate.getConnection();
		
		int result = new AuctionDao().deleteAuctionPtn(con, reqCode, ptnCode);
		JDBCTemplate.close(con); // 자원 반납

		return result;
	}

	public int updateAuctionPtn(AuctionPartnerVo auc) {
		// TODO Auto-generated method stub
		Connection con = JDBCTemplate.getConnection();
		
		int result = new AuctionDao().updateAuctionPtn(con, auc);
		JDBCTemplate.close(con); // 자원 반납

		return result;
	}

	public int updatePtnCodeOfAuction(String reqCode, String ptnCode) {
		// TODO Auto-generated method stub
		Connection con = JDBCTemplate.getConnection();
		
		int result = new AuctionDao().updatePtnCodeOfAuction(con, reqCode, ptnCode);
		JDBCTemplate.close(con); // 자원 반납

		return result;
	}

}
