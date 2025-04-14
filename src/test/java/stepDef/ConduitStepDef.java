package stepDef;

import base.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.EditArticlePage;
import pages.LoginPage;
import pages.NewArticleTest;
import pages.ProductListPage;

import java.time.Duration;

public class ConduitStepDef {

    WebDriver driver = TestBase.getDriver();
    LoginPage loginPage;
	NewArticleTest newArticle;
	WebDriverWait wait;
	EditArticlePage editArticle;

	public ConduitStepDef() {
        loginPage = new LoginPage(driver);
		newArticle = new NewArticleTest(driver);
		editArticle =new EditArticlePage(driver);
    }

    @Given("User is on login page")
    public void user_is_on_login_page() {
        TestBase.openURL("https://conduit-realworld-example-app.fly.dev/#/login");
    }

    @When("User enters {string} and {string}")
    public void user_enters_and(String string, String string2) {
        loginPage.logIntoTheApp("TestUser@gmail.com", "Test@123");
    }

    @Then("User should be on Home Page")
    public void user_should_be_on_home_page() {
        Assert.assertTrue(loginPage.isHomePage());
    }

    @When("User add new article")
    public void user_add_new_article() {
		newArticle.publishArticle("7333Test", "Test3", "Test4", "Test5");
	}

    @Then("Article must be added")
    public void article_must_be_added() {
		Assert.assertEquals(newArticle.verifyArticleHeader(), "7333Test");
	}

    @Given("User should be on Article Page")
    public void user_should_be_on_article_page() {
		Assert.assertEquals(newArticle.verifyArticleHeader(), "7331Test");
    }

	@When("User edit the article")
	public void user_edit_the_article() {
		editArticle.editArticle("7334Test", "Test41", "Test51", "Test51");
	}

	@Then("Article must be edited")
	public void article_must_be_edited() {
		Assert.assertEquals(editArticle.verifyArticleHeader(), "7334Test");
	}

    @When("User delete the article")
    public void user_delete_the_article() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Article must be deleted")
    public void article_must_be_deleted() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}


