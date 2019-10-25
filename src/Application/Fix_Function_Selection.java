package Application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Fix_Function_Selection extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fix_Function_Selection frame = new Fix_Function_Selection();
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
	public Fix_Function_Selection() {
		setTitle("Fix_Function_Selection");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 250, 300, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("1. Sửa từ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Fix_Function01 fix_Function01 = new Fix_Function01();
				fix_Function01.setVisible(true);
				fix_Function01.setDefaultCloseOperation(HIDE_ON_CLOSE);
			}
		});
		btnNewButton.setBounds(29, 21, 221, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("2. Sửa nghĩa của từ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fix_Function02 fix_Function02 = new Fix_Function02();
				fix_Function02.setVisible(true);
				fix_Function02.setDefaultCloseOperation(HIDE_ON_CLOSE);
			}
		});
		btnNewButton_1.setBounds(29, 65, 221, 23);
		contentPane.add(btnNewButton_1);
		
		
	}
}
