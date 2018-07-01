package ein.mono.profile.model.vo;

public class PtnUpdate { // 업체 추가 정보
	private String updateCode; // 추가정보코드
	private String updateName; // 추가정보명
	private String updateContent; // 추가정보
	
	public PtnUpdate() {
		super();
	}
	public PtnUpdate(String updateCode, String updateName, String updateContent) {
		super();
		this.updateCode = updateCode;
		this.updateName = updateName;
		this.updateContent = updateContent;
	}
	public String getUpdateCode() {
		return updateCode;
	}
	public void setUpdateCode(String updateCode) {
		this.updateCode = updateCode;
	}
	public String getUpdateName() {
		return updateName;
	}
	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}
	public String getUpdateContent() {
		return updateContent;
	}
	public void setUpdateContent(String updateContent) {
		this.updateContent = updateContent;
	}
	
}
