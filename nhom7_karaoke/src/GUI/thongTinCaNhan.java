package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.Color;

public class thongTinCaNhan extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					thongTinCaNhan frame = new thongTinCaNhan();
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
	public thongTinCaNhan() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 397, 439);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(62, 598, 805, -475);
		contentPane.add(table);
		
		JLabel lblNewLabel = new JLabel("Ch\u01B0\u01A1ng tr\u00ECnh qu\u1EA3n l\u00FD karaoke");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(72, 133, 505, 31);
		contentPane.add(lblNewLabel);
		
		JTextArea txtrHTn = new JTextArea();
		txtrHTn.setBackground(new Color(240, 255, 255));
		txtrHTn.setText("H\u1ECD t\u00EAn : Tr\u1EA7n C\u00F4ng Nguy\u00EAn\r\nCh\u1EE9c v\u1EE5 : Qu\u1EA3n l\u00FD \r\n");
		txtrHTn.setBounds(75, 211, 459, 106);
		contentPane.add(txtrHTn);
	}
}
