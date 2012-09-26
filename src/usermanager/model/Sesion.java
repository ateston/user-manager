package usermanager.model;

import java.util.ArrayList;
import java.util.List;

import usermanager.util.SHA1;

public class Sesion {

    private String name;
    private String password;
    private List<User> users;
    private User owner;

    public Sesion(String name, String password){
        this.name = name;
        this.password = new SHA1().getHash(password);
        this.users = new ArrayList<User>();
    }

    public void setOwner(User u){
        this.owner = u;
    }

    public User getOwner(){
        return owner;
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
