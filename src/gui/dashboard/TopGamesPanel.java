package gui.dashboard;

import component.GButton;
import component.GColor;
import controller.Game;
import controller.LoadGames;
import dbconnection.Query;

import javax.swing.*;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class TopGamesPanel extends JPanel {
    private ArrayList<String> listG=new ArrayList<String>();
    protected TopGamesPanel() throws SQLException{
    	
        PreparedStatement ps=Query.topGames();
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
        	listG.add(rs.getString("titolo"));
        }
        setBorder(BorderFactory.createRaisedSoftBevelBorder());
        addGames();
    }

    private void addGames() {
        JPanel gamePanel = new JPanel(new GridLayout(0, 1, 10, 10));
        gamePanel.add(new JLabel("Top Games",SwingConstants.CENTER));
        for (int i = 0; i < listG.size(); i++) {
            GButton btn = new GButton((i+1)+") "+listG.get(i), GColor.GREY_200);
            gamePanel.add(btn);
        }
        gamePanel.setPreferredSize(new Dimension(280,300));
        add(gamePanel);
    }
}
