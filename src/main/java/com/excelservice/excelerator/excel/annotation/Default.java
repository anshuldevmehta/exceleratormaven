/*
 * code  
 */
package com.excelservice.excelerator.excel.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Anshul D Mehta
 * @author Anshul D Mehta 
 * 
 *         Custom annotation to specify
 *         default value of a column
 */
@Target(ElementType.FIELD)
@Retention(RUNTIME)
public @interface Default {

	String defaultValue();

}
