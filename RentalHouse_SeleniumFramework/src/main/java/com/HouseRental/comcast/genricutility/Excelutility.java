package com.HouseRental.comcast.genricutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelutility {
	public String getExcelSheet(String sheetName,int rowNum,int cellCount) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(IConstants.ExcelPath);
		Workbook workbook = WorkbookFactory.create(fis);
		String data = workbook.getSheet(sheetName).getRow(rowNum).getCell(cellCount).getStringCellValue();
		return data;
		
	}
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(IConstants.ExcelPath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sh = workbook.getSheet(sheetName);
		workbook.close();
		return sh.getLastRowNum();
	}
	public void setDataExcell(String sheetName,int rowNum,int cellNum,String Data) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(IConstants.ExcelPath);
		Workbook workbook = WorkbookFactory.create(fis);
		
		Sheet sheet = workbook.getSheet(sheetName);
		Row R = sheet.getRow(rowNum);
		Cell C = R.getCell(cellNum);
		Cell creat = R.createCell(rowNum);
		 C.setCellValue(Data);
		 FileOutputStream FI=new FileOutputStream(IConstants.ExcelPath);
		 workbook.write(FI);
		 workbook.close();
	}
}
