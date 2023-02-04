package Entity;

public class DichVu {
	private String maDV;
	private String tenDV;
	private String donViTinh;
	private int donGia;
	private String loai;
	
	public DichVu(String maDV, String tenDV) {
		super();
		this.maDV = maDV;
		this.tenDV = tenDV;
	}

	public DichVu(String maDV, String tenDV, String donViTinh, int donGia, String loai) {
		super();
		this.maDV = maDV;
		this.tenDV = tenDV;
		this.donViTinh = donViTinh;
		this.donGia = donGia;
		this.loai = loai;
	}
	
	public DichVu(String maDV) {
		super();
		this.maDV = maDV;
	}
	public String getMaDV() {
		return maDV;
	}
	public void setMaDV(String maDV) {
		this.maDV = maDV;
	}
	public String getTenDV() {
		return tenDV;
	}
	public void setTenDV(String tenDV) {
		this.tenDV = tenDV;
	}
	public String getDonViTinh() {
		return donViTinh;
	}
	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}
	public int getDonGia() {
		return donGia;
	}
	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}
	public String getLoai() {
		return loai;
	}
	public void setLoai(String loai) {
		this.loai = loai;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maDV == null) ? 0 : maDV.hashCode());
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
		DichVu other = (DichVu) obj;
		if (maDV == null) {
			if (other.maDV != null)
				return false;
		} else if (!maDV.equals(other.maDV))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DichVu [maDV=" + maDV + ", tenDV=" + tenDV + ", donViTinh=" + donViTinh + ", donGia=" + donGia
				+ ", loai=" + loai + "]";
	}
	
}
