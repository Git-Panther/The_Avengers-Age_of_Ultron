package ein.mono.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ein.mono.board.model.service.AttachmentService;
import ein.mono.board.model.service.PostService;
import ein.mono.board.model.vo.AttachmentVo;
import ein.mono.board.model.vo.PostVo;

@WebServlet("/selectPostList.do")
public class SelectPostListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectPostListServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String post_type = request.getParameter("post_type");
		
		ArrayList<PostVo> postList = new PostService().selectPostList(post_type);
		
		// 썸네일 이미지로 사용할 첨부파일 리스트 가져와서 화면에 전달.
		if(post_type.equals("내방자랑게시판 타입") || post_type.equals("후기게시판 타입")) {
			ArrayList<AttachmentVo> thumnailList = new AttachmentService().selectThumnailAttachmentList();
		}
		if(null != postList) {
			// 게시판 페이지로 이동
		} else {
			// 에러 페이지로 이동
		}
	}

}

