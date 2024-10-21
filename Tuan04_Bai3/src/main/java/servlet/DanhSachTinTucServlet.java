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
import dao.TinTucDAO;
import daoImplement.DanhMucDAOIMPL;
import daoImplement.DanhSachTinTucQuanLy;
import entities.DanhMuc;
import entities.TinTuc;

/**
 * Servlet implementation class DanhSachTinTucServlet
 */
public class DanhSachTinTucServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactoryUtil entityManageFactory;
	private TinTucDAO danhSachTinTucQuanLy;
	private DanhMucDAO danhMucDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DanhSachTinTucServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.entityManageFactory = new EntityManagerFactoryUtil();

		this.danhSachTinTucQuanLy = new DanhSachTinTucQuanLy(this.entityManageFactory.getEntityManager());
		this.danhMucDAO = new DanhMucDAOIMPL(this.entityManageFactory.getEntityManager());

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String maDMStr = request.getParameter("madm");
		int maDM = 0;
		if (maDMStr != null && !maDMStr.isEmpty()) {
			try {
				maDM = Integer.parseInt(maDMStr);
			} catch (NumberFormatException e) {
				response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Mã không hợp lệ");
				return;
			}
		}

		List<DanhMuc> danhMucList = null;

		danhMucList = danhMucDAO.layTatCaDanhMuc();

		List<TinTuc> tinTucList;
		if (maDM > 0) {
			tinTucList = danhSachTinTucQuanLy.layTinTucTheoDanhMuc(maDM);
		} else {
			tinTucList = danhSachTinTucQuanLy.layTatCaTinTuc();
		}

		request.setAttribute("danhMucList", danhMucList);
		request.setAttribute("tinTucList", tinTucList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/DanhSachTinTuc.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String maDMStr = req.getParameter("madm");
		int maDM = 0;
		if (maDMStr != null && !maDMStr.isEmpty()) {
			try {
				maDM = Integer.parseInt(maDMStr);
			} catch (NumberFormatException e) {
				resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Mã không hợp lệ");
				return;
			}
		}
		List<DanhMuc> danhMucList = null;
		danhMucList = danhMucDAO.layTatCaDanhMuc();
		List<TinTuc> tinTucList;
		if (maDM > 0) {
			tinTucList = danhSachTinTucQuanLy.layTinTucTheoDanhMuc(maDM);
		} else {
			tinTucList = danhSachTinTucQuanLy.layTatCaTinTuc();
		}
		req.setAttribute("danhMucList", danhMucList);
		req.setAttribute("tinTucList", tinTucList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/DanhSachTinTuc.jsp");
		dispatcher.forward(req, resp);

	}

}