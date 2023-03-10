package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.NhanVien_DAO;
import DAO.*;
import Entity.*;
import connect_DB.connectDB;
import DAO.*;
import Entity.*;



import java.awt.Component;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ManHinhChinh extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JMenuItem mntmTTCN;
	private JMenuItem mntmQLNV;
	private JMenuItem mntmDoiMK;
	private JMenuItem mntmQLHD;
	private JMenuItem mntmQLKH;
	private ArrayList<NhanVien> danhSachNhanVien;
	private NhanVien_DAO daoNhanVien;
	private JMenuItem mntmQLDV;
	private JMenuItem mntmTinhLuong;
	private JMenuItem mntmTKTNgay;
	private JMenuItem mntmDichVu;
	private JMenuItem mntmTimNhanVien;
	private JMenuItem mntmTimKhachHang;
	private JMenuItem mntmTimPhong;
	private JMenuItem mntmDatPhong;
	private JMenuItem mntmQLP;
	private JMenu mnHeThong;
	private JMenuItem mntmThoat;
	private JMenu mnDanhMuc;
	private JMenuBar menuBar;
	private JMenuItem mntmPCCT;
	private JMenuItem mntmChamCong;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManHinhChinh frame = new ManHinhChinh();
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
	public ManHinhChinh() {
		try {
			connectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		daoNhanVien = new NhanVien_DAO();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 659);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		menuBar = new JMenuBar();
		menuBar.setFont(new Font("Times New Roman", Font.BOLD, 17));
		menuBar.setBackground(new Color(255, 228, 196));
		setJMenuBar(menuBar);
		
		mnHeThong = new JMenu("H??? th???ng");
		menuBar.add(mnHeThong);
		
		mntmTTCN = new JMenuItem("Th??ng tin c?? nh??n");
		mnHeThong.add(mntmTTCN);
		
		mntmDoiMK = new JMenuItem("?????i m???t kh???u");
		mnHeThong.add(mntmDoiMK);
		
		mntmThoat = new JMenuItem("Tho??t");
		mnHeThong.add(mntmThoat);
		
		mnDanhMuc = new JMenu("Danh m???c");
		menuBar.add(mnDanhMuc);
		
		mntmQLNV = new JMenuItem("Qu???n l?? nh??n vi??n");
		mnDanhMuc.add(mntmQLNV);
		
		mntmQLKH = new JMenuItem("Qu???n l?? kh??ch h??ng");
		mnDanhMuc.add(mntmQLKH);
		
		mntmQLP = new JMenuItem("Qu???n l?? ph??ng");
		mnDanhMuc.add(mntmQLP);
		
		mntmQLDV = new JMenuItem("Qu\u1EA3n l\u00FD d\u1ECBch v\u1EE5");
		mnDanhMuc.add(mntmQLDV);
		
		mntmQLHD = new JMenuItem("Qu\u1EA3n l\u00FD h??a ????n");
		mnDanhMuc.add(mntmQLHD);
		
		JMenu mnXuLy = new JMenu("X\u1EED l\u00FD");
		menuBar.add(mnXuLy);
		
		mntmTinhLuong = new JMenuItem("T\u00EDnh l\u01B0\u01A1ng");
		mnXuLy.add(mntmTinhLuong);
		
		mntmPCCT = new JMenuItem("Ph??n c??ng ca tr???c");
		mnXuLy.add(mntmPCCT);
		
		mntmDatPhong = new JMenuItem("?????t phong");
		mnXuLy.add(mntmDatPhong);
		
		mntmChamCong = new JMenuItem("Ch???m c??ng");
		mnXuLy.add(mntmChamCong);
		
		JMenu mnThongKe = new JMenu("Th???ng k??");
		menuBar.add(mnThongKe);
		
		mntmTKTNgay = new JMenuItem("Th???ng k?? theo ng??y");
		mnThongKe.add(mntmTKTNgay);
		
		JMenuItem mntmNewMenuItem_1_2_2 = new JMenuItem("Th???ng k?? theo qu??");
		mnThongKe.add(mntmNewMenuItem_1_2_2);
		
		JMenuItem mntmNewMenuItem_2_2_2 = new JMenuItem("Th???ng k?? theo n??m");
		mnThongKe.add(mntmNewMenuItem_2_2_2);
		
		JMenu mntTimKiem = new JMenu("T\u00ECm ki\u1EBFm");
		menuBar.add(mntTimKiem);
		
		mntmTimNhanVien = new JMenuItem("Nh\u00E2n Vi\u00EAn");
		mntTimKiem.add(mntmTimNhanVien);
		
		mntmTimKhachHang = new JMenuItem("Kh\u00E1ch h\u00E0ng");
		mntTimKiem.add(mntmTimKhachHang);
		
		mntmTimPhong = new JMenuItem("Ph\u00F2ng");
		mntTimKiem.add(mntmTimPhong);
		
		mntmDichVu = new JMenuItem("D???ch v???");
		mntTimKiem.add(mntmDichVu);
		
		
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		mntmTTCN.addActionListener(this);
		mntmQLNV.addActionListener(this);
		mntmDoiMK.addActionListener(this);
		mntmQLHD.addActionListener(this);
		mntmQLKH.addActionListener(this);
		mntmQLDV.addActionListener(this);
		mntmTinhLuong.addActionListener(this);
		mntmTKTNgay.addActionListener(this);
		mntmDichVu.addActionListener(this);
		mntmTimNhanVien.addActionListener(this);
		mntmTimKhachHang.addActionListener(this);
		mntmTimPhong.addActionListener(this);
		mntmDatPhong.addActionListener(this);
		mntmQLP.addActionListener(this);
		mntmChamCong.addActionListener(this);
		mntmPCCT.addActionListener(this);
		//mntmTimHoaDon.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource(); 
		
		if(o.equals(mntmDoiMK)) {
			
			doiMK frmDoiMK = new doiMK();
			frmDoiMK.setVisible(true);
		}
		else if(o.equals(mntmQLNV)) {
			QuanLiNhanVien frmQLNV = null;
			try {
				frmQLNV = new QuanLiNhanVien();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frmQLNV.setVisible(true);
		}

		else if(o.equals(mntmQLKH)) {
			//this.setVisible(false);
			QuanLiKhachHang frmQLKH = null;
			try {
				frmQLKH = new QuanLiKhachHang();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frmQLKH.setVisible(true);
		}
		else if(o.equals(mntmQLDV)) {
			//this.setVisible(false);
			QuanLiDichVu frmQLDV = null;
			try {
				frmQLDV = new QuanLiDichVu();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frmQLDV.setVisible(true);
		}
		else if(o.equals(mntmQLHD)) {
			//this.setVisible(false);
			QuanLiHoaDon frmQLHD = null;
			try {
				frmQLHD = new QuanLiHoaDon();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frmQLHD.setVisible(true);
		}
		else if(o.equals(mntmTinhLuong)) {
			//this.setVisible(false);
			frmTinhLuong frmTinhLuong = null;
			try {
				frmTinhLuong = new frmTinhLuong();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frmTinhLuong.setVisible(true);
		}
		else if(o.equals(mntmTKTNgay)) {
			//this.setVisible(false);
			ThongKeNgay frmThongKe = null;
			try {
				frmThongKe = new ThongKeNgay();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frmThongKe.setVisible(true);
		}
		else if(o.equals(mntmDichVu)) {
			//this.setVisible(false);
			TimKiemDichVu frmTimKiemDichVu = null;
			try {
				frmTimKiemDichVu = new TimKiemDichVu();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frmTimKiemDichVu.setVisible(true);
		}
		else if(o.equals(mntmTimNhanVien)) {
			//this.setVisible(false);
			TimKiemNhanVien frmTimKiemNhanvien = null;
			try {
				frmTimKiemNhanvien = new TimKiemNhanVien();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frmTimKiemNhanvien.setVisible(true);
		}
		else if(o.equals(mntmTimKhachHang)) {
			//this.setVisible(false);
			TimKiemKhachHang frmTimKiemKhachhang = null;
			try {
				frmTimKiemKhachhang = new TimKiemKhachHang();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frmTimKiemKhachhang.setVisible(true);
		}
		else if(o.equals(mntmTimPhong)) {
			//this.setVisible(false);
			TimKiemPhong frmTimKiemPhong = null;
			try {
				frmTimKiemPhong = new TimKiemPhong();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frmTimKiemPhong.setVisible(true);
		}
		else if(o.equals(mntmDatPhong)) {
			//this.setVisible(false);
			frmDatPhong frmDatPhong = null;
			try {
				frmDatPhong = new frmDatPhong();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frmDatPhong.setVisible(true);
		}
		else if(o.equals(mntmQLP)) {
			//this.setVisible(false);
			QuanLiPhong frmQLPhong = null;
			try {
				frmQLPhong = new QuanLiPhong();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frmQLPhong.setVisible(true);
		}
		else if(o.equals(mntmPCCT)) {
			//this.setVisible(false);
			PhanCongCaTruc frmPCCT = null;
			try {
				frmPCCT = new PhanCongCaTruc();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frmPCCT.setVisible(true);
		}
		else if(o.equals(mntmChamCong)) {
			//this.setVisible(false);
			ChamCong frmChamCong = null;
			try {
				frmChamCong = new ChamCong();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			frmChamCong.setVisible(true);
		}
	}
	
}
