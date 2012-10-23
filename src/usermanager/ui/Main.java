package usermanager.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import usermanager.UserManager;
import usermanager.model.ComputerDevice;
import usermanager.model.Device;
import usermanager.model.Sesion;
import usermanager.model.User;
import usermanager.util.SHA1;

public class Main {

	static UserManager um = null;
	static SHA1 sha1 = null;

	static InputStreamReader isr;
	static BufferedReader br;

	public static void main(String[] args){
		um = UserManager.getInstance();
		sha1 = new SHA1();
		System.out.println("D>> created user-manager");

		isr = new InputStreamReader(System.in);
		br = new BufferedReader(isr);

		String username = null;
		String password = null;
		System.out.println("Choose username: ");
		try {
			username = br.readLine();
			password = br.readLine();
		} catch (IOException e1) {
			System.out.println("Failed to read input");
		}

		Device device = new ComputerDevice();
		device.setType("computer");
		device.setUid(sha1.getHash("computer"));

		System.out.println("Setting ur device... " + device.getIpAddress() + " " + device.getMacAddress());

		User user = new User(username, password);
		user.getDevices().add(device);

		um.setUser(user, device);

		int option = 0;
		printMenu();
		while(true){
			option = 0;
			System.out.println("Select an option: ");
			try {
				option = Integer.parseInt(br.readLine());
			} catch (IOException e) {
				option = 0;
			} catch (NumberFormatException e){
				option = 0;
			}
			switch(option){
			case 1:
				createSesion();
				break;
			case 2:
				joinSesion();
				break;
			case 3:
				leaveSesion();
				break;
			case 4:
				selectDevice();
				break;
			case 5:
				addDevice();
				break;
			case 6:
				removeDevice();
				break;
			case 7:
				System.exit(0);
				break;
			}

			if(option < 8 && option > 0){
				printMenu();
			}
		}
	}

	public static void printMenu(){
		System.out.println("Menu");
		System.out.println(um.getUserMangerStatus());
		System.out.println("1. Create Sesion");
		System.out.println("2. Join Sesion");
		System.out.println("3. Leave Sesion");
		System.out.println("4. Select active device");
		System.out.println("5. Add dummy device");
		System.out.println("6. Disconnect device");
		System.out.println("7. Exit");
	}

	public static void createSesion(){
		String name = null;
		String password = null;

		System.out.println("Select name for new sesion: ");
		try {
			name = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Select password: ");
		try {
			password = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Creating new sesion...");
		Sesion sesion = new Sesion(name, password);
		um.addSesion(sesion);
		System.out.println("Sesion created!");
	}

	public static void joinSesion(){
		Iterator<Sesion> sesions =  um.getSesionsIterator();
		if(um.getSesionCount() > 0)
			System.out.println("Select sesion to join: ");

		int i = 0;
		while(sesions.hasNext()){
			System.out.println(i + ") " + sesions.next().getName());
		}

		int option = 0;
		while(option != 0 && um.getSesionCount() > 0){
			try {
				option = Integer.parseInt(br.readLine());
			} catch (NumberFormatException | IOException e) {
				System.out.println("An error ocurred when trying to parse option");
				option = 0;
			}

			if(option > 0){
				Sesion sesion = um.getSesion(option);
				System.out.println("Joining sesion of name: " + sesion.getName());
				um.joinSesion(sesion);
				System.out.println("Sesion joined!");
			}
		}
	}

	public static void leaveSesion(){
		if(um.getCurrentSesion() != null){
			um.leaveSesion(um.getCurrentSesion());
			System.out.println("Sesion left.");
		} else{
			System.out.println("You are not connected to a sesion");
		}
	}

	public static void addDevice(){
		String type = null;

		System.out.println("Select the type of device: ");
		try {
			type = br.readLine();
		} catch (IOException e) {
			System.out.println("Failed to get the type of device.");
			e.printStackTrace();
		}

		Device device = new Device();
		device.setType(type);
		device.setUid(new SHA1().getHash(type + (int)300 * Math.random()));

		um.getCurrentUser().getDevices().add(device);
		System.out.println("Added device of type: " + device.getType() + " and uid: " + device.getUid());
	}

	public static void selectDevice(){
		List<Device> devices = um.getCurrentUser().getDevices();
		if(devices.size() > 0)
			System.out.println("Select active device: ");

		for(int i = 0; i < devices.size(); i++){
			System.out.println(i + ") " + devices.get(i).getUid() + " - " + devices.get(i).getType());
		}

		int option = 0;
		while(option != 0 && devices.size() > 0){
			try {
				option = Integer.parseInt(br.readLine());
			} catch (NumberFormatException | IOException e) {
				System.out.println("An error ocurred when trying to parse option");
				option = 0;
			}

			if(option > 0){
				Device device = devices.get(option);
				System.out.println("Selected device of type: " + device.getType());
				um.setUser(um.getCurrentUser(), device);
				System.out.println("Active device changed.");
			}
		}
	}

	public static void removeDevice(){
		List<Device> devices = um.getCurrentUser().getDevices();
		if(devices.size() > 1){
			System.out.println("Select device to remove: ");

			for(int i = 0; i < devices.size(); i++){
				System.out.println(i + ") " + devices.get(i).getUid() + " - " + devices.get(i).getType());
			}

			int option = 0;
			while(option != 0 && devices.size() > 0){
				try {
					option = Integer.parseInt(br.readLine());
				} catch (NumberFormatException | IOException e) {
					System.out.println("An error ocurred when trying to parse option");
					option = 0;
				}

				if(option > 0){
					Device device = devices.get(option);
					System.out.println("Removed device of type: " + device.getType());
					um.getCurrentUser().getDevices().remove(device);
					System.out.println("Device removed.");
				}
			}
		}
		else{
			System.out.println("You cannot remove more devices.");
		}

	}
}
