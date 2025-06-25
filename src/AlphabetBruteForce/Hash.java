package AlphabetBruteForce;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

	public static String Hashing(String password) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA256");
		byte[] messagedigest = md.digest(password.getBytes());
		BigInteger bigInt = new BigInteger(1,messagedigest);
		return bigInt.toString(16);
	}
	
}