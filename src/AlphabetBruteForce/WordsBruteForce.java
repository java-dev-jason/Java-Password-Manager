package AlphabetBruteForce;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class WordsBruteForce {
	private static Hash hash = new Hash();
	private static File textFile = new File("src/Words.txt");
	private static Scanner scan;
	
	public WordsBruteForce() {
	}
	
	public static String brute(String HashCode) throws Exception {
		scan = new Scanner(textFile);
		while(scan.hasNext()) {
			String word = scan.next();
			String wordHashed = hash.Hashing(word);
			System.out.println(word + " " + wordHashed);
			
			if(HashCode.equals(wordHashed)) {
				return word;
			}
		}
		
		return "NotFound";
	}
}
