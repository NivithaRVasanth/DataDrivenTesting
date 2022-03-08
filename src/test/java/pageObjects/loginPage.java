package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

//webdriver,constructor with pagefactory ,webelements, action methods

public class loginPage {
	
	WebDriver ldriver;
	
	public loginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
		
	}


     @FindBy(how=How.ID,using = "email")
     WebElement email;
     @FindBy(how=How.ID_OR_NAME,using="passwd")
     WebElement password;
     @FindBy(how=How.ID,using="SubmitLogin") 
     WebElement submit;
     
     public void login(String emailID,String pass)
     {
    	 email.sendKeys(emailID);
    	 password.sendKeys(pass);
    	 submit.click();
     }
}
