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
import DAO.LoaiNhanVien_DAO;
import DAO.NhanVien_DAO;
import Entity.DichVu;
import Entity.LoaiNhanVien;
import Entity.NhanVien;
import Other.ConvertToASCII;
import connect_DB.connectDB;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.Container;

public class QuanLiDichVu extends JFrame implements MouseListener,ActionListener{

	private JPanel panel;
	private JTextField txtMaDV;
	private JTextField txtTenDV;
	private JTextField txtDonViTinh;
	private DefaultTableModel dfmodel;
	private JTable table;
	private JTable table_1;
	private JTextField txtLoai;
	private DichVu_DAO daoDichVu;
	private ArrayList<DichVu> danhSachDichVu;
	private JButton btnXoa;
	private JButton btnThem;
	private JButton btnSua;
	private JTextField txtDonGia;
	private JButton btnThoat;
	private JLabel lblTBMaDV;
	private JLabel lblTBLoai;
	private JLabel lblTenMH;
	private JLabel lblTBDonViTinh;
	private JLabel lblTBDonGia;
	private JLabel lblTBTenMH;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLiDichVu frame = new QuanLiDichVu();
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
	public QuanLiDichVu() throws Exception {
		try {
			connectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		daoDichVu = new DichVu_DAO();
		
		setTitle("Quản lí dịch vụ");
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1480, 895);
		panel = new JPanel();
		panel.setBackground(new Color(240, 255, 255));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel lblMaDV = new JLabel("Mã dịch vụ");
		lblMaDV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMaDV.setBounds(96, 148, 85, 18);
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
		
		
		
		txtDonGia = new JTextField();
		txtDonGia.setColumns(10);
		txtDonGia.setBounds(1303, 144, 133, 21);
		panel.add(txtDonGia);
		
		btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnSua.setBounds(1321, 216, 115, 30);
		panel.add(btnSua);
		
		
		
		String [] tieude= {"Mã Dịch vụ", "Tên mặt hàng","Đơn giá","Đơn vị tính","Loại"};
		dfmodel=new DefaultTableModel(tieude,0);
		table=new JTable(dfmodel);
		
		
		table.addMouseListener(this);
		JScrollPane sc=new JScrollPane(table);
		sc.setBackground(new Color(240, 255, 255));
		sc.setBorder(new TitledBorder(null, "Danh s\u00E1ch d\u1ECBch v\u1EE5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		sc.setBounds(96, 307, 1340, 378);
		getContentPane().add(sc);
		
		JLabel lbl = new JLabel("Đơn giá");
		lbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl.setBounds(1141, 148, 133, 18);
		panel.add(lbl);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnXoa.setBounds(1161, 216, 115, 30);
		panel.add(btnXoa);
		
		btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnThem.setBounds(989, 216, 115, 30);
		panel.add(btnThem);
		
		JLabel lblTitle = new JLabel("Thông Tin Dịch Vụ");
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblTitle.setBounds(695, 34, 289, 38);
		panel.add(lblTitle);
		
		JLabel lblLoai = new JLabel("Loại");
		lblLoai.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLoai.setBounds(96, 220, 85, 18);
		panel.add(lblLoai);
		
		txtLoai = new JTextField();
		txtLoai.setColumns(10);
		txtLoai.setBounds(216, 216, 133, 21);
		panel.add(txtLoai);
		
		btnThoat = new JButton("Thoát");
		
		btnThoat.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnThoat.setBounds(821, 216, 115, 30);
		panel.add(btnThoat);
		
		 lblTBMaDV = new JLabel("");
		lblTBMaDV.setBounds(96, 181, 253, 13);
		panel.add(lblTBMaDV);
		
		 lblTBLoai = new JLabel("");
		lblTBLoai.setBounds(96, 260, 253, 13);
		panel.add(lblTBLoai);
		
		 lblTBTenMH = new JLabel("");
		lblTBTenMH.setBounds(450, 181, 253, 13);
		panel.add(lblTBTenMH);
		
		lblTBDonViTinh = new JLabel("");
		lblTBDonViTinh.setBounds(821, 181, 253, 13);
		panel.add(lblTBDonViTinh);
		
		 lblTBDonGia = new JLabel("");
		lblTBDonGia.setBounds(1141, 181, 295, 13);
		panel.add(lblTBDonGia);
		btnThoat.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		docDSDichVu();
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		txtMaDV.setText(dfmodel.getValueAt(row,0).toString());
		txtTenDV.setText(dfmodel.getValueAt(row,1).toString());
		txtDonGia.setText(dfmodel.getValueAt(row,2).toString());
		txtDonViTinh.setText(dfmodel.getValueAt(row,3).toString());
		txtLoai.setText(dfmodel.getValueAt(row,4).toString());
		
	}

	@Override
	public void mousePressed(MouseEvent e) {		
	}

	@Override
	public void mouseReleased(MouseEvent e) {	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnThem)) {
			String maDV = txtMaDV.getText().trim();
			String tenDV = txtTenDV.getText().trim();
		//	int donGia = Integer.parseInt(txtDonGia.getText().trim());
			String dg = txtDonGia.getText().trim();
			String donViTinh = txtDonViTinh.getText().trim();
			String loai = txtLoai.getText().trim();
			int viTri =0;
			if(maDV.length()==0) {
				lblTBMaDV.setText("Mã dịch vụ không được bỏ trống");
				viTri =1;
			} else if (!ConvertToASCII.convertToASCII(maDV).matches("DV[0-9]")) {
				lblTBMaDV.setText("Mã dịch vụ phải bắt đầu bằng DVx với x là số bất kì  ");
				viTri =1;
			} else {
				lblTBMaDV.setText("");
			} if (donViTinh.length()==0 ) {
				lblTBDonViTinh.setText("Đơn vị tính không được để trống");
				viTri =1;
			} else {
				lblTBDonViTinh.setText("");
			}   if (loai.length()==0 ) {
				lblTBLoai.setText("Loại dịch vụ không được để trống");
				viTri =1;
			} else {
				lblTBLoai.setText("");
			}   if (tenDV.length()==0 ) {
				lblTBTenMH.setText("Tên dịch vụ không được để trống");
				viTri =1;
			} else {
				lblTBTenMH.setText("");
			}  
			int dongia = 0;
			if(dg.length()==0) {
				lblTBDonGia.setText("Đơn giá không được bỏ trống");
				viTri = 1;
			} else  {
				try {
					dongia = Integer.parseInt(dg);
					if(dongia<=0) {
						lblTBDonGia.setText("Đơn giá phải lớn hơn 0");
						viTri = 1;
					} else {
						lblTBDonGia.setText("");
					}
				} catch (Exception ex) {
					lblTBDonGia.setText("Đơn giá không đúng định dạng");
					viTri = 1;
				}	
			}
			if (viTri ==0 ) {
				int donGia = Integer.parseInt(dg);
				DichVu dichvu = new DichVu(maDV,tenDV,donViTinh,donGia,loai);
				daoDichVu.themDichVu(dichvu);
				dfmodel.addRow(new Object[] {dichvu.getMaDV(),dichvu.getTenDV(),dichvu.getDonGia(),dichvu.getDonViTinh(),dichvu.getLoai() 
				});	
				JOptionPane.showMessageDialog(this, "Thêm thành công!");
			}
			
			
				
		}
		else if(o.equals(btnXoa)) {
			if(table.getSelectedRow()==-1)
				JOptionPane.showMessageDialog(this, "Chọn dòng cần xóa");
			else {
				int r=JOptionPane.showConfirmDialog(this,"Bạn muốn xóa dòng này");
				if(r==JOptionPane.YES_OPTION) {
					int row = table.getSelectedRow();
					String maDV = dfmodel.getValueAt(row, 0).toString();
					if (daoDichVu.xoaDichVu(maDV)) {
						dfmodel.removeRow(table.getSelectedRow());
						JOptionPane.showMessageDialog(this, "Xóa thành công.");
					}
					else {
						JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi!");
					}
				}
			}
		}
		else if (o.equals(btnSua)) {
					
			String maDV = txtMaDV.getText().trim();
			String tenDV = txtTenDV.getText().trim();
			//int donGia = Integer.parseInt(txtDonGia.getText().trim());
			String dg = txtDonGia.getText().trim();
			String donViTinh = txtDonViTinh.getText().trim();
			String loai = txtLoai.getText().trim();
			
			
			
			int viTri =0;
			if(maDV.length()==0) {
				lblTBMaDV.setText("Mã dịch vụ không được bỏ trống");
				viTri =1;
			} else if (!ConvertToASCII.convertToASCII(maDV).matches("DV[0-9]")) {
				lblTBMaDV.setText("Mã dịch vụ phải bắt đầu bằng DVx với x là số bất kì ");
				viTri =1;
			} else {
				lblTBMaDV.setText("");
			} if (donViTinh.length()==0 ) {
				lblTBDonViTinh.setText("Đơn vị tính không được để trống");
				viTri =1;
			} else {
				lblTBDonViTinh.setText("");
			}   if (loai.length()==0 ) {
				lblTBLoai.setText("Loại dịch vụ không được để trống");
				viTri =1;
			} else {
				lblTBLoai.setText("");
			}   if (tenDV.length()==0 ) {
				lblTBTenMH.setText("Tên dịch vụ không được để trống");
				viTri =1;
			} else {
				lblTBTenMH.setText("");
			}  
			int dongia = 0;
			if(dg.length()==0) {
				lblTBDonGia.setText("Đơn giá không được bỏ trống");
				viTri = 1;
			} else  {
				try {
					dongia = Integer.parseInt(dg);
					if(dongia<=0) {
						lblTBDonGia.setText("Đơn giá phải lớn hơn 0");
						viTri = 1;
					} else {
						lblTBDonGia.setText("");
					}
				} catch (Exception ex) {
					lblTBDonGia.setText("Đơn giá không đúng định dạng");
					viTri = 1;
				}	
			}
			if (viTri ==0 ) {
				int donGia = Integer.parseInt(dg);
				DichVu dichvu = new DichVu(maDV,tenDV,donViTinh,donGia,loai);
				
				dichvu.setTenDV(tenDV);
				dichvu.setLoai(loai);
				dichvu.setDonGia(donGia);
				dichvu.setDonViTinh(donViTinh);
				
				
				daoDichVu.suaDichVu(dichvu);
				dfmodel.setRowCount(0);
			
				try {
					danhSachDichVu = daoDichVu.layDSDichVu();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for (DichVu dichVu : danhSachDichVu) {
					dfmodel.addRow(new Object[] {dichVu.getMaDV(),dichVu.getTenDV(),dichVu.getDonGia(),dichVu.getDonViTinh(),dichVu.getLoai() 
							});	
				}
				JOptionPane.showMessageDialog(this, "Sửa thành công!");
			}
			
		}
		else if (o.equals(btnThoat)) {
			dispose();
		}
	}
	private void docDSDichVu() throws Exception {
		danhSachDichVu = daoDichVu.layDSDichVu();
		for (DichVu dichVu : danhSachDichVu) {
			dfmodel.addRow(new Object[] {dichVu.getMaDV(),dichVu.getTenDV(),dichVu.getDonGia(),dichVu.getDonViTinh(),dichVu.getLoai() 
					});	
		}
	}
}
