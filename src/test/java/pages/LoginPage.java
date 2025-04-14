package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	@FindBy(name="email")
	WebElement eMail;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(css =  "button.btn.btn-lg.btn-primary.pull-xs-right")
	WebElement loginBtn;

	@FindBy(xpath = "//a[text() = 'Home']")
	WebElement homePageLink;



	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void logIntoTheApp(String strEmail, String strPassword)
	{
		eMail.sendKeys(strEmail);
		password.sendKeys(strPassword);
		loginBtn.click();
	}

	public boolean isHomePage()
	{
		return (homePageLink.isDisplayed());
	}
}
