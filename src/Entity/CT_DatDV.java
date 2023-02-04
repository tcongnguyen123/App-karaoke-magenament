package Entity;

public class CT_DatDV {
	private String maCTDP;
	private DonDatPhong dondatPhong;
	private int soLuong;
	private DichVu dichvu;
	public CT_DatDV(String maCTDP, DonDatPhong dondatPhong, int soLuong, DichVu dichvu) {
		super();
		this.maCTDP = maCTDP;
		this.dondatPhong = dondatPhong;
		this.soLuong = soLuong;
		this.dichvu = dichvu;
	}
	public CT_DatDV() {
		super();
	}
	
	public CT_DatDV(DonDatPhong dondatPhong, int soLuong, DichVu dichvu) {
		super();
		this.dondatPhong = dondatPhong;
		this.soLuong = soLuong;
		this.dichvu = dichvu;
	}
	public String getMaCTDP() {
		return maCTDP;
	}
	public void setMaCTDP(String maCTDP) {
		this.maCTDP = maCTDP;
	}
	public DonDatPhong getDondatPhong() {
		return dondatPhong;
	}
	public void setDondatPhong(DonDatPhong dondatPhong) {
		this.dondatPhong = dondatPhong;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public DichVu getDichvu() {
		return dichvu;
	}
	public void setDichvu(DichVu dichvu) {
		this.dichvu = dichvu;
	}
	@Override
	public String toString() {
		return "CT_DatDV [maCTDP=" + maCTDP + ", dondatPhong=" + dondatPhong + ", soLuong=" + soLuong + ", dichvu="
				+ dichvu + "]";
	}
	
	
	
}
