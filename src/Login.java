import java.util.Scanner;

public class Login {
	public Login() {}
	
	public String LoginMenu() {
		System.out.println("Login");
		System.out.println("____________");
		System.out.print("password: ");
		Scanner scan = new Scanner(System.in);
		return scan.next();
	}
}
