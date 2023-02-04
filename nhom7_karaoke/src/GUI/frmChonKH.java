package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import DAO.KhachHang_DAO;
import Entity.KhachHang;
import connect_DB.connectDB;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JButton;

public class frmChonKH extends JFrame implements MouseListener ,ActionListener{

	private JPanel contentPane;
	private DefaultTableModel dfmodel;
	private JTable table;
	private JButton btnChon;
	private JButton btnThoat;
	private KhachHang_DAO daoKhachHang;
	private ArrayList<KhachHang> danhSachKhachHang;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmChonKH frame = new frmChonKH();
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
	public frmChonKH() throws Exception {
		try {
			connectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		daoKhachHang =new KhachHang_DAO();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1008, 636);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Danh S\u00E1ch Kh\u00E1ch H\u00E0ng");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTitle.setBounds(378, 45, 265, 28);
		contentPane.add(lblTitle);
		String [] tieude= {"Mã KH","Họ tên","Số điện thoại"};
		dfmodel=new DefaultTableModel(tieude,0);
		table=new JTable(dfmodel);
		
		
		table.addMouseListener(this);
		JScrollPane sc=new JScrollPane(table);
		sc.setBackground(new Color(240, 255, 255));
		sc.setBorder(new TitledBorder(null, "Danh sách khách hàng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		sc.setBounds(32, 176, 907, 318);
		getContentPane().add(sc);
		
		 btnChon = new JButton("Chọn");
		btnChon.setBounds(327, 550, 85, 21);
		contentPane.add(btnChon);
		
		 btnThoat = new JButton("Thoát");
		btnThoat.setBounds(462, 550, 85, 21);
		contentPane.add(btnThoat);
		btnThoat.addActionListener(this);
		btnChon.addActionListener(this);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnChon)) {
			int row = table.getSelectedRow();
			frmDatPhong.setKH(dfmodel.getValueAt(row, 1).toString(),dfmodel.getValueAt(row, 2).toString());
			setVisible(false);
		}
		
	}
	private void docDSKhachHang() throws Exception {
		danhSachKhachHang = daoKhachHang.layDSKhachHang();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		for (KhachHang khachHang : danhSachKhachHang) {
			dfmodel.addRow(new Object[] {khachHang.getMaKH(), khachHang.getTenKH(),khachHang.getSdt() });	
		}
	}
}
