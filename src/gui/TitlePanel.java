package gui;

import component.*;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import java.awt.Font;

@SuppressWarnings("serial")
public  class TitlePanel extends JPanel {
    public TitlePanel(){
        JLabel userL = new JLabel("Games Center");
        userL.setFont(new Font(Font.DIALOG,Font.BOLD,50));
        userL.setForeground(GColor.GREEN_400);
        setBorder(BorderFactory.createLineBorder(GColor.GREEN_200,3,true));
        add(userL);
    }
}
