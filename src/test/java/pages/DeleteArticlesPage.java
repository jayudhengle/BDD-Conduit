package pages;

import base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static base.TestBase.getDriver;


public class DeleteArticlesPage
{
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));

    @FindBy(xpath = "(//button[@class= 'btn btn-sm'])[1]")
    WebElement deleteButton;

    @FindBy(xpath = "//div[contains(text() , 'Articles')]")
    WebElement deltedMessage;

    public DeleteArticlesPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    public void  deleteArticle()
    {
        try
        {
            deleteButton.click();
            Alert alert = getDriver().switchTo().alert();
            alert.accept();
        }
        catch (Exception e)
        {
            System.out.println("No alert Found!!");
        }
    }

    public String getDeleteMessage()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text() , 'Articles')]")));
        return(deltedMessage.getText());
    }
}
