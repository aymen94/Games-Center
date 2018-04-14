package component;

import javax.swing.UnsupportedLookAndFeelException;

import javax.swing.ImageIcon;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class UI extends UIManager {
	public UI() {
		try {
			setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		put("JFrame.icon",new ImageIcon("src//images//user.png"));
		put("Button.ui",GFont.getFont());
		put("OptionPane.background", GColor.FULLWHITE);
		put("Panel.background",GColor.FULLWHITE);
		put("TextField.font", GFont.getFont());
		put("Label.font", GFont.getFont());
		put("PasswordField.font",GFont.getFont());
		put("OptionPane.buttonFont",GFont.getFont());
		put("Button.font",GFont.getFont());
	}

}
