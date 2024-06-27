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

import javax.swing.DefaultListModel;
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
import javax.swing.JScrollBar;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import java.awt.Cursor;
import javax.swing.Timer;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

	public class AccSystemGUI extends JFrame {
	
		static AccMethods AccMetd = new AccMethods() ;
	    public static JPanel contentPane;
	    private JPanel WelcomePanel;
	    private JPanel LoginPanel;
	    private JTextField textField;
	    private JPasswordField passwordField;
	    private JPanel MenuPanel;
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
	    static JLabel lblDifPassword2 ; 
	    static JLabel lblVerifyStatus;
	    JLabel lblVerifyPanelSample ;
	    JComboBox MenuComboBox = new JComboBox();
	    private JLabel lblDorC;
	    private JPanel panel_1;
	    private JPanel panel_2;
	    private JLabel lblNewLabel_1;
	    private JLabel lblNewLabel_2;
	    private JButton btnNewButton_2;
	    private JButton btnNewButton_3;
	    private JButton btnNewButton_4;

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
	    } // Main.
	    
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
	        
//	        Welcome Panel.
	        WelcomePanel = new JPanel();
	        contentPane.add(WelcomePanel, "WelcomePanel");
	        WelcomePanel.setLayout(null);
	        
	        JLabel lblNewLabel = new JLabel("Welcome to Bank");
	        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	        lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 22));
	        lblNewLabel.setBounds(220, 204, 325, 46);
	        WelcomePanel.add(lblNewLabel);
	        
	        JButton btnNewButton = new JButton("Enter"); // Welcome Panel Button.
	        btnNewButton.setFocusable(false);
	        btnNewButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                cardLayout.show(contentPane, "MenuPanel");
	            }
	        });
	        btnNewButton.setBounds(330, 262, 106, 25);
	        WelcomePanel.add(btnNewButton);
	        
//	        Login Panel.
	        LoginPanel = new JPanel();
	        contentPane.add(LoginPanel, "LoginPanel");
	        LoginPanel.setLayout(null);
	        
	        JLabel Username = new JLabel("Username");
	        Username.setBounds(224, 182, 62, 15);
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
	        
	        lblVerifyStatus = new JLabel("");
	        lblVerifyStatus.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
	        lblVerifyStatus.setBounds(304, 319, 260, 25);
	        LoginPanel.add(lblVerifyStatus);
    		
	        btnNewButton_1 = new JButton("Enter"); // Login Panel Button.
	        btnNewButton_1.setFocusable(false);
	        btnNewButton_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	                String Username = new String(textField.getText());
	                String Password = new String(passwordField.getPassword());
	                AccMetd.ExistingUserLogin(Username,Password);
	                if (AccMetd.Result == "Pass" ) {
	                	Timer timer1 = new Timer(1000, new ActionListener() {
	                		@Override
	        		        public void actionPerformed(ActionEvent e) {
	                			Menu();
	        		        }
	                	});
	                	timer1.setRepeats(false);
	        		    timer1.start();
	                }
	                else {}
	        	}
	        });
	        btnNewButton_1.setRolloverEnabled(false);
	        btnNewButton_1.setBounds(317, 268, 106, 25);
	        LoginPanel.add(btnNewButton_1);
	        
	        JLabel AskUserLoginLabel = new JLabel("For New Users, ");
	        AskUserLoginLabel.setFont(new Font("Dialog", Font.BOLD, 13));
	        AskUserLoginLabel.setBounds(213, 399, 106, 19);
	        LoginPanel.add(AskUserLoginLabel);
	        
	        JButton AskUserLoginButton = new JButton("Click Here");
	        AskUserLoginButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	                cardLayout.show(contentPane, "NewUserPanel");
	        	}
	        });
	        AskUserLoginButton.setFocusable(false);
	        AskUserLoginButton.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
	        AskUserLoginButton.setBounds(317, 393, 106, 25);
	        LoginPanel.add(AskUserLoginButton);

