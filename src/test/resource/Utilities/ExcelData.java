package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ExcelData {
	WebDriver driver;
	
	String excelpath=".\\TestData\\TestData.xlsx"; //file path
	
	
	public ExcelData(WebDriver driver)//constructor
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public String[] readExcel() throws IOException {
		
		String []data= new String[3];
		
		//path of excel file
		FileInputStream fis= new FileInputStream(excelpath);
		
		//read the workbook
		XSSFWorkbook workbook= new XSSFWorkbook(fis);//object of excel file
		XSSFSheet sheet= workbook.getSheetAt(0);
		
		Row row= sheet.getRow(1);
		
		Cell cell1 = row.getCell(0);
        String ID = cell1.getStringCellValue();
        
        Cell cell2 = row.getCell(1);
        String password = cell2.getStringCellValue();
        
        Cell cell3 = row.getCell(2);
        String RepeatPassword = cell3.getStringCellValue();
        
        data[0]=ID;
        data[1]=password;
        data[2]=RepeatPassword;
		
		return data;
		
		
	}

}
