package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteArticlesPage
{

    @FindBy(xpath = "(//button[@class= 'btn btn-sm'])[1]")
    WebElement deleteButton;

    public DeleteArticlesPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    public void deleteArticle() throws InterruptedException {
        deleteButton.click();
    }
}
