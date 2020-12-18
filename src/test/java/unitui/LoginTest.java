package unitui;

import core.selenium.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pivotal.config.Environment;
import pivotal.ui.HomePage;
import pivotal.ui.InitialPage;
import pivotal.ui.LoginPage;
import pivotal.ui.LoginPage2;

public class LoginTest {
    private InitialPage initialPage;
    private LoginPage loginPage;
    private HomePage homePage;
    private String email = Environment.getInstance().getEmail();
    private String password = Environment.getInstance().getPassword();

    /**
     * Sets up.
     */
    @BeforeTest
    public void setUp() {
        WebDriverManager.getInstance().getWebDriver().get(Environment.getInstance().getBaseUrl());
    }

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
        WebElement expected = WebDriverManager.getInstance().getWebDriver().findElement(By.xpath("//button[contains(text(),'testauto20202')]"));
        Assert.assertEquals(actual, expected);
    }
}
