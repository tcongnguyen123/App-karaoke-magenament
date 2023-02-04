package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Cursor;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import DAO.HoaDon_DAO;
import DAO.NhanVien_DAO;
import Entity.HoaDon;
import Entity.NhanVien;
import connect_DB.connectDB;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Font;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class ThongKeNgay extends JFrame implements MouseListener,ActionListener {

	private JPanel contentPane;
	private DefaultTableModel dfmodel1;
	private JTable table1;
	private JComboBox<String> cboThang;
	private ArrayList<HoaDon> danhSachHD;
	private JButton btnThongKe;
	private JLabel lblTTongDoanhThu;
	private JComboBox<String> cboNam;
	private JLabel lblTBTongGio;
	private JLabel lblTBTDTGio;
	private JLabel lblTBTongDTDV;
	private JLabel lblTBNgayI;
	private JLabel lblTTongDoanhThuNam;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongKeNgay frame = new ThongKeNgay();
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
	public ThongKeNgay() throws Exception {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		try {
			connectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		setTitle("Qu\u1EA3n l\u00FD h\u00F3a \u0111\u01A1n\r\n\r\n");
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1386, 810);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TH\u1ED0NG K\u00CA DOANH THU THEO NG\u00C0Y");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(628, 22, 489, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblThang = new JLabel("Tháng");
		lblThang.setBounds(194, 688, 45, 13);
		contentPane.add(lblThang);
		
		btnThongKe = new JButton("Th\u1ED1ng k\u00EA");
		btnThongKe.setBounds(1005, 663, 112, 21);
		contentPane.add(btnThongKe);
		
		String [] tieude1= {"Ngày","Tổng tiền "};
		dfmodel1=new DefaultTableModel(tieude1,0);
		table1=new JTable(dfmodel1);



		//table1.addMouseListener(this);
		JScrollPane sc1=new JScrollPane(table1);
		sc1.setBackground(new Color(240, 255, 255));
		sc1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch th\u00E0nh ti\u1EC1n ", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		sc1.setBounds(78, 108, 662, 487);
		getContentPane().add(sc1);
		
		JButton btnThot = new JButton("Tho\u00E1t");
		btnThot.setBounds(1158, 663, 112, 21);
		contentPane.add(btnThot);
		
		JLabel lblTongDoanhThu = new JLabel("Tổng doanh thu");
		lblTongDoanhThu.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblTongDoanhThu.setBounds(980, 142, 236, 38);
		contentPane.add(lblTongDoanhThu);
		
		lblTTongDoanhThu = new JLabel("New label");
		lblTTongDoanhThu.setBounds(1226, 142, 175, 21);
		contentPane.add(lblTTongDoanhThu);
		
		JLabel lblTongDoanhThuPhong = new JLabel("Tổng doanh thu phòng");
		lblTongDoanhThuPhong.setBounds(989, 259, 160, 30);
		contentPane.add(lblTongDoanhThuPhong);
		
		lblTBNgayI = new JLabel("Tổng giờ hát");
		lblTBNgayI.setBounds(1226, 445, 160, 30);
		contentPane.add(lblTBNgayI);
		
		JLabel lblTngDoanhThu = new JLabel("Tổng doanh thu dịch vụ");
		lblTngDoanhThu.setBounds(989, 323, 160, 30);
		contentPane.add(lblTngDoanhThu);
		
		 lblTBTongDTDV = new JLabel("Tổng giờ hát");
		lblTBTongDTDV.setBounds(1226, 323, 160, 30);
		contentPane.add(lblTBTongDTDV);
		
		JLabel lblNgayThuNhieuI = new JLabel("Ngày thu nhiều nhất");
		lblNgayThuNhieuI.setBounds(989, 450, 160, 21);
		contentPane.add(lblNgayThuNhieuI);
		
		 lblTBTDTGio = new JLabel("Tổng giờ hát");
		lblTBTDTGio.setBounds(1226, 385, 160, 30);
		contentPane.add(lblTBTDTGio);
		
		cboThang = new JComboBox<String>();
		cboThang.setBackground(Color.WHITE);
		cboThang.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		cboThang.setModel(new DefaultComboBoxModel<String>());
		cboThang.setBounds(282, 686, 52, 19);
		for(int i=1;i<=12;i++) {
			cboThang.addItem(String.valueOf(i));
		}
		contentPane.add(cboThang);
		
		JLabel lblNam = new JLabel("Năm");
		lblNam.setBounds(430, 692, 45, 13);
		contentPane.add(lblNam);
		
		cboNam = new JComboBox<String>();
		cboNam.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		cboNam.setBackground(Color.WHITE);
		cboNam.setBounds(501, 686, 79, 19);
		ArrayList<String> dsnam = new HoaDon_DAO().layDsNamLapHoaDon();
		int n = dsnam.size();
		for (int i =0;i<n;i++) {
			cboNam.addItem(dsnam.get(i));
		}
		btnThongKe.addActionListener(this);
		contentPane.add(cboNam);
		
		JLabel lblTongDoanhThuNam = new JLabel("Tổng doanh thu/Năm");
		lblTongDoanhThuNam.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblTongDoanhThuNam.setBounds(980, 190, 236, 38);
		contentPane.add(lblTongDoanhThuNam);
		
		lblTTongDoanhThuNam = new JLabel("New label");
		lblTTongDoanhThuNam.setBounds(1226, 205, 175, 21);
		contentPane.add(lblTTongDoanhThuNam);
		
		JLabel lblTongGioHat_1_1 = new JLabel("Tổng giờ hát");
		lblTongGioHat_1_1.setBounds(989, 385, 160, 30);
		contentPane.add(lblTongGioHat_1_1);
		
		lblTBTongGio = new JLabel("Tổng giờ hát");
		lblTBTongGio.setBounds(1226, 259, 160, 30);
		contentPane.add(lblTBTongGio);
	
		
	}
	

		@Override
		public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();
			if(o.equals(btnThongKe)) {
				
				String thang = (String) cboThang.getSelectedItem();
				String nam = (String) cboNam.getSelectedItem();
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
				double tongTien = new HoaDon_DAO().layTongDoanhThu(thang);
				lblTTongDoanhThu.setText(String.valueOf(tongTien));
				danhSachHD = new HoaDon_DAO().layDSHDtheoThang(nam);
				danhSachHD = new HoaDon_DAO().layDSHDtheoThang(thang);
				dfmodel1.setRowCount(0);
				for (HoaDon hd : danhSachHD) {
					dfmodel1.addRow(new Object[] { dtf.format(hd.getNgayLapDon()),
							hd.getTongTien()
					});
				}
				double tongTienNam = new HoaDon_DAO().layTongDoanhThuTheoNam(nam);
				lblTTongDoanhThuNam.setText(String.valueOf(tongTienNam));
				double tongGio = new HoaDon_DAO().layTongGio(thang);
				lblTBTongGio.setText(String.valueOf(tongGio));
				double tongDTDV = new HoaDon_DAO().layTongTDV(thang);
				lblTBTongDTDV.setText(String.valueOf(tongDTDV));
				double tongDTPhong = new HoaDon_DAO().layTongTTGio(thang);
				lblTBTDTGio.setText(String.valueOf(tongDTPhong));
				double tongDTNgayNhieuI = new HoaDon_DAO().layNgayThuNhieuI(thang);
				lblTBNgayI.setText(String.valueOf(tongDTNgayNhieuI));
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
}
