package ein.mono.profile.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ein.mono.profile.model.service.ProfileService;
import ein.mono.profile.model.vo.ProfileVo;



/**
 * Servlet implementation class ProfilListServlet
 */
@WebServlet("/ProfilList.do")
public class ProfileListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int pCode = Integer.parseInt(request.getParameter("partnerCode"));
		
		
		
		ArrayList<ProfileVo> profil = new ProfileService().selectProfileList(pCode);
	}

}
