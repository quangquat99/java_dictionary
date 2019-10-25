package Application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import chap01.DictionaryManagement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Fix_Function02 extends Giaodien_Tudien {

	
	private JPanel contentPane;
	private JTextField tfword_Before;
	private JTextField tfword_After;
	private DictionaryManagement dictionaryManagement_Fix02 = this.getDictionaryManagement();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fix_Function02 frame = new Fix_Function02();
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
	public Fix_Function02() {
		setTitle("Sửa nghĩa của từ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Từ cần sửa nghĩa : ");
		lblNewLabel.setBounds(32, 28, 196, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Sửa nghĩa của từ thành : ");
		lblNewLabel_1.setBounds(32, 103, 196, 20);
		contentPane.add(lblNewLabel_1);
		
		tfword_Before = new JTextField();
		tfword_Before.setBounds(32, 59, 196, 33);
		contentPane.add(tfword_Before);
		tfword_Before.setColumns(10);
		
		tfword_After = new JTextField();
		tfword_After.setBounds(32, 134, 196, 43);
		contentPane.add(tfword_After);
		tfword_After.setColumns(10);
		
		JButton btnNewButton = new JButton("Sửa");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean check = dictionaryManagement_Fix02.fixWord02(tfword_Before.getText(), tfword_After.getText());
				if(check) JOptionPane.showMessageDialog(null, "Sửa thành công!!!", "Report", JOptionPane.OK_CANCEL_OPTION);
				else JOptionPane.showMessageDialog(null, "Sửa thất bại!!! Không tìm thấy từ có nghĩa cần sửa.", "Report", JOptionPane.OK_CANCEL_OPTION);
				dictionaryManagement_Fix02.dictionaryExportToFile();
			}
		});
		btnNewButton.setBounds(76, 214, 89, 23);
		contentPane.add(btnNewButton);
	}

}
