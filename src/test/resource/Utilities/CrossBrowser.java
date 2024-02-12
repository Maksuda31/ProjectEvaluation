package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CrossBrowser {

WebDriver driver;//global declaration of the driver

//this the path of the properties of file...this comes from properties of config.propertiesS
String FilePath="C:\\Users\\narsi\\eclipse-workspace\\ProjectEvaluation\\Config.properties";

public WebDriver browser_initiate() throws IOException {
	
	//Step1-method
	FileInputStream fis= new FileInputStream(FilePath);
	
	//Step2-method
	Properties P= new Properties();
	
	//Step 3-method
	P.load(fis);
	String browsername=P.getProperty("browser");



switch(browsername)
{
case "Chrome":

	driver=new ChromeDriver();
	driver.get(P.getProperty("url"));
	break;

case "Edge":

	driver=new EdgeDriver();
	driver.get(P.getProperty("url"));
	break;	
	
case "Firefox":

	driver=new FirefoxDriver();
	driver.get(P.getProperty("url"));
	break;	

}
return driver;
}
}

