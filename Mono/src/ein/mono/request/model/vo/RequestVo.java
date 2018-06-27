package ein.mono.request.model.vo;

import java.util.Date;
import java.util.List;

public class RequestVo { // 신청 공통 사항
	private String reqCode; // 신청 코드
	private String reqTitle; // 신청 제목
	private String memberCode; // 신청자의 코드
	private String memberName; // 신청자의 이름
	private String ptnCode; // 시공을 담당할 업체
	private String ptnName; // 시공을 담당할 업체의 이름
	private String constAddress; // 시공지 주소
	private String reqContent; // 상세한 시공 요청 사항
	private List<String> samplePhotoUrls; // 희망하는 시공 사진(2매까지)
	private int reqPrice; // 경매희망가
	private Date reqDate; // 시공희망일
	private Date startDate; // 신청한 날짜. 경매는 끝나는 날짜도 있다.
	private String reqCheck; // 주문 상태를 표시(경매중 등등)
	private String tradeCheck; // 거래 상태를 표시(선불 등)
	private int size; // 평수
	private boolean veranda; // 베란다 여부
	private List<String> electrics; // 전기 조명 여부
	private String flooring; // 바닥재
	private String papering; // 도배
	private String coating; // 도장재
	private List<String> innerConst; // 내부 시공 항목 체크사항들(천장, 중문, 창호, 타일, 욕실, 주방, 기타-입주 청소)
	private String reqType; // 주문 분류
	private Date constStartDate; // 시공시작일
	private Date constEndDate; // 시공종료일
	
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

	public String getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}

	public String getPtnCode() {
		return ptnCode;
	}

	public void setPtnCode(String ptnCode) {
		this.ptnCode = ptnCode;
	}

	public String getConstAddress() {
		return constAddress;
	}

	public void setConstAddress(String constAddress) {
		this.constAddress = constAddress;
	}

	public String getReqContent() {
		return reqContent;
	}

	public void setReqContent(String reqContent) {
		this.reqContent = reqContent;
	}

	public List<String> getSamplePhotoUrls() {
		return samplePhotoUrls;
	}

	public void setSamplePhotoUrls(List<String> samplePhotoUrls) {
		this.samplePhotoUrls = samplePhotoUrls;
	}

	public int getReqPrice() {
		return reqPrice;
	}

	public void setReqPrice(int reqPrice) {
		this.reqPrice = reqPrice;
	}

	public Date getReqDate() {
		return reqDate;
	}

	public void setReqDate(Date reqDate) {
		this.reqDate = reqDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getReqCheck() {
		return reqCheck;
	}

	public void setReqCheck(String reqCheck) {
		this.reqCheck = reqCheck;
	}

	public String getTradeCheck() {
		return tradeCheck;
	}

	public void setTradeCheck(String tradeCheck) {
		this.tradeCheck = tradeCheck;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public boolean isVeranda() {
		return veranda;
	}

	public void setVeranda(boolean veranda) {
		this.veranda = veranda;
	}

	public List<String> getElectrics() {
		return electrics;
	}

	public void setElectrics(List<String> electrics) {
		this.electrics = electrics;
	}

	public String getFlooring() {
		return flooring;
	}

	public void setFlooring(String flooring) {
		this.flooring = flooring;
	}

	public String getPapering() {
		return papering;
	}

	public void setPapering(String papering) {
		this.papering = papering;
	}

	public String getCoating() {
		return coating;
	}

	public void setCoating(String coating) {
		this.coating = coating;
	}

	public List<String> getInnerConst() {
		return innerConst;
	}

	public void setInnerConst(List<String> innerConst) {
		this.innerConst = innerConst;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getPtnName() {
		return ptnName;
	}

	public void setPtnName(String ptnName) {
		this.ptnName = ptnName;
	}

	public String getReqType() {
		return reqType;
	}

	public void setReqType(String reqType) {
		this.reqType = reqType;
	}
	public Date getConstStartDate() {
		return constStartDate;
	}
	public void setConstStartDate(Date constStartDate) {
		this.constStartDate = constStartDate;
	}
	public Date getConstEndDate() {
		return constEndDate;
	}
	public void setConstEndDate(Date constEndDate) {
		this.constEndDate = constEndDate;
	}
}
