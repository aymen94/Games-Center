package controller;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbconnection.Query;

public class DetailedGame extends Game {

	public static DetailedGame mysqlDetailedGame(int id) throws SQLException
	{
		ResultSet rs=Query.infoGame(id).executeQuery();
		rs.next();
		String titolo=rs.getString("titolo");
		BigDecimal prezzo=rs.getBigDecimal("prezzo");
		String img=rs.getString("cover");
		String desc=rs.getString("Prodotto.descrizione");
		Short year=rs.getShort("anno");
		String cat=rs.getString("Categoria.nome");
		String pegi=rs.getString("Pegi.icona"); 
		int cv=rs.getInt("copie_vendute");
		int cd=rs.getInt("copie_disponibili");
		String pro=rs.getString("Produttore.nome");
		int views= rs.getInt("Visualizzazioni");
		boolean type=rs.getBoolean("tipo");
		ArrayList<String> lingue= new ArrayList<String>();
		do {
			lingue.add(
					rs.getString("Lingua.nome"));
		}while(rs.next());
		return new DetailedGame(id, titolo, prezzo, img, desc, year, cat, lingue, pegi, cv, cd, cv+cd, pro,views,type);
	}

	public DetailedGame(int id, String title, BigDecimal price, String img, String description, short year,
			String categoria, ArrayList<String> lingua, String pegi, int copieVendute, int copieDisponibili, int copieTotali, String produttore, int visualizzazioni, boolean type) {
		super(id, title,img,price,copieDisponibili);
		this.pegi=pegi;
		this.type=type;
		this.produttore=produttore;
		this.categoria=categoria;
		this.description=description;
		this.year=year;
		this.lingua= lingua;
		this.copieVendute = copieVendute;
		this.copieTotali = copieTotali;
		this.visualizzazioni=visualizzazioni;
	}

	public int getVisualizzazioni() {
		return visualizzazioni;
	}

	public void setVisualizzazioni(int visualizzazioni) {
		this.visualizzazioni = visualizzazioni;
	}

	public void setCopieDisponibili(int copieDisponibili) {

		this.copieTotali+=copieDisponibili-getCopieDisponibili();
		setCopieDisponibili(copieDisponibili);
	}

	public ArrayList<String> getLingua() {
		return lingua;
	}

	public void setLingua(ArrayList<String> lingua) {
		this.lingua = lingua;
	}

	public int getCopieVendute() {
		return copieVendute;
	}

	public void setCopieVendute(int copieVendute) {
		this.copieVendute = copieVendute;
	}

	public int getCopieTotali() {
		return copieTotali;
	}

	public String getLinguaString()
	{
		String lingue=new String();
		if(lingua.size()>0)
		{
			lingue=lingua.get(0);
			for(int i=1; i<lingua.size(); i++)
				lingue+=", " + lingua.get(i);
		}
		return lingue;
	}

	public BigDecimal getNewPrice() {

		try
		{
			long price=getPrice().longValueExact();
			return calculatePrice(price);
		}
		catch(ArithmeticException e)
		{
			double price=getPrice().doubleValue();
			return calculatePrice(price);
		}
	}

	private BigDecimal calculatePrice(long price)
	{
		if(visualizzazioni>=100)
			if(copieVendute<=100)
				return BigDecimal.valueOf(price-price*0.1).setScale(2,BigDecimal.ROUND_HALF_UP);
			else
				return BigDecimal.valueOf(price+price*0.15).setScale(2,BigDecimal.ROUND_HALF_UP);
		else
			if(copieVendute<=100)
				return BigDecimal.valueOf(price-price*0.02).setScale(2,BigDecimal.ROUND_HALF_UP);
			else
				return BigDecimal.valueOf(price+price*0.01).setScale(2,BigDecimal.ROUND_HALF_UP);
	}

	private BigDecimal calculatePrice(double price)
	{
		if(visualizzazioni>=100)
			if(copieVendute<=100)
				return BigDecimal.valueOf(price-price*0.1).setScale(2,BigDecimal.ROUND_HALF_UP);
			else
				return BigDecimal.valueOf(price+(price*0.15)).setScale(2,BigDecimal.ROUND_HALF_UP);
		else
			if(copieVendute<=100)
				return BigDecimal.valueOf(price-price*0.02).setScale(2,BigDecimal.ROUND_HALF_UP);
			else
				return BigDecimal.valueOf(price+price*0.01).setScale(2,BigDecimal.ROUND_HALF_UP);
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public boolean getType() {
		return type;
	}

	public String getPegi() {
		return pegi;
	}

	public void setPegi(String pegi) {
		this.pegi = pegi;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getProduttore() {
		return produttore;
	}

	public void setProduttore(String produttore) {
		this.produttore = produttore;
	}

	public void setCopieTotali(int copieTotali) {
		this.copieTotali = copieTotali;
	}

	private ArrayList<String> lingua;
	private int copieVendute,year,copieTotali, visualizzazioni;
	private boolean type;
	private String pegi,description,categoria,produttore;
}
