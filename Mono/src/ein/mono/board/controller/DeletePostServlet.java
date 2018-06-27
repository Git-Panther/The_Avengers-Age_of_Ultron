package ein.mono.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ein.mono.board.model.service.PostService;

@WebServlet("/deleteBoard.do")
public class DeletePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeletePostServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String post_code = request.getParameter("post_code");
		
		int result = new PostService().deletePost(post_code);
		
		if(0 < result) {
			// 게시글 목록으로 이동하는데 새로운 게시글 리스트 select해서 보내줘야함
		} else {
			// 에러페이지
		}
	}

}
