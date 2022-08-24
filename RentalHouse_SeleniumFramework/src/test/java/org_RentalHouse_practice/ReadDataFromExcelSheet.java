package org_RentalHouse_practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelSheet {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//step1 read the file using file inputstream
		
FileInputStream fis=new FileInputStream(".\\Data\\Test_case_template.xlsx");
//step2 creat workbook
Workbook workbook = WorkbookFactory.create(fis);
//step3 load sheet
Sheet sh = workbook.getSheet("owner module_test case");
//step4 navigate to row
Row r = sh.getRow(1);
//step5 navigate to cell
Cell c = r.getCell(7);
//step6 read the value inside the cell
System.out.println(c.getStringCellValue());
	}

}
