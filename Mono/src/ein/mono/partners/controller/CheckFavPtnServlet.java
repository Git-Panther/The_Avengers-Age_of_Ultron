package ein.mono.partners.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ein.mono.partners.model.service.PartnersService;

/**
 * Servlet implementation class SelectFavPtnServlet
 */
@WebServlet("/checkFavPtn.do")
public class CheckFavPtnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckFavPtnServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String memberCode = request.getParameter("memberCode");
		String partnerCode = request.getParameter("partnerCode");
		
		response.getWriter().print(new PartnersService().hasFavPtn(memberCode, partnerCode));
	}

}
