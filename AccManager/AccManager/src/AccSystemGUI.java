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

	public class AccSystemGUI extends JFrame {

	    private JPanel contentPane;
	    private JPanel WelcomePanel;
	    private JPanel LoginPanel;
	    private JTextField textField;
	    private JPasswordField passwordField;
	    private JPanel VerificationPanel;
	    private JLabel lblNewLabel_3;
	    private JButton btnNewButton_1;
	    private JPanel panel;

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
	        
	        textField = new JTextField();
	        textField.setBounds(304, 179, 240, 19);
	        LoginPanel.add(textField);
	        textField.setColumns(10);
	        
	        JLabel Username = new JLabel("USERNAME");
	        Username.setBounds(214, 181, 67, 15);
	        LoginPanel.add(Username);
	        
	        passwordField = new JPasswordField();
	        passwordField.setBounds(304, 222, 240, 19);
	        LoginPanel.add(passwordField);
	        
	        JLabel UserPassword = new JLabel("PASSWORD");
	        Username.setBounds(214, 224, 72, 15);
	        LoginPanel.add(UserPassword);
	        
	        btnNewButton_1 = new JButton("Enter");
	        btnNewButton_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		CardLayout cardLayout = (CardLayout) contentPane.getLayout();
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
	        btnNewButton_1.setBounds(304, 290, 106, 25);
	        LoginPanel.add(btnNewButton_1);
	        
	        VerificationPanel = new JPanel();
	        contentPane.add(VerificationPanel, "VerificationPanel");
	        VerificationPanel.setLayout(null);
	        
	        panel = new JPanel();
	        contentPane.add(panel, "name_8133787472166");
	        
	        
	    }
	}

