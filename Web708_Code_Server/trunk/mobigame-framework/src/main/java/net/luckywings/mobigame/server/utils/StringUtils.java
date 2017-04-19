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


/**
 * 
 * ClassName: StringUtils
 * 
 * @description
 * @author nikm
 * @Date 2013-3-7
 * 
 */
public class StringUtils {
	public static final String HEX_STRING_BLANK_SPLIT = " ";
	public static final String HEX_STRING_NOT_SPLIT = "";

	/**
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isEmpty(String value) {
		return (value == null || value.equals(""));
	}

	/**
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isEmpty(Object value) {
		return (value == null || value.toString().equals(""));
	}

	/**
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isNotEmpty(String value) {
		return !isEmpty(value);
	}

	/**
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isNotEmpty(Object value) {
		return !isEmpty(value);
	}

//	private static final byte[] HEX_CHAR_TABLE = { (byte) '0', (byte) '1',
//			(byte) '2', (byte) '3', (byte) '4', (byte) '5', (byte) '6',
//			(byte) '7', (byte) '8', (byte) '9', (byte) 'a', (byte) 'b',
//			(byte) 'c', (byte) 'd', (byte) 'e', (byte) 'f' };

//	public static String getHexString(byte[] raw) throws UnsupportedEncodingException {
//		byte[] hex = new byte[2 * raw.length];
//		int index = 0;
//
//		for (byte b : raw) {
//			int v = b & 0xFF;
//			hex[index++] = HEX_CHAR_TABLE[v >>> 4];
//			hex[index++] = HEX_CHAR_TABLE[v & 0xF];
//		}
//		return new String(hex, "UTF-8");
//	}
	
	public static String getHexString(byte[] b) {
		return getHexString(b, HEX_STRING_BLANK_SPLIT);
	}

	public static String getHexString(byte[] b, String splitString) {
		int[] intArray = new int[b.length];
		for (int i = 0; i < b.length; i++) {
			if (b[i] < 0)
				b[i] += 256;
			else {
				intArray[i] = b[i];
			}
		}
		return getHexString(intArray, splitString);
	}

	public static String getHexString(int[] b) {
		return getHexString(b, " ");
	}

	public static String getHexString(int[] b, String splitString) {
		StringBuffer sb = new StringBuffer();
		for (int c : b) {
			String strData = Integer.toHexString(c);
			if (strData.length() == 1)
				sb.append("0").append(strData);
			else {
				sb.append(strData);
			}
			sb.append(splitString);
		}
		return sb.toString().trim();
	}

	public static String getHexString(int i) {
		return getHexString(new int[] { i });
	}

	public static String getHexString(byte i) {
		return getHexString(new byte[] { i });
	}

	public static String toLowerFirstChar(String s) {
		return s.substring(0, 1).toLowerCase() + s.substring(1);
	}

	public static String toUpperFirstChar(String s) {
		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}

	/**
	 * 作为关键字搜索 去除转义字符和防止sql注入
	 */
//	public static String escapeSpecial(String raw) {
//		String str = StringEscapeUtils.escapeSql(raw);
//
//		StringBuffer strBuf = new StringBuffer("");
//
//		int len = str.length();
//		for (int i = 0; i < len; i++) {
//			if (ifContains(str.charAt(i)) >= 0) {
//				strBuf.append("\\" + str.charAt(i));
//			} else {
//				strBuf.append(str.charAt(i));
//			}
//		}
//		return strBuf.toString();
//	}

//	private static int ifContains(char charAt) {
//		/* 通配符 */
//		String spe = "%[]!^_";
//		int len = spe.length();
//		for (int i = 0; i < len; i++) {
//			if (spe.charAt(i) == charAt) {
//				return i;
//			}
//		}
//		return -1;
//	}

	public static void main(String args[]) throws Exception {
		byte[] byteArray = { (byte) 255, (byte) 254, (byte) 253, (byte) 252,
				(byte) 251, (byte) 250 };

		System.out.println(StringUtils.getHexString(byteArray));
	}
}
