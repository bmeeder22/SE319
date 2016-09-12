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
	 * Encrypts a String and returns the encrypted String
	 * @param string
	 * @return the encrypted String
	 */
	public static String encryptString(String string) {
		byte[] encryptedBytes = encryptStringToBytes(string);
		return DatatypeConverter.printBase64Binary(encryptedBytes);
	}

	/**
	 * Decrypts an encrypted String and returns the result as a String
	 * @param string
	 * @return the decrypted String
	 */
	public static String decryptStringFromString(String string) {
		byte[] encryptedBytes = DatatypeConverter.parseBase64Binary(string);
		return decryptStringFromBytes(encryptedBytes);
	}
	
	/**
	 * Encrypts a File and returns the encoded bytes as a String
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static String encryptFileToString(File file) throws IOException {
		byte[] bytes = encryptFileToByteArray(file);
		return DatatypeConverter.printBase64Binary(bytes);
	}
	
	/**
	 * Decrypts an encrypted File from a String and writes the File to the pathname
	 * @param encryptedString
	 * @param pathname
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
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
	
	/**
	 * Encrypts a String and returns as an array of bytes.
	 * @param string
	 * @return
	 */
	private static byte[] encryptStringToBytes(String string) {
		byte[] stringBytes = string.getBytes();
		
		return encryptDecrypt(stringBytes);
	}
	
	/**
	 * Decrypts an array of bytes and returns the array as a String.
	 * @param stringBytes
	 * @return the decrypted String
	 */
	public static String decryptStringFromBytes(byte[] stringBytes) {
		byte[] decryptedBytes = encryptDecrypt(stringBytes);
		return new String(decryptedBytes);
	}
	
	/**
	 * Encrypts or decrypts an array of bytes by performing an XOR with the key on every byte.
	 * @param bytes
	 * @return An encrypted/decrypted array of bytes
	 */
	private static byte[] encryptDecrypt(byte[] bytes) {
		byte[] alternateBytes = new byte[bytes.length];
				
		for (int i = 0; i < bytes.length; i++) {
			alternateBytes[i] = (byte) (bytes[i] ^ key); // b[i] XOR key
		}
		
		return alternateBytes;
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
	
	private static void decryptFileFromByteArray(byte[] encryptedFileBytes, String pathname) throws FileNotFoundException, IOException {
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

		FileOutputStream outStream = new FileOutputStream(pathname);
		outStream.write(decryptedFileBytes);
		outStream.close();
	}
	
	private static byte[] encryptFileToByteArray(File file) throws IOException {
		byte[] encryptedFileBytes = new byte[0];
		try {
			Path path = Paths.get(file.getAbsolutePath());
			byte[] fileBytes = Files.readAllBytes(path);
			ArrayList<Integer> fileBitsIntArray = getBitsIntArray(fileBytes);

			int bitNum = 7;	//counts down from 7 to 2
			byte encryptedByte = Byte.parseByte("0"); //creates a byte of all 0s
			for (int bit : fileBitsIntArray) {
				encryptedByte = setBit(encryptedByte, bitNum, bit);
				
				if (bitNum == 2) { //add it to encryptedFileBytes
					encryptedFileBytes = appendByte(encryptedFileBytes, encryptedByte);
					bitNum = 7;
				} else {
					bitNum--;
				}
			}

			return encryptedFileBytes;
		} catch (IOException e) {
			System.out.println("Something went wrong. Could not encrypt file.");
			return null;
		}
	}
}
