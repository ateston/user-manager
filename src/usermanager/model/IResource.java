package usermanager.model;

import java.io.Serializable;

import usermanager.bridge.IResourceManagerBridge;

public interface IResource {

	public boolean isAvailable();
	public void cancelConsumption();
	public void setObserver(IConsumptionObs observer);
	public boolean recieveAction(int action_id, String[] param);
	public int getStatus();
	public void setId(int id);

}