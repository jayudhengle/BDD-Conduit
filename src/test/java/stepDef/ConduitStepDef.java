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
import pages.*;

import java.time.Duration;

public class ConduitStepDef {

    WebDriver driver = TestBase.getDriver();
    LoginPage loginPage;
	NewArticleTest newArticle;
	WebDriverWait wait;
	EditArticlePage editArticle;
    DeleteArticlesPage deleteArticle;

	public ConduitStepDef() {
        loginPage = new LoginPage(driver);
		newArticle = new NewArticleTest(driver);
		editArticle =new EditArticlePage(driver);
        deleteArticle =new DeleteArticlesPage(driver);
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
		newArticle.publishArticle("7348Test", "Test3", "Test4", "Test5");
	}

    @Then("Article must be added")
    public void article_must_be_added() {
		Assert.assertTrue(newArticle.verifyArticleHeader());
	}

    @Given("User should be on Article Page")
    public void user_should_be_on_article_page() {
		Assert.assertTrue(newArticle.verifyArticleHeader());
    }

	@When("User edit the article")
	public void user_edit_the_article() {
		editArticle.editArticle("7345Test", "Test41", "Test51", "Test51");
	}

	@Then("Article must be edited")
	public void article_must_be_edited() {
        Assert.assertTrue(editArticle.verifyArticleHeader());
    }

    @When("User delete the article")
    public void user_delete_the_article() throws InterruptedException {
        deleteArticle.deleteArticle();
    }

    @Then("Article must be deleted")
    public void article_must_be_deleted() {
        Assert.assertEquals(deleteArticle.getDeleteMessage(), "Articles not available.");
    }
}


