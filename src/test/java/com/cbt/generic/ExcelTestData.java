package com.cbt.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelTestData 
{
	public String filepath = "D:\\New_Eclipse_Workspace\\FlyrobeWeb\\Excel\\InputData.xlsx";
	public String sheetName1 = "LoginData";
	public String sheetName2 = "Testcases";
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	int totalRow;
	int totalColumn;
	
	ArrayList<String> dataSheetList= new ArrayList<String>();
	
	
	public String[][] readTestData(String filepath) throws IOException
	{
		FileInputStream excelFile = new FileInputStream(filepath);
		workbook = new XSSFWorkbook(excelFile);
		sheet = workbook.getSheet(sheetName1);
		totalRow = sheet.getLastRowNum();
		totalColumn = sheet.getRow(0).getLastCellNum();
		
		String[][] testData = new String[totalRow-1][totalColumn];
		
		for(int i=1;i<totalRow;i++)
		{
			for(int j=0;j<totalColumn;j++)
			{
				testData[i-1][j]= sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return testData;
	}
	
	
	public void writeResultData(String result, String exception) throws IOException
	{
		sheet=workbook.getSheet(sheetName2);
		
		for(int i=1;i<totalRow;i++)
		{
			Row row = sheet.getRow(i);
			Cell status = row.createCell(4);
			status.setCellType(Cell.CELL_TYPE_STRING);
			status.setCellValue(result);
			
			Cell error = row.createCell(5);
			error.setCellType(Cell.CELL_TYPE_STRING);
			error.setCellValue(exception);
			
			FileOutputStream outputFilepath = new FileOutputStream(filepath);
			workbook.write(outputFilepath);
			outputFilepath.close();
		}
	}
	
	@DataProvider(name="testData")
	public Object[][] loginData() throws IOException 
	{
		Object[][] arrayObject = readTestData(filepath);
		return arrayObject;
	}
	

	public ArrayList<String> readDataFromExcel () throws Exception
	{
		
		FileInputStream excelFile = new FileInputStream(filepath);
		workbook = new XSSFWorkbook(excelFile);
		sheet = workbook.getSheet(sheetName1);
		
		int rowCount=sheet.getLastRowNum();
	
		for(int i=1;i<=rowCount;i++)
		{
			Row row=sheet.getRow(i);
	
			int cellCount = row.getLastCellNum();
			{
				for(int j=0;j<cellCount;j++)
				{
					dataSheetList.add(row.getCell(j).toString());
				}	
			}
		}
		return dataSheetList;
	}
	
	public static String returnValue(String cityName) throws Exception
	{
		
		FileInputStream fis =new FileInputStream("D:\\New_Eclipse_Workspace\\FlyrobeWeb\\Excel\\InputData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		int cellCount=wb.getSheet("LoginData").getRow(0).getLastCellNum();
		String cityName2=null;
		String cityName3=null;
		
		first:
		for(int i=0; i<cellCount;i++)
		{
			cityName2=wb.getSheet("LoginData").getRow(0).getCell(i).toString();
			if(cityName2.equals("cityName"))
			{
				int count=wb.getSheet("LoginData").getLastRowNum();
				for(int p=0; p<count;p++)
				{
					cityName3=wb.getSheet("LoginData").getRow(p).getCell(i).toString();
					if(cityName3.equals(cityName))
					{
						cityName=cityName3;
						System.out.println(cityName3);
						break first;
					}
				}
			}
		}
		
		return cityName;
		
		
	}
}

