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

import Entity.*;
import Other.DateFormat;
import connect_DB.connectDB;
import DAO.*;

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
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JRadioButton;
import java.awt.SystemColor;

public class QuanLiNhanVien extends JFrame implements MouseListener,ActionListener{

	private JPanel panel;
	private JTextField txtMaNV;
	private JTextField txtHoTen;
	private JTextField txtDiaChi;
	private JTextField txtEmail;
	private JTextField txtSDT;
	private DefaultTableModel dfmodel;
	private JTable table;
	private JTable table_1;
	private ArrayList<NhanVien> danhSachNhanVien;
	private NhanVien_DAO daoNhanVien;
	private JRadioButton radNam;
	private JRadioButton radNu;
	private JComboBox<String> cboLoaiNV;
	private LoaiNhanVien_DAO daoLoaiNhanVien;
	private ArrayList<LoaiNhanVien> danhSachLoaiNV;
	private JTextField txtNgaySinh;
	private ButtonGroup bg;
	private JButton btnXoaRong;
	private UtilDateModel dateModel;
	private Properties dateProperties;
	private JDatePanelImpl datePanel;
	private JDatePickerImpl dateNgaySinh;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JLabel lblTitle;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLiNhanVien frame = new QuanLiNhanVien();
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
	public QuanLiNhanVien() throws Exception  {
		try {
			connectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		daoNhanVien = new NhanVien_DAO();
		daoLoaiNhanVien = new LoaiNhanVien_DAO();
	
		setTitle("Qu???n l?? nh??n vi??n");
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1480, 895);
		panel = new JPanel();
		panel.setBackground(new Color(240, 255, 255));
		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel lblMaNV = new JLabel("M\u00E3 Nh\u00E2n Vi\u00EAn");
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMaNV.setBounds(96, 148, 85, 18);
		panel.add(lblMaNV);
		
		JLabel lblNewLabel_1 = new JLabel("H\u1ECD t\u00EAn");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(95, 217, 85, 13);
		panel.add(lblNewLabel_1);
		
		txtMaNV = new JTextField();
		txtMaNV.setBounds(216, 144, 133, 21);
		panel.add(txtMaNV);
		txtMaNV.setColumns(10);
		
		txtHoTen = new JTextField();
		txtHoTen.setBounds(217, 214, 132, 21);
		panel.add(txtHoTen);
		txtHoTen.setColumns(10);
		
		JLabel lblDiaChi = new JLabel("\u0110\u1ECBa ch\u1EC9");
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDiaChi.setBounds(450, 148, 85, 18);
		panel.add(lblDiaChi);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setBounds(449, 218, 85, 13);
		panel.add(lblEmail);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(570, 144, 204, 22);
		panel.add(txtDiaChi);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(571, 214, 203, 21);
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
		
		JLabel lblLoaiNV = new JLabel("Lo???i nh??n vi??n");
		lblLoaiNV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLoaiNV.setBounds(1177, 148, 102, 18);
		panel.add(lblLoaiNV);
		
		/*JTextField txtLoaiNV = new JTextField();
		txtLoaiNV.setColumns(10);
		txtLoaiNV.setBounds(1303, 144, 133, 21);
		panel.add(txtLoaiNV); */
		cboLoaiNV = new JComboBox<String>();
		cboLoaiNV.setBounds(1289, 148, 142, 21);
		panel.add(cboLoaiNV);

		danhSachLoaiNV = daoLoaiNhanVien.layDSLoai();

		cboLoaiNV.addItem("Ch???n Nh??n Vi??n");
		for (LoaiNhanVien loai : danhSachLoaiNV) {
			cboLoaiNV.addItem(loai.getTenLoai());
		}
		
		btnSua = new JButton("S???a");
		btnSua.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnSua.setBounds(1303, 302, 115, 30);
		panel.add(btnSua);
		
		
		
		String [] tieude= {"M?? NV","H??? t??n","Ng??y Sinh","SDT","Gi???i t??nh","Email","DiaChi","Ch???c v???"};
		dfmodel=new DefaultTableModel(tieude,0);
		table=new JTable(dfmodel);
		
		
		table.addMouseListener(this);
		JScrollPane sc=new JScrollPane(table);
		sc.setBackground(new Color(240, 255, 255));
		sc.setBorder(new TitledBorder(null, "Danh s\u00E1ch nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		sc.setBounds(96, 383, 1340, 378);
		getContentPane().add(sc);
		
		btnXoa = new JButton("X??a");
		btnXoa.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnXoa.setBounds(1145, 302, 115, 30);
		panel.add(btnXoa);
		
		btnThem = new JButton("Th??m");
		btnThem.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnThem.setBounds(821, 302, 115, 30);
		panel.add(btnThem);
		
		/*JRadioButton rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setBackground(new Color(240, 255, 255));
		rdbtnNam.setBounds(941, 214, 103, 21);
		panel.add(rdbtnNam);
		
		JRadioButton rdbtnNu = new JRadioButton("N???");
		rdbtnNu.setBackground(new Color(240, 255, 255));
		rdbtnNu.setBounds(1084, 214, 103, 21);
		panel.add(rdbtnNu); */
		radNam = new JRadioButton("Nam");
		radNam.setBackground(new Color(240, 255, 255));
		radNam.setBounds(941, 214, 103, 21);
		panel.add(radNam);
		radNam.setSelected(true);
		
		radNu = new JRadioButton("N???");
		radNu.setBackground(new Color(240, 255, 255));
		radNu.setBounds(1046, 214, 74, 21);
		panel.add(radNu);
		
		bg = new ButtonGroup();
		bg.add(radNam);
		bg.add(radNu);
		
		lblTitle = new JLabel("Th??ng Tin Nh??n Vi??n");
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblTitle.setBounds(644, 32, 508, 51);
		panel.add(lblTitle);
		
		JLabel lblNgaySinh = new JLabel("Ng??y sinh");
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNgaySinh.setBounds(1177, 214, 102, 18);
		panel.add(lblNgaySinh);
		
		/*txtNgaySinh = new JTextField();
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setBounds(1289, 214, 133, 21);
		panel.add(txtNgaySinh); */ 
		
		dateModel = new UtilDateModel();
		dateProperties = new Properties();
		dateProperties.put("text.today", "Today");
		dateProperties.put("text.month", "Month");
		dateProperties.put("text.year", "Year");
		datePanel = new JDatePanelImpl(dateModel, dateProperties);
		dateNgaySinh = new JDatePickerImpl(datePanel, new DateFormat());
		dateNgaySinh.getJFormattedTextField().setEditable(true);
		dateNgaySinh.getJFormattedTextField().setBackground(SystemColor.textHighlightText);
		dateNgaySinh.setSize(252, 28);
		//dateNgaySinh.setLocation(50, 161);
		dateNgaySinh.setBounds(1289, 217, 142, 21);
		panel.add(dateNgaySinh);
		
		btnXoaRong = new JButton("X??a R???ng");
		btnXoaRong.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnXoaRong.setBounds(979, 302, 115, 30);
		panel.add(btnXoaRong);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 10, 10);
		panel.add(panel_1);
		
		radNam.addActionListener(this);
		radNu.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		docDSNhanVien();
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		txtMaNV.setText(dfmodel.getValueAt(row,0).toString());
		txtHoTen.setText(dfmodel.getValueAt(row,1).toString());
		DefaultTableModel model  = (DefaultTableModel) table.getModel();
		try {
			Date date =  new SimpleDateFormat("dd-MM-yyyy").parse((String) model.getValueAt(row, 2).toString());
			dateModel.setValue(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtSDT.setText(dfmodel.getValueAt(row,3).toString());
		
		String gioiTinh = dfmodel.getValueAt(row,4).toString();
			if(gioiTinh.equals("Nam")) {
				radNam.setSelected(true);
			}
			else {
				radNu.setSelected(true);
			}
		txtEmail.setText(dfmodel.getValueAt(row,5).toString());
		cboLoaiNV.setSelectedItem(dfmodel.getValueAt(row,7).toString());
		txtDiaChi.setText(dfmodel.getValueAt(row,6).toString());
		
	
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
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnXoaRong)) {
			txtMaNV.setText("");
			txtHoTen.setText("");
	//		dateModel.setValue(null);
			txtSDT.setText("");
			txtEmail.setText("");
			radNam.setSelected(false);
			radNu.setSelected(false);
			cboLoaiNV.setSelectedIndex(0);
			txtDiaChi.setText("");
			dateModel.setSelected(false);
			txtHoTen.requestFocus();

		}
		else if (o.equals(btnThem)) {
			String maNV = txtMaNV.getText().trim();
			String hoTen = txtHoTen.getText().trim();
			LocalDate ngaySinh = LocalDate.of(dateModel.getYear(), dateModel.getMonth() + 1, dateModel.getDay());
			String soDienThoai = txtSDT.getText().trim();
			boolean gioiTinh = radNam.isSelected();
			String email = txtEmail.getText().trim();
			String diaChi = txtDiaChi.getText().trim();
			
			LoaiNhanVien loai = danhSachLoaiNV.get(cboLoaiNV.getSelectedIndex() - 1);
			
			NhanVien objNhanVien = new NhanVien(maNV, hoTen, ngaySinh, soDienThoai, gioiTinh, email, diaChi,loai);
			daoNhanVien.themNhanVien(objNhanVien);
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			dfmodel.addRow(new Object[] {
					objNhanVien.getMaNV(), objNhanVien.getTenNV(), dtf.format(objNhanVien.getNgaySinh()),objNhanVien.getSoDienThoai(), objNhanVien.isGioiTinh() ? "Nam" : "N???",objNhanVien.getEmail(),objNhanVien.getDiaChi(),objNhanVien.getLoaiNV().getTenLoai()		
			});
			JOptionPane.showMessageDialog(this, "Th??m th??nh c??ng!");
	
		}
		else if(o.equals(btnXoa)) {
			if(table.getSelectedRow()==-1)
				JOptionPane.showMessageDialog(this, "Ch???n d??ng c???n x??a");
			else {
				int r=JOptionPane.showConfirmDialog(this,"B???n mu???n x??a d??ng n??y");
				if(r==JOptionPane.YES_OPTION) {
					int row = table.getSelectedRow();
					String maNV = dfmodel.getValueAt(row, 0).toString();
					if (daoNhanVien.xoaNhanVien(maNV)) {
						dfmodel.removeRow(table.getSelectedRow());
						JOptionPane.showMessageDialog(this, "X??a th??nh c??ng.");
					}
					else {
						JOptionPane.showMessageDialog(this, "???? x???y ra l???i!");
					}
				}
			}
				
		}
		else if (o.equals(btnSua)) {
			
			String maNV = txtMaNV.getText().trim();
			String hoTen = txtHoTen.getText().trim();
			LocalDate ngaySinh = LocalDate.of(dateModel.getYear(), dateModel.getMonth() + 1, dateModel.getDay());
			String soDienThoai = txtSDT.getText().trim();
			boolean gioiTinh = radNam.isSelected();
			String email = txtEmail.getText().trim();
			String diaChi = txtDiaChi.getText().trim();
			
			LoaiNhanVien loai = danhSachLoaiNV.get(cboLoaiNV.getSelectedIndex() - 1);
			
			NhanVien nhanVien = new NhanVien(maNV, hoTen, ngaySinh, soDienThoai, gioiTinh, email, diaChi,loai);
			
			nhanVien.setLoaiNV(loai);
			nhanVien.setTenNV(hoTen);
			nhanVien.setNgaySinh(ngaySinh);
			nhanVien.setSoDienThoai(soDienThoai);
			nhanVien.setGioiTinh(gioiTinh);
			nhanVien.setEmail(email);
			nhanVien.setDiaChi(diaChi);
			
			daoNhanVien.suaNhanVien(nhanVien);
			dfmodel.setRowCount(0);
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			try {
				danhSachNhanVien = daoNhanVien.layDSNhanVien();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			for (NhanVien nhanVien1 : danhSachNhanVien) {
				dfmodel.addRow(new Object[] {nhanVien1.getMaNV(), nhanVien1.getTenNV(), dtf.format(nhanVien1.getNgaySinh()),nhanVien1.getSoDienThoai(), nhanVien1.isGioiTinh() ? "Nam" : "N???",nhanVien1.getEmail(),nhanVien1.getDiaChi(),nhanVien1.getLoaiNV().getTenLoai() });	
			}
			JOptionPane.showMessageDialog(this, "S???a th??nh c??ng!");
		}
	}
	private void docDSNhanVien() throws Exception {
		danhSachNhanVien = daoNhanVien.layDSNhanVien();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		for (NhanVien nhanVien : danhSachNhanVien) {
			dfmodel.addRow(new Object[] {nhanVien.getMaNV(), nhanVien.getTenNV(), dtf.format(nhanVien.getNgaySinh()),nhanVien.getSoDienThoai(), nhanVien.isGioiTinh() ? "Nam" : "N???",nhanVien.getEmail(),nhanVien.getDiaChi(),nhanVien.getLoaiNV().getTenLoai()
					});	
		}
	}
}
