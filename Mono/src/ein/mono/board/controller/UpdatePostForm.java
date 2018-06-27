package ein.mono.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ein.mono.board.model.service.PostService;
import ein.mono.board.model.vo.PostVo;

@WebServlet("/updatePostForm.do")
public class UpdatePostForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdatePostForm() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String post_code = request.getParameter("post_code");

		PostVo post = new PostService().selectPost(post_code);
		
		if(null != post) {
			// 해당 post 객체 넘겨주고 게시글 수정 페이지로 이동
			request.setAttribute("post", post);
		} else {
			// 에러
		}
	}

}
