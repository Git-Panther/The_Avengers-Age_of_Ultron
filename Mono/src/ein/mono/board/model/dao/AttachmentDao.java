package ein.mono.board.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import ein.mono.board.model.vo.AttachmentVo;
import ein.mono.board.model.vo.PostVo;
import ein.mono.common.JDBCTemplate;

public class AttachmentDao {
	Properties prop = new Properties();

	public AttachmentDao(){
		String filename = AttachmentDao.class.getResource("/attachment/attachment_sql.properties").getPath();
		try {
			prop.load(new FileReader(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 내 방 자랑/ 후기 게시판 썸네일 이미지 select(file_level을 조회 조건으로)
	public ArrayList<AttachmentVo> selectThumnailAttachmentList(Connection con) {
		ArrayList<AttachmentVo> list = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "";
		
		try {
			stmt = con.createStatement();
			
			query = prop.getProperty("selectThumnailAttachmentList");
			
			rs = stmt.executeQuery(query);
			list = new ArrayList<AttachmentVo>();
			AttachmentVo temp = null;
			while(rs.next()) {
				temp = new AttachmentVo();
				
				list.add(temp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(stmt);
		}
		
		return list;
	}
	
	// post_code에 첨부된 파일들만 select
	public ArrayList<AttachmentVo> selectAttachmentList(Connection con, String post_code) {
		ArrayList<AttachmentVo> list = null;
		Statement stmt = null;
		ResultSet rs = null;
		String query = "";
		
		try {
			stmt = con.createStatement();
			
			query = prop.getProperty("selectAttachmentList");
			
			rs = stmt.executeQuery(query);
			list = new ArrayList<AttachmentVo>();
			AttachmentVo temp = null;
			while(rs.next()) {
				temp = new AttachmentVo();
				
				list.add(temp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(stmt);
		}
		
		return list;
	}

	public int insertAttachment(Connection con, ArrayList<AttachmentVo> list) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = prop.getProperty("insertAttachment");
		
		try {
			for(int i = 0; i < list.size(); i++) {
				pstmt = con.prepareStatement(query);
				
				/*pstmt.setInt(1, list.get(i).getBno());
				pstmt.setString(2, list.get(i).getOriginName());
				//System.out.println("원본 이름 : " + list.get(i).getOriginName());
				pstmt.setString(3, list.get(i).getChangeName());
				pstmt.setString(4, list.get(i).getPath());
				pstmt.setInt(5, i == 0 ? 0 : 1);*/
				
				result += pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int updateAttachment(Connection con, String post_code, ArrayList<AttachmentVo> list) {
		int result = 0;
		
		return result;
	}
}
