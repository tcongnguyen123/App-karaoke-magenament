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

public class TimKiemHoaDon extends JFrame implements MouseListener{

	private JPanel panel;
	private JTextField txtMaHD;
	private JTextField txtKhachHang;
	private JTextField txtNgayLap;
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
					TimKiemHoaDon frame = new TimKiemHoaDon();
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
	public TimKiemHoaDon() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1480, 895);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel lblTimNhanVien = new JLabel("Tìm kiếm dịch vụ");
		lblTimNhanVien.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblTimNhanVien.setBounds(196, 31, 577, 45);
		panel.add(lblTimNhanVien);
		
		JLabel lblMaHD = new JLabel("Mã hóa đơn");
		lblMaHD.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMaHD.setBounds(96, 148, 85, 18);
		panel.add(lblMaHD);
		
		JLabel lblKhachHang = new JLabel("Tên khách hàng");
		lblKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblKhachHang.setBounds(819, 148, 112, 18);
		panel.add(lblKhachHang);
		
		txtMaHD = new JTextField();
		txtMaHD.setBounds(216, 144, 133, 21);
		panel.add(txtMaHD);
		txtMaHD.setColumns(10);
		
		txtKhachHang = new JTextField();
		txtKhachHang.setBounds(970, 148, 132, 21);
		panel.add(txtKhachHang);
		txtKhachHang.setColumns(10);
		
		JLabel lblNgayLap = new JLabel("Ngày lập ");
		lblNgayLap.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNgayLap.setBounds(450, 148, 85, 18);
		panel.add(lblNgayLap);
		
		txtNgayLap = new JTextField();
		txtNgayLap.setColumns(10);
		txtNgayLap.setBounds(570, 144, 133, 21);
		panel.add(txtNgayLap);
		
		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton.setBounds(987, 223, 115, 30);
		panel.add(btnNewButton);
		
		
		
		String [] tieude= {"Mã HĐ", "Ngày Lập","giờ thuê","giờ trả","Tên KH","Tổng tiền"};
		dfmodel=new DefaultTableModel(tieude,0);
		table=new JTable(dfmodel);
		
		
		table.addMouseListener(this);
		JScrollPane sc=new JScrollPane(table);
		sc.setBounds(96, 318, 1340, 378);
		getContentPane().add(sc);
		
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
