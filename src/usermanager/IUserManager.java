package usermanager;

import usermanager.model.Sesion;

public interface IUserManager {
  
  public void addSesion(Sesion sesion);
  public void joinSesion(Sesion sesion);
  public void leaveSesion(Sesion sesion);

  //Resource Manager
  public void consumptionFinished(int resource_id, String path);
  public void consumptionFailed(int resource_id, String error);
  public void consumptionInterrupted(int resource_id, String error);
  public void consumptionStarted(int resource_id,String[] details);

}
