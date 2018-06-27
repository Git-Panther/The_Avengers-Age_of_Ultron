package ein.mono.board.model.vo;

import java.util.Date;

public class ReplyVo {
	private String reply_code;
	private String writer_code;
	private String post_code;
	private String reply_content;
	private Date reply_date;
	
	
	public ReplyVo() {
		super();
	}

	public ReplyVo(String writer_code, String post_code, String reply_content) {
		super();
		this.writer_code = writer_code;
		this.post_code = post_code;
		this.reply_content = reply_content;
	}

	public String getReply_code() {
		return reply_code;
	}

	public void setReply_code(String reply_code) {
		this.reply_code = reply_code;
	}

	public String getWriter_code() {
		return writer_code;
	}

	public void setWriter_code(String writer_code) {
		this.writer_code = writer_code;
	}

	public String getPost_code() {
		return post_code;
	}

	public void setPost_code(String post_code) {
		this.post_code = post_code;
	}

	public String getReply_content() {
		return reply_content;
	}

	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}

	public Date getReply_date() {
		return reply_date;
	}

	public void setReply_date(Date reply_date) {
		this.reply_date = reply_date;
	}

	@Override
	public String toString() {
		return "CommentVo [reply_code=" + reply_code + ", writer_code=" + writer_code + ", post_code=" + post_code
				+ ", reply_content=" + reply_content + ", reply_date=" + reply_date + ", toString()=" + super.toString()
				+ "]";
	}
	
}
