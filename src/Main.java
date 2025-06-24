import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static Login login = new Login();
	private static Hash hash = new Hash();
	private static MYSQL mysql = new MYSQL("localhost",3306,"passmanager");
	private static String OPassword = mysql.getPassword();
	private static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) throws NoSuchAlgorithmException {
		login();
	}
	
	private static void login() throws NoSuchAlgorithmException {
		String userPassword = "";
		if(OPassword == "NoPassword") {
			newPassword();
		}else {
			userPassword = login.LoginMenu();
		}
		
		if(hash.Hashing(userPassword).equals(OPassword)) {
			menu();
		}else {
			System.out.println("Wrong Password try again!");
			login();
		}
	}
	
	private static void menu() {
		System.out.println("[1] see Passwords");
		System.out.println("[2] add Password");
		System.out.println("[3] delete password");
		String eingabe = scan.next();
		switch(eingabe) {
		case "1":
			seePasswords();
			break;
		case "2":
			addPassword();
			break;
		case "3":
			deletePassword();
			break;
		}
		menu();
	}
	
	private static void seePasswords() {
		ArrayList<String> Password = mysql.seePasswords();
		ArrayList<String> PasswordID = mysql.seePasswordsID();
		for(int i = 0; i < Password.size(); i++) {
			System.out.println("ID: " + PasswordID.get(i) + " Password: " + Password.get(i));
		}
	}
	
	private static void addPassword() {
		System.out.print("Password: ");
		String password = scan.next();
		mysql.executeQuery("INSERT INTO passwords (Password) VALUES ('" + password +"');");
	}
	
	private static void deletePassword() {
		seePasswords();
		System.out.println("ID to delete (If you want to go back write: back)");
		System.out.print("ID: ");
		String eingabe = scan.next();
		mysql.executeQuery("DELETE FROM passwords WHERE idPassword = " + eingabe + ";");
	}
	
	private static void newPassword() throws NoSuchAlgorithmException {
		System.out.print("Set Password: ");
		String eingabe = scan.next();
		mysql.executeQuery("INSERT INTO login (password) VALUES ('" + hash.Hashing(eingabe) + "');");
		menu();
	}

}
