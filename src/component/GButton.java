package component;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class GButton extends JButton {
    public GButton(ImageIcon text) {
        super (text);
        setUI(new UIButton());
    }
    public GButton(String text, Color color) {
        super (text);
        setBackground(color);
        setUI(new UIButton());

    }
    public GButton(String text, Color color, Font font) {
        super (text);
        setBackground(color);
        setFont(font);
        setUI(new UIButton());
    }
}

