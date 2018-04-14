package gui.dashboard;

import controller.DetailedGame;
import controller.Game;
import dbconnection.Config;
import dbconnection.Query;
import gui.TitlePanel;

import javax.swing.*;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@SuppressWarnings("serial")
public class GameInfoFrame extends  JFrame {
        private Game g;
    protected GameInfoFrame(Game g) throws SQLException{
        this.g=g;
        setLayout(new BorderLayout());
        setTitle("Games Center "+g.getTitle());
        add(new TitlePanel(),BorderLayout.NORTH);
        addAllInfo();
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    private void addAllInfo() throws SQLException{
        add(img(),BorderLayout.LINE_START);
        add(getInfo(),BorderLayout.CENTER);

    }
    private JLabel img(){
       ImageIcon img= new ImageIcon(Config.PATH_SOURCE+g.getImg());
        Image image = img.getImage();
        return new JLabel(new ImageIcon(image.getScaledInstance(280, 440, Image.SCALE_SMOOTH)));
    }
    private JPanel getInfo() throws SQLException {
    	DetailedGame game=DetailedGame.mysqlDetailedGame(g.getId());
    	JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextArea description = new JTextArea("Description: " + game.getDescription());
        description.setEditable(false);
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Title: " + game.getTitle()));
        panel.add(new JLabel("Year: " + game.getYear()));
        panel.add(description);
        return panel;
    }
}
