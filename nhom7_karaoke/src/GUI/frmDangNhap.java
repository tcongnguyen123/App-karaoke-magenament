package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class frmDangNhap extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtTaiKhoan;
	private JPasswordField txtPassword;
	private JButton btnDangNhap;
	private JButton btnThoat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmDangNhap frame = new frmDangNhap();
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
	public frmDangNhap() {
		setBackground(new Color(240, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTaiKhoan = new JLabel("T\u00E0i Kho\u1EA3n");
		lblTaiKhoan.setBounds(39, 86, 96, 13);
		contentPane.add(lblTaiKhoan);
		
		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setBounds(203, 83, 149, 19);
		contentPane.add(txtTaiKhoan);
		txtTaiKhoan.setColumns(10);
		
		JLabel lblMatKhau = new JLabel("M\u1EADt kh\u1EA9u");
		lblMatKhau.setBounds(39, 151, 96, 13);
		contentPane.add(lblMatKhau);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(203, 148, 149, 19);
		contentPane.add(txtPassword);
		
		btnDangNhap = new JButton("\u0110\u0103ng nh\u1EADp");
		btnDangNhap.setBounds(80, 206, 109, 21);
		contentPane.add(btnDangNhap);
		
		 btnThoat = new JButton("Tho\u00E1t");
		btnThoat.setBounds(213, 206, 85, 21);
		contentPane.add(btnThoat);
		
		JLabel lblNewLabel = new JLabel("\u0110\u0103ng nh\u1EADp");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(164, 23, 164, 19);
		contentPane.add(lblNewLabel);
		btnThoat.addActionListener(this);
		btnDangNhap.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o =e.getSource();
		if(o.equals(btnDangNhap)) {
			String username = txtTaiKhoan.getText();
			String password = new String(txtPassword.getPassword());
			StringBuilder sb = new StringBuilder ();
			
			if(username.equals("")) {
				sb.append("tài khoản trống");
			}
			if(password.equals("")) {
				sb.append("mật khẩu trống");
			}
			if(username.equals("sa")&& password.equals("123")) {
				ManHinhChinh frmMHC = null;
				try {
					frmMHC = new ManHinhChinh();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frmMHC.setVisible(true);
			}
		}
		else if (o.equals(btnThoat)) {
			dispose();
		}
		}
	
		
}
