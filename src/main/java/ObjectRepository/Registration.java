package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


		
		public class Registration {
			WebDriver driver;  
		
		//location of elements with name
		@FindBy(name="username")//excel input
		WebElement ID; 
		
		@FindBy(xpath="//input[@name='password']")//excel input
		WebElement password;
		
		@FindBy(xpath="//input[@name='repeatedPassword']")//excel input
		WebElement RepeatPassW;
		
		//data provider
		@FindBy(xpath="//input[@name='account.firstName']")
		WebElement FirstName;
		
		@FindBy(xpath="//input[@name='account.lastName']")
		WebElement LastName;
		
		@FindBy(xpath="//input[@name='account.email']")
		WebElement Email;
		
		@FindBy(xpath="//input[@name='account.phone']")
		WebElement Phone;
		
		@FindBy(xpath="//input[@name='account.address1']")
		WebElement Add1;
		
		@FindBy(xpath="//input[@name='account.address2']")
		WebElement Add2;
		
		@FindBy(xpath="//input[@name='account.city']")
		WebElement City;
		
		@FindBy(xpath="//input[@name='account.state']")
		WebElement State;
		
		@FindBy(xpath="//input[@name='account.zip']")
		WebElement Zip;
		
		@FindBy(xpath="//input[@name='account.country']")
		WebElement Country;
		
		@FindBy(xpath="//input[@name='newAccount']")
		WebElement Profile;
		
		//Profile Information
		@FindBy(name="account.listOption")
		WebElement MyList;
		
		@FindBy(name="account.bannerOption")
		WebElement MyBanner;
		
		
		@FindBy(name="newAccount")
		WebElement Save;
		
		//constructor and connector
		public Registration (WebDriver driver) 
        {
	    this.driver=driver;
		PageFactory.initElements(driver, this);
		}
		
		//ActionMethod
		
		public void UserInfo(String u1, String p1, String p2) {
	        
			ID.sendKeys(u1);
	        password.sendKeys(p1);
	        RepeatPassW.sendKeys(p2);
	    }
		
		
		public void SetFirstName(String FName) 
		{
			FirstName.sendKeys(FName);
		}
		public void SetLastName(String LName) 
		{
			LastName.sendKeys(LName);
		}
		
		public void SetEmail(String AEmail) 
		{
			Email.sendKeys(AEmail);
		}
		public void SetPhone(String AcPhone) //should be int
		{
			Phone.sendKeys(AcPhone);
		}
		
		public void SetAdd1(String Address1) 
		{
			Add1.sendKeys(Address1);
		}
		
		public void SetAdd2(String Address2) 
		{
			Add2.sendKeys(Address2);
		}
		
		public void SetCity(String CityName) 
		{
			City.sendKeys(CityName);
		}
		
		public void SetState(String StateName) 
		{
			State.sendKeys(StateName);
		}
		
		public void SetZip(String ZipNumber) ///should be int
		{
			Zip.sendKeys(ZipNumber);
		}
		
		public void SetCountry(String CountryName) 
		{
			Country.sendKeys(CountryName);
		}
		
		//ProInfo
		
		public void MyList()
		{
			MyList.click();
		}
		
		public void MyBanner() 
		{
			MyBanner.click();
		}
		
		public void SetProfile() 
		{
			Profile.click();
		}
		public void Save() 
		{
			Save.click();
		}
		
		
		}
		



