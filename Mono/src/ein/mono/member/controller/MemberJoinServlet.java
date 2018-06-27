package ein.mono.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ein.mono.member.model.service.MemberService;
import ein.mono.member.model.vo.MemberVo;


@WebServlet("/memberJoin.do")
public class MemberJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public MemberJoinServlet() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		//객체저장
		
		String mType = request.getParameter("memberType");
		String mId	= request.getParameter("memberId");
		String mPwd = request.getParameter("memberPwd");
		String mName = request.getParameter("memberName");
		String mEmail = request.getParameter("memberEmail");
		String mAddress = request.getParameter("memberAddress");
		String mTel = request.getParameter("memberTel");
		String mNickname = request.getParameter("memberNickname");
		

		MemberVo member = new MemberVo(mType, mId, mPwd, mName, mEmail, mAddress, mTel, mNickname);
		
		MemberService ms = new MemberService();
		RequestDispatcher view = null;
		
		int result = ms.joinMember(member);
		
		
		
		
		
	}

}
