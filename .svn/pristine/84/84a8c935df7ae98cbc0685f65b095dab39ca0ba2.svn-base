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

import java.util.Locale;

/**
 * 
 * ClassName: LocaleUtils
 *
 * @description
 * @author nikm
 * @Date 2013-3-7
 *
 */
public class LocaleUtils {
    public static void main(String[] objs) {
        Locale c = getLocale("en");
        System.out.println(c);
    }

    public static Locale getLocale(String language) {
        Locale l = null;
        if (language == null) {
            l = Locale.JAPAN;
        }
        else {
            try {
                l = new Locale(language);
            } catch (Exception e) {
                l = Locale.JAPAN;
            }
        }
        return l;
    }
}
