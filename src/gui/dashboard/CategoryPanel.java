package gui.dashboard;

import component.GButton;
import component.GColor;
import component.GFont;
import controller.Category;
import controller.LoadCategory;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class CategoryPanel extends JPanel {
	private  ArrayList<Category> list;
	private HomeGamesPanel home;
	private JTextField search;

	protected CategoryPanel(HomeGamesPanel home){
		this.home=home;
		list=new LoadCategory().getList();
		setBorder(BorderFactory.createBevelBorder(5));
		initialize();
	}


	private void initialize(){
		JPanel panel=new JPanel(new BorderLayout(0,0));
		JPanel top=new JPanel(new FlowLayout(0,0,0));
		JPanel center =new JPanel(new GridLayout(0,1,10,10));
		GButton[]  cButton= new GButton[list.size()];
		JLabel title =new JLabel("Category",SwingConstants.CENTER);
		GButton searchButton=new GButton(new ImageIcon("src//Images//ricerca.png"));
		searchButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					home.update("All",search.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}		
			}
		});
		search=new JTextField(15);
		search.setFont(GFont.getSmallFont());

		title.setFont(GFont.getBigFont());
		title.setForeground(GColor.GREEN_400);
		top.add(search);
		top.add(searchButton);
		center.add(title);
		GButton all=new GButton("All",GColor.BLUE_500,GFont.getBigFont());

		ActionListener click=new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					home.update(e.getActionCommand(),search.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		};
		all.addActionListener(click);
		center.add(all);

		for(int i=0;i<list.size();i++) {
			cButton[i] = new GButton(list.get(i).getName(), GColor.BLUE_500,GFont.getBigFont());
			cButton[i].addActionListener(click);
			center.add(cButton[i]);
		}
		panel.add(top, BorderLayout.NORTH);
		panel.add(center,BorderLayout.CENTER);
		add(panel);
	}

}
