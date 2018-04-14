package dbconnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public  class Query {

    //client
    public static final String buyGame="INSERT INTO acquisto(cliente,prodotto,n_fattura,prezzo) VALUES(?,?,?,?)";
    public static final String withdraw="UPDATE cliente SET saldo=saldo-? WHERE id=?";
    public static final String product="UPDATE prodotto SET copie_disponibili=copie_disponibili-1, copie_vendute=copie_vendute+1 WHERE cod_prodotto=?";
    public static final String buyCoin="UPDATE Cliente SET saldo=saldo+? where id=?";
    public static final String getFamilyID ="select count(*)from cliente where family_id=?";
    public static final String setFamilyID="UPDATE Cliente SET family_id=? where id=?";
    public static final String getInvoice="SELECT titolo,_data,n_fattura,Acquisto.prezzo From Acquisto,prodotto WHERE cliente=? and prodotto=?";
    public static final String category="SELECT * FROM categoria";
    public static final String login="SELECT * FROM cliente WHERE email= ? and password= ?";
    public static final String register="INSERT INTO Cliente (nome,cognome,email,data_nascita,password) VALUES(?,?,?,?,?)";
    public static final String user="SELECT email,nome,cognome,saldo, data_nascita, password,family_id from cliente WHERE id=?";

    public static PreparedStatement topGames() throws SQLException {
        String _query="SELECT cod_prodotto,titolo FROM Prodotto WHERE tipo=1 ORDER BY copie_vendute DESC LIMIT 10";
        return ConnectDB.getConnection().prepareStatement(_query);
    }

    public static PreparedStatement userGames() throws SQLException {
        String _query="SELECT cod_prodotto, titolo, cover,Prodotto.prezzo,copie_disponibili FROM Acquisto, Prodotto WHERE cod_prodotto=prodotto AND cliente=?";
        return ConnectDB.getConnection().prepareStatement(_query);
    }


    public static PreparedStatement infoGame(int id) throws SQLException
    {
    	  String _query= ("SELECT titolo, Prodotto.descrizione, cover, prezzo, anno, Categoria.nome, Lingua.nome, Pegi.icona, copie_disponibili, copie_vendute, Produttore.nome,visualizzazioni as Visualizzazioni, tipo\n" +
					"FROM Prodotto LEFT JOIN Pegi ON pegi=Pegi.id LEFT JOIN categoria ON categoria=categoria.id, Lingua,produttore \n" +
			"where cod_prodotto=" + id + " AND produttore=sigla AND lingua.id IN (SELECT lingua from Traduzione where prodotto=cod_prodotto)");
			return ConnectDB.getConnection().prepareStatement(_query);
    }

}
