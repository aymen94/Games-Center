package gui.dashboard;

import controller.Game;
import controller.LoadGames;
import controller.Session;
import dbconnection.Query;

import javax.swing.JPanel;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.GridLayout;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class MyGamesPanel extends JPanel {
    private LoadGames listGames;
   	private PreparedStatement ps;

    protected MyGamesPanel() throws SQLException {
    	ps=Query.userGames();
    	ps.setInt(1, Session.getUser().getId());
        listGames = new LoadGames(ps);
        addGames();
    }


    private void addGames() {
        JPanel gamePanel = new JPanel(new GridLayout(0, 4, 5, 5));
        ArrayList<Game> listG = listGames.getList();
        for (int i = 0; i < listG.size(); i++)
            gamePanel.add(new GamePanel(listG.get(i),false));

        add(gamePanel);
    }

    protected void update() throws SQLException{
        listGames = new LoadGames(ps);
        this.removeAll();
        addGames();
    }
}
