package gui.dashboard;

import dbconnection.ConnectDB;
import component.GButton;
import component.GColor;
import controller.Family;
import controller.GPassword;
import controller.Session;
import controller.User;
import gui.TitlePanel;
import handlererror.SQLDataException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.InputMismatchException;

@SuppressWarnings("serial")
public class SettingFrame extends JFrame {
	private User user;
	JPasswordField oldpassT = new JPasswordField(15);
	JPasswordField passT = new JPasswordField(15);
	JPasswordField passTR = new JPasswordField(15);
	JTextField family= new JTextField(""+Session.getUser().getFamily(),15);


	protected SettingFrame(){
		this.user=new User(Session.getUser().getId());
		setTitle("Setting Account");
		setLayout(new BorderLayout(5,5));
		add(new TitlePanel(),BorderLayout.NORTH);
		add(new JLabel(new ImageIcon("src//Images//user.png")),BorderLayout.LINE_START);
		bottom();
		form();
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	private void form(){
		JPanel myPanel = new JPanel();
		myPanel.setLayout(new GridLayout(0,2,2,2));
		myPanel.setBorder(BorderFactory.createTitledBorder("info Account"));
		JLabel name = new JLabel("Name: ");
		JLabel lastName = new JLabel("LastName: ");
		JLabel email = new JLabel("Email: ");
		JLabel oldPass = new JLabel("Old Password: ");
		JLabel pass = new JLabel("New Password: ");
		JLabel passR = new JLabel("Repeat Password: ");
		JLabel familyL=new JLabel("Family: ");
		JTextField nameT = new JTextField(Session.getUser().getName(),15);
		JTextField lastNameT = new JTextField(Session.getUser().getLastName(),15);
		JTextField emailT = new JTextField(Session.getUser().getEmail(),15);
		emailT.setEditable(false);
		nameT.setEditable(false);
		lastNameT.setEditable(false);
		myPanel.add(name);
		myPanel.add(nameT);
		myPanel.add(lastName);
		myPanel.add(lastNameT);
		myPanel.add(email);
		myPanel.add(emailT);
		myPanel.add(familyL);
		myPanel.add(family);
		myPanel.add(oldPass);
		myPanel.add(oldpassT);
		myPanel.add(pass);
		myPanel.add(passT);
		myPanel.add(passR);
		myPanel.add(passTR);
		add(myPanel,BorderLayout.CENTER);
	}

	private void bottom(){
		JPanel panelButton=new JPanel();
		GButton apply=new GButton("apply", GColor.GREEN_400);
		apply.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {

					Family fam=new Family(Integer.parseInt(family.getText()),Session.getUser());
					if(fam.getChanged())
					{
						JOptionPane.showMessageDialog(null, "Family updated successfully", "Family updated", JOptionPane.INFORMATION_MESSAGE);
					}
					if(	passT.getPassword().length<6)
						JOptionPane.showMessageDialog(null, "New password must contain at least 6 characters", "Error", JOptionPane.ERROR_MESSAGE);
					else
					{

						GPassword old= new GPassword(oldpassT.getPassword());
						GPassword n1= new GPassword(passT.getPassword());
						GPassword n2= new GPassword(passTR.getPassword());

						if(!old.checkPass(user.getPassword()))
							JOptionPane.showMessageDialog(null, "Old password is incorrect", "Error", JOptionPane.ERROR_MESSAGE);
						else if(n1.checkPass(n2))
						{
							Connection conn = ConnectDB.getConnection();
							PreparedStatement st;
							st = conn.prepareStatement("UPDATE  Cliente\r\n" + 
									"set password=?\r\n" + 
									"where id=?");
							st.setString(1,n2.getHash());
							st.setInt(2, user.getId());
							if(st.executeUpdate()==0)
								throw new SQLDataException();
							dispose();
							JOptionPane.showMessageDialog(null, "Password updated successfully", "Password updated", JOptionPane.INFORMATION_MESSAGE);
						}
						else throw new InputMismatchException();
					}
				}
				catch(IllegalArgumentException error)
				{
					JOptionPane.showMessageDialog(null, "The family has reached its limit", "Error", JOptionPane.ERROR_MESSAGE);

				}
				catch(InputMismatchException error)
				{
					JOptionPane.showMessageDialog(null, "Passwords don't match", "Error", JOptionPane.ERROR_MESSAGE);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "SQL Exception", "Error", JOptionPane.ERROR_MESSAGE);
				} catch (SQLDataException e1 ) {
					JOptionPane.showMessageDialog(null, "Unable to update password", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		GButton cancel=new GButton("cancel", GColor.GREEN_400);
		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panelButton.add(apply);
		panelButton.add(cancel);
		add(panelButton,BorderLayout.PAGE_END);
	}
}
