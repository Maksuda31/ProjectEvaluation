package PG.ProjectEvaluation;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import ObjectRepository.Home;
import ObjectRepository.HomePage;
import ObjectRepository.LogIn;
import ObjectRepository.Registration;
import Utilities.CrossBrowser;
import Utilities.ExcelData;

public class AppTest 
{
	WebDriver driver;//
	String []data= new String[3];// for excel data
	

    @Test
    public void Application() throws IOException
    {
    	    	
    	//for reporting //using ExtentReports
    	ExtentReports report= new ExtentReports();
    	
    	ExtentSparkReporter sparkreport= new ExtentSparkReporter("C:\\Users\\narsi\\eclipse-workspace\\ProjectEvaluation\\target\\Report\\report.html");
    	ExtentTest test=report.createTest("Registration");
    	
    	
    	report.attachReporter(sparkreport);//for report generation
    	test.log(Status.PASS, "successful");
    	report.flush();
    	
    	
        
        CrossBrowser br= new CrossBrowser();
        driver=br.browser_initiate();
        Home h=new Home(driver);
        h.signin();
      
    }

    	   	
        @Test(dataProvider="dp")
        
        public void application (String FName, String LName, String AEmail, String AcPhone, String Address1, String Address2, 
        		String CityName, String StateName, String ZipNumber, String CountryName) throws IOException
        {
        //we need to create an object to access different page
        	
  
        	//home page
        	HomePage hp= new HomePage(driver);
        	hp.signin();
        	//Login page
        	LogIn l= new LogIn(driver);
        	l.register();
        	
        	
        	//At registration page from excel sheet
        	        	
        	ExcelData d = new ExcelData(driver);
            data = d.readExcel();
            String ID = data[0];
            String password= data[1];
            String RepeatPassW = data[2];
            
                   	
        	Registration R= new Registration(driver);
        	
        	R.UserInfo(ID, password, RepeatPassW);
        	
        	R.SetFirstName(FName);
        	R.SetLastName(LName);
        	R.SetEmail(AEmail);
        	R.SetPhone(AcPhone);
        	R.SetAdd1(Address1);
        	R.SetAdd2(Address2);
        	R.SetCity(CityName);
        	R.SetState(StateName);
        	R.SetZip(ZipNumber);
        	R.SetCountry(CountryName);
        	
        	R.MyList();//MyPro
        	R.MyBanner();//MyPro
        	
        	R.SetProfile();
        	
        	R.Save();//save account information    
        	
    	
        	TakesScreenshot ts=(TakesScreenshot)driver;
        	File file=ts.getScreenshotAs(OutputType.FILE);
        	FileUtils.copyFile(file, new File("C:\\Users\\narsi\\eclipse-workspace\\ProjectEvaluation\\screenshots\\ss.png"));
        
        	 
        	
        }
        
       @DataProvider(name = "dp")
       public static Object[][] userData() {
        
       Object[][] data= {{"Max", "Roy", "MR@example.com", "111-2222-333","111 ABC", "Apt A", "Charlotte", "NC","12345", "USA" }}; 
             
             return data;
       }
            
    }
       
    
