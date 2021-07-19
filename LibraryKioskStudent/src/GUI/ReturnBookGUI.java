package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Book.BookManager;
import Book.BorrowBook;
import Book.BorrowManager;

import Book.RecordManager;
import Book.BookRecord;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Font;

public class ReturnBookGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	protected JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnBookGUI frame = new ReturnBookGUI();
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
	public ReturnBookGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ISBN :");
		lblNewLabel.setBounds(85, 183, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblId = new JLabel("Date :");
		lblId.setBounds(85, 208, 46, 14);
		contentPane.add(lblId);
		
		textField = new JTextField();
		textField.setBounds(127, 180, 178, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(127, 205, 178, 20);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_1 = new JLabel("Return Book");
		lblNewLabel_1.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(135, 10, 136, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Return Book");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BorrowManager BorrowManager = new BorrowManager();
				BorrowBook borrowbook = new BorrowBook();
				
                
				borrowbook.setISBN(textField.getText());
				BookRecord.setReturnDate(textField_1.getText());

				BorrowManager.returnBook(borrowbook);
                JOptionPane.showMessageDialog(null, "Return Success");
                
                RecordManager insertRecord = new RecordManager();
                BookRecord bRecord = new BookRecord();
                
                bRecord.setISBN(borrowbook.getISBN());
                
                insertRecord.record(bRecord);
                
                
                
			}
		});
		btnNewButton.setBounds(160, 233, 113, 23);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(Color.WHITE);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookSectionGUI menu = new BookSectionGUI();
				menu.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(10, 233, 71, 23);
		contentPane.add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 29, 416, 137);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Display");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BorrowManager displayReturnBook = new BorrowManager();
				displayReturnBook.displayBorrowBook();
				displayReturnBook.setVisible(true);
				dispose();				
			}
		});
		btnNewButton_1.setBounds(10, 7, 85, 21);
		contentPane.add(btnNewButton_1);
	}

}