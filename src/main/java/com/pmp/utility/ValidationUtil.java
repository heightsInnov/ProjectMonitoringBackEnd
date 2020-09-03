package com.pmp.utility;

import java.util.List;
import java.util.Objects;

public class ValidationUtil {

    public static boolean checkFieldsIsNull(Object instance, List<String> fieldNames) {
        return fieldNames.stream().allMatch(field -> {
            try {
                return Objects.isNull(instance.getClass().getDeclaredField(field).get(instance));
            } catch (Exception e) {
                return true;//You can throw RuntimeException if need.
            }
        });
    }
}
