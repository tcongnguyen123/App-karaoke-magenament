package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import DAO.DichVu_DAO;
import DAO.DonDatPhong_DAO;
import DAO.KhachHang_DAO;
import DAO.LoaiPhong_DAO;
import DAO.NhanVien_DAO;
import DAO.Phong_DAO;
import Entity.DichVu;
import Entity.DonDatPhong;
import Entity.KhachHang;
import Entity.LoaiNhanVien;
import Entity.NhanVien;
import Entity.Phong;
import Other.DateFormat;
import Other.clockThread;
import connect_DB.connectDB;
import Other.ConvertToASCII;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.awt.SystemColor;
import java.awt.Window;
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
import javax.swing.SpinnerNumberModel;

import java.awt.Color;
import javax.swing.border.TitledBorder;
import java.awt.Component;
import java.awt.Container;
import javax.swing.JCheckBox;
import javax.swing.border.EtchedBorder;

public class frmDatPhong extends JFrame implements MouseListener,ActionListener{

	private JPanel panel;
	private JTextField txtMaDon;
	private JTextField txtTenPhong;
	private static JTextField txtSDT;
	private DefaultTableModel dfmodel;
	private JTable table;
	private JTable table_1;
	private DonDatPhong_DAO daoDonDatPhong;
	private ArrayList<DonDatPhong> danhSachDonDatPhong;
	private JTextField txtNgayTaoDon;
	private JTextField textField_1;
	private JTextField txtTenKH;
	private JTextField txtNgayBD;
	private Phong_DAO daoPhong;
	private LoaiPhong_DAO daoLoaiPhong;
	private ArrayList<Phong> danhSachPhong;
	private DefaultTableModel dfmodel1;
	private JTable table1;
	private JButton btnDatPhong;
	private UtilDateModel dateModel;
	private Properties dateProperties;
	private JDatePanelImpl datePanel;
	private KhachHang_DAO daoKhachHang;
	private DefaultTableModel dfmodel2;
	private DichVu_DAO daoDichVu;
	private ArrayList<DichVu> danhSachDichVu;
	private JButton btnTraPhong;
	private JLabel lblTBSoPhong;
	private JLabel lblTBGioBD;
	private JLabel lblTBTenKH;
	private static JTextField txtSoDienThoai;
	private JLabel lblHide;
	private JTextField txtNhanVien;
	private NhanVien_DAO daoNhanVien;
	private ArrayList<NhanVien> danhSachNV;
	private JButton btnXoaRong;
	private JButton btnThoat;
	private JDatePickerImpl dateNgayThue;
	private JLabel lblGi;
	private JTextField txt;
	private JLabel lblPht;
	private JTextField textField_2;
	private JSpinner txtGio;
	private JSpinner txtPhut;
	private JLabel lblTenNV;
	private JTextField txtNV;
	private ArrayList<NhanVien> danhSachTenNV;
	private JComboBox<String> cboTenNV;
	private ArrayList<KhachHang> danhSachTenKH;
	private int gio1;
	private ArrayList<DonDatPhong> danhSachGio;
	private Object gio111;
	private JButton btnTinhGio;
	private static JTextField txtTenKhachHang;
	private JButton btnChonKH;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmDatPhong frame = new frmDatPhong();
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
	public frmDatPhong() throws Exception {
		try {
			connectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		daoDonDatPhong = new DonDatPhong_DAO();
		daoPhong = new Phong_DAO();
	//	danhSachPhong = daoPhong.layDSPhong();
		daoLoaiPhong = new LoaiPhong_DAO();
		daoKhachHang = new KhachHang_DAO();
		daoDichVu = new DichVu_DAO();
		daoNhanVien = new NhanVien_DAO();
		setTitle("Đặt phòng");
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1480, 895);
		panel = new JPanel();
		panel.setBackground(new Color(240, 255, 255));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel lblMaPhong = new JLabel("Mã đơn là");
		lblMaPhong.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMaPhong.setBounds(96, 148, 85, 18);
		panel.add(lblMaPhong);
		
		txtMaDon = new JTextField();
		txtMaDon.setEditable(false);
		txtMaDon.setText(daoDonDatPhong.getMaMoi());
		txtMaDon.setBounds(216, 144, 133, 21);
		panel.add(txtMaDon);
		txtMaDon.setColumns(10);
		
		JLabel lblTenPhong = new JLabel("Tên phòng");
		lblTenPhong.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTenPhong.setBounds(450, 148, 110, 18);
		panel.add(lblTenPhong);
		
		txtTenPhong = new JTextField();
		txtTenPhong.setColumns(10);
		txtTenPhong.setBounds(570, 144, 133, 21);
		panel.add(txtTenPhong);
	/*	txtTrangThai = new JTextField();
		txtTrangThai.setColumns(10);
		txtTrangThai.setBounds(941, 144, 133, 21);
		panel.add(txtTrangThai);*/
		
		btnDatPhong = new JButton("\u0110\u1EB7t ph\u00F2ng");
		btnDatPhong.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnDatPhong.setBounds(1168, 262, 115, 30);
		panel.add(btnDatPhong);
		
		
		
		String [] tieude= {"Mã đơn","Tên Phòng","Ngày tạo đơn","Ngày giờ thuê","Tên khách hàng","Số điện thoại","Nhân viên phục vụ","Tình trạng thanh toán"};
		dfmodel=new DefaultTableModel(tieude,0);
		table=new JTable(dfmodel);
		
		
		table.addMouseListener(this);
		JScrollPane sc=new JScrollPane(table);
		sc.setBackground(new Color(240, 255, 255));
		sc.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch c\u00E1c \u0111\u01A1n \u0111\u1EB7t ph\u00F2ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		sc.setBounds(96, 590, 1340, 171);
		getContentPane().add(sc);
		
		JLabel lblTitle = new JLabel("Thông tin đặt phòng");
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblTitle.setBounds(658, 56, 345, 30);
		panel.add(lblTitle);
		
		btnTraPhong = new JButton("Trả phòng");
		btnTraPhong.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnTraPhong.setBounds(1321, 262, 115, 30);
		panel.add(btnTraPhong);
		
		JLabel lblNgayTaoDon = new JLabel("Ngày Tạo đơn");
		lblNgayTaoDon.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNgayTaoDon.setBounds(96, 208, 85, 18);
		panel.add(lblNgayTaoDon);
		
		txtNgayTaoDon = new JTextField();
		txtNgayTaoDon.setColumns(10);
		txtNgayTaoDon.setBounds(216, 204, 133, 21);
		panel.add(txtNgayTaoDon);
		
		/*txtNgayBD = new JTextField();
		txtNgayBD.setColumns(10);
		txtNgayBD.setBounds(570, 208, 133, 21);
		panel.add(txtNgayBD);*/
		
		
 		
		JLabel lblGioBD = new JLabel("giờ bắt đầu");
		lblGioBD.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGioBD.setBounds(450, 212, 85, 18);
		panel.add(lblGioBD);
		

		dateModel = new UtilDateModel();
		dateProperties = new Properties();
		dateProperties.put("text.today", "Today");
		dateProperties.put("text.month", "Month");
		dateProperties.put("text.year", "Year");
		datePanel = new JDatePanelImpl(dateModel, dateProperties);
		dateNgayThue = new JDatePickerImpl(datePanel, new DateFormat());
		dateNgayThue.getJFormattedTextField().setEditable(true);
		dateNgayThue.getJFormattedTextField().setBackground(SystemColor.textHighlightText);
		dateNgayThue.setSize(252, 28);
		//dateNgaySinh.setLocation(50, 161);
		dateNgayThue.setBounds(570, 208, 142, 21);
		panel.add(dateNgayThue);
		
		
		JLabel lblTenKH = new JLabel("Tên KH");
		lblTenKH.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTenKH.setBounds(823, 148, 85, 18);
		panel.add(lblTenKH);
		
	/*	txtTenKH = new JTextField();
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(1303, 144, 133, 21);
		panel.add(txtTenKH); */
		
    	
		
	/*	LocalDateTime lc = java.time.LocalDateTime.now();
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		txtNgayTaoDon.setText(df.format(lc));
		*/
		txtNgayTaoDon.setEditable(false);
		JLabel lblClock = new JLabel("New label");
		lblClock.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblClock.setBounds(450, 65, 98, 21);
		lblClock.hide();
		panel.add(lblClock);
		
		clockThread th = new clockThread(lblClock);
		
		
		
		String [] tieude1= {"Mã phòng","Tên phòng","Tên Loại phòng","Đơn giá","Tình trạng"};
		dfmodel1=new DefaultTableModel(tieude1,0);
		table1=new JTable(dfmodel1);
		
		
		
		//table1.addMouseListener(this);
		JScrollPane sc1=new JScrollPane(table1);
		sc1.setBackground(new Color(240, 255, 255));
		sc1.setBorder(new TitledBorder(null, "Danh s\u00E1ch c\u00E1c ph\u00F2ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		sc1.setBounds(96, 366, 1340, 171);
		getContentPane().add(sc1);
		
		lblTBSoPhong = new JLabel("");
		lblTBSoPhong.setBounds(450, 176, 253, 26);
		panel.add(lblTBSoPhong);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(821, 185, 432, 13);
		panel.add(lblNewLabel_2);
		
		lblTBGioBD = new JLabel("");
		lblTBGioBD.setBounds(821, 179, 615, 13);
		panel.add(lblTBGioBD);
		
		lblTBTenKH = new JLabel("");
		lblTBTenKH.setBounds(1168, 185, 268, 17);
		panel.add(lblTBTenKH);
		
		JLabel lblSDT = new JLabel("SDT");
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSDT.setBounds(1221, 148, 63, 18);
		panel.add(lblSDT);
		
		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setBounds(1303, 148, 133, 21);
		panel.add(txtSoDienThoai);
		
		lblHide = new JLabel("chua xac nhan");
		lblHide.setBounds(96, 285, 45, 13);
		lblHide.hide();
		panel.add(lblHide);
		
		btnXoaRong = new JButton("Xóa rỗng");
		btnXoaRong.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnXoaRong.setBounds(1008, 262, 115, 30);
		panel.add(btnXoaRong);
		
		btnThoat = new JButton("Thoát");
		btnThoat.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnThoat.setBounds(1321, 764, 115, 30);
		panel.add(btnThoat);
		
		lblGi = new JLabel("giờ");
		lblGi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGi.setBounds(450, 253, 85, 18);
		panel.add(lblGi);
		
		
		txtGio = new JSpinner();
		txtGio.setModel(new SpinnerNumberModel(new Short((short) 0), new Short((short) 0), new Short((short) 24),
				new Short((short) 1)));
		txtGio.setBounds(570, 250, 63, 21);
		panel.add(txtGio);
		txtPhut = new JSpinner();
		txtPhut.setModel(new SpinnerNumberModel(new Short((short) 0), new Short((short) 0), new Short((short) 59),
				new Short((short) 1)));
		txtPhut.setBounds(570, 281, 63, 21);
		panel.add(txtPhut);

		JLabel lblNewLabel_4 = new JLabel("phút");
		panel.add(lblNewLabel_4);

		JLabel lblH = new JLabel("giờ");
		panel.add(lblH);
		
		lblPht = new JLabel("Phút");
		lblPht.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPht.setBounds(450, 281, 85, 18);
		panel.add(lblPht);
		
		lblTenNV = new JLabel("Tên NV");
		lblTenNV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTenNV.setBounds(823, 208, 85, 18);
		panel.add(lblTenNV);
		
		
		cboTenNV = new JComboBox<String>();
		cboTenNV.setBounds(958, 203, 133, 21);
		panel.add(cboTenNV);
		
		danhSachTenNV = daoNhanVien.layDSTenNV();

		cboTenNV.addItem("Chọn Nhân Viên");
		for (NhanVien nv : danhSachTenNV) {
			cboTenNV.addItem(nv.getTenNV());
		}
		
		btnTinhGio = new JButton("Tính giờ");
		btnTinhGio.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnTinhGio.setBounds(861, 262, 115, 30);
		panel.add(btnTinhGio);
		
		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setBounds(958, 149, 133, 19);
		panel.add(txtTenKhachHang);
		txtTenKhachHang.setColumns(10);
		
		btnChonKH = new JButton("Chọn KH");
		btnChonKH.setBounds(1111, 148, 85, 21);
		panel.add(btnChonKH);
		
		
		
	
		
	
		
		
	
		

		
		
		String [] tieude2= {"Tên DV","Đơn vị tính","Đơn giá","Loại"};
		dfmodel2=new DefaultTableModel(tieude2,0);
		btnXoaRong.addActionListener(this);
		btnDatPhong.addActionListener(this);
		btnTraPhong.addActionListener(this);
		btnThoat.addActionListener(this);
		btnTinhGio.addActionListener(this);
		btnChonKH.addActionListener(this);
		docDSPhong();
		docDSDonDatPhong();
		docDSDichVu();
		

		th.start();
		
	
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	/*	int row = table.getSelectedRow();
		DefaultTableModel model  = (DefaultTableModel) table.getModel();
	/*	try {
			Date date =  new SimpleDateFormat("dd-MM-yyyy").parse((String) model.getValueAt(row, 2).toString());
			txtNgayBD.setValue(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
	/*	DefaultTableModel model1  = (DefaultTableModel) table.getModel();
		try {
			Date date =  new SimpleDateFormat("dd-MM-yyyy").parse((String) model1.getValueAt(row, 3).toString());
			dateModel.setValue(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtMaDon.setText(dfmodel.getValueAt(row, 0).toString());
		txtTenPhong.setText(dfmodel.getValueAt(row, 1).toString());
		txtNgayTaoDon.setText(dfmodel.getValueAt(row, 2).toString());
	
		
		txtSoDienThoai.setText(dfmodel.getValueAt(row, 5).toString());
		String tinhTrangDon = dfmodel.getValueAt(row,6).toString();
		*/

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
	private void docDSDonDatPhong() throws Exception {
		danhSachDonDatPhong = daoDonDatPhong.layDSDonDatPhong();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		for (DonDatPhong dondat : danhSachDonDatPhong) {
			dfmodel.addRow(new Object[] {dondat.getMaDon(), dondat.getPhong().getTenPhong(),formatter.format(dondat.getNgayTaoDon()),formatter.format( dondat.getNgayGioThue())
				,dondat.getKhachhang().getTenKH(),dondat.getKhachhang().getSdt(),dondat.getNhanvien().getTenNV()
				,dondat.getTinhTrangThanhToan()
			});	
		}
		
	}
	private void showDate() {
		LocalDateTime d = LocalDateTime.now();
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		txtNgayBD.setText(df.format(d));
	}
	private void docDSPhong() throws Exception {
		danhSachPhong = daoPhong.layDSPhong();
		for (Phong phong : danhSachPhong) {
			
			dfmodel1.addRow(new Object[] {phong.getMaPhong(), phong.getTenPhong(),phong.getLoaiPhong().getTenLoaiPhong(), 
					phong.getDonGia(),phong.getTinhTrang()
			});	
		}
	}
	private void docDSDichVu() throws Exception {
		danhSachDichVu = daoDichVu.layDSDichVu();
		for (DichVu dv : danhSachDichVu) {
		
			dfmodel2.addRow(new Object[] {dv.getTenDV(), dv.getDonGia(),dv.getDonViTinh(), 
					dv.getLoai()
			});	
		}
	}
	public static void setSDT (String makh, String tenkh,String sdt) {
		txtSDT.setText(sdt);
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnDatPhong)) {
			String tenPhong = txtTenPhong.getText().trim();
			String maPhong = daoPhong.getMa(tenPhong);
			
			
			
			String sdt = txtSoDienThoai.getText();
		
			
			String maDon = txtMaDon.getText();
			int viTriLoi = 0;
			LocalDateTime  localDTNgayGioThue1=  LocalDateTime.of(dateModel.getYear() , dateModel.getMonth()+1,
					dateModel.getDay(), Integer.parseInt(txtGio.getValue().toString()),
					Integer.parseInt(txtPhut.getValue().toString()), 0);
			
			 if (!localDTNgayGioThue1.isAfter(LocalDateTime.now())) {
					JOptionPane.showMessageDialog(this, "Ngày thuê phải sau ngày hiện tại");
					viTriLoi =1;
			 }
		

			
			
		/*	if (tenPhong.length()==0) {
				lblTBSoPhong.setText("Tên phòng không được để trống");
				viTriLoi=1;
			} else if (!ConvertToASCII.convertToASCII(tenPhong).matches("[1-9]{1}|[1-9]{1}[0-9]")) {
				lblTBSoPhong.setText("Tên phòng là số");
				viTriLoi=1;
			} else {
				lblTBSoPhong.setText("");
			} 
			if (sdt.length()==0) {
				lblTBSDT.setText("Tên phòng không được để trống");
				viTriLoi=1;
			} else if (!ConvertToASCII.convertToASCII(sdt).matches("0[1-9]{1}[0-9]{8}")) {
				lblTBSDT.setText("Số điện thoại gồm 10 số");
				viTriLoi=1;
			} else {
				lblTBSDT.setText("");
			}
			if (tenKH.length() == 0) {
				lblTBTenKH.setText("Tên khách hàng không được để trống!");
				viTriLoi = 1;
			} else if (tenKH.length() > 40) {
				lblTBTenKH.setText("Tên nhân viên tối đa 40 ký tự!");
				viTriLoi = 1;
			} else if (!ConvertToASCII.convertToASCII(tenKH).matches("[a-zA-Z đĐ]+")) {
				lblTBTenKH.setText("Tên nhân viên chỉ bao gồm ký tự và khoảng trắng!");
				viTriLoi = 1;
			} else {
				lblTBTenKH.setText("");
			} 
			if (GioThue.length()==0) {
				lblTBGioBD.setText("Ngày giờ thuê không được bỏ trống");
				viTriLoi =1;
			} else  if (!ConvertToASCII.convertToASCII(GioThue).matches("(0[1-9]|[1-2][0-9]|3[0-1])-(0[1-9]|1[0-2])-[0-9]{4} (2[0-3]|[01][0-9]):[0-5][0-9]:[0-5][0-9]")) {
				lblTBGioBD.setText("Ngày giờ theo định dạng dd-MM-yyyy HH:mm:ss (với d,m,y,h,m,s lần lượt là ngày tháng năm giờ phút giây");
				viTriLoi = 1;
			} else {
				lblTBGioBD.setText("");
			}*/
			if (viTriLoi ==0) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
				
				LocalDateTime  localDTNgayGioThue=  LocalDateTime.of(dateModel.getYear() , dateModel.getMonth()+1,
						dateModel.getDay(), Integer.parseInt(txtGio.getValue().toString()),
						Integer.parseInt(txtPhut.getValue().toString()), 0);
				
				LocalDateTime  local1=  LocalDateTime.of(dateModel.getYear() , dateModel.getMonth()+1,
						dateModel.getDay(), 0,0,
						0);
				LocalDateTime  local2=  LocalDateTime.of(dateModel.getYear() , dateModel.getMonth()+1,
						dateModel.getDay(), 23,59,
						59);
				LocalDateTime localDTNgayGioTao  = LocalDateTime.now();
				
				DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
				String n = localDTNgayGioThue.format(formatter1);
				LocalDate lc = LocalDate.of(dateModel.getYear(), dateModel.getMonth()+1, dateModel.getDay());
				String a;
				
				try {
					a = daoDonDatPhong.layDSGio(localDTNgayGioThue,local1,local2,maPhong);
					int b = Integer.parseInt(a);
					if(b<6) {
						JOptionPane.showMessageDialog(this, "Phòng đã có người đặt");
					} else {
						Phong phong = new Phong(maPhong,tenPhong);
						
						
						NhanVien nhanvien = danhSachTenNV.get(cboTenNV.getSelectedIndex() -1);
						String tenKH = txtTenKhachHang.getText();
						String maKH = daoKhachHang.getMa(tenKH, sdt);
						
						KhachHang khachhang = new KhachHang(maKH,tenKH,sdt);
										
						
						DonDatPhong ddp = new DonDatPhong(maDon,phong,khachhang,nhanvien,localDTNgayGioThue,localDTNgayGioTao);
				//		gio1 = Integer.parseInt(txtGio.getValue().toString()); 
					//	danhSachGio = daoDonDatPhong.layDSGio();
					//	for(DonDatPhong ddp1 : danhSachGio) {
							
						//	gio111 = Integer.parseInt(ddp1);
					//		int a = gio1-danhSachGio;
					//		if(gio1-ddp1<=3) {
					//			
						//	}
					//	}
							
						daoDonDatPhong.themDonDatPhong(ddp);
						dfmodel.setRowCount(0);
						docDSDonDatPhong();
						txtMaDon.setText(daoDonDatPhong.getMaMoi());
					} 
					
						
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(this, "Vui lòng đặt phòng lại");
					e1.printStackTrace();
				}
				
				
				
				
				//DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
				
				
				/*if (daoDonDatPhong.themDonDatPhong(ddp)) {
				dfmodel.setRowCount(0);
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					try {
						danhSachDonDatPhong = daoDonDatPhong.layDSDonDatPhong();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			
				for (DonDatPhong dondat : danhSachDonDatPhong) {
					dfmodel.addRow(new Object[] {dondat.getMaDon(), dondat.getPhong().getTenPhong(),formatter.format(dondat.getNgayTaoDon()),formatter.format( dondat.getNgayGioThue())
						,dondat.getKhachhang().getTenKH(),dondat.getKhachhang().getSdt(),dondat.getNhanvien().getTenNV()
					});	
				}
				txtMaDon.setText(daoDonDatPhong.getMaMoi());
				}
				else {
					JOptionPane.showMessageDialog(this, "Họ tên khách hàng cần phải được tạo tài khoản");
				}*/
			}
			
			
				
			

			
		}
		else if(o.equals(btnXoaRong)) {
			txtMaDon.setText("");
		}
		else if (o.equals(btnTinhGio)) {
			
			int row = table.getSelectedRow();
			String s = dfmodel.getValueAt(row, 1).toString();
			String tenphong = dfmodel.getValueAt(row, 1).toString();
			String maphong = daoPhong.getMa(tenphong);
			String gio = dfmodel.getValueAt(row, 3).toString();
			DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			LocalDateTime  local=  LocalDateTime.parse(gio, formater);
		
			if(daoPhong.getTinhTrangPhong(maphong).equals("Phòng đang sử dụng")) {
				JOptionPane.showMessageDialog(this, "Không thể tính giờ do phòng đang được dùng");
			} else if(dfmodel.getValueAt(row, 7).toString().equals("Đã thanh toán")) {
				JOptionPane.showMessageDialog(this, "Đơn đã thanh toán  nên không thể tính giờ");
			} else if (local.isAfter(LocalDateTime.now())) {
				JOptionPane.showMessageDialog(this,"Không thể tính giờ do chưa tới ngày giờ thuê");
			}
			else {
				String aaa = "Phòng đang sử dụng";
				String maDon1 = dfmodel.getValueAt(row, 0).toString();
				String string1 = "Đang chờ thanh toán";
				daoPhong.capNhatPhong(aaa, s);
				daoDonDatPhong.suaTinhTrangThanhToan(string1,maDon1);
				
				try {
					dfmodel1.setRowCount(0);
					docDSPhong();
					dfmodel.setRowCount(0);
					docDSDonDatPhong();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		
		}
		else if (o.equals(btnTraPhong)) {
		
			
			
			int row = table.getSelectedRow();
			String string1 = "Đã thanh toán";
			String maDon1 = dfmodel.getValueAt(row, 0).toString();
			if(dfmodel.getValueAt(row, 7).toString().equals("Đang chờ thanh toán")) {
				String tenphong = dfmodel.getValueAt(row, 1).toString();
				String maphong = daoPhong.getMa(tenphong);
				if(daoPhong.getTinhTrangPhong(maphong).equals("Phòng đang sử dụng")) {
					String aaa = "Phòng trống";
					String s1 = dfmodel.getValueAt(row, 1).toString();
					daoPhong.capNhatPhong(aaa, s1);
					
					daoDonDatPhong.suaTinhTrangThanhToan(string1,maDon1);
					dfmodel1.setRowCount(0);
					try {
						docDSPhong();
					} catch (Exception e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					String s = dfmodel.getValueAt(row, 7).toString();
					String sa = dfmodel.getValueAt(row, 6).toString();
					String gio = dfmodel.getValueAt(row, 3).toString();
					DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
					LocalDateTime  local=  LocalDateTime.parse(gio, formater);
					
					if(s.equals("Đã thanh toán") ) {
						JOptionPane.showMessageDialog(this, "Đơn này đã thanh toán");
					}
					
					else if (local.isAfter(LocalDateTime.now())) {
						JOptionPane.showMessageDialog(this,"Không thể trả phòng do chưa tới ngày giờ thuê");
					}
					
					else {
						frmHoaDon frmHoaDon = new frmHoaDon();
						try {
							frmHoaDon.xemThoiGian(danhSachDonDatPhong.get(table.getSelectedRow()));
							String tenPhong = txtTenPhong.getText().trim();
							String maPhong = daoPhong.getMa(tenPhong);
							Phong phong = new Phong(maPhong,tenPhong);
							
						
						
							
							String maDon = txtMaDon.getText();
							DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
							LocalDateTime  localDTNgayGioThue=  LocalDateTime.of(dateModel.getYear() , dateModel.getMonth()+1,
									dateModel.getDay(), Integer.parseInt(txtGio.getValue().toString()),
									Integer.parseInt(txtPhut.getValue().toString()), 0);
							
						
							LocalDateTime localDTNgayGioTao = LocalDateTime.now();
					
							
						//	boolean NVXacNhan = ckcTinhTrangDon.isSelected();
							
							
							
							String tinhtrangthanhtoan = "Đã thanh toán";
							daoDonDatPhong.suaTinhTrangThanhToan(tinhtrangthanhtoan,maDon);
							dfmodel.setRowCount(0);
							DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
								try {
									danhSachDonDatPhong = daoDonDatPhong.layDSDonDatPhong();
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
						
							for (DonDatPhong dondat : danhSachDonDatPhong) {
								dfmodel.addRow(new Object[] {dondat.getMaDon(), dondat.getPhong().getTenPhong(),formatter.format(dondat.getNgayTaoDon()),formatter.format( dondat.getNgayGioThue())
									,dondat.getKhachhang().getTenKH(),dondat.getKhachhang().getSdt(),dondat.getNhanvien().getTenNV(), dondat.getTinhTrangThanhToan()
								});	
							}
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						frmHoaDon.setVisible(true);
					}
				}
			}
				else if(dfmodel.getValueAt(row, 7).toString().equals("Chưa thanh toán"))  {
					JOptionPane.showMessageDialog(this, "Phòng chưa tính giờ nên không được thanh toán");
				} else {
					JOptionPane.showMessageDialog(this, "Phòng đã được thanh toán trước đó");
				}
			}
		else if(o.equals(btnChonKH)) {
			try {
				new frmChonKH().setVisible(true);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(o.equals(btnThoat)) {
			dispose();
		}
		}

		
		
	public static void setKH (String tenKH,String sdt) {
		txtTenKhachHang.setText(tenKH);
		txtSoDienThoai.setText(sdt);
		
	}
}
