package controller;

import javax.swing.JOptionPane;
import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GPassword {

    public GPassword(char[] password){
        MessageDigest crypt = null;
        try {
            crypt = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e){
            JOptionPane.showMessageDialog(null, "Internal Error: error sha256 ", "Internal error", 0);
        }
        byte[] b =crypt.digest(String.valueOf(password).getBytes());
        hash= DatatypeConverter.printHexBinary(b);

        //destroy password
        System.gc();
    }

    public boolean checkPass(GPassword second)
    {
        return hash.equals(second.getHash());
    }
    public boolean checkPass(String second)
    {
        return hash.equals(second);
    }

    public String getHash()
    {
        return hash;
    }

    private String hash;
}

