/*
 * code  
 */
package com.excelservice.excelerator.excel.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Anshul D Mehta
 */
public class DateTypeConverter implements TypeConverter<Date> {

    private static final Logger LOG = LoggerFactory.getLogger(DateTypeConverter.class);

    @Override
    public Date convert(Object value, String... pattern) {
        if (value == null) {
            return null;
        }

        Calendar calendar = Calendar.getInstance();
        if (value instanceof Timestamp) {
            calendar.setTimeInMillis(((Timestamp) value).getTime());
        } else if (value instanceof Date) {
            calendar.setTimeInMillis(((Date) value).getTime());
        } else if (value instanceof String) {
            try {
                return new SimpleDateFormat(pattern[0]).parse((String) value);
            } catch (Exception ex1) {
                return null;
            }
        } else {
            return null;
        }

        return calendar.getTime();
    }

}
