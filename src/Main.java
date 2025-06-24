import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
	private static Login login = new Login();
	private static Hash hash = new Hash();
	private static MYSQL mysql = new MYSQL("localhost",3306,"passmanager");
	private static AESCoder aes;
	private static String OPassword = mysql.getPassword();
	private static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		keyGenerator();
		login();
	}
	
	private static void login() throws Exception {
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
	
	private static void menu() throws Exception {
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
	
	private static void seePasswords() throws Exception {
		ArrayList<String> Password = mysql.seePasswords();
		ArrayList<String> PasswordID = mysql.seePasswordsID();
		for(int i = 0; i < Password.size(); i++) {
			System.out.println("ID: " + PasswordID.get(i) + " Password: " + aes.decrypt(Password.get(i)));
		}
	}
	
	private static void keyGenerator() throws Exception {
		File Data = new File("src/Key.txt");
		Scanner FileScanner = null;
		try {
			FileScanner = new Scanner(Data).useLocale(Locale.US);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		if(FileScanner.hasNext()) {
			aes = new AESCoder(FileScanner.next());
		}else {
			aes = new AESCoder(null);
		}
	}
	
	private static void addPassword() throws Exception {
		System.out.print("Password: ");
		String password = scan.next();
		mysql.executeQuery("INSERT INTO passwords (Password) VALUES ('" + aes.encrypt(password) +"');");
	}
	
	private static void deletePassword() throws Exception {
		seePasswords();
		System.out.println("ID to delete (If you want to go back write: back)");
		System.out.print("ID: ");
		String eingabe = scan.next();
		mysql.executeQuery("DELETE FROM passwords WHERE idPassword = " + eingabe + ";");
	}
	
	private static void newPassword() throws Exception {
		System.out.print("Set Password: ");
		String eingabe = scan.next();
		mysql.executeQuery("INSERT INTO login (password) VALUES ('" + hash.Hashing(eingabe) + "');");
		menu();
	}

}
