package Entity;

public class CT_HoaDon {
		private HoaDon hoaDon;
		private int soLuong;
		private DichVu dichVu;
		private double thanhTienDV;
		public CT_HoaDon(HoaDon hoaDon, int soLuong, DichVu dichVu, double thanhTienDV) {
			super();
			this.hoaDon = hoaDon;
			this.soLuong = soLuong;
			this.dichVu = dichVu;
			this.thanhTienDV = thanhTienDV;
		}
		public CT_HoaDon() {
			
		}
		
		public CT_HoaDon(int soLuong, double thanhTienDV) {
			super();
			this.soLuong = soLuong;
			this.thanhTienDV = thanhTienDV;
		}
		public CT_HoaDon(HoaDon hoaDon, int soLuong, double thanhTienDV) {
			super();
			this.hoaDon = hoaDon;
			this.soLuong = soLuong;
			this.thanhTienDV = thanhTienDV;
		}
		public HoaDon getHoaDon() {
			return hoaDon;
		}
		public void setHoaDon(HoaDon hoaDon) {
			this.hoaDon = hoaDon;
		}
		public int getSoLuong() {
			return soLuong;
		}
		public void setSoLuong(int soLuong) {
			this.soLuong = soLuong;
		}
		public DichVu getDichVu() {
			return dichVu;
		}
		public void setDichVu(DichVu dichVu) {
			this.dichVu = dichVu;
		}
		public double getThanhTienDV() {
			return thanhTienDV;
		}
		public void setThanhTienDV(double thanhTienDV) {
			this.thanhTienDV = thanhTienDV;
		}
		@Override
		public String toString() {
			return "CT_HoaDon [hoaDon=" + hoaDon + ", soLuong=" + soLuong + ", dichVu=" + dichVu + ", thanhTienDV="
					+ thanhTienDV + "]";
		}
		
		
		

		
		

		
		
		
}
