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

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.Socket;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

import org.apache.log4j.Logger;

/**
 * 
 * ClassName: CommonUtils
 *
 * @description
 * @author nikm
 * @Date 2013-3-7
 *
 */
public class CommonUtils {
	private static Logger log = Logger.getLogger(CommonUtils.class);

	/**
	 * 
	 * @param obj
	 * @return
	 */
	public static Integer convertToInt(Object obj) {
		Integer rel = null;

		if (obj != null) {
		    if(obj instanceof Integer) {
		        rel = (Integer)obj;
		    }
		    else {
		        rel = Integer.parseInt(obj.toString());
		    }
		}

		return rel;
	}

	/**
	 * 
	 * @return
	 */
	public static String uuid() {
		return UUID.randomUUID().toString();
	}

	public static Long toLong(Object obj) {
		Long r = null;
		if (obj != null) {
			if (obj instanceof BigInteger) {
				r = ((BigInteger) obj).longValue();
			}
			else if(obj instanceof Long) {
			    r = (Long)obj;
			}
		}
		return r;
	}

	public static String toStr(Object obj) {
		String r = null;
		if (obj != null) {
			r = obj.toString();
		}
		return r;
	}

	public static Integer toInteger(Object obj) {
		Integer r = null;
		if (obj != null) {
			if (obj instanceof BigInteger) {
				r = ((BigInteger) obj).intValue();
			} else if (obj instanceof Integer) {
				r = (Integer) obj;
			}
		}
		return r;
	}

	public static Date toDate(Object obj) {
		Date r = null;
		if (obj != null) {
			if (obj instanceof Timestamp) {
				r = (Timestamp) obj;
			}
			// r = obj.toString();

		}
		return r;
	}

	/**
	 * 
	 * @return
	 */
	public static <T> List<T> removeDuplicateList(List<T> lst) {
		List<T> rel = new ArrayList<T>();
		if (lst != null) {
			for (T t : lst) {
				if (!rel.contains(t)) {
					rel.add(t);
				}
			}
		}
		return rel;
	}

	public static void main(String[] argvs) {
//		System.out.println(getRandomNum() +" , " +getRandomNum().length());
//	    getAllSessionKeys("10.20.0.70",11211);
	}

	/**
	 * 
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<Long> objectToLongList(Object obj) {
		List<Long> rels = new ArrayList<Long>();
		if (obj != null) {
			if (obj instanceof List) {
				List<Object> objLst = (List<Object>) obj;
				for (Object item : objLst) {
					if (item != null) {
						rels.add(Long.valueOf(item.toString()));
					}
				}
			} else if (obj instanceof Object[]) {
				Object[] objs = (Object[]) obj;
				for (Object item : objs) {
					if (item != null) {
						rels.add(Long.valueOf(item.toString()));
					}
				}
			} else {
				rels.add(Long.valueOf(obj.toString()));
			}
		}

		return rels;
	}

	/**
	 * 
	 * @param imagePath
	 * @return
	 */
	public static String convertToRelativeFileUrl(Long attachId) {
		return attachId != null ? "/common/file/" + attachId : null;
	}

	/**
	 * 
	 * @param bytes
	 * @return
	 */
	public static String formatFileSize(Long sizeBytes) {
		String size = "";
		try {
			double dSize = (double) sizeBytes;
			if (dSize >= 1024) {
				dSize /= 1024;
				size = "K";
				if (dSize >= 1024) {
					dSize /= 1024;
					size = "M";
				}
			}
			size = new DecimalFormat("0.00").format(dSize) + size;
		} catch (Exception e) {
			size = sizeBytes.toString();
		}

		return size;
	}

	/**
	 * @param type
	 * @return
	 */
	public static String convertAppTypeToNum(String type) {
		String rel = "";
		if (type.equalsIgnoreCase("ipad")) {
			rel = "2";
		} else if (type.equalsIgnoreCase("itouch")) {
			rel = "1";
		} else if (type.equalsIgnoreCase("iphone")) {
			rel = "1";
		} else if (type.equalsIgnoreCase("ipod")) {
			rel = "0";
		}
		return rel;
	}

	/**
	 * TODO: convert system require between description and number type
	 * 
	 * @param nums
	 * @return
	 */
	public static String convertAppNumToType(String nums) {
		String rel = "";

		if (nums != null) {
			String[] numArr = nums.split(",");
			for (String num : numArr) {
				String tmp = "";
				if (num.equals("0")) {
					tmp = "ipod";
				}
				if (num.equals("1")) {
					tmp = "itouch/iphone";
				} else if (num.equals("2")) {
					tmp = "ipad";
				}
				rel += "," + tmp;
			}
			rel = rel.substring(1);
		}

		return rel;
	}

