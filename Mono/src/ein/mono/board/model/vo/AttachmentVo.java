package ein.mono.board.model.vo;

import java.util.Date;

public class AttachmentVo {
	private int file_code; // 구분할 것 없으니 int로 줘도 괜찮을 듯
	private String post_code; 
	private String origin_name;
	private String new_name;
	private String file_path;
	private Date upload_date;
	private int file_level; 
	private int download_count;
	private String del_flag;
	
	// 화면 출력용 변수
	private String username; // *출력할 작성자 정보가 아이디였나 닉네임이었나*
	private String title;
	private String content;
	private Date writeDate;
	private int bcount;
	
	public AttachmentVo() {
		super();
	}

	public AttachmentVo(int file_code, String post_code, String origin_name, String new_name, String file_path,
			Date upload_date, int file_level, int download_count, String del_flag) {
		super();
		this.file_code = file_code;
		this.post_code = post_code;
		this.origin_name = origin_name;
		this.new_name = new_name;
		this.file_path = file_path;
		this.upload_date = upload_date;
		this.file_level = file_level;
		this.download_count = download_count;
		this.del_flag = del_flag;
	}

	public int getFile_code() {
		return file_code;
	}

	public void setFile_code(int file_code) {
		this.file_code = file_code;
	}

	public String getPost_code() {
		return post_code;
	}

	public void setPost_code(String post_code) {
		this.post_code = post_code;
	}

	public String getOrigin_name() {
		return origin_name;
	}

	public void setOrigin_name(String origin_name) {
		this.origin_name = origin_name;
	}

	public String getNew_name() {
		return new_name;
	}

	public void setNew_name(String new_name) {
		this.new_name = new_name;
	}

	public String getFile_path() {
		return file_path;
	}

	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}

	public Date getUpload_date() {
		return upload_date;
	}

	public void setUpload_date(Date upload_date) {
		this.upload_date = upload_date;
	}

	public int getFile_level() {
		return file_level;
	}

	public void setFile_level(int file_level) {
		this.file_level = file_level;
	}

	public int getDownload_count() {
		return download_count;
	}

	public void setDownload_count(int download_count) {
		this.download_count = download_count;
	}

	public String getDel_flag() {
		return del_flag;
	}

	public void setDel_flag(String del_flag) {
		this.del_flag = del_flag;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public int getBcount() {
		return bcount;
	}

	public void setBcount(int bcount) {
		this.bcount = bcount;
	}

	@Override
	public String toString() {
		return "AttachmentVo [file_code=" + file_code + ", post_code=" + post_code + ", origin_name=" + origin_name
				+ ", new_name=" + new_name + ", file_path=" + file_path + ", upload_date=" + upload_date
				+ ", file_level=" + file_level + ", download_count=" + download_count + ", del_flag=" + del_flag
				+ ", toString()=" + super.toString() + "]";
	}

}
	