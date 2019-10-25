package Application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import chap01.DictionaryManagement;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Add_Function extends Giaodien_Tudien {

	private JPanel contentPane;
	private JTextField add_Spelling_Word;
	private JTextField add_Explain_Word;
	private DictionaryManagement dictionaryManagement_Add = this.getDictionaryManagement();
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Function frame = new Add_Function();
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
	public Add_Function() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 500, 273);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		add_Spelling_Word = new JTextField();
		add_Spelling_Word.setBounds(116, 36, 255, 30);
		contentPane.add(add_Spelling_Word);
		add_Spelling_Word.setColumns(10);
		
		add_Explain_Word = new JTextField();
		add_Explain_Word.setBounds(116, 113, 255, 30);
		contentPane.add(add_Explain_Word);
		add_Explain_Word.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Từ cần thêm : ");
		lblNewLabel.setBounds(126, 11, 101, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nghĩa của từ cần thêm : ");
		lblNewLabel_1.setBounds(126, 77, 163, 23);
		contentPane.add(lblNewLabel_1);
		
		JButton btAdd = new JButton("Thêm ");
		btAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if ( dictionaryManagement_Add.insertWord(add_Spelling_Word.getText(), add_Explain_Word.getText()))
				{
					JOptionPane.showMessageDialog(null, "Thêm từ thành công!!!", "Report", JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Thêm từ thất bại!!! Từ đã có sẵn", "Report", JOptionPane.INFORMATION_MESSAGE);
				}
				dictionaryManagement_Add.dictionaryExportToFile();
			}
		});
		
		btAdd.setBounds(152, 200, 89, 23);
		contentPane.add(btAdd);
	}
	
	

}
