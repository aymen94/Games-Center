package gui;

import component.*;
import controller.Login;
import gui.dashboard.DashboardFrame;
import handlererror.LoginError;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

@SuppressWarnings("serial")
public class LoginFrame extends JFrame  {
    private JLabel conn;
    private JTextField emailT;
    private JPasswordField passT;
    private GButton loginB,registerB;
    public LoginFrame(){
        setLayout(new BorderLayout());
        setTitle("Log-In");
        add(new TitlePanel(),BorderLayout.NORTH);
        add(form(),BorderLayout.CENTER);
        add(bottom(),BorderLayout.SOUTH);
        action();
        getRootPane().setDefaultButton(loginB);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    private JPanel form() {
        JPanel myPanel = new JPanel();
        myPanel.setLayout(new BoxLayout(myPanel,BoxLayout.Y_AXIS));
        myPanel.setBorder(BorderFactory.createTitledBorder("Log-In"));
        JLabel user = new JLabel("Email: ");
        JLabel pass = new JLabel("Password: ");
        conn= new JLabel("");
        conn.setFont(GFont.getSmallFont());
        conn.setForeground(GColor.RED_500);
        emailT = new JTextField(15);
        passT =new JPasswordField(15);
        myPanel.add(user);
        myPanel.add(emailT);
        myPanel.add(pass);
        myPanel.add(passT);
        myPanel.add(conn);
        return myPanel;
    }

    private JPanel bottom(){
        JPanel myPanel = new JPanel(new GridLayout(3,1,10,10));
        loginB = new GButton("Log-In",GColor.GREEN_700);
        JLabel txt = new JLabel("Not Registred,Create Account Now",JLabel.CENTER);
        registerB = new GButton("Create Accout",GColor.GREEN_800);

        myPanel.add(loginB);
        myPanel.add(txt);
        myPanel.add(registerB);
        return myPanel;
    }

    private void action(){

        loginB.addActionListener(e -> {
            try {
                if(!emailT.getText().matches("^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$") || passT.getPassword().length<6)
                    throw new LoginError();
                else{
                    Login l =new Login(emailT.getText().trim(), passT.getPassword());
                    if(l.launch()) {
                      setVisible(false);
                        /*EventQueue.invokeLater(new Runnable() {
                            @Override
                            public void run() {*/
                                try {
									new  DashboardFrame().setVisible(true);
								} catch (SQLException e1) {
									e1.printStackTrace();
									// TODO Auto-generated catch block
									//JOptionPane.showMessageDialog(null, "Errore SQL", "Errore", JOptionPane.ERROR_MESSAGE);
								}
                         /*   }
                        } );*/
                 }
                }
            } catch (LoginError e1) {
               conn.setText("The Email or Password are incorrect");
               pack();
            }
        });

        registerB.addActionListener(e -> {
            setVisible(false);
            new RegisterFrame().setVisible(true);
        });

    }

}
