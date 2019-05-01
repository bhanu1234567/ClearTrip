package com.makemytrip.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReusables {
	
	String Excelpath;
	FileInputStream fip;
	Workbook workbook;
	Sheet sheet;
	
	
	public ExcelReusables(String Excelpath) throws IOException

	{
		this.Excelpath=Excelpath;
		fip = new FileInputStream(Excelpath);
		workbook=WorkbookFactory.create(fip);
	}
	
	public String getcellvalue(String sheet,int row, int cell) {
		
		 String value=null;
		
		if (workbook.getSheet(sheet).getRow(row).getCell(cell).getCellType()==workbook.getSheet(sheet).getRow(row).getCell(cell).getCellType().STRING) 
		{
			 value = workbook.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		}
		
		else if (workbook.getSheet(sheet).getRow(row).getCell(cell).getCellType()==workbook.getSheet(sheet).getRow(row).getCell(cell).getCellType().NUMERIC) {
			
			
			 value = String.valueOf((workbook.getSheet(sheet).getRow(row).getCell(cell).getNumericCellValue()));
		}
		
		return value;
	}
	/*public List getCellValues()
	{
		List list=null;
		for(i=0;i<)
		
		return list;
	}*/
	
	
}
