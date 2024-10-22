package controller.diennuoc;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DichVuDAO;
import database.ThuePhongDAO;
import database.TienDienNuocDAO;
import model.DichVu;
import model.ThuePhong;
import model.TienDienNuoc;

/**
 * Servlet implementation class UpdateDN
 */
@WebServlet("/updatedn")
public class UpdateDN extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDN() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String matiendien = request.getParameter("matiendien");
		TienDienNuocDAO dao = new TienDienNuocDAO();
		TienDienNuoc dn = dao.getDienNuocByMa(matiendien);
		request.setAttribute("dnN", dn);
		
		ThuePhongDAO dao1 = new ThuePhongDAO();
		List<ThuePhong> list1 = dao1.getAllThuePhong();
		DichVuDAO dao2 = new DichVuDAO();
		List<DichVu> list2 = dao2.getAllDichVu();
		
		request.setAttribute("thuephonglist", list1);
		request.setAttribute("dichvulist", list2);
		
		request.getRequestDispatcher("tiendiennuoc/update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String matiendien = request.getParameter("matiendien");
		String thue = request.getParameter("thue");
		String dichvu = request.getParameter("dichvu");
		String tungay = request.getParameter("tungay");
		String toingay = request.getParameter("toingay");
		String sodienStr = request.getParameter("sodien");
		String dongiaStr = request.getParameter("dongia");
		String dathanhtoan = request.getParameter("dathanhtoan");
		
		Double sodien = 0.0, dongia = 0.0;
		try {
			sodien = Double.parseDouble(sodienStr);
			dongia = Double.parseDouble(dongiaStr);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		TienDienNuocDAO dao = new TienDienNuocDAO();
		TienDienNuoc dn = new TienDienNuoc(matiendien, new ThuePhong(thue), new DichVu(dichvu), Date.valueOf(tungay), Date.valueOf(toingay), sodien, dongia, dathanhtoan);
		dao.updateDienNuoc(dn);
		response.sendRedirect("showdn");
	}

}
