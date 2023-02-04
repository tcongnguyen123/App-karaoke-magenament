package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.LoaiNhanVien_DAO;
import DAO.LoaiPhong_DAO;
import DAO.NhanVien_DAO;
import DAO.Phong_DAO;
import Entity.LoaiNhanVien;
import Entity.LoaiPhong;
import Entity.NhanVien;
import Entity.Phong;
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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JRadioButton;

public class QuanLiPhong extends JFrame implements MouseListener,ActionListener{

	private JPanel panel;
	private JTextField txtMaPhong;
	private JTextField txtTenLoaiPhong;
	private DefaultTableModel dfmodel;
	private JTable table;
	private JTable table_1;
	private JTextField txtMieuTa;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnXoaRong;
	private JTextField txtDonGia;
	private JLabel lblTenPhong;
	private JTextField txtTenPhong;
	private Phong_DAO daoPhong;
	private LoaiPhong_DAO daoLoaiPhong;
	private ArrayList<LoaiPhong> danhSachLoaiPhong;
	private JComboBox<String> cboLoaiPhong;
	private ArrayList<Phong> danhSachPhong;
	private JButton btnThem;
	private JLabel lblTBMaPhong;
	private JLabel lblTBTenPhong;
	private JLabel lblTBDonGia;
	private JLabel lblTBMieuTa;
	private JLabel lblNewLabel;
	private ButtonGroup bg;
	private JLabel lblTinhTrang;
	private JTextField txtTinhTrang;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLiPhong frame = new QuanLiPhong();
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
	public QuanLiPhong() throws Exception {
		try {
			connectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		daoPhong = new Phong_DAO();
		daoLoaiPhong = new LoaiPhong_DAO();
		
		setTitle("Quản lí phòng");
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1480, 895);
		panel = new JPanel();
		panel.setBackground(new Color(240, 255, 255));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel lblMaPhong = new JLabel("Mã phòng");
		lblMaPhong.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMaPhong.setBounds(96, 149, 85, 18);
		panel.add(lblMaPhong);
		
		txtMaPhong = new JTextField();
		txtMaPhong.setBounds(216, 144, 133, 21);
		panel.add(txtMaPhong);
		txtMaPhong.setColumns(10);
		
		JLabel lblTenLoaiPhong = new JLabel("Tên Loại Phòng");
		lblTenLoaiPhong.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTenLoaiPhong.setBounds(450, 148, 110, 18);
		panel.add(lblTenLoaiPhong);
		
		/*txtTenLoaiPhong = new JTextField();
		txtTenLoaiPhong.setColumns(10);
		txtTenLoaiPhong.setBounds(570, 144, 133, 21);
		panel.add(txtTenLoaiPhong);*/
		cboLoaiPhong = new JComboBox<String>();
		cboLoaiPhong.setBounds(570, 144, 133, 21);
		panel.add(cboLoaiPhong);

		danhSachLoaiPhong = daoLoaiPhong.layDSLoai();

		cboLoaiPhong.addItem("Chọn Phòng");
		for (LoaiPhong loai : danhSachLoaiPhong) {
			cboLoaiPhong.addItem(loai.getTenLoaiPhong());
		}
		
		
		txtDonGia = new JTextField();
		txtDonGia.setColumns(10);
		txtDonGia.setBounds(989, 148, 133, 21);
		panel.add(txtDonGia);
		
		btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnSua.setBounds(1321, 216, 115, 30);
		panel.add(btnSua);
		
		
		
		String [] tieude= {"Mã Phòng","Tên phòng", "Tên loại phòng","Đơn giá/ giờ","Miêu tả","Tình trạng"};
		dfmodel=new DefaultTableModel(tieude,0);
		table=new JTable(dfmodel);
		
		
		table.addMouseListener(this);
		JScrollPane sc=new JScrollPane(table);
		sc.setBackground(new Color(240, 255, 255));
		sc.setBorder(new TitledBorder(null, "Danh sách phòng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		sc.setBounds(96, 307, 1340, 378);
		getContentPane().add(sc);
		
		
		
		
		
		JLabel lblDonGia = new JLabel("Đơn giá");
		lblDonGia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDonGia.setBounds(860, 144, 133, 18);
		panel.add(lblDonGia);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnXoa.setBounds(1161, 216, 115, 30);
		panel.add(btnXoa);
		
		btnXoaRong = new JButton("Xóa rỗng");
		btnXoaRong.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnXoaRong.setBounds(989, 216, 115, 30);
		panel.add(btnXoaRong);
		
		JLabel lblTitle = new JLabel("Thông Tin Phòng");
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblTitle.setBounds(695, 34, 289, 38);
		panel.add(lblTitle);
		
		JLabel lblMieuTa = new JLabel("Miêu tả");
		lblMieuTa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMieuTa.setBounds(1183, 148, 110, 18);
		panel.add(lblMieuTa);
		
		txtMieuTa = new JTextField();
		txtMieuTa.setColumns(10);
		txtMieuTa.setBounds(1303, 144, 133, 21);
		panel.add(txtMieuTa);
		
		btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnThem.setBounds(821, 216, 115, 30);
		panel.add(btnThem);
		
		lblTenPhong = new JLabel("Tên phòng");
		lblTenPhong.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTenPhong.setBounds(96, 210, 85, 18);
		panel.add(lblTenPhong);
		
		txtTenPhong = new JTextField();
		txtTenPhong.setColumns(10);
		txtTenPhong.setBounds(216, 205, 133, 21);
		panel.add(txtTenPhong);
		
		lblTBMaPhong = new JLabel("");
		lblTBMaPhong.setBounds(96, 187, 253, 13);
		panel.add(lblTBMaPhong);
		
		lblTBTenPhong = new JLabel("");
		lblTBTenPhong.setBounds(96, 249, 253, 13);
		panel.add(lblTBTenPhong);
		
		lblTBDonGia = new JLabel("");
		lblTBDonGia.setBounds(860, 187, 262, 13);
		panel.add(lblTBDonGia);
		
		lblTBMieuTa = new JLabel("");
		lblTBMieuTa.setBounds(1183, 193, 253, 13);
		panel.add(lblTBMieuTa);
		
		lblTinhTrang = new JLabel("Tình trạng ");
		lblTinhTrang.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTinhTrang.setBounds(450, 214, 96, 13);
		panel.add(lblTinhTrang);
		
		txtTinhTrang = new JTextField();
		txtTinhTrang.setColumns(10);
		txtTinhTrang.setBounds(570, 207, 133, 21);
		panel.add(txtTinhTrang);
		
		bg = new ButtonGroup();
		
		
		btnXoaRong.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnThem.addActionListener(this);
		
		docDSPhong();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		txtMaPhong.setText(dfmodel.getValueAt(row,0).toString());
		txtTenPhong.setText(dfmodel.getValueAt(row,1).toString());
		cboLoaiPhong.setSelectedItem(dfmodel.getValueAt(row,2).toString());
		txtDonGia.setText(dfmodel.getValueAt(row,3).toString());
		txtMieuTa.setText(dfmodel.getValueAt(row,4).toString());
		 txtTinhTrang .setText(dfmodel.getValueAt(row,5).toString());
		
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
		if(o.equals(btnXoaRong)) {
			txtMaPhong.setText("");
			txtTenPhong.setText("");
			txtDonGia.setText("");
			txtMieuTa.setText("");
			txtTinhTrang.setText("");
			cboLoaiPhong.setSelectedIndex(0);
			
		}
		else if (o.equals(btnThem)) {
			String maPhong = txtMaPhong.getText().trim();
			String tenPhong = txtTenPhong.getText().trim();
			String donGia = txtDonGia.getText().trim();
			String mieuTa = txtMieuTa.getText().trim();
			String tinhTrang = txtTinhTrang.getText().trim();
			int viTriLoi = 0;
			if (maPhong.length()==0) {
				lblTBMaPhong.setText("Mã phòng không được để trống");
				viTriLoi=1;
			} else if (!ConvertToASCII.convertToASCII(maPhong).matches("[P]{1}[0-9]{2}")) {
				lblTBMaPhong.setText("3 kí tự ,Kí tự bắt đầu là P và có 2 số cuối");
				viTriLoi=1;
			} else {
				lblTBMaPhong.setText("");
			}
			if (tenPhong.length()==0) {
				lblTBTenPhong.setText("Tên phòng không được để trống");
				viTriLoi=1;
			} else if (!ConvertToASCII.convertToASCII(tenPhong).matches("[1-9]{1}|[1-9]{1}[0-9]")) {
				lblTBTenPhong.setText("Tên phòng là số");
				viTriLoi=1;
			} else {
				lblTBTenPhong.setText("");
			}
			int donGiaInt =0;
			if(donGia.length()==0) {
				lblTBDonGia.setText("Đơn giá không được để trống!");
				viTriLoi = 1;
			} else  {
				try {
					donGiaInt = Integer.parseInt(donGia);
					if(donGiaInt<=0) {
						lblTBDonGia.setText("Đơn giá phải lớn hơn 0");
						viTriLoi = 1;
					} else {
						lblTBDonGia.setText("");
					}
				} catch (Exception ex) {
					lblTBDonGia.setText("Đơn giá không đúng định dạng!");
					viTriLoi = 1;
				}	
			}
			if (mieuTa.length()==0) {
				lblTBMieuTa.setText("Tên phòng không được để trống");
				viTriLoi=1;
			}  else {
				lblTBMieuTa.setText("");
			}
			if (viTriLoi== 0) {
				int dongia = Integer.parseInt(txtDonGia.getText().trim()); 
				LoaiPhong loai = danhSachLoaiPhong.get(cboLoaiPhong.getSelectedIndex()-1);
				Phong phong = new Phong (maPhong,tenPhong,mieuTa,dongia,loai,tinhTrang);
				daoPhong.themPhong(phong);
				dfmodel.addRow(new Object[] {phong.getMaPhong(), phong.getTenPhong(),phong.getLoaiPhong().getTenLoaiPhong(), 
						phong.getDonGia(),phong.getMieuTa(),phong.getTinhTrang()
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
					String maP = dfmodel.getValueAt(row, 0).toString();
					if (daoPhong.xoaPhong(maP)) {
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
			String maPhong = txtMaPhong.getText().trim();
			String tenPhong = txtTenPhong.getText().trim();
			String donGia = txtDonGia.getText().trim();
			String mieuTa = txtMieuTa.getText().trim();
			String tinhTrang = txtTinhTrang.getText().trim();
			int viTriLoi = 0;
			if (maPhong.length()==0) {
				lblTBMaPhong.setText("Mã phòng không được để trống");
				viTriLoi=1;
			} else if (!ConvertToASCII.convertToASCII(maPhong).matches("[P]{1}[0-9]{2}")) {
				lblTBMaPhong.setText("3 kí tự ,Kí tự bắt đầu là P và có 2 số cuối");
				viTriLoi=1;
			} else {
				lblTBMaPhong.setText("");
			}
			if (tenPhong.length()==0) {
				lblTBTenPhong.setText("Tên phòng không được để trống");
				viTriLoi=1;
			} else if (!ConvertToASCII.convertToASCII(tenPhong).matches("[1-9]{1}|[1-9]{1}[0-9]")) {
				lblTBTenPhong.setText("Tên phòng là số");
				viTriLoi=1;
			} else {
				lblTBTenPhong.setText("");
			}
			int donGiaInt =0;
			if(donGia.length()==0) {
				lblTBDonGia.setText("Đơn giá không được để trống!");
				viTriLoi = 1;
			} else  {
				try {
					donGiaInt = Integer.parseInt(donGia);
					if(donGiaInt<=0) {
						lblTBDonGia.setText("Đơn giá phải lớn hơn 0");
						viTriLoi = 1;
					} else {
						lblTBDonGia.setText("");
					}
				} catch (Exception ex) {
					lblTBDonGia.setText("Đơn giá không đúng định dạng!");
					viTriLoi = 1;
				}	
			}
			if (mieuTa.length()==0) {
				lblTBMieuTa.setText("Tên phòng không được để trống");
				viTriLoi=1;
			}  else {
				lblTBMieuTa.setText("");
			}
			if (viTriLoi== 0) {
				int dongia = Integer.parseInt(txtDonGia.getText().trim()); 
				LoaiPhong loai = danhSachLoaiPhong.get(cboLoaiPhong.getSelectedIndex()-1);
				Phong phong = new Phong (maPhong,tenPhong,mieuTa,dongia,loai,tinhTrang);
				
				phong.setDonGia(dongia);
				phong.setLoaiPhong(loai);
				phong.setMaPhong(maPhong);
				phong.setMieuTa(mieuTa);
				phong.setTenPhong(tenPhong);
				phong.setTinhTrang(tinhTrang);
				
				daoPhong.suaPhong(phong);
				dfmodel.setRowCount(0);
				try {
					danhSachPhong = daoPhong.layDSPhong();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				for (Phong phong1 : danhSachPhong) {
				dfmodel.addRow(new Object[] {phong1.getMaPhong(), phong1.getTenPhong(),phong1.getLoaiPhong().getTenLoaiPhong(), 
						phong1.getDonGia(),phong1.getMieuTa(),phong1.getTinhTrang()
				});	
				}
			}
		}
	}

	private void docDSPhong() throws Exception {
		danhSachPhong = daoPhong.layDSPhong();
		for (Phong phong : danhSachPhong) {
			dfmodel.addRow(new Object[] {phong.getMaPhong(), phong.getTenPhong(),phong.getLoaiPhong().getTenLoaiPhong(), 
					phong.getDonGia(),phong.getMieuTa(),phong.getTinhTrang()
			});	
		}
	}
}
