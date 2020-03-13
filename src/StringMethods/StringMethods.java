package StringMethods;

import java.util.Arrays;
import java.util.Base64;

/*
Visit the JavaDocs for the String class to view everything you can do with a String.  


HINT:  Here are some String methods you might find useful
charAt 
contains
replace
trim
length
getBytes
endsWith
split 
indexOf
lastIndexOf
compareTo(IgnoreCase)
substring


Here are some Character methods you might find useful:
Character.toLowerCase(char c);
Character.isLetter(char c);
Character.isDigit(char c);
Character.getNumericValue(char c);
 */

public class StringMethods {

	// Given Strings s1 and s2, return the longer String
	public static String longerString(String s1, String s2) {

		if (s1.length() > s2.length()) {
			return s1;
		} else {
			return s2;
		}
	}

	// if String s contains the word "underscores", change all of the spaces to
	// underscores
	public static String formatSpaces(String s) {
		if (s.contains("underscores")) {
			s = s.replace(" ", "_");

		}
		return s;
	}

	// Return the name of the person whose LAST name would appear first if they were
	// in alphabetical order
	// You cannot assume there are no extra spaces around the name, but you can
	// assume there is only one space between the first and last name
	public static String lineLeader(String s1, String s2, String s3) {
		s1 = s1.trim();
		String[] a = s1.split(" ");
		s2 = s2.trim();
		String[] b = s2.split(" ");
		s3 = s3.trim();
		String[] c = s3.split(" ");
		int f = a[1].compareToIgnoreCase(b[1]);
		int g = a[1].compareToIgnoreCase(c[1]);
		int x = b[1].compareToIgnoreCase(a[1]);
		int y = b[1].compareToIgnoreCase(c[1]);
		int t = c[1].compareToIgnoreCase(a[1]);
		int j = c[1].compareToIgnoreCase(b[1]);
		if (f < 0 && g < 0) {

			return s1;
		}else if(x<0&&y<0) {
			return s2;
		}else {
			return s3;
		}
		
	}

	// Return the sum of all numerical digits in the String
	public static int numeralSum(String s) {
		int total=0;
		for (int i = 0; i < s.length(); i++) {
			char e=s.charAt(i);
			if(Character.isDigit(e)==true) {
				int w=Integer.parseInt(e+"");
				total+=w;
			}
		}
		return total;
	}

	// Return the number of times String substring appears in String s
	public static int substringCount(String s, String substring) {
		int amountOfTimes=0;
		while(s.contains(substring)) {
			amountOfTimes++;
			int ind=s.indexOf(substring);
			s=s.substring(ind+ substring.length(), s.length());
			
		}
		return amountOfTimes;
		
	}

	// Call Utitilities.encrypt to encrypt String s
	public static String encrypt(String s, char key) {
		return Utilities.encrypt(s.getBytes(), (byte)key);
		
	}

	// Call Utilities.decrypt to decrypt the cypherttex
	public static String decrypt(String s, char key) {
		
		return Utilities.decrypt(s, (byte)key) ;
	}

	// Return the number of words in String s that end with String substring
	// You can assume there are no punctuation marks between words
	public static int wordsEndsWithSubstring(String s, String substring) {
		int total=0;
		String [] words=s.split(" ");
		for (int i = 0; i < words.length; i++) {
			if(words[i].endsWith(substring)) {
				total++;
			}
		}
		return total;
		//while(s.endsWith(substring)) {
		//total++;
		
		//}
		//return total;
	}

	// Given String s, return the number of characters between the first occurrence
	// of String substring and the final occurrence
	// You can assume that substring will appear at least twice
	public static int distance(String s, String substring) {
		String[] characters=s.split(substring);
		for (int j = 0; j < characters.length; j++) {
			int x=characters[j+1].length()-characters[j].length();
		
		}
		return 0;
		
	}

	// Return true if String s is a palindrome
	// palindromes are words or phrases are read the same forward as backward.
	// HINT: ignore/remove all punctuation and spaces in the String
	public static boolean palindrome(String s) {
		return true;
	}

}

class Utilities {
	// This basic encryption scheme is called single-byte xor. It takes a single
	// byte and uses exclusive-or on every character in the String.
	public static String encrypt(byte[] plaintext, byte key) {
		for (int i = 0; i < plaintext.length; i++) {
			plaintext[i] = (byte) (plaintext[i] ^ key);
		}
		return Base64.getEncoder().encodeToString(plaintext);
	}

	public static String decrypt(String cyphertext, byte key) {
		byte[] b = Base64.getDecoder().decode(cyphertext);
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) (b[i] ^ key);
		}
		return new String(b);
	}
}
