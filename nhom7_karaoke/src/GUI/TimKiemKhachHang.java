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
import Entity.KhachHang;
import Entity.NhanVien;
import connect_DB.connectDB;

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

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;

public class TimKiemKhachHang extends JFrame implements MouseListener, ActionListener {

	private JPanel panel;
	private JTextField txtMaKH;
	private JTextField txtHoTen;
	private JTextField txtEmail;
	private JTextField txtSDT;
	private JTextField txtGioiTinh;
	private DefaultTableModel dfmodel;
	private JTable table;
	private JTable table_1;
	private JTextField txtTuoi;
	private JButton btnTim;
	private JTextField txtCCCD;
	private KhachHang_DAO daoKhachHang;
	private ArrayList<KhachHang> danhSachKhachHang;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimKiemKhachHang frame = new TimKiemKhachHang();
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
	public TimKiemKhachHang() {
		try {
			connectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		daoKhachHang = new KhachHang_DAO();
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1480, 895);
		panel = new JPanel();
		panel.setBackground(new Color(240, 255, 255));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel lblTimNhanVien = new JLabel("T??m ki???m kh??ch h??ng");
		lblTimNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblTimNhanVien.setBounds(697, 24, 577, 45);
		panel.add(lblTimNhanVien);
		
		JLabel lblMaNV = new JLabel("M?? kh??ch h??ng");
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMaNV.setBounds(96, 148, 85, 18);
		panel.add(lblMaNV);
		
		JLabel lblNewLabel_1 = new JLabel("H??? t??n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(95, 217, 85, 13);
		panel.add(lblNewLabel_1);
		
		txtMaKH = new JTextField();
		txtMaKH.setBounds(216, 144, 133, 21);
		panel.add(txtMaKH);
		txtMaKH.setColumns(10);
		
		txtHoTen = new JTextField();
		txtHoTen.setBounds(217, 214, 132, 21);
		panel.add(txtHoTen);
		txtHoTen.setColumns(10);
		
		JLabel lblTuoi = new JLabel("Tu???i");
		lblTuoi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTuoi.setBounds(450, 148, 85, 18);
		panel.add(lblTuoi);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setBounds(449, 217, 85, 13);
		panel.add(lblEmail);
		
		txtTuoi = new JTextField();
		txtTuoi.setColumns(10);
		txtTuoi.setBounds(570, 144, 133, 21);
		panel.add(txtTuoi);
		
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
		
		txtGioiTinh = new JTextField();
		txtGioiTinh.setColumns(10);
		txtGioiTinh.setBounds(942, 214, 132, 21);
		panel.add(txtGioiTinh);
		
		
		
		txtCCCD = new JTextField();
		txtCCCD.setColumns(10);
		txtCCCD.setBounds(1303, 144, 133, 21);
		panel.add(txtCCCD);
		
		btnTim = new JButton("T??m");
		btnTim.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnTim.setBounds(1303, 302, 115, 30);
		panel.add(btnTim);
		
		
		
		String [] tieude= {"M?? KH","H??? t??n","SDT","Gi???i t??nh","C??n c?????c","Email","Tu???i"};
		dfmodel=new DefaultTableModel(tieude,0);
		table=new JTable(dfmodel);
		
		
		table.addMouseListener(this);
		JScrollPane sc=new JScrollPane(table);
		sc.setBackground(new Color(240, 255, 255));
		sc.setBounds(96, 379, 1340, 378);
		getContentPane().add(sc);
		btnTim.addActionListener(this);
		JLabel lblCCCD = new JLabel("C??n c?????c ");
		lblCCCD.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCCCD.setBounds(1192, 148, 133, 18);
		panel.add(lblCCCD);
		
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
		Object o = e.getSource();
		if(o.equals(btnTim)) {
			try {
				timKiemKhachHang();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	private void timKiemKhachHang() throws Exception {
		String sdt = txtSDT.getText().trim();
		if (sdt == null) {
			sdt = "";
		}
		String maKhachH = txtMaKH.getText().trim();
		if (maKhachH == null) {
			maKhachH = "";
		}
		String hoTen = txtHoTen.getText().trim();
		if (hoTen == null) {
			hoTen = "";
		}
		String Email = txtEmail.getText().trim();
		if (Email == null) {
			Email = "";
		}
		String cccd = txtCCCD.getText().trim();
		if (cccd == null) {
			cccd = "";
		}
		String tuoi = txtTuoi.getText().trim();
		if (tuoi == null) {
			tuoi = "";
		}
		danhSachKhachHang = daoKhachHang.timKhachHang(sdt,maKhachH,hoTen,Email,cccd,tuoi);
		dfmodel.setRowCount(0);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		for (KhachHang khachhang : danhSachKhachHang) {
			dfmodel.addRow(new Object[] {khachhang.getMaKH(),khachhang.getTenKH(),khachhang.getSdt(),khachhang.isGioiTinh() ? "Nam" : "N???" ,khachhang.getCccd(),khachhang.getEmail(),khachhang.getTuoi() });	
		}
	}
}
