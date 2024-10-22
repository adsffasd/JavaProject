package controller.thuephong;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.KhachThueDAO;
import database.PhongDAO;
import database.ThuePhongDAO;
import model.KhachThue;
import model.Phong;
import model.ThuePhong;

/**
 * Servlet implementation class AddTP
 */
@WebServlet("/addtp")
public class AddTP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTP() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PhongDAO dao = new PhongDAO();
		List<Phong> list = dao.getAllPhong();
		KhachThueDAO dao1 = new KhachThueDAO();
		List<KhachThue> list1 = dao1.getAllKhachThue();
		
		request.setAttribute("listP", list);
		request.setAttribute("listKT", list1);
		request.getRequestDispatcher("/thuephong/add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String mathue = request.getParameter("mathue");
		String khachthue = request.getParameter("khachthue");
		String phong = request.getParameter("phong");
		String giaphongStr = request.getParameter("giaphong");
		String tiendatcocStr = request.getParameter("tiendatcoc");
		String ngaythue = request.getParameter("ngaythue");
		String ngaytraphong = request.getParameter("ngaytraphong");
		String thanhtoan = request.getParameter("thanhtoan");
		
		int giaphong = 0, tiendatcoc = 0;
		try {
			giaphong = Integer.parseInt(giaphongStr);
			tiendatcoc = Integer.parseInt(tiendatcocStr);
		} catch (NumberFormatException e) {
		}
		
		ThuePhongDAO dao = new ThuePhongDAO();
		ThuePhong tp = new ThuePhong(mathue, new KhachThue(khachthue), new Phong(phong), giaphong, tiendatcoc, Date.valueOf(ngaythue), Date.valueOf(ngaytraphong), thanhtoan);
		dao.insertThuePhong(tp);
		response.sendRedirect("showtp");
	}

}
