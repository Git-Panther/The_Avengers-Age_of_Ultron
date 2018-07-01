package ein.mono.profile.model.vo;

public class PtnContact { // 업체 연락처
	private String contactCode; // 연락처코드
	private String contactType; // 연락처타입
	private String contactInfo; // 연락처정보
	
	public PtnContact() {}
	public PtnContact(String contactCode, String contactType, String contactInfo) {
		super();
		this.contactCode = contactCode;
		this.contactType = contactType;
		this.contactInfo = contactInfo;
	}
	public String getContactCode() {
		return contactCode;
	}
	public void setContactCode(String contactCode) {
		this.contactCode = contactCode;
	}
	public String getContactType() {
		return contactType;
	}
	public void setContactType(String contactType) {
		this.contactType = contactType;
	}
	public String getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}
	
	
}
