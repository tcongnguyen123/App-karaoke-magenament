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

import DAO.CT_HoaDon_DAO;
import DAO.DichVu_DAO;
import DAO.DonDatDV_DAO;
import DAO.DonDatPhong_DAO;
import DAO.KhachHang_DAO;
import DAO.LoaiPhong_DAO;
import DAO.NhanVien_DAO;
import DAO.Phong_DAO;
import Entity.CT_DatDV;
import Entity.CT_HoaDon;
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
import java.awt.event.MouseAdapter;
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
import javax.swing.border.EtchedBorder;

public class frmDatDichVu extends JFrame implements ActionListener,MouseListener{

	private JPanel panel;
	private JTextField txtSoLuong;
	private JTextField txtSDT;
	private DefaultTableModel dfmodel;
	private JTable table;
	private JTable table_1;
	private DonDatPhong_DAO daoDonDatPhong;
	private ArrayList<DonDatPhong> danhSachDonDatPhong;
	private JTextField textField_1;
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
	private ArrayList<DichVu> dsDichVu;
	private DonDatDV_DAO daoDonDatDV;
	private ArrayList<CT_DatDV> danhSachDonDatDV;
	private CT_HoaDon_DAO daoCT_HoaDon;
	private JButton btnThoat;
	private JTable table2;
	private ArrayList<DonDatPhong> danhSachDon;
	private DefaultTableModel dfmodel3;
	private JTable table3;
	private JButton btnHuy;

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
		daoCT_HoaDon = new CT_HoaDon_DAO();
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
		lblSoLuong.setBounds(635, 318, 110, 18);
		panel.add(lblSoLuong);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(710, 318, 133, 21);
		panel.add(txtSoLuong);
	
		
	/*	txtTrangThai = new JTextField();
		txtTrangThai.setColumns(10);
		txtTrangThai.setBounds(941, 144, 133, 21);
		panel.add(txtTrangThai);*/
		
		btnThemDV = new JButton("Thêm DV");
		btnThemDV.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnThemDV.setBounds(939, 689, 115, 30);
		panel.add(btnThemDV);
		
		
		
		String [] tieude= {"Tên DV","Số lượng","Mã Đơn","Số phòng","Thành tiền"};
		dfmodel=new DefaultTableModel(tieude,0);
		table=new JTable(dfmodel);
		
		
	//	table.addMouseListener(this);
		JScrollPane sc=new JScrollPane(table);
		sc.setBackground(new Color(240, 255, 255));
		sc.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch d\u1ECBch v\u1EE5 theo ph\u00F2ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		sc.setBounds(96, 524, 529, 254);
		getContentPane().add(sc);
		
		JLabel lblTitle = new JLabel("Thông tin đặt dịch vụ");
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblTitle.setBounds(658, 56, 345, 30);
		panel.add(lblTitle);
		
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
		JLabel lblClock = new JLabel("New label");
		lblClock.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblClock.setBounds(450, 65, 98, 21);
		lblClock.hide();
		panel.add(lblClock);
		
		clockThread th = new clockThread(lblClock);
		
		
		
		String [] tieude1= {"Tên DV","Đơn giá","Đơn vị tính","Loại"};
		dfmodel1=new DefaultTableModel(tieude1,0);
		table1=new JTable(dfmodel1);
		
		
		
		//table1.addMouseListener(this);
		JScrollPane sc1=new JScrollPane(table1);
		sc1.setBackground(new Color(240, 255, 255));
		sc1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch c\u00E1c d\u1ECBch v\u1EE5", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		sc1.setBounds(96, 204, 529, 289);
		getContentPane().add(sc1);
		danhSachPhongTrongDon = daoDonDatPhong.layDSDonDatPhong();
		
	
		
		btnThoat = new JButton("Thoát");
		btnThoat.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnThoat.setBounds(1266, 689, 115, 30);
		panel.add(btnThoat);
		
	
		
		
		String [] tieude2= {"Mã hóa đơn","Mã Phòng","Tên phòng"};
		dfmodel3=new DefaultTableModel(tieude2,0);
		table3=new JTable(dfmodel3);
		
		
		
		//table1.addMouseListener(this);
		JScrollPane sc2=new JScrollPane(table3);
		sc2.setBackground(new Color(240, 255, 255));
		sc2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch c\u00E1c ph\u00F2ng \u0111ang d\u00F9ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		sc2.setBounds(907, 204, 464, 289);
		getContentPane().add(sc2);
		
		btnHuy = new JButton("Hủy DV");
		btnHuy.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnHuy.setBounds(1111, 689, 115, 30);
		panel.add(btnHuy);
		
