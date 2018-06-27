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
import ein.mono.board.model.service.ReplyService;
import ein.mono.board.model.vo.AttachmentVo;
import ein.mono.board.model.vo.PostVo;
import ein.mono.board.model.vo.ReplyVo;

@WebServlet("/selectBoard.do")
public class SelectPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SelectPostServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 게시글 리스트 페이지에서 선택된 게시글의 코드 받아옴
		String post_code = request.getParameter("post_code");
	
		PostVo post = new PostService().selectPost(post_code);
		
		if(null != post) {
			// 해당 게시글 상세페이지로 이동
			// 해당 게시글 조회수 카운트 + 1 시켜줘야 해
			post.setViews_count(post.getViews_count() + 1);
			// 현재 게시글의 post_code에 해당되는 첨부파일 리스트 가져와서 화면에 전달.
			ArrayList<AttachmentVo> attachmentList = new AttachmentService().selectAttachmentList(post.getPost_code());
			request.setAttribute("attachmentList", attachmentList);		
			// 댓글도 불러와야함
			ArrayList<ReplyVo> replyList = new ReplyService().selectReplyList(post.getPost_code());
			request.setAttribute("replyList", replyList);		
			
			
		} else {
			// 에러 페이지로 이동
		}
		
		
	}

}
