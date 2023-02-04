package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.DichVu_DAO;
import Entity.DichVu;
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
import java.awt.Container;

public class TimKiemDichVu extends JFrame implements MouseListener,ActionListener{

	private JPanel panel;
	private JTextField txtMaDV;
	private JTextField txtTenDV;
	private JTextField txtDonViTinh;
	private DefaultTableModel dfmodel;
	private JTable table;
	private JTable table_1;
	private DichVu_DAO daoDichVu;
	private JButton btnTim;
	private ArrayList<DichVu> danhSachDichVu;
	private JTextField txtLoai;
	private JButton btnThoat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimKiemDichVu frame = new TimKiemDichVu();
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
	public TimKiemDichVu() {
		try {
			connectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		daoDichVu = new DichVu_DAO();
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1480, 895);
		panel = new JPanel();
		panel.setBackground(new Color(240, 255, 255));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel lblTimNhanVien = new JLabel("Tìm kiếm dịch vụ");
		lblTimNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblTimNhanVien.setBounds(682, 27, 577, 45);
		panel.add(lblTimNhanVien);
		
		JLabel lblMaDV = new JLabel("Mã dịch vụ");
		lblMaDV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMaDV.setBounds(96, 149, 85, 18);
		panel.add(lblMaDV);
		
		txtMaDV = new JTextField();
		txtMaDV.setBounds(216, 144, 133, 21);
		panel.add(txtMaDV);
		txtMaDV.setColumns(10);
		
		JLabel lblTen = new JLabel("Tên mặt hàng");
		lblTen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTen.setBounds(450, 148, 85, 18);
		panel.add(lblTen);
		
		txtTenDV = new JTextField();
		txtTenDV.setColumns(10);
		txtTenDV.setBounds(570, 144, 133, 21);
		panel.add(txtTenDV);
		
		JLabel lblDonViTinh = new JLabel("Đơn vị tính");
		lblDonViTinh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDonViTinh.setBounds(821, 148, 85, 18);
		panel.add(lblDonViTinh);
		
		txtDonViTinh = new JTextField();
		txtDonViTinh.setColumns(10);
		txtDonViTinh.setBounds(941, 144, 133, 21);
		panel.add(txtDonViTinh);
		
		btnTim = new JButton("Tìm");
		btnTim.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnTim.setBounds(1321, 216, 115, 30);
		panel.add(btnTim);
		
		
		
		String [] tieude= {"Mã Dịch vụ", "Tên mặt hàng","Đơn giá","Đơn vị tính","Loại"};
		dfmodel=new DefaultTableModel(tieude,0);
		table=new JTable(dfmodel);
		
		
		table.addMouseListener(this);
		JScrollPane sc=new JScrollPane(table);
		sc.setBounds(96, 307, 1340, 378);
		getContentPane().add(sc);
		
		JLabel lblLoai = new JLabel("Loại");
		lblLoai.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLoai.setBounds(1183, 149, 85, 18);
		panel.add(lblLoai);
		
		txtLoai = new JTextField();
		txtLoai.setColumns(10);
		txtLoai.setBounds(1303, 143, 133, 21);
		panel.add(txtLoai);
		
		btnThoat = new JButton("Thoát");
		btnThoat.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnThoat.setBounds(1167, 216, 115, 30);
		panel.add(btnThoat);
		
		btnTim.addActionListener(this);
		btnThoat.addActionListener(this);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtMaDV.setText(dfmodel.getValueAt(row,0).toString());
		txtTenDV.setText(dfmodel.getValueAt(row,1).toString());
		txtDonViTinh.setText(dfmodel.getValueAt(row,3).toString());
		txtLoai.setText(dfmodel.getValueAt(row,4).toString());
		
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
		Object o = e.getSource();
		if(o.equals(btnTim)) {
			try {
				timKiemDichVu();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if(o.equals(btnThoat)) {
			dispose();
		}
	}
	private void timKiemDichVu() throws Exception {
		String maDichVu = txtMaDV.getText().trim();
		if (maDichVu == null) {
			maDichVu = "";
		}
		String tenDichVu = txtTenDV.getText().trim();
		if (tenDichVu == null) {
			tenDichVu = "";
		}
		String donvitinh = txtDonViTinh.getText().trim();
		if (donvitinh == null) {
			donvitinh = "";
		}
		String Loai = txtLoai.getText().trim();
		if (Loai == null) {
			Loai = "";
		}
	//	int dongia = Integer.parseInt(txtDonGia.getText().trim());
	//	if (dongia == null) {
	//		dongia = "";
	//	}
		
		danhSachDichVu = daoDichVu.timDichVu(maDichVu,tenDichVu,donvitinh,Loai);
		dfmodel.setRowCount(0);
		for (DichVu dichVu : danhSachDichVu) {
			dfmodel.addRow(new Object[] {dichVu.getMaDV(),dichVu.getTenDV(),dichVu.getDonGia(),dichVu.getDonViTinh(),dichVu.getLoai() 
					});	
		}
	}
}
