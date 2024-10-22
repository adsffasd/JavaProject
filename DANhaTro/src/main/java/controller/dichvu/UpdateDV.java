package controller.dichvu;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DichVuDAO;
import model.DichVu;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/updatedv")
public class UpdateDV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDV() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String madichvu = request.getParameter("madichvu");
		DichVuDAO dao = new DichVuDAO();
		DichVu dv = dao.getDichVuByMa(madichvu);
		request.setAttribute("dvV", dv);
		request.getRequestDispatcher("/dichvu/update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String madichvu = request.getParameter("madichvu");
		String tendichvu = request.getParameter("tendichvu");
		
		DichVuDAO dao = new DichVuDAO();
		dao.updateDichVu(madichvu, tendichvu);
		response.sendRedirect("showdv");
	}

}
