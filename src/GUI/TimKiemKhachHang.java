package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;

public class TimKiemKhachHang extends JFrame implements MouseListener{

	private JPanel panel;
	private JTextField txtMaNV;
	private JTextField txtTxthoten;
	private JTextField txtDiaChi;
	private JTextField txtEmail;
	private JTextField txtSDT;
	private JTextField txtGioiTinh;
	private DefaultTableModel dfmodel;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimKiemKhachHang frame = new TimKiemKhachHang();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TimKiemKhachHang() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1480, 895);
		panel = new JPanel();
		panel.setBackground(new Color(240, 255, 255));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel lblTimNhanVien = new JLabel("Tìm kiếm khách hàng");
		lblTimNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblTimNhanVien.setBounds(697, 24, 577, 45);
		panel.add(lblTimNhanVien);
		
		JLabel lblMaNV = new JLabel("Mã khách hàng");
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMaNV.setBounds(96, 148, 85, 18);
		panel.add(lblMaNV);
		
		JLabel lblNewLabel_1 = new JLabel("Họ tên");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(95, 217, 85, 13);
		panel.add(lblNewLabel_1);
		
		txtMaNV = new JTextField();
		txtMaNV.setBounds(216, 144, 133, 21);
		panel.add(txtMaNV);
		txtMaNV.setColumns(10);
		
		txtTxthoten = new JTextField();
		txtTxthoten.setBounds(217, 214, 132, 21);
		panel.add(txtTxthoten);
		txtTxthoten.setColumns(10);
		
		JLabel lblDiaChi = new JLabel("\u0110\u1ECBa ch\u1EC9");
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDiaChi.setBounds(450, 148, 85, 18);
		panel.add(lblDiaChi);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setBounds(449, 217, 85, 13);
		panel.add(lblEmail);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(570, 144, 133, 21);
		panel.add(txtDiaChi);
		
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
		
		txtGioiTinh = new JTextField();
		txtGioiTinh.setColumns(10);
		txtGioiTinh.setBounds(942, 214, 132, 21);
		panel.add(txtGioiTinh);
		
		
		
		JTextField txtCCCD = new JTextField();
		txtCCCD.setColumns(10);
		txtCCCD.setBounds(1303, 144, 133, 21);
		panel.add(txtCCCD);
		
		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton.setBounds(1303, 302, 115, 30);
		panel.add(btnNewButton);
		
		
		
		String [] tieude= {"Mã KH","Họ tên","Địa chỉ","SDT","Chức vụ","Giới tính"};
		dfmodel=new DefaultTableModel(tieude,0);
		table=new JTable(dfmodel);
		
		
		table.addMouseListener(this);
		JScrollPane sc=new JScrollPane(table);
		sc.setBackground(new Color(240, 255, 255));
		sc.setBounds(96, 383, 1340, 378);
		getContentPane().add(sc);
		
		JLabel lblCCCD = new JLabel("Căn cước ");
		lblCCCD.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCCCD.setBounds(1192, 148, 133, 18);
		panel.add(lblCCCD);
		
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
