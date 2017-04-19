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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * 
 * ClassName: MobileCompressUtils
 * 
 * @description
 * @author wujianjun
 * @Date 2015-1-15
 * 
 */
public class MobileCompressUtils {
	/**
	 * 压缩
	 * @param str
	 * @return
	 * @throws IOException
	 */
	public static byte[] compress(String str) throws IOException {
		if (str == null || str.length() == 0) {
			return null;
		}

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		GZIPOutputStream gzip = new GZIPOutputStream(out);
		try {
			gzip.write(str.getBytes("UTF-8"));
			gzip.flush();
		} finally {
			gzip.close();
		}
		return out.toByteArray();
	}

	/**
	 * 解压
	 * 
	 * @param str
	 * @return
	 * @throws IOException
	 */
	public static String uncompress(byte[] buffer) {
		String returnStr = "";
		if (buffer == null || buffer.length == 0) {
			return "";
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ByteArrayInputStream in = new ByteArrayInputStream(buffer);
		GZIPInputStream gunzip;
		try {
			gunzip = new GZIPInputStream(in);
			try {
				byte[] bufferCu = new byte[256];
				int n;
				while ((n = gunzip.read(bufferCu)) >= 0) {
					out.write(bufferCu, 0, n);
				}
			} finally {
				gunzip.close();
			}
			in.close();
			out.close();
			returnStr = out.toString("UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return returnStr;
	}

}
