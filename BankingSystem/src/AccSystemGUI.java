/*
  	Report : LastTenTrans Array is not updating when inserting transactions.
 */
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	    private JButton btnMPPanelDorC;
	    private JButton btnMPOthers;
	    private JTextField DateTxtField;
	    private JTextField AmountTxtField;
	    private JTextField RemarksTxtField;
	    private JLabel lblDorC5;
	    private JComboBox KindComboBox;
	    private JLabel lblDorCConfirmation;
	    static JLabel lblOutput_1 ;

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
	    	
	        setTitle("Bank");
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
	                cardLayout.show(contentPane, "LoginPanel");
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
	        lblVerifyStatus.setHorizontalAlignment(SwingConstants.CENTER);
	        lblVerifyStatus.setHorizontalTextPosition(SwingConstants.CENTER);
	        lblVerifyStatus.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
	        lblVerifyStatus.setBounds(242, 317, 260, 25);
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
	        
	        JLabel AskUserLoginLabel = new JLabel("Sign in");
	        AskUserLoginLabel.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		cardLayout.show(contentPane, "NewUserPanel");
	        	}
	        });
	        AskUserLoginLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
	        AskUserLoginLabel.setBounds(293, 372, 69, 19);
	        LoginPanel.add(AskUserLoginLabel);
	        
	        JLabel lblforgetpassword = new JLabel("Forgot Password?");
	        lblforgetpassword.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {

	        	}
	        });
	        lblforgetpassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	        lblforgetpassword.setHorizontalAlignment(SwingConstants.CENTER);
	        lblforgetpassword.setHorizontalTextPosition(SwingConstants.CENTER);
	        lblforgetpassword.setBounds(374, 369, 223, 25);
	        LoginPanel.add(lblforgetpassword);


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
	     
//	        Menu Panel.
	        MenuPanel = new JPanel();
	        contentPane.add(MenuPanel, "MenuPanel");
	        MenuPanel.setLayout(null);
    
	        lblVerifyPanelSample = new JLabel("Main Menu");
	        lblVerifyPanelSample.setFont(new Font("Lucida Grande", Font.PLAIN, 29));
	        lblVerifyPanelSample.setBounds(310, 23, 166, 34);
	        MenuPanel.add(lblVerifyPanelSample);
	        
	        JPanel panel = new JPanel();
	        panel.setBounds(6, 314, 341, 168);
	        MenuPanel.add(panel);
	        panel.setLayout(null);
	        
	        lblDorC = new JLabel("Deposit/Withdraw");
	        lblDorC.setBounds(117, 55, 118, 16);
	        panel.add(lblDorC);
	        
	        btnMPPanelDorC = new JButton("Enter");
	        btnMPPanelDorC.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		cardLayout.show(contentPane, "DorCPanel");
	        	}
	        });
	        btnMPPanelDorC.setFocusable(false);
	        btnMPPanelDorC.setBounds(117, 83, 117, 29);
	        panel.add(btnMPPanelDorC);
	        
	        panel_1 = new JPanel();
	        panel_1.setBounds(346, 314, 418, 168);
	        MenuPanel.add(panel_1);
	        panel_1.setLayout(null);
	        
	        JComboBox OthersComboBox = new JComboBox();
	        OthersComboBox.setModel(new DefaultComboBoxModel(new String[] {"Bank Balance", "Last Transaction", "Average Spend", "Total Credit", "Total Debit"}));
	        OthersComboBox.setBounds(66, 44, 261, 27);
	        panel_1.add(OthersComboBox);
	        
	        JLabel lblP_1 = new JLabel("Others");
	        lblP_1.setBounds(164, 16, 61, 16);
	        panel_1.add(lblP_1);
	        

	        lblOutput_1 = new JLabel(" ");
	        lblOutput_1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
	        lblOutput_1.setHorizontalAlignment(SwingConstants.CENTER);
	        lblOutput_1.setBounds(6, 138, 758, 48);
	        MenuPanel.add(lblOutput_1);
	        
	        btnMPOthers = new JButton("Enter");
	        btnMPOthers.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		 String SelectedItem = (String) OthersComboBox.getSelectedItem(); 
	        		 AccMetd.OthersItemDisplay(SelectedItem); 
	        	
	        	}
	        });
	        btnMPOthers.setFocusable(false);
	        btnMPOthers.setBounds(136, 83, 117, 29);
	        panel_1.add(btnMPOthers);
	        
	        
