package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Entity.*;
import connect_DB.connectDB;
import DAO.*;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Container;

public class TimKiemNhanVien extends JFrame implements MouseListener,ActionListener{

	private JPanel panel;
	private JTextField txtMaNV;
	private JTextField txtHoTen;
	private JTextField txtDiaChi;
	private JTextField txtEmail;
	private JTextField txtSDT;
	private JTextField textField_3;
	private DefaultTableModel dfmodel;
	private JTable table;
	private JTable table_1;
	private JComboBox<String> cboLoaiNV;
	private LoaiNhanVien_DAO daoLoaiNhanVien;
	private ArrayList<LoaiNhanVien> danhSachLoaiNV;
	private NhanVien_DAO daoNhanVien;
	private JComboBox<String> cboMaNV;
	private ArrayList<NhanVien> danhSachMaNV;
	private JRadioButton radNam;
	private JRadioButton radNu;
	private ButtonGroup bg;
	private ArrayList<NhanVien> danhSachNhanVien;
	private JButton btnTim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimKiemNhanVien frame = new TimKiemNhanVien();
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
	public TimKiemNhanVien() throws Exception {
		try {
			connectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		daoNhanVien = new NhanVien_DAO();
		daoLoaiNhanVien = new LoaiNhanVien_DAO();
	
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1480, 895);
		panel = new JPanel();
		panel.setBackground(new Color(240, 255, 255));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel lblTimNhanVien = new JLabel("T\u00ECm ki\u1EBFm nh\u00E2n vi\u00EAn");
		lblTimNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblTimNhanVien.setBounds(657, 25, 577, 45);
		panel.add(lblTimNhanVien);
		
		JLabel lblMaNV = new JLabel("M\u00E3 Nh\u00E2n Vi\u00EAn");
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMaNV.setBounds(96, 148, 85, 18);
		panel.add(lblMaNV);
		
		JLabel lblNewLabel_1 = new JLabel("H\u1ECD t\u00EAn");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(95, 217, 85, 13);
		panel.add(lblNewLabel_1);
		
		/*txtMaNV = new JTextField();
		txtMaNV.setBounds(216, 144, 133, 21);
		panel.add(txtMaNV);
		txtMaNV.setColumns(10); */
		cboMaNV = new JComboBox<String>();
		cboMaNV.setBounds(216, 144, 133, 21);
		panel.add(cboMaNV);
		danhSachMaNV = daoNhanVien.layDSNhanVien();

		cboMaNV.addItem("Chọn Mã NV");
		for (NhanVien maNV : danhSachMaNV) {
			cboMaNV.addItem(maNV.getMaNV());
		}
		
		txtHoTen = new JTextField();
		txtHoTen.setBounds(217, 214, 132, 21);
		panel.add(txtHoTen);
		txtHoTen.setColumns(10);
		
		JLabel lblDiaChi = new JLabel("\u0110\u1ECBa ch\u1EC9");
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDiaChi.setBounds(450, 148, 85, 18);
		panel.add(lblDiaChi);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setBounds(449, 217, 85, 13);
		panel.add(lblEmail);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(570, 144, 133, 21);
		panel.add(txtDiaChi);
		
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
		
		/*textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(942, 214, 132, 21);
		panel.add(textField_3);
		*/
		radNam = new JRadioButton("Nam");
		radNam.setBackground(new Color(240, 255, 255));
		radNam.setBounds(941, 214, 103, 21);
		panel.add(radNam);
		radNam.setSelected(true);
		
		radNu = new JRadioButton("Nữ");
		radNu.setBackground(new Color(240, 255, 255));
		radNu.setBounds(1046, 214, 74, 21);
		panel.add(radNu);
		
		bg = new ButtonGroup();
		bg.add(radNam);
		bg.add(radNu);
		JLabel lblLoaiNV = new JLabel("Lo\u1EA1i Nh\u00E2n Vi\u00EAn");
		lblLoaiNV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLoaiNV.setBounds(1177, 148, 102, 18);
		panel.add(lblLoaiNV);
		
		/*JTextField txtLoaiNV = new JTextField();
		txtLoaiNV.setColumns(10);
		txtLoaiNV.setBounds(1303, 144, 133, 21);
		panel.add(txtLoaiNV); */
		cboLoaiNV = new JComboBox<String>();
		cboLoaiNV.setBounds(1289, 148, 142, 21);
		panel.add(cboLoaiNV);
		danhSachLoaiNV = daoLoaiNhanVien.layDSLoai();

		cboLoaiNV.addItem("Chọn Nhân Viên");
		for (LoaiNhanVien loai : danhSachLoaiNV) {
			cboLoaiNV.addItem(loai.getTenLoai());
		}
		
		
		
		btnTim = new JButton("T\u00ECm");
		btnTim.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnTim.setBounds(1303, 302, 115, 30);
		panel.add(btnTim);
		
		
		
		String [] tieude= {"Mã NV","Họ tên","Ngày Sinh","SDT","Giới tính","Email","DiaChi","Chức vụ"};
		dfmodel=new DefaultTableModel(tieude,0);
		table=new JTable(dfmodel);
		
		
		table.addMouseListener(this);
		JScrollPane sc=new JScrollPane(table);
		sc.setBounds(96, 383, 1340, 378);
		getContentPane().add(sc);
		
		btnTim.addActionListener(this);
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o  = e.getSource();
		if(o.equals(btnTim)) {
			try {
				timKiemNhanVien();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	private void timKiemNhanVien() throws Exception {
		String sdt = txtSDT.getText().trim();
		if (sdt == null) {
			sdt = "";
		}
		String maNhanV ;
		if (cboMaNV.getSelectedIndex()!=0) {
			maNhanV = danhSachMaNV.get(cboMaNV.getSelectedIndex()-1).getMaNV();
		}
		else {
			maNhanV = "";
		}
		String loaiNV ;
		if (cboLoaiNV.getSelectedIndex()!=0) {
			loaiNV = danhSachLoaiNV.get(cboLoaiNV.getSelectedIndex()-1).getTenLoai();
		}
		else {
			loaiNV = "";
		}
		String DiaChi = txtDiaChi.getText().trim();
		if (DiaChi == null) {
			DiaChi = "";
		}
		String hoTen = txtHoTen.getText().trim();
		if (hoTen == null) {
			hoTen = "";
		}
		String Email = txtEmail.getText().trim();
		if (Email == null) {
			Email = "";
		}
		
		danhSachNhanVien = daoNhanVien.timNhanVien(sdt,maNhanV,loaiNV,DiaChi,hoTen,Email);
		dfmodel.setRowCount(0);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		for (NhanVien nhanVien : danhSachNhanVien) {
			dfmodel.addRow(new Object[] {nhanVien.getMaNV(), nhanVien.getTenNV(), dtf.format(nhanVien.getNgaySinh()),nhanVien.getSoDienThoai(), nhanVien.isGioiTinh() ? "Nam" : "Nữ",nhanVien.getEmail(),nhanVien.getDiaChi(),nhanVien.getLoaiNV().getTenLoai() });	
		}
	}
	
}
