package entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

@Entity
@Table (name = "TINTUC")
public class TinTuc {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Assuming auto-increment for maTT
	@Column(name = "MATT") // Ensure the name matches the database column
    private int maTT;

	@Column(name = "TIEUDE")
    @NotEmpty(message = "Tiêu đề không được để trống.")
    private String tieuDe;

	@Column(name = "NOIDUNG")
    @NotEmpty(message = "Nội dung không được để trống.")
    @Size(max = 255, message = "Nội dung không được quá 255 ký tự.")
    private String noiDung;

	@Column(name = "LIENKET")
    @NotEmpty(message = "Liên kết không được để trống.")
    @Pattern(regexp = "^http://.*", message = "Liên kết phải bắt đầu bằng 'http://'.")
    private String lienKet;

    @ManyToOne
    @JoinColumn(name = "MADM", nullable = false) 
    private DanhMuc danhMuc;

   
    public int getMaTT() {
        return maTT;
    }

    public void setMaTT(int maTT) {
        this.maTT = maTT;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getLienKet() {
        return lienKet;
    }

    public void setLienKet(String lienKet) {
        this.lienKet = lienKet;
    }

    public DanhMuc getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(DanhMuc danhMuc) {
        this.danhMuc = danhMuc;
    }
}