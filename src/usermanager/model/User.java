package usermanager.model;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import usermanager.util.SHA1;

public class User {
	private String username = null;
	private String password = null;
	private List<Device> devices;
	
	public User(String username, String password){
		this.username = username;
		try {
			this.password = new SHA1().getHash(password);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.devices = new ArrayList<Device>();
	}
	
	public String getUsername(){
		return username;
	}
	
	public String getPassword(){
		return password;
	}
	
	public List<Device> getDevices(){
		return devices;
	}
	
	public void addDevice(Device device){
		devices.add(device);
	}
}
