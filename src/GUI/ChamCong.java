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
import javax.swing.border.TitledBorder;
import java.awt.Color;

public class ChamCong extends JFrame implements MouseListener{

	private JPanel panel;
	private JTextField txtMaPhong;
	private JTextField txtTenPhong;
	private JTextField txtTenNV;
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
					ChamCong frame = new ChamCong();
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
	public ChamCong() {
		setTitle("Chấm công");
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1480, 895);
		panel = new JPanel();
		panel.setBackground(new Color(240, 255, 255));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel lblTuNgay = new JLabel("Từ ngày");
		lblTuNgay.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTuNgay.setBounds(96, 148, 85, 18);
		panel.add(lblTuNgay);
		
		txtMaPhong = new JTextField();
		txtMaPhong.setBounds(216, 144, 133, 21);
		panel.add(txtMaPhong);
		txtMaPhong.setColumns(10);
		
		JLabel lblDenNgay = new JLabel("Đến ngày");
		lblDenNgay.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDenNgay.setBounds(450, 148, 110, 18);
		panel.add(lblDenNgay);
		
		txtTenPhong = new JTextField();
		txtTenPhong.setColumns(10);
		txtTenPhong.setBounds(570, 144, 133, 21);
		panel.add(txtTenPhong);
		
		JLabel lblTenNV = new JLabel("Tên nhân viên");
		lblTenNV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTenNV.setBounds(821, 148, 85, 18);
		panel.add(lblTenNV);
		
		txtTenNV = new JTextField();
		txtTenNV.setColumns(10);
		txtTenNV.setBounds(941, 144, 133, 21);
		panel.add(txtTenNV);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnLuu.setBounds(1321, 143, 115, 30);
		panel.add(btnLuu);
		
		
		
		String [] tieude= {"Mã NV","Tên NV","Ngày","Ca 1","Ca 2","Ca 3","Tổng"};
		dfmodel=new DefaultTableModel(tieude,0);
		table=new JTable(dfmodel);
		
		
		table.addMouseListener(this);
		JScrollPane sc=new JScrollPane(table);
		sc.setBackground(new Color(240, 255, 255));
		sc.setBorder(new TitledBorder(null, "Danh sách chấm công nhân viên", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		sc.setBounds(96, 307, 1340, 378);
		getContentPane().add(sc);
		
		JButton btnXemCong = new JButton("Xem Công");
		btnXemCong.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btnXemCong.setBounds(1161, 143, 115, 30);
		panel.add(btnXemCong);
		
		JLabel lblTitle = new JLabel("Thông Tin Chấm Công");
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblTitle.setBounds(695, 34, 289, 38);
		panel.add(lblTitle);
		
		JLabel lblChuThich = new JLabel("X là nhân viên có đi làm ");
		lblChuThich.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblChuThich.setBounds(96, 724, 329, 18);
		panel.add(lblChuThich);
		
		JLabel lblPLNhn = new JLabel("p là nhân viên nghỉ có phép ");
		lblPLNhn.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblPLNhn.setBounds(275, 724, 329, 18);
		panel.add(lblPLNhn);
		
		JLabel lblKLNhn = new JLabel("k là nhân viên nghỉ không phép");
		lblKLNhn.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblKLNhn.setBounds(495, 724, 329, 18);
		panel.add(lblKLNhn);
		
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
