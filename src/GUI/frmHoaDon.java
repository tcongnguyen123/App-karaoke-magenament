package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Entity.DonDatPhong;

import javax.swing.SwingConstants;

public class frmHoaDon extends JFrame {

	private JPanel contentPane;
	private JTextField txtTenKH;
	private JTextField txtSoPhong;
	private JTextField txtGioBD;
	private JTextField txtGioKT;
	private JTextField txtTongThoiGian;
	private JTable table;
	private JLabel lblTongDV;
	private JTextField txtTongTienDV;
	private JLabel lblTenKH_4;
	private JTextField txtTongTienThoiGian;
	private JLabel lblTenKH_5;
	private JTextField txtTongTien;
	private JLabel lblMaHD;
	private JTextField txtMaHD;
	private JTextField txtNgayBD;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 755);
		contentPane = new JPanel();
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
		
		txtTenKH = new JTextField();
		txtTenKH.setEditable(false);
		txtTenKH.setBounds(171, 116, 96, 19);
		contentPane.add(txtTenKH);
		txtTenKH.setColumns(10);
		
		JLabel lblTenKH_1 = new JLabel("S\u1ED1 ph\u00F2ng");
		lblTenKH_1.setBounds(380, 122, 62, 16);
		contentPane.add(lblTenKH_1);
		
		txtSoPhong = new JTextField();
		txtSoPhong.setEditable(false);
		txtSoPhong.setColumns(10);
		txtSoPhong.setBounds(487, 119, 96, 19);
		contentPane.add(txtSoPhong);
		
		JLabel lblGioBD = new JLabel("gi\u1EDD b\u1EAFt \u0111\u1EA7u");
		lblGioBD.setBounds(64, 167, 62, 16);
		contentPane.add(lblGioBD);
		
		txtGioBD = new JTextField();
		txtGioBD.setEditable(false);
		txtGioBD.setColumns(10);
		txtGioBD.setBounds(171, 166, 96, 19);
		contentPane.add(txtGioBD);
		
		JLabel lblGioKT = new JLabel("gi\u1EDD k\u1EBFt th\u00FAc");
		lblGioKT.setBounds(64, 206, 62, 16);
		contentPane.add(lblGioKT);
		
		txtGioKT = new JTextField();
		txtGioKT.setEditable(false);
		txtGioKT.setColumns(10);
		txtGioKT.setBounds(171, 205, 202, 17);
		contentPane.add(txtGioKT);
		
		JLabel lblTenKH_2_2 = new JLabel("th\u1EDDi gian t\u1ED5ng");
		lblTenKH_2_2.setBounds(64, 245, 62, 16);
		contentPane.add(lblTenKH_2_2);
		
		txtTongThoiGian = new JTextField();
		txtTongThoiGian.setEditable(false);
		txtTongThoiGian.setColumns(10);
		txtTongThoiGian.setBounds(171, 244, 96, 19);
		contentPane.add(txtTongThoiGian);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		table.setBounds(64, 305, 522, 264);
		contentPane.add(table);
		
		lblTongDV = new JLabel("T\u1ED5ng d\u1ECBch v\u1EE5");
		lblTongDV.setHorizontalAlignment(SwingConstants.LEFT);
		lblTongDV.setBounds(380, 600, 62, 16);
		contentPane.add(lblTongDV);
		
		txtTongTienDV = new JTextField();
		txtTongTienDV.setColumns(10);
		txtTongTienDV.setBounds(487, 597, 96, 19);
		contentPane.add(txtTongTienDV);
		
		lblTenKH_4 = new JLabel("T\u1ED5ng ti\u1EC1n gi\u1EDD");
		lblTenKH_4.setBounds(380, 633, 62, 16);
		contentPane.add(lblTenKH_4);
		
		txtTongTienThoiGian = new JTextField();
		txtTongTienThoiGian.setColumns(10);
		txtTongTienThoiGian.setBounds(487, 630, 96, 19);
		contentPane.add(txtTongTienThoiGian);
		
		lblTenKH_5 = new JLabel("Th\u00E0nh ti\u1EC1n");
		lblTenKH_5.setBounds(380, 670, 62, 16);
		contentPane.add(lblTenKH_5);
		
		txtTongTien = new JTextField();
		txtTongTien.setColumns(10);
		txtTongTien.setBounds(487, 667, 96, 19);
		contentPane.add(txtTongTien);
		
		lblMaHD = new JLabel("M\u00E3 h\u00F3a \u0111\u01A1n");
		lblMaHD.setBounds(64, 603, 62, 16);
		contentPane.add(lblMaHD);
		
		txtMaHD = new JTextField();
		txtMaHD.setColumns(10);
		txtMaHD.setBounds(171, 600, 96, 19);
		contentPane.add(txtMaHD);
		
		txtNgayBD = new JTextField();
		txtNgayBD.setEditable(false);
		txtNgayBD.setColumns(10);
		txtNgayBD.setBounds(277, 166, 96, 19);
		contentPane.add(txtNgayBD);
	}
	public void xemThoiGian (DonDatPhong dondat) {
		DateTimeFormatter df =  DateTimeFormatter.ofPattern("dd-MM-yyyy");
		DateTimeFormatter dtf =  DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		DateTimeFormatter d =  DateTimeFormatter.ofPattern("HH:mm:ss");
		txtGioBD.setText(dondat.getGioThue());
		
		txtNgayBD.setText(df.format(dondat.getNgayThue()).toString());
		
		LocalDateTime ngayHT = LocalDateTime.now();
		LocalDate ngayHtai = LocalDate.of(ngayHT.getYear(), ngayHT.getMonth() , ngayHT.getDayOfMonth());
		
		Timestamp ngayhientai =Timestamp.valueOf(ngayHT);
		Date ngay = new Date(ngayhientai.getTime());
	//	String ngay = new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new java.util.Date (ngayhientai*1000));
		txtGioKT.setText(dtf.format(ngayHT).toString());
		txtSoPhong.setText(dondat.getPhong().getTenPhong());
		txtTenKH.setText(dondat.getKhachhang().getTenKH());
		//txtGioKT.setText(LocalDateTime.now());
		String s = dondat.getGioThue();
		LocalTime gio = LocalTime.parse(s);
		LocalDateTime a = LocalDateTime.of(dondat.getNgayThue().getYear(),dondat.getNgayThue().getMonth(),dondat.getNgayThue().getDayOfMonth(),gio.getHour(),gio.getMinute());
		long time1= getTime(dondat.getNgayThue());
		long time2 = getTime(ngayHtai);
		if (time1>time2) {
			txtTongThoiGian.setText("sai");
		}
		else {
			txtTongThoiGian.setText("ðúng");
		}
			
		long time = ngayHT.getHour() - a.getHour();
		String q = String.valueOf(time);
		//txtTongThoiGian.setText("Gio : "+q);
	}

	private long getTime(LocalDate ngayThue) {
		// TODO Auto-generated method stub
		return 0;
	}
}
