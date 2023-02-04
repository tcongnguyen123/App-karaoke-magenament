package Entity;


import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;



public class DonDatPhong {
	private String maDon;
	private Phong phong;
	private KhachHang khachhang;
	private NhanVien nhanvien;
	private LocalDateTime ngayGioThue;
	private LocalDateTime ngayTaoDon;
	private String tinhTrangThanhToan;
	

	public DonDatPhong() {
		super();
	}
	public DonDatPhong(String maDon, Phong phong, KhachHang khachhang, NhanVien nhanvien, LocalDateTime ngayGioThue,
			LocalDateTime ngayTaoDon) {
		super();
		this.maDon = maDon;
		this.phong = phong;
		this.khachhang = khachhang;
		this.nhanvien = nhanvien;
		this.ngayGioThue = ngayGioThue;
		this.ngayTaoDon = ngayTaoDon;
	}
	
	public DonDatPhong(String maDon, Phong phong) {
		super();
		this.maDon = maDon;
		this.phong = phong;
	}
	
	public DonDatPhong(String maDon, LocalDateTime ngayGioThue) {
		super();
		this.maDon = maDon;
		this.ngayGioThue = ngayGioThue;
	}
	public DonDatPhong(String maDon) {
		super();
		this.maDon = maDon;
	}
	public DonDatPhong(String maDon, Phong phong, KhachHang khachhang, NhanVien nhanvien, LocalDateTime ngayGioThue,
			LocalDateTime ngayTaoDon, String tinhTrangThanhToan) {
		super();
		this.maDon = maDon;
		this.phong = phong;
		this.khachhang = khachhang;
		this.nhanvien = nhanvien;
		this.ngayGioThue = ngayGioThue;
		this.ngayTaoDon = ngayTaoDon;
		this.tinhTrangThanhToan = tinhTrangThanhToan;
	}
	public String getMaDon() {
		return maDon;
	}
	public void setMaDon(String maDon) {
		this.maDon = maDon;
	}
	public Phong getPhong() {
		return phong;
	}
	public void setPhong(Phong phong) {
		this.phong = phong;
	}
	public KhachHang getKhachhang() {
		return khachhang;
	}
	public void setKhachhang(KhachHang khachhang) {
		this.khachhang = khachhang;
	}
	public NhanVien getNhanvien() {
		return nhanvien;
	}
	public void setNhanvien(NhanVien nhanvien) {
		this.nhanvien = nhanvien;
	}
	public LocalDateTime getNgayGioThue() {
		return ngayGioThue;
	}
	public void setNgayGioThue(LocalDateTime ngayGioThue) {
		this.ngayGioThue = ngayGioThue;
	}
	public LocalDateTime getNgayTaoDon() {
		return ngayTaoDon;
	}
	public void setNgayTaoDon(LocalDateTime ngayTaoDon) {
		this.ngayTaoDon = ngayTaoDon;
	}
	
	public String getTinhTrangThanhToan() {
		return tinhTrangThanhToan;
	}
	public void setTinhTrangThanhToan(String tinhTrangThanhToan) {
		this.tinhTrangThanhToan = tinhTrangThanhToan;
	}
	@Override
	public String toString() {
		return "DonDatPhong [maDon=" + maDon + ", phong=" + phong + ", khachhang=" + khachhang + ", nhanvien="
				+ nhanvien + ", ngayGioThue=" + ngayGioThue + ", ngayTaoDon=" + ngayTaoDon + ", tinhTrangThanhToan="
				+ tinhTrangThanhToan + "]";
	}
	
	
	

	
}
	