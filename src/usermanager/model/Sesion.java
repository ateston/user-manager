package usermanager.model;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import usermanager.util.SHA1;

public class Sesion {
	
	private String name;
	private String password;
	private List<User> users;
	
	public Sesion(String name, String password){
		this.name = name;
		try {
			this.password = new SHA1().getHash(password);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.users = new ArrayList<User>();
	}
	
	public String getName(){
		return name;
	}
	
	public String getPassword(){
		return password;
	}
	
	public List<User> getUsersList(){
		return users;
	}
}
