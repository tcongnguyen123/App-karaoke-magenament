package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Cursor;
import java.awt.Frame;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JRadioButton;

public class ThongKeNgay extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongKeNgay frame = new ThongKeNgay();
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
	public ThongKeNgay() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setTitle("Qu\u1EA3n l\u00FD h\u00F3a \u0111\u01A1n\r\n\r\n");
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 961, 798);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 255, 255));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(60, 109, 1437, 548);
		contentPane.add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setBounds(43, 41, 1343, 480);
		panel.add(table);
		
		JLabel lblNewLabel = new JLabel("TH\u1ED0NG K\u00CA DOANH THU THEO NG\u00C0Y");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(628, 22, 489, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Ng\u00E0y");
		lblNewLabel_1.setBounds(47, 692, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("T\u1EA5t c\u1EA3");
		rdbtnNewRadioButton.setBackground(new Color(240, 255, 255));
		rdbtnNewRadioButton.setBounds(197, 688, 103, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Ph\u00F2ng");
		rdbtnNewRadioButton_1.setBackground(new Color(240, 255, 255));
		rdbtnNewRadioButton_1.setBounds(337, 688, 103, 21);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JButton btnNewButton = new JButton("Th\u1ED1ng k\u00EA");
		btnNewButton.setBounds(628, 684, 112, 21);
		contentPane.add(btnNewButton);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("D\u1ECBch v\u1EE5");
		rdbtnNewRadioButton_2.setBackground(new Color(240, 255, 255));
		rdbtnNewRadioButton_2.setBounds(492, 688, 103, 21);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JButton btnThot = new JButton("Tho\u00E1t");
		btnThot.setBounds(779, 684, 112, 21);
		contentPane.add(btnThot);
	}
}
