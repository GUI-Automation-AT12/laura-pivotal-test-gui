package unitui;

import core.selenium.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pivotal.config.Environment;
import pivotal.ui.pages.HomePage;
import pivotal.ui.pages.InitialPage;
import pivotal.ui.pages.LoginPage;
import pivotal.ui.pages.LoginPage2;

public class LoginTest {
    private InitialPage initialPage;
    private LoginPage loginPage;
    private HomePage homePage;
    private String email = Environment.getInstance().getProperties().get("email");
    private String password = Environment.getInstance().getProperties().get("password");

    /**
     * Tear down.
     */
    @AfterTest
    public void tearDown() {
        WebDriverManager.quit();
    }

    /**
     * Tests login to pivotal.
     */
    @Test
    public void login() {
        initialPage = new InitialPage();
        loginPage = initialPage.login();
        LoginPage2 loginPage2 = loginPage.login(email);
        homePage = loginPage2.login(password);
        WebElement actual = homePage.getProfileDropDown();
        WebElement expected = WebDriverManager.getInstance().getWebDriver().findElement(By.xpath("//button[contains(text(),'testauto2020')]"));
        Assert.assertEquals(actual, expected);
    }
}
