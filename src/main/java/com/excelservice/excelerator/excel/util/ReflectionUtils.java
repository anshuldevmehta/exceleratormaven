/*
 * code  
 */
package com.excelservice.excelerator.excel.util;

import com.excelservice.excelerator.excel.annotation.Column;
import com.excelservice.excelerator.excel.annotation.Default;
import com.excelservice.excelerator.excel.converter.TypeConverter;
import com.excelservice.excelerator.excel.converter.TypeConverters;
import io.micrometer.common.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

import static com.excelservice.excelerator.excel.util.CollectionUtils.isEmpty;

/**
 * @author Anshul D Mehta
 * @author Anshul D Mehta
 */
public class ReflectionUtils {

	private static final Logger LOG = LoggerFactory.getLogger(ReflectionUtils.class);

	private static String toUpperCaseFirstCharacter(String str) {
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	public static void setValueOnField(Object instance, Field field, Object value) throws Exception {
		Class<?> clazz = instance.getClass();
		String setMethodName = "set" + toUpperCaseFirstCharacter(field.getName());

		for (Map.Entry<Class, TypeConverter> entry : TypeConverters.getConverter().entrySet()) {
			if (field.getType().equals(entry.getKey())) {
				Method method = clazz.getDeclaredMethod(setMethodName, entry.getKey());
				Column column = field.getAnnotation(Column.class);
				method.invoke(instance, entry.getValue().convert(value, column == null ? null : column.pattern()));

				if (field.isAnnotationPresent(Default.class) && null==value)
				{
					Default defaultValue=field.getAnnotation(Default.class);
					method.invoke(instance, entry.getValue().convert(defaultValue.defaultValue()));
				}
			}
		}
	}

	public static void eachFields(Class<?> clazz, EachFieldCallback callback) throws Throwable {
		Field[] fields = clazz.getDeclaredFields();
		if (!isEmpty(fields)) {
			for (Field field : fields) {
				if (field.isAnnotationPresent(Column.class)) {
					if (!field.getAnnotation(Column.class).name().isEmpty()) {
						callback.each(field, field.getAnnotation(Column.class).name(), null);
					} else {
						callback.each(field, null, field.getAnnotation(Column.class).index());
					}
				} else {
					callback.each(field, field.getName(), null);
				}

			}
		}
	}

	public static Field mapNameToField(Class<?> clazz, String name) throws Throwable {
		Field[] fields = clazz.getDeclaredFields();
		if (!isEmpty(fields)) {
			for (Field field : fields) {
				if (field.getName().equals(name)) {
					return field;
				}
			}
		}
		throw new Exception("Error -- " + name + " Property of Class is not Found...");
	}
}
