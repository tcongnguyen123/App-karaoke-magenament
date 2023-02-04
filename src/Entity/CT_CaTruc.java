package Entity;

import java.time.LocalDate;

public class CT_CaTruc {
	private CaTruc caTruc;
	private NhanVien nhanVien;
	private int soCa;
	private LocalDate ngayTruc;
	public CT_CaTruc() {
		super();
	}
	public CT_CaTruc(CaTruc caTruc, NhanVien nhanVien, int soCa, LocalDate ngayTruc) {
		super();
		this.caTruc = caTruc;
		this.nhanVien = nhanVien;
		this.soCa = soCa;
		this.ngayTruc = ngayTruc;
	}
	public CaTruc getCaTruc() {
		return caTruc;
	}
	public void setCaTruc(CaTruc caTruc) {
		this.caTruc = caTruc;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public int getSoCa() {
		return soCa;
	}
	public void setSoCa(int soCa) {
		this.soCa = soCa;
	}
	public LocalDate getNgayTruc() {
		return ngayTruc;
	}
	public void setNgayTruc(LocalDate ngayTruc) {
		this.ngayTruc = ngayTruc;
	}
	@Override
	public String toString() {
		return "CT_CaTruc [caTruc=" + caTruc + ", nhanVien=" + nhanVien + ", soCa=" + soCa + ", ngayTruc=" + ngayTruc
				+ "]";
	}

	
}