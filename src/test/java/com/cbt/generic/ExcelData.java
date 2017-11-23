package com.cbt.generic;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelData 
{
	public static String filepath = "D:\\New_Eclipse_Workspace\\FlyrobeWeb\\Excel\\InputData.xlsx";
	public static String sheetName1="LoginData";
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;

	public static String readDataFromExcel(String columnName, String rowName) throws IOException
	{
		FileInputStream excelFile = new FileInputStream(filepath);
		workbook=new XSSFWorkbook(excelFile);
		sheet=workbook.getSheet(sheetName1);
		int totalRow = sheet.getLastRowNum();
		int totalColumn = sheet.getRow(0).getLastCellNum();
		
		 String rowData= null;
		
		for(int i=0;i<totalColumn;i++)
		{
			String columnName1 = sheet.getRow(0).getCell(i).toString();
			
			if(columnName1.equalsIgnoreCase(columnName))
			{
				for(int j=1;j<totalRow;j++)
				{
					String rowName1 = sheet.getRow(j).getCell(i).toString();
					 if(rowName1.equals(rowName))
					 {
						 rowData=rowName1;
						 System.out.println(rowData);
					 }
				}
			}
		}
		return rowData;	
	}
}
	

