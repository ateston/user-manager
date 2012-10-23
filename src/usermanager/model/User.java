package usermanager.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import usermanager.util.SHA1;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String username = null;
    private String password = null;
    private List<Device> devices;

    /**
     * Constructor for user, receives the username and password.
     * @param username username of the user.
     * @param password password of the user.
     */
    public User(String username, String password){
        this.username = username;
        this.password = new SHA1().getHash(password);
        this.devices = new ArrayList<Device>();
    }

    /**
     * Returns the user's username.
     * @return user's username.
     */
    public String getUsername(){
        return username;
    }

    /**
     * Returns the password of the user.
     * @return password of the user.
     */
    public String getPassword(){
        return password;
    }

    /**
     * Returns the list of devices for this user.
     * @return the list of devices.
     */
    public List<Device> getDevices(){
        return devices;
    }
}