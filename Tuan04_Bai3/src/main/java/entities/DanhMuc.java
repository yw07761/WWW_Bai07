package entities;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "DANHMUC")
public class DanhMuc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MADM")
    private int maDM;

    @Column(name = "TENDANHMUC", nullable = false)
    private String tenDanhMuc;

    @Column(name = "NGUOIQUANLY")
    private String nguoiQuanLy;

    @Column(name = "GHICHU")
    private String ghiChu;

    @OneToMany(mappedBy = "danhMuc", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TinTuc> tinTucList;

    
    public DanhMuc() {}

    public DanhMuc(String tenDanhMuc, String nguoiQuanLy, String ghiChu) {
        this.tenDanhMuc = tenDanhMuc;
        this.nguoiQuanLy = nguoiQuanLy;
        this.ghiChu = ghiChu;
    }

	public int getMaDM() {
		return maDM;
	}

	public void setMaDM(int maDM) {
		this.maDM = maDM;
	}

	public String getTenDanhMuc() {
		return tenDanhMuc;
	}

	public void setTenDanhMuc(String tenDanhMuc) {
		this.tenDanhMuc = tenDanhMuc;
	}

	public String getNguoiQuanLy() {
		return nguoiQuanLy;
	}

	public void setNguoiQuanLy(String nguoiQuanLy) {
		this.nguoiQuanLy = nguoiQuanLy;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public List<TinTuc> getTinTucList() {
		return tinTucList;
	}

	public void setTinTucList(List<TinTuc> tinTucList) {
		this.tinTucList = tinTucList;
	}

   
}
