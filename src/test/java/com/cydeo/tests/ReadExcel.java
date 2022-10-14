package com.cydeo.tests;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;


import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcel {
    @Test
    public void read_from_excel_file() throws IOException {
        //Store the path to data in a String object
        String path = "SampleData.xlsx";

        //Load it to FileInputStream
        FileInputStream file = new FileInputStream(path);

        //workbook>sheet>row>cell

        //Create a workbook
        XSSFWorkbook workbook = new XSSFWorkbook(file);

        //Create a sheet from currently opened workbook
        XSSFSheet sheet = workbook.getSheet("Employees");

        //Select row and cell
        System.out.println(sheet.getRow(1).getCell(0));
        //This will get the second row first cell value - INDEXES START AT ZERO!

        //Returns the number of used cells only
        //starts counting from 1
        int usedRows = sheet.getPhysicalNumberOfRows();
        System.out.println(usedRows);

        //Returns the number from top cell to bottom cell
        //starts counting from 0, doesn't care about if the cell is empty or not
        int lastUsedRow = sheet.getLastRowNum();
        System.out.println(lastUsedRow);

        for (int rowNum = 0; rowNum < usedRows; rowNum++) {
            //Birinci sutunda hangi row M'ye denk geliyorsa o celli bas
            if (sheet.getRow(rowNum).getCell(0).toString().equals("M")) {
                System.out.println(sheet.getRow(rowNum).getCell(0));
            }
        }

        //Check if name is F, print out his job id
        for (int rowNum = 0; rowNum < usedRows; rowNum++) {
            if (sheet.getRow(rowNum).getCell(0).toString().equals("F")) {
                System.out.println("Job ID of " + sheet.getRow(rowNum).getCell(0) + " is " + sheet.getRow(rowNum).getCell(2));
            }
        }

    }
}
