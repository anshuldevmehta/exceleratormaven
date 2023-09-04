/*
 * code  
 */
package com.excelservice.excelerator.excel.converter;

/**
 * @author Anshul D Mehta
 */
public interface TypeConverter<T> {

    T convert(Object value, String... pattern);
}
