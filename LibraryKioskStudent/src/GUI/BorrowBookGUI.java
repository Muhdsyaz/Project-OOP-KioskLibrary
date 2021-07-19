package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Book.BookManager;
import Book.Book;
import Book.BorrowBook;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Font;

public class BorrowBookGUI extends JFrame {

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
					BorrowBookGUI frame = new BorrowBookGUI();
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
	public BorrowBookGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Borrow Book");
		lblNewLabel.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(146, 11, 137, 14);
		contentPane.add(lblNewLabel);
		
		/*
		BookManager bookManager = new BookManager();
		Book book = new Book();
		
		String item; 
		String items = "";
		
		book = bookManager.displayBook();
		item = "\n" + book.getBookISBN() + "\t" + book.getBookTitle() + "\t" + book.getBookAuthor() + "\t" + book.getBookPublisher() + "\t" + book.getYearOfPublish() ;
		*/
		
		JLabel lblNewLabel_1 = new JLabel("ISBN : ");
		lblNewLabel_1.setBounds(33, 176, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(68, 176, 137, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Borrow");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BookManager bookManager = new BookManager();
				BorrowBook borrowbook = new BorrowBook();
                
				borrowbook.setISBN(textField.getText());
				borrowbook.setBorrowDate(textField_1.getText());

                bookManager.borrow(borrowbook);
                JOptionPane.showMessageDialog(null, "Borrow Success");

			}
		});
		btnNewButton.setBounds(328, 227, 98, 23);
		contentPane.add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(Color.WHITE);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookSectionGUI book = new BookSectionGUI();
				book.setVisible(true);
				dispose();
			}
		});
		btnBack.setBounds(23, 227, 67, 23);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel_2 = new JLabel("Date :");
		lblNewLabel_2.setBounds(215, 176, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(256, 176, 96, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 28, 403, 136);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Display");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookManager displayBook = new BookManager();
				displayBook.displayBook();
				displayBook.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(23, 4, 85, 21);
		contentPane.add(btnNewButton_1);
	}
}