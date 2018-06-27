package ein.mono.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ein.mono.board.model.service.ReplyService;

@WebServlet("/deleteReply.do")
public class DeleteReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteReplyServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reply_code = request.getParameter("reply_code");
		String post_code = request.getParameter("post_code");
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		int result = new ReplyService().deleteReply(reply_code);
		
		if(0 < result) {
			response.sendRedirect("/mwp/selectPost.do?post_code=" + post_code + "&currentPage=" + currentPage);
		} else {
			// 에러
		}
	
	}

}
