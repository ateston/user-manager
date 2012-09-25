package usermanager;

import java.util.ArrayList;
import java.util.List;

import usermanager.model.Device;
import usermanager.model.Sesion;
import usermanager.model.User;

public class UserManager {
	
	private List<Sesion> sesions = null;
	private Sesion currentSesion = null;
	
	public UserManager(){
		sesions = new ArrayList<Sesion>();
	}
	
	public Sesion getCurrentSesion(){
		return currentSesion;
	}
	
	public List<Sesion> getSesions(){
		return sesions;
	}
	
	public void addSesion(Sesion sesion){
		sesions.add(sesion);
	}
	
	public void joinSesion(Sesion sesion){
		this.currentSesion = sesion;
	}
	
	public void disconnectUser(User user){
		//TODO complete this.
	}
	
	public void disconnectDevice(Device device){
		//TODO complete this.
	}
	
}
