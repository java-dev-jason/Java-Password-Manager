import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AESCoder {
	private static SecretKey secretkey;
	private static Cipher deCipher;
	private static Cipher enCipher;
	
	public AESCoder(String base64Key) throws Exception {
		enCipher = Cipher.getInstance("AES");
		deCipher = Cipher.getInstance("AES");
		
		if (base64Key == null || base64Key.isEmpty()) {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(256);
            secretkey = keyGenerator.generateKey();
        } else {
            byte[] decodedKey = Base64.getDecoder().decode(base64Key);
            secretkey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
        }
		
		enCipher.init(Cipher.ENCRYPT_MODE, secretkey);
		deCipher.init(Cipher.DECRYPT_MODE, secretkey);
	}
	
	public static String encrypt(String Text) throws Exception {
		byte[] encryptedBytes = enCipher.doFinal(Text.getBytes());
		return Base64.getEncoder().encodeToString(encryptedBytes);
	}
	
	public static String decrypt(String cryptedText) throws Exception {
		byte[] decryptedBytes = deCipher.doFinal(Base64.getDecoder().decode(cryptedText));
		return new String(decryptedBytes);
	}
	
	
}
