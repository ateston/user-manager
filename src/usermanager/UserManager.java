package usermanager;
import usermanager.bridge.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import usermanager.model.Device;
import usermanager.model.Sesion;
import usermanager.model.User;
import usermanager.util.Status;

public class UserManager implements IUserManager, ICommBridge, Serializable {

    private static final long serialVersionUID = 1L;
    
    private List<Sesion> sesions = null;
	private Sesion currentSesion = null;

	private User currentUser;
	private Device currentDevice;
	
	private static UserManager um;
	
	public static UserManager getInstance(){
	    if(um == null){
	        um = new UserManager();
	    }
	    return um;
	}

	private int STATUS = Status.DISCONNECTED;

	/**
	 * Constructor of user manager, inititalizes the list of sesions and sets default status (disconnected).
	 */
	private UserManager(){
		sesions = new ArrayList<Sesion>();
		STATUS = Status.DISCONNECTED;
	}

	/**
	 * Sets the user and device for this user manager.
	 * @param user user for this user manager.
	 * @param device device for this user manager. 
	 */
	public void setUser(User user, Device device){
		this.currentUser = user;
		this.currentDevice = device;
	}

	/**
	 * Returns the current sesion.
	 * @return the current sesion.
	 */
	public Sesion getCurrentSesion(){
		return currentSesion;
	}

	/**
	 * Returns the list of sesions available.
	 * @return list of sesions.
	 */
	public Iterator<Sesion> getSesionsIterator(){
		return sesions.iterator();
	}
	
	public int getSesionCount(){
	    return sesions.size();
	}
	
	public Sesion getSesion(int index){
	    return sesions.get(index);
	}

	/**
	 * Returns the current device.
	 * @return current device.
	 */
	public Device getCurrentDevice(){
		return currentDevice;
	}

	/**
	 * Returns the current user.
	 * @return the current user.
	 */
	public User getCurrentUser(){
		return currentUser;
	}

	/**
	 * Adds a sesion for this user manager.
	 * @param sesion sesion to add.
	 */
	public void addSesion(Sesion sesion){
		sesions.add(sesion);
	}

	/**
	 * Switches the current sesion for the sesion given.
	 * @param sesion sesion given to switch.
	 */
	public void joinSesion(Sesion sesion){
		this.currentSesion = sesion;
		STATUS = Status.CONNECTED;
	}

	/**
	 * Leaves the current sesion.
	 * @param sesion sesion to leave.
	 */
	public void leaveSesion(Sesion sesion){
		this.currentSesion = null;
		STATUS = Status.DISCONNECTED;
	}

	/**
	 * Disconnects the device.
	 * @param device device for disconnect.
	 * @throws NoSuchMethodException not implemented yet.
	 */
	public void disconnectDevice(Device device) throws NoSuchMethodException{
		//TODO complete this.
		throw new NoSuchMethodException();
	}

	/**
	 * Returns the status of user manager.
	 * @return status code.
	 * @see usermanager.util.Status usermanager.util.Status for values.
	 */
	public int getStatus(){
		return STATUS;
	}

	/**
	 * Returns a string status of the user manager (for logging).
	 * @return String indicating the status of the user manager.
	 */
	public String getUserMangerStatus(){
		String sesion = "null";
		String user = currentUser.getUsername();
		String device = currentDevice.getMacAddress();
		return "current sesion name: " + sesion + ", current username: " + user + "(" + STATUS + ")" +", current device: " + device;
	}

	/**
	 * Returns a string indicating the status of the user manager.
	 * @return status string.
	 */
	public String getStringStatus(){
		switch(STATUS){
		case Status.CONNECTED:
			return "connected";
		case Status.DISCONNECTED:
			return "disconnected";
		case Status.CONNECTING:
			return "connecting";
		case Status.UPDATED:
			return "updated";
		case Status.UPDATING:
			return "updating";
		}
		return null;
	}

	@Override
	public Object getCurrentSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSession(Object session) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void connectionError(String error) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disconnectUser(String user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(Object updatedUser) {
		// TODO Auto-generated method stub
		
	}

}
