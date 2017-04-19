/*******************************************************************************
 * LUCKYWINGS PROPRIETARY INFORMATION
 *  
 * The information contained herein is proprietary to LuckyWings and shall not be reproduced or
 * disclosed in whole or in part or used for any design or manufacture without direct written
 * authorization from LuckyWings.
 *
 * Copyright (c) 2016 by LuckyWings. All rights reserved.
 *******************************************************************************/
package net.luckywings.mobigame.server.rulers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.luckywings.mobigame.server.utils.CommonUtils;
import net.luckywings.mobigame.server.utils.SysProperties;


/**
 * 
 * @ClassName: PlayerIdRuler
 * @author nikm
 * @date 2013-7-24
 * 
 */
public class PlayerIdRuler {
    /** Declare the default dynamic database server number in CAS */
    private static int DYNAMIC_DB_NUM = SysProperties.getInstance().getIntProperty(
            "server.database.dynamic.dbnum", 2);
    // private static int DYNAMIC_DB_NUM = 2;

    private static String PRIORITY_LIST = SysProperties.getInstance().getProperty(
            "server.database.dynamic.dbnum", "50, 50");

    // private static String PRIORITY_LIST = "100,0"; // --- 100000 ---: DS1 - 100000, DS2 - 0
    // private static String PRIORITY_LIST = "0,100"; // --- 100000 ---: DS1 - 0, DS2 - 100000
    // private static String PRIORITY_LIST = "80,20"; // --- 100000 ---: DS1 - 80726, DS2 - 19274
    // private static String PRIORITY_LIST = "50,50"; // --- 100000 ---: DS1 - 50061, DS2 - 49939

    /**
     * @param identity
     * @param ip
     * @return
     */
    public static String generateKey(String id) {

        String key = null;

        String[] priorityList = PRIORITY_LIST.split(",");
        if (priorityList.length != DYNAMIC_DB_NUM) {
            key = "1" + id;
        } else {
            int priority = 0;
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int i = 1; i <= DYNAMIC_DB_NUM; i++) {
                priority += CommonUtils.convertToInt(priorityList[i - 1]);
                map.put(i, priority);
            }
            int ds = (Integer) ProbabilityRuler.judgeFromMap(map);

            key = (ds == 0) ? "1" + id : ds + id;
        }

        return key;
    }

    public static String parseDbType(String key) {
        if (key != null && key.length() > 1) {
            return key.substring(0, 1);
        }
        return "1";
    }

    /**
     * Return all types of player id
     * 
     * @return
     */
    public static String[] getAllIdTypes() {
        List<String> keys = new ArrayList<String>();
        for (int i = 1; i <= DYNAMIC_DB_NUM; i++) {
            keys.add(i + "pid");
        }
        return keys.toArray(new String[keys.size()]);
    }

    /**
     * Return all db types
     * 
     * @return
     */
    public static String[] getAllDbTypes() {
        List<String> keys = new ArrayList<String>();
        for (int i = 1; i <= DYNAMIC_DB_NUM; i++) {
            keys.add("ds" + i);
        }
        return keys.toArray(new String[keys.size()]);
    }

    public static void main(String[] args) {
        int count1 = 0;
        int count2 = 0;

        String key;

        int num = 100000;
        for (int i = 0; i < num; i++) {
            key = generateKey("identity");
            key = parseDbType(key);
            if (("1").equals(key)) {
                count1++;
            } else if (("2").equals(key)) {
                count2++;
            }
        }
        System.out.println("--- 100000 ---: DS1 - " + ((float) count1 / (float) num) * 100
                + ", DS2 - " + ((float) count2 / (float) num) * 100);

        String[] types = getAllDbTypes();
        for (int i = 0; i < types.length; i++) {
            System.out.println(types[i]);
        }
    }
}
