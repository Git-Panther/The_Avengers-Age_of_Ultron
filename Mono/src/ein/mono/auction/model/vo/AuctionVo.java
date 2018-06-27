package ein.mono.auction.model.vo;

import java.util.Date;
import java.util.List;

import ein.mono.request.model.vo.RequestVo;

public class AuctionVo extends RequestVo { // 경매 추가 사항
	private Date endDate; // 경매 꿑나는 날짜
	private List<AuctionPartnerVo> auctionPtns; // 경매 참여자들의 정보
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public List<AuctionPartnerVo> getAuctionPtns() {
		return auctionPtns;
	}
	public void setAuctionPtns(List<AuctionPartnerVo> auctionPtns) {
		this.auctionPtns = auctionPtns;
	}
}
