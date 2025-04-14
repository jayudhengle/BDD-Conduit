package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductListPage 
{
	
	@FindBy(id= "add-to-cart-sauce-labs-backpack")
	WebElement itemOne;
	
	@FindBy(id= "add-to-cart-sauce-labs-bike-light")
	WebElement itemTwo;
	
	@FindBy(className = "shopping_cart_badge")
	WebElement cardtLnk;
	
	public ProductListPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void addToCart()
	{
		itemOne.click();
		itemTwo.click();
	}
	
	public void viewCart()
	{
		cardtLnk.click();
	}


	
	
}
