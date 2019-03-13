/*
 * 阔地教育科技有限公司版权所有(codyy.com/codyy.cn)
 * Copyright (c) 2017, Codyy and/or its affiliates. All rights reserved.
 */

package com.codyy.cms.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaojian on 2016/4/20.
 */
public class GsonUtils {
    public static <T> T json2Bean(String jsonString, Class<T> cls) {
        T t;
        try {
            Gson gson = new GsonBuilder().registerTypeAdapterFactory(new NullStringToEmptyAdapterFactory()).create();
//然后用上面一行写的gson来序列化和反序列化实体类type
//            gson.fromJson(json, type);
//            gson.toJson(type);
//            Gson gson = new Gson();
            t = gson.fromJson(jsonString, cls);
        } catch (Exception e) {
            e.printStackTrace();
            t = null;
        }
        return t;
    }

    public static <T> T json2Bean(String jsonString, Type type) {
        T t;
        try {
            Gson gson = new GsonBuilder().registerTypeAdapterFactory(new NullStringToEmptyAdapterFactory()).create();
//然后用上面一行写的gson来序列化和反序列化实体类type
//            gson.fromJson(json, type);
//            gson.toJson(type);
//            Gson gson = new Gson();
            t = gson.fromJson(jsonString, type);
        } catch (Exception e) {
            e.printStackTrace();
            t = null;
        }
        return t;
    }

    public static <T> T bean2Bean(Object o, Type type) {
        T t;
        try {
            String jsonString = bean2JsonStr(o);
            Gson gson = new GsonBuilder().registerTypeAdapterFactory(new NullStringToEmptyAdapterFactory()).create();
//然后用上面一行写的gson来序列化和反序列化实体类type
//            gson.fromJson(json, type);
//            gson.toJson(type);
//            Gson gson = new Gson();
            t = gson.fromJson(jsonString, type);
        } catch (Exception e) {
            e.printStackTrace();
            t = null;
        }
        return t;
    }

    public static <T> List<T> json2List(String jsonString) {
        List<T> list;
        try {
            Gson gson = new Gson();
            list = gson.fromJson(jsonString, new TypeToken<List<T>>() {
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
            list = new ArrayList<>();
        }
        return list == null ? new ArrayList<T>() : list;
    }

    public static <T> List<T> fromJsonList(String json, Class<T> clazz) {
        List<T> lst = new ArrayList<>();
        try {
            JsonArray array = new JsonParser().parse(json).getAsJsonArray();
            for (final JsonElement elem : array) {
                lst.add(new Gson().fromJson(elem, clazz));
            }
        } catch (Exception e) {
        }
        return lst;
    }

    public static List<Map<String, Object>> listKeyMaps(String jsonString) {
        List<Map<String, Object>> list;
        try {
            Gson gson = new Gson();
            list = gson.fromJson(jsonString,
                    new TypeToken<List<Map<String, Object>>>() {
                    }.getType());
        } catch (Exception e) {
            e.printStackTrace();
            list = new ArrayList<>();
        }
        return list;
    }


    public static Map<String, String> bean2Map(Object object) {
        String jsonStr = bean2JsonStr(object);
        return jsonStr2Map(jsonStr);
    }

    public static String bean2JsonStr(Object object) {
        String jsonStr = "";
        try {
            Gson gson = new Gson();
            jsonStr = gson.toJson(object);
        } catch (Exception e) {
            e.printStackTrace();
            jsonStr = "";
        }

        return jsonStr;
    }

    public static Map<String, String> jsonStr2Map(String jsonStr) {
        Map<String, String> map = null;
        try {
            Gson gson = new Gson();
            map = gson.fromJson(jsonStr, Map.class);
        } catch (Exception e) {
            e.printStackTrace();
            map = null;
        }
        return map;
    }

    public static String list2JsonStr(List list) {
        String jsonStr = "";
        try {
            Gson gson = new Gson();
            jsonStr = gson.toJson(list);
        } catch (Exception e) {
            e.printStackTrace();
            jsonStr = "";
        }

        return jsonStr;
    }

    public static class NullStringToEmptyAdapterFactory<T> implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            Class<T> rawType = (Class<T>) type.getRawType();
            if (rawType != String.class) {
                return null;
            }
            return (TypeAdapter<T>) new StringNullAdapter();
        }
    }

    public static class StringNullAdapter extends TypeAdapter<String> {
        @Override
        public String read(JsonReader reader) throws IOException {
            if (reader.peek() == JsonToken.NULL) {
                reader.nextNull();
                return "";
            }
            return reader.nextString();
        }

        @Override
        public void write(JsonWriter writer, String value) throws IOException {
            if (value == null) {
                writer.nullValue();
                return;
            }
            writer.value(value);
        }
    }
}
