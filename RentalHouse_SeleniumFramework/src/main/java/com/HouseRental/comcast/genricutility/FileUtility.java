package com.HouseRental.comcast.genricutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {

	public String getPropertykeyValue(String key) throws IOException {
		FileInputStream fis=new FileInputStream(IConstants.PropertyFilePath);
		Properties pro=new Properties();
		pro.load(fis);
	String value = pro.getProperty(key);
	return value;
		}

}
