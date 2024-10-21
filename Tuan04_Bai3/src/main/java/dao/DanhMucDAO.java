package dao;

import java.util.List;

import entities.DanhMuc;

public interface DanhMucDAO {
	 public List<DanhMuc> layTatCaDanhMuc();
	 public void themDanhMuc(DanhMuc danhMucMoi);
}