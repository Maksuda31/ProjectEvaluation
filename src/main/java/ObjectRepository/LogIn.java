package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogIn {
	WebDriver driver;
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="signon")
	WebElement signon;
	

	  @FindBy(xpath="//a[normalize-space()='Register Now!']")
	    WebElement register;
	
	public LogIn(WebDriver driver)//constructor
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	public void login_credentials()
	{
		username.sendKeys("j2ee");
		password.clear();
		password.sendKeys("j2ee");
		
	}

	public void register() {
	
		register.click();
		
	}
}
