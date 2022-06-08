package org.expert;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Json utils
 */
public class JsonUtil {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static <T> void registerModule(Class<T> clazz) {
        SimpleModule module = new SimpleModule();
        module.addSerializer(clazz, new JsonSerializer<T>() {
            @Override
            public void serialize(T arg0, JsonGenerator jgen,
                                  SerializerProvider arg2) throws IOException {
                jgen.writeString(clazz.getCanonicalName());
            }
        });
        OBJECT_MAPPER.registerModule(module);
    }

    public static <T> T readValue(String jsonStr, Class<T> clazz) throws IOException {
        return OBJECT_MAPPER.readValue(jsonStr, clazz);
    }

    public static <T> T readValue(String jsonStr, JavaType javaType) throws IOException {
        return OBJECT_MAPPER.readValue(jsonStr, javaType);
    }

    public static <T> T fromJson(String jsonStr, Class<T> clazz) {
        try {
            return OBJECT_MAPPER.readValue(jsonStr, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T fromJson(String jsonStr, JavaType javaType) {
        try {
            return OBJECT_MAPPER.readValue(jsonStr, javaType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String toJson(Object obj) {
        try {
            return OBJECT_MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static String writeJsonStr(Object obj) throws JsonProcessingException {
        return OBJECT_MAPPER.writeValueAsString(obj);
    }

    public static String writePrettyJsonStr(Object obj) throws JsonProcessingException {
        return OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
    }

    public static void writeJsonStream(OutputStream out, Object obj) throws IOException {
        OBJECT_MAPPER.writeValue(out, obj);
    }

    public static <T> List<T> readListValue(String jsonStr, Class<T> clazz) throws IOException {
        JavaType javaType = OBJECT_MAPPER.getTypeFactory().constructParametricType(List.class, clazz);
        return OBJECT_MAPPER.readValue(jsonStr, javaType);
    }

    public static <T> List<T> fromListValue(String jsonStr, Class<T> clazz) {
        try {
            JavaType javaType = OBJECT_MAPPER.getTypeFactory().constructParametricType(List.class, clazz);
            return OBJECT_MAPPER.readValue(jsonStr, javaType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <K, V> Map<K, V> readMapValue(String jsonStr, Class<K> kclazz, Class<V> vclazz) throws IOException {
        JavaType javaType = OBJECT_MAPPER.getTypeFactory().constructParametricType(HashMap.class, kclazz, vclazz);
        return OBJECT_MAPPER.readValue(jsonStr, javaType);
    }

    public static ArrayNode readArray(String jsonStr) throws IOException {
        JsonNode node = OBJECT_MAPPER.readTree(jsonStr);
        if (node.isArray()) {
            return (ArrayNode) node;
        }
        return null;
    }

    public static JsonNode readNode(String jsonStr) throws IOException {
        return OBJECT_MAPPER.readTree(jsonStr);
    }

}