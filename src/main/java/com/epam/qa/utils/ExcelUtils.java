package com.epam.qa.utils;

import com.epam.qa.constants.FrameworkConstants;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelUtils {

    private static FileInputStream fIS;
    private static XSSFWorkbook workbook;
    private static XSSFSheet sheet;

    private ExcelUtils() {

    }
    public static String getCellStringData(String sheetName, int rowNum, int column) throws Exception {
        fIS = new FileInputStream(FrameworkConstants.getExcelPath());
        workbook = new XSSFWorkbook(fIS);
        sheet = workbook.getSheet(sheetName);
        String data;

        try {
            data = sheet.getRow(rowNum).getCell(column).getStringCellValue();

        } catch (Exception e) {
            data = "";
            new Throwable("The data is coming empty for cell");
        }
        workbook.close();
        fIS.close();
        return data;

    }

    public static double getCellDataInt(int row, int cell) throws Exception {
        fIS = new FileInputStream(FrameworkConstants.getExcelPath());
        workbook = new XSSFWorkbook(fIS);
        sheet = workbook.getSheet("Sheet1");
        double data = 0;
        try {
            data = sheet.getRow(row).getCell(cell).getNumericCellValue();
        } catch (Exception e) {
            new Throwable("The data is coming empty for cell");
        }

        return data;
    }

}
