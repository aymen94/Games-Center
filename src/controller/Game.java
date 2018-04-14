package controller;

import java.math.BigDecimal;

public class Game {
    private int id,copieDisponibili;
    private String title,img;
    private BigDecimal price;

    public Game(int id, String title, String img, BigDecimal price, int copie) {
        this.id = id;
        this.title = title;
        this.img = img;
        this.price = price;
        this.copieDisponibili=copie;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
		this.price = price;
	}

    public String getImg() {
        return img;
    }

	public int getCopieDisponibili() {
		return copieDisponibili;
	}

	public void setCopieDisponibili(int copieDisponibili) {

		this.copieDisponibili = copieDisponibili;
	}
}