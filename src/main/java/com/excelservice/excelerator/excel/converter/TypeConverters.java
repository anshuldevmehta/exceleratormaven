/*
 * code  
 */
package com.excelservice.excelerator.excel.converter;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Anshul D Mehta
 */
public class TypeConverters {

    private static Map<Class, TypeConverter> converter;

    private static void registerConverter() {
        converter = new HashMap<>();
        converter.put(String.class, new StringTypeConverter());
        converter.put(Integer.class, new IntegerTypeConverter());
        converter.put(Double.class, new DoubleTypeConverter());
        converter.put(Boolean.class, new BooleanTypeConverter());
        converter.put(Date.class, new DateTypeConverter());
    }

    public static Map<Class, TypeConverter> getConverter() {
        if (converter == null) {
            registerConverter();
        }
        return converter;
    }
}
