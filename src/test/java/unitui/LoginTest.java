package unitui;

import core.selenium.WebDriverManager;
import core.utils.JsonDataReader;
import core.utils.WebElementInteractor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.openqa.selenium.By;
import pivotal.ui.bares.TopNavigationBar;
import pivotal.ui.pages.HomePage;
import pivotal.ui.pages.InitialPage;
import pivotal.ui.pages.LoginPage;
import pivotal.ui.pages.LoginPage2;

public class LoginTest {

    private static final String EDITABLE_USER = "Editable User";
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
        JsonDataReader jsonDataReader = new JsonDataReader("users.json");
        String email = jsonDataReader.getValueData(EDITABLE_USER, "email");
        String password = jsonDataReader.getValueData(EDITABLE_USER, "password");
        InitialPage initialPage = new InitialPage();
        LoginPage loginPage = initialPage.login();
        LoginPage2 loginPage2 = loginPage.login(email);
        HomePage homePage = loginPage2.login(password);
        TopNavigationBar topNavigationBar = new TopNavigationBar();
        String actual = topNavigationBar.getTextFromUserMenu();
        WebDriver webDriver = WebDriverManager.getInstance().getWebDriver();
        String expected = WebElementInteractor.getTxt(webDriver.findElement(By.xpath("//button[contains(text(),'testauto2020')]")));
        Assert.assertEquals(actual, expected);
    }
}
