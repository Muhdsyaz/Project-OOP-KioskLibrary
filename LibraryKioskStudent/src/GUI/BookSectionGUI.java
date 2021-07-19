package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class BookSectionGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookSectionGUI frame = new BookSectionGUI();
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
	public BookSectionGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book Section");
		lblNewLabel.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(139, 22, 129, 30);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Borrow Book");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BorrowBookGUI borrow = new BorrowBookGUI();
				borrow.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton.setBounds(145, 69, 123, 23);
		contentPane.add(btnNewButton);
		
		JButton btnReturnBook = new JButton("Return Book");
		btnReturnBook.setBackground(Color.WHITE);
		btnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReturnBookGUI returnBook = new ReturnBookGUI();
				returnBook.setVisible(true);
				dispose();
			}
		});
		btnReturnBook.setBounds(145, 102, 123, 23);
		contentPane.add(btnReturnBook);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBackground(Color.WHITE);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibraryKioskMenu menu = new LibraryKioskMenu();
				menu.setVisible(true);
				dispose();
			}
		});
		btnLogout.setBounds(145, 173, 123, 23);
		contentPane.add(btnLogout);
		
		JButton btnNewButton_1 = new JButton("Book Record");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookRecordGUI book = new BookRecordGUI();
				book.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(145, 135, 123, 28);
		contentPane.add(btnNewButton_1);
	}
}