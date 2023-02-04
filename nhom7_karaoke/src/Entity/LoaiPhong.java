package Entity;

public class LoaiPhong {
	private String maLoai;
	private String tenLoaiPhong;
	public LoaiPhong() {
		super();
	}
	public LoaiPhong(String maLoai, String tenLoaiPhong) {
		super();
		this.maLoai = maLoai;
		this.tenLoaiPhong = tenLoaiPhong;
	}
	public String getMaLoai() {
		return maLoai;
	}
	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}
	public String getTenLoaiPhong() {
		return tenLoaiPhong;
	}
	public void setTenLoaiPhong(String tenLoaiPhong) {
		this.tenLoaiPhong = tenLoaiPhong;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maLoai == null) ? 0 : maLoai.hashCode());
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
		LoaiPhong other = (LoaiPhong) obj;
		if (maLoai == null) {
			if (other.maLoai != null)
				return false;
		} else if (!maLoai.equals(other.maLoai))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "LoaiPhong [maLoai=" + maLoai + ", tenLoaiPhong=" + tenLoaiPhong + "]";
	}
	
}
