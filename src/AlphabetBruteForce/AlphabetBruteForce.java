package AlphabetBruteForce;

import java.security.NoSuchAlgorithmException;

public class AlphabetBruteForce {
	static char[] alphabet;
	private static Hash hash = new Hash();
	
	public static String bruteForceSmallLetters(String hashCode) {
		alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		int n = 3;
		int[] indices = new int[n];

		while (true) {
		    StringBuilder sb = new StringBuilder();
		    for (int i = 0; i < n; i++) {
		        sb.append(alphabet[indices[i]]);
		    }
		    String hashCandidate = "";
		    String candidate = sb.toString();
		    try {
				hashCandidate = Hash.Hashing(candidate);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		    if(hashCandidate.equals(hashCode)) {
		    	return candidate;
		    }
		    System.out.println(candidate + " " + hashCandidate);

		    int pos = n - 1;
		    while (pos >= 0) {
		        indices[pos]++;
		        if (indices[pos] < alphabet.length) {
		            break;
		        } else {
		            indices[pos] = 0;
		            pos--;
		        }
		    }

		    if (pos < 0) {
		    	n++;
		    	indices = new int[n];
		    }
		}
	}

	public static String bruteForceBigLetters(String hashCode) {
		alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		int n = 3;
		int[] indices = new int[n];

		while (true) {
		    StringBuilder sb = new StringBuilder();
		    for (int i = 0; i < n; i++) {
		        sb.append(alphabet[indices[i]]);
		    }
		    String hashCandidate = "";
		    String candidate = sb.toString();
		    try {
				hashCandidate = Hash.Hashing(candidate);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		    if(hashCandidate.equals(hashCode)) {
		    	return candidate;
		    }
		    System.out.println(candidate + " " + hashCandidate);

		    int pos = n - 1;
		    while (pos >= 0) {
		        indices[pos]++;
		        if (indices[pos] < alphabet.length) {
		            break;
		        } else {
		            indices[pos] = 0;
		            pos--;
		        }
		    }

		    if (pos < 0) {
		    	n++;
		    	indices = new int[n];
		    }
		}
	}

	public static String bruteForceNumberLetters(String hashCode) {
		alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		int n = 3;
		int[] indices = new int[n];

		while (true) {
		    StringBuilder sb = new StringBuilder();
		    for (int i = 0; i < n; i++) {
		        sb.append(alphabet[indices[i]]);
		    }
		    String hashCandidate = "";
		    String candidate = sb.toString();
		    try {
				hashCandidate = Hash.Hashing(candidate);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		    if(hashCandidate.equals(hashCode)) {
		    	return candidate;
		    }
		    System.out.println(candidate + " " + hashCandidate);

		    int pos = n - 1;
		    while (pos >= 0) {
		        indices[pos]++;
		        if (indices[pos] < alphabet.length) {
		            break;
		        } else {
		            indices[pos] = 0;
		            pos--;
		        }
		    }

		    if (pos < 0) {
		    	n++;
		    	indices = new int[n];
		    }
		}
	}
}