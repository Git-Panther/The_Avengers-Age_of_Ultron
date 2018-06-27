package ein.mono.qna.model.dao;

import java.sql.Connection;
import java.util.ArrayList;

import ein.mono.qna.model.vo.QnAVo;

public class QnADao {
	public ArrayList<QnAVo> selectQnaList(Connection con){
		return null;
	}
	public QnAVo selectQna(Connection con,String qnaCode){
		return null;
	}
	public int insertQuestion(Connection con,QnAVo question){
		return 0;
	}
	
	public int insertAnswer(Connection con,QnAVo answer){
		return 0;
	}

}