		btnHuy.addActionListener(this);
		btnThoat.addActionListener(this);
		btnThemDV.addActionListener(this);
		
		docDSPhongDangSuDung();
		docDSDichVu();

		table3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					datDuLieu();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		

		th.start();
		
	
	}


	private void docDSDonDatDV() throws Exception {
		int row = table3.getSelectedRow();
		String madon = (String) dfmodel3.getValueAt(row, 0);
		danhSachDonDatDV = daoDonDatDV.layDSDonDatDV(madon);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		for (CT_DatDV dondat : danhSachDonDatDV) {
			String maPhong = dondat.getDondatPhong().getPhong().getMaPhong();
			String tenPhong = daoDonDatDV.getMa(maPhong); 
			dfmodel.addRow(new Object[] { dondat.getDichvu().getMaDV(),dondat.getSoLuong(),dondat.getDondatPhong().getMaDon(),tenPhong
				,dondat.getThanhTienDichVu()
			});	
		}
		
	}
	private void docDSPhongDangSuDung() throws Exception {
		danhSachDon = daoDonDatPhong.layDSDonDatPhong();
		for (DonDatPhong dondat : danhSachDon) {
			if(dondat.getTinhTrangThanhToan().equals("Đang chờ thanh toán")) {
				dfmodel3.addRow(new Object[] {
						dondat.getMaDon(),dondat.getPhong().getMaPhong(),dondat.getPhong().getTenPhong()
				});
			}
		}
	}
/*	private void docDSDonDatDVtheophong(String maP) throws Exception {
		//String maP1 = (String) cboSoPhong.getSelectedItem();
		danhSachDonDatDV = daoDonDatDV.docDSDVtheoPhong(maP);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		for (CT_DatDV dondat : danhSachDonDatDV) {
			String maPhong = dondat.getDondatPhong().getPhong().getMaPhong();
			String tenPhong = daoDonDatDV.getMa(maPhong); 
			dfmodel.addRow(new Object[] { dondat.getDichvu().getMaDV(),dondat.getSoLuong(),dondat.getDondatPhong().getMaDon(),tenPhong
				,dondat.getThanhTienDichVu()
			});	
		}*/
		
	//}
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
			try {
				int soLuong = Integer.parseInt(txtSoLuong.getText());
				int row1 = table1.getSelectedRow();
				int row3= table3.getSelectedRow();
				
				
				
				String obMaDon = dfmodel3.getValueAt(row3,0).toString();
				String tenDV = dfmodel1.getValueAt(row1, 0).toString();
				String dongia = dfmodel1.getValueAt(row1, 1).toString();
				int donGia = Integer.parseInt(dongia);
				String maDV = daoDichVu.timDichVu22(tenDV);
				DichVu dv = new DichVu(maDV,tenDV,donGia);
				double thanhtien = tinhTien(soLuong, donGia);
				//Phong obTenPhong =danhSachPhongTrongDon.get(cboSoPhong.getSelectedIndex()-1) ;
				DonDatPhong obdondatphong = new DonDatPhong(obMaDon);
				CT_DatDV dondat = new CT_DatDV(obdondatphong,soLuong,dv,thanhtien);
				try {
					daoDonDatDV.themDonDatDV(dondat);
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(this, "Chưa nhập số lượng");
				}
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "Chưa nhập số lượng");
			}
			
			
			
			dfmodel.setRowCount(0);
			try {
				docDSDonDatDV();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				
				e1.printStackTrace();
			}
				
			
		}
		else if (o.equals(btnThoat)) {
			dispose();
		} 
		else if (o.equals(btnHuy)) {
			if(table.getSelectedRow()==-1)
				JOptionPane.showMessageDialog(this, "Chọn dòng cần hủy");
			else {
				int r=JOptionPane.showConfirmDialog(this,"Bạn muốn xóa hủy dịch vụ này");
				if(r==JOptionPane.YES_OPTION) {
					int row = table.getSelectedRow();
					String tenDV = dfmodel.getValueAt(row, 0).toString();
					String maDV = daoDichVu.timDichVu22(tenDV);
					
					if (daoDonDatDV.xoaDichVu(maDV)) {
						dfmodel.removeRow(table.getSelectedRow());
						JOptionPane.showMessageDialog(this, "Xóa thành công.");
					}
					else {
					
						JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi");
						
					}
				}
			}
		}
	}

		private double tinhTien(int soLuong, int donGia) {
			double thanhTien = 0;
			thanhTien = soLuong * donGia;
			return thanhTien;
		}
		public void datDuLieu() throws Exception {
			int row = table3.getSelectedRow();
			if(row!= -1) {
				dfmodel.setRowCount(0);
				docDSDonDatDV();
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
