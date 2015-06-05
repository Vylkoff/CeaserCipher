import java.util.Scanner;

public class Ceaser {

	public static void main(String[] args) {

		String err = "Wrong key";
		String textResult = null;
		char[] letters = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
				'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
				'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
				'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
				'u', 'v', 'w', 'x', 'y', 'z' };
		Scanner input = new Scanner(System.in);
		System.out.println("Enter \"e\" for encrypt or \"d\" for decrypt !");
		String text = input.nextLine();
		String encrypt = "e";
		String decrypt = "d";
		if (text.equals(encrypt)) {
			textResult = coding(letters, err);
			System.out.println(textResult);
		} else if (text.equals(decrypt)) {
			textResult = decoding(letters, err);
			System.out.println(textResult);
		} else if ((text.equals(encrypt) == false)
				|| (text.equalsIgnoreCase(decrypt) == false)) {
			System.out.println("Wrong command !");
		}
	}

	public static String coding(char[] letters, String err) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter text for encrypting:");
		String text1 = input.nextLine();
		System.out.println("Enter key for displacement:");
		int n = input.nextInt();
		String codingText = null;
		char[] plainText = text1.toCharArray();
		if (n > 0) {
			for (int c = 0; c < plainText.length; c++) {
				for (int k = 0; k < letters.length; k++) {
					if (k+n <= letters.length) {
						if (plainText[c] == letters[k]) {
							plainText[c] = letters[k + n];
							break;
						}
					}
					if (k + n > letters.length) {
						if (plainText[c] == letters[k]) {
							plainText[c] = letters[(k + n) - letters.length];
							break;
						}
					}
				}
			}
			codingText = String.valueOf(plainText);
			return codingText;
		} else {
			return err;
		}
	}

	public static String decoding(char[] letters, String err) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter text for decrypting!");
		String text2 = input.nextLine();
		System.out.println("Enter key for displacement:");
		int n = input.nextInt();
		String decodingText = null;
		char[] codeText = text2.toCharArray();
		if (n > 0) {
			for (int c = 0; c < codeText.length; c++) {
				for (int k = 0; k < letters.length; k++) {
					if ((k >= n) && (codeText[c] == letters[k])) {
						codeText[c] = letters[k - n];
						break;
					}
					if ((codeText[c] == letters[k]) && (k < n)) {
						codeText[c] = letters[(52 - n) + k];
						break;
					}
				}
			}
			decodingText = String.valueOf(codeText);
			return decodingText;
		} else {
			return err;
		}
	}
}