package dao;

import java.util.List;

import entities.TinTuc;


public interface TinTucDAO {
	public List<TinTuc> layTinTucTheoDanhMuc(int maDM);
	public void themTinTuc(TinTuc tinTuc);
	 public void xoaTinTuc(int maTT);
	public List<TinTuc> layTatCaTinTuc();
}