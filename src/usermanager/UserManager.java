package usermanager;

import java.util.ArrayList;
import java.util.List;

import usermanager.model.Device;
import usermanager.model.Sesion;
import usermanager.model.User;
import usermanager.util.Status;

public class UserManager {

    private List<Sesion> sesions = null;
    private Sesion currentSesion = null;

    private User currentUser;
    private Device currentDevice;

    private int STATUS = Status.DISCONNECTED;

    public UserManager(){
        sesions = new ArrayList<Sesion>();
        STATUS = Status.DISCONNECTED;
    }

    public void setUser(User user, Device device){
        this.currentUser = user;
        this.currentDevice = device;
    }

    public Sesion getCurrentSesion(){
        return currentSesion;
    }

    public List<Sesion> getSesions(){
        return sesions;
    }

    public Device getCurrentDevice(){
        return currentDevice;
    }

    public User getCurrentUser(){
        return currentUser;
    }

    public void addSesion(Sesion sesion){
        sesions.add(sesion);
    }

    public void joinSesion(Sesion sesion){
        this.currentSesion = sesion;
        STATUS = Status.CONNECTED;
    }

    public void leaveSesion(Sesion sesion){
        this.currentSesion = null;
        STATUS = Status.DISCONNECTED;
    }

    public void disconnectDevice(Device device) throws NoSuchMethodException{
        //TODO complete this.
        throw new NoSuchMethodException();
    }

    public int getStatus(){
        return STATUS;
    }

    public String getUserMangerStatus(){
        String sesion = "null";
        String user = currentUser.getUsername();
        String device = currentDevice.getMacAddress();
        return "current sesion name: " + sesion + ", current username: " + user + "(" + STATUS + ")" +", current device: " + device;
    }

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

}
