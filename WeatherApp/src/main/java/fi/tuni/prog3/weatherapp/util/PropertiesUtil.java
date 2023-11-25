package fi.tuni.prog3.weatherapp.util;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@UtilityClass
public class PropertiesUtil {

    public static void populatePropertyToProperties(
            String property,
            Object value,
            Map<String, Object> properties) {
        if (value instanceof String && StringUtils.isNotEmpty(value.toString())) {
            properties.put(property, value);
        }
        if (value instanceof Collection && !CollectionUtils.isEmpty((Collection<?>) value)) {
            properties.put(property, value);
        }
    }

    public static Map<String, Object> mergeProperties(Map<String, Object> entity, Map<String, Object> request) {
        return Stream.of(entity, request)
                .flatMap(m -> m.entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue, (e, r) -> r));
    }
}
