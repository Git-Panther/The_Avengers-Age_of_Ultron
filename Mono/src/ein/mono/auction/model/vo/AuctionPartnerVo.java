package ein.mono.auction.model.vo;

public class AuctionPartnerVo { // 사실 업체 클래스 상속할 수도 있다.
	private String ptnCode; // 경매 참여 업체의 코드
	private String ptnName; // 경매 참여 업체의 업체명
	private String reqCode;
	private String reqTitle;
	private int ptnPay; // 경매 참여자가 부른 값
	private boolean bidCheck; // 경매 낙찰 여부
	
	public AuctionPartnerVo() {
		super();
	}

	public AuctionPartnerVo(String ptnCode, String ptnName, String reqCode, String reqTitle, int ptnPay,
			boolean bidCheck) {
		super();
		this.ptnCode = ptnCode;
		this.ptnName = ptnName;
		this.reqCode = reqCode;
		this.reqTitle = reqTitle;
		this.ptnPay = ptnPay;
		this.bidCheck = bidCheck;
	}

	public String getPtnCode() {
		return ptnCode;
	}

	public void setPtnCode(String ptnCode) {
		this.ptnCode = ptnCode;
	}

	public String getPtnName() {
		return ptnName;
	}

	public void setPtnName(String ptnName) {
		this.ptnName = ptnName;
	}

	public int getPtnPay() {
		return ptnPay;
	}

	public void setPtnPay(int ptnPay) {
		this.ptnPay = ptnPay;
	}

	public boolean isBidCheck() {
		return bidCheck;
	}

	public void setBidCheck(boolean bidCheck) {
		this.bidCheck = bidCheck;
	}

	public String getReqCode() {
		return reqCode;
	}

	public void setReqCode(String reqCode) {
		this.reqCode = reqCode;
	}

	public String getReqTitle() {
		return reqTitle;
	}

	public void setReqTitle(String reqTitle) {
		this.reqTitle = reqTitle;
	}
}
