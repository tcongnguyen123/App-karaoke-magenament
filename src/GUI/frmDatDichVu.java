package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import DAO.DichVu_DAO;
import DAO.DonDatDV_DAO;
import DAO.DonDatPhong_DAO;
import DAO.KhachHang_DAO;
import DAO.LoaiPhong_DAO;
import DAO.NhanVien_DAO;
import DAO.Phong_DAO;
import Entity.CT_DatDV;
import Entity.DichVu;
import Entity.DonDatPhong;
import Entity.KhachHang;
import Entity.NhanVien;
import Entity.Phong;
import Other.DateFormat;
import Other.clockThread;
import connect_DB.connectDB;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import java.awt.Component;
import java.awt.Container;

public class frmDatDichVu extends JFrame implements ActionListener{

	private JPanel panel;
	private JTextField txtSoLuong;
	private JTextField txtSDT;
	private DefaultTableModel dfmodel;
	private JTable table;
	private JTable table_1;
	private DonDatPhong_DAO daoDonDatPhong;
	private ArrayList<DonDatPhong> danhSachDonDatPhong;
	private JTextField textField_1;
	private JComboBox<String> cboSoPhong;
	private JTextField txtNgayBD;
	private Phong_DAO daoPhong;
	private LoaiPhong_DAO daoLoaiPhong;
	private ArrayList<Phong> danhSachPhong;
	private DefaultTableModel dfmodel1;
	private JTable table1;
	private JButton btnThemDV;
	private UtilDateModel dateModel;
	private Properties dateProperties;
	private JDatePanelImpl datePanel;
	private KhachHang_DAO daoKhachHang;
	private DefaultTableModel dfmodel2;
	private DichVu_DAO daoDichVu;
	private ArrayList<DichVu> danhSachDichVu;
	private ArrayList<DonDatPhong> danhSachPhongTrongDon;
	private JComboBox cboMaDon;
	private JComboBox cboTenDV;
	private ArrayList<DichVu> dsDichVu;
	private DonDatDV_DAO daoDonDatDV;
	private ArrayList<CT_DatDV> danhSachDonDatDV;
	private JLabel lblCTDP;
	private JTextField txtMaCTDP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmDatDichVu frame = new frmDatDichVu();
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
	@SuppressWarnings("unchecked")
	public frmDatDichVu() throws Exception {
		try {
			connectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		daoDonDatPhong = new DonDatPhong_DAO();
		daoPhong = new Phong_DAO();
		danhSachPhong = daoPhong.layDSPhong();
		daoLoaiPhong = new LoaiPhong_DAO();
		daoKhachHang = new KhachHang_DAO();
		daoDichVu = new DichVu_DAO();
		daoDonDatDV = new DonDatDV_DAO();
		setTitle("Đặt phòng");
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1480, 895);
		panel = new JPanel();
		panel.setBackground(new Color(240, 255, 255));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel lblSoLuong = new JLabel("Số lượng");
		lblSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSoLuong.setBounds(450, 148, 110, 18);
		panel.add(lblSoLuong);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(570, 144, 133, 21);
		panel.add(txtSoLuong);
		
		JLabel lblPhong = new JLabel("Phòng");
		lblPhong.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPhong.setBounds(821, 148, 85, 18);
		panel.add(lblPhong);
	
		
	/*	txtTrangThai = new JTextField();
		txtTrangThai.setColumns(10);
		txtTrangThai.setBounds(941, 144, 133, 21);
		panel.add(txtTrangThai);*/
		
		btnThemDV = new JButton("Thêm DV");
		btnThemDV.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnThemDV.setBounds(1321, 262, 115, 30);
		panel.add(btnThemDV);
		
		
		
		String [] tieude= {"Tên DV","Số lượng","Mã Đơn","Số phòng"};
		dfmodel=new DefaultTableModel(tieude,0);
		table=new JTable(dfmodel);
		
		
	//	table.addMouseListener(this);
		JScrollPane sc=new JScrollPane(table);
		sc.setBackground(new Color(240, 255, 255));
		sc.setBorder(new TitledBorder(null, "Danh s\u00E1ch c\u00E1c ph\u00F2ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		sc.setBounds(96, 590, 1340, 171);
		getContentPane().add(sc);
		
		JLabel lblTitle = new JLabel("Thông tin đặt phòng");
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblTitle.setBounds(658, 56, 345, 30);
		panel.add(lblTitle);
		
		JLabel lblTenDV = new JLabel("Tên DV");
		lblTenDV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTenDV.setBounds(96, 148, 85, 18);
		panel.add(lblTenDV);
		
		/*txtNgayBD = new JTextField();
		txtNgayBD.setColumns(10);
		txtNgayBD.setBounds(570, 208, 133, 21);
		panel.add(txtNgayBD);*/
		
		dateModel = new UtilDateModel();
		dateProperties = new Properties();
		dateProperties.put("text.today", "Today");
		dateProperties.put("text.month", "Month");
		dateProperties.put("text.year", "Year");
		datePanel = new JDatePanelImpl(dateModel, dateProperties);
		
		JLabel lblMaDon = new JLabel("Mã Đơn");
		lblMaDon.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMaDon.setBounds(1183, 149, 85, 18);
		panel.add(lblMaDon);
		JLabel lblClock = new JLabel("New label");
		lblClock.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblClock.setBounds(450, 65, 98, 21);
		panel.add(lblClock);
		
		clockThread th = new clockThread(lblClock);
		
		
		
		String [] tieude1= {"Tên DV","Đơn giá","Đơn vị tính","Loại"};
		dfmodel1=new DefaultTableModel(tieude1,0);
		table1=new JTable(dfmodel1);
		
		
		
		//table1.addMouseListener(this);
		JScrollPane sc1=new JScrollPane(table1);
		sc1.setBackground(new Color(240, 255, 255));
		sc1.setBorder(new TitledBorder(null, "Danh s\u00E1ch c\u00E1c ph\u00F2ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		sc1.setBounds(96, 366, 1340, 171);
		getContentPane().add(sc1);
		
		
		cboSoPhong = new JComboBox<String>();

		cboSoPhong.setBounds(941, 144, 133, 21);
		panel.add(cboSoPhong);
		danhSachPhongTrongDon = daoDonDatPhong.layDSDonDatPhong();
		for(DonDatPhong don : danhSachPhongTrongDon) {
			
			cboSoPhong.addItem(don.getPhong().getTenPhong());
		}
		
		cboMaDon = new JComboBox<String>();
		cboMaDon.setBounds(1298, 148, 138, 21);
		
		for(DonDatPhong don : danhSachPhongTrongDon) {

			cboMaDon.addItem(don.getMaDon());
		}
		panel.add(cboMaDon);
		
		cboTenDV = new JComboBox<String>();
		cboTenDV.setBounds(211, 149, 133, 18);
		
		dsDichVu = daoDichVu.layDSDichVu();
		for(DichVu dv : dsDichVu) {

			cboTenDV.addItem(dv.getTenDV());
		}
		panel.add(cboTenDV);
		
		lblCTDP = new JLabel("Mã CTDP");
		lblCTDP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCTDP.setBounds(91, 213, 110, 18);
		panel.add(lblCTDP);
		
		
		
		
		
		txtMaCTDP = new JTextField();
		txtMaCTDP.setColumns(10);
		txtMaCTDP.setBounds(211, 209, 133, 21);
		panel.add(txtMaCTDP);
		String [] tieude2= {"Tên DV","Đơn vị tính","Đơn giá","Loại"};
		dfmodel2=new DefaultTableModel(tieude2,0);
		
		btnThemDV.addActionListener(this);
	
		docDSDonDatDV();
		docDSDichVu();
		

		th.start();
		
	
	}

/*	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		DefaultTableModel model  = (DefaultTableModel) table.getModel();
	/*	try {
			Date date =  new SimpleDateFormat("dd-MM-yyyy").parse((String) model.getValueAt(row, 2).toString());
			txtNgayBD.setValue(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DefaultTableModel model1  = (DefaultTableModel) table.getModel();
		try {
			Date date =  new SimpleDateFormat("dd-MM-yyyy").parse((String) model1.getValueAt(row, 3).toString());
			dateModel.setValue(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	//	txtMaDV.setText(dfmodel.getValueAt(row, 0).toString());
		txtSoLuong.setText(dfmodel.getValueAt(row, 1).toString());
		//txtTenDV.setText(dfmodel.getValueAt(row, 2).toString());
		
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
		
	}*/
	private void docDSDonDatDV() throws Exception {
		danhSachDonDatDV = daoDonDatDV.layDSDonDatDV();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		for (CT_DatDV dondat : danhSachDonDatDV) {
			String maPhong = dondat.getDondatPhong().getPhong().getMaPhong();
			String tenPhong = daoDonDatDV.getMa(maPhong); 
			dfmodel.addRow(new Object[] { dondat.getDichvu().getMaDV(),dondat.getSoLuong(),dondat.getDondatPhong().getMaDon(),tenPhong
				
			});	
		}
		
	}
	private void showDate() {
		LocalDateTime d = LocalDateTime.now();
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		txtNgayBD.setText(df.format(d));
	}
	
	private void docDSDichVu() throws Exception {
		danhSachDichVu = daoDichVu.layDSDichVu();
		for (DichVu dv : danhSachDichVu) {
			
			dfmodel1.addRow(new Object[] {dv.getTenDV(), dv.getDonGia(),dv.getDonViTinh(), 
					dv.getLoai()
			});	
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnThemDV)) {
			String maCTDP = txtMaCTDP.getText();
			int soLuong = Integer.parseInt(txtSoLuong.getText());
			
			DichVu obDichVu = dsDichVu.get(cboTenDV.getSelectedIndex());
			String obMaDon = (String) cboMaDon.getSelectedItem();
			//Phong obTenPhong =danhSachPhongTrongDon.get(cboSoPhong.getSelectedIndex()-1) ;
			DonDatPhong obdondatphong = new DonDatPhong(obMaDon);
			CT_DatDV dondat = new CT_DatDV(maCTDP,obdondatphong,soLuong,obDichVu);
		
		/*	dondat.setMaCTDP(maCTDP);
			dondat.setDondatPhong(obdondatphong);
			dondat.setSoLuong(soLuong);
			dondat.setDichvu(obDichVu);*/
		//	String maPhong = dondat.getDondatPhong().getPhong().getMaPhong();
			//String tenPhong = daoDonDatDV.getMa(maPhong); 
			daoDonDatDV.themDonDatDV(dondat);
			dfmodel.addRow(new Object[] { dondat.getDichvu().getTenDV(),dondat.getSoLuong(),dondat.getDondatPhong().getMaDon(),dondat.getDondatPhong()
			});	
		}
	}
		//	daoDonDatPhong.suaDonDat(dondat);
		
			
}
