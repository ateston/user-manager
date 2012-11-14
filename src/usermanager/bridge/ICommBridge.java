package usermanager.bridge;

public interface ICommBridge {

	/**
	 * Returns the actual session as an object. If its not connected to any session, the return value will be null.
	 * @return session Object.
	 */
	public Object getCurrentSession();
	
	/**
	 * Sets the session as the actual session
	 * @params Object session to set as actual session  .
	 */
	public void setSession(Object session);
	
	/**
	 * Notify error on connection
	 * @params string error.
	 */
	public void connectionError(String error);
	
	/**
	 * Disconnects a user from the actual session.
	 * @params string username of the user to disconnect.
	 */
	public void disconnectUser(String user);
	
	/**
	 * Updates user information.
	 * @params Object updatedUser.
	 */
	public void updateUser(Object updatedUser);
	
	
}
