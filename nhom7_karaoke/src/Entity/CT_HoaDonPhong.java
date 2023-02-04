package Entity;

public class CT_HoaDonPhong {
	private HoaDon hoadon;
	private int soGio;
	private double thanhTienGio;
	private Phong phong;
	public CT_HoaDonPhong(HoaDon hoadon, int soGio, double thanhTienGio, Phong phong) {
		super();
		this.hoadon = hoadon;
		this.soGio = soGio;
		this.thanhTienGio = thanhTienGio;
		this.phong = phong;
	}
	public CT_HoaDonPhong() {
		super();
	}
	public HoaDon getHoadon() {
		return hoadon;
	}
	public void setHoadon(HoaDon hoadon) {
		this.hoadon = hoadon;
	}
	public int getSoGio() {
		return soGio;
	}
	public void setSoGio(int soGio) {
		this.soGio = soGio;
	}
	public double getThanhTienGio() {
		return thanhTienGio;
	}
	public void setThanhTienGio(double thanhTienGio) {
		this.thanhTienGio = thanhTienGio;
	}
	public Phong getPhong() {
		return phong;
	}
	public void setPhong(Phong phong) {
		this.phong = phong;
	}
	@Override
	public String toString() {
		return "CT_HoaDonPhong [hoadon=" + hoadon + ", soGio=" + soGio + ", thanhTienGio=" + thanhTienGio + ", phong="
				+ phong + "]";
	}
	
}
