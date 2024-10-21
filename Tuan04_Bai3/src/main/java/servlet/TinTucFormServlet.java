package servlet;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import daoImplement.DanhMucDAOIMPL;
import daoImplement.DanhSachTinTucQuanLy;
import entities.DanhMuc;
import entities.DanhMucList;
import entities.TinTuc;

/**
 * Servlet implementation class TinTucFormServlet
 */
public class TinTucFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactory emf;
	private Validator validator;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TinTucFormServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		emf = Persistence.createEntityManagerFactory("tintuc");
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    System.out.println("TinTucFormServlet doGet called");

	    // Lấy danh sách danh mục
	    List<DanhMuc> danhMucList = DanhMucList.queryProducts(); // Đảm bảo gọi phương thức đúng

	    // In ra danh sách để kiểm tra
	    System.out.println("Danh mục trong servlet: " + danhMucList);

	    request.setAttribute("danhMucList", danhMucList);
	    request.getRequestDispatcher("/TinTucForm.jsp").forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String maTTStr = request.getParameter("maTT");
		String tieuDe = request.getParameter("tieuDe");
		String noiDung = request.getParameter("noiDung");
		String lienKet = request.getParameter("lienKet");
		String danhMucStr = request.getParameter("danhMuc");

		int maTT = Integer.parseInt(maTTStr);
		int maDM = Integer.parseInt(danhMucStr);

		TinTuc tinTuc = new TinTuc();
		tinTuc.setMaTT(maTT);
		tinTuc.setTieuDe(tieuDe);
		tinTuc.setNoiDung(noiDung);
		tinTuc.setLienKet(lienKet);

		EntityManager em = emf.createEntityManager();
		DanhMuc danhMuc = em.find(DanhMuc.class, maDM);
		tinTuc.setDanhMuc(danhMuc);

		Set<ConstraintViolation<TinTuc>> violations = validator.validate(tinTuc);

		if (!violations.isEmpty()) {
			StringBuilder errorMessage = new StringBuilder("Dữ liệu nhập không hợp lệ:<br>");
			for (ConstraintViolation<TinTuc> violation : violations) {
				errorMessage.append(violation.getMessage()).append("<br>");
			}

			request.setAttribute("errorMessage", errorMessage.toString());
			request.getRequestDispatcher("/TinTucForm.jsp").forward(request, response);
			return;
		}

		DanhSachTinTucQuanLy tinTucDao = new DanhSachTinTucQuanLy(em);
		tinTucDao.themTinTuc(tinTuc);
		tinTucDao.close();

		request.setAttribute("tinTuc", tinTuc);
		request.getRequestDispatcher("/DanhSachTinTucServlet").forward(request, response);
		
	}

	@Override
	public void destroy() {
		if (emf != null) {
			emf.close();
		}
	}

}