package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Student.Student;
import Student.StudentManager;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;

public class LoginGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
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
	public LoginGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBackground(Color.ORANGE);
		lblNewLabel.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(170, 22, 95, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID :");
		lblNewLabel_1.setBounds(57, 89, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password :");
		lblNewLabel_1_1.setBounds(57, 132, 64, 14);
		contentPane.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setBounds(142, 86, 155, 17);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(142, 129, 155, 17);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentManager studentManager = new StudentManager();
                Student student = new Student();

                student.setID(textField.getText());
                student.setPassword(textField_1.getText());


                if (studentManager.loginfx(textField.getText(), textField_1.getText()))
                {

                   BookSectionGUI book = new BookSectionGUI();
                   book.setVisible(true);
                   dispose();

                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Invalid");
                }
			}
		});
		btnNewButton.setBounds(176, 171, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnReturn = new JButton("Back");
		btnReturn.setBackground(Color.WHITE);
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibraryKioskMenu menu = new LibraryKioskMenu();
				menu.setVisible(true);
				dispose();
			}
		});
		btnReturn.setBounds(32, 227, 71, 23);
		contentPane.add(btnReturn);
	}

}