package gui;

import component.*;
import controller.Registration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class RegisterFrame extends JFrame {
    private JTextField emailT,nameT,lastNameT,dateT;
    private JPasswordField passT,passTR;
    private GButton loginB,registerB;

    public RegisterFrame(){
        setLayout(new BorderLayout());
        setTitle("Register");
        add(new TitlePanel(),BorderLayout.NORTH);
        form();
        bottom();
        action();
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void form() {
        JPanel myPanel = new JPanel();
        myPanel.setLayout(new BoxLayout(myPanel,BoxLayout.Y_AXIS));
        myPanel.setBorder(BorderFactory.createTitledBorder("Create Account"));
        JLabel name = new JLabel("Name: ");
        JLabel lastName = new JLabel("LastName: ");
        JLabel email = new JLabel("Email: ");
        JLabel date = new JLabel("Date of Birth:");
        JLabel pass = new JLabel("Password: ");
        JLabel passR = new JLabel("Repeat Password: ");

        nameT = new JTextField(15);
        lastNameT = new JTextField(15);
        emailT = new JTextField(15);
        dateT = new JTextField(15);
        passT = new JPasswordField(15);
        passTR = new JPasswordField(15);

        myPanel.add(name);
        myPanel.add(nameT);
        myPanel.add(lastName);
        myPanel.add(lastNameT);
        myPanel.add(email);
        myPanel.add(emailT);
        myPanel.add(date);
        myPanel.add(dateT);
        myPanel.add(pass);
        myPanel.add(passT);
        myPanel.add(passR);
        myPanel.add(passTR);
        add(myPanel,BorderLayout.CENTER);
    }

    private void bottom(){
        JPanel myPanel = new JPanel(new GridLayout(3,1,10,10));
        registerB = new GButton("Register",GColor.GREEN_700);
        JLabel txt = new JLabel("You Have an Account, Login now",JLabel.CENTER);
        loginB = new GButton("Log-In here",GColor.GREEN_800);

        myPanel.add(registerB);
        myPanel.add(txt);
        myPanel.add(loginB);
        add(myPanel,BorderLayout.SOUTH);
    }

    private void action(){

        registerB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Registration(nameT.getText(),lastNameT.getText(),emailT.getText(),dateT.getText(),passT.getPassword(),passTR.getPassword());
            }
        });

        loginB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new LoginFrame().setVisible(true);
                    }
                } );
            }
        });

    }
}
