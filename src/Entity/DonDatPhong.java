package Entity;


import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;



public class DonDatPhong {
	private String maDon;
	private String tenDon;
	private Phong phong;
	private KhachHang khachhang;
	private String gioThue;
	private LocalDate ngayThue;
	private Timestamp ngayTaoDon;
	public DonDatPhong() {
		super();
	}
	public DonDatPhong(String maDon, String tenDon, Phong phong, KhachHang khachhang,String gioThue, LocalDate ngayThue,
			 Timestamp ngayTaoDon) {
		super();
		this.maDon = maDon;
		this.tenDon = tenDon;
		this.phong = phong;
		this.khachhang = khachhang;
		this.gioThue = gioThue;
		this.ngayThue = ngayThue;

		this.ngayTaoDon = ngayTaoDon;
	}
	

	public DonDatPhong(String maDon, Phong phong) {
		super();
		this.maDon = maDon;
		this.phong = phong;
	}
	public DonDatPhong(String maDon) {
		super();
		this.maDon = maDon;
	}
	public String getMaDon() {
		return maDon;
	}
	public void setMaDon(String maDon) {
		this.maDon = maDon;
	}
	public String getTenDon() {
		return tenDon;
	}
	public void setTenDon(String tenDon) {
		this.tenDon = tenDon;
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
	public String getGioThue() {
		return gioThue;
	}
	public void setGioThue(String gioThue) {
		this.gioThue = gioThue;
	}
	public LocalDate getNgayThue() {
		return ngayThue;
	}
	public void setNgayThue(LocalDate ngayThue) {
		this.ngayThue = ngayThue;
	}

	public Timestamp getNgayTaoDon() {
		return ngayTaoDon;
	}
	public void setNgayTaoDon(Timestamp ngayTaoDon) {
		this.ngayTaoDon = ngayTaoDon;
	}
	


	@Override
	public String toString() {
		return "DonDatPhong [maDon=" + maDon + ", tenDon=" + tenDon + ", phong=" + phong + ", khachhang=" + khachhang
				+ ", gioThue=" + gioThue + ", ngayThue=" + ngayThue + ", ngayTaoDon="
				+ ngayTaoDon + "]";
	}
	
	
	
}
