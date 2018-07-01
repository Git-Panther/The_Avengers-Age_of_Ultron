package ein.mono.profile.model.vo;

import java.util.ArrayList;
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
	private String weekdaysStart; // 평일상담시작시간
	private String weekdaysEnd; // 평일상담종료시간
	private String weekendStart; // 주말상담시작시간
	private String weekendEnd; // 주말상담종료시간

	private ArrayList<PtnUpdate> ptnUpdates = new ArrayList<PtnUpdate>();// 추가정보 리스트	
	private ArrayList<PtnContact> ptnContacts = new ArrayList<PtnContact>();// 연락처 리스트
	private HashMap<Integer, String> ptnPhoto = new HashMap<Integer, String>(); // 업체 사진들. Integer는 우선순위, String은 파일명
	private int favorites; // 즐겨찾기 보유수
	private double metascore; // 평점
	
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

	
	
	public ArrayList<PtnUpdate> getPtnUpdates() {
		return ptnUpdates;
	}


	public void setPtnUpdates(ArrayList<PtnUpdate> ptnUpdates) {
		this.ptnUpdates = ptnUpdates;
	}


	public ArrayList<PtnContact> getPtnContacts() {
		return ptnContacts;
	}


	public void setPtnContacts(ArrayList<PtnContact> ptnContacts) {
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


	public double getMetascore() {
		return metascore;
	}


	public void setMetascore(double metascore){
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
