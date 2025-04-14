package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static base.TestBase.getDriver;

public class NewArticleTest
{
	WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));


	@FindBy(linkText = "New Article")
	WebElement newArticleLnk;
	
	@FindBy(name = "title")
	WebElement articleTitle;
	
	@FindBy(xpath =  "//input[@name = 'description']")
	WebElement articleDesc;
	
	@FindBy(name = "body")
	WebElement articleBody;
	
	@FindBy(name = "tags")
	WebElement articleTags;
	
	@FindBy(css = "button.btn.btn-lg.pull-xs-right.btn-primary")
	WebElement publishArticleBtn;

	@FindBy(xpath = "//div[@class='container']/h1")
	WebElement articleHeading;



	public NewArticleTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void publishArticle(String titleTxt, String descriptionTxt, String bodyTxt, String tagsText)
	{
		newArticleLnk.click();
		articleTitle.sendKeys(titleTxt);
		articleDesc.sendKeys(descriptionTxt);
		articleBody.sendKeys(bodyTxt);
		articleTags.sendKeys(tagsText);
		publishArticleBtn.click();
	}

	public boolean verifyArticleHeader()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='container']/h1")));
		return(articleHeading.isDisplayed());
	}
}
