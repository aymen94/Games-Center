package gui.dashboard;

import controller.Game;
import controller.LoadGames;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class HomeGamesPanel extends JPanel {
    private LoadGames listGames;
    protected HomeGamesPanel() throws SQLException{
        listGames=new LoadGames("SELECT * FROM prodotto");
        addGames();
    }


    private void addGames(){
        JPanel gamePanel=new JPanel(new GridLayout(0,4,5,5));
        ArrayList<Game> listG=listGames.getList();
        for(int i=0;i<listG.size();i++)
            gamePanel.add(new GamePanel(listG.get(i),true));

        add(gamePanel);
    }

    protected void update(String category, String string) throws SQLException{
        if(category.equals("All"))
            listGames=new LoadGames("SELECT * FROM prodotto where titolo like \"%" +string +"%\"");
        else
            listGames = new LoadGames( "SELECT * FROM prodotto WHERE categoria IN " +
                                "(Select id From categoria WHERE nome='"+category+"' ) and titolo like \"%" +string +"%\"");

        this.removeAll();
        addGames();
        getRootPane().updateUI();
    }
}
