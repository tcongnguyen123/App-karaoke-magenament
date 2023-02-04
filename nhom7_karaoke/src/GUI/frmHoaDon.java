package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.CT_HoaDonPhongDAO;
import DAO.CT_HoaDon_DAO;
import DAO.DichVu_DAO;
import DAO.DonDatDV_DAO;
import DAO.DonDatPhong_DAO;
import DAO.HoaDon_DAO;
import DAO.NhanVien_DAO;
import DAO.Phong_DAO;
import Entity.CT_DatDV;
import Entity.CT_HoaDon;
import Entity.CT_HoaDonPhong;
import Entity.DichVu;
import Entity.DonDatPhong;
import Entity.HoaDon;
import Entity.KhachHang;
import Entity.NhanVien;
import Entity.Phong;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JButton;

public class frmHoaDon extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;
	private JLabel lblTongDV;
	private JLabel lblTenKH_4;
	private JLabel lblTenKH_5;
	private JLabel lblMaHD;
	private JLabel lblThoiGian;
	private JLabel lblTenKhachHang;
	private JLabel lblGioKetthuc;
	private JLabel lblTPhong;
	private JLabel lblNgayThue;
	private DefaultTableModel dfmodel;
	private DichVu_DAO daoDichVu;
	private DonDatDV_DAO daoDonDatDV;
	private ArrayList<CT_DatDV> danhSachDonDatDV;
	private JLabel lblThanhTien1;
	private JLabel lblTongTienGio;
	private CT_HoaDon_DAO daoCT_HoaDon;
	private JLabel lblTongTienDV;
	private JLabel lblNhanVien;
	private JLabel lblNguoiLap;
	private HoaDon_DAO daoHoaDon;
	private JButton btnThoat;
	private NhanVien_DAO daoNhanVien;
	private JLabel lblNewLabel;
	private JLabel txtMaHD;
	private HoaDon_DAO hddao;
	private ArrayList<CT_HoaDon> dscthd;
	private CT_HoaDon_DAO cthddao;
	private ArrayList<CT_DatDV> dsddichvu;
	private Phong_DAO daoPhong;
	private CT_HoaDonPhongDAO daoCTHDPhong;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmHoaDon frame = new frmHoaDon();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frmHoaDon() {
		daoCTHDPhong = new CT_HoaDonPhongDAO();
		daoPhong = new Phong_DAO(); 
		daoDichVu = new DichVu_DAO();
		daoDonDatDV = new DonDatDV_DAO();
		daoCT_HoaDon = new CT_HoaDon_DAO();
		daoHoaDon = new HoaDon_DAO();
		daoNhanVien = new NhanVien_DAO();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 648, 755);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblHoaDon = new JLabel("H\u00F3a \u0111\u01A1n");
		lblHoaDon.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblHoaDon.setBounds(274, 29, 112, 43);
		contentPane.add(lblHoaDon);
		
		JLabel lblTenKH = new JLabel("T\u00EAn KH");
		lblTenKH.setBounds(64, 119, 62, 16);
		contentPane.add(lblTenKH);
		
		JLabel lblTenPhong = new JLabel("Tên phòng");
		lblTenPhong.setBounds(380, 122, 62, 16);
		contentPane.add(lblTenPhong);
		
		JLabel lblGioBD = new JLabel("Giờ bắt đầu");
		lblGioBD.setBounds(64, 167, 81, 16);
		contentPane.add(lblGioBD);
		
		JLabel lblGioKT = new JLabel("Giờ kết thúc");
		lblGioKT.setBounds(64, 206, 81, 18);
		contentPane.add(lblGioKT);
		
		JLabel lblTenKH_2_2 = new JLabel("Thời gian tổng");
		lblTenKH_2_2.setBounds(64, 245, 81, 18);
		contentPane.add(lblTenKH_2_2);
		

		String [] tieude= {"Tên DV","Số lượng","Mã Đơn","Số phòng"};
		dfmodel=new DefaultTableModel(tieude,0);
		table=new JTable(dfmodel);
		
		
	//	table.addMouseListener(this);
		JScrollPane sc=new JScrollPane(table);
		sc.setBackground(new Color(240, 255, 255));
		sc.setBorder(new TitledBorder(null, "Danh sách các dịch vụ đã sử dụng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		sc.setBounds(64, 305, 522, 217);
		getContentPane().add(sc);
		
		
		lblTongDV = new JLabel("T\u1ED5ng d\u1ECBch v\u1EE5");
		lblTongDV.setHorizontalAlignment(SwingConstants.LEFT);
		lblTongDV.setBounds(380, 582, 86, 16);
		contentPane.add(lblTongDV);
		
		lblTenKH_4 = new JLabel("T\u1ED5ng ti\u1EC1n gi\u1EDD");
		lblTenKH_4.setBounds(380, 618, 86, 18);
		contentPane.add(lblTenKH_4);
		
		lblTenKH_5 = new JLabel("Th\u00E0nh ti\u1EC1n");
		lblTenKH_5.setBounds(380, 658, 86, 15);
		contentPane.add(lblTenKH_5);
		
		lblMaHD = new JLabel("M\u00E3 h\u00F3a \u0111\u01A1n");
		lblMaHD.setBounds(64, 582, 97, 16);
		contentPane.add(lblMaHD);
		
		lblThoiGian = new JLabel("New label");
		lblThoiGian.setBounds(171, 247, 202, 16);
		contentPane.add(lblThoiGian);
		
		lblTenKhachHang = new JLabel("New label");
		lblTenKhachHang.setBounds(168, 121, 202, 16);
		contentPane.add(lblTenKhachHang);
		
		lblGioKetthuc = new JLabel("New label");
		lblGioKetthuc.setBounds(171, 208, 202, 16);
		contentPane.add(lblGioKetthuc);
		
		lblTPhong = new JLabel("New label");
		lblTPhong.setBounds(456, 121, 202, 16);
		contentPane.add(lblTPhong);
		
		lblNgayThue = new JLabel("New label");
		lblNgayThue.setBounds(168, 169, 202, 16);
		contentPane.add(lblNgayThue);
		
		lblThanhTien1 = new JLabel("New label");
		lblThanhTien1.setBounds(487, 657, 99, 16);
		contentPane.add(lblThanhTien1);
		
		lblTongTienGio = new JLabel("");
		lblTongTienGio.setBounds(487, 618, 99, 16);
		contentPane.add(lblTongTienGio);
		
		lblTongTienDV = new JLabel("New label");
		lblTongTienDV.setBounds(487, 582, 99, 16);
		contentPane.add(lblTongTienDV);
		
		lblNhanVien = new JLabel("Người lập");
		lblNhanVien.setBounds(64, 633, 62, 16);
		contentPane.add(lblNhanVien);
		
		lblNguoiLap = new JLabel("Người lập");
		lblNguoiLap.setBounds(171, 634, 131, 16);
		contentPane.add(lblNguoiLap);
		
		btnThoat = new JButton("Thoát");
		btnThoat.setBounds(466, 687, 85, 21);
		contentPane.add(btnThoat);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(380, 169, 45, 13);
		contentPane.add(lblNewLabel);
		
		txtMaHD = new JLabel("Người lập");
		txtMaHD.setBounds(171, 582, 131, 16);
		contentPane.add(txtMaHD);
		btnThoat.addActionListener(this);
	}
	@SuppressWarnings("null")
	public void xemThoiGian (DonDatPhong dondat) throws Exception {
		DateTimeFormatter dtf =  DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		LocalDateTime ngayGioKetThuc = LocalDateTime.now();
	//	LocalDateTime ngayGioBatDau = LocalDateTime.of(dondat.getNgayGioThue().getYear()+1900, dondat.getNgayGioThue().getMonth(),dondat.getNgayGioThue().getDayOfMonth(), dondat.getNgayGioThue().getHour(), dondat.getNgayGioThue().getMinute(), dondat.getNgayGioThue().getSecond());
		LocalDateTime ngayGioBatDau = dondat.getNgayGioThue();
		LocalDateTime ngayGioLapDon = LocalDateTime.now();;
		String maPhong = dondat.getPhong().getMaPhong();
		String tenPhong1 = dondat.getPhong().getTenPhong();
		
		String maDon = dondat.getMaDon();
		danhSachDonDatDV = daoDonDatDV.docDSDVtheoMaDon(maDon);

		for (CT_DatDV donDat : danhSachDonDatDV) {
			String tenPhong = daoDonDatDV.getMa(maPhong); 
			dfmodel.addRow(new Object[] { donDat.getDichvu().getMaDV(),donDat.getSoLuong(),donDat.getDondatPhong().getMaDon(),tenPhong
				
			});	
		}
		
		String maKH = dondat.getKhachhang().getMaKH();
		String tenKH = dondat.getKhachhang().getTenKH();
		txtMaHD.setText(daoHoaDon.getMaMoi());
		
		lblGioKetthuc.setText(dtf.format(ngayGioKetThuc));
		lblNgayThue.setText(dtf.format(ngayGioBatDau));
		lblTenKhachHang.setText(tenKH);
		lblTPhong.setText(tenPhong1);
		
		
		
	
		String maKhachHang = lblTenKhachHang.getText();
		
	
		Timestamp dateBatDau = null;
		Timestamp dateKetThuc = null;
		
		dateBatDau = Timestamp.valueOf(ngayGioBatDau);
		dateKetThuc = Timestamp.valueOf(ngayGioKetThuc);
		
		long diffInMinutes = ngayGioKetThuc.getMinute() - ngayGioBatDau.getMinute();
		long diffInYears = 0;
		long diffInMonths = 0;
		long diffInDays = 0;
		long diffInHours = 0;
		if (diffInMinutes <= 0 ) {
			diffInMinutes = 60+diffInMinutes;
			 diffInYears = ngayGioKetThuc.getYear() - ngayGioBatDau.getYear();
			 diffInMonths = ngayGioKetThuc.getMonthValue() - ngayGioBatDau.getMonthValue();
			 diffInDays = ngayGioKetThuc.getDayOfMonth() - ngayGioBatDau.getDayOfMonth();
			 diffInHours = ((ngayGioKetThuc.getHour() - ngayGioBatDau.getHour())+diffInDays*24+diffInMonths*30*24+diffInYears*12*30*24)-1;
		}
		else {
			 diffInYears = ngayGioKetThuc.getYear() - ngayGioBatDau.getYear();
			 diffInMonths = ngayGioKetThuc.getMonthValue() - ngayGioBatDau.getMonthValue();
			 diffInDays = ngayGioKetThuc.getDayOfMonth() - ngayGioBatDau.getDayOfMonth();
			 diffInHours = (ngayGioKetThuc.getHour() - ngayGioBatDau.getHour())+diffInDays*24+diffInMonths*30*24+diffInYears*12*30*24;
		}
		String q1 = String.valueOf(diffInHours);
//		String q2 = String.valueOf(diffInDays);
		String q3 = String.valueOf(diffInMinutes);
//		String q = String.valueOf(ngayGioKetThuc.getDayOfMonth());
	//	String q4 = String.valueOf(diffInMonths);
		lblThoiGian.setText(" "+q1+" giờ "+q3+" phút");
	//	lblThoiGian.setText(""+q+""+q4);
		
	//	HoaDon hoadon (maHD,nhanvien,khachhang,ngayGioLapDon,ngayGioBatDau,ngayGioKetThuc,phong) 
	   

		String a = String.valueOf(dondat.getPhong().getDonGia());
		float phut = Float.valueOf(diffInMinutes);
		float time3 = phut/60;

		String b = String.valueOf(thoiGianTong( diffInHours,time3,dondat.getPhong().getDonGia()));
		lblTongTienGio.setText(b);
		Double thanhTienDV = daoCT_HoaDon.tongTienDichVu(dondat.getMaDon());
		String thanhtienDV = String.valueOf(thanhTienDV);
		lblTongTienDV.setText(thanhtienDV);
		Double tienTG = Double.valueOf(b);
		double tongTien = 0;
		tongTien = thanhTienDV + tienTG;
		lblThanhTien1.setText(String.valueOf(tongTien));
	//	lblNguoiLap.setText("Tr?n Công Nguyên");
	//	String tenNV = lblNguoiLap.getText();
	//	String maNV = daoNhanVien.getMaNV(tenNV);
		
		lblNguoiLap.setText(dondat.getNhanvien().getTenNV());
		
		String tennhanvien = lblNguoiLap.getText();
		String manhanvien = daoNhanVien.getMaNV(tennhanvien);
		
		lblNewLabel.setText(manhanvien);
		
	
		String maHoaDon = txtMaHD.getText();
		LocalDateTime lctdate = LocalDateTime.now();
		LocalDateTime lctdate2 = LocalDateTime.now();
		String ngaygiothue = lblNgayThue.getText().trim();
		
		
		LocalDateTime lctdate3 = LocalDateTime.parse(ngaygiothue,dtf);
		
		NhanVien nhanvien =new NhanVien (manhanvien);
		
		KhachHang khachhang = new KhachHang(maKH,tenKH);
		
		Phong phong = new Phong (maPhong,tenPhong1);
		
		DonDatPhong ddp = new DonDatPhong(maDon,ngayGioBatDau);
		
		//DichVu dichvu = danhSachDonDatDV.get(table.getSelectedRow());
		
	//	HoaDon hoadon = new HoaDon(maHoaDon,ddp,nhanvien,khachhang,lctdate,lctdate2,lctdate3);
		
	
		
	//	CT_HoaDon cthd = new CT_HoaDon(hd,phong);
		
		String MaPhong = "P01";
		String MaDichVu = "DV1";
		Phong phong1 = new Phong(MaPhong);
		DichVu dichvu1 = new DichVu(MaDichVu);
		
		int soGio = Integer.parseInt(q1); 
		double thanhTienGio =Double.parseDouble(b);
		String tenphong = lblTPhong.getText();
		String maPhong1 = daoPhong.getMa(tenphong);
		Phong p = new Phong(maPhong1,tenphong);
		
		
		String maNV = lblNewLabel.getText();
		
		
		int SoLuong = 0;
		HoaDon hdd = new HoaDon(maHoaDon);
		HoaDon hoadon = new HoaDon(maHoaDon,ddp,nhanvien,khachhang,lctdate,lctdate2,lctdate3,tongTien);
		
	
		
		
		hddao = new HoaDon_DAO();
		dscthd = new ArrayList<CT_HoaDon>();
		cthddao =new CT_HoaDon_DAO();
		dsddichvu = new DonDatDV_DAO().layDsCT_DatDVTheoPhieuDat(maDon);
	
		
		String hoadon11 = txtMaHD.getText();
		ArrayList<CT_DatDV> dsddvu = null;
		dsddvu = new DonDatDV_DAO().layDsCT_DatDVTheoPhieuDat(maDon);
		
		DonDatPhong ddp1 = new DonDatPhong_DAO().timDonDatPhong(maDon);
		hddao.themHoaDon(hoadon);
		CT_HoaDonPhong cthdp = new CT_HoaDonPhong(hoadon,soGio,thanhTienGio,p);
		daoCTHDPhong.themChiTietHoaDonPhong(cthdp);
	//	DichVu dichvu = new DichVu(maDV);
		for(CT_DatDV ctdv : dsddvu) {
			String maDV = new DichVu_DAO().timDichVu22(ctdv.getDichvu().getMaDV());
			DichVu dv  = new DichVu (ctdv.getDichvu().getMaDV());
			HoaDon hoadon1 = new HoaDon(hoadon11);
			Double tt = ctdv.getThanhTienDichVu();
			CT_HoaDon ct = new CT_HoaDon(hoadon1,ctdv.getSoLuong(),dv, tt);
			new CT_HoaDon_DAO().themChiTietHoaDon(ct);
		}
		
		
		
	}
		
		//	CT_HoaDon cthoadon = new CT_HoaDon(hd,SoLuong,phong1,dichvu1,soGio,thanhTienGio,thanhTienDV);
	//	try {
//			daoHoaDon.themHoaDon(hoadon);
		//	daoCT_HoaDon.themChiTietHoaDon(cthoadon);
		//	daoCT_HoaDon.suaHoaDon(cthd);
			
	//	} catch (Exception e) {
			// TODO: handle exception
		//	JOptionPane.showMessageDialog(this,"Hóa đơn này đã được thêm trước đó");
		//}
	
		
		
	

	
		
	
	private double tinhTien(int soLuong, int donGia) {
		double thanhTien = 0;
		thanhTien = soLuong * donGia;
		return thanhTien;
	}
	private double thoiGianTong(long time1,float time2, int donGia) {
		double tien = 0;
			tien = (time1+time2)*donGia;
		return tien;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnThoat)) {
			dispose();
		}
	}
	public void chuyenDatDVSangCTHD (String maDon,String maHD) {
		
	}
}
