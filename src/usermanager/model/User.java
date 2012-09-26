package usermanager.model;

import java.util.ArrayList;
import java.util.List;

import usermanager.util.SHA1;

public class User {
    private String username = null;
    private String password = null;
    private List<Device> devices;

    public User(String username, String password){
        this.username = username;
        this.password = new SHA1().getHash(password);
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