//	        DorC Panel.
	        JPanel DorCPanel = new JPanel();
	        contentPane.add(DorCPanel, "DorCPanel");
	        DorCPanel.setLayout(null);
	        
	        JLabel lblDorC1 = new JLabel("Deposit/Withdraw");
	        lblDorC1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
	        lblDorC1.setHorizontalAlignment(SwingConstants.CENTER);
	        lblDorC1.setBounds(277, 26, 210, 33);
	        DorCPanel.add(lblDorC1);
	        
	        JLabel lblDorC2 = new JLabel("Remarks");
	        lblDorC2.setHorizontalAlignment(SwingConstants.CENTER);
	        lblDorC2.setBounds(213, 328, 61, 16);
	        DorCPanel.add(lblDorC2);
	        
	        JLabel lblDorC3 = new JLabel("Date");
	        lblDorC3.setHorizontalAlignment(SwingConstants.CENTER);
	        lblDorC3.setBounds(213, 209, 61, 16);
	        DorCPanel.add(lblDorC3);
	        
	        JLabel lblDorC4 = new JLabel("Amount");
	        lblDorC4.setHorizontalAlignment(SwingConstants.CENTER);
	        lblDorC4.setBounds(213, 269, 61, 16);
	        DorCPanel.add(lblDorC4);
	        
	        lblDorC5 = new JLabel("Kind");
	        lblDorC5.setHorizontalAlignment(SwingConstants.CENTER);
	        lblDorC5.setBounds(213, 383, 61, 16);
	        DorCPanel.add(lblDorC5);
	        
	        DateTxtField = new JTextField();
	        DateTxtField.setBounds(286, 204, 210, 26);
	        DorCPanel.add(DateTxtField);
	        DateTxtField.setColumns(10);
	        
	        AmountTxtField = new JTextField();
	        AmountTxtField.setBounds(286, 264, 210, 26);
	        DorCPanel.add(AmountTxtField);
	        AmountTxtField.setColumns(10);
	        
	        RemarksTxtField = new JTextField();
	        RemarksTxtField.setBounds(286, 323, 210, 26);
	        DorCPanel.add(RemarksTxtField);
	        RemarksTxtField.setColumns(10);
	        
	        KindComboBox = new JComboBox();
	        KindComboBox.setModel(new DefaultComboBoxModel(new String[] {"Ration", "Outing", "Food", "School", "Others"}));
	        KindComboBox.setBounds(286, 379, 210, 27);
	        DorCPanel.add(KindComboBox);
	        
	        JComboBox DorCComboBox = new JComboBox();
	        DorCComboBox.setModel(new DefaultComboBoxModel(new String[] {"Deposit", "Withdraw"}));
	        DorCComboBox.setBounds(286, 131, 210, 27);
	        DorCPanel.add(DorCComboBox);
	        
	        JButton btnDorC = new JButton("Enter");
	        btnDorC.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		String Date = new String (DateTxtField.getText());
	        		String TempAmount = new String (AmountTxtField.getText());
	        		int Amount = Integer.valueOf(TempAmount);
	        		String Remarks = new String (RemarksTxtField.getText());
	        		String Kind = (String) KindComboBox.getSelectedItem();
	        		String DorCSelected = (String) DorCComboBox.getSelectedItem();
	        		
	        		DateTxtField.setText("");
	        		AmountTxtField.setText("");
	        		RemarksTxtField.setText("");
	        		
	        		if (DorCSelected == "Deposit" ) {
	        			AccMetd.InsertCredit(Date,Amount,Remarks,Kind);
	        			lblDorCConfirmation.setText("Amount Deposited Successfully.");
	        			
	        		}
	        		else if (DorCSelected == "Withdraw" ) {
	        			AccMetd.InsertDebit(Date,Amount,Remarks,Kind);
	        			lblDorCConfirmation.setText("Amount Withdrawn Successfully.");
	        		}
	        	}
	        });
	        btnDorC.setBounds(591, 264, 117, 29);
	        DorCPanel.add(btnDorC);
	        
	        lblDorCConfirmation = new JLabel(" ");
	        lblDorCConfirmation.setHorizontalAlignment(SwingConstants.CENTER);
	        lblDorCConfirmation.setBounds(545, 328, 210, 16);
	        DorCPanel.add(lblDorCConfirmation);
	        
	        JButton btnBack = new JButton("Back");
	        btnBack.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		Back("contentPane","MenuPanel");
	        	}
	        });
	        btnBack.setBounds(6, 453, 117, 29);
	        DorCPanel.add(btnBack);
	    }
	    
	    private void Menu() {
	    	CardLayout cardLayout = (CardLayout) contentPane.getLayout();
	    	cardLayout.show(contentPane, "MenuPanel");
	    }
	    
	    private void Back(String x, String y) { 	// Goes to the Previous Page.
	    	CardLayout cardLayout = (CardLayout) contentPane.getLayout();
	    	cardLayout.show(contentPane, "MenuPanel");
	    }
}

