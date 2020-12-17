package pivotal;

import core.selenium.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pivotal.config.Environment;
import pivotal.ui.HomePage;
import pivotal.ui.InitialPage;
import pivotal.ui.LoginPage;
import pivotal.ui.LoginPage2;
import pivotal.ui.ProjectPage;
import pivotal.ui.ProjectPage2;

public class ProjectTest {
    private InitialPage initialPage;
    private LoginPage loginPage;
    private HomePage homePage;
    private WebDriverManager webDriverManager;
    private ProjectPage projectPage;
    private ProjectPage2 projectPage2;
    String email = Environment.getInstance().getEmail();
    String password = Environment.getInstance().getPassword();
    String name = "test";
    String account = "";

    @Before
    public void setUp() {
        webDriverManager = new WebDriverManager();
        webDriverManager.getWebDriver().get(Environment.getInstance().getBaseUrl());
        initialPage = new InitialPage(webDriverManager.getWebDriver(), webDriverManager.getDriverWait());
        loginPage = initialPage.login();
        LoginPage2 loginPage2 = loginPage.login(email);
        homePage = loginPage2.login(password);
    }
    @After
    public void tearDown() {
        webDriverManager.getWebDriver().quit();
    }

    /**
     * Tests login to pivotal.
     */
    @Test
    public void createProject() {
        projectPage = homePage.createProject();
        projectPage2 = projectPage.createProject(name, account);
    }
}
