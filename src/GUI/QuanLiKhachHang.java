package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.KhachHang_DAO;
import DAO.LoaiNhanVien_DAO;
import DAO.NhanVien_DAO;
import Entity.KhachHang;
import Entity.NhanVien;
import connect_DB.connectDB;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JRadioButton;

public class QuanLiKhachHang extends JFrame implements MouseListener{

	private JPanel panel;
	private JTextField txtMaKH;
	private JTextField txtHoTen;
	private JTextField txtCCCD;
	private JTextField txtEmail;
	private JTextField txtSDT;
	private DefaultTableModel dfmodel;
	private JTable table;
	private JTable table_1;
	private KhachHang_DAO daoKhachHang;
	private ArrayList<KhachHang> danhSachKhachHang;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLiKhachHang frame = new QuanLiKhachHang();
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
	public QuanLiKhachHang() throws Exception {
		try {
			connectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		daoKhachHang = new KhachHang_DAO();
		
		setTitle("Quản lí Khách hàng");
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1480, 895);
		panel = new JPanel();
		panel.setBackground(new Color(240, 255, 255));
		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel lblMaKH = new JLabel("Mã Khách Hàng");
		lblMaKH.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMaKH.setBounds(96, 148, 110, 17);
		panel.add(lblMaKH);
		
		JLabel lblHoTen = new JLabel("H\u1ECD t\u00EAn");
		lblHoTen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHoTen.setBounds(95, 217, 85, 13);
		panel.add(lblHoTen);
		
		txtMaKH = new JTextField();
		txtMaKH.setEditable(false);
		txtMaKH.setBounds(216, 144, 133, 21);
		panel.add(txtMaKH);
		txtMaKH.setColumns(10);
		
		txtHoTen = new JTextField();
		txtHoTen.setBounds(217, 214, 132, 21);
		panel.add(txtHoTen);
		txtHoTen.setColumns(10);
		
		JLabel lblCMND = new JLabel("Căn cước");
		lblCMND.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCMND.setBounds(450, 148, 85, 18);
		panel.add(lblCMND);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setBounds(449, 217, 85, 13);
		panel.add(lblEmail);
		
		txtCCCD = new JTextField();
		txtCCCD.setColumns(10);
		txtCCCD.setBounds(570, 144, 133, 21);
		panel.add(txtCCCD);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(571, 214, 132, 21);
		panel.add(txtEmail);
		
		JLabel lblSDT = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i");
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSDT.setBounds(821, 148, 85, 18);
		panel.add(lblSDT);
		
		JLabel lblGioiTinh = new JLabel("Gi\u1EDBi t\u00EDnh");
		lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGioiTinh.setBounds(820, 217, 85, 13);
		panel.add(lblGioiTinh);
		
		txtSDT = new JTextField();
		txtSDT.setColumns(10);
		txtSDT.setBounds(941, 144, 133, 21);
		panel.add(txtSDT);
		
		JLabel lblTuoi = new JLabel("Tuổi");
		lblTuoi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTuoi.setBounds(1177, 148, 102, 18);
		panel.add(lblTuoi);
		
		JTextField txtTuoi = new JTextField();
		txtTuoi.setColumns(10);
		txtTuoi.setBounds(1303, 144, 133, 21);
		panel.add(txtTuoi);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnSua.setBounds(1303, 302, 115, 30);
		panel.add(btnSua);
		
		
		
		String [] tieude= {"Mã KH","Họ tên","Số điện thoại","Giới tính","Căn cước","Email","Tuổi"};
		dfmodel=new DefaultTableModel(tieude,0);
		table=new JTable(dfmodel);
		
		
		table.addMouseListener(this);
		JScrollPane sc=new JScrollPane(table);
		sc.setBackground(new Color(240, 255, 255));
		sc.setBorder(new TitledBorder(null, "Danh sách khách hàng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		sc.setBounds(96, 383, 1340, 378);
		getContentPane().add(sc);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnXoa.setBounds(1145, 302, 115, 30);
		panel.add(btnXoa);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnThem.setBounds(974, 302, 115, 30);
		panel.add(btnThem);
		
		JRadioButton rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setBackground(new Color(240, 255, 255));
		rdbtnNam.setBounds(941, 214, 103, 21);
		panel.add(rdbtnNam);
		
		JRadioButton rdbtnNu = new JRadioButton("Nữ");
		rdbtnNu.setBackground(new Color(240, 255, 255));
		rdbtnNu.setBounds(1084, 214, 103, 21);
		panel.add(rdbtnNu);
		
		JLabel lblTitle = new JLabel("Thông Tin Khách Hàng");
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblTitle.setBounds(665, 50, 432, 43);
		panel.add(lblTitle);
		
		docDSKhachHang();
		
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
	private void docDSKhachHang() throws Exception {
		danhSachKhachHang = daoKhachHang.layDSKhachHang();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		for (KhachHang khachHang : danhSachKhachHang) {
			dfmodel.addRow(new Object[] {khachHang.getMaKH(), khachHang.getTenKH(),khachHang.getSdt(), khachHang.isGioiTinh() ? "Nam" : "Nữ",khachHang.getCccd(),khachHang.getEmail(),khachHang.getTuoi() });	
		}
	}
}
