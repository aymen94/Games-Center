package gui.dashboard;

import component.GButton;
import component.GColor;
import controller.BuyGame;
import dbconnection.Config;
import controller.Game;
import controller.Invoice;
import controller.Session;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.SQLException;

@SuppressWarnings("serial")
public class GamePanel extends JPanel{
        private Game g;
        private boolean buy;

    protected GamePanel(Game g,boolean buy) {
        this.g=g;
        this.buy=buy;
        setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
        setBorder(BorderFactory.createRaisedBevelBorder());
        title();
        img();
        JLabel price =new JLabel(String.valueOf(g.getPrice()) + "€",SwingConstants.CENTER);
        //price.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        JPanel panel=new JPanel(new BorderLayout());
        panel.add(price);
        add(panel);
        add(bInfo());
    }

    private void title(){
        JPanel panel =new JPanel();
        panel.add(new JLabel(g.getTitle()));
        add(panel);
    }

    private void img() {
        JPanel panel = new JPanel();
        ImageIcon img = new ImageIcon(Config.PATH_SOURCE + g.getImg());
        Image image = img.getImage();
        panel.add(new JLabel(new ImageIcon(image.getScaledInstance(140, 220, Image.SCALE_SMOOTH))));
        add(panel);
}

    private JPanel bInfo(){
        JPanel panel =new JPanel();
        GButton info =new GButton("More info",GColor.BLUE_500);

        info.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
					new GameInfoFrame(g).setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });

        panel.add(info);
        if(buy) {
            panel.add(buttonBuy());
        }else
        {
            panel.add(buttonDownload());
            panel.add(buttonInvoice());
        }

        return panel;
    }
    private JPanel buttonBuy(){
        JPanel panel =new JPanel();
        GButton buyB =new GButton("Buy", GColor.GREEN_300);
        
        if(g.getCopieDisponibili()<=0)
      	   buyB.setEnabled(false);
        
        buyB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(JOptionPane.showConfirmDialog(null,"you really want to buy: "+g.getTitle())==JOptionPane.YES_OPTION) {
                    try {
                        BigDecimal price=BigDecimal.valueOf(Session.getUser().getCoin().doubleValue() - g.getPrice().doubleValue());
                        price.setScale(2,BigDecimal.ROUND_HALF_UP);
                        if(price.doubleValue()>=0) {
                            new BuyGame(g);
                            Session.getUser().setCoin(price);
                            UserPanel.refreshCoin();
                            g.setCopieDisponibili(g.getCopieDisponibili()-1);
                            if(g.getCopieDisponibili()<=0)
                           	   buyB.setEnabled(false);
                        }else
                            JOptionPane.showMessageDialog(null,"you do not have enough money.","Deposit Coin",JOptionPane.ERROR_MESSAGE);
                    } catch (SQLException e1) {
                        JOptionPane.showMessageDialog(null,"you have already purchased this game.","Purchased game",JOptionPane.INFORMATION_MESSAGE);
                    }
                }

            }
        });
        panel.add(buyB);
    return panel;

    }
    private JPanel buttonDownload(){
        JPanel panel =new JPanel();
        GButton download =new GButton("Download",GColor.GREEN_400);
        download.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(download,"This is only demo :)","Download"+g.getTitle(),JOptionPane.INFORMATION_MESSAGE);
            }
        });
        panel.add(download);
        return panel;
    }
    
    private JPanel buttonInvoice(){
        JPanel panel =new JPanel();
        GButton invoice =new GButton("Invoice",GColor.RED_300);
        invoice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
					Invoice bill=Invoice.mysqlInvoice(Session.getUser().getId(), g.getId());
	                JOptionPane.showMessageDialog(invoice,"Invoice number: "+bill.getNumber() +"\nProduct: " + bill.getProduct() + "\nPrice: " + bill.getPrice() +"\nDate: "+ bill.getDate(),"Invoice "+bill.getNumber(),JOptionPane.INFORMATION_MESSAGE);

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
        panel.add(invoice);
        return panel;
    }
}
