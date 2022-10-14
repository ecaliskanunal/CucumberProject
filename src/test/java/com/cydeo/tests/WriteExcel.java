package com.cydeo.tests;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.awt.image.ImagingOpException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {
    String filePath = "SampleData.xlsx";
    XSSFWorkbook workbook;
    XSSFSheet sheet;

    @Test
    public void excel_write() throws IOException{
        FileInputStream file = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(file);
        sheet= workbook.getSheet("Employees");

        //Create the cells and write the values in them
        XSSFCell salaryCell = sheet.getRow(0).createCell(3);
        salaryCell.setCellValue("Salary");

        XSSFCell salaryCell1 = sheet.getRow(1).createCell(3);
        salaryCell.setCellValue(150000);

        XSSFCell salaryCell2 = sheet.getRow(2).createCell(3);
        salaryCell.setCellValue(200000);

        XSSFCell salaryCell3 = sheet.getRow(3).createCell(3);
        salaryCell.setCellValue(500000);

        //Change the surname U to Unal
        for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
            if(sheet.getRow(rowNum).getCell(1).toString().equals("U")){
                sheet.getRow(rowNum).getCell(1).setCellValue("Unal");
            }
        }

        // FileInputStream reads, FileOutputStream writes/saves the changes
        //Save the changes
        FileOutputStream output = new FileOutputStream(filePath);

        //save/write changes to the workbook
        workbook.write(output);

        //close all
        output.close();
        workbook.close();
        file.close();
    }
}
