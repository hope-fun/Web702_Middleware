/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
package net.luckywings.mobigame.server.utils;

import java.nio.charset.Charset;

/**
 * 
 * @ClassName: BitConverter
 * @author nikm
 * @date 2013-8-6
 * 
 */
public class BitConverter {
	public static byte[] getBytes(short data) {
		byte[] bytes = new byte[2];
		bytes[0] = (byte) (data & 0xff);
		bytes[1] = (byte) ((data & 0xff00) >> 8);
		return bytes;
	}

	public static byte[] getBytes(char data) {
		byte[] bytes = new byte[2];
		bytes[0] = (byte) (data);
		bytes[1] = (byte) (data >> 8);
		return bytes;
	}

	public static byte[] getBytes(boolean data) {
		byte[] bytes = new byte[1];
		bytes[0] = (byte) (data ? 1 : 0);
		return bytes;
	}

	public static byte[] getBytes(int data) {
		byte[] bytes = new byte[4];
		bytes[0] = (byte) (data & 0xff);
		bytes[1] = (byte) ((data & 0xff00) >> 8);
		bytes[2] = (byte) ((data & 0xff0000) >> 16);
		bytes[3] = (byte) ((data & 0xff000000) >> 24);
		return bytes;
	}

	public static byte[] getBytes(long data) {
		byte[] bytes = new byte[8];
		bytes[0] = (byte) (data & 0xff);
		bytes[1] = (byte) ((data >> 8) & 0xff);
		bytes[2] = (byte) ((data >> 16) & 0xff);
		bytes[3] = (byte) ((data >> 24) & 0xff);
		bytes[4] = (byte) ((data >> 32) & 0xff);
		bytes[5] = (byte) ((data >> 40) & 0xff);
		bytes[6] = (byte) ((data >> 48) & 0xff);
		bytes[7] = (byte) ((data >> 56) & 0xff);
		return bytes;
	}

	public static byte[] getBytes(float data) {
		int intBits = Float.floatToIntBits(data);
		return getBytes(intBits);
	}

	public static byte[] getBytes(double data) {
		long intBits = Double.doubleToLongBits(data);
		return getBytes(intBits);
	}

	public static byte[] getBytes(String data, String charsetName) {
		Charset charset = Charset.forName(charsetName);
		return data.getBytes(charset);
	}

	public static byte[] getBytes(String data) {
		return getBytes(data, "GBK");
	}

	public static boolean getBoolean(byte[] bytes) {
		return bytes[0] == 1;
	}

	public static boolean getBoolean(byte[] bytes, int startIndex) {
		return bytes[startIndex] == 1;
	}

	public static short getShort(byte[] bytes) {
		return (short) ((0xff & bytes[0]) | (0xff00 & (bytes[1] << 8)));
	}

	public static short getShort(byte[] bytes, int startIndex) {
		return (short) ((0xff & bytes[startIndex]) | (0xff00 & (bytes[startIndex + 1] << 8)));
	}

	public static char getChar(byte[] bytes) {
		return (char) ((0xff & bytes[0]) | (0xff00 & (bytes[1] << 8)));
	}

	public static char getChar(byte[] bytes, int startIndex) {
		return (char) ((0xff & bytes[startIndex]) | (0xff00 & (bytes[startIndex + 1] << 8)));
	}

	public static int getInt(byte[] bytes) {
		return (0xff & bytes[0]) | (0xff00 & (bytes[1] << 8))
				| (0xff0000 & (bytes[2] << 16))
				| (0xff000000 & (bytes[3] << 24));
	}

	public static int getInt(byte[] bytes, int startIndex) {
		return (0xff & bytes[startIndex])
				| (0xff00 & (bytes[startIndex + 1] << 8))
				| (0xff0000 & (bytes[startIndex + 2] << 16))
				| (0xff000000 & (bytes[startIndex + 3] << 24));
	}

	public static long getLong(byte[] bytes) {
		return (0xffL & (long) bytes[0]) | (0xff00L & ((long) bytes[1] << 8))
				| (0xff0000L & ((long) bytes[2] << 16))
				| (0xff000000L & ((long) bytes[3] << 24))
				| (0xff00000000L & ((long) bytes[4] << 32))
				| (0xff0000000000L & ((long) bytes[5] << 40))
				| (0xff000000000000L & ((long) bytes[6] << 48))
				| (0xff00000000000000L & ((long) bytes[7] << 56));
	}

	public static long getLong(byte[] bytes, int startIndex) {
		return (0xffL & (long) bytes[startIndex])
				| (0xff00L & ((long) bytes[startIndex + 1] << 8))
				| (0xff0000L & ((long) bytes[startIndex + 2] << 16))
				| (0xff000000L & ((long) bytes[startIndex + 3] << 24))
				| (0xff00000000L & ((long) bytes[startIndex + 4] << 32))
				| (0xff0000000000L & ((long) bytes[startIndex + 5] << 40))
				| (0xff000000000000L & ((long) bytes[startIndex + 6] << 48))
				| (0xff00000000000000L & ((long) bytes[startIndex + 7] << 56));
	}

	public static float getFloat(byte[] bytes) {
		return Float.intBitsToFloat(getInt(bytes));
	}

	public static double getDouble(byte[] bytes) {
		long l = getLong(bytes);
		System.out.println(l);
		return Double.longBitsToDouble(l);
	}

	public static float getFloat(byte[] bytes, int startIndex) {
		byte[] result = new byte[4];
		System.arraycopy(bytes, startIndex, result, 0, 4);
		return Float.intBitsToFloat(getInt(result));
	}

	public static double getDouble(byte[] bytes, int startIndex) {
		byte[] result = new byte[8];
		System.arraycopy(bytes, startIndex, result, 0, 8);
		long l = getLong(result);
		System.out.println(l);
		return Double.longBitsToDouble(l);
	}

	public static String getString(byte[] bytes, String charsetName) {
		return new String(bytes, Charset.forName(charsetName));
	}

	public static String getString(byte[] bytes) {
		return getString(bytes, "GBK");
	}
}
