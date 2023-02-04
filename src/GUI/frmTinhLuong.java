package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Cursor;
import javax.swing.JButton;

public class frmTinhLuong extends JFrame implements ActionListener,MouseListener{

	private JPanel contentPane;
	private JTextField txtMaNV;
	private JTextField txtTongCaNgay;
	private JTextField textField_1;
	private JTextField txtTongCaDem;
	private JTextField txtDoanhThu;
	private JLabel lblDoanhThu;
	private JTextField txtLuongCoBan;
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
					frmTinhLuong frame = new frmTinhLuong();
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
	public frmTinhLuong() {
		setBackground(new Color(240, 255, 255));
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1578, 882);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 255, 255));
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblMaNV = new JLabel("M\u00E3 nh\u00E2n vi\u00EAn");
		lblMaNV.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblMaNV.setBounds(125, 93, 108, 48);
		panel_1.add(lblMaNV);
		
		txtMaNV = new JTextField();
		txtMaNV.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txtMaNV.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		txtMaNV.setBounds(297, 104, 150, 27);
		panel_1.add(txtMaNV);
		txtMaNV.setColumns(10);
		
		JLabel lblTongCaNgay = new JLabel("T\u1ED5ng ca ng\u00E0y");
		lblTongCaNgay.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblTongCaNgay.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblTongCaNgay.setBounds(125, 182, 108, 48);
		panel_1.add(lblTongCaNgay);
		
		txtTongCaNgay = new JTextField();
		txtTongCaNgay.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txtTongCaNgay.setColumns(10);
		txtTongCaNgay.setBounds(303, 192, 76, 27);
		panel_1.add(txtTongCaNgay);
		
		JLabel lblTenNV_2 = new JLabel("T\u00EAn nh\u00E2n vi\u00EAn");
		lblTenNV_2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblTenNV_2.setBounds(645, 93, 108, 48);
		panel_1.add(lblTenNV_2);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textField_1.setColumns(10);
		textField_1.setBounds(815, 104, 150, 27);
		panel_1.add(textField_1);
		
		JLabel lblTongCaDem = new JLabel("T\u1ED5ng ca \u0111\u00EAm");
		lblTongCaDem.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblTongCaDem.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblTongCaDem.setBounds(645, 192, 108, 48);
		panel_1.add(lblTongCaDem);
		
		txtTongCaDem = new JTextField();
		txtTongCaDem.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txtTongCaDem.setColumns(10);
		txtTongCaDem.setBounds(823, 202, 76, 28);
		panel_1.add(txtTongCaDem);
		
		lblDoanhThu = new JLabel("Doanh thu/Th\u00E1ng");
		lblDoanhThu.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblDoanhThu.setBounds(1091, 93, 108, 48);
		panel_1.add(lblDoanhThu);
		
		txtDoanhThu = new JTextField();
		txtDoanhThu.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txtDoanhThu.setColumns(10);
		txtDoanhThu.setBounds(1269, 104, 150, 27);
		panel_1.add(txtDoanhThu);
		
		JLabel lblLuongCoBan = new JLabel("L\u01B0\u01A1ng C\u01A1 B\u1EA3n");
		lblLuongCoBan.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblLuongCoBan.setBounds(1091, 182, 108, 48);
		panel_1.add(lblLuongCoBan);
		
		txtLuongCoBan = new JTextField();
		txtLuongCoBan.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txtLuongCoBan.setColumns(10);
		txtLuongCoBan.setBounds(1269, 192, 150, 27);
		panel_1.add(txtLuongCoBan);
		
		JButton btnTinhLuong = new JButton("T\u00EDnh L\u01B0\u01A1ng");
		btnTinhLuong.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnTinhLuong.setBounds(1311, 282, 108, 28);
		panel_1.add(btnTinhLuong);
		
		String [] tieude= {"Mã NV","Họ tên","Lương cơ bản","Ngày Công","Doanh thu","Lương lãnh thực"};
		dfmodel=new DefaultTableModel(tieude,0);
		table=new JTable(dfmodel);
		
		
		table.addMouseListener(this);
		JScrollPane sc=new JScrollPane(table);
		sc.setBounds(125, 345, 1294, 388);
		panel_1.add(sc);
		
		JLabel lblTieuDe = new JLabel("T\u00EDnh l\u01B0\u01A1ng");
		lblTieuDe.setBounds(710, 26, 128, 30);
		panel_1.add(lblTieuDe);
		lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 25));
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
