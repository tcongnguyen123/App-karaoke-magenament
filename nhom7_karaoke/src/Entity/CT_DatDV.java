package Entity;

public class CT_DatDV {
	private DonDatPhong dondatPhong;
	private int soLuong;
	private DichVu dichvu;
	private double thanhTienDichVu;
	public CT_DatDV() {
		super();
	}

	
	public CT_DatDV(DonDatPhong dondatPhong, int soLuong, DichVu dichvu, double thanhTienDichVu) {
		super();
		this.dondatPhong = dondatPhong;
		this.soLuong = soLuong;
		this.dichvu = dichvu;
		this.thanhTienDichVu = thanhTienDichVu;
	}

	
	public CT_DatDV(DonDatPhong dondatPhong, int soLuong, DichVu dichvu) {
		super();
		this.dondatPhong = dondatPhong;
		this.soLuong = soLuong;
		this.dichvu = dichvu;
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
	

	public double getThanhTienDichVu() {
		return thanhTienDichVu;
	}


	public void setThanhTienDichVu(double thanhTienDichVu) {
		this.thanhTienDichVu = thanhTienDichVu;
	}


	@Override
	public String toString() {
		return "CT_DatDV [dondatPhong=" + dondatPhong + ", soLuong=" + soLuong + ", dichvu=" + dichvu
				+ ", thanhTienDichVu=" + thanhTienDichVu + "]";
	}


	
}
