package Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class HoaDon {
	private String maHD;
	private DonDatPhong donDat ;
	private NhanVien nhanVien;
	private KhachHang khachHang;
	private LocalDateTime gioTra;
	private LocalDateTime ngayLapDon;
	private LocalDateTime ngayGiothue;
	private double tongTien;
	public HoaDon() {
		super();
	}
	
	

	public HoaDon(String maHD, DonDatPhong donDat, NhanVien nhanVien, KhachHang khachHang, LocalDateTime gioTra,
			LocalDateTime ngayLapDon, LocalDateTime ngayGiothue) {
		super();
		this.maHD = maHD;
		this.donDat = donDat;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.gioTra = gioTra;
		this.ngayLapDon = ngayLapDon;
		this.ngayGiothue = ngayGiothue;
	}



	public HoaDon(String maHD, NhanVien nhanVien, KhachHang khachHang,LocalDateTime ngayLapDon) {
		super();
		this.maHD = maHD;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.ngayLapDon = ngayLapDon;
	}

	public HoaDon(String maHD) {
		super();
		this.maHD = maHD;
	}
	
	public HoaDon(String maHD, DonDatPhong donDat, NhanVien nhanVien, KhachHang khachHang) {
		super();
		this.maHD = maHD;
		this.donDat = donDat;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
	}
	






	public HoaDon(LocalDateTime ngayLapDon, double tongTien) {
		super();
		this.ngayLapDon = ngayLapDon;
		this.tongTien = tongTien;
	}



	public HoaDon(String maHD, DonDatPhong donDat, NhanVien nhanVien, KhachHang khachHang, LocalDateTime gioTra,
			LocalDateTime ngayLapDon, LocalDateTime ngayGiothue, double tongTien) {
		super();
		this.maHD = maHD;
		this.donDat = donDat;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.gioTra = gioTra;
		this.ngayLapDon = ngayLapDon;
		this.ngayGiothue = ngayGiothue;
		this.tongTien = tongTien;
	}



	public HoaDon(String maHD, DonDatPhong donDat, KhachHang khachHang, LocalDateTime gioTra, LocalDateTime ngayLapDon,
			LocalDateTime ngayGiothue) {
		super();
		this.maHD = maHD;
		this.donDat = donDat;
		this.khachHang = khachHang;
		this.gioTra = gioTra;
		this.ngayLapDon = ngayLapDon;
		this.ngayGiothue = ngayGiothue;
	}



	public HoaDon(String maHD, DonDatPhong donDat, NhanVien nhanVien, KhachHang khachHang, LocalDateTime gioTra,
			LocalDateTime ngayLapDon) {
		super();
		this.maHD = maHD;
		this.donDat = donDat;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.gioTra = gioTra;
		this.ngayLapDon = ngayLapDon;
	}
	
	public HoaDon(String maHD, DonDatPhong donDat, NhanVien nhanVien, KhachHang khachHang, LocalDateTime gioTra,
			LocalDateTime ngayLapDon, double tongTien) {
		super();
		this.maHD = maHD;
		this.donDat = donDat;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.gioTra = gioTra;
		this.ngayLapDon = ngayLapDon;
		this.tongTien = tongTien;
	}
	
	public double getTongTien() {
		return tongTien;
	}
	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public DonDatPhong getDonDat() {
		return donDat;
	}
	public void setDonDat(DonDatPhong donDat) {
		this.donDat = donDat;
	}
	public NhanVien getNhanVien() {
		return nhanVien;
	}
	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}
	public KhachHang getKhachHang() {
		return khachHang;
	}
	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}
	public LocalDateTime getGioTra() {
		return gioTra;
	}
	public void setGioTra(LocalDateTime gioTra) {
		this.gioTra = gioTra;
	}
	public LocalDateTime getNgayLapDon() {
		return ngayLapDon;
	}
	public void setNgayLapDon(LocalDateTime ngayLapDon) {
		this.ngayLapDon = ngayLapDon;
	}

	public LocalDateTime getNgayGiothue() {
		return ngayGiothue;
	}

	public void setNgayGiothue(LocalDateTime ngayGiothue) {
		this.ngayGiothue = ngayGiothue;
	}



	@Override
	public String toString() {
		return "HoaDon [maHD=" + maHD + ", donDat=" + donDat + ", nhanVien=" + nhanVien + ", khachHang=" + khachHang
				+ ", gioTra=" + gioTra + ", ngayLapDon=" + ngayLapDon + ", ngayGiothue=" + ngayGiothue + ", tongTien="
				+ tongTien + "]";
	}
	

	

}
