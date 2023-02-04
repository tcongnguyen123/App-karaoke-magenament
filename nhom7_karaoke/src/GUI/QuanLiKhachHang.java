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
import DAO.LoaiNhanVien_DAO;
import DAO.NhanVien_DAO;
import Entity.KhachHang;
import Entity.LoaiNhanVien;
import Entity.NhanVien;
import Other.ConvertToASCII;
import connect_DB.connectDB;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JRadioButton;

public class QuanLiKhachHang extends JFrame implements MouseListener,ActionListener{

	private JPanel panel;
	private JTextField txtMaKH;
	private JTextField txtHoTen;
	private JTextField txtCCCD;
	private JTextField txtEmail;
	private JTextField txtSDT;
	private DefaultTableModel dfmodel;
	private JTable table;
	private JTable table_1;
	private KhachHang_DAO daoKhachHang;
	private ArrayList<KhachHang> danhSachKhachHang;
	private JButton btnXoaRong;
	private JButton btnXoa;
	private JButton btnThem;
	private JButton btnSua;
	private JRadioButton radNam;
	private JRadioButton radNu;
	private ButtonGroup bg;
	private JTextField txtTuoi;
	private JLabel lblTBHoTen;
	private JLabel lblTBCCCD;
	private JLabel lblTBEmail;
	private JLabel lblTBSDT;
	private JLabel lblTBTuoi;
	private JLabel lblTBMaKH;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLiKhachHang frame = new QuanLiKhachHang();
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
	public QuanLiKhachHang() throws Exception {
		try {
			connectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		daoKhachHang = new KhachHang_DAO();
		
		setTitle("Quản lí Khách hàng");
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1480, 895);
		panel = new JPanel();
		panel.setBackground(new Color(240, 255, 255));
		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel lblMaKH = new JLabel("Mã Khách Hàng");
		lblMaKH.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMaKH.setBounds(96, 148, 110, 17);
		panel.add(lblMaKH);
		
		JLabel lblHoTen = new JLabel("H\u1ECD t\u00EAn");
		lblHoTen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHoTen.setBounds(95, 217, 85, 13);
		panel.add(lblHoTen);
		
		txtMaKH = new JTextField();
		txtMaKH.setEditable(true);
		txtMaKH.setBounds(216, 144, 133, 21);
		panel.add(txtMaKH);
		txtMaKH.setColumns(10);
		
		txtHoTen = new JTextField();
		txtHoTen.setBounds(217, 214, 132, 21);
		panel.add(txtHoTen);
		txtHoTen.setColumns(10);
		
		JLabel lblCMND = new JLabel("Căn cước");
		lblCMND.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCMND.setBounds(450, 148, 85, 18);
		panel.add(lblCMND);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setBounds(449, 217, 85, 13);
		panel.add(lblEmail);
		
		txtCCCD = new JTextField();
		txtCCCD.setColumns(10);
		txtCCCD.setBounds(570, 144, 133, 21);
		panel.add(txtCCCD);
		
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
		
		JLabel lblTuoi = new JLabel("Tuổi");
		lblTuoi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTuoi.setBounds(1177, 148, 102, 18);
		panel.add(lblTuoi);
		
		txtTuoi = new JTextField();
		txtTuoi.setColumns(10);
		txtTuoi.setBounds(1303, 144, 133, 21);
		panel.add(txtTuoi);
		
		btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnSua.setBounds(1303, 302, 115, 30);
		panel.add(btnSua);
		
		
		
		String [] tieude= {"Mã KH","Họ tên","Số điện thoại","Giới tính","Căn cước","Email","Tuổi"};
		dfmodel=new DefaultTableModel(tieude,0);
		table=new JTable(dfmodel);
		
		
		table.addMouseListener(this);
		JScrollPane sc=new JScrollPane(table);
		sc.setBackground(new Color(240, 255, 255));
		sc.setBorder(new TitledBorder(null, "Danh sách khách hàng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		sc.setBounds(96, 383, 1340, 378);
		getContentPane().add(sc);
		
		 btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnXoa.setBounds(1145, 302, 115, 30);
		panel.add(btnXoa);
		
		 btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnThem.setBounds(974, 302, 115, 30);
		panel.add(btnThem);
		
		radNam = new JRadioButton("Nam");
		radNam.setBackground(new Color(240, 255, 255));
		radNam.setBounds(941, 214, 103, 21);
		panel.add(radNam);
		radNam.setSelected(true);
		
		radNu = new JRadioButton("Nữ");
		radNu.setBackground(new Color(240, 255, 255));
		radNu.setBounds(1084, 214, 103, 21);
		panel.add(radNu);
		
		bg = new ButtonGroup();
		bg.add(radNam);
		bg.add(radNu);
		
		JLabel lblTitle = new JLabel("Thông Tin Khách Hàng");
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblTitle.setBounds(665, 50, 432, 43);
		panel.add(lblTitle);
		
		btnXoaRong = new JButton("Xóa rỗng");
		btnXoaRong.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnXoaRong.setBounds(807, 302, 115, 30);
		panel.add(btnXoaRong);
		
		lblTBHoTen = new JLabel("");
		lblTBHoTen.setBounds(96, 268, 253, 13);
		panel.add(lblTBHoTen);
		
		lblTBCCCD = new JLabel("");
		lblTBCCCD.setBounds(450, 191, 253, 13);
		panel.add(lblTBCCCD);
		
		lblTBEmail = new JLabel("");
		lblTBEmail.setBounds(450, 268, 253, 13);
		panel.add(lblTBEmail);
		
		lblTBSDT = new JLabel("");
		lblTBSDT.setBounds(821, 191, 253, 13);
		panel.add(lblTBSDT);
		
		lblTBTuoi = new JLabel("");
		lblTBTuoi.setBounds(1183, 195, 253, 13);
		panel.add(lblTBTuoi);
		
		lblTBMaKH = new JLabel("");
		lblTBMaKH.setBounds(96, 191, 253, 13);
		panel.add(lblTBMaKH);
		btnXoaRong.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		docDSKhachHang();
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtMaKH.setText(dfmodel.getValueAt(row,0).toString());
		txtHoTen.setText(dfmodel.getValueAt(row,1).toString());
		txtSDT.setText(dfmodel.getValueAt(row,2).toString());
		
		String gioiTinh = dfmodel.getValueAt(row,3).toString();
			if(gioiTinh.equals("Nam")) {
				radNam.setSelected(true);
			}
			else {
				radNu.setSelected(true);
			}
		txtCCCD.setText(dfmodel.getValueAt(row, 4).toString());
		txtEmail.setText(dfmodel.getValueAt(row,5).toString());
		txtTuoi.setText(dfmodel.getValueAt(row,6).toString());
		
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
	private void docDSKhachHang() throws Exception {
		danhSachKhachHang = daoKhachHang.layDSKhachHang();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		for (KhachHang khachHang : danhSachKhachHang) {
			dfmodel.addRow(new Object[] {khachHang.getMaKH(), khachHang.getTenKH(),khachHang.getSdt(), khachHang.isGioiTinh() ? "Nam" : "Nữ",khachHang.getCccd(),khachHang.getEmail(),khachHang.getTuoi() });	
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnXoaRong)) {
			txtMaKH.setText("");
			txtHoTen.setText("");
	//		dateModel.setValue(null);
			txtSDT.setText("");
			txtEmail.setText("");
			radNam.setSelected(false);
			radNu.setSelected(false);
			txtCCCD.setText("");
			txtTuoi.setText("");
			txtHoTen.requestFocus();
		}
		else if(o.equals(btnXoa)) {
			if(table.getSelectedRow()==-1)
				JOptionPane.showMessageDialog(this, "Chọn dòng cần xóa");
			else {
				int r=JOptionPane.showConfirmDialog(this,"Bạn muốn xóa dòng này");
				if(r==JOptionPane.YES_OPTION) {
					int row = table.getSelectedRow();
					String maKH = dfmodel.getValueAt(row, 0).toString();
					if (daoKhachHang.xoaKhachHang(maKH)) {
						dfmodel.removeRow(table.getSelectedRow());
						JOptionPane.showMessageDialog(this, "Xóa thành công.");
					}
					else {
						JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi!");
					}
				}
			}
				
		}
		else if (o.equals(btnThem)) {
			String maKH = txtMaKH.getText().trim();
			String hoTen = txtHoTen.getText().trim();
			String  tuoi = txtTuoi.getText().trim();
			String soDienThoai = txtSDT.getText().trim();
			boolean gioiTinh = radNam.isSelected();
			String email = txtEmail.getText().trim();
			String cccd = txtCCCD.getText().trim();
			
			int viTriLoi =0;
			if (maKH.length()==0) {
				lblTBMaKH.setText("Mã khách hàng không được để trống");
				viTriLoi =1;
			} else if (!ConvertToASCII.convertToASCII(maKH).matches("[K]{1}[0-9]{3}")) {
				lblTBMaKH.setText("Kí tự bắt đầu là N và có 3 kí tự sau là số");
				viTriLoi = 1;
			} else {
				lblTBMaKH.setText("");
			}
			if(soDienThoai.length()==0) {
				lblTBSDT.setText("Số điện thoại không được để trống!");
				viTriLoi = 1;
			} else if (soDienThoai.length() > 10) {
				lblTBSDT.setText("Số điện thoại tối đa 10 ký tự!");
				viTriLoi = 1;
			} else if (!ConvertToASCII.convertToASCII(soDienThoai).matches("0[0-9]{9}")) {
				lblTBSDT.setText("Số điện thoại không hợp lệ");
				viTriLoi = 1;
			} else {
				lblTBSDT.setText("");
			}

			if (email.length() == 0) {
				lblTBEmail.setText("Email không được để trống!");
				viTriLoi = 1;
			} else if (email.length() > 30) {
				lblTBEmail.setText("Email tối đa 30 ký tự!");
				viTriLoi = 1;
			} else if (!ConvertToASCII.convertToASCII(email).matches("[a-z0-9][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}")) {
				lblTBEmail.setText("Email không hợp lệ!");
				viTriLoi = 1;
			} else {
				lblTBEmail.setText("");
			}	
			if (hoTen.length() == 0) {
				lblTBHoTen.setText("Tên khách hàng không được để trống!");
				viTriLoi = 1;
			} else if (hoTen.length() > 40) {
				lblTBHoTen.setText("Tên khách hàng tối đa 40 ký tự!");
				viTriLoi = 1;
			} else if (!ConvertToASCII.convertToASCII(hoTen).matches("[a-zA-Z đĐ]+")) {
				lblTBHoTen.setText("Tên khách hàng chỉ bao gồm ký tự và khoảng trắng!");
				viTriLoi = 1;
			} else {
				lblTBHoTen.setText("");
			}
			int tuoiInt =0;
			if(tuoi.length()==0) {
				lblTBTuoi.setText("Tuổi không được để trống!");
				viTriLoi = 1;
			} else  {
				try {
					tuoiInt = Integer.parseInt(tuoi);
					if(tuoiInt<18) {
						lblTBTuoi.setText("Tuổi phải trên 18 tuổi");
						viTriLoi = 1;
					} else {
						lblTBTuoi.setText("");
					}
				} catch (Exception ex) {
					lblTBTuoi.setText("Tuổi không đúng định dạng!");
					viTriLoi = 1;
				}	
			}
			if (cccd.length() == 0) {
				lblTBCCCD.setText("Căn cước không được để trống!");
				viTriLoi = 1;
			} else if (!ConvertToASCII.convertToASCII(cccd).matches("[0-9]{9}|[0-9]{12}")) {
				lblTBCCCD.setText("Căn cước phải 9 số hoặc 12 số");
				viTriLoi = 1;
			} else {
				lblTBCCCD.setText("");
			}
			
			
			if (viTriLoi ==0) {
				
				
				KhachHang objKhachHang = new KhachHang(maKH, hoTen,  soDienThoai, gioiTinh,cccd, email,tuoi);
				daoKhachHang.themKhachHang(objKhachHang);
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				dfmodel.addRow(new Object[] {
					objKhachHang.getMaKH(),objKhachHang.getTenKH(),objKhachHang.getSdt(),objKhachHang.isGioiTinh() ? "Nam" : "Nữ"	,objKhachHang.getCccd(),objKhachHang.getEmail(),objKhachHang.getTuoi()	
				});
				JOptionPane.showMessageDialog(this, "Thêm thành công!");
		
			}
		
		} else if (o.equals(btnSua)) {
			
			String maKH = txtMaKH.getText().trim();
			String hoTen = txtHoTen.getText().trim();
			String  tuoi = txtTuoi.getText().trim();
			String soDienThoai = txtSDT.getText().trim();
			boolean gioiTinh = radNam.isSelected();
			String email = txtEmail.getText().trim();
			String cccd = txtCCCD.getText().trim();
			int viTriLoi =0;
			if (maKH.length()==0) {
				lblTBMaKH.setText("Mã khách hàng không được để trống");
				viTriLoi =1;
			} else if (!ConvertToASCII.convertToASCII(maKH).matches("[K]{1}[0-9]{3}")) {
				lblTBMaKH.setText("Kí tự bắt đầu là N và có 3 kí tự sau là số");
				viTriLoi = 1;
			} else {
				lblTBMaKH.setText("");
			}
			if(soDienThoai.length()==0) {
				lblTBSDT.setText("Số điện thoại không được để trống!");
				viTriLoi = 1;
			} else if (soDienThoai.length() > 10) {
				lblTBSDT.setText("Số điện thoại tối đa 10 ký tự!");
				viTriLoi = 1;
			} else if (!ConvertToASCII.convertToASCII(soDienThoai).matches("0[0-9]{9}")) {
				lblTBSDT.setText("Số điện thoại không hợp lệ");
				viTriLoi = 1;
			} else {
				lblTBSDT.setText("");
			}

			if (email.length() == 0) {
				lblTBEmail.setText("Email không được để trống!");
				viTriLoi = 1;
			} else if (email.length() > 30) {
				lblTBEmail.setText("Email tối đa 30 ký tự!");
				viTriLoi = 1;
			} else if (!ConvertToASCII.convertToASCII(email).matches("[a-z0-9][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}")) {
				lblTBEmail.setText("Email không hợp lệ!");
				viTriLoi = 1;
			} else {
				lblTBEmail.setText("");
			}	
			if (hoTen.length() == 0) {
				lblTBHoTen.setText("Tên khách hàng không được để trống!");
				viTriLoi = 1;
			} else if (hoTen.length() > 40) {
				lblTBHoTen.setText("Tên khách hàng tối đa 40 ký tự!");
				viTriLoi = 1;
			} else if (!ConvertToASCII.convertToASCII(hoTen).matches("[a-zA-Z đĐ]+")) {
				lblTBHoTen.setText("Tên khách hàng chỉ bao gồm ký tự và khoảng trắng!");
				viTriLoi = 1;
			} else {
				lblTBHoTen.setText("");
			}
			int tuoiInt =0;
			if(tuoi.length()==0) {
				lblTBTuoi.setText("Tuổi không được để trống!");
				viTriLoi = 1;
			} else  {
				try {
					tuoiInt = Integer.parseInt(tuoi);
					if(tuoiInt<18) {
						lblTBTuoi.setText("Tuổi phải trên 18 tuổi");
						viTriLoi = 1;
					} else {
						lblTBTuoi.setText("");
					}
				} catch (Exception ex) {
					lblTBTuoi.setText("Tuổi không đúng định dạng!");
					viTriLoi = 1;
				}	
			}
			if (cccd.length() == 0) {
				lblTBCCCD.setText("Căn cước không được để trống!");
				viTriLoi = 1;
			} else if (!ConvertToASCII.convertToASCII(cccd).matches("[0-9]{9}|[0-9]{12}")) {
				lblTBCCCD.setText("Căn cước phải 9 số hoặc 12 số");
				viTriLoi = 1;
			} else {
				lblTBCCCD.setText("");
			}
			
			
			if (viTriLoi ==0) {
				KhachHang khachhang = new KhachHang(maKH, hoTen,  soDienThoai, gioiTinh,cccd, email,tuoi);
				
				
				khachhang.setTenKH(hoTen);
				khachhang.setSdt(soDienThoai);
				khachhang.setGioiTinh(gioiTinh);
				khachhang.setCccd(cccd);
				khachhang.setEmail(email);
				khachhang.setTuoi(tuoi);
				
				daoKhachHang.suaKhachHang(khachhang);
				dfmodel.setRowCount(0);
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
				try {
					danhSachKhachHang = daoKhachHang.layDSKhachHang();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for (KhachHang khachhang1 : danhSachKhachHang) {
					dfmodel.addRow(new Object[] {
							khachhang1.getMaKH(),khachhang1.getTenKH(),khachhang1.getSdt(),khachhang1.isGioiTinh() ? "Nam" : "Nữ"	,khachhang1.getCccd(),khachhang1.getEmail(),khachhang1.getTuoi()	
						});
				}
				JOptionPane.showMessageDialog(this, "Sửa thành công!");
			}
			
			
			
		}
	}
	
}
