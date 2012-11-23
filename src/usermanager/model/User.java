package usermanager.model;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username = null;
    private int id;
    private String password = null;
    private List<Resource> resources;

    /**
     * Constructor for user, receives the username and password.
     * 
     * @param username
     *            username of the user.
     * @param password
     *            password of the user.
     */
    public User() {
        // this.username = username;
        // this.password = new SHA1().getHash(password);
        SecureRandom random = new SecureRandom();
        this.id = random.nextInt();
        this.resources = new ArrayList<Resource>();
    }

    public int getId() {
        return id;
    }

    /**
     * Returns the user's username.
     * 
     * @return user's username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Returns the password of the user.
     * 
     * @return password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Returns the list of devices for this user.
     * 
     * @return the list of devices.
     */
    public List<Resource> getResources() {
        return this.resources;
    }
    
    
    public void updateResources(){
    	
    }
}
