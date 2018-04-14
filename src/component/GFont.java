package component;

import java.awt.Font;

public class GFont {
    public static Font getFont(){
       return new Font(Font.SANS_SERIF,Font.PLAIN,20);
    }
    public static Font getBigFont(){
        return new Font(Font.SANS_SERIF,Font.PLAIN,30);
    }
    public static Font getSmallFont(){
        return new Font(Font.SANS_SERIF,Font.PLAIN,12);
    }
}
