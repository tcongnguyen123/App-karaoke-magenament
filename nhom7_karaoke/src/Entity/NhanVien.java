package Entity;

import java.time.LocalDate;

public class NhanVien {
	private String maNV;
	private String tenNV;
	private LocalDate ngaySinh;
	private String soDienThoai;
	private boolean gioiTinh;
	private String email;
	private String diaChi;
	private LoaiNhanVien loaiNV;
	
	
	public NhanVien(String maNV, String tenNV) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
	}

	public NhanVien(String maNV, String tenNV, LocalDate ngaySinh, String soDienThoai, boolean gioiTinh, String email,
			String diaChi, LoaiNhanVien loaiNV) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.ngaySinh = ngaySinh;
		this.soDienThoai = soDienThoai;
		this.gioiTinh = gioiTinh;
		this.email = email;
		this.diaChi = diaChi;
		this.loaiNV = loaiNV;
	}
	

	public NhanVien(String maNV) {
		super();
		this.maNV = maNV;
	}

	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public LocalDate getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public String getGioiTinh() {
		return isGioiTinh() ? "Nam" : "Nữ";
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public LoaiNhanVien getLoaiNV() {
		return loaiNV;
	}
	public void setLoaiNV(LoaiNhanVien loaiNV) {
		this.loaiNV = loaiNV;
	}
	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", tenNV=" + tenNV + ", soDienThoai=" + soDienThoai + ", gioiTinh=" + gioiTinh
				+ ", email=" + email + ", diaChi=" + diaChi + ", loaiNV=" + loaiNV + "]";
	}
	
}
