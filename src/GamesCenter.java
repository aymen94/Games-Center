import component.UI;
import dbconnection.ConnectDB;
import gui.LoginFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class GamesCenter {
	public static void main(String[] args){
		new UI();
		new ConnectDB().start();
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame a=new LoginFrame();
						a.setVisible(true);
			}
		} );
	}

}


