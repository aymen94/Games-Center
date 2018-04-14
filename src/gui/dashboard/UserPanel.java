package gui.dashboard;

import component.GButton;
import component.GColor;
import controller.Deposit;
import controller.Session;
import gui.TitlePanel;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.SQLException;

@SuppressWarnings("serial")
public class UserPanel extends JPanel {
	private GButton settingB,buyCoin;
	private static JLabel coin;

	public static JLabel getCoin() {
		return coin;
	}

	public static void refreshCoin() {
		coin.setText(String.format("%.2f",Session.getUser().getCoin().doubleValue()));
	}

	protected  UserPanel(){
		add(new TitlePanel());
		userPanel();
		deposit();
		setting();
	}
	private void userPanel(){
		JPanel panelInfo=new JPanel();
		JLabel imageL,nameL,coinL;
		settingB=new GButton(new ImageIcon("src//Images//setting.png"));
		buyCoin=new GButton("Buy Coin",GColor.GREEN_400);
		imageL=new JLabel(new ImageIcon("src//Images//user.png"));
		imageL.setBorder(BorderFactory.createLineBorder(GColor.BLACK));
		nameL=new JLabel("Name: "+ Session.getUser().getName()+" "+Session.getUser().getLastName());
		coinL=new JLabel("Coin: ");
		coin=new JLabel(String.format("%.2f",Session.getUser().getCoin().doubleValue()));
		panelInfo.add(imageL);
		panelInfo.add(nameL);
		panelInfo.add(coinL);
		panelInfo.add(coin);
		panelInfo.add(buyCoin);
		panelInfo.add(settingB);
		panelInfo.setBorder(BorderFactory.createLineBorder(GColor.BLACK));
		add(panelInfo, BorderLayout.NORTH);
	}

	private void deposit(){
		buyCoin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Deposit deposit = new Deposit(Double.parseDouble(JOptionPane.showInputDialog("Insert the amount to be deposited")));
					if (deposit.insert()) {
						JOptionPane.showMessageDialog(null, "Deposit success", "Deposit success", JOptionPane.INFORMATION_MESSAGE);
						BigDecimal price=BigDecimal.valueOf(Session.getUser().getCoin().doubleValue() + deposit.getDeposit().doubleValue());
                        price.setScale(2,BigDecimal.ROUND_HALF_UP);
						Session.getUser().setCoin(price);
						refreshCoin();
					} else
						JOptionPane.showMessageDialog(null, "Insert positive number", "Deposit Error", JOptionPane.ERROR_MESSAGE);
				}catch (NumberFormatException | HeadlessException | SQLException err){
					JOptionPane.showMessageDialog(null,"Insert numeric format","Error format",JOptionPane.ERROR_MESSAGE);

				}
			}
		});

	}

	private void setting(){
		settingB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SettingFrame().setVisible(true);
			}
		});
	}
}
