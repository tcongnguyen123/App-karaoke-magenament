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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TimKiemPhong extends JFrame implements MouseListener{

	private JPanel panel;
	private JTextField txtMaPhong;
	private DefaultTableModel dfmodel;
	private JTable table;
	private JTable table_1;
	private JTextField txtTenLoaiPhong;
	private JTextField txtTinhTrang;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimKiemPhong frame = new TimKiemPhong();
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
	public TimKiemPhong() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1480, 895);
		panel = new JPanel();
		panel.setBackground(new Color(240, 255, 255));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel lblTimPhong = new JLabel("Tìm kiếm phòng");
		lblTimPhong.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblTimPhong.setBounds(667, 30, 577, 45);
		panel.add(lblTimPhong);
		
		JLabel lblMaPhong = new JLabel("Mã phòng");
		lblMaPhong.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMaPhong.setBounds(97, 148, 85, 18);
		panel.add(lblMaPhong);
		
		txtMaPhong = new JTextField();
		txtMaPhong.setBounds(216, 144, 133, 21);
		panel.add(txtMaPhong);
		txtMaPhong.setColumns(10);
		
		JButton btnNewButton = new JButton("Tìm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnNewButton.setBounds(1321, 143, 115, 30);
		panel.add(btnNewButton);
		
		
		
		String [] tieude= {"Mã Phòng","Tên Loại Phòng","Đơn giá","Tình trạng"};
		dfmodel=new DefaultTableModel(tieude,0);
		table=new JTable(dfmodel);
		
		
		table.addMouseListener(this);
		JScrollPane sc=new JScrollPane(table);
		sc.setBounds(96, 318, 1340, 378);
		getContentPane().add(sc);
		
		JLabel lblTenLoaiPhong = new JLabel("Tên loại phòng");
		lblTenLoaiPhong.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTenLoaiPhong.setBounds(506, 149, 109, 18);
		panel.add(lblTenLoaiPhong);
		
		txtTenLoaiPhong = new JTextField();
		txtTenLoaiPhong.setColumns(10);
		txtTenLoaiPhong.setBounds(624, 144, 133, 21);
		panel.add(txtTenLoaiPhong);
		
		JLabel lblTinhTrang = new JLabel("Tình Trạng");
		lblTinhTrang.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTinhTrang.setBounds(933, 148, 109, 18);
		panel.add(lblTinhTrang);
		
		txtTinhTrang = new JTextField();
		txtTinhTrang.setColumns(10);
		txtTinhTrang.setBounds(1100, 148, 133, 21);
		panel.add(txtTinhTrang);
		
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
