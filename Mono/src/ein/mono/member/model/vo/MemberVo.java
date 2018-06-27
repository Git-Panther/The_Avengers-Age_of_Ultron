package ein.mono.member.model.vo;

import java.util.Date;

public class MemberVo {
	//member 공통적으로 가지고 있는 값 기본정보 //멤버생일 제외함
	
	private String memberCode;
	private String memberType;
	private String memberRank;
	private String memberId;
	private String memberPwd;
	private String memberName;
	private String memberEmail;
	private String memberAddress;
	private String memberTel;
	private String memberNickname;
	private Date memberJoinDate;
	
	public MemberVo() {}
	
	//전체
	public MemberVo(String memberCode, String memberType, String memberRank, String memberId, String memberPwd,
			String memberName, String memberEmail, String memberAddress, String memberTel, String memberNickname,
			Date memberJoinDate) {
		super();
		this.memberCode = memberCode;
		this.memberType = memberType;
		this.memberRank = memberRank;
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		this.memberEmail = memberEmail;
		this.memberAddress = memberAddress;
		this.memberTel = memberTel;
		this.memberNickname = memberNickname;
		this.memberJoinDate = memberJoinDate;
	}
	
	
	//회원가입
	public MemberVo(String memberType, String memberId, String memberPwd, String memberName, String memberEmail,
			String memberAddress, String memberTel, String memberNickname) {
		super();
		this.memberType = memberType;
		this.memberId = memberId;
		this.memberPwd = memberPwd;
		this.memberName = memberName;
		this.memberEmail = memberEmail;
		this.memberAddress = memberAddress;
		this.memberTel = memberTel;
		this.memberNickname = memberNickname;
	}

	public String getMemberCode() {
		return memberCode;
	}

	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public String getMemberRank() {
		return memberRank;
	}

	public void setMemberRank(String memberRank) {
		this.memberRank = memberRank;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPwd() {
		return memberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	public String getMemberTel() {
		return memberTel;
	}

	public void setMemberTel(String memberTel) {
		this.memberTel = memberTel;
	}

	public String getMemberNickname() {
		return memberNickname;
	}

	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}

	public Date getMemberJoinDate() {
		return memberJoinDate;
	}

	public void setMemberJoinDate(Date memberJoinDate) {
		this.memberJoinDate = memberJoinDate;
	}

	@Override
	public String toString() {
		return "MemberVo [memberCode=" + memberCode + ", memberType=" + memberType + ", memberRank=" + memberRank
				+ ", memberId=" + memberId + ", memberPwd=" + memberPwd + ", memberName=" + memberName
				+ ", memberEmail=" + memberEmail + ", memberAddress=" + memberAddress + ", memberTel=" + memberTel
				+ ", memberNickname=" + memberNickname + ", memberJoinDate=" + memberJoinDate + "]";
	}
	
	
	
	
	
	
}
