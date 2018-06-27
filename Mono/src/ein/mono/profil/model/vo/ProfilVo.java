package ein.mono.profil.model.vo;

import ein.mono.member.model.vo.MemberVo;

public class ProfilVo extends MemberVo{
	//memberVo를 상속받고 + 업체 추가 정보
	
	private String partnerCode; //업체코드
	private String partnerOwner; //대표자명
	private String partnerCheck; //승인여부
	private String partnerLicense; //사업자등록증
	private String partnerLogo; //업체로고
	private String partnerLocation; //시공지역
	private String partnerStyles; //스타일
	private String partnerIntro; //업체소개
	
	private String weekdaysStart;
	private String weekdaysEnd;
	private String weekendStart;
	private String weekendEnd;
	
	
	public ProfilVo(){}


	public ProfilVo(String partnerCode, String partnerOwner, String partnerCheck, String partnerLicense,
			String partnerLogo, String partnerLocation, String partnerStyles, String partnerIntro, String weekdaysStart,
			String weekdaysEnd, String weekendStart, String weekendEnd) {
		super();
		this.partnerCode = partnerCode;
		this.partnerOwner = partnerOwner;
		this.partnerCheck = partnerCheck;
		this.partnerLicense = partnerLicense;
		this.partnerLogo = partnerLogo;
		this.partnerLocation = partnerLocation;
		this.partnerStyles = partnerStyles;
		this.partnerIntro = partnerIntro;
		this.weekdaysStart = weekdaysStart;
		this.weekdaysEnd = weekdaysEnd;
		this.weekendStart = weekendStart;
		this.weekendEnd = weekendEnd;
	}


	public String getPartnerCode() {
		return partnerCode;
	}


	public void setPartnerCode(String partnerCode) {
		this.partnerCode = partnerCode;
	}


	public String getPartnerOwner() {
		return partnerOwner;
	}


	public void setPartnerOwner(String partnerOwner) {
		this.partnerOwner = partnerOwner;
	}


	public String getPartnerCheck() {
		return partnerCheck;
	}


	public void setPartnerCheck(String partnerCheck) {
		this.partnerCheck = partnerCheck;
	}


	public String getPartnerLicense() {
		return partnerLicense;
	}


	public void setPartnerLicense(String partnerLicense) {
		this.partnerLicense = partnerLicense;
	}


	public String getPartnerLogo() {
		return partnerLogo;
	}


	public void setPartnerLogo(String partnerLogo) {
		this.partnerLogo = partnerLogo;
	}


	public String getPartnerLocation() {
		return partnerLocation;
	}


	public void setPartnerLocation(String partnerLocation) {
		this.partnerLocation = partnerLocation;
	}


	public String getPartnerStyles() {
		return partnerStyles;
	}


	public void setPartnerStyles(String partnerStyles) {
		this.partnerStyles = partnerStyles;
	}


	public String getPartnerIntro() {
		return partnerIntro;
	}


	public void setPartnerIntro(String partnerIntro) {
		this.partnerIntro = partnerIntro;
	}


	public String getWeekdaysStart() {
		return weekdaysStart;
	}


	public void setWeekdaysStart(String weekdaysStart) {
		this.weekdaysStart = weekdaysStart;
	}


	public String getWeekdaysEnd() {
		return weekdaysEnd;
	}


	public void setWeekdaysEnd(String weekdaysEnd) {
		this.weekdaysEnd = weekdaysEnd;
	}


	public String getWeekendStart() {
		return weekendStart;
	}


	public void setWeekendStart(String weekendStart) {
		this.weekendStart = weekendStart;
	}


	public String getWeekendEnd() {
		return weekendEnd;
	}


	public void setWeekendEnd(String weekendEnd) {
		this.weekendEnd = weekendEnd;
	}


	@Override
	public String toString() {
		return "ProfilVo [partnerCode=" + partnerCode + ", partnerOwner=" + partnerOwner + ", partnerCheck="
				+ partnerCheck + ", partnerLicense=" + partnerLicense + ", partnerLogo=" + partnerLogo
				+ ", partnerLocation=" + partnerLocation + ", partnerStyles=" + partnerStyles + ", partnerIntro="
				+ partnerIntro + ", weekdaysStart=" + weekdaysStart + ", weekdaysEnd=" + weekdaysEnd + ", weekendStart="
				+ weekendStart + ", weekendEnd=" + weekendEnd + "]";
	}
	
	
	
	
	
	
	
	
}
