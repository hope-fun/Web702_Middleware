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

import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 
 * ClassName: JsonUtils
 * 
 * @description
 * @author nikm
 * @Date 2013-3-7
 * 
 */
public class JsonUtils {

    private static Map<Class<?>, Object> SERIALIZER;
    private static Map<Class<?>, Object> DESERIALIZER;

//    static {
//        DESERIALIZER = new HashMap<Class<?>, Object>();
//        DESERIALIZER.put(Date.class, new JsonDeserializer<Date>() {
//            @Override
//            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
//
//                return json == null ? null : new Date(json.getAsLong());
//            }
//        });
//        DESERIALIZER.put(PagedList.class, new JsonDeserializer<PagedList>() {
//            @Override
//            public PagedList deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
//                PagedList rel = null;
//                if (json != null) {
//                    rel = new PagedList();
//                    JsonObject pagedObj = json.getAsJsonObject();
//
//                    if (pagedObj.get("totalSize") != null) {
//                        rel.setTotalSize(pagedObj.get("totalSize").getAsLong());
//                    }
//                    if (pagedObj.get("pageSize") != null) {
//                        rel.setPageSize(pagedObj.get("pageSize").getAsInt());
//                    }
//                    if (pagedObj.get("pageIndex") != null) {
//                        rel.setPageIndex(pagedObj.get("pageIndex").getAsInt());
//                    }
//                    JsonElement classObject = pagedObj.get("itemClass");
//                    JsonElement items = pagedObj.get("items");
//                    if (items != null && items.isJsonArray()) {
//                        try {
//                            Class<?> objClass = Class.forName(classObject.getAsString());
//
//                            JsonArray arr = pagedObj.get("items").getAsJsonArray();
//
//                            Iterator<JsonElement> iterators = arr.iterator();
//                            while (iterators.hasNext()) {
//                                JsonElement ele = iterators.next();
//                                rel.add(JsonUtils.fromJson(ele.getAsString(), objClass));
//                            }
//                        } catch (ClassNotFoundException e) {
//                            // TODO Auto-generated catch block
//                            e.printStackTrace();
//                        }
//                    }
//                }
//                return rel;
//            }
//        });
//
//        SERIALIZER = new HashMap<Class<?>, Object>();
//        SERIALIZER.put(Date.class, new JsonSerializer<Date>() {
//            @Override
//            public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
//                return src == null ? null : new JsonPrimitive(src.getTime());
//            }
//        });
//        SERIALIZER.put(PagedList.class, new JsonSerializer<PagedList>() {
//            @Override
//            public JsonElement serialize(PagedList src, Type typeOfSrc, JsonSerializationContext context) {
//                JsonObject rel = null;
//                if (src != null) {
//                    rel = new JsonObject();
//                    if (src.getTotalSize() != null) {
//                        rel.add("totalSize", new JsonPrimitive(src.getTotalSize()));
//                    }
//                    if (src.getPageIndex() != null) {
//                        rel.add("pageIndex", new JsonPrimitive(src.getPageIndex()));
//                    }
//                    if (src.getPageSize() != null) {
//                        rel.add("pageSize", new JsonPrimitive(src.getPageSize()));
//                    }
//                    JsonArray arr = null;
//                    if (src.size() != 0) {
//                        Gson g = new Gson();
//
//                        arr = new JsonArray();
//                        rel.add("itemClass", new JsonPrimitive(src.get(0).getClass().getName()));
//
//                        for (Object obj : src) {
//                            String eleStr = JsonUtils.toJson(obj);
//                            arr.add(new JsonPrimitive(eleStr));
//                        }
//                    }
//                    rel.add("items", arr);
//                }
//                return rel;
//            }
//        });
//    }


    public static <T> T fromJson(String json, Class<T> classOfT) {
        return fromJson(json, classOfT, DESERIALIZER);
    }

    public static <T> T fromJson(String json, Class<T> classOfT, Map<Class<?>, Object> adapters) {
        Gson gson = getGson(adapters);
        return gson.fromJson(json, classOfT);
    }

    public static String toJson(Object jsonElement) {
        return toJson(jsonElement, SERIALIZER);
    }

    public static String toJson(Object jsonElement, Map<Class<?>, Object> adapters) {
        Gson gson = getGson(adapters);
        return gson.toJson(jsonElement);
    }

    public static Gson getGson(Map<Class<?>, Object> adapters) {
        Gson gson = null;
        if (adapters != null) {
            GsonBuilder gsonBuilder = new GsonBuilder();
            for (Map.Entry<Class<?>, Object> entry : adapters.entrySet()) {
                gsonBuilder.registerTypeAdapter(entry.getKey(), entry.getValue());
            }
            gson = gsonBuilder.create();
        } else {
        	// gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
            gson = new Gson();
        }
        return gson;
    }


    public static interface A {
        String getA();
    }

//    public static class JsonTestVO {
//        private String test;
//
//        /**
//         * @return the test
//         */
//        public String getTest() {
//            return test;
//        }
//
//        /**
//         * @param test
//         *            the test to set
//         */
//        public void setTest(String test) {
//            this.test = test;
//        }
//
//    }
//
//    public static class D extends B<JsonTestVO> {
//
//    }

//    public static class B<T> implements A {
//        private Date date;
//        private String a;
//        private String b;
//        private PagedList<T> items;
//
//        /**
//         * @return the items
//         */
//        public PagedList<T> getItems() {
//            return items;
//        }
//
//        /**
//         * @param items
//         *            the items to set
//         */
//        public void setItems(PagedList<T> items) {
//            this.items = items;
//        }
//
//        @Override
//        public String getA() {
//
//            return a;
//        }
//
//        /**
//         * @return the date
//         */
//        public Date getDate() {
//            return date;
//        }
//
//        /**
//         * @param date
//         *            the date to set
//         */
//        public void setDate(Date date) {
//            this.date = date;
//        }
//
//        /**
//         * @return the b
//         */
//        public String getB() {
//            return b;
//        }
//
//        /**
//         * @param b
//         *            the b to set
//         */
//        public void setB(String b) {
//            this.b = b;
//        }
//
//        /**
//         * @param a
//         *            the a to set
//         */
//        public void setA(String a) {
//            this.a = a;
//        }
//
//    }
}
