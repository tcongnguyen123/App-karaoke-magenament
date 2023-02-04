package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import DAO.CT_HoaDon_DAO;
import DAO.DichVu_DAO;
import DAO.DonDatPhong_DAO;
import DAO.HoaDon_DAO;
import DAO.KhachHang_DAO;
import DAO.LoaiPhong_DAO;
import DAO.NhanVien_DAO;
import DAO.Phong_DAO;
import Entity.CT_HoaDon;
import Entity.HoaDon;
import Entity.Phong;
import connect_DB.connectDB;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Frame;
import javax.swing.JMenuBar;
import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class QuanLiHoaDon extends JFrame implements MouseListener,ActionListener {

	private JPanel contentPane;
	private DefaultTableModel modelNV;
	private JTable tableNV;
	private DefaultTableModel dfmodel;
	private DonDatPhong_DAO daoDonDatPhong;
	private Phong_DAO daoPhong;
	private ArrayList<Phong> danhSachPhong;
	private LoaiPhong_DAO daoLoaiPhong;
	private KhachHang_DAO daoKhachHang;
	private DichVu_DAO daoDichVu;
	private HoaDon_DAO daoHoaDon;
	private ArrayList<HoaDon> danhSachHoaDon;
	private ArrayList<HoaDon> danhsachTien;
	private NhanVien_DAO daoNhanVien;
	private DefaultTableModel dfmodel1;
	private JTable table1;
	private final JButton btnThoat = new JButton("Thoát");
	private DefaultTableModel dfmodel2;
	private JTable table2;
	private CT_HoaDon_DAO daoCTHD;
	private ArrayList<CT_HoaDon> danhSach;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLiHoaDon frame = new QuanLiHoaDon();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public QuanLiHoaDon() throws Exception {
		
		try {
			connectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		daoDonDatPhong = new DonDatPhong_DAO();
		daoPhong = new Phong_DAO();
	//	danhSachPhong = daoPhong.layDSPhong();
		daoLoaiPhong = new LoaiPhong_DAO();
		daoKhachHang = new KhachHang_DAO();
		daoDichVu = new DichVu_DAO();
		daoHoaDon = new HoaDon_DAO();
		daoCTHD = new CT_HoaDon_DAO();
		daoNhanVien = new NhanVien_DAO();
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setBackground(new Color(240, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1129, 705);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
	
		
		JLabel lblTitle = new JLabel("Quản lý hóa đơn");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblTitle.setBounds(675, 20, 182, 25);
		contentPane.add(lblTitle);
		
		
		
		String [] tieude1= {"Mã HĐ","Ngày lập","Người lập","Tên Khách hàng","Ngày lập đơn","Ngày giờ thuê","Ngày giờ trả","Tổng tiền"};
		dfmodel1=new DefaultTableModel(tieude1,0);
		table1=new JTable(dfmodel1);



		//table1.addMouseListener(this);
		JScrollPane sc1=new JScrollPane(table1);
		sc1.setBackground(new Color(240, 255, 255));
		sc1.setBorder(new TitledBorder(null, "Danh s\u00E1ch c\u00E1c ph\u00F2ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		sc1.setBounds(10, 125, 736, 487);
		getContentPane().add(sc1);
		
		String [] tieude2= {"Mã HD","Số lượng","Tên dv","Thành tiền"};
		dfmodel2=new DefaultTableModel(tieude2,0);
		table2=new JTable(dfmodel2);



		//table1.addMouseListener(this);
		JScrollPane sc2=new JScrollPane(table2);
		sc2.setBackground(new Color(240, 255, 255));
		sc2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch d\u1ECBch v\u1EE5 \u0111\u01B0\u1EE3c \u0111\u1EB7t", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		sc2.setBounds(840, 125, 666, 487);
		getContentPane().add(sc2);
		
		
		
		btnThoat.setBounds(422, 622, 148, 36);
		contentPane.add(btnThoat);
		
 		
		table1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					datDuLieu();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		docDSHoaDon();
	
 		
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnThoat)) {
			dispose();
		}
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	private void docDSHoaDon() throws Exception {
		danhSachHoaDon = daoHoaDon.layDsHoaDon();
		String a = "mot hai";
		SimpleDateFormat dtf  = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		DecimalFormat df  = new DecimalFormat("dd-MM-yyyy HH:mm:ss");
		 
		for (HoaDon hd : danhSachHoaDon) {
			String tenKH = daoKhachHang.getTenKH(hd.getKhachHang().getMaKH());
			String tenNV = daoNhanVien.getTenNV(hd.getNhanVien().getMaNV()); 
			dfmodel1.addRow(new Object[] {
					hd.getMaHD(),hd.getDonDat().getMaDon(),tenNV,tenKH, dtf1.format(hd.getNgayLapDon()),dtf1.format(hd.getNgayGiothue()),dtf1.format(hd.getGioTra()),hd.getTongTien()
			});
		}
		
	/*	for (CT_HoaDon hoadon : danhSachHoaDon) {
			
		//	String stringGiolap = String.valueOf(hoadon.getNgayLapDon());
			//@SuppressWarnings("deprecation")
			//long date = Date.parse(stringGiolap);
			String maKH = hoadon.getHoaDon().getKhachHang().getMaKH();
			String tenKH = daoKhachHang.getTenKH(maKH);
			String maNV = hoadon.getHoaDon().getNhanVien().getMaNV();
			String tenNV = daoNhanVien.getTenNV(maNV);
			dfmodel.addRow(new Object[] {hoadon.getHoaDon().getMaHD(),dtf1.format(hoadon.getHoaDon().getNgayLapDon()),tenNV,tenKH,dtf1.format(hoadon.getNgayGioThue()),dtf1.format(hoadon.getNgayGioTra()),hoadon.getTongTien()
			});	
*/
		}
	private void docDVtheoMa() throws Exception {
		int row = table1.getSelectedRow();
		String madon = (String) dfmodel1.getValueAt(row, 0);
		
		
		danhSach = daoCTHD.layDSHDTheoMa(madon);
		for (CT_HoaDon i : danhSach) {
			String tenDV = daoDichVu.getTenDV(i.getDichVu().getMaDV());
			
			dfmodel2.addRow(new Object[] {
					i.getHoaDon().getMaHD(),i.getSoLuong(),tenDV,i.getThanhTienDV()
			});
		}
		
	}
	public void datDuLieu() throws Exception {
		int row = table1.getSelectedRow();
		if(row!= -1) {
			dfmodel2.setRowCount(0);
			docDVtheoMa();
		}
	}
	}

/*	private void docDSHoaDonTien(String mhd) throws Exception {
		danhsachTien = daoHoaDon.layDSTongTienTG(mhd);
		
		SimpleDateFormat dtf  = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"); 
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		DecimalFormat df  = new DecimalFormat("dd-MM-yyyy HH:mm:ss");
		for (HoaDon hoadon : danhsachTien) {
			
		//	String stringGiolap = String.valueOf(hoadon.getNgayLapDon());
			//@SuppressWarnings("deprecation")
			//long date = Date.parse(stringGiolap);
			dfmodel.addRow(new Object[] {hoadon.getTien()});
		

		}
		
	}
*/
