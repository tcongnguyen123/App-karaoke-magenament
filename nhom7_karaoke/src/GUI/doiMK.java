package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class doiMK extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					doiMK frame = new doiMK();
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
	public doiMK() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("�?ổi mật khẩu");
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mật khẩu hiện tại");
		lblNewLabel.setBounds(33, 55, 112, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("M\u1EADt kh\u1EA9u m\u1EDBi");
		lblNewLabel_1.setBounds(33, 103, 112, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nh\u1EADp l\u1EA1i m\u1EADt kh\u1EA9u");
		lblNewLabel_2.setBounds(33, 146, 112, 18);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(197, 52, 144, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("X\u00E1c nh\u1EADn");
		btnNewButton.setBounds(90, 205, 97, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("H\u1EE7y");
		btnNewButton_1.setBounds(225, 205, 85, 21);
		contentPane.add(btnNewButton_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(197, 145, 144, 19);
		contentPane.add(textField_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(197, 100, 144, 19);
		contentPane.add(textField_1);
	}
}
