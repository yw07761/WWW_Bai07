package entities;

import java.util.ArrayList;
import java.util.List;

public class DanhMucList {
	private static final List<DanhMuc> ds = new ArrayList<DanhMuc>();
	static {
		initData();
	}
	public static List<DanhMuc> queryProducts(){
		System.out.println(ds);
		return ds;
	}
	private static void initData() {
	    System.out.println("Initializing data...");
	    
	    DanhMuc dm1 = new DanhMuc();
	    dm1.setMaDM(1);
	    dm1.setTenDanhMuc("Thế giới");
	    dm1.setGhiChu("Tình hình thế giới");
	    dm1.setNguoiQuanLy("Thang");
	    ds.add(dm1);

	    DanhMuc dm2 = new DanhMuc();
	    dm2.setMaDM(2);
	    dm2.setTenDanhMuc("Công nghệ");
	    dm2.setGhiChu("Tin tức về công nghệ");
	    dm2.setNguoiQuanLy("Huy");
	    ds.add(dm2);

	    // In ra danh sách danh mục để kiểm tra
	    System.out.println("Danh sách danh mục: " + ds);
	}


}