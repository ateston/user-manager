package usermanager.model;

public class Device {

	protected String type = null;
	protected String uid = null;
	
	public Device(){
		
	}
	
	public void setType(String type){
		this.type = type;
	}
	
	public void setUid(String uid){
		this.uid = uid;
	}
	
	public String getType(){
		return type;
	}
	
	public String getUid(){
		return uid;
	}
	
	public Object getResourceManager(){
		//TODO complete this.
		return null;
	}
}
