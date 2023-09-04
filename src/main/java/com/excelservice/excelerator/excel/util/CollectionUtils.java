/*
 * code  
 */
package com.excelservice.excelerator.excel.util;

import java.util.Collection;

/**
 * @author Anshul D Mehta
 */
public class CollectionUtils {

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isEmpty(Object[] object) {
        return object == null || object.length < 1;
    }
}
