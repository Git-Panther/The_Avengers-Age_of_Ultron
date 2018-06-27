package ein.mono.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ein.mono.board.model.service.PostService;
import ein.mono.board.model.vo.PostVo;

@WebServlet("/searchPost.do")
public class SearchPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchPostServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8");
		//response.setContentType("text/html; charset=UTF-8");
		
		int condition = Integer.parseInt(request.getParameter("condition"));
		String keyword = request.getParameter("keyword");
		
		// 비지니스 로직 호출
		ArrayList<PostVo> list = new PostService().searchPost(condition, keyword);
		
		// 결과 처리
		RequestDispatcher view = null;
		if(list != null) {
			request.setAttribute("list", list);
			//view = request.getRequestDispatcher("views/notice/noticeList.jsp");
		} else {
			request.setAttribute("msg", "게시글 검색 중 오류 발생!");
			//view = request.getRequestDispatcher("views/common/errorPage.jsp");
		}
		view.forward(request, response);
		
	}

}
