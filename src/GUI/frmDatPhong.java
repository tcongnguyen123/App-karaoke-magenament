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
import DAO.DonDatPhong_DAO;
import DAO.KhachHang_DAO;
import DAO.LoaiPhong_DAO;
import DAO.NhanVien_DAO;
import DAO.Phong_DAO;
import Entity.DichVu;
import Entity.DonDatPhong;
import Entity.KhachHang;
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
import java.awt.Color;
import javax.swing.border.TitledBorder;
import java.awt.Component;
import java.awt.Container;

public class frmDatPhong extends JFrame implements MouseListener,ActionListener{

	private JPanel panel;
	private JTextField txtMaDon;
	private JTextField txtSoPhong;
	private JTextField txtSDT;
	private DefaultTableModel dfmodel;
	private JTable table;
	private JTable table_1;
	private DonDatPhong_DAO daoDonDatPhong;
	private ArrayList<DonDatPhong> danhSachDonDatPhong;
	private JTextField txtNgayTaoDon;
	private JTextField textField_1;
	private JTextField txtGioBD;
	private JTextField txtTenKH;
	private JComboBox<String> cboTrangThai;
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
	private JDatePickerImpl dateNgayBD;
	private KhachHang_DAO daoKhachHang;
	private DefaultTableModel dfmodel2;
	private DichVu_DAO daoDichVu;
	private ArrayList<DichVu> danhSachDichVu;
	private JButton btnTraPhong;
	private JLabel lblTBSoPhong;
	private JLabel lblTBNgayBD;
	private JLabel lblTBGioBD;
	private JLabel lblTBTenKH;

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
		danhSachPhong = daoPhong.layDSPhong();
		daoLoaiPhong = new LoaiPhong_DAO();
		daoKhachHang = new KhachHang_DAO();
		daoDichVu = new DichVu_DAO();
		setTitle("Đặt phòng");
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1480, 895);
		panel = new JPanel();
		panel.setBackground(new Color(240, 255, 255));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel lblMaPhong = new JLabel("Mã đơn");
		lblMaPhong.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMaPhong.setBounds(96, 148, 85, 18);
		panel.add(lblMaPhong);
		
		txtMaDon = new JTextField();
		txtMaDon.setEditable(false);
		txtMaDon.setText(daoDonDatPhong.getMaMoi());
		txtMaDon.setBounds(216, 144, 133, 21);
		panel.add(txtMaDon);
		txtMaDon.setColumns(10);
		
		JLabel lblSoPhong = new JLabel("Số phòng");
		lblSoPhong.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSoPhong.setBounds(450, 148, 110, 18);
		panel.add(lblSoPhong);
		
		txtSoPhong = new JTextField();
		txtSoPhong.setColumns(10);
		txtSoPhong.setBounds(570, 144, 133, 21);
		panel.add(txtSoPhong);
		
		JLabel lblTrangThai = new JLabel("Trạng thái");
		lblTrangThai.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTrangThai.setBounds(821, 148, 85, 18);
		panel.add(lblTrangThai);
		
		cboTrangThai = new JComboBox<String>();
		cboTrangThai.addItem("Đầy");
		cboTrangThai.addItem("Trống");

		cboTrangThai.setBounds(941, 144, 133, 21);
		panel.add(cboTrangThai);
	/*	txtTrangThai = new JTextField();
		txtTrangThai.setColumns(10);
		txtTrangThai.setBounds(941, 144, 133, 21);
		panel.add(txtTrangThai);*/
		
		btnDatPhong = new JButton("\u0110\u1EB7t ph\u00F2ng");
		btnDatPhong.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnDatPhong.setBounds(1168, 262, 115, 30);
		panel.add(btnDatPhong);
		
		
		
		String [] tieude= {"Mã đơn","Số Phòng","Ngày tạo đơn","Ngày bắt đầu","giờ bắt đầu","Tên khách hàng"};
		dfmodel=new DefaultTableModel(tieude,0);
		table=new JTable(dfmodel);
		
		
		table.addMouseListener(this);
		JScrollPane sc=new JScrollPane(table);
		sc.setBackground(new Color(240, 255, 255));
		sc.setBorder(new TitledBorder(null, "Danh s\u00E1ch c\u00E1c ph\u00F2ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
		
		JLabel lblNgayBD = new JLabel("Ngày bắt đầu");
		lblNgayBD.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNgayBD.setBounds(450, 212, 85, 18);
		panel.add(lblNgayBD);
		
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
		dateNgayBD = new JDatePickerImpl(datePanel, new DateFormat());
		dateNgayBD.getJFormattedTextField().setEditable(true);
		dateNgayBD.getJFormattedTextField().setBackground(SystemColor.textHighlightText);
		dateNgayBD.setSize(252, 28);
		//dateNgayBD.setLocation(50, 161);
		dateNgayBD.setBounds(570, 208, 133, 21);
		panel.add(dateNgayBD);
 		
		JLabel lblGioBD = new JLabel("giờ bắt đầu");
		lblGioBD.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGioBD.setBounds(821, 208, 85, 18);
		panel.add(lblGioBD);
		
		txtGioBD = new JTextField();
		txtGioBD.setColumns(10);
		txtGioBD.setBounds(941, 208, 133, 21);
		panel.add(txtGioBD);
		
		JLabel lblTenKH = new JLabel("Tên KH");
		lblTenKH.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTenKH.setBounds(1168, 148, 85, 18);
		panel.add(lblTenKH);
		
		txtTenKH = new JTextField();
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(1303, 144, 133, 21);
		panel.add(txtTenKH);
		
    	
		
	/*	LocalDateTime lc = java.time.LocalDateTime.now();
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		txtNgayTaoDon.setText(df.format(lc));
		*/
		txtNgayTaoDon.setEditable(false);
		JLabel lblClock = new JLabel("New label");
		lblClock.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblClock.setBounds(450, 65, 98, 21);
		panel.add(lblClock);
		
		clockThread th = new clockThread(lblClock);
		
		
		
		String [] tieude1= {"Mã phòng","Số phòng","Tên Loại phòng","Đơn giá","Tình trạng"};
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
		lblNewLabel_2.setBounds(821, 185, 253, 13);
		panel.add(lblNewLabel_2);
		
		lblTBNgayBD = new JLabel("");
		lblTBNgayBD.setBounds(450, 249, 253, 13);
		panel.add(lblTBNgayBD);
		
		lblTBGioBD = new JLabel("");
		lblTBGioBD.setBounds(821, 249, 253, 13);
		panel.add(lblTBGioBD);
		
		lblTBTenKH = new JLabel("");
		lblTBTenKH.setBounds(1168, 185, 268, 17);
		panel.add(lblTBTenKH);
		
		
		String [] tieude2= {"Tên DV","Đơn vị tính","Đơn giá","Loại"};
		dfmodel2=new DefaultTableModel(tieude2,0);
		
		btnDatPhong.addActionListener(this);
		btnTraPhong.addActionListener(this);
		docDSPhong();
		docDSDonDatPhong();
		docDSDichVu();
		

		th.start();
		
	
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		DefaultTableModel model  = (DefaultTableModel) table.getModel();
	/*	try {
			Date date =  new SimpleDateFormat("dd-MM-yyyy").parse((String) model.getValueAt(row, 2).toString());
			txtNgayBD.setValue(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		DefaultTableModel model1  = (DefaultTableModel) table.getModel();
		try {
			Date date =  new SimpleDateFormat("dd-MM-yyyy").parse((String) model1.getValueAt(row, 3).toString());
			dateModel.setValue(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtMaDon.setText(dfmodel.getValueAt(row, 0).toString());
		txtSoPhong.setText(dfmodel.getValueAt(row, 1).toString());
		txtNgayTaoDon.setText(dfmodel.getValueAt(row, 2).toString());
		txtGioBD.setText(dfmodel.getValueAt(row, 4).toString());
		txtTenKH.setText(dfmodel.getValueAt(row, 5).toString());
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
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		for (DonDatPhong dondat : danhSachDonDatPhong) {
			dfmodel.addRow(new Object[] {dondat.getMaDon(), dondat.getPhong().getTenPhong(),dondat.getNgayTaoDon(),dtf.format( dondat.getNgayThue()),dondat.getGioThue()
				,dondat.getKhachhang().getTenKH()
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
			if (phong.isTinhTrang()==false) {
			dfmodel1.addRow(new Object[] {phong.getMaPhong(), phong.getTenPhong(),phong.getLoaiPhong().getTenLoaiPhong(), 
					phong.getDonGia(),phong.isTinhTrang() ? "Đầy" : "Trống"
			});	
			}
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnDatPhong)) {
			String soPhong = txtSoPhong.getText().trim();
			String tenKH = txtTenKH.getText().trim();
			String GioThue = txtGioBD.getText().trim();
			LocalDate ngayThue = LocalDate.of(dateModel.getYear(), dateModel.getMonth() + 1, dateModel.getDay());
		
			
			
			int viTriLoi =0;
			int soLuong = 0;
			if (soPhong.length() == 0) {
				lblTBSoPhong.setText("Mức lương không được để trống!");
				viTriLoi = 1;
			} else {
				try {
					soLuong = Integer.parseInt(soPhong);
					if (soLuong < 0) {
						lblTBSoPhong.setText("Số phòng phải lớn hơn 0!");
						viTriLoi = 1;
					} else {
						lblTBSoPhong.setText("");
					}
				} catch (Exception ex) {
					lblTBSoPhong.setText("Phải nhập số tự nhiên theo phòng!");
					viTriLoi = 1;
				}
			}
			if(dateModel.getValue()==null) {
				lblTBNgayBD.setText("Ngày đặt không được để trống");
				viTriLoi =1;
			} else if (!ngayThue.isAfter(LocalDate.now())) {
				lblTBNgayBD.setText("Ngày đặt không được trước ngày hiện tại");
				viTriLoi=1;
			} else {
				lblTBNgayBD.setText("");
			}
			//LocalTime t = LocalTime.parse(GioThue);
			if (GioThue.length()==0) {
				lblTBNgayBD.setText("giờ thuê không được để trống");
				viTriLoi=1;
			} else if (!ConvertToASCII.convertToASCII(GioThue).matches("[0-9]{2}\\:[0-9]{2}")){
				lblTBGioBD.setText("giờ thuê theo dạng AA:AA với A là số từ 0-9");
				viTriLoi= 1;
			} else {
				lblTBGioBD.setText("");
				
			}
			if(tenKH.length()==0) {
				lblTBTenKH.setText("Phải điền đầy đủ họ tên khách hàng đã đăng ký");
				viTriLoi = 1;
			} else if  (!ConvertToASCII.convertToASCII(tenKH).matches("[a-zA-Z0-9 đĐ]+")) {
				lblTBTenKH.setText("Điền đầy đủ thông tin khách hàng ban đầu đăng kí");
			} else {
				lblTBTenKH.setText("");
			}
			if (viTriLoi==0) {
				String maDon = txtMaDon.getText().trim();
				
				String gioThue = txtGioBD.getText().trim();
				SimpleDateFormat spd = new SimpleDateFormat("hh:mm:ss ");
			/*	Time gio = null;
				try {
					gio = (Time) spd.parse(GioThue);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				LocalTime gioThue = LocalTime.of(gio.getHours(),gio.getMinutes(), gio.getSeconds());
				DecimalFormat dtf  = new DecimalFormat("HH:mm:ss");
				*/
			//	String gioThue = dtf.parse(dateGioThue);
				//String ngayThue = txtNgayBD.getText().trim();
				
				LocalDate ngaythue = LocalDate.of(dateModel.getYear(), dateModel.getMonth() + 1, dateModel.getDay());
				LocalDateTime ngaytaoDon = LocalDateTime.now();
				Timestamp ngaytao = Timestamp.valueOf(ngaytaoDon);
				
				String maDV = null;
				String sophong = txtSoPhong.getText().trim();
				
				String maPhong = daoPhong.getMa(soPhong);
				boolean tinhTrang = daoPhong.getTinhTrang(soPhong);
				Phong phong = new Phong(maPhong,soPhong,tinhTrang);
				
				String tenkh = txtTenKH.getText().trim();
				String maKH = daoKhachHang.getMa(tenKH);
				KhachHang khachhang = new KhachHang(maKH,tenKH);
				
				
				DichVu dichvu = new DichVu(maDV);
				DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
				String tenDon = null;
				//String current = df.format(ngaytaoDon);
				
				DonDatPhong dondatphong = new DonDatPhong(maDon,soPhong,phong,khachhang,GioThue,ngayThue,ngaytao);
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				
					
					
				
			
				
						if (dondatphong.getPhong().isTinhTrang()==true) {
							JOptionPane.showMessageDialog(this, "Phòng này đã có người khác đặt");
						}
						else {
							dfmodel.addRow(new Object[] {
									dondatphong.getMaDon(), dondatphong.getPhong().getTenPhong(), dondatphong.getNgayTaoDon(),dtf.format(dondatphong.getNgayThue())	
									,dondatphong.getGioThue(),dondatphong.getKhachhang().getTenKH()
							});
							daoDonDatPhong.themDonDatPhong(dondatphong);
							txtMaDon.setText(daoDonDatPhong.getMaMoi());
							daoPhong.capNhatPhong("1", maPhong);
							dfmodel1.setRowCount(0);
							try {
								danhSachPhong = daoPhong.layDSPhong();
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							for (Phong Phong : danhSachPhong) {
								if (Phong.isTinhTrang()==false) {
								dfmodel1.addRow(new Object[] {Phong.getMaPhong(), Phong.getTenPhong(),Phong.getLoaiPhong().getTenLoaiPhong(), 
										Phong.getDonGia(),Phong.isTinhTrang() ? "Đầy" : "Trống"
								});	
								}
							}
						}
			}
			

			
		}
		else if (o.equals(btnTraPhong)) {
			frmHoaDon frmHoaDon = new frmHoaDon();
			frmHoaDon.xemThoiGian(danhSachDonDatPhong.get(table.getSelectedRow()));
			frmHoaDon.setVisible(true);
		}
		
			//JOptionPane.showMessageDialog(this, "Thêm thành công!");
		}
}
