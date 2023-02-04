package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.LoaiPhong_DAO;
import DAO.Phong_DAO;
import Entity.LoaiNhanVien;
import Entity.LoaiPhong;
import Entity.NhanVien;
import Entity.Phong;
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
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TimKiemPhong extends JFrame implements MouseListener,ActionListener{

	private JPanel panel;
	private JTextField txtMaPhong;
	private DefaultTableModel dfmodel;
	private JTable table;
	private JTable table_1;
	private JTextField txtTenLoaiPhong;
	private JButton btnTim;
	private JComboBox<String> cboLoaiPhong;
	private Phong_DAO daoPhong;
	private LoaiPhong_DAO daoLoaiPhong;
	private ArrayList<LoaiPhong> danhSachLoaiPhong;
	private JLabel lblTenPhong;
	private JTextField txtTenPhong;
	private ArrayList<Phong> danhSachPhong;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimKiemPhong frame = new TimKiemPhong();
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
	public TimKiemPhong() throws Exception {
		try {
			connectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		daoPhong = new Phong_DAO();
		daoLoaiPhong = new LoaiPhong_DAO();
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1480, 895);
		panel = new JPanel();
		panel.setBackground(new Color(240, 255, 255));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel lblTimPhong = new JLabel("Tìm kiếm phòng");
		lblTimPhong.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblTimPhong.setBounds(667, 30, 577, 45);
		panel.add(lblTimPhong);
		
		JLabel lblMaPhong = new JLabel("Mã phòng");
		lblMaPhong.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMaPhong.setBounds(97, 148, 85, 18);
		panel.add(lblMaPhong);
		
		txtMaPhong = new JTextField();
		txtMaPhong.setBounds(216, 144, 133, 21);
		panel.add(txtMaPhong);
		txtMaPhong.setColumns(10);
		
		btnTim = new JButton("Tìm");


		btnTim.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnTim.setBounds(1321, 143, 115, 30);
		panel.add(btnTim);
		
		
		
		String [] tieude= {"Mã Phòng","Tên Phòng","Tên Loại Phòng","Đơn giá","Miêu tả","Tình trạng"};
		dfmodel=new DefaultTableModel(tieude,0);
		table=new JTable(dfmodel);
		
		
		table.addMouseListener(this);
		JScrollPane sc=new JScrollPane(table);
		sc.setBounds(96, 318, 1340, 378);
		getContentPane().add(sc);
		
		JLabel lblTenLoaiPhong = new JLabel("Tên loại phòng");
		lblTenLoaiPhong.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTenLoaiPhong.setBounds(506, 150, 109, 18);
		panel.add(lblTenLoaiPhong);
		
	/*	txtTenLoaiPhong = new JTextField();
		txtTenLoaiPhong.setColumns(10);
		txtTenLoaiPhong.setBounds(624, 144, 133, 21);
		panel.add(txtTenLoaiPhong); */
		cboLoaiPhong = new JComboBox<String>();
		cboLoaiPhong.setBounds(624, 144, 133, 21);
		panel.add(cboLoaiPhong);
		
		lblTenPhong = new JLabel("Tên Phòng");
		lblTenPhong.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTenPhong.setBounds(949, 154, 109, 18);
		panel.add(lblTenPhong);
		
		txtTenPhong = new JTextField();
		txtTenPhong.setColumns(10);
		txtTenPhong.setBounds(1067, 148, 133, 21);
		panel.add(txtTenPhong);
		danhSachLoaiPhong = daoLoaiPhong.layDSLoai();

		cboLoaiPhong.addItem("Chọn Loại Phòng");
		for (LoaiPhong loai : danhSachLoaiPhong) {
			cboLoaiPhong.addItem(loai.getTenLoaiPhong());
		}
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
		Object o = e.getSource();
		if(o.equals(btnTim)) {
			try {
				timKiemPhong();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	private void timKiemPhong() throws Exception {
		String maPhong = txtMaPhong.getText().trim();
		if(maPhong == null) {
			maPhong = "";
		}
		String tenPhong = txtTenPhong.getText().trim();
		if(tenPhong == null) {
			tenPhong = "";
		}
		String loaiPhong;
		if (cboLoaiPhong.getSelectedIndex()!=0) {
			loaiPhong = danhSachLoaiPhong.get(cboLoaiPhong.getSelectedIndex()-1).getTenLoaiPhong();
		}
		else {
			loaiPhong = "";
		}
		danhSachPhong = daoPhong.timPhong(maPhong,tenPhong,loaiPhong);
		dfmodel.setRowCount(0);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		for (Phong phong : danhSachPhong) {
			dfmodel.addRow(new Object[] {phong.getMaPhong(),phong.getTenPhong(),phong.getLoaiPhong().getMaLoai(),phong.getDonGia() ,phong.getMieuTa(),phong.getTinhTrang() });	
		}
	}
}
