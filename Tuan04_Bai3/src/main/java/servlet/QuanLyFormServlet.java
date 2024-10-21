package servlet;

import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import untils.EntityManagerFactoryUtil;

import java.io.IOException;
import java.util.List;

import entities.TinTuc;
import daoImplement.DanhSachTinTucQuanLy;

/**
 * Servlet implementation class QuanLyFormServlet
 */
public class QuanLyFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DanhSachTinTucQuanLy danhSachTinTucQuanLy;
	private EntityManager entityManager;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	@Override
	public void init() throws ServletException {
		this.entityManager = new EntityManagerFactoryUtil().getEntityManager();
		this.danhSachTinTucQuanLy = new DanhSachTinTucQuanLy(entityManager);
	}

	public QuanLyFormServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("CAll DOGETT");
		List<TinTuc> tinTucList = danhSachTinTucQuanLy.layTatCaTinTuc();
		System.out.println(tinTucList);

		request.setAttribute("tinTucList", tinTucList);

		request.getRequestDispatcher("/QuanLiForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String maTT = request.getParameter("maTT");
		if (maTT != null) {
			int maTinTuc = Integer.parseInt(maTT);

			danhSachTinTucQuanLy.xoaTinTuc(maTinTuc);
		}

		response.sendRedirect("QuanLyFormServlet");
	}

	@Override
	public void destroy() {
		if (entityManager != null) {
			entityManager.close();
		}
	}

}