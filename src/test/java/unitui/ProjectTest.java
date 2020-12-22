package unitui;

import core.selenium.WebDriverManager;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
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
    private String email = Environment.getInstance().getEmail();
    private String password = Environment.getInstance().getPassword();
    private String name = "test";
    private String account = "";

    /**
     * Sets up.
     */
    @BeforeTest
    public void setUp() {
        WebDriverManager.getInstance();
        webDriverManager.getWebDriver().get(Environment.getInstance().getBaseUrl());
        initialPage = new InitialPage();
        loginPage = initialPage.login();
        LoginPage2 loginPage2 = loginPage.login(email);
        homePage = loginPage2.login(password);
    }

    /**
     * Tear down.
     */
    @AfterTest
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
