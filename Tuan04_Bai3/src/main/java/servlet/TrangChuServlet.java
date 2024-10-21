package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import untils.EntityManagerFactoryUtil;

import java.io.IOException;
import java.util.List;

import dao.DanhMucDAO;

import daoImplement.DanhMucDAOIMPL;

import entities.DanhMuc;

/**
 * Servlet implementation class DanhMucServlet
 */
public class TrangChuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactoryUtil entityManageFactory;
	private DanhMucDAO dao;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		this.entityManageFactory = new EntityManagerFactoryUtil();
		this.dao = new DanhMucDAOIMPL(this.entityManageFactory.getEntityManager());
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TrangChuServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<DanhMuc> list = dao.layTatCaDanhMuc();
		if (!list.isEmpty()) {

			request.setAttribute("ds", dao.layTatCaDanhMuc());
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/TrangChu.jsp");
			dispatcher.forward(request, response);
		} else {
			DanhMuc dm = new DanhMuc();
			dm.setTenDanhMuc("Thế giới");
			dm.setGhiChu("Tình hình thế giới");
			dm.setNguoiQuanLy("Thang");
			dao.themDanhMuc(dm);
			DanhMuc dm1 = new DanhMuc();
			dm1.setTenDanhMuc("Pháp luật");
			dm1.setGhiChu("Tình hình xã hội");
			dm1.setNguoiQuanLy("Thang");
			dao.themDanhMuc(dm1);
			request.setAttribute("ds", dao.layTatCaDanhMuc());
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/TrangChu.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}