	public static <T> java.util.List<T> toList(T[] arr) {
		java.util.List<T> rel = null;
		if (arr != null && arr.length > 0) {
			rel = new java.util.ArrayList<T>();
			for (T item : arr) {
				rel.add(item);
			}
		}
		return rel;
	}

	/**
	 * 
	 * @param minmumOsVersion
	 * @param targetOSVersion
	 * @return
	 */
	public static boolean isAcceptpedOSVersion(String minmumOsVersion, String targetOSVersion) {
		return targetOSVersion != null && minmumOsVersion.compareToIgnoreCase(targetOSVersion) <= 0;
	}

	public static byte[] objectToBytes(Object obj) {
		byte[] bytes = null;
		try {
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			ObjectOutputStream outputStream = new ObjectOutputStream(out);
			outputStream.writeObject(obj);
			bytes = out.toByteArray();
			outputStream.close();
		} catch (Exception e) {
			log.error("Can not canvert obj to byte[]. ", e);
		}
		return bytes;
	}
	
	public static byte[] intToByteArray(final int integer) {
		int byteNum = (40 - Integer.numberOfLeadingZeros(integer < 0 ? ~integer : integer)) / 8;
		byte[] byteArray = new byte[4];

		for (int n = 0; n < byteNum; n++)
			byteArray[3 - n] = (byte) (integer >>> (n * 8));

		return (byteArray);
	}

	public static int byteArrayToInt(byte[] b, int offset) {
		int value = 0;
		for (int i = 0; i < 4; i++) {
			int shift = (4 - 1 - i) * 8;
			value += (b[i + offset] & 0x000000FF) << shift;
		}
		return value;
	}

	public static Object blobToObject(byte[] bytes) throws IOException {
		Object obj = null;
		try {
			ByteArrayInputStream out = new ByteArrayInputStream(bytes);
			ObjectInputStream in = new ObjectInputStream(out);
			obj = in.readObject();
			in.close();
		} catch (Exception e) {

			log.error("Can not canvert byte[] to obj. ", e);
		}
		return obj;
	}
	
    /**
     * 
     * @param min
     * @param max
     * @return
     */
    public static int getRandom(int min, int max) {
    	if(min == max)
    	{
    		return min;
    	}
		Random random = new Random();
		return random.nextInt(max-min+1)+ min;
	}
    
    /**
	 * judge field is empty
	 * @param field field
	 * @return true:not empty,false:empty
	 */
	public static boolean isEmpty(final String field) {
		return field == null || field.length() == 0;
	}
	
	public static boolean isEmptyObject(Object field) {
		return null == field;
	}
	
	private static final String AND_STR = " and ";
	public static String appendSQLString(String alias) {
		if (isEmpty(alias)) {
			return "";
		}
		return AND_STR + alias+".deleteStatus = 'VALID'"; 
	}
	
	public static String getRandomNum() {
		StringBuffer sb = new StringBuffer();
		for (int i=0;i<9;i++) {
		 sb.append(getRandom(0,9)+"");
		}
		return sb.toString();
	}
	
	/**
	 * 获取memcached
	 *  getAllExpirationTime("10.20.0.70",11211)
	 * @param host  主机IP 地址
	 * @param port  端口号
	 * @return  map:  key:sessionId，value sessionId对应的session过期时间
	 */
	 public static List<String> getAllExpirationTime(String host, int port){
         StringBuffer buffer = new StringBuffer();
         List<String> sessionList = new ArrayList<String> ();
         try {
             Socket socket = new Socket(host, port);
             PrintWriter os = new PrintWriter(socket.getOutputStream());
             BufferedReader is = new BufferedReader(new InputStreamReader( socket.getInputStream()));
             os.println("stats items");
             os.flush();
             String l ;
             while (!(l = is.readLine()).equals("END")) {
                 buffer.append(l).append("\n");
             }
             String rr = buffer.toString();
             Set<String> ids = new HashSet<String>();
             if(rr.length() > 0){
                 buffer = new StringBuffer();//items 
                 rr.replace("STAT items", "");
                 for(String s : rr.split("\n")){
                     ids.add(s.split(":")[1]);
                 }
                 if (ids.size() > 0){
                     for(String s : ids){
                         os.println("stats cachedump "+ s +" 0");
                         os.flush();
                         while (!(l = is.readLine()).equals("END")) {
                            String [] items =  l.split(" ");
                            long expirationTime = Long.parseLong(items[4]);
                            if (new Date().getTime()/1000 <= expirationTime) {
                                String sessionId = items[1];
                                if (sessionId.lastIndexOf("-") > 40) {
                                    sessionList.add(items[1]);
                                }
                            }
                         }
                     }
                 }
             }
             os.close();
             is.close();
             socket.close();
         } catch (Exception e) {
             e.printStackTrace();
             log.error(e.getMessage());
         }
         return sessionList;
     }

}
