/*
 * code  
 */
package com.excelservice.excelerator.excel.util;

import org.apache.poi.ss.usermodel.Workbook;

/**
 * @author Anshul D Mehta
 */
public interface WorkbookCallback {

	void getWorkbook(Workbook workbook) throws Throwable;
}
