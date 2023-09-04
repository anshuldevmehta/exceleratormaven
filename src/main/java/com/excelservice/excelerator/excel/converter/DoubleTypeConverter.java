/*
 * code  
 */
package com.excelservice.excelerator.excel.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * @author Anshul D Mehta
 */
public class DoubleTypeConverter implements TypeConverter<Double> {

    private static final Logger LOG = LoggerFactory.getLogger(DoubleTypeConverter.class);
    
    @Override
    public Double convert(Object value, String... pattern) {
        if (value == null) {
            return null;
        }

        if (value instanceof Double) {
            return (Double) value;
        }

        if (value instanceof String) {
            //try {
                return Double.valueOf(((String) value).trim());
            //} catch (Exception ex) {
            //   LOG.warn(null, ex);
            //    return null;
            //}
        }

        if (value instanceof BigDecimal) {
            return ((BigDecimal) value).doubleValue();
        }

        return null;
    }

}
