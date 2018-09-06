package com.example.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * json工具类
 *
 * @author cyx
 */
public class JsonUtil {

    private static ObjectMapper om = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    /**
     * 对象转换json
     *
     * @param object 要转json的对象
     */
    public static String toJsonString(Object object) {
        try {
            return om.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * json转换成对象
     *
     * @param json  json字符串
     * @param clazz 集合中的java对象类型
     */
    public static <T> T parseObject(String json, Class<T> clazz) {
        try {
            return om.readValue(json, clazz);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * json集合字符串转换为 List<YourBean>
     *
     * @param json  json字符串
     * @param clazz 集合中的java对象类型
     */
    public static <T> List<T> parseToList(String json, Class<T> clazz) {
        try {
            return om.readValue(json, getCollectionType(List.class, clazz));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * json集合字符串转换为 Map<String,YourBean>
     *
     * @param json  json字符串
     * @param clazz 集合中的java对象类型
     */
    public static <T> Map<String, T> parseToMap(String json, Class<T> clazz) {
        try {
            return om.readValue(json, getCollectionType(Map.class, String.class, clazz));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return om.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }
}
