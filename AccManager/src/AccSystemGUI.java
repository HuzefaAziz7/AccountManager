import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Rectangle;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JScrollBar;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import java.awt.Cursor;

	public class AccSystemGUI extends JFrame {
		
	    private JPanel contentPane;
	    private JPanel WelcomePanel;
	    private JPanel LoginPanel;
	    private JTextField textField;
	    private JPasswordField passwordField;
	    private JPanel VerificationPanel;
	    private JLabel lblNewLabel_3;
	    private JButton btnNewButton_1;
	    private JPanel NewUserPanel;
	    private JLabel lblNewUsername;
	    private JTextField txtfieldNewUsername;
	    private JLabel lblNewPassword;
	    private JPasswordField pwfieldNewPassword;
	    private JButton btnNewUserPanel;
	    private JLabel lblConfirmPassword;
	    private JPasswordField pwfieldConfirmPassword;

	    /**
	     * Launch the application.
	     */
	    public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
	                    AccSystemGUI frame = new AccSystemGUI();
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
	    public AccSystemGUI() {
	    	
	        setTitle("Weyay Bank");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 770, 516);
	        contentPane = new JPanel();
	        setContentPane(contentPane);
	        contentPane.setLayout(new CardLayout(0, 0));
	        CardLayout cardLayout = (CardLayout) contentPane.getLayout();
	        
	        // Panel 1 (Welcome Panel)
	        WelcomePanel = new JPanel();
	        contentPane.add(WelcomePanel, "panel1");
	        WelcomePanel.setLayout(null);
	        
	        JLabel lblNewLabel = new JLabel("Welcome to Bank");
	        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	        lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 22));
	        lblNewLabel.setBounds(220, 204, 325, 46);
	        WelcomePanel.add(lblNewLabel);
	        
	        JButton btnNewButton = new JButton("Enter");
	        btnNewButton.setFocusable(false);
	        btnNewButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
	                cardLayout.show(contentPane, "panel2");
	            }
	        });
	        btnNewButton.setBounds(330, 262, 106, 25);
	        WelcomePanel.add(btnNewButton);
	        
	        // Panel 2 (Login Panel)
	        LoginPanel = new JPanel();
	        contentPane.add(LoginPanel, "panel2");
	        LoginPanel.setLayout(null);
	        
	        JLabel Username = new JLabel("Username");
	        Username.setBounds(224, 181, 62, 15);
	        LoginPanel.add(Username);
	        
	        textField = new JTextField();
	        textField.setBounds(304, 179, 240, 19);
	        LoginPanel.add(textField);
	        textField.setColumns(10);
	        
	        JLabel UserPassword = new JLabel("Password");
	        UserPassword.setBounds(226, 224, 60, 15);
	        LoginPanel.add(UserPassword);
	        
	        passwordField = new JPasswordField();
	        passwordField.setBounds(304, 222, 240, 19);
	        LoginPanel.add(passwordField);
	        
	        btnNewButton_1 = new JButton("Enter");
	        btnNewButton_1.setFocusable(false);
	        btnNewButton_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	                cardLayout.show(contentPane, "VerificationPanel");
	                String Verification = "Pass" ; 
	                if (Verification == "Pass") { 
	                	lblNewLabel_3 = new JLabel("Successful.");
	                }
	                else if (Verification == "Fail"){
	                	lblNewLabel_3 = new JLabel("Failed.");
	                }
	                
	                lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 52));
	    	        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
	    	        lblNewLabel_3.setBounds(179, 136, 380, 169);
	    	        VerificationPanel.add(lblNewLabel_3);
	        	}
	        });
	        btnNewButton_1.setRolloverEnabled(false);
	        btnNewButton_1.setBounds(317, 268, 106, 25);
	        LoginPanel.add(btnNewButton_1);
	        
	        JLabel AskUserLoginLabel = new JLabel("For New Users, ");
	        AskUserLoginLabel.setFont(new Font("Dialog", Font.BOLD, 13));
	        AskUserLoginLabel.setBounds(212, 340, 106, 19);
	        LoginPanel.add(AskUserLoginLabel);
	        
	        JButton AskUserLoginButton = new JButton("Click Here");
	        AskUserLoginButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	                cardLayout.show(contentPane, "NewUserPanel");
	        	}
	        });
	        AskUserLoginButton.setFocusable(false);
	        AskUserLoginButton.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
	        AskUserLoginButton.setBounds(317, 337, 106, 25);
	        LoginPanel.add(AskUserLoginButton);
	        
	        VerificationPanel = new JPanel();
	        contentPane.add(VerificationPanel, "VerificationPanel");
	        VerificationPanel.setLayout(null);
	        
	        NewUserPanel = new JPanel();
	        contentPane.add(NewUserPanel, "NewUserPanel");
	        NewUserPanel.setLayout(null);
	        
	        lblNewUsername = new JLabel("New Username");
	        lblNewUsername.setBounds(196, 193, 93, 15);
	        NewUserPanel.add(lblNewUsername);
	        
	        txtfieldNewUsername = new JTextField();
	        txtfieldNewUsername.setColumns(10);
	        txtfieldNewUsername.setBounds(307, 191, 240, 19);
	        NewUserPanel.add(txtfieldNewUsername);
	        
	        lblNewPassword = new JLabel("New Password");
	        lblNewPassword.setBounds(196, 232, 93, 15);
	        NewUserPanel.add(lblNewPassword);
	        
	        pwfieldNewPassword = new JPasswordField();
	        pwfieldNewPassword.setBounds(307, 230, 240, 19);
	        NewUserPanel.add(pwfieldNewPassword);
	        
	        lblConfirmPassword = new JLabel("Confirm Password");
	        lblConfirmPassword.setBounds(175, 270, 114, 15);
	        NewUserPanel.add(lblConfirmPassword);
	        
	        pwfieldConfirmPassword = new JPasswordField();
	        pwfieldConfirmPassword.setBounds(307, 268, 240, 19);
	        NewUserPanel.add(pwfieldConfirmPassword);
	        
	        btnNewUserPanel = new JButton("Enter");
	        btnNewUserPanel.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		
	        		System.out.println(txtfieldNewUsername.getText());
	        		System.out.println(pwfieldNewPassword.getPassword());
	        		System.out.println(pwfieldConfirmPassword.getPassword());
	        	}
	        });
	        btnNewUserPanel.setRolloverEnabled(false);
	        btnNewUserPanel.setFocusable(false);
	        btnNewUserPanel.setBounds(294, 304, 106, 25);
	        NewUserPanel.add(btnNewUserPanel);
	        
	        
	        
	        
	    }
	}

