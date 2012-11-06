package usermanager.bridge;

public interface ICommBridge {

	//Conectarse:
	//1- Primero le prgunto a Comunicacion si existe alguna sesi—n activa.
	//Comunication.anyActiveSession() --> retorna un bool
	//2- Si se retorna true entonces se le pide conectarse a la sesion.
	//Comunication.connectToSession()
	//Comunicacion se comunica con Comunicacion de otro dispositivo
	//2- Este ultimo le pide la sesion actual a UserManager y la envia
	public Object getCurrentSession();
	//3- En caso de que le llege, se asigna la sesion
	public void setSession(Object session);
	// pero si hay error le avisa a traves de este metodo
	public void connectionError();
	
	//Desconectarse:
	//1-Se llama a un metodo de comunicacion entregandole un string con el username o un id del usuario
	//Comunication.disconectUser(currentUser)
	//Comunicacion se comunica con Comunicacion de los otros dispositivo
	//2-Comunicacion(de los otros dispositvos) les comunican a sus respectivos UserManagers que se desconecta el ususrio
	public void disconnectUser(String user);
	
	
	//Cambio en algun User
	//1- UserManger notific‡ a Comunicacion de algun cambio ocurrido al User del dispositivo, entregandole la instancia de este como Object
	//Comunication.currentUserChanged(currentUser)
	//2- Comunicacion le env’a este Objeto al resto de los dispositivos
	//3- Al llegar a algun dispositivo, Comunicacion llama a una metodo de User Manager para que este actualize a este usuario
	public void updateUser(Object updatedUser);
	
	
}
