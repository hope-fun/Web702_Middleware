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

import org.apache.commons.lang.math.RandomUtils;

import java.util.*;
import java.util.Map.Entry;

/**
 * @ClassName: ProbabilityRuler
 * @author nikm
 * @date 2013-9-26
 *
 */
public class ProbabilityRuler {

    public static void main(String[] args) {
//    	int num = 1000000;
//    	int count = 0;
    	
    	// 几率，概率
//    	int probability = 0;
//        while (probability<100) {
//        	count = 0;
//        	for (int j=0; j<num; j++) {
//        		if (judge(probability)) count++;
//        	}
//        	System.out.println("--- "+probability+" ---: " + ((float)count/(float)num)*100);
//        	
//        	probability += 10;
//        }
        
//    	Map<String,Integer> map = new HashMap<String,Integer>();
//    	map.put("鬼迷心窍", 25);
//    	map.put("自然灾害", 20);
//    	map.put("任意导航", 30);
//    	map.put("政府投资", 25);
//    	String key = judgeFromMap(map);
//    	System.out.println(key);
    	
//    	for (int j=0; j<num; j++) {
//			if (("3").equals(judgeFromMap(map))) count++;
//		}
//    	System.out.println("--- 30,30,40 ---: " + ((float)count/(float)num)*100);

//        for(int i=0;i<100;i++)
//        System.out.println(getRandom(0,3));
//
//    	//判断
//    	if(judge(5,1,100)){
//    		System.out.println(true);
//    	}
//    	else{
//    		System.out.println(false);
//    	}

        for(int i=0;i<100;i++)
            System.out.println(getRandom0(1,6));
    }
	
	/**
	 * 概率判定 <br />
	 * 从范围0-100获取随机值rd <br />
	 * rd <= probability, true<br />
	 * probability > rd, false
	 *  
	 * @param int probability，数值
	 * @return
	 */
	public static boolean judge(int probability) {
		return judge(probability, 0, 100);
	}
	
	/**
	 * 卡牌概率判断
	 * 从范围0-10000获取随机值 <br />
	 * rd <= probability, true<br />
	 * probability > rd, false
	 * @param int probability，数值
	 * @return
	 */
	public static boolean cardJudge(int probability) {
		return judge(probability, 0, 10000);
	}
	
	/**
	 * 概率判定 <br />
	 * 从范围 min-max 获取随机值rd <br />
	 * rd <= probability, true <br />
	 * probability > rd, false
	 * 
	 * @param int probability，数值
	 * @param int min，判定范围下限
	 * @param int max， 判定范围上限
	 * @return
	 */
	public static boolean judge(int probability, int min, int max) {
		if (min >= max) return false;
		
		int rd = getRandom(min, max);
		if (rd <= probability) {
			return true;
		}
		
		return false;
	}

	/**
	 * 从列表判定概率 <br />
	 * 从范围0-100获取随机值rd <br />
	 * rd < probability1, probability1 选中 <br />
	 * rd < probability1+probability2, probability2 选中 <br />
	 * 
	 * 例如: <br />
	 * {"1":10, "2":90} <br />
	 * 随机值rd=0-9, 1选中 <br />
	 * 随机值rd=10-99, 2选中 <br />
	 * 
	 * @param map, Map<Object, Integer>, key=>probability
	 * @return key of map
	 */
	public static <T> T judgeFromMap(Map<T, Integer> map) {
		return judgeFromMap(map, 0, 100);
	}
	
	public static <T> List<T> judgeListFromMap(Map<T, Integer> map) {
		return judgeListFromMap(map, 0, 100);
	}
	
	/**
	 * 从列表判定概率
	 * 从范围min-max获取随机值rd <br />
	 * rd < min+probability1, probability1 选中 <br />
	 * rd < min+probability1+probability2, probability2 选中 <br />
	 * 
	 * 例如: <br />
	 * min=100, max=200
	 * {"1":10, "2":90} <br />
	 * 随机值rd=100-109, 1选中 <br />
	 * 随机值rd=110-199, 2选中 <br />
	 * 
	 * @param map, Map<Object, Integer>, key=>probability
	 * @param int min，判定范围下限
	 * @param int max， 判定范围上限
	 * @return key of map
	 */
	public static <T> T judgeFromMap(Map<T, Integer> map, int min, int max) {
		if (min >= max || map == null || map.size() < 1) return null;
		
		int rd = getRandom(min, max);
		int probability = min;
		
		Iterator<Entry<T,Integer>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Entry<T, Integer> entry = it.next();
			probability += entry.getValue();
			
			if (rd < probability) {
				return entry.getKey();
			}
		}
		return null;
	}
	
	public static <T> List<T> judgeListFromMap(Map<T, Integer> map, int min, int max) {
		if (min >= max || map == null || map.size() < 1) return null;
		int rd;
		List<T> list = new ArrayList<T>();
		Iterator<Entry<T,Integer>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Entry<T, Integer> entry = it.next();
			rd = getRandom(min, max);
			if (rd < (min+entry.getValue())) {
				list.add(entry.getKey());
			}
		}
		return list;
	}
	
    /**
     * 随机的范围： [min,max)   max 不包含
     * @param min
     * @param max
     * @return
     */
    public static int getRandom(int min, int max) {
        if(min   == max)
            return min;

		Random random = new Random();
		return random.nextInt(max-min)+ min;
	}

    /**
     * 随机的范围： [min,max]  包含max
     * @param min
     * @param max
     * @return
     */
    public static int getRandom0(int min, int max) {
        if(min   == max)
            return min;

        Random random = new Random();
        return random.nextInt(max - min + 1)+ min;
    }



    public static<T>  List<T> getRandom(List<T> elements, int num) {
        List<T> copy = new ArrayList<T>(elements);
        if(elements.size() <= num || elements.isEmpty()) {
            return copy;
        }else{
            List<T> ret = new ArrayList<T>();
            while(ret.size() < num){
                int index = getRandom(1,elements.size() + 1);
                T random = elements.get(index - 1);
                ret.add(random);
                copy.remove(random);
            }
            return ret;
        }

    }

    public static<T> T getRandomOne(List<T> elements) {
        if(elements == null || elements.isEmpty())
            return null;

        int index = RandomUtils.nextInt(elements.size());
        return elements.get(index);

    }
}
