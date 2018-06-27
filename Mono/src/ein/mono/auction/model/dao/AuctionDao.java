package ein.mono.auction.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

import ein.mono.auction.model.vo.AuctionPartnerVo;
import ein.mono.auction.model.vo.AuctionVo;

public class AuctionDao {

	private Properties prop = new Properties();
	
	public AuctionDao() {
		String filename = AuctionDao.class.getResource("/auction/auction_sql.properties").getPath();
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
	
	public int insertAuction(Connection con, AuctionVo auc) {
		// TODO Auto-generated method stub
		// AuctionVo 내용 바탕으로 삽입
		int result = 0;
		return result;
	}

	public int updateAuction(Connection con, AuctionVo auc) {
		// TODO Auto-generated method stub
		// 변경된 경매 사항을 반영
		int result = 0;
		return result;
	}

	public int insertAuctionPtn(Connection con, AuctionPartnerVo aucPtn) {
		// TODO Auto-generated method stub
		// 업체의 경매 신청 반영
		int result = 0;
		
		return result;
	}

	public int deleteAuctionPtn(Connection con, String reqCode, String ptnCode) {
		// TODO Auto-generated method stub
		// 경매 신청 취소 : delete
		int result = 0;
		
		return result;
	}

	public int updateAuctionPtn(Connection con, AuctionPartnerVo auc) {
		// TODO Auto-generated method stub
		int result = 0;
		// 업체의 경매 금액 변경사항 반영
		
		return result;
	}

	public int updatePtnCodeOfAuction(Connection con, String reqCode, String ptnCode) {
		// TODO Auto-generated method stub
		// 1. Update를 통해 request_ptn 테이블의 ptnCode, reqCode를 보유한 행의 입찰여부를 'T'로 바꿈
		// 2. 트리거를 통해 Request 테이블의 ptn_code를 ptnCode로 바꾸거나 다시 Update를 통해 ptn_code 갱신
		int result = 0;
		
		return result;
	}

}
