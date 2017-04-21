package com.gulj.common.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.io.IOException;
import java.util.List;
import java.util.Map;


/**
 *
 */
public class JsonUtil {

    private final static Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    private static final ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    private JsonUtil() {
    }

    public static ObjectMapper getMapper() {
        return mapper;
    }

    public static Map<String, Object> json2Map(String jsonStr) {
        Assert.hasText(jsonStr, "json字符串不能为空");
        try {
            return mapper.readValue(jsonStr, new TypeReference<Map<String, Object>>() {
            });
        } catch (IOException e) {
            logger.error("json串转map异常", e);
        }
        return null;
    }

    public static List json2List(String jsonArr) {
        try {
            return mapper.readValue(jsonArr, List.class);
        } catch (IOException e) {
            logger.error("json串转Obj异常", e);
        }
        return null;
    }

    public static <T> T json2Obj(String jsonStr, Class<T> clazz) {
        Assert.hasText(jsonStr, "json字符串不能为空");
        try {
            return mapper.readValue(jsonStr, clazz);
        } catch (IOException e) {
            logger.error("json串转Obj异常", e);
        }
        return null;
    }

    public static String map2Json(Map<String, Object> map) {
        try {
            return mapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            logger.error("map转json串异常", e);
        }
        return null;
    }

    public static String obj2Json(Object map) {
        try {
            return mapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            logger.error("map转json串异常", e);
        }
        return null;
    }
}
