package ein.mono.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ein.mono.board.model.service.ReplyService;
import ein.mono.board.model.vo.ReplyVo;

@WebServlet("/insertReply.do")
public class InsertReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InsertReplyServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String post_code = request.getParameter("post_code");
		String writer_code = request.getParameter("writer_code");
		String reply_content = request.getParameter("reply_content");
		
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		ReplyVo reply  = new ReplyVo(writer_code, post_code, reply_content);
		
		// 비지니스 로직 호출
		int result = new ReplyService().insertReply(reply);
		
		if(0 < result) {
			// 해당 게시글 상세 페이지로 다시 이동.
			response.sendRedirect("/mwp/selectPost.do?post_code=" + post_code + "&currentPage=" + currentPage);
		} else {
			// 에러
		}
		
		
		
	}

}
