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

import DAO.CT_CaTruc_DAO;
import DAO.CaTruc_DAO;
import DAO.LoaiNhanVien_DAO;
import DAO.NhanVien_DAO;
import Entity.CT_CaTruc;
import Entity.CaTruc;
import Entity.NhanVien;
import connect_DB.connectDB;

import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

public class PhanCongCaTruc extends JFrame implements MouseListener {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel dfmodel;
	private JTextField textField;
	private CaTruc_DAO daoCaTruc;
	private CT_CaTruc_DAO daoCT_CaTruc;
	private ArrayList<CT_CaTruc> danhSachCaTruc;
	private ArrayList<CaTruc> danhSachCTCaTruc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhanCongCaTruc frame = new PhanCongCaTruc();
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
	public PhanCongCaTruc() throws Exception {
		try {
			connectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		daoCaTruc = new CaTruc_DAO();
		daoCT_CaTruc = new CT_CaTruc_DAO();
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1577, 882);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Ph\u00E2n C\u00F4ng Ca Tr\u1EF1c");
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblTitle.setBounds(703, 45, 464, 46);
		contentPane.add(lblTitle);
		
		String [] tieude= {"Mã NV","Họ tên","Ca 1","Ca 2","Ca 3","Tổng ca"};
		dfmodel=new DefaultTableModel(tieude,0);
		table=new JTable(dfmodel);
		
		
		table.addMouseListener(this);
		JScrollPane sc=new JScrollPane(table);
		sc.setBackground(new Color(240, 255, 255));
		sc.setBorder(new TitledBorder(null, "Danh sách ca trực nhân viên", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		sc.setBounds(93, 218, 1340, 378);
		getContentPane().add(sc);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnLuu.setBounds(1236, 149, 85, 21);
		contentPane.add(btnLuu);
		
		JLabel lblThang = new JLabel("Tháng");
		lblThang.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblThang.setBounds(968, 149, 70, 21);
		contentPane.add(lblThang);
		
		textField = new JTextField();
		textField.setBounds(1064, 150, 103, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		docDSCaTruc();
		//docDSCTCaTruc();
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
	private void docDSCaTruc() throws Exception {
		danhSachCaTruc = daoCT_CaTruc.layDSCT_CaTruc();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		for (CT_CaTruc catruc : danhSachCaTruc) {
			dfmodel.addRow(new Object[] {catruc.getNhanVien().getMaNV(),catruc.getNhanVien().getTenNV(),catruc.getNgayTruc()});	
		}
	}
	private void docDSCTCaTruc() throws Exception {
		danhSachCTCaTruc = daoCaTruc.layDSCaTruc();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		for (CaTruc catruc : danhSachCTCaTruc) {
			dfmodel.addRow(new Object[] {catruc.getMaCa(),catruc.getGioBD(),catruc.getGioKT(),catruc.getMucLuong()});	
		}
	}
}
