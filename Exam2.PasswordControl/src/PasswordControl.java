import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JPasswordField;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;


public class PasswordControl {

	private JFrame frame;
	private JPasswordField passwordField;
	private JButton btnOk;
	private JButton btnHelp;
	private JLabel lblEnterThePassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PasswordControl window = new PasswordControl();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PasswordControl() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {0, 0, 0};
		gridBagLayout.rowHeights = new int[] {0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		lblEnterThePassword = new JLabel("Enter The Password:");
		GridBagConstraints gbc_lblEnterThePassword = new GridBagConstraints();
		gbc_lblEnterThePassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnterThePassword.anchor = GridBagConstraints.EAST;
		gbc_lblEnterThePassword.gridx = 0;
		gbc_lblEnterThePassword.gridy = 0;
		frame.getContentPane().add(lblEnterThePassword, gbc_lblEnterThePassword);
		
		passwordField = new JPasswordField(10);
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 0;
		frame.getContentPane().add(passwordField, gbc_passwordField);
		
		btnOk = new JButton("OK");
		GridBagConstraints gbc_btnOk = new GridBagConstraints();
		gbc_btnOk.insets = new Insets(0, 0, 5, 0);
		gbc_btnOk.gridx = 1;
		gbc_btnOk.gridy = 1;
		frame.getContentPane().add(btnOk, gbc_btnOk);
		btnOk.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						System.out.println(passwordField.getPassword());
						char[] correctPassword = {'b','u','g','a','b','o','o'};
						if(Arrays.equals(correctPassword,passwordField.getPassword())){
							JOptionPane.showMessageDialog(frame,"This is the correct Password.");
						}else {
							JOptionPane.showMessageDialog(frame,"Invalid password. Try again.","Error Message",
				                    JOptionPane.ERROR_MESSAGE);
							passwordField.setText(null);
						}
					}
				});
		
		btnHelp = new JButton("Help");
		GridBagConstraints gbc_btnHelp = new GridBagConstraints();
		gbc_btnHelp.gridx = 1;
		gbc_btnHelp.gridy = 2;
		frame.getContentPane().add(btnHelp, gbc_btnHelp);
		btnHelp.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(frame,"Enter the password.");
					}
				});
	}

}
