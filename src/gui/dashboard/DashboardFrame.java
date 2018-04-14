package gui.dashboard;
import javax.swing.*;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.sql.SQLException;

@SuppressWarnings("serial")
public class DashboardFrame extends JFrame {
	private MyGamesPanel myGames;
	private HomeGamesPanel homeGame;
	public  DashboardFrame() throws SQLException {
		setLayout(new BorderLayout());
		setTitle("Games Center dashboard");
		add(new UserPanel(),BorderLayout.NORTH);
		centerPanel();
		pack();
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	private void centerPanel() throws SQLException{
		JTabbedPane tab = new JTabbedPane();
		homeGame=new HomeGamesPanel();
		myGames=new MyGamesPanel();
		tab.addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e) {
				try {
					myGames.update();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                getRootPane().updateUI();
			}
		});
		tab.addTab("Home",new ImageIcon("src//images//home.png"),new JScrollPane(homeGame));
		tab.addTab("My Games",new ImageIcon("src//images//mygames.png"),new JScrollPane (myGames));
		add(tab,BorderLayout.CENTER);
		add(new JScrollPane(new CategoryPanel(homeGame)),BorderLayout.LINE_START);
		add(new JScrollPane(new TopGamesPanel()),BorderLayout.LINE_END);
	}

}








