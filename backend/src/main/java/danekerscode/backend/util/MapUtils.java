package danekerscode.backend.util;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@UtilityClass
@Slf4j
public class MapUtils {
    public static Map<String, Object> objectToMap(Object obj) {
        Map<String, Object> map = new HashMap<>();

        Class<?> objClass = obj.getClass();

        Field[] fields = objClass.getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);

                String fieldName = field.getName();
                Object fieldValue = field.get(obj);

                map.put(fieldName, fieldValue);

                field.setAccessible(false);
            } catch (IllegalAccessException e) {
                log.error("error:{}" , e.getMessage());
            }
        }

        return map;
    }
}
