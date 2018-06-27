package ein.mono.board.model.vo;

import java.util.Date;

public class PostVo {
	private String post_code;
	private String post_type;
	private String writer_code;
	private String title;
	private String content;
	private int views_count;
	private Date written_date;
	private String del_flag;
//	private String file; // 첨부파일 여러개 할거야
	
	public PostVo() {
		super();
	}

	public PostVo(String post_type, String writer_code, String title, String content) {
		super();
		this.post_type = post_type;
		this.writer_code = writer_code;
		this.title = title;
		this.content = content;
	}

	public String getPost_code() {
		return post_code;
	}

	public void setPost_code(String post_code) {
		this.post_code = post_code;
	}

	public String getPost_type() {
		return post_type;
	}

	public void setPost_type(String post_type) {
		this.post_type = post_type;
	}

	public String getWriter_code() {
		return writer_code;
	}

	public void setWriter_code(String writer_code) {
		this.writer_code = writer_code;
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

	public int getViews_count() {
		return views_count;
	}

	public void setViews_count(int views_count) {
		this.views_count = views_count;
	}

	public Date getWritten_date() {
		return written_date;
	}

	public void setWritten_date(Date written_date) {
		this.written_date = written_date;
	}

	public String getDel_flag() {
		return del_flag;
	}

	public void setDel_flag(String del_flag) {
		this.del_flag = del_flag;
	}

	
	
}
