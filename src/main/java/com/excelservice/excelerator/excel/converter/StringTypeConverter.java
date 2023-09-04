/*
 * code  
 */
package com.excelservice.excelerator.excel.converter;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.poi.util.StringUtil;

/**
 * @author Anshul D Mehta
 */
public class StringTypeConverter implements TypeConverter<String> {

    @Override
    public String convert(Object value, String... pattern) {
        if (value instanceof String) {
            if(!StringUtil.isBlank((String) value))
            return ((String) value).trim();
        }
        
        return null;
    }

}
