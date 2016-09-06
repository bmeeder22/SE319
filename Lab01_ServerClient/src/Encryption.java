
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
	
	//TODO: Remove main method - for testing purposes only
//	public static void main(String[] args) {
//		System.out.println("Original string: Hello World");
//		byte[] encryptedString = encryptString("Hello World");
//		System.out.println("Decrypted string: " + decryptString(encryptedString));
//	}

}
