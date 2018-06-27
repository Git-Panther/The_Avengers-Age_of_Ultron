package ein.mono.qna.model.vo;

public class QnAVo {
	private String qnaCode;
	private String mCode;
	private String pCode;
	private String question;
	private String answer;
	
	public QnAVo(){}

	public QnAVo(String qnaCode, String mCode, String pCode, String question, String answer) {
		super();
		this.qnaCode = qnaCode;
		this.mCode = mCode;
		this.pCode = pCode;
		this.question = question;
		this.answer = answer;
	}

	public String getQnaCode() {
		return qnaCode;
	}

	public void setQnaCode(String qnaCode) {
		this.qnaCode = qnaCode;
	}

	public String getmCode() {
		return mCode;
	}

	public void setmCode(String mCode) {
		this.mCode = mCode;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	
	

}
