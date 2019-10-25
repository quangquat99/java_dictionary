package Application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import chap01.DictionaryManagement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Fix_Function01 extends Giaodien_Tudien {

	private JPanel contentPane;
	private JTextField tfword_Before;
	private JTextField tfword_After;

	private DictionaryManagement dictionaryManagement_Fix01 = this.getDictionaryManagement();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fix_Function01 frame = new Fix_Function01();
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
	public Fix_Function01() {
		setTitle("Sửa từ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Từ cần sửa : ");
		lblNewLabel.setBounds(29, 27, 197, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sửa từ thành : ");
		lblNewLabel_1.setBounds(29, 103, 197, 20);
		contentPane.add(lblNewLabel_1);
		
		tfword_Before = new JTextField();
		tfword_Before.setBounds(29, 59, 197, 33);
		contentPane.add(tfword_Before);
		tfword_Before.setColumns(10);
		
		tfword_After = new JTextField();
		tfword_After.setBounds(29, 134, 197, 43);
		contentPane.add(tfword_After);
		tfword_After.setColumns(10);
		
		JButton btnNewButton = new JButton("Sửa");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean check = dictionaryManagement_Fix01.fixWord01(tfword_Before.getText(), tfword_After.getText());
				if(check) JOptionPane.showMessageDialog(null, "Sửa thành công!!!", "Report", JOptionPane.OK_CANCEL_OPTION);
				else JOptionPane.showMessageDialog(null, "Sửa thất bại!!! Không tìm thấy từ cần sửa.", "Report", JOptionPane.OK_CANCEL_OPTION);
				dictionaryManagement_Fix01.dictionaryExportToFile();
				
			}
		});
		btnNewButton.setBounds(74, 213, 89, 23);
		contentPane.add(btnNewButton);
	}
}
