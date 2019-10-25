package Application;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.RenderingHints.Key;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import chap01.Dictionary;
import chap01.DictionaryManagement;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import javax.swing.JScrollBar;
//import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JScrollPane;

public class Giaodien_Tudien extends JFrame implements DocumentListener{

	private JPanel contentPane;
	
	private JTextField Spelling_Word;
	private DictionaryManagement dictionaryManagement;
	private JTextArea Explain_Word;
	private DefaultListModel model;
	private JList list_Words;
	public static final String VOICE_NAME = "kevin16";
	
	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Giaodien_Tudien frame = new Giaodien_Tudien();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DictionaryManagement getDictionaryManagement() {
		return dictionaryManagement;
	}

	public void setDictionaryManagement(DictionaryManagement dictionaryManagement) {
		this.dictionaryManagement = dictionaryManagement;
	}

	/**
	 * Create the frame.
	 */
	public Giaodien_Tudien()  {
			
	
		setResizable(false);
		setTitle("Java_Dictionary");
		
		dictionaryManagement = new DictionaryManagement();
		dictionaryManagement.insertFromFile();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 407);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 93, 132, 264);
		contentPane.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(260, 93, 303, 264);
		contentPane.add(scrollPane_1);
		*/
		
		Spelling_Word = new JTextField();
		Spelling_Word.setBounds(10, 73, 132, 22);
		contentPane.add(Spelling_Word);
		Spelling_Word.setColumns(10);
		Spelling_Word.getDocument().addDocumentListener(this);
		Spelling_Word.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				if ( arg0.getKeyCode() == KeyEvent.VK_ENTER)
				{
					action_Search();
				}
			}
		});
		
		
		model = new DefaultListModel<>();
		list_Words = new JList(model);
		list_Words.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				String value = list_Words.getSelectedValue().toString();
				
				String str = dictionaryManagement.dictionaryLookup(value);
				//System.out.println(str);
				
				
				String str2 = str.replace("\t", "\n ");
				Explain_Word.setText(str2);
				
			}
		});
		list_Words.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if ( arg0.getKeyCode() == KeyEvent.VK_DOWN )
				{
					int i = list_Words.getSelectedIndex() + 1;
				}
				else if (arg0.getKeyCode() == KeyEvent.VK_UP )
				{
					int i = list_Words.getSelectedIndex() - 1;
				}
			}
		});
		
		
		list_Words.setBackground(Color.LIGHT_GRAY);
		list_Words.setBounds(10, 95, 132, 262);
		contentPane.add(list_Words);
		
		JButton btnPhtm = new JButton("Phát âm");
		btnPhtm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Voice voice;
				VoiceManager voiceManager = VoiceManager.getInstance();
				voice = voiceManager.getVoice(VOICE_NAME);
				voice.allocate();
				
				try {
					voice.speak(Spelling_Word.getText());
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		});
		btnPhtm.setBounds(152, 136, 98, 23);
		contentPane.add(btnPhtm);
		
		Explain_Word = new JTextArea();
		Explain_Word.setLineWrap(true);
		Explain_Word.setWrapStyleWord(true);
		Explain_Word.setBounds(260, 73, 303, 284);
		contentPane.add(Explain_Word);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(153, 204, 255));
		lblNewLabel.setBounds(10, 0, 553, 49);
		contentPane.add(lblNewLabel);
		Image image1 = new Image();
		image1.setPicture(lblNewLabel, "Dict.jpg");		
		
		


		
		JButton btSearch = new JButton("Tìm kiếm");
		btSearch.setBounds(152, 70, 98, 23);
		btSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				action_Search();
				
			}
		});
		contentPane.add(btSearch);
		
		
		
		
		JButton btDelete = new JButton("Xóa từ");
		btDelete.setBounds(152, 334, 98, 23);
		
		btDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//Tao 1 panel mới
				
				JPanel panel_Delete = new JPanel();
				JLabel lblword_Need_Delete = new JLabel("Từ bị xóa : ");
				JTextField tf_Xoatu = new JTextField(10);
				panel_Delete.add(lblword_Need_Delete);
				panel_Delete.add(tf_Xoatu);
				
				int click = JOptionPane.showConfirmDialog(null, panel_Delete , "Delete_Function",JOptionPane.OK_CANCEL_OPTION);
				if ( click == JOptionPane.OK_OPTION )
				{
					if (dictionaryManagement.deleteWord(tf_Xoatu.getText()))
					{
						JOptionPane.showMessageDialog(null, "Xóa từ thành công!!!"  , "Report", JOptionPane.INFORMATION_MESSAGE);
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "Xóa từ thất bại!!! Từ không có trong từ điển", "Report", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				else if (click == JOptionPane.CANCEL_OPTION);
				dictionaryManagement.dictionaryExportToFile();
			}
		});
		contentPane.add(btDelete);
		
		JButton btFix = new JButton("Sửa từ");
		btFix.setBounds(152, 268, 98, 23);
		btFix.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Fix_Function_Selection fix_Function_Selection = new Fix_Function_Selection();
				fix_Function_Selection.setVisible(true);
				fix_Function_Selection.setTitle("Fix_Function");
				
				
				
				fix_Function_Selection.setDefaultCloseOperation(HIDE_ON_CLOSE);
			}
		});
		
		contentPane.add(btFix);
		
		
		JButton btAdd = new JButton("Thêm từ");
		//jlScreen.setLabelFor(btAdd);
		btAdd.setBounds(152, 202, 98, 23);
		btAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Add_Function add_Function = new Add_Function();
				add_Function.setVisible(true);
				add_Function.setTitle("Add_Function");
				add_Function.setDefaultCloseOperation(HIDE_ON_CLOSE);
				
			}
		});
		contentPane.add(btAdd);
		
		JLabel lblNhpT = new JLabel("Nhập từ : ");
		lblNhpT.setForeground(Color.WHITE);
		//lblNhpT.setBackground(Color.WHITE);
		lblNhpT.setBounds(10, 51, 132, 22);
		contentPane.add(lblNhpT);
		
		JLabel jlScreen = new JLabel("");
		jlScreen.setBounds(0, 0, 583, 378);
		contentPane.add(jlScreen);
		Image image2 = new Image();
		image2.setPicture(jlScreen, "hehe.jpg");
		

		

		//scrollPane.setViewportView(list_Words);
		

		//scrollPane_1.setViewportView(Explain_Word);
		

		
	}
	
	
	public void action_Search()
	{
		String str = Spelling_Word.getText();
		String str2 = dictionaryManagement.dictionaryLookup(str);
		String str3 = str2.replace("\t", "\n ");
		System.out.println(str3);
		Explain_Word.setText(" " + str3);
	}

	
	
	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
//		show_list_EWords(e);
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		show_list_EWords(e);
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		show_list_EWords(e);
	}
	
//	public void print(DocumentEvent e) {
//		System.out.println(Spelling_Word.getText());
//	}
	
	public void show_list_EWords(DocumentEvent e)
	{
		DefaultListModel model_List = new DefaultListModel();
		ArrayList<String> arrayList = dictionaryManagement.dictionarySearcher(Spelling_Word.getText());
		for(String str : arrayList) {
			model_List.addElement(str);
		}
		if ( model_List.size() > 0 )
		{
			list_Words.setModel(model_List);
			
		}
		
	}
}