//	        Menu Panel.
	        MenuPanel = new JPanel();
	        contentPane.add(MenuPanel, "MenuPanel");
	        MenuPanel.setLayout(null);
	        
	        lblVerifyPanelSample = new JLabel("Main Menu");
	        lblVerifyPanelSample.setFont(new Font("Lucida Grande", Font.PLAIN, 29));
	        lblVerifyPanelSample.setBounds(310, 23, 166, 34);
	        MenuPanel.add(lblVerifyPanelSample);
	        
	        JPanel panel = new JPanel();
	        panel.setBounds(6, 314, 210, 168);
	        MenuPanel.add(panel);
	        
	        lblDorC = new JLabel(" Deposit/Withdraw");
	        panel.add(lblDorC);
	        
	        btnNewButton_2 = new JButton("New button");
	        panel.add(btnNewButton_2);
	        
	        panel_1 = new JPanel();
	        panel_1.setBounds(554, 314, 210, 168);
	        MenuPanel.add(panel_1);
	        
	        btnNewButton_4 = new JButton("New button");
	        panel_1.add(btnNewButton_4);
	        
	        lblNewLabel_2 = new JLabel("Others\n");
	        panel_1.add(lblNewLabel_2);
	        
	        panel_2 = new JPanel();
	        panel_2.setBounds(228, 314, 317, 168);
	        MenuPanel.add(panel_2);
	        panel_2.setLayout(null);
	        
	        lblNewLabel_1 = new JLabel("Bank Balance");
	        lblNewLabel_1.setBounds(57, 11, 81, 16);
	        panel_2.add(lblNewLabel_1);
	        
	        btnNewButton_3 = new JButton("New button");
	        btnNewButton_3.setBounds(106, 61, 117, 29);
	        panel_2.add(btnNewButton_3);

//	        NewUserPanel.
	        NewUserPanel = new JPanel();
	        NewUserPanel.setFont(new Font("Dialog", Font.PLAIN, 19));
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
	        
	        lblDifPassword2 = new JLabel(" ");
	        lblDifPassword2.setBounds(196, 362, 351, 15);
    		NewUserPanel.add(lblDifPassword2);
    		
	        btnNewUserPanel = new JButton("Submit");
	        btnNewUserPanel.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		
	        		String NewUsername = new String(txtfieldNewUsername.getText()) ;
	        		String NewPassword = new String(pwfieldNewPassword.getPassword()) ;
	        		String ConfirmPassword = new String(pwfieldConfirmPassword.getPassword()) ;
	        		 
	        		if (NewPassword.equals(ConfirmPassword)) { 
	        			AccMetd.NewUserLogin(NewUsername, NewPassword);
	        		    lblDifPassword2.setText("New Login Successful.. Please Wait");

//	        		    After 1.5 seconds, change the label text to "ReDirecting to Login Page."
	        		    Timer timer1 = new Timer(1500, new ActionListener() {
	        		        
	        		    	@Override
	        		        public void actionPerformed(ActionEvent e) {
	        		            lblDifPassword2.setText("ReDirecting to Login Page.");

//	        		            After 1 second, Return to the Login Panel.
	        		            Timer timer2 = new Timer(1000, new ActionListener() {
	        		                
	        		            	@Override
	        		                public void actionPerformed(ActionEvent e) {
	        		                    //cardLayout.previous(LoginPanel);
	        		                    cardLayout.show(contentPane, "LoginPanel");
	        		                }
	        		            });
	        		            
	        		            timer2.setRepeats(false);
	        		            timer2.start();
	        		        }
	        		    });
	        		    
	        		    timer1.setRepeats(false);
	        		    timer1.start();    
	        		} 
	        		else { 
	        			lblDifPassword2.setText("Confirmed Password Incorrect..!!");
	        		}
	        	}
	        });
	        
	        btnNewUserPanel.setRolloverEnabled(false);
	        btnNewUserPanel.setFocusable(false);
	        btnNewUserPanel.setBounds(294, 304, 106, 25);
	        NewUserPanel.add(btnNewUserPanel);
	        
	    }
	    
	    private void Menu() {
	    	CardLayout cardLayout = (CardLayout) contentPane.getLayout();
	    	cardLayout.show(contentPane, "MenuPanel");
	    }
}

