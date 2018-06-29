package ein.mono.profile.model.vo;

import java.util.Date;
import java.util.HashMap;

import ein.mono.member.model.vo.MemberVo;

public class ProfileVo extends MemberVo{
	//memberVo를 상속받고 + 업체 추가 정보
	
	private String partnerCode; //업체코드
	private String partnerOwner; //대표자명
	private String partnerCheck; //승인여부
	private String partnerLicense; //사업자등록증
	private String partnerLogo; //업체로고
	private String partnerLocation; //시공지역
	private String partnerStyles; //스타일
	private String partnerIntro; //업체소개
	private Date weekdaysStart; // 평일상담시작시간
	private Date weekdaysEnd; // 평일상담종료시간
	private Date weekendStart; // 주말상담시작시간
	private Date weekendEnd; // 주말상담종료시간

	private HashMap<String, String> ptnUpdates = new HashMap<String, String>();// 추가정보 리스트	
	private HashMap<String, String> ptnContacts = new HashMap<String, String>();// 연락처
	private HashMap<Integer, String> ptnPhoto = new HashMap<Integer, String>(); // 업체 사진들. Integer는 우선순위, String은 파일명
	private int favorites; // 즐겨찾기 보유수
	private int metascore; // 평점
	
	public ProfileVo(){}

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


	public Date getWeekdaysStart() {
		return weekdaysStart;
	}


	public void setWeekdaysStart(Date weekdaysStart) {
		this.weekdaysStart = weekdaysStart;
	}


	public Date getWeekdaysEnd() {
		return weekdaysEnd;
	}


	public void setWeekdaysEnd(Date weekdaysEnd) {
		this.weekdaysEnd = weekdaysEnd;
	}


	public Date getWeekendStart() {
		return weekendStart;
	}


	public void setWeekendStart(Date weekendStart) {
		this.weekendStart = weekendStart;
	}


	public Date getWeekendEnd() {
		return weekendEnd;
	}


	public void setWeekendEnd(Date weekendEnd) {
		this.weekendEnd = weekendEnd;
	}

	
	
	public HashMap<String, String> getPtnUpdates() {
		return ptnUpdates;
	}


	public void setPtnUpdates(HashMap<String, String> ptnUpdates) {
		this.ptnUpdates = ptnUpdates;
	}


	public HashMap<String, String> getPtnContacts() {
		return ptnContacts;
	}


	public void setPtnContacts(HashMap<String, String> ptnContacts) {
		this.ptnContacts = ptnContacts;
	}


	public HashMap<Integer, String> getPtnPhoto() {
		return ptnPhoto;
	}


	public void setPtnPhoto(HashMap<Integer, String> ptnPhoto) {
		this.ptnPhoto = ptnPhoto;
	}


	public int getFavorites() {
		return favorites;
	}


	public void setFavorites(int favorites) {
		this.favorites = favorites;
	}


	public int getMetascore() {
		return metascore;
	}


	public void setMetascore(int metascore) {
		this.metascore = metascore;
	}


	@Override
	public String toString() {
		return "ProfileVo [partnerCode=" + partnerCode + ", partnerOwner=" + partnerOwner + ", partnerCheck="
				+ partnerCheck + ", partnerLicense=" + partnerLicense + ", partnerLogo=" + partnerLogo
				+ ", partnerLocation=" + partnerLocation + ", partnerStyles=" + partnerStyles + ", partnerIntro="
				+ partnerIntro + ", weekdaysStart=" + weekdaysStart + ", weekdaysEnd=" + weekdaysEnd + ", weekendStart="
				+ weekendStart + ", weekendEnd=" + weekendEnd + ", ptnUpdates=" + ptnUpdates + ", ptnContacts="
				+ ptnContacts + ", ptnPhoto=" + ptnPhoto + ", favorites=" + favorites + ", metascore=" + metascore
				+ "]";
	}
}
