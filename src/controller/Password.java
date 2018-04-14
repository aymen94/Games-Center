package controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class Password {
	
	public Password(char[] password) throws NoSuchAlgorithmException{
		 MessageDigest crypt = MessageDigest.getInstance("SHA-256");
         byte[] b =crypt.digest(String.valueOf(password).getBytes());
         hash= DatatypeConverter.printHexBinary(b);
         
         //destroy password
		for(int i=0;i<password.length;i++)
				password[i]=0;
	}

	public boolean checkPass(Password second)
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
	
	String hash;
}
