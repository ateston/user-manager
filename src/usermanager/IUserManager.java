package usermanager;

import usermanager.model.Sesion;

public interface IUserManager {
    
    public void addSesion(Sesion sesion);
    public void joinSesion(Sesion sesion);
    public void leaveSesion(Sesion sesion);

}
