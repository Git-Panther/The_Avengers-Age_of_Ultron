package ein.mono.notice.model.dao;

import java.sql.Connection;
import java.util.ArrayList;

import ein.mono.notice.model.vo.NoticeVo;

public class NoticeDao {
	public ArrayList<NoticeVo> selectNoticeList(Connection con){
		return null;
	}
	public NoticeVo selectNotice(Connection con, int noticeNo) {
		return null;
	}
	public int insertNotice(Connection con, NoticeVo notice) {
		return 0;
	}
	public int updateNoticeCount(Connection con, int noticeNo) {
		return 0;
	}
	public int updateNotice(Connection con, NoticeVo notice){
		return 0;
	}
	public int deleteNotice(Connection con, int noticeNo) {
		return 0;
	}
	

}
