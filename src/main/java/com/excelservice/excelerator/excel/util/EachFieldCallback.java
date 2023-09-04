/*
 * code  
 */
package com.excelservice.excelerator.excel.util;

import java.lang.reflect.Field;

/**
 * @author Anshul D Mehta
 * @author Anshul D Mehta
 */
public interface EachFieldCallback {

    void each(Field field, String name, Integer index) throws Throwable;
}
