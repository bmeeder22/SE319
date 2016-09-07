
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Encryption {
	final private static byte key = (byte) 240; // key: 11110000

	/**
	 * Encrypts a String and returns as an array of bytes.
	 * @param string
	 * @return
	 */
	public static byte[] encryptString(String string) {
		byte[] stringBytes = string.getBytes();
		
		return encryptDecrypt(stringBytes);
	}
	
	/**
	 * Decrypts an array of bytes and returns the array as a String.
	 * @param stringBytes
	 * @return
	 */
	public static String decryptString(byte[] stringBytes) {
		byte[] decryptedBytes = encryptDecrypt(stringBytes);
		return new String(decryptedBytes);
	}
	
	/**
	 * Encrypts or decrypts an array of bytes by performing an XOR with the key on every byte.
	 * @param bytes
	 * @return An encrypted/decrypted array of bytes
	 */
	public static byte[] encryptDecrypt(byte[] bytes) {
		byte[] alternateBytes = new byte[bytes.length];
		
//		System.out.println("key = " + String.format("%8s", Integer.toBinaryString(key & 0xFF)).replace(' ', '0'));
		
		for (int i = 0; i < bytes.length; i++) {
			alternateBytes[i] = (byte) (bytes[i] ^ key); // b[i] XOR key
			
//			String bits = String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
//			System.out.println("original: " + bits);			
//			System.out.println("encrypted: " + String.format("%8s", Integer.toBinaryString(alternateBytes[i] & 0xFF)).replace(' ', '0'));
		}
		
		return alternateBytes;
	}

	public static byte[] encryptFile(File file) {
		try {
			Path path = Paths.get(file.getAbsolutePath());
			byte[] fileBytes = Files.readAllBytes(path);

			if (fileBytes.length % 3 != 0) {
				System.out.println("file bytes not divisible by 3");
			}

			byte[] encryptedFileBytes = new byte[0];

			return encryptedFileBytes;
		} catch (IOException e) {
			System.out.println("Something went wrong.");
			return null;
		}
	}

	private static byte[] appendBytes(byte[] bytes1, byte[] bytes2) {
		byte[] result = new byte[bytes1.length + bytes2.length];
		
		int index = 0;
		for (byte b : bytes1) {
			result[index] = b;
			index++;
		}
		for (byte b2 : bytes2) {
			result[index] = b2;
			index++;
		}

		return result;
	}
	
	//TODO: Remove main method - for testing purposes only
	public static void main(String[] args) {
		System.out.println("Original string: Hello World");
		byte[] encryptedString = encryptString("Hello World");
		System.out.println("Decrypted string: " + decryptString(encryptedString));

		File test = new File("test.txt");
		encryptFile(test);
	}

}
