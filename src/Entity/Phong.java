package Entity;

public class Phong {
	private String maPhong;
	private String tenPhong;
	private String mieuTa;
	private int donGia;
	private LoaiPhong loaiPhong;
	private boolean tinhTrang;
	
	public Phong(String maPhong, String tenPhong, int donGia) {
		super();
		this.maPhong = maPhong;
		this.tenPhong = tenPhong;
		this.donGia = donGia;
	}
	
	public Phong(String maPhong) {
		super();
		this.maPhong = maPhong;
	}

	public Phong(String maPhong, String tenPhong, boolean tinhTrang) {
		super();
		this.maPhong = maPhong;
		this.tenPhong = tenPhong;
		this.tinhTrang = tinhTrang;
	}

	public Phong(String maPhong, String tenPhong) {
		super();
		this.maPhong = maPhong;
		this.tenPhong = tenPhong;
	}

	public Phong() {
		super();
	}
	public Phong(String maPhong, String tenPhong, String mieuTa, int donGia, LoaiPhong loaiPhong,boolean tinhTrang) {
		super();
		this.maPhong = maPhong;
		this.tenPhong = tenPhong;
		this.mieuTa = mieuTa;
		this.donGia = donGia;
		this.loaiPhong = loaiPhong;
		this.tinhTrang = tinhTrang;
	}
	
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	public String getTenPhong() {
		return tenPhong;
	}
	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}
	public String getMieuTa() {
		return mieuTa;
	}
	public void setMieuTa(String mieuTa) {
		this.mieuTa = mieuTa;
	}
	public int getDonGia() {
		return donGia;
	}
	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}
	public LoaiPhong getLoaiPhong() {
		return loaiPhong;
	}
	public void setLoaiPhong(LoaiPhong loaiPhong) {
		this.loaiPhong = loaiPhong;
	}
	public boolean isTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(boolean tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maPhong == null) ? 0 : maPhong.hashCode());
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
		Phong other = (Phong) obj;
		if (maPhong == null) {
			if (other.maPhong != null)
				return false;
		} else if (!maPhong.equals(other.maPhong))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Phong [maPhong=" + maPhong + ", tenPhong=" + tenPhong + ", mieuTa=" + mieuTa + ", donGia=" + donGia
				+ ", loaiPhong=" + loaiPhong + ", tinhTrang=" + tinhTrang + "]";
	}
	
	
	
}
