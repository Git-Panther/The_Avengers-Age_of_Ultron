package ein.mono.profil.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ein.mono.profil.model.service.ProfilService;
import ein.mono.profil.model.vo.ProfilVo;



/**
 * Servlet implementation class ProfilListServlet
 */
@WebServlet("/ProfilList.do")
public class ProfilListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfilListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int pCode = Integer.parseInt(request.getParameter("partnerCode"));
		
		
		
		ArrayList<ProfilVo> profil = new ProfilService().selectProfilList(pCode);
	}

}
