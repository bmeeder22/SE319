
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.bind.DatatypeConverter;

public class Encryption {
	final private static byte key = (byte) 240; // key: 11110000

	/**
	 * Encrypts a String and returns as an array of bytes.
	 * @param string
	 * @return
	 */
	public static byte[] encryptStringToBytes(String string) {
		byte[] stringBytes = string.getBytes();
		
		return encryptDecrypt(stringBytes);
	}

	public static String encryptString(String string) {
		byte[] encryptedBytes = encryptStringToBytes(string);
		return DatatypeConverter.printBase64Binary(encryptedBytes);
	}
	
	/**
	 * Decrypts an array of bytes and returns the array as a String.
	 * @param stringBytes
	 * @return
	 */
	public static String decryptStringFromBytes(byte[] stringBytes) {
		byte[] decryptedBytes = encryptDecrypt(stringBytes);
		return new String(decryptedBytes);
	}

	public static String decryptStringFromString(String string) {
		byte[] encryptedBytes = DatatypeConverter.parseBase64Binary(string);
		return decryptStringFromBytes(encryptedBytes);
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

	public static byte[] encryptFileToByteArray(File file) throws IOException {
		byte[] encryptedFileBytes = new byte[0];
		try {
			Path path = Paths.get(file.getAbsolutePath());
			byte[] fileBytes = Files.readAllBytes(path);
			ArrayList<Integer> fileBitsIntArray = getBitsIntArray(fileBytes);

			// System.out.println("Bytes in file: " + fileBytes.length);
			int bytesAdded = 0;

			int bitNum = 7;	//counts down from 7 to 2
			byte encryptedByte = Byte.parseByte("0"); //creates a byte of all 0s
			for (int bit : fileBitsIntArray) {
				encryptedByte = setBit(encryptedByte, bitNum, bit);
				
				if (bitNum == 2) { //add it to encryptedFileBytes
					encryptedFileBytes = appendByte(encryptedFileBytes, encryptedByte);

					//TODO: Remove the following block - for testing only
					// bytesAdded++;
					// byte[] singleByte = new byte[0];
					// singleByte = appendByte(singleByte, encryptedByte);
					// System.out.println("Encrypted byte " + bytesAdded + ": " + getBitsIntArray(singleByte).toString());
					
					bitNum = 7;
				} else {
					bitNum--;
				}
			}

			// System.out.println("Bytes written: " + encryptedFileBytes.length);

			return encryptedFileBytes;
		} catch (IOException e) {
			System.out.println("Something went wrong. Could not encrypt file.");
			return null;
		}
	}
	
	public static String encryptFileToString(File file) throws IOException {
		byte[] bytes = encryptFileToByteArray(file);
		return DatatypeConverter.printBase64Binary(bytes);
	}

	public static void decryptFileFromByteArray(byte[] encryptedFileBytes, String pathname) throws FileNotFoundException, IOException {
		File file = null;
		byte[] decryptedFileBytes = new byte[0];

		ArrayList<Integer> encryptedBitsIntArray = getBitsIntArray(encryptedFileBytes);

		//reading the array of encrypted bits
		Iterator<Integer> iter = encryptedBitsIntArray.iterator();
		ArrayList<Integer> decryptedBitsIntArray = new ArrayList<Integer>();
		while (iter.hasNext()) {
			for (int countToSix = 0; countToSix < 6 && iter.hasNext(); countToSix++) { //grab 6 ints
				decryptedBitsIntArray.add(iter.next());
			}
			for (int countToTwo = 0; countToTwo < 2 && iter.hasNext(); countToTwo++) { //ignore 2 ints
				iter.next();
			}
		}
		
		//reading the array of decrypted bits
		iter = decryptedBitsIntArray.iterator();
		byte nextByte = Byte.parseByte("0");
		while (iter.hasNext()) {	//
			int bitNum ;
			for (bitNum = 7; bitNum >= 0 && iter.hasNext(); bitNum--) {
				nextByte = setBit(nextByte, bitNum, iter.next());
			}
			if (bitNum == -1) { //If 8 bits have been read, add the byte
				decryptedFileBytes = appendByte(decryptedFileBytes, nextByte);
			}
		}

		//TODO: Remove the following block - for testing only
		// System.out.println("Byte content: " + new String(decryptedFileBytes));
		// System.out.println("Decrypted Bytes: " + decryptedBitsIntArray.toString() + "\nNumber of bytes: " + decryptedBitsIntArray.size() / 8);
		// for (byte b : decryptedFileBytes) {
		// 	byte[] singleByte = new byte[0];
		// 	singleByte = appendByte(singleByte, b);
		// 	System.out.println("Encrypted byte : " + getBitsIntArray(singleByte).toString());
		// }

		FileOutputStream outStream = new FileOutputStream(pathname);
		outStream.write(decryptedFileBytes);
		outStream.close();
	}
	
	public static void decryptFileFromString(String encryptedString, String pathname) throws FileNotFoundException, IOException {
		byte[] bytes = DatatypeConverter.parseBase64Binary(encryptedString);
		decryptFileFromByteArray(bytes, pathname);
	}

	//-----------------------------------------
	// HELPER METHODS
	//-----------------------------------------

	private static int getBit(byte b, int bitNum) {
		return ((b >> bitNum) & 1);
	}

	private static byte setBit(byte b, int bitNum, int bitValue) {
		byte newByte = (byte) 0;
		if (bitValue == 1) {
			newByte = (byte) (b | (1 << bitNum));
		} else if (bitValue == 0) {
			newByte = (byte) (b & ~(1 << bitNum));
		} else {
			return b;
		}
		return newByte;
	}
	
	private static ArrayList<Integer> getBitsIntArray(byte[] bytes) {
		ArrayList<Integer> bits = new ArrayList<Integer>();
		for (byte b : bytes) {
			for (int bitNum = 7; bitNum >= 0; bitNum--) {
				bits.add(getBit(b, bitNum));				
			}
		}
		
		return bits;
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
	
	private static byte[] appendByte(byte[] bytes, byte toAppend) {
		byte[] result = new byte[bytes.length + 1];
		
		int index = 0;
		for (byte b : bytes) {
			result[index] = b;
			index++;
		}
		result[index] = toAppend;
		
		return result;
	}
	
	//TODO: Remove main method - for testing purposes only
	public static void main(String[] args) throws IOException, FileNotFoundException {
		System.out.println("Original string: Hello World");
		byte[] encryptedBytes = encryptStringToBytes("Hello World");
		System.out.println("Decrypted string: " + decryptStringFromBytes(encryptedBytes));

		String encryptedString = encryptString("Hello Moon");
		System.out.println("Decrypted string from string: " + decryptStringFromString(encryptedString));

		// byte one = (byte) 1;
		// byte two = (byte) 2;
		// System.out.println("One: " + getBit(one, 3) + getBit(one, 2) + getBit(one, 1) + getBit(one, 0));
		// System.out.println("Two: " + getBit(two, 3) + getBit(two, 2) + getBit(two, 1) + getBit(two, 0));

		// two = setBit(two, 1, 0);
		// System.out.println("Zero: " + getBit(two, 3) + getBit(two, 2) + getBit(two, 1) + getBit(two, 0));
		// two = setBit(two, 2, 1);
		// System.out.println("Four: " + getBit(two, 3) + getBit(two, 2) + getBit(two, 1) + getBit(two, 0));
		// two = setBit(two, 3, 1);
		// System.out.println("Twelve: " + getBit(two, 3) + getBit(two, 2) + getBit(two, 1) + getBit(two, 0));
		// two = setBit(two, 2, 0);
		// System.out.println("Eight: " + getBit(two, 3) + getBit(two, 2) + getBit(two, 1) + getBit(two, 0));
		
		// byte[] numbersByte = new byte[0];
		// numbersByte = appendByte(numbersByte, Byte.parseByte("1"));
		// numbersByte = appendByte(numbersByte, Byte.parseByte("3"));
		// numbersByte = appendByte(numbersByte, Byte.parseByte("15"));
		// numbersByte = appendByte(numbersByte, Byte.parseByte("-128"));
		// ArrayList<Integer> numbersBitArray = getBitsIntArray(numbersByte);
		// System.out.println(numbersBitArray.toString());

		// File test = new File("test.txt");
		// byte[] encryptedFileBytes = encryptFileToByteArray(test);
		// decryptFileFromByteArray(encryptedFileBytes, "test_decrypted.txt");
		
		// String encryptedFileString = encryptFileToString(test);
		// System.out.println("Encrypted File String: " + encryptedFileString);
		// decryptFileFromString(encryptedFileString, "string_test.txt");
		

		// System.out.println("Encrypted File: " + getBitsIntArray(encryptedFileBytes).toString());
	}

}
