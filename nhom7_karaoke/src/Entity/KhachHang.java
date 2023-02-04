package Entity;

public class KhachHang {
	private String maKH;
	private String tenKH;
	private String sdt;
	private boolean gioiTinh;
	private String cccd;
	private String email;
	private String tuoi;
	public KhachHang() {
		super();
	}
	
	public KhachHang(String maKH) {
		super();
		this.maKH = maKH;
	}
	

	public KhachHang(String maKH, String tenKH, String sdt) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.sdt = sdt;
	}

	public KhachHang(String maKH, String tenKH, String sdt, boolean gioiTinh, String cccd, String email, String tuoi) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.sdt = sdt;
		this.gioiTinh = gioiTinh;
		this.cccd = cccd;
		this.email = email;
		this.tuoi = tuoi;
	}
	public KhachHang(String maKH, String tenKH) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getCccd() {
		return cccd;
	}
	public void setCccd(String cccd) {
		this.cccd = cccd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTuoi() {
		return tuoi;
	}
	public void setTuoi(String tuoi) {
		this.tuoi = tuoi;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maKH == null) ? 0 : maKH.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		if (maKH == null) {
			if (other.maKH != null)
				return false;
		} else if (!maKH.equals(other.maKH))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", tenKH=" + tenKH + ", sdt=" + sdt + ", gioiTinh=" + gioiTinh + ", cccd="
				+ cccd + ", email=" + email + ", tuoi=" + tuoi + "]";
	}
	
	
	
}